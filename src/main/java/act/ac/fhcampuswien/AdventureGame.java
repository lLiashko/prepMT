package act.ac.fhcampuswien;

import java.util.Scanner;

// Task 6
public class AdventureGame {
    private StoryNode[] storyNodes;
    private int inventoryCount;
    private Item[] inventory;

    private AdventureGame(StoryNode[] storyNodes) {
        this.storyNodes = storyNodes;
        this.inventory = new Item[5];
        this.inventoryCount = 0;
    }

    // Task 7
    public boolean addItemToInventory(Item item) {
        if (inventoryCount <= inventory.length) {
            inventory[inventoryCount] = item;
            inventoryCount++;
            return true;
        } else {
            System.out.println("Inventory is full! You can't carry more items.");
            return false;
        }
    }

    // Task 8
    public void playGame(Scanner scanner) {
        for (int i = 0; i < 5; i++) {
            // 1.
            StoryNode currentStoryNode = storyNodes[i];
            // 2.
            Item currentItem = currentStoryNode.getItem();
            System.out.println(currentStoryNode.getDescription());
            if (!currentStoryNode.hasNext()) {
                // 3. (line 39 only)
                currentStoryNode.getEndingText();
                // 4.
                if (inventory.length != 0) {
                    System.out.println("Your inventory: " + currentItem);
                }
            } else {
                if (currentStoryNode.hasItem()) {
                    System.out.println("You found an item: " + currentItem.getName());
                }
                System.out.println(currentStoryNode.getChoice1());
                System.out.println(currentStoryNode.getChoice2());
                scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                if (choice == 1 && currentStoryNode.hasItem()) {
                    addItemToInventory(currentStoryNode.getItem());
                    if (addItemToInventory(currentStoryNode.getItem())) {
                        System.out.println("Item added to your inventory.");
                    }
                    currentStoryNode = storyNodes[currentStoryNode.getChoice1Index()];
                    System.out.println(currentStoryNode.getDescription());
                } else if (choice == 2 && currentStoryNode.hasItem()) {
                    addItemToInventory(currentStoryNode.getItem());
                    if (addItemToInventory(currentStoryNode.getItem())) {
                        System.out.println("Item added to your inventory.");
                    }
                    currentStoryNode = storyNodes[currentStoryNode.getChoice1Index()];
                    System.out.println(currentStoryNode.getDescription());
                } else {
                    System.out.println("Invalid choice.");
                    System.out.println(currentStoryNode.getDescription());
                }
            }
        }
    }
}
