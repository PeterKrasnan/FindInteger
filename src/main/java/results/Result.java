package results;

import algorithms.Algorithm;

/**
 * Created by Peter Krasnan on 22.10.2017.
 */
public class Result {
    private Algorithm algo;
    private long time;
    private int number;

    public Result(Algorithm algo, long time, int number) {
        this.algo = algo;
        this.time = time;
        this.number = number;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "[" + algo.getName() + ", " + time / 1000000 + " ms , " + number + "]";
    }
}
