package commands;

/**
 * Created by Peter Krasnan.
 */
public class AllCommand extends GeneratorCommand {

    @Override
    public void execute() {
        getGenerator().setAllFlag();
    }

}
