package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter Krasnan.
 */
public class AlgorithmService {

    private static AlgorithmService instance;
    private List<Algorithm> algorithms;

    private AlgorithmService() {
    }

    public static AlgorithmService getInstance() {
        if (instance == null) {
            instance = new AlgorithmService();
        }
        return instance;
    }

    private void initAllAlgorithms() {
        algorithms = new ArrayList<Algorithm>() {
            {
                add(new AlgoA());
                add(new AlgoB());
                add(new AlgoC());
            }
        };
    }

    public List<Algorithm> getAllAlgorithms() {
        initAllAlgorithms();
        return algorithms;
    }

    //    public void setTimeOutToAlgorithms(){
    //        //...
    //    }
}
