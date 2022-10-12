package gui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import data.Coordinate;

public class RoutePlotterPanel extends JPanel{
    private List<Coordinate> coordinates = new ArrayList<>();

    
    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public RoutePlotterPanel() {
        super();
    }

    @Override
    public void paint(Graphics g) {
        int x = this.getX() + 50;
        int y = this.getY() + 50;
        int width = this.getWidth();
        int height = this.getHeight();
        List<Coordinate> scaledCoordinates = Utils.scaleCoordinates(this.coordinates, width, height);
        Coordinate lastCoordinates = null;
        for (Coordinate coordinate : scaledCoordinates) {
            g.drawOval((int)coordinate.x + x, (int)coordinate.y + y, 5, 5);
            if(lastCoordinates != null) {
                g.drawLine((int)lastCoordinates.x + x, (int)lastCoordinates.x + y
                , (int)coordinate.x + x, (int)coordinate.y + y);
            }
            lastCoordinates = coordinate;
        }
    }

    public void clear(Graphics g) {
        g.clearRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

}
