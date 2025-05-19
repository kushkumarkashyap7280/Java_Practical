package P2;

import P1.TwoDim;

public class ThreeDim extends TwoDim {
    private double z;

    public ThreeDim() {
        super();
        this.z = 0.0;
    }

    public ThreeDim(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    @Override
    public void display() {
        System.out.println("ThreeDim display method: Coordinates are (" +
                getX() + ", " + getY() + ", " + z + ")");
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }
}
