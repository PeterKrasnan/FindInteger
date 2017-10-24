package commands;

/**
 * Created by Peter Krasnan.
 */
public class FirstCommand extends GeneratorCommand {

    @Override
    public void execute() {
        getGenerator().setFirstFlag();
    }

}
