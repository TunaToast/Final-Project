


/* * Boilerplate structure generated with assistance from ChatGPT (OpenAI). 
* Adapted and completed by James McKean. 
* All game content, algorithms, map layout, descriptions, and logic 
* were created by me. */


import java.util.Scanner;


//TODO: Use comments to clearly denotate what sections of code do what.
public class Game {

    private boolean finalDoorOpen = false;
    private boolean barrenDoorOpen = false;
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
        initOldMan();
        createItems();
        placeItems();
        createWorldMap();

        player = new Player(rooms.get("Start"));  // Starting room

        //Starting message
        System.out.println("Welcome to Into The Deep!");  //me
        System.out.println("You wake to find yourself at the bottom of a deep hole, your rope having snapped in your attempt at a gentle descent.");  //me
        System.out.println("Tracking your sister's captors has lead you to this cave system beneath a remote seaside village.");  //me
        System.out.println("Taking a moment to get your bearings, you find yourself before the mouth of a dark system of caverns.");  //me
        System.out.println("Gazing one final time up into the darkness above, the sheer rock walls deny any hope of going anywhere but forward.");  //me
        System.out.println("With this realization, you gather your courage and step into the cavern ahead of you.");  //me

        System.out.println("\n[Press Enter to Start]");
        
        //Pause for input to allow reading of welcome message
        new Scanner(System.in).nextLine();


        gameLoop();
    }

    private void createRooms() {
        //TODO: Create room objects here
        // Example:
        // rooms.put("Damp Cave", new Room("Damp Cave", "A dark, damp cave with dripping water."));

        rooms.put("Start", new Room("Hole Bottom", "You are at the bottom of a deep hole.\nThe walls are steep and smooth, and you find yourself unable to find enough purchase to attempt climbing.\nThough, with the entrance of the hole out of sight, that would probably be a very dangerous idea.\nThe only way to go is forward, suspiciously lit by a single torch.\nThere are exits to the east and west."));  //me
        rooms.put("East of Start", new Room("East tunnel", "You are in a narrow tunnel that leads to a passage to the North, the walls surprisingly smooth.\nThere are exits to the west and north."));  //me
        rooms.put("West of Start", new Room("West tunnel", "You are in a narrow tunnel that leads to a passage to the North, the walls surprisingly smooth.\nThere is a decayed skeleton clutching an item laying with its back to the left wall and a gentle light emanates from the northern exit.\nThere are exits to the east and north."));  //me
        rooms.put("Center West Room", new Room("Old Man's Room", "You find yourself in a small chamber, with a dim lantern just barely illuminating a bedroll against the east wall as well as the room itself.\nYou can just make out the nearly skeletal form of an old man huddled in prayer before a crude statue, time having long worn away its features.\nThere are exits to the north, east, and south."));  //me
        rooms.put("Central Room", new Room("Collapsed Chamber", "You are in what was once a large chamber, now partially collapsed.\nRubble cuts off a substantial portion of the room, but there is still enough room allow passing through.  In the middle of what is accessible, there is a dais with strange runes carved into its surface.\nA flat stone carving of something you can't quite make out is sitting on its pedestal, its silhouette strange and unfamiliar.\nThere are exits to the east and west."));  //me
        rooms.put("Center East Room", new Room("Barren Room", "You find yourself in a small, barren cavern.\nRough rock walls surround you, with little of interest to be found in the room.\nAs you look closer at the walls, there is a single cutout of some strange silhouette etched into the north wall.\nThere are exits to the east, west, and south.\nA faint draft emanates from the north wall."));  //me
        rooms.put("Central Far East Room", new Room("Abandoned Expansion",  "You find yourself in a small, abandoned expansion of the cave system.\nPickaxe marks scar the walls, rubble piles dot areas against the far wall, and two chairs and a barrel with a lantern long gone out sit against the wall just inside the entrance.\nLooking closer, a rusty pickaxe is leaned up against one of the chairs.\nThere is an exit to the west."));  //me
        rooms.put("North of Old Man's Room", new Room("Collapsed Sleeping Chamber", "You find yourself in a small chamber seemingly used for sleeping in a time long past.\nBunks line each visible wall, both in various states of ruin.\nRubble cuts off access from the far wall.\nOn closer inspection, a long loop of rope is wound upon a hook near the entryway that may come in handy.\nThere is an exit to the south."));  //me
        rooms.put("North of Barren Room", new Room("Ritual Chamber", "You find yourself in a large chamber, the walls covered in strange runes, symbols, and apparent figures of worship.\nAs you attempt to examine them, a sharp pain starts to form deep in your skull.\nYou are unable to focus on any of the figures, and many of the runes, as your eyes seem to pull your vision away of their own accord.\nIt is almost as if your brain is trying to save you from something horrible were you to fully comprehend their form or meaning.\nA locked door is set into the western wall, with an exit to the south."));  //me
        rooms.put("Final Room", new Room("Room with a Pit", "You find yourself in a small chamber with the mouth of a seemingly bottomless pit in the center.\nThe only exit is through the door you entered through.\nYou listen carefully and swear you can hear the sound of labored breathing and the faint sound of crashing waves coming from the depths of the pit.\nUnfortunately, there is no other way forward other than to brave the pit.\nThere is an exit to the east."));  //me
        rooms.put("The End", new Room("Final Cutscene", "You secure the rope and slide down into the suffocating darkness.\nAs you descend, you notice countless yellow eyes reflecting what little light filters through the pit opening.\nThe air smells of the sea and some acrid odor you can't place, but which burns your eyes and runs your nose as your lungs fight for breath.\nOverwhelmed, you double over gagging and fighting for every gasp.\nAs your vision starts to swim, you can just make out thick black tendrils worming their way towards you.\nRiddled with numerous eyes, one particularly thick tentacle reaches near to your leg and seems to size you up.\nIn an instant, the tentacle splits apart down its length with a sickly smack.\nInnumerable needle like teeth shimmer in the dim light as it rears back.\nJust before unconsciousness takes you, the tentacle engulfs your legs, latching on and dragging your helpless form into the darkness.\nAn unearthly, unnaturally deep shriek echoes through the chamber as your vision goes dark"));
        
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

        rooms.get("Start").setExit("East", rooms.get("East of Start"));  //me
        rooms.get("Start").setExit("West", rooms.get("West of Start"));  //me

        rooms.get("East of Start").setExit("West", rooms.get("Start"));  //me
        rooms.get("East of Start").setExit("North", rooms.get("Center East Room"));  //me
        rooms.get("West of Start").setExit("East", rooms.get("Start"));  //me
        rooms.get("West of Start").setExit("North", rooms.get("Center West Room"));  //me

        rooms.get("Center West Room").setExit("South", rooms.get("West of Start"));  //me
        rooms.get("Center West Room").setExit("East", rooms.get("Central Room"));  //me
        rooms.get("Center West Room").setExit("North", rooms.get("North of Old Man's Room"));  //me

        rooms.get("North of Old Man's Room").setExit("South", rooms.get("Center West Room"));  //me

        rooms.get("Central Room").setExit("West", rooms.get("Center West Room"));  //me
        rooms.get("Central Room").setExit("East", rooms.get("Center East Room"));  //me

        rooms.get("Center East Room").setExit("West", rooms.get("Central Room"));  //me
        rooms.get("Center East Room").setExit("South", rooms.get("East of Start"));  //me
        rooms.get("Center East Room").setExit("East", rooms.get("Central Far East Room"));  //me
        rooms.get("Center East Room").setExit("North", rooms.get("North of Barren Room"));

        rooms.get("Central Far East Room").setExit("West", rooms.get("Center East Room"));  //me

        rooms.get("North of Barren Room").setExit("South", rooms.get("Center East Room"));  //me
        rooms.get("North of Barren Room").setExit("West", rooms.get("Final Room"));  //me

        rooms.get("Final Room").setExit("East", rooms.get("North of Barren Room"));  //me
        rooms.get("Final Room").setExit("Down", rooms.get("The End")); //me


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

                    //Pause for player to read message
                    System.out.println("\n[Press Enter to Continue]");
                    new Scanner(System.in).nextLine();

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

                //Checks that the player has provided an item name target with the take command
                //If not, prompts with a question to remind user of syntax
                if (parts.length < 2) {
                    System.out.println("Take what?");

                    //Pause for 
                    //player to read message
                    System.out.println("\n[Press Enter to Continue]");
                    new Scanner(System.in).nextLine();

                    //returns true to keep gameLoop running
                    return true;
                }
                //Stores the part of the command at index 1 into the string variable itemName
                //itemName then has any white space trimmed off for accurate comparison later
                String itemName = parts[1];
                itemName = itemName.trim();
                
                //fetches the players current room position and stores it in the room variable currentRoom
                Room currentRoom = player.getCurrentRoom();

                //sets itemToTake to null
                Item itemToTake = null;

                //i is set to 0
                //for as long as i is less than the size of the referenced array list
                for(int i = 0 ; i < currentRoom.getItems().size() ; i++) {
                    //creates Item variable item and defines it as the Items array list object at index i
                    Item item = currentRoom.getItems().get(i);
                    //if the item returned matches the value stored in the itemName variable
                    if (item.getName().equalsIgnoreCase(itemName)) {
                        //access the player's inventory and add the item
                        player.getInventory().add(item);
                        //access the items currently in the room and remove the item from index i
                        currentRoom.getItems().remove(i);
                        
                        //Message to provide feedback for action
                        System.out.println("You put the " + item.getName() + " in your satchel.");
                        
                        //Pause for player to read message
                        System.out.println("\n[Press Enter to Continue]");
                        new Scanner(System.in).nextLine();

                        //sets itemToTake variable to the value of item
                        itemToTake = item;
                        //stops loop
                        break;
                    }
                }
                //if the array list is iterated through completely without itemToTake being assigned other than null
                if(itemToTake == null) {
                    //feedback to indicate item is not available to take
                    System.out.println("The item [" + itemName + "] is not here");

                    //Pause for player to read message
                    System.out.println("\n[Press Enter to Continue]");
                    new Scanner(System.in).nextLine();
                }
                //returns true to keep gameLoop running
                return true;

            //case "drop":
                //TODO: Implement drop item logic
                //I have decided against this
                //return true;

            case "talk":
                //TODO: Implement talk logic
                return true;

            case "inventory":
                showInventory();

                //Pause for player to read message
                System.out.println("\n[Press Enter to Continue]");
                new Scanner(System.in).nextLine();

                return true;

            case "quit":
                System.out.println("You abandon your pursuit and allow desperation to overtake you.\nDeep withinthe labyrinthine caves there is no hope of escape.\nAs your mind unravels, the darkness consumes you.\nYour sister is never found.\nGame over.");  //me
                
                //Pause for player to read message
                System.out.println("\n[Press Enter to Continue]");
                new Scanner(System.in).nextLine();
                
                return false;
            
            default:
                System.out.println("I am unable to decipher what you mean.");
                return true;
        }
    }

    private void move(String direction) {
        
        //Retrieves player's current room location
        Room current = player.getCurrentRoom();
        
        //if the name of the current room matches "Barren Room" AND the player tries to go North (with the case ignored)
        if(current.getName().equals("Barren Room") && direction.equalsIgnoreCase("north")) {
            // The linear search method hasCarving is called and returns a boolean depending on whether "Stone Carving" is found in the player's inventory
            boolean hasCarving = ItemSearches.haveStoneCarving(player.getInventory(), "Stone Carving");
            //Checking the negative case first, if the boolean returns false print a message and stop movement with the "return" command
            if (!hasCarving) {
                System.out.println("You push against the rough stone comprising the wall unable to find any seams.\nYou notice an indentation with an alien silhouette carved into the rock off to one side, as if something needs to be inserted.\nWithout anything to place there, the wall blocks your way."); //me
                
                //Pause for player to read message
                System.out.println("\n[Press Enter to Continue]");
                new Scanner(System.in).nextLine();

                return;  //stops movement
              
              
                //Anything else is the positive case, and if barrenDoorOpen is not true it prints a message for the door opening and then sets the door's open boolean to true
            } else {
                if (!barrenDoorOpen) {
                    System.out.println("A feeling of dread washes over you, causing you to momentarily hesitate from placing the carving in the cutout.\nAs you complete the placement of the carving, you hear a click from some hidden mechanism and the wall swings open.\nEthereal light fills the entryway from deeper within this hidden chamber.\nThe dread felt moments ago drains and is replaced by acute curiosity as you cross the threshold."); //me
                    
                    //Pause for player to read message
                    System.out.println("\n[Press Enter to Continue]");
                    new Scanner(System.in).nextLine();
                    
                    barrenDoorOpen = true;
                }
            }

        }

        //if the name of the current room matches "Ritual Chamber" AND the player tries to go west
        if(current.getName().equals("Ritual Chamber") && direction.equalsIgnoreCase("west")) {

            boolean hasKey = ItemSearches.haveKey(player.getInventory(), "Key");
            if (!hasKey) {
                System.out.println("You approach the door and, as you try the handle, a shimmering barrier of energy springs to life.\nUnable to react in time, as your hand contacts the barrier, a sharp pain shoots up your arm followed by a pins and needles as your arm temporarily goes numb.\nWithout the proper key, there is no way through this door."); //me
                
                //Pause for player to read message
                System.out.println("\n[Press Enter to Continue]");
                new Scanner(System.in).nextLine();

                return;  //stops movement
            } else {
                if (!finalDoorOpen) {
                    System.out.println("With no small amount of effort, you push the key through the surrounding barrier and into the lock.\nAs the lock actuates, the runes and patterns flash a bright green from top to bottom before fading away, smoke rising from where the etchings on the key once were.\nThe barrier sputters and fades away as the latch emits a satisfying click.\nYou push the door open, the darkness of the next chamber seeming to swallow all light around it."); //me
                    finalDoorOpen = true;

                    //Pause for player to read message
                    System.out.println("\n[Press Enter to Continue]");
                    new Scanner(System.in).nextLine();
                }
            }
        }
    

        Room next = current.getExit(direction);
        
        if (next == null) {
            System.out.println("There is no exit in that direction.");

            //Pause for player to read message
            System.out.println("\n[Press Enter to Continue]");
            new Scanner(System.in).nextLine();

        } else {
            player.setCurrentRoom(next);
        }
    
    }

    private void showExits(Room room) {
        System.out.print("Exits: ");
        for (String dir : room.getExitDirections()) {
            String cap = dir.substring(0,1).toUpperCase() + dir.substring(1).toLowerCase();
            System.out.print(cap + " ");
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
    
    //Field for the NPC
    private Old_Man oldMan;

    private void initOldMan() {
        oldMan = new Old_Man("Old Man");
        oldMan.addDialogue("Cave", "Be wary as these caverns have existed for far longer than is apparent and house things lost to even The Builder's memory.  You are outside of his sight while here and, by extension, beyond his protection and graces.");
        oldMan.addDialogue("Rope", "That rope was used to lower the chosen few to have audience with our lord in a time long past. *his fingers linger on one particular frayed end of the rope that is oddly stained and his face darkens*  I do not wish to speak further about this.");
        oldMan.addDialogue("Stone Carving", "Ah, you have found our artisan's representation of our lord's beautiful and majestic countenance.  It is a shame it is but a useless lump of rock now, leaving you unable to experience the depth of his exquisite form.  It will still perform its function, however.");
        //TODO: Add More Dialogue
    }
    
}
