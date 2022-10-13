package tsp;

import java.io.File;
import data.RespositoryHandler;


/**
 * Concrete Implementation for DataCreationService
 * @author Aakash Vora
 */
public class IDataCreationService implements DataCreationService {


    private FileValidator fileValidator;
    private Parser parser;
    private RespositoryHandler handler;
    

    /**
     * Creates instance for DataCreationService
     * @param fileValidator Validator to validate file
     * @param parser Parser to parse file
     * @param handler Handler to communicate with Repository
     */
    public IDataCreationService(FileValidator fileValidator, Parser parser, RespositoryHandler handler) {
        this.fileValidator = fileValidator;
        this.parser = parser;
        this.handler = handler;
    }


    @Override
    public boolean populateDataFromFile(File file) {
        boolean isSuccess = false;
        boolean isParsed = false;
        boolean isValid = false;
        fileValidator = new FileValidator();
        parser = new Parser();
        isValid = fileValidator.validate(file);
        if(isValid) {
            isParsed = parser.parse(file);
            if (isParsed) {
                isSuccess = true;
                handler.empty();
                handler.updateIsAsymmetric(parser.isASymmetric());
                if(!parser.isASymmetric()) {
                    handler.updateCoordinates(parser.getCoordinates());
                } else {
                    handler.updateDistances(parser.getDistanceMatrix());
                }
            } else {
                System.out.println("Unable to parse received file");
            }
        }  else {
            System.out.println("Invalid file received");
        }
        return isSuccess;
    }

    
}
