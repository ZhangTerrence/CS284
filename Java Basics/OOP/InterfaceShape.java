package OOP;

// Interfaces only allow for abstract methods that will be implemented by a subclass. Also cannot be instantiated.
// Subclasses implementing will throw error if not ALL interface methods are implemented.
// Called using "implements"
public interface InterfaceShape {
    /**
     Returns the offset for the shape.
     */
    public int getOffset();
    /**
     Sets the offset for the shape.
     */
    public void setOffset(int newOffset);

    /**
     Draws the shape at lineNumber lines down
     from the current line.
     */
    public void drawAt(int lineNumber);
    /**
     Draws the shape at the current line.
     */
    public void drawHere();
}
