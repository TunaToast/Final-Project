


/* * Boilerplate structure generated with assistance from ChatGPT (OpenAI). 
* Adapted and completed by James McKean. 
* All game content, algorithms, map layout, descriptions, and logic 
* were created by me. */


import java.util.Scanner;


//TODO: Use comments to clearly denotate what sections of code do what.
public class Game {

    private Player player;
    private CommandParser parser = new CommandParser();

    // Stores all rooms created in the HashMap rooms indexed by their names
    private java.util.HashMap<String, Room> rooms = new java.util.HashMap<>();

    public static void main(String[] args) {
        new Game().start();
    }

    public void start() {
        createRooms();
        createItems();
        placeItems();
        createWorldMap();

        player = new Player(rooms.get("Damp Cave"));

        System.out.println("Welcome to Into The Deep!");
        System.out.println("You wake to find yourself at the bottom of a deep hole, your rope having snapped in your attempt at a gentle descent.");
        System.out.println("Tracking your sister's captors has lead you to this cave system beneath a remote seaside village.");
        System.out.println("Taking a moment to get your bearings, you find yourself before the mouth of a dark system of caverns.");
        System.out.println("Gazing one final time up into the darkness above, the sheer rock walls deny any hope of going anywhere but forward.");
        System.out.println("With this realization, you gather your courage and step into the cavern ahead of you.");

        gameLoop();
    }

    private void createRooms() {
        //TODO: Create room objects here
        // Example:
        // rooms.put("Damp Cave", new Room("Damp Cave", "A dark, damp cave with dripping water."));
    }

    private void createItems() {
        //TODO: Implement items here
        // Example:
        // items.put("Rope", new Item("Rope", "A sturdy rope, useful for climbing."));
    }

    private void placeItems() {
        //TODO: Implement item placement logic
        // Place items in rooms as needed
        // Example:
        //  reference a room from the rooms HashMap
        //  Room DampCave = rooms.get("Damp Cave");
        //
        //  reference an item from the items HashMap
        // Item torch = new Item("Torch", "A wooden torch to light your way.");
        //
        // Place the item in the room
        //startingCave.addItem(torch);
    }

    private void createWorldMap() {
        //TODO: Implement world map creation logic
        //Define room connections here
        //Example:
        // rooms.get("Damp Cave").setExit("north", rooms.get("Dark Tunnel"));
    }

    private void gameLoop() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            Room room = player.getCurrentRoom();
            System.out.println("\n== " + room.getName() + " ==");
            System.out.println(room.getDescription());

            showExits(room);
            showRoomItems(room);

            System.out.print("> ");
            String input = scanner.nextLine();
            running = handleCommand(input);
        }
        // Close the scanner to avoid resource leaks
        scanner.close();
    }

    private boolean handleCommand(String input) {
        String[] parts = parser.parse(input);

        if (parts.length == 0) {
            return true;
        }

        String command = parts[0];

        switch (command) {

            case "go":
                if (parts.length < 2) {
                    System.out.println("Go where?");
                } else {
                    move(parts[1]);
                }
                return true;
            
            case "look":
                //Refresh description
                System.out.println(player.getCurrentRoom().getDescription());
                return true;

            case "take":
                //TODO: Implement take item logic
                return true;

            case "drop":
                //TODO: Implement drop item logic
                return true;

            case "talk":
                //TODO: Implement talk logic
                return true;

            case "inventory":
                showInventory();
                return true;

            case "quit":
                System.out.println("You abandon your pursuit and allow desperation to overtake you deep in the labyrinthine caves with no hope of escape. Game over.");
                return false;
            
            default:
                System.out.println("I am unable to decipher what you mean.");
                return true;
        }
    }

    private void move(String direction) {
        Room next = player.getCurrentRoom().getExit(direction);

        if (next == null) {
            System.out.println("There is no exit in that direction.");
        } else {
            player.setCurrentRoom(next);
        }
    
    }

    private void showExits(Room room) {
        System.out.print("Exits: ");
        for (String dir : room.getExitDirections()) {
            System.out.print(dir + " ");
        }      
        System.out.println();
    }

    private void showRoomItems(Room room) {
        if (room.getItems().isEmpty()) {
            return;
        }

        System.out.print("You see: ");
        for (Item i : room.getItems()) {
            System.out.print(i.getName() + " ");
        }
        System.out.println();
    }

    private void showInventory() {
        System.out.print("Your backpack contains: ");
        for (Item i : player.getInventory()) {
            System.out.print(i.getName() + " ");
        }
        System.out.println();
    }
    
    
}
