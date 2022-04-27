package commands.commandCollection;

import commands.Command;

public class ExitCommand extends Command {

    @Override
    public void userExecute() {
        setName("exit");
        setArg("EXIT");
    }
}
