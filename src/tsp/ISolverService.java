package tsp;

import java.util.ArrayList;
import java.util.List;

import data.Coordinate;
import data.RespositoryHandler;


/**
 * Concrete Implementation for SolverService
 * @author Aakash Vora
 */
public class ISolverService implements SolverService {


    private RespositoryHandler handler;


    /**
     * @param dataHandler Handler to communicate with Repository
     */
    public ISolverService(RespositoryHandler dataHandler) {
        handler = dataHandler;
    }

    @Override
    public SolverOut solve() {
        SolverOut out;
        if(handler.fetchIsAsymmetric()) {
            out = find_tsp(handler.fetchDistances());

        } else {
            out = find_tsp(handler.fetchCoordinates());
        }
        return out;
    }

    /**
     * Solves the Traveling salesman using Nearest Neighbor method
     * @param distanceMat 2D Matrix containing distance between all coordinates
     * @return Object containing total distance and order of traversal info
     */
    private SolverOut find_tsp(double[][] distanceMat) {
        double totaldistance = 0;
        List<Integer> order = new ArrayList<>();
        int source = 0;
        int currInd = source;
        for (int i = 0; i < distanceMat.length; i++) {
            order.add(currInd);
            int nextInd = -1;
            double nextDis = Double.MAX_VALUE;
            boolean update = false;
            for (int j = 0; j < distanceMat.length; j++) {
                if(currInd != j) {
                    if(distanceMat[currInd][j] < nextDis && !order.contains(j)) {
                        nextDis = distanceMat[currInd][j];
                        nextInd = j;
                        update = true;
                    }
                }
            }
            if(update) {
                totaldistance+= nextDis;
                currInd = nextInd;
            }
        }
        totaldistance += distanceMat[currInd][source];
        order.add(source);
        return new SolverOut(order, totaldistance, !handler.fetchIsAsymmetric(), handler.fetchCoordinates());    
    }


    /**
     * Solves the Traveling salesman using Nearest Neighbor method
     * @param coordinates List containing coordinates for which problem needs to be solved
     * @return Object containing total distance and order of traversal info
     */
    private SolverOut find_tsp(List<Coordinate> coordinates) {
        double totaldistance = 0;
        List<Integer> order = new ArrayList<>();
        int source = 0;
        int currInd = source;
        for (int i = 0; i < coordinates.size(); i++) {
            order.add(currInd);
            int nextInd = -1;
            double nextDis = Double.MAX_VALUE;
            boolean update = false;
            for (int j = 0; j < coordinates.size(); j++) {
                if(currInd != j) {
                    Coordinate curCoordinate = coordinates.get(currInd);
                    Coordinate nextCoordinate = coordinates.get(j);
                    double distance = find_distance(curCoordinate, nextCoordinate);
                    if(distance < nextDis && !order.contains(j)) {
                        nextDis = distance;
                        nextInd = j;
                        update = true;
                    }
                }
            }
            if(update) {
                totaldistance+= nextDis;
                currInd = nextInd;
            }
        }
        totaldistance += find_distance(coordinates.get(currInd), coordinates.get(source));
        order.add(source);
        return new SolverOut(order, totaldistance, !handler.fetchIsAsymmetric(), handler.fetchCoordinates());    
    }

    /**
     * Utility function for calculating Eulidian distance between to coordinates
     * @param c1 First coordinate
     * @param c2 Second coordinate
     * @return Eulidian distance
     */
    private double find_distance(Coordinate c1, Coordinate c2) {
        return Math.sqrt(Math.pow(c1.x-c2.x,2) + Math.pow(c1.y-c2.y, 2));
    }
}
