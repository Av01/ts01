import gui.Constants;
import gui.DisplayPanel;
import gui.Model;
import gui.ReloadActionListener;
import gui.UploadListener;
import tsp.DataCreationService;
import tsp.DistanceMetric;
import tsp.EucidianDistanceMetric;
import tsp.FileValidator;
import tsp.IDataCreationService;
import tsp.ISolverService;
import tsp.Parser;
import tsp.SolverService;

import java.awt.event.*;

import data.IRespositoryHandler;
import data.RespositoryHandler;


/**
 * Main class triggering execution of the application
 * @author Aakash Vora
 */
public class App {


    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        DisplayPanel gui = new DisplayPanel(new Model(Constants.START_DISTANCE, Constants.START_ORDER), 2000,1000);
        RespositoryHandler dataHandler = new IRespositoryHandler();
        FileValidator fileValidator = new FileValidator();
        Parser parser = new Parser();
        DataCreationService dataCreationService = new IDataCreationService(fileValidator, parser, dataHandler);
        DistanceMetric distanceMetric = new EucidianDistanceMetric();
        SolverService solverService = new ISolverService(dataHandler, distanceMetric);
        ActionListener resetListener = new ReloadActionListener(gui);
        ActionListener uploadListener = new UploadListener(gui, dataCreationService, solverService);
        gui.registerButtonListeners(resetListener, uploadListener);
    }


}
