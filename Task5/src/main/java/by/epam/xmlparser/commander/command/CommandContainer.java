package by.epam.xmlparser.commander.command;

import java.util.HashMap;
import java.util.Map;

import by.epam.xmlparser.commander.ICommand;

public class CommandContainer {
	
	private static final CommandContainer INSTANCE = new CommandContainer();
	private Map<CommandType, ICommand> container = new HashMap<CommandType, ICommand>();
	
	private CommandContainer() {
		container.put(CommandType.NOT_SUCH_COMMAND, new NoCommand());
		container.put(CommandType.DOM_PARSE, new DomParseCommand());
		container.put(CommandType.SAX_PARSE, new SaxParseCommand());
		container.put(CommandType.STAX_PARSE, new StaxParseCommand());
	}
	
	public static CommandContainer getInstance() {
		return INSTANCE;
	}
	
	public ICommand getCommand(CommandType commandType) {
		return container.get(commandType);
	}

}
