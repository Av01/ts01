package gui;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import data.Coordinate;
import tsp.DataCreationService;
import tsp.SolverOut;
import tsp.SolverService;

public class UploadListener implements ActionListener{
    DisplayPanel panel;
    DataCreationService dataCreationService;
    SolverService solverService;

    public UploadListener(DisplayPanel panel, DataCreationService dataCreationService, SolverService solverService) {
        this.panel = panel;
        this.dataCreationService = dataCreationService;
        this.solverService = solverService;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        panel.updateModel(new Model(Constants.START_DISTANCE, Constants.START_ORDER));
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showDialog(panel.parentPanel,"Select");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            System.out.println("Opening: " + file.getName() + ".");
            if(dataCreationService.populateDataFromFile(file)) {
                SolverOut s = solverService.solve();
                List<Coordinate> coordinates = new ArrayList<>();
                if(s.isShowData()) {
                    coordinates = Utils.listCoordinateByOrder(s.getCoordinates(), s.getOrder());
                }
                panel.updateModel(new Model(String.valueOf(s.getTotaldistance()), coordinates, Utils.formatOrder(s.getOrder())));
            } else {
                System.out.println("Unable to read the file.");
            }
        } else {
            System.out.println("Open command cancelled by user.");
        }
        
    }
    
}
