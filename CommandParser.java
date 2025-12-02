

// [AI-BOILERPLATE] Basic command input parser.

//TODO: Use comments to clearly denotate what sections of code do what.
public class CommandParser {

    //splits commands entered by the player into useable lowercase key words
    public String[] parse(String input) {

        if(input == null) {
            return new String[0];
        }
        input = input.trim();
        if(input.isEmpty()) {
            return new String[0];
        }

        //split into 2 parts only
        String[] parts = input.split("\\s+", 2);
        //normalize commands into lower case
        parts[0] = parts[0].toLowerCase();
        if(parts.length ==1) {
            return new String[] {
                parts[0]
            };
        }
        String remainder = parts[1].trim().toLowerCase().replaceAll("\\s+"," ");
        return new String[] { parts[0], remainder };
    }
}
    

