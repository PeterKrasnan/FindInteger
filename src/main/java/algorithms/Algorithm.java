package algorithms;

import results.Result;

/**
 * Created by Peter Krasnan.
 */
public abstract class Algorithm implements Runnable {

    private Result result;
    private String name;

    @Override
    public void run() {
        calculate();
    }

    private void calculate() {
        long startTime = System.nanoTime();
        int result = calculation();
        long estimatedTime = System.nanoTime() - startTime;
        setResult(new Result(this, estimatedTime, result));
    }

    private void sleep(){

    }

    /**
     * Calculation of complex algorithm
     *
     * @return founded number
     */
    public abstract int calculation();

    public Result getResult() {
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setResult(Result result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
