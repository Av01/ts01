package gui;

import java.util.ArrayList;
import java.util.List;

import data.Coordinate;

public class Model {
    String totalDistance = "";
    List<Coordinate> coordinates;
    public String orderOfTraversal;
    public Model(String totalDistance, String orderOfTraversal) {
        this.totalDistance = totalDistance;
        this.orderOfTraversal = orderOfTraversal;
        this.coordinates = new ArrayList<>();
    }
    public Model(String totalDistance, List<Coordinate> coordinates, String orderOfTraversal) {
        this.totalDistance = totalDistance;
        this.coordinates = coordinates;
        this.orderOfTraversal = orderOfTraversal;
    }
}
