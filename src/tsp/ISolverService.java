package tsp;

import java.util.ArrayList;
import java.util.List;
import data.RespositoryHandler;

public class ISolverService implements SolverService {
    RespositoryHandler handler;

    public ISolverService(RespositoryHandler dataHandler) {
        handler = dataHandler;
    }

    @Override
    public SolverOut solve() {
        double[][] distanceMat = handler.fetchDistances();
        SolverOut out = find_tsp(distanceMat);
        // for (Integer i : out.getOrder()) {
        //     System.out.print(i + " -> ");
        // }
        // System.out.println("Total distance: " + out.getTotaldistance());
        return out;
    }

    private SolverOut find_tsp(double[][] distanceMat) {
        double totaldistance = 0;
        List<Integer> order = new ArrayList<>();
        int dim = distanceMat.length;
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
}
