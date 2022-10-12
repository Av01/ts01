package tsp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Parser {
    String typeField = "TYPE";
    String dimensionField = "DIMENSION";
    boolean isASymmetric; 
    String type = "UNK";
    int dimensions = 0;
    List<List<Double>> data = new ArrayList<>();
    
    public List<List<Double>> getData() {
        return data;
    }

    public boolean parse(File file) {
        ArrayList<String> text = new ArrayList<>();
        boolean isParsed = false;
        try {
            try (Scanner scanner = new Scanner(file, "UTF-8" )) {
                while(scanner.hasNext()) {
                    String str = scanner.nextLine();
                    text.add(str);
                    if(str.contains(":")) {
                        String[] parts = str.split(":");
                        if(typeField.equals(parts[0].strip())) {
                            type = parts[1].strip();
                            if("ATSP".equals(type)) {
                                isASymmetric = true;
                            }
                        } else if (dimensionField.equals(parts[0].strip())) {
                            dimensions = Integer.parseInt(parts[1].strip());
                        }
                    }
                }
            }
            if(!"UNK".equals(type) && dimensions > 0) {
                String string_data = "";
                for (String string : text) {
                    if(Pattern.matches("(((\\-)?([0-9])+(\\.)?([0-9])*)|( )|(\t))+", string)) {
                        string_data+= string + " "; //added space as delimeter
                    }
                }
                isParsed = update_and_validate_data(string_data);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find the file. Error : " + e.getMessage());
        }
        return isParsed;
        
    }

    private boolean update_and_validate_data(String string_data) {
        String[] parts = string_data.strip().split("( )+");
        if(type.equals("TSP") && parts.length == 3 * dimensions) {
            for (int i = 0; i < parts.length; i+=3) {
                data.add(Arrays.asList(new Double[]{Double.parseDouble(parts[i+1]),Double.parseDouble(parts[i+2])}));
            }
            return true;
        } else if (type.equals("ATSP") && parts.length == dimensions * dimensions) {
            for (int i = 0; i < dimensions; i++) {
                List<Double> row = new ArrayList<>();
                for(int j = 0; j < dimensions; j++) {
                    row.add(Double.parseDouble(parts[i*dimensions+j]));
                }
                data.add(row);
            }
            return true;
        } else {
            return false;
        }
    }
    
}
