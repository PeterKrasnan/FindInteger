package commands;

import generator.Generator;

/**
 * Created by Peter Krasnan.
 *
 */
public abstract class GeneratorCommand implements ICommand {
    private CommandGeneratorExecutor generator;

    public abstract void execute();

    public void setGenerator(Generator generator){
        this.generator = generator;
    }

    public CommandGeneratorExecutor getGenerator() {
        return generator;
    }
}
