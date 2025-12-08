/*
*Name: James McKean
*Date: 12/4/25
*Assignment: Final Programming Project
*CPSC-39-12705 (Fall 2025)
*Professor Kanemoto
*/


/*
 * CommandParser.java
 *
 * Portions of this code were adapted with guidance from OpenAI's ChatGPT (Dec 2025).
 * Suggestions included improvements to parsing multi-word commands and normalizing input.
 * All modifications, integration into the game, and additional logic were implemented by James McKean.
 */
//CommandParser


//TODO: Use comments to clearly denotate what sections of code do what.
public class CommandParser {

    //splits commands entered by the player into a command and optional modifiers that are put into the "remainder" variable and normalizing into lowercase
    public String[] parse(String input) {

        //If input is not assigned a value other than it's initialization value of null
        if(input == null) {
            //then a new 0 length string array is created to indicate nothing was entered
            return new String[0];
        }
        
        //The input variable is trimmed, removing leading and trailing whitespace
        input = input.trim();
        //If the input variable is empty
        //Then a new 0 length string array is created to indicate nothing was entered
        if(input.isEmpty()) {
            return new String[0];
        }

        //split into 2 parts only
        String[] parts = input.split("\\s+", 2);
        //commands are parts[0]
        //normalize commands into lower case
        parts[0] = parts[0].toLowerCase();
        //check if the split above resulted in only one part
        if(parts.length ==1) {
            //if so, a new string array is created containing just the command
            return new String[] {
                parts[0]
            };
        }
        // the remainder string variable is instantiated
        //remainder is assigned as parts[1] trimmed for whitespace and forced to lowercase
        // .replaceAll("\\s+", " "); replaces any amount of consecutive whitespaces with a space (" ")
        String remainder = parts[1].trim().toLowerCase().replaceAll("\\s+"," ");
        //Creates a new String array containing the command (parts[0]) in index 0 and the remainder variable value in index 1
        return new String[] { parts[0], remainder };
    }
}
    

