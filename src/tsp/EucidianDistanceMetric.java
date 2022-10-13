package tsp;

import data.Coordinate;


/**
 * Concrete Implementation for DistanceMetric that calculates Eucidian distance between to points
 * @author Aakash Vora
 */
public class EucidianDistanceMetric implements DistanceMetric {

    @Override
    public double findDistance(Coordinate c1, Coordinate c2) {
        return Math.sqrt(Math.pow(c1.x-c2.x,2) + Math.pow(c1.y-c2.y, 2));
    }
    
}
