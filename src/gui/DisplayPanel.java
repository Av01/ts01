package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Coordinate class represents a POJO for storing (x,y) coordinates
 * @author Aakash Vora
 */
public class DisplayPanel {


    JFrame frame;
    JPanel parentPanel;
    Model model;
    JButton reset;
    JButton upload;
    JTextArea order;
    JLabel orderLabel;
    JTextField distance;
    JLabel distanceLabel;
    JPanel panel1;
    JPanel panel2;
    RoutePlotterPanel panel3;


    /**
     * @param model Model containing the data to display
     * @param width Width in px of the window
     * @param height Height in px of the window
     */
    public DisplayPanel(Model model,int width,int height) {
        this.model = model;
        frame = new JFrame();
        parentPanel = new JPanel(new BorderLayout());
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new RoutePlotterPanel();
        reset = new JButton("Reset");

        upload = new JButton("Upload and Calculate");

        panel1.add(reset);
        panel1.add(upload);
        panel1.setPreferredSize(new Dimension(200,1000));
        parentPanel.add(panel1, BorderLayout.LINE_START);

        distanceLabel = new JLabel("Total distance");
        distance = new JTextField();
        distance.setEnabled(false);
        panel2.add(distanceLabel);
        panel2.add(distance);

        orderLabel = new JLabel("Order of Traversal");
        order = new JTextArea(model.totalDistance);
        JScrollPane scroll = new JScrollPane(order, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(300,500));
        order.setLineWrap(true);
        order.setEnabled(false);
        panel2.add(orderLabel);
        panel2.add(scroll);
        panel2.setPreferredSize(new Dimension(300,500));
        parentPanel.add(panel2, BorderLayout.AFTER_LINE_ENDS);
        panel3.setPreferredSize(new Dimension(1000,1000));
        parentPanel.add(panel3,BorderLayout.CENTER);

        frame.setSize(width,height);  
        frame.add(parentPanel);
        frame.setVisible(true);
        updateModel(model);
    }


    /**
     * Take a new Model and refreshes the displayed data
     * @param model Model containing data to display
     */
    public void updateModel(Model model) {
        this.model = model;
        panel3.clear(parentPanel.getGraphics());
        distance.setText(model.totalDistance);
        order.setText(model.orderOfTraversal);
        panel3.setCoordinates(model.coordinates);
        panel3.paint(parentPanel.getGraphics());
    }


    /**
     * @return Currently displayed model
     */
    public Model getModel() {
        return this.model;
    }


    /**
     * Adds behaviour for button click
     * @param resetListener Listener defining action for "Reset" button
     * @param uploadListener Listener defining action for "Upload and Calculate" button
     */
    public void registerButtonListeners(ActionListener resetListener, ActionListener uploadListener) {
        reset.addActionListener(resetListener);
        upload.addActionListener(uploadListener);
    }

    
    /**
     * Disables all buttons
     */
    public void disbleAction() {
        reset.setEnabled(false);
        upload.setEnabled(false);
    }


    /**
     * Enables all buttons
     */
    public void enableAction() {
        reset.setEnabled(true);
        upload.setEnabled(true);
    }

    
}
