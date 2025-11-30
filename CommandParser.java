

// [AI-BOILERPLATE] Basic command input parser.

//TODO: Use comments to clearly denotate what sections of code do what.
public class CommandParser {

    //splits commands entered by the player into useable lowercase key words
    public String[] parse(String input) {
        return input.trim().toLowerCase().split(" ");
    }
    
}
