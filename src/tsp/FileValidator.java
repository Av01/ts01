package tsp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileValidator {
    /*  NAME:  br17
        TYPE: ATSP
        COMMENT: 17 city problem (Repetto)
        DIMENSION:  17
        EDGE_WEIGHT_TYPE: EXPLICIT
        EDGE_WEIGHT_FORMAT: FULL_MATRIX  */
    String regex1 = "(EDGE_WEIGHT_SECTION)|(NODE_COORD_SECTION)|((NAME|TYPE|COMMENT|DIMENSION|EDGE_WEIGHT_TYPE|EDGE_WEIGHT_FORMAT)( )*:( )*(.)*)";
    String regex2 = "((((\\-)?([0-9])+(\\.)?([0-9])*)|( )|(\t))+|EOF+)";
    Pattern pattern = Pattern.compile(regex1 + "?|" + regex2 + "?");
    public boolean validate(File file) {
        boolean isValid = false;
        try {
            Scanner s = new Scanner(file);
            while(s.hasNextLine()) {
                String str = s.nextLine();
                Matcher m = pattern.matcher(str);
                isValid = m.matches() && m.start() == 0 && m.end() == str.length();
                // System.out.println(str + (m.matches() ? "Valid" : "Invalid"));
                if(!isValid) break;
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file. Error: " + e.getMessage());
        }
        return isValid;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileValidator validator = new FileValidator();
        if (validator.validate(new File("/Users/avsmac/Downloads/asym_small.atsp"))) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
