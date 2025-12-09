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

//Room.java

import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    
    private Old_Man npc;

    // Creates a hash map to store exit directions that are mapped to the room objects they lead to
    private HashMap<String, Room> exits = new HashMap<>();

    // Items currently stored in this room are added to the ArrayList called items
    private ArrayList<Item> items = new ArrayList<>();

    // Constructor for the rooms creating a named room with an associated description
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Set an exit in a given direction
    public void setExit(String direction, Room room) {
        exits.put(direction.toLowerCase(), room);
    }

    // Get the room in a given direction, returning null if there is no exit that way
    public Room getExit(String direction) {
        return exits.get(direction.toLowerCase());
    }

    // Get all available exit directions
    public Set<String> getExitDirections() {
        return exits.keySet();
    }

    // Get the name of the room
    public String getName() { 
        return name; 
    }

    // Get the description of the room
    public String getDescription() { 
        return description;
    }

    // Add an item to the room
    public void addItem(Item item) {
        items.add(item);
    }

    // Removes an item from the room
    public void removeItem(Item item) {
        items.remove(item);
    }

    // Returns a list of all items in the room
    public List<Item> getItems() {
        return items;
    }

    // create a method to set the room's npcs
    public void setNPC(Old_Man npc) {
        this.npc = npc;
    }

    // create a method to return the room's NPC
    public Old_Man getNPC() {
        return npc;
    }

}
    
