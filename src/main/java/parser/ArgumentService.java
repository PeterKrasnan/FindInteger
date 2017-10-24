package parser;

import commands.AllCommand;
import commands.Command;
import commands.FirstCommand;
import commands.ICommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter Krasnan.
 */

/**
 * Responsible for creation commands, (maybe in future for Options, Flags, ...) from arguments
 * that are used for setting, controlling program
 */
public class ArgumentService {

    private List<ICommand> commands;

    //we can add new type of list, e.g. if we create new class called Option, Flags, Variables, etc
    //for controlling behaviour of various classes
    //some of them could be used for setting DB connection for storing results, setting input file, it's format,
    //or setting generation of statitistics,...

    public ArgumentService(String[] args) {
        commands = new ArrayList<>();
        for (String arg : args) {

            //if (condition)
            commands.add(createCommand(arg));

            //else {if (someOtherCondition)
            // {options.add(createOption(arg))}}...
        }
    }

    public List<ICommand> getCommands() {
        return commands;
    }

    private ICommand createCommand(String arg) {

        //more complex logic could be added

        if (arg.equals(Command.ALL.name().toLowerCase())) {
            return new AllCommand();
        }
        if (arg.equals(Command.FIRST.name().toLowerCase())) {
            return new FirstCommand();
        }

        throw new IllegalArgumentException("Wrong argument, arg: " + arg);
    }

}
