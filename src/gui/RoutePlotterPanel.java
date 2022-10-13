package gui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import data.Coordinate;


/**
 * Child class of JPanel with functionality for plotting points
 * @author Aakash Vora
 */
public class RoutePlotterPanel extends JPanel{


    /**
     * Store the list of coordinates that needs to be plotted
     */
    private List<Coordinate> coordinates = new ArrayList<>();

    
    public RoutePlotterPanel() {
        super();
    }


    @Override
    public void paint(Graphics g) {
        int width = this.getWidth();
        int height = this.getHeight();
        int x = (int)(this.getX() + 0.01 * width);
        int y = (int)(this.getY() + 0.01 * height);
        List<Coordinate> scaledCoordinates = Utils.scaleCoordinates(this.coordinates, (int)(width * 0.9), (int)(height * 0.9));
        Coordinate lastCoordinates = null;
        for (Coordinate coordinate : scaledCoordinates) {
            g.drawOval((int)coordinate.x + x, (int)coordinate.y + y, 2, 2);
            if(lastCoordinates != null) {
                g.drawLine((int)lastCoordinates.x + x, (int)lastCoordinates.y + y
                , (int)coordinate.x + x, (int)coordinate.y + y);
            }
            lastCoordinates = coordinate;
        }
    }


    /**
     * Clears the plotted points
     * @param g G
     */
    public void clear(Graphics g) {
        g.clearRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }


    public List<Coordinate> getCoordinates() {
        return coordinates;
    }


    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

}
