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

//Player.java

import java.util.ArrayList;
public class Player {
    
    private Room currentRoom;

    // Create an ArrayList named inventory to keep track of items added or removed
    private ArrayList<Item> inventory = new ArrayList<>();

    // creates a method to the player in the designated starting room
    public Player(Room startRoom) {
        this.currentRoom = startRoom;
    }

    // Method to retrieve the current room
    public Room getCurrentRoom() {
        return currentRoom;
    }
   
    // method to set the room the player is in
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    // method to add items into inventory
    public void addItem(Item item) {
        inventory.add(item);
    }

    // method to remove an item from inventory
    public void removeItem(Item item) {
        inventory.remove(item);
    }

    // a method to return the modifiable inventory ArrayList
    public ArrayList<Item> getInventory() {
        return inventory;
    }


}