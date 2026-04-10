package EX2;

public class GenericNumeric<T extends Number> {

    private T value;

    // Constructor
    public GenericNumeric(T value) {
        this.value = value;
    }

    // b. Returns the reciprocal: 1 / value
    public double reciprocal() {
        return 1.0 / value.doubleValue();
    }

    // c. Returns the fractional part: e.g. 9.76 -> 0.76
    public double fraction() {
        double d = value.doubleValue();
        return d - (long) d;   // subtract the whole number part
    }

    // d. Checks if absolute values of this and another number are equal
    //    Works across types (e.g. Double and Float)
    public <U extends Number> boolean absEqual(U other) {
        return Math.abs(this.value.doubleValue()) == Math.abs(other.doubleValue());
    }

    // Main method to test everything
    public static void main(String[] args) {

        // --- Test reciprocal ---
        GenericNumeric<Integer> intNum = new GenericNumeric<>(6);
        System.out.println("Reciprocal of 6: " + intNum.reciprocal());       // 0.16666666666666666

        GenericNumeric<Double> dblNum = new GenericNumeric<>(4.5);
        System.out.println("Reciprocal of 4.5: " + dblNum.reciprocal());     // 0.2222222222222222

        // --- Test fraction ---
        GenericNumeric<Double> fracNum = new GenericNumeric<>(3.14);
        System.out.println("Fraction of 3.14: " + fracNum.fraction());       // ~0.14

        GenericNumeric<Float> floatNum = new GenericNumeric<>(8.76f);
        System.out.println("Fraction of 8.76: " + floatNum.fraction());      // ~0.76

        // --- Test absEqual ---
        GenericNumeric<Double> a = new GenericNumeric<>(-3.0);
        Float b = 3.0f;
        System.out.println("absEqual(-3.0, 3.0f): " + a.absEqual(b));        // true

        GenericNumeric<Double> c = new GenericNumeric<>(5.0);
        Integer d = 7;
        System.out.println("absEqual(5.0, 7): " + c.absEqual(d));            // false
    }
}
