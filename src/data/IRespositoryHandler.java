package data;

import java.util.List;


/**
 * Implementation for RespositoryHandler interface
 * @author Aakash Vora
 */
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


}
