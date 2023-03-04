package Generics;

public class PairDD {
    private double fst;
    private double snd;

    public PairDD(double fst, double snd) {
        super();
        this.fst = fst;
        this.snd = snd;
    }

    public double getFst() {
        return this.fst;
    }
    public void setFst(double fst) {
        this.fst = fst;
    }
    public double getSnd() {
        return this.snd;
    }
    public void setSnd(double snd) {
        this.snd = snd;
    }

    public String toString() {
        return "<" + this.fst + "," + this.snd + ">";
    }
}
