package data;

import java.util.List;

public interface RespositoryHandler {
    public List<Coordinate> fetchCoordinates();
    public void updateCoordinates(List<Coordinate> coordinates);
    public double[][] fetchDistances();
    public void updateDistances(double[][] distances);
    public boolean fetchIsAsymmetric();
    public void updateIsAsymmetric(boolean isASymmetric);
    public void empty();
    public void calculateRest();
}
