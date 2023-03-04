package OOP;

// Abstract classes can also implement interfaces
public abstract class ShapeBase implements InterfaceShape {
    private int offset;

    public ShapeBase() {
        this.offset = 0;
    }
    public ShapeBase(int theOffset) {
        this.offset = theOffset;
    }

    @Override
    public int getOffset() {
        return this.offset;
    }
    @Override
    public void setOffset(int newOffset) {
        this.offset = newOffset;
    }

    @Override
    public void drawAt(int lineNumber) {
        for(int count = 0; count <lineNumber; count++)
            System.out.println( );
        drawHere();
    }
    @Override
    public abstract void drawHere();
}
