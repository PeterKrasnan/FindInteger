package algorithms;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.random;

/**
 * Created by Peter Krasnan.
 */
public class AlgoB extends Algorithm {

    public AlgoB() {
        super();
        setName("B");
    }

    @Override
    public int calculation() {
        long time = 1000 + (long) (random() * 2000);
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Random().nextInt();
    }

}
