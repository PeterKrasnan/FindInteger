import commands.ICommand;
import generator.Generator;
import parser.ArgumentService;

import java.util.List;

/**
 * Created by Peter Krasnan.
 */
public class MainApp {
    public static void main(String[] args) {
        //create commands for execution
        ArgumentService argumentService = new ArgumentService(args);

        //List<Options> options = argumentService.getOptions()

        //get commands
        List<ICommand> commands = argumentService.getCommands();

        //set generator behaviour based on commands
        Generator generator = new Generator(commands);

        //execute
        generator.run();

        //new DBConnection(options).writeToDB(generator.getResults())
    }
}
