

/*
 * Boilerplate structure generated with assistance from ChatGPT (OpenAI).
 * Adapted and completed by .
 * All conversation content, hints, dialogue, and logic were created by me.
 */

//TODO: Use comments to clearly denotate what sections of code do what.

import java.util.Scanner;

public class Old_Man {

    private String name;
    private java.util.HashMap<String, String> dialogueOptions = new java.util.HashMap<>();

    public Old_Man(String name) {
        this.name = name;
        
        // Example: dialogueOptions.put("greet", "Hello there, traveler!");
    }

    public String getName() {
        return name;
    }

    /**
     * Add a dialogue option for the old man
     * @param key The key for the dialogue option
     * @param text The text of the dialogue option
     */
    public void addDialogue(String key, String text) {
        dialogueOptions.put(key, text);
    }

    /**
     * Get the dialogue text for a given key
     * @param key The key for the dialogue option
     * @return The text of the dialogue option, or null if not found
     */

    public String getDialogue(String key) {
        return dialogueOptions.get(key);
    }

    /*
    *Simple conversation loop with the player
    *Expand if needed for branching dialogue
    */
    public void talk() {
        Scanner scanner = new Scanner(System.in);
        boolean talking = true;

        System.out.println("\n" + name + ": Greetings, lost one.  Why has The Builder brought you to me?");  //me

        while (talking) {
            System.out.println("\nEnter a topic of conversation the old man may know about, or 'bye' to end the conversation: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("bye")) {
                System.out.println("\n" + name + ": Do not stray too deep, lost one.  There are things...\n" +
                                                    "*the old man shudders and his focus becomes pained and distant*\n" +
                                                    "...things older than even The Builder Himself in these caverns.");  //me

                //Pause for player to read message
                System.out.println("\n[Press Enter to Continue]");
                new Scanner(System.in).nextLine();

                talking = false;
            } else if (dialogueOptions.containsKey(input)) {
                System.out.println("\nThe " + name + " says: " + dialogueOptions.get(input));
            }else {
                System.out.println("\nThe " + name + " narrows his eyes and cocks his head in confusion. 'I do not understand what you mean by '" + input + "'.");  //me
            }
        }
    } 
}