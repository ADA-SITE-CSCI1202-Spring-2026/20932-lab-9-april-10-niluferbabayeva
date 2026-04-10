package PW3;

public class Pair<A, B> {

    private A first;
    private B second;

    // Constructor
    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    // Getters
    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    // Setters
    public void setFirst(A first) {
        this.first = first;
    }

    public void setSecond(B second) {
        this.second = second;
    }

    // Check if two pairs are equal (both elements must match)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pair)) return false;

        Pair<?, ?> other = (Pair<?, ?>) obj;   // wildcard: we don't know the types
        return this.first.equals(other.first) && this.second.equals(other.second);
    }

    // Good practice: if you override equals, override hashCode too
    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + second.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    // --- Static factory method (like Map.entry()) ---
    // Lets you write: Pair.of("hello", 42) instead of new Pair<>("hello", 42)
    public static <X, Y> Pair<X, Y> of(X first, Y second) {
        return new Pair<>(first, second);
    }


    // --- Test ---
    public static void main(String[] args) {

        // Basic pair
        Pair<String, Integer> p1 = new Pair<>("Alice", 30);
        System.out.println("Pair 1: " + p1);
        System.out.println("First: " + p1.getFirst());
        System.out.println("Second: " + p1.getSecond());

        // Using factory method
        Pair<Double, Boolean> p2 = Pair.of(3.14, true);
        System.out.println("\nPair 2: " + p2);

        // Same type for both
        Pair<String, String> p3 = Pair.of("hello", "world");
        System.out.println("Pair 3: " + p3);

        // Updating values
        p1.setFirst("Bob");
        p1.setSecond(25);
        System.out.println("\nAfter update: " + p1);

        // Equality check
        Pair<String, Integer> p4 = new Pair<>("Bob", 25);
        System.out.println("\np1.equals(p4): " + p1.equals(p4));   // true

        Pair<String, Integer> p5 = new Pair<>("Bob", 99);
        System.out.println("p1.equals(p5): " + p1.equals(p5));     // false
    }
}
