package tsp;

public class DummySolverService implements SolverService {

    @Override
    public SolverOut solve() {
        System.out.println("Solver called!!");
        return null;
    }
    
}
