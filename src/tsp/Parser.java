package tsp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import data.Coordinate;


/**
 * Parser to parse a File in TSPLIB format
 * @author Aakash Vora
 */
public class Parser {


    private String typeField = "TYPE";
    private String dimensionField = "DIMENSION";
    private boolean isASymmetric; 
    private String type = "UNK";
    private int dimensions = 0;
    private List<Coordinate> coordinates = new ArrayList<>();
    private double [][] distanceMatrix;


    /**
     * Parses the file
     * @param file File to be parsed
     * @return Boolean representing success or failure
     */
    public boolean parse(File file) {
        ArrayList<String> text = new ArrayList<>();
        boolean isParsed = false;
        try {
            try (Scanner scanner = new Scanner(file, "UTF-8" )) {
                while(scanner.hasNext()) {
                    String str = scanner.nextLine();
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
                    else if (Pattern.matches("(((\\-)?([0-9])+(\\.)?([0-9])*)|( )|(\t))+", str)) {
                        text.add(str);
                    }
                }
            }
            if("TSP".equals(type) && dimensions > 0) {
                for (String string : text) {
                    String[] parts = string.strip().split("( )+");
                    if(parts.length != 3) {
                        isParsed = false;
                        break;
                    } else {
                        coordinates.add(new Coordinate(Double.parseDouble(parts[1]), Double.parseDouble(parts[2])));
                    }
                    isParsed = coordinates.size() == dimensions;
                }
            } else if ("ATSP".equals(type) && dimensions > 0) {
                distanceMatrix = new double[dimensions][dimensions];
                int i = 0;
                int j = 0;
                int count = 0;
                for (String string : text) {
                    String[] parts = string.strip().split("( )+");
                    for(String str : parts) {
                        distanceMatrix[i][j] = Double.parseDouble(str);
                        j=((j+1)%dimensions);
                        if(j == 0) i+=1;
                        count++;
                    }
                }
                isParsed = (count == dimensions * dimensions);

            } else {
                isParsed = false;
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find the file. Error : " + e.getMessage());
        }
        return isParsed;
        
    }

    public boolean isASymmetric() {
        return isASymmetric;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public double[][] getDistanceMatrix() {
        return distanceMatrix;
    }
    
}
