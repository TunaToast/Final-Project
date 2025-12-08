/*
*Name: James McKean
*Date: 12/4/25
*Assignment: Final Programming Project
*CPSC-39-12705 (Fall 2025)
*Professor Kanemoto
*/

//ItemSearches.java

import java.util.ArrayList;

//ChatGPT assisted only with syntax/structural guidance — algorithm logic and implementation written by me.

public class ItemSearches {
   
  //Create a boolean check to see if the player has the carved stone in their inventory
  public static boolean haveStoneCarving (ArrayList<Item> inventory, String itemName) {
    // Loop through the inventory to check for the item, ArrayLists use .size() instead of .length
    for (int i = 0; i < inventory.size(); i++) {
        //To fetch a specific item from ArrayList inventory, use .get(index)
        //Then use .getName() to retrieve the name of the item
        //Then use the comparison method .equalsIgnoreCase() to compare item names
        if (inventory.get(i).getName().equalsIgnoreCase(itemName)) {
            //if found, return the boolean true
            return true;
        }
    }
    //if not found, return the boolean false
    return false;

  }  //End of haveStoneCarving method

  //Create a two part method to first sort, then binary search the inventory for the key
  public static boolean haveKey (ArrayList<Item> inventory, String itemName) {
    //First, sort the inventory using bubble sort
    //Create a nested loop to compare each item in the inventory
    //Outer loop moves through each item
    boolean alreadySorted = true;
    for (int i = 0; i < inventory.size() - 1 && alreadySorted; i++) {
        alreadySorted = false;
        //Inner loop compares the current item with the next item
        for (int j = 0; j < inventory.size() - i - 1; j++) {
            //Retrieve item at index j and compare to item at index j+1
            //Compare item name ASCII values using compareToIgnoreCase() to avoid case affecting comparison
            //If current item name value is greater than the next and greater than 0, swap them
            if (inventory.get(j).getName().compareToIgnoreCase(inventory.get(j+1).getName()) > 0) {
                alreadySorted = true;
                //Create a temporary variable to hold one of the items during the swap
                Item temp = inventory.get(j);
                //Set item at index j to item at index j+1
                inventory.set(j, inventory.get(j + 1));
                //Set the item at index j + 1 to the temp variable
                inventory.set(j + 1, temp);
            }  //End of if statement
        
        } // End of inner loop
    
    } //End of bubble sort

    //Next, perform binary search on the sorted inventory
        //create left and right starting indexes
        int left = 0;
        int right = inventory.size() - 1;
        //While the left index is less or equal to the right index
        while (left <= right) {
            //Find middle index value
            int mid = left + (right - left) / 2;
            //Compare the middle item name to the target item name
            int comparison = inventory.get(mid).getName().compareToIgnoreCase(itemName);
            //if comparison is 0, the item has been found
            if (comparison == 0) {
                return true;
            //If comparison is less than 0, search the right half
            } else if (comparison < 0) {
                left = mid + 1;
            //If comparison is greater than 0, search the left half
            } else {
                right = mid - 1;
            
            }
            
        }
        //False is returned if the item is not found
        return false;
    
    }  //End of haveKey method

    //create a recursive inventory search
    public static boolean haveRope (ArrayList<Item> inventory, String itemName, int index) {
        //If all items checked, return false
        if (index >= inventory.size()) {
            return false;
        }

        //If item currently checked matches, return true
        if (inventory.get(index).getName().equalsIgnoreCase(itemName)) {
            return true;
        }

        //Recursive call for three field haveRope to increase the index
        return haveRope (inventory, itemName, index + 1);
    
    }  //end of three field haveRope method

    //creates a haveRope method with two fields instead of three
    public static boolean haveRope(ArrayList<Item> inventory, String itemName) {
        //allows for the use of the two fields by assigning the index as zero
        return haveRope (inventory, itemName, 0);
    
    }  //end of two field haveRope method

}
    


