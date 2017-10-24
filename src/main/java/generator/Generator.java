package generator;

import algorithms.Algorithm;
import algorithms.AlgorithmService;
import commands.GeneratorCommand;
import commands.CommandGeneratorExecutor;
import commands.ICommand;
import results.Result;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by Peter Krasnan.
 */
public class Generator implements CommandGeneratorExecutor {

    private List<Algorithm> algos;
    private List<ICommand> commands;
    private ExecutorService executorService;

    private boolean allFlag;
    private boolean firstFlag;

    public Generator(List<ICommand> commands) {
        this.commands = commands;
        this.executorService = Executors.newCachedThreadPool();
    }

    public void run() {
        setGeneratorToCommands();
        executeCommands(); //some command could set e.g. timeoutFlag

        algos = getWantedAlgorithms(); //initialization

        run(algos);

        writeResults();
        cleanSettings();
    }

    private void run(List<Algorithm> algos) {
        for (Algorithm algo : algos) {
            executorService.execute(algo);
        }
        waitTillEnd();
    }

    private void executeCommands() {
        commands.forEach(x -> x.execute());
    }

    //Sets generator to all GeneratorCommand commands
    private void setGeneratorToCommands() {
        for (ICommand command : commands) {
            if (command instanceof GeneratorCommand) {
                ((GeneratorCommand) command).setGenerator(this);
            }
        }
    }

    private void waitTillEnd() {
        executorService.shutdown();
        try {

            // timeout can be set as a field
            // now is set to 10 seconds
            executorService.awaitTermination(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Based on set flags, method prints results to STDOUT
     */
    private void writeResults() {
        if (firstFlag) {
            System.out.println(getResults().stream().reduce((a, b) -> a.getTime() < b.getTime() ? a : b).orElse(null));
        }

        if (allFlag) {
            StringBuilder sb = new StringBuilder();
            for (Result result : getResults()) {
                sb.append(result.toString());
            }
            System.out.println(sb);
        }

        //e.g. implementation of showing minimal number
        //if (minFlag){System.out.println(getResults().stream().reduce((a, b) -> a.getNumber() < b.getNumber() ? a : b).orElse(null))}
    }

    private List<Algorithm> getWantedAlgorithms() {
        //Here we can add logic for what algorithms we want to use
        //if no condition is set by a command, return all algorithms available
        //e.g. if (someCondition){return AlgorithmService.getInstance().getAllAlgorithms(condition);}
        return AlgorithmService.getInstance().getAllAlgorithms();
    }

    private List<Result> getResults() {
        return algos.stream().map(Algorithm::getResult).collect(Collectors.toList());
    }

    @Override
    public void setAllFlag() {
        allFlag = true;
    }

    @Override
    public void setFirstFlag() {
        firstFlag = true;
    }

    private void cleanSettings() {
        allFlag = false;
        firstFlag = false;
    }


}
