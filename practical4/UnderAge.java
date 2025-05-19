package practical4;

public class UnderAge extends Exception {
    private int age;

    public UnderAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Under Age: " + age;
    }
}
