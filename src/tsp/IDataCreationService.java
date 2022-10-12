package tsp;

import java.io.File;
import java.util.List;

import data.IRespositoryHandler;
import data.RespositoryHandler;

public class IDataCreationService implements DataCreationService {
    FileValidator fileValidator;
    Parser parser;
    RespositoryHandler handler = new IRespositoryHandler();

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
                List<List<Double>> data = parser.getData();
                for (List<Double> list : data) {
                    for (Double it : list) {
                        System.out.print(it + ",");
                    }
                    System.out.println();
                }
                handler.empty();
                handler.updateIsAsymmetric(parser.isASymmetric);
                if(!parser.isASymmetric) {
                    handler.updateCoordinates(data);
                } else {
                    handler.updateDistances(data);
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
