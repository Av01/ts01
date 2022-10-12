package data;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static Repository repository;
    private boolean isAsymmetric;
    private List<List<Double>> coordinates; 
    private List<List<Double>> distanceMatrix;

    public boolean isAsymmetric() {
        return isAsymmetric;
    }

    public void setAsymmetric(boolean isAsymmetric) {
        this.isAsymmetric = isAsymmetric;
    }

    public List<List<Double>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<Double>> coordinates) {
        this.coordinates = coordinates;
    }

    public List<List<Double>> getDistanceMatrix() {
        return distanceMatrix;
    }

    public void setDistanceMatrix(List<List<Double>> distanceMatrix) {
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
