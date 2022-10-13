package data;


/**
 * Coordinate class represents a POJO for storing (x,y) coordinates
 * @author Aakash Vora
 */
public class Coordinate {


    public double x;
    public double y;


    /**
     * Constructor for creating object from (x,y) values.
     * @param x Represents the x-axis value
     * @param y Represents the y-axis value
     */
    public Coordinate(double x,double y) {
        this.x = x;
        this.y = y;
    }


}
