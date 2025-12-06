/*
*Name: James McKean
*Date: 12/4/25
*Assignment: Final Programming Project
*CPSC-39-12705 (Fall 2025)
*Professor Kanemoto
*/

/*
 * Boilerplate structure generated with assistance from ChatGPT (OpenAI).
 * Adapted and completed by .
 * All game content, algorithms, map layout, descriptions, and logic 
 * were created by me.
 */

//TODO: Use comments to clearly denotate what sections of code do what.

import java.util.ArrayList;
public class Player {
    
    private Room currentRoom;

    // Inventory using ArrayList
    private ArrayList<Item> inventory = new ArrayList<>();

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
    }

    
    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }
    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }


}