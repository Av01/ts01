package tsp;

import java.util.List;

import data.Coordinate;


/**
 * Represents output data for TSP solution
 * @author Aakash Vora
 */
public class SolverOut {


    private List<Integer> order;
    private double totaldistance;
    private boolean showData = false;
    private List<Coordinate> coordinates;
    


    /**
     * Create new object with solution data
     * @param order Order of traversal
     * @param totaldistance Total distance
     * @param showData Boolean representing symmetric TSP
     * @param coordinates List of coordinates
     */
    public SolverOut(List<Integer> order, double totaldistance, boolean showData, List<Coordinate> coordinates) {
        this.order = order;
        this.totaldistance = totaldistance;
        this.showData = showData;
        this.coordinates = coordinates;
    }


    public List<Integer> getOrder() {
        return order;
    }


    public void setOrder(List<Integer> order) {
        this.order = order;
    }


    public double getTotaldistance() {
        return totaldistance;
    }


    public void setTotaldistance(double totaldistance) {
        this.totaldistance = totaldistance;
    }


    public boolean isShowData() {
        return showData;
    }


    public void setShowData(boolean showData) {
        this.showData = showData;
    }


    public List<Coordinate> getCoordinates() {
        return coordinates;
    }


    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    
}
