package practical3.P1;

public abstract class Shape {
    public abstract double area();

    public abstract void readData();

    public void displayArea() {
        System.out.println("Area: " + area());
    }
}
