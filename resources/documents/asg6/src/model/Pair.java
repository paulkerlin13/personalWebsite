package model;

public class Pair<T1, T2> {
    //fields
    public T1 first;
    public T2 second;

    /**
     * Constructor that creates a new Pair instance.
     * @param first
     * @param second
     */
    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }
}
