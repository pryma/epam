package by.epam.xmlparser.commander;

import by.epam.xmlparser.commander.command.DomParseCommand;
import by.epam.xmlparser.commander.command.NoCommand;
import by.epam.xmlparser.commander.command.SaxParseCommand;
import by.epam.xmlparser.commander.command.StaxParseCommand;


public class CommandDispatcher {
	
/*	private static final CommandContainer INSTANCE = new CommandContainer();
	private Map<CommandType, ICommand> container = new HashMap<CommandType, ICommand>();
	
	private CommandContainer() {
		container.put(CommandType.DOM_PARSE, new DomParseCommand());
		container.put(CommandType.SAX_PARSE, new SaxParseCommand());
		container.put(CommandType.STAX_PARSE, new StaxParseCommand());
	}
	
	public static CommandContainer getInstance() {
		return INSTANCE;
	}*/
	
	public static ICommand getCommand(String commandName) {
		CommandType command = CommandType.valueOf(commandName.toUpperCase());
		
		switch (command) {
		
		case DOM_PARSE:
			return new DomParseCommand();
		case SAX_PARSE:
			return new SaxParseCommand();
		case STAX_PARSE:
			return new StaxParseCommand();

		default:
			
			return new NoCommand();
		}
		
	}

}
