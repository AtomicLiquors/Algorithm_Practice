public class Example {
    private int instanceVariable;

    public Example() {
        // Assuming instanceVariable is initially 5
        this.instanceVariable = 5;
        int incrementedValue = this.instanceVariable++;
        System.out.println("Assigned value: " + this.instanceVariable);
        System.out.println("Incremented value: " + incrementedValue);
    }

    public static void main(String[] args) {
        new Example();
    }
}