package Generics;

public class Pair<E,F> {
    private E first;
    private F second;

    public Pair(E first, F second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return this.first;
    }
    public F getSecond() {
        return this.second;
    }
}
