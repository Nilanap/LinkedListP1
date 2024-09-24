public class ItemType {
    private int value;

    // Constructor to initialize ItemType with a value
    public ItemType(int value) {
        this.value = value;
    }

    public int compareTo(ItemType item) {
        if (this.value < item.getValue()) {
            return -1;
        } else if (this.value > item.getValue()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getValue() {
        return value;
    }

    // The initialize method is no longer needed, but you can keep it if preferred.
    public void initialize(int num) {
        this.value = num;
    }

    @Override
    public String toString(){
        return Integer.toString(value);
    }
}
