package data;

import java.util.ArrayList;
import java.util.List;

public class IRespositoryHandler implements RespositoryHandler {
    
    @Override
    public List<Coordinate> fetchCoordinates() {
        return Repository.getInstance().getCoordinates();
    }

    @Override
    public void updateCoordinates(List<Coordinate> coordinates) {
        Repository.getInstance().setCoordinates(coordinates);
        
    }

    @Override
    public double[][] fetchDistances() {
        return Repository.getInstance().getDistanceMatrix();
    }

    @Override
    public void updateDistances(double[][] distances) {
        Repository.getInstance().setDistanceMatrix(distances);
        
    }

    @Override
    public boolean fetchIsAsymmetric() {
        return Repository.getInstance().isAsymmetric();
    }

    @Override
    public void updateIsAsymmetric(boolean isASymmetric) {
        Repository.getInstance().setAsymmetric(isASymmetric);       
    }

    @Override
    public void empty() {
        Repository.refresh();
    }

    @Override
    public void calculateRest() {
        Repository repository = Repository.getInstance();
        if(!repository.isAsymmetric()) {
            List<Coordinate> coordinates = repository.getCoordinates();
            int n = coordinates.size();
            double[][] distanceMat = new double[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = i; j < n; j++) {
                    double distance = find_distance(coordinates.get(i).x,coordinates.get(i).y,
                    coordinates.get(j).x,coordinates.get(j).y);
                    distanceMat[i][j] = distance;
                    distanceMat[j][i] = distance;
                }
            }
            repository.setDistanceMatrix(distanceMat);
        }
        
    }

    private double find_distance(Double x1, Double y1, Double x2, Double y2) {
        return Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2, 2));
    }
    
}
