package gui;

import java.awt.event.*;


/**
 * Listener implementation for defining behaviour when "Reset" button is clicked
 * @author Aakash Vora
 */
public class ReloadActionListener implements ActionListener{
    

    private DisplayPanel panel;



    /**
     * @param panel Display panel containing GUI definations
     */
    public ReloadActionListener(DisplayPanel panel) {
        this.panel = panel;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Model model = new Model( Constants.START_DISTANCE, Constants.START_ORDER);
        panel.updateModel(model);
    }
    
}
