package gui;

import java.awt.event.*;

public class ReloadActionListener implements ActionListener{
    DisplayPanel panel;

    public ReloadActionListener(DisplayPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Model model = new Model( Constants.START_DISTANCE, Constants.START_ORDER);
        panel.updateModel(model);
    }
    
}
