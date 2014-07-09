package by.epam.xmlparser.commander;

import by.epam.xmlparser.commander.command.CommandContainer;
import by.epam.xmlparser.commander.command.CommandType;


public class CommandDispatcher {
	
	private static final CommandDispatcher INSTANCE = new CommandDispatcher();
	private CommandContainer container;
	
	private CommandDispatcher() {
		container = CommandContainer.getInstance();
	}
	
	public static CommandDispatcher getInstance() {
		return INSTANCE;
	}
	
	public ICommand getCommand(String commandName) {
		CommandType commandType = CommandType.valueOf(commandName.toUpperCase());
		ICommand command;
		if (null != commandType) {
			command = container.getCommand(commandType);
		} else {
			command = container.getCommand(CommandType.NOT_SUCH_COMMAND);
		}
		return command;
	}

}
