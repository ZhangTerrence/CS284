package OOP;

// Abstract classes are very similar to normal classes except that they cannot be instantiated and can contain abstract methods.
// Called using "extends"
public abstract class AbstractShape {
    // An abstract class can have variables.
    private String color;

    // While abstract classes can have constructors, they CANNOT be instantiated by new keyboard. Therefore, this can only be called in subclasses.
    public AbstractShape(String color) {
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    // Abstract methods are methods that allow no implementation. Implementation is provided in subclasses.
    public abstract double area();
    public String toString() {
        return "I am a Shape. My color is "+color;
    }
}

