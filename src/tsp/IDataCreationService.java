package tsp;

import java.io.File;
import data.RespositoryHandler;

public class IDataCreationService implements DataCreationService {
    FileValidator fileValidator;
    Parser parser;
    RespositoryHandler handler;

    public IDataCreationService(RespositoryHandler dataHandler) {
        this.handler = dataHandler;
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
                handler.updateIsAsymmetric(parser.isASymmetric);
                if(!parser.isASymmetric) {
                    handler.updateCoordinates(parser.coordinates);
                } else {
                    handler.updateDistances(parser.distanceMatrix);
                }
                handler.calculateRest();
            } else {
                System.out.println("Unable to parse received file");
            }
        }  else {
            System.out.println("Invalid file received");
        }
        return isSuccess;
    }
    
}
