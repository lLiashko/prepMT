package act.ac.fhcampuswien;

// Task 2
public class StoryNode {
    private String description;
    private String choice1;
    private String choice2;
    private int choice1Index;
    private int choice2Index;
    private boolean hasWon;
    private Item item;

    public StoryNode(String description, String choice1, String choice2, int choice1Index
    , int choice2Index, boolean hasWon) {
        this.description = description;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice1Index = choice1Index;
        this.choice2Index = choice2Index;
        this.hasWon = hasWon;

    }

    public StoryNode(String description, String choice1, String choice2, int choice1Index
    , int choice2Index, boolean hasWon, Item item) {
        this.description = description;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice1Index = choice1Index;
        this.choice2Index = choice2Index;
        this.hasWon = hasWon;
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public String getChoice1() {
        return choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public int getChoice1Index() {
        return choice1Index;
    }

    public int getChoice2Index() {
        return choice2Index;
    }

    public boolean isHasWon() {
        return hasWon;
    }

    public Item getItem() {
        return item;
    }

    // Task 3
    public boolean hasNext() {
        return !(choice1Index < 0 || choice2Index <0);
    }

    // Task 4
    public boolean hasItem() {
        return item != null;
    }

    // Task 5
    public String getEndingText() {
        if (!hasNext() && hasWon) {
            return "You win!";
        } else if (!hasNext() && !hasWon) {
            return "Game over";
        } else if (hasNext()){
            return "Game is not over yet...";
        }
        return "";
    }
}
