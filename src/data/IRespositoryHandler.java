package data;

import java.util.ArrayList;
import java.util.List;

public class IRespositoryHandler implements RespositoryHandler {
    
    @Override
    public List<List<Double>> fetchCoordinates() {
        return Repository.getInstance().getCoordinates();
    }

    @Override
    public void updateCoordinates(List<List<Double>> coordinates) {
        Repository.getInstance().setCoordinates(coordinates);
        
    }

    @Override
    public List<List<Double>> fetchDistances() {
        return Repository.getInstance().getDistanceMatrix();
    }

    @Override
    public void updateDistances(List<List<Double>> distances) {
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
            List<List<Double>> coordinates = repository.getCoordinates();
            int n = coordinates.size();
            List<List<Double>> distanceMat = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                List<Double> row = new ArrayList<>();
                for(int j = 0; j < n; j++) {
                    double distance = find_distance(coordinates.get(i).get(0),coordinates.get(i).get(1),
                    coordinates.get(j).get(0),coordinates.get(j).get(1));
                    row.add(distance);
                }
                distanceMat.add(row);
            }
            repository.setDistanceMatrix(distanceMat);
        }
        
    }

    private double find_distance(Double x1, Double y1, Double x2, Double y2) {
        return Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2, 2));
    }
    
}
