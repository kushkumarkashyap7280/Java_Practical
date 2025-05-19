package practical1;

public class Complex {
    private double real;
    private double imaginary;
    
    public Complex() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }
    
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    public Complex add(Complex other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new Complex(newReal, newImaginary);
    }
    
    public Complex multiply(Complex other) {
        double newReal = (this.real * other.real) - (this.imaginary * other.imaginary);
        double newImaginary = (this.real * other.imaginary) + (this.imaginary * other.real);
        return new Complex(newReal, newImaginary);
    }
    
    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + Math.abs(imaginary) + "i";
        }
    }
    
    public static void main(String[] args) {
        Complex c1 = new Complex(3.0, 2.0);
        Complex c2 = new Complex(1.0, 4.0);
        
        System.out.println("First complex number: " + c1);
        System.out.println("Second complex number: " + c2);
        
        Complex sum = c1.add(c2);
        System.out.println("Sum: " + sum);
        
        Complex product = c1.multiply(c2);
        System.out.println("Product: " + product);
    }
}
