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
 * All game content, algorithms, map layout, descriptions, and logic 
 * were created by me.
 */



// TODO: Use comments to clearly denotate what sections of code do what.

public class Item {

    private String name;
    private String description;

    //Create a constructor for the Item class
    public Item(String name, String description) {
        //delineate the name and description variable from the constructor field parameters
        //use "this." to refer to the class variables vs the constructor parameters
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}