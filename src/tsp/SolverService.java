package tsp;


/**
 * Interface for solving TSP problem
 * @author Aakash Vora
 */
public interface SolverService {


    /**
     * This method uses data in Repository and provides TSP solution for it.
     * @return Object containing solution for TSP
     */
    public SolverOut solve();

}
