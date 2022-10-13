package tsp;

import java.io.File;


/**
 * Interface for validation and parsing of a file along with creation of data
 * @author Aakash Vora
 */
public interface DataCreationService {


    /**
     * Validates the syntax of file, parses it and populates the data in Repository
     * @param file File containing the data
     * @return Boolean representing success or failure
     */
    public boolean populateDataFromFile(File file); 


}
