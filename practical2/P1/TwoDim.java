package P1;

public class TwoDim {
    private double x;
    private double y;

    public TwoDim() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public TwoDim(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void display() {
        System.out.println("TwoDim display method: Coordinates are (" + x + ", " + y + ")");
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
