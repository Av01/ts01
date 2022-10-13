package tsp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Validator to test syntax of File in TSPLIB format
 * @author Aakash Vora
 */
public class FileValidator {


    private String regex1 = "(EDGE_WEIGHT_SECTION)|(NODE_COORD_SECTION)|((NAME|TYPE|COMMENT|DIMENSION|EDGE_WEIGHT_TYPE|EDGE_WEIGHT_FORMAT)( )*:( )*(.)*)";
    private String regex2 = "((((\\-)?([0-9])+(\\.)?([0-9])*)|( )|(\t))+|EOF+)";
    private Pattern pattern = Pattern.compile(regex1 + "?|" + regex2 + "?");


    /**
     * Validates the file
     * @param file File to be validated
     * @return Boolean representing success or failure
     */
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


}
