


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

    // Stores all items created in the Hashmap items indexed by their names
    private java.util.HashMap<String, Item> items = new java.util.HashMap<>();


    public static void main(String[] args) {
        new Game().start();
    }

    public void start() {
        createRooms();
        createItems();
        placeItems();
        createWorldMap();

        player = new Player(rooms.get("Start"));  // Starting room

        System.out.println("Welcome to Into The Deep!");  //me
        System.out.println("You wake to find yourself at the bottom of a deep hole, your rope having snapped in your attempt at a gentle descent.");  //me
        System.out.println("Tracking your sister's captors has lead you to this cave system beneath a remote seaside village.");  //me
        System.out.println("Taking a moment to get your bearings, you find yourself before the mouth of a dark system of caverns.");  //me
        System.out.println("Gazing one final time up into the darkness above, the sheer rock walls deny any hope of going anywhere but forward.");  //me
        System.out.println("With this realization, you gather your courage and step into the cavern ahead of you.");  //me

        gameLoop();
    }

    private void createRooms() {
        //TODO: Create room objects here
        // Example:
        // rooms.put("Damp Cave", new Room("Damp Cave", "A dark, damp cave with dripping water."));

        rooms.put("Start", new Room("Hole Bottom", "You are at the bottom of a deep hole.\nThe walls are steep and smooth, and you find yourself unable to find enough purchase to attempt climbing.\nThough, with the entrance of the hole out of sight, that would probably be a very dangerous idea.\nThe only way to go is forward, suspicously lit by a single torch.\nThere are exits to the east and west."));  //me
        rooms.put("East of Start", new Room("East tunnel", "You are in a narrow tunnel that leads to a passage to the North, the walls surprisingly smooth.\nThere are exits to the west and north."));  //me
        rooms.put("West of Start", new Room("West tunnel", "You are in a narrow tunnel that leads to a passage to the North, the walls surprisingly smooth.\nThere is a decayed skeleton clutching an item laying with its back to the left wall and a gentle light emanates from the northern exit.\nThere are exits to the east and north."));  //me
        rooms.put("Center West Room", new Room("Old Man's Room", "You find yourself in a small chamber, with a dim lantern just barely illuminating a bedroll against the east wall as well as the room itself.\nYou can just make out the nearly skeletal form of an old man huddled in prayer before a crude statue, time having long worn away its features.\nThere are exits to the north, east, and south."));  //me
        rooms.put("Central Room", new Room("Collapsed Chamber", "You are in what was once a large chamber, now partially collapsed.\nRubble cuts off a substantial portion of the room, but there is still enough room allow passing through.  In the middle of what is accessible, there is a dais with strange runes carved into its surface.\nA flat stone carving of something you can't quite make out is sitting on its pedestal, its silhouette strange and unfamiliar.\nThere are exits to the east and west."));  //me
        rooms.put("Center East Room", new Room("Barren Room", "You find yourself in a small, barren cavern.\nRough rock walls surround you, with little of interest to be found in the room.\nAs you look closer at the walls, there is a single cutout of some strange silhouette etched into the north wall.\nThere are exits to the east, west, and south.\nA faint draft emanates from the north wall."));  //me
        rooms.put("Central Far East Room", new Room("Abandoned Expansion",  "You find yourself in a small, abandoned expansion of the cave system.\nPickaxe marks scar the walls, rubble piles dot areas against the far wall, and two chairs and a barrel with a lantern long gone out sit against the wall just inside the entrance.\nLooking closer, a rusty pickaxe is leaned up against one of the chairs.\nThere is an exit to the west."));  //me
        rooms.put("North of Old Man's Room", new Room("Collapsed Sleeping Chamber", "You find yourself in a small chamber seemingly used for sleeping in a time long past.\nBunks line each visible wall, both in various states of ruin.\nRubble cuts off access from the far wall.\nOn closer inspection, a long loop of rope is wound upon a hook near the entryway that may come in handy.\nThere is an exit to the south."));  //me
        rooms.put("North of Barren Room", new Room("Ritual Chamber", "You find yourself in a large chamber, the walls covered in strange runes, symbols, and apparent figures of worship.\nAs you attempt to examine them, a sharp pain starts to form deep in your skull.\nYour are unable to focus on any of the figures, and many of the runes, as your eyes seem to pull your vision away of their own accord.\nIt is almost as if your brain is trying to save you from something horrible were you to fully comprehend their form or meaning.\nA locked door is set into the western wall, with an exit to the south."));  //me
        rooms.put("Final Room", new Room("Room with a Pit", "You find yourself in a small chamber with the mouth of a seemingly bottomless pit in the center.\nThe only exit is through the door you entered through.\nYou listen carefully and swear you can hear the sound of labored breathing and the faint sound of crashing waves coming from the depths of the pit.\nUnfortunately, there is no other way forward other than to brave the pit.\nThere is an exit to the east."));  //me
        
    }

    private void createItems() {
        //TODO: Implement items here
        // Example:
        // items.put("Rope", new Item("Rope", "A sturdy rope, useful for climbing."));

        items.put("Rope", new Item("Rope", "A long length of sturdy rope, useful for climbing."));  //me
        items.put("Torch", new Item("Torch", "A wooden torch, struggling to keep aflame.  Weak, but still providing enough light to see by."));  //me
        items.put("Pickaxe", new Item("Pickaxe", "A rusty pickaxe, useful for breaking through rubble."));  //me
        items.put("Stone Carving", new Item("Stone Carving", "With its features worn away by time and erosion, you are unable to determine what person or creature this carving's silhouette once represented."));  //me
        items.put("Key", new Item("Key", "A small, rusty key though you can see intricate designs and runes etched into its surface that have been worn smooth with use and age."));  //me

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

        Room Start = rooms.get("Start");  //me
        Room WestofStart = rooms.get("West of Start");  //me
        Room CenterWestRoom = rooms.get("Old Man's Room");  //me
        Room CentralRoom = rooms.get("Central Room");  //me
        Room CentralFarEastRoom = rooms.get("Central Far East Room");  //me
        Room NorthofOldMansRoom = rooms.get("North of Old Man's Room");  //me
        
        Item Rope = items.get("Rope");  //me
        Item Torch = items.get("Torch");  //me
        Item Pickaxe = items.get("Pickaxe");  //me
        Item StoneCarving = items.get("Stone Carving");  //me
        Item Key = items.get("Key");  //me

        Start.addItem(Torch);  //me
        NorthofOldMansRoom.addItem(Rope);  //me
        CentralRoom.addItem(StoneCarving);  //me
        CentralFarEastRoom.addItem(Pickaxe);  //me
        WestofStart.addItem(Key);  //me
    }

    private void createWorldMap() {
        //TODO: Implement world map creation logic
        //Define room connections here
        //Example:
        // rooms.get("Damp Cave").setExit("north", rooms.get("Dark Tunnel"));

        rooms.get("Start").setExit("east", rooms.get("East of Start"));  //me
        rooms.get("Start").setExit("west", rooms.get("West of Start"));  //me

        rooms.get("East of Start").setExit("west", rooms.get("Start"));  //me
        rooms.get("East of Start").setExit("north", rooms.get("Center East Room"));  //me
        rooms.get("West of Start").setExit("east", rooms.get("Start"));  //me
        rooms.get("West of Start").setExit("north", rooms.get("Center West Room"));  //me

        rooms.get("Center West Room").setExit("south", rooms.get("West of Start"));  //me
        rooms.get("Center West Room").setExit("east", rooms.get("Central Room"));  //me
        rooms.get("Center West Room").setExit("north", rooms.get("North of Old Man's Room"));  //me

        rooms.get("North of Old Man's Room").setExit("south", rooms.get("Center West Room"));  //me

        rooms.get("Central Room").setExit("west", rooms.get("Center West Room"));  //me
        rooms.get("Central Room").setExit("east", rooms.get("Center East Room"));  //me

        rooms.get("Center East Room").setExit("west", rooms.get("Central Room"));  //me
        rooms.get("Center East Room").setExit("south", rooms.get("East of Start"));  //me
        rooms.get("Center East Room").setExit("east", rooms.get("Central Far East Room"));  //me

        rooms.get("Central Far East Room").setExit("west", rooms.get("Center East Room"));  //me

        rooms.get("North of Barren Room").setExit("south", rooms.get("Center East Room"));  //me
        rooms.get("North of Barren Room").setExit("west", rooms.get("Final Room"));  //me

        rooms.get("Final Room").setExit("east", rooms.get("North of Barren Room"));  //me

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
                System.out.println("You abandon your pursuit and allow desperation to overtake you.\nDeep withinthe labyrinthine caves there is no hope of escape.\nAs your mind unravels, the darkness consumes you.\nYour sister is never found.\nGame over.");  //me
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
