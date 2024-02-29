package model;

public class NavigableDocModel<T> {
    //fields
    private Node<T> leftHead;
    private Node<T> rightHead;
    private int countLeft = 0;
    private int countRight = 0;

    /**
     * Constructor that takes no parameters and initializes the nodes to null.
     */
    public NavigableDocModel() {
        this.leftHead = null;
        this.rightHead = null;
    }

    //getter method
    public Node<T> getLeftHead() {
        return leftHead;
    }

    //getter method
    public Node<T> getRightHead() {
        return rightHead;
    }

    public int getCountLeft() {
        return countLeft;
    }

    public int getCountRight() {
        return countRight;
    }

    //Inserts a new item to the front of the right side; O(1)
    public void insertNewItemRt(T item){
        rightHead = new Node<>(item, rightHead);
        //updating the size of right side
        countRight++;
        }

    //Overrides the toString method to return all the nodes in correct format; O(n)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node<T> current = leftHead;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        sb.append("$ ");

        current = rightHead;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }

    //Moves the cursor forward by one position; O(n)
    public void forward(){
        if(rightHead == null){
            throw new IllegalStateException("The right side is empty");
        }
        if(leftHead == null){
            leftHead = new Node<>(rightHead.data, null);
        }
        else {
            Node<T> current = leftHead;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(rightHead.data, null);
        }
        rightHead = rightHead.next;
        //updating the size of each side
        countLeft++;
        countRight--;
    }

    //Moves the cursor back to the front by assigning everything on the left to start of the right; O(n)
    public void reset(){
        //checks if the cursor is already on the far left
        if (leftHead == null) {
            return;
        }
        //creating a current node
        Node<T> current = leftHead;
        //loops so current is at the end of the left side
        while (current.next != null) {
            current = current.next;
        }
        current.next = rightHead;
        rightHead = leftHead;
        leftHead = null;
        //updating the size of each side
        countLeft = 0;
        countRight += countLeft;
    }

    //Returns the number of items before the bar; O(1)
    public int lenBeforeBar() {
        return getCountLeft();
    }

    //Returns the number of items before the bar; O(1)
    public int lenAfterBar() {
        return getCountRight();
    }

    /**
     * Method that will call its helper to look for inputted item
     */
    public Pair<Side, Integer> contains(T item) {
        //Calls helper for the left side
        Pair<Side, Integer> lResult = contains(item, leftHead, 0, Side.LEFT);
        //Calls helper for the right side
        Pair<Side, Integer> rResult = contains(item, rightHead, 0, Side.RIGHT);

        //checks if both sides returned none
        if (lResult.first == Side.NONE && rResult.first == Side.NONE) {
            return new Pair<>(Side.NONE, -1);
        }
        //checks if both sides found the item
        else if (lResult.first != Side.NONE && rResult.first != Side.NONE){
            return new Pair<>(Side.BOTH, lResult.second);
        }
        //checks if the left side found the item
        else if (lResult.first == Side.LEFT) {
            return lResult;
        }
        //checks if the right side found the item
        else if (rResult.first == Side.RIGHT) {
            return rResult;
        }
        //returns that the item didn't appear
        else {
            return new Pair<>(Side.NONE, -1);
        }
    }

    /**
     * Helper method for above method
     * @param item
     * @param current
     * @param index
     * @param side
     * @return
     */
    private Pair<Side, Integer> contains(T item, Node<T> current, int index, Side side) {
        //base case if end of list is reached
        if (current == null) {
            return new Pair<>(Side.NONE, -1);
        }
        //if the item is found it returns the side and index
        if (current.data.equals(item)) {
            return new Pair<>(side, index);
        }
        //recursive case to continue searching
        return contains(item, current.next, index + 1, side);
    }


}

