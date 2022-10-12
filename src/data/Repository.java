package data;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static Repository repository;
    private boolean isAsymmetric;
    private List<Coordinate> coordinates; 
    private double[][] distanceMatrix;

    public boolean isAsymmetric() {
        return isAsymmetric;
    }

    public void setAsymmetric(boolean isAsymmetric) {
        this.isAsymmetric = isAsymmetric;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public double[][] getDistanceMatrix() {
        return distanceMatrix;
    }

    public void setDistanceMatrix(double[][] distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }

    public Repository() {
        isAsymmetric = false;
        coordinates = new ArrayList<>();
        distanceMatrix = null;
    }

    public static Repository getInstance() {
        repository = repository == null ? new Repository() : repository;
        return repository;
    } 
    
    public static Repository refresh() {
        return repository = new Repository();
    }
}
