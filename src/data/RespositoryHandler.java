package data;

import java.util.List;


/**
 * Interface for communicating with data store
 * @author Aakash Vora
 */
public interface RespositoryHandler {


    /**
     * @return Returns list of coordinates from data store
     */
    public List<Coordinate> fetchCoordinates();


    /**
     * Updates list of coordinates in data store
     * @param coordinates List of coordinates
     */
    public void updateCoordinates(List<Coordinate> coordinates);


    /**
     * @return Returns distances between coordinates from data store
     */
    public double[][] fetchDistances();


    /**
     * Updates distances between coordinates in data store
     * @param distances 2D Matrix containing distances between coordinates
     */
    public void updateDistances(double[][] distances);


    /**
     * @return Returns the type of data (symmetric or asymmetric) from data store
     */
    public boolean fetchIsAsymmetric();


    /**
     * Updates the type of data (symmetric or asymmetric) in data store
     * @param isASymmetric Boolean showing whether data is asymmetric
     */
    public void updateIsAsymmetric(boolean isASymmetric);


    /**
     * Clears the data store and initializes it with default values
     */
    public void empty();


}
