package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import tsp.DataCreationService;
import tsp.SolverOut;
import tsp.SolverService;

public class MainPanel extends JPanel implements ActionListener {
    JButton reset;
    JButton upload;
    JTextArea order;
    JLabel orderLabel;
    JTextField distance;
    JLabel distanceLabel;
    SolverService solverService;
    DataCreationService dataCreationService;
    JFileChooser fc = new JFileChooser();
    JPanel panel1;
    JPanel panel2;
    RoutePlotterPanel panel3;
    int height = 2000;
    int width = 2000;


    public MainPanel(SolverService solverService, DataCreationService dataCreationService) {
        super();
        this.setLayout(new BorderLayout());
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new RoutePlotterPanel();
        this.dataCreationService = dataCreationService;
        this.solverService = solverService;
        reset = new JButton("Reset");
        reset.addActionListener(this);

        upload = new JButton("Upload and Calculate");
        upload.addActionListener(this);

        panel1.add(reset);
        panel1.add(upload);
        panel1.setPreferredSize(new Dimension(200,1000));
        this.add(panel1, BorderLayout.LINE_START);

        distanceLabel = new JLabel("Total distance");
        distance = new JTextField("Total distance will show up here");
        distance.setEnabled(false);
        panel2.add(distanceLabel);
        panel2.add(distance);

        orderLabel = new JLabel("Order of Traversal");
        order = new JTextArea();
        JScrollPane scroll = new JScrollPane(order, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(300,500));
        order.setLineWrap(true);
        order.setEnabled(false);
        panel2.add(orderLabel);
        panel2.add(scroll);
        panel2.setPreferredSize(new Dimension(300,500));
        this.add(panel2, BorderLayout.AFTER_LINE_ENDS);
        panel3.setPreferredSize(new Dimension(1000,1000));
        this.add(panel3,BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        order.setText(e.getActionCommand());
        if(e.getSource() == upload) {
            reloadUI();
            int returnVal = fc.showDialog(this,"Select");
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                order.setText("Opening: " + file.getName() + ".");
                if(dataCreationService.populateDataFromFile(file)) {
                    SolverOut s = solverService.solve();
                    if(s.isShowData()) {
                        List<List<Integer>> newCoordinates = scaleCoordinates(s.getCoordinates());
                        showCoordinates(newCoordinates, s.getOrder());
                    }
                    showOutput(s.getOrder(),s.getTotaldistance());
                } else {
                    order.setText("Unable to read the file.");
                }
            } else {
                order.setText("Open command cancelled by user.");
            }
        }
        if(e.getSource() == reset) {
            reloadUI();
        }
        
    }

    private void reloadUI() {
        order.setText("");
        distance.setText("");
        panel3.clear(getGraphics());
        
    }

    private void showOutput(List<Integer> orderList, double totaldistance) {
        distance.setText(String.valueOf(totaldistance));
        String orderString = "";
        for (int i = 0; i < orderList.size(); i++) {
            if (i != 0) {
                orderString += " -> ";
            }
            orderString += orderList.get(i);
        }
        order.setText(orderString);
    }

    private void showCoordinates(List<List<Integer>> newCoordinates, List<Integer> order) {
        List<List<Integer>> rearrangedList = new ArrayList<>();
        for (Integer o : order) {
            rearrangedList.add(newCoordinates.get(o));
        }
        panel3.setCoordinates(rearrangedList);
        panel3.paint(getGraphics());
    }

    private List<List<Integer>> scaleCoordinates(List<List<Double>> coordinates) {
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        for (List<Double> list : coordinates) {
            double x = list.get(0);
            double y = list.get(1);
            if (maxX < x) maxX = x;
            if (minX > x) minX = x;
            if (maxY < y) maxY = y;
            if (minY > y) minY = y; 
        }
        List<List<Integer>> out = new ArrayList<>();
        double xdiff = maxX - minX;
        double ydiff = maxY - minY;
        for (int i = 0; i < coordinates.size(); i++) {
            List<Double> coordinate = coordinates.get(i);
            double x = coordinate.get(0);
            double y = coordinate.get(1);
            if(minX < 0) x = x - minX;
            if(minY < 0) y = y - minY;
            int new_x = (int) (450 * x / xdiff);
            int new_y = (int) (450 * y / ydiff);
            List<Integer> xy = new ArrayList<>();
            xy.add(new_x);
            xy.add(new_y);
            out.add(xy);
        }
        return out;
    }
}
