package data;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents the repository for holding file data
 * @author Aakash Vora
 */
public class Repository {


    /**
     * It supposed to be singleton object, hence storing the reference as a static variable
     */
    private static Repository repository;
    /**
     * Field to mark asymmetric or symmetric data
     */
    private boolean isAsymmetric;
    /**
     * Reference to coordinate list
     */
    private List<Coordinate> coordinates; 
    /**
     * Reference to matrix containing between all coordinates
     */
    private double[][] distanceMatrix;


    public Repository() {
        isAsymmetric = false;
        coordinates = new ArrayList<>();
        distanceMatrix = null;
    }


    /**
     * @return Reference to current Repository object
     */
    public static Repository getInstance() {
        repository = repository == null ? new Repository() : repository;
        return repository;
    } 

    
    /**
     * @return Purges last object and generate a new one with defaults
     */
    public static Repository refresh() {
        return repository = new Repository();
    }


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


}
