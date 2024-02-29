package model;

public class Node<A> {
    //fields
    public A data;
    public Node<A> next;

    /**
     * Constructor that creates a new Node instance.
     * @param data
     * @param next
     */
    public Node(A data, Node<A> next){
        this.data = data;
        this.next = next;
    }
}
