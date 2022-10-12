package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
// import java.awt.*;

import tsp.IDataCreationService;
import tsp.ISolverService;

public class ParentGUI {
    JFrame frame;
    JPanel panel;
    int width = 2000;
    int height = 1000;

    public ParentGUI() {
        frame = new JFrame();
        panel = new MainPanel(new ISolverService(), new IDataCreationService());
        // frame.setLayout(new FlowLayout());
        frame.setSize(width,height);  
        frame.add(panel);
        frame.setVisible(true);
    }

}
