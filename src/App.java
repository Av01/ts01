import gui.Constants;
import gui.DisplayPanel;
import gui.Model;
import gui.ReloadActionListener;
import gui.UploadListener;
import tsp.DataCreationService;
import tsp.IDataCreationService;
import tsp.ISolverService;
import tsp.SolverService;

import java.awt.event.*;

import data.IRespositoryHandler;
import data.RespositoryHandler;

public class App {
    public static void main(String[] args) throws Exception {
        DisplayPanel gui = new DisplayPanel(new Model(Constants.START_DISTANCE, Constants.START_ORDER), 2000,1000);
        RespositoryHandler dataHandler = new IRespositoryHandler();
        DataCreationService dataCreationService = new IDataCreationService(dataHandler);
        SolverService solverService = new ISolverService(dataHandler);
        ActionListener resetListener = new ReloadActionListener(gui);
        ActionListener uploadListener = new UploadListener(gui, dataCreationService, solverService);
        gui.registerButtonListeners(resetListener, uploadListener);
    }
}
