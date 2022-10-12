package data;

import java.util.List;

public interface RespositoryHandler {
    public List<List<Double>> fetchCoordinates();
    public void updateCoordinates(List<List<Double>> coordinates);
    public List<List<Double>> fetchDistances();
    public void updateDistances(List<List<Double>> distances);
    public boolean fetchIsAsymmetric();
    public void updateIsAsymmetric(boolean isASymmetric);
    public void empty();
    public void calculateRest();
}
