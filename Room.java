

/*
 * Boilerplate structure generated with assistance from ChatGPT (OpenAI).
 * Adapted and completed by <Your Name>.
 * All game content, algorithms, map layout, descriptions, and logic 
 * were created by me.
 */


//TODO: Use comments to clearly denotate what sections of code do what.
public class Room {
    private String name;
    private String description;

    // Creates a hash map to store exit directions that are mapped to the room objects they lead to
    private java.util.HashMap<String, Room> exits = new java.util.HashMap<>();

    // Items currently stored in this room are added to the ArrayList called items
    private java.util.ArrayList<Item> items = new java.util.ArrayList<>();

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
    public java.util.Set<String> getExitDirections() {
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
    public java.util.List<Item> getItems() {
        return items;
    }

}
    
