/*
*Name: James McKean
*Date: 12/4/25
*Assignment: Final Programming Project
*CPSC-39-12705 (Fall 2025)
*Professor Kanemoto
*/

/*
 * Boilerplate structure generated with assistance from ChatGPT (OpenAI).
 * Adapted and completed by James McKean.
 * All conversation content, hints, dialogue, and logic were created by me.
 */

//TODO: Use comments to clearly denotate what sections of code do what.
//Old_Man.java

import java.util.HashMap;
import java.util.Scanner;

public class Old_Man {

    private String name;
    private HashMap<String, String> dialogueOptions = new HashMap<>();

    //constructor to set the npc name
    public Old_Man(String name) {
        this.name = name;
        
    }

    //method to return the npc name
    public String getName() {
        return name;
    }

    //method to store dialogue associated with a key
    public void addDialogue(String key, String text) {
        dialogueOptions.put(key, text);
        // Example: dialogueOptions.put("greet", "Hello there, traveler!");
    }

    //returns the dialogue using the key
    public String getDialogue(String key) {
        return dialogueOptions.get(key);
    }

    //creates a talk method using the scanner as input
    public void talk(Scanner scanner) {
        //turns the talking boolean to true
        boolean talking = true;

        //print this message at the start of talking
        System.out.println("\n" + name + ": Greetings, lost one.  Why has The Builder brought you to me?");  //me

        //while talking is true
        while (talking) {
            //print this at the start of each talk loop
            System.out.println("\nEnter a topic of conversation the old man may know about, or 'bye' to end the conversation: \n" +
                                    "Suggested: Cave, an item you have, a room you have visited");  //me
            String input = scanner.nextLine().trim().toLowerCase();

            //if the player inputs bye
            if (input.equals("bye")) {
                //print this message
                System.out.println("\n" + name + ": Do not stray too deep, lost one.  There are things...\n" +
                                                    "*the old man shudders and his focus becomes pained and distant*\n" +
                                                    "...things older than even The Builder Himself in these caverns.");  //me

                //Pause for player to read message
                System.out.println("\n[Press Enter to Continue]");
                scanner.nextLine();

                //set talking to false to leave loop
                talking = false;
            
            //if the input matches a dialogue key
            } else if (dialogueOptions.containsKey(input)) {
                //print the dialogue
                System.out.println("\nThe " + name + " says: " + dialogueOptions.get(input));
            }else {
                //if input does not match anything, print this message
                System.out.println("\nThe " + name + " narrows his eyes and cocks his head in confusion. 'I do not understand what you mean by '" + input + "'.");  //me
            }
        }
    } 
}