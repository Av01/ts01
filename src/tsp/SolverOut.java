package tsp;

import java.util.List;

public class SolverOut {
    List<Integer> order;
    double totaldistance;
    boolean showData = false;
    List<List<Double>> coordinates;
    
    public SolverOut(List<Integer> order, double totaldistance, boolean showData, List<List<Double>> coordinates) {
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

    public List<List<Double>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<Double>> coordinates) {
        this.coordinates = coordinates;
    }
    
}
