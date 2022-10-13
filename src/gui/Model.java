package gui;

import java.util.ArrayList;
import java.util.List;

import data.Coordinate;


/**
 * Contains data to be displayed using GUI
 * @author Aakash Vora
 */
public class Model {


    String totalDistance = "";
    List<Coordinate> coordinates = new ArrayList<>();
    String orderOfTraversal;


    /**
     * @param totalDistance Total distance
     * @param orderOfTraversal String representing order of Traversal
     */
    public Model(String totalDistance, String orderOfTraversal) {
        this.totalDistance = totalDistance;
        this.orderOfTraversal = orderOfTraversal;
    }


    /**
     * @param totalDistance Total distance
     * @param coordinates List of coordinates
     * @param orderOfTraversal String representing order of Traversal
     */
    public Model(String totalDistance, List<Coordinate> coordinates, String orderOfTraversal) {
        this.totalDistance = totalDistance;
        this.coordinates = coordinates;
        this.orderOfTraversal = orderOfTraversal;
    }
}
