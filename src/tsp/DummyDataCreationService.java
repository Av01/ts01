package tsp;

import java.io.File;

public class DummyDataCreationService implements DataCreationService {

    @Override
    public boolean populateDataFromFile(File file) {
        return false;
    }
    
}
