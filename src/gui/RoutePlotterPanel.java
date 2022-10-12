package gui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class RoutePlotterPanel extends JPanel{
    private List<List<Integer>> coordinates = new ArrayList<>();

    
    public List<List<Integer>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<Integer>> coordinates) {
        this.coordinates = coordinates;
    }

    public RoutePlotterPanel() {
        super();
        this.setSize(500,500);
    }

    @Override
    public void paint(Graphics g) {
        int x = this.getX() + 50;
        int y = this.getY() + 50;
        List<Integer> lastCoordinates = null;
        for (int i = 0; i < coordinates.size(); i++) {
            List<Integer> coordinate = coordinates.get(i);
            g.drawOval(coordinate.get(0) + x, coordinate.get(1) + y, 5, 5);
            if(lastCoordinates != null) {
                g.drawLine(lastCoordinates.get(0) + x, lastCoordinates.get(1) + y
                , coordinate.get(0) + x, coordinate.get(1) + y);
            }
            lastCoordinates = coordinate;
        }
    }

    public void clear(Graphics g) {
        g.clearRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

}
