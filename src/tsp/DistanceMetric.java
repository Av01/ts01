package tsp;

import data.Coordinate;


/**
 * Interface for calculating distance between to points
 * @author Aakash Vora
 */
public interface DistanceMetric {
    

    /**
     * Utility function for calculating distance between to coordinates
     * @param c1 First coordinate
     * @param c2 Second coordinate
     * @return distance value
     */
    public double findDistance(Coordinate c1, Coordinate c2);


}
