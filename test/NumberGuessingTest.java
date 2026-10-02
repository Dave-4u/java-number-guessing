/** Dependency-free tests. Run with ./run.sh test */
public class NumberGuessingTest {
    static int passed = 0;

    static void check(boolean cond, String name) {
        if (!cond) throw new AssertionError("FAILED: " + name);
        System.out.println("  ok - " + name);
        passed++;
    }

    public static void main(String[] args) {
        check(NumberGuessing.check(50, 10) < 0, "low guess is too low");
        check(NumberGuessing.check(50, 90) > 0, "high guess is too high");
        check(NumberGuessing.check(50, 50) == 0, "exact guess is correct");
        check(NumberGuessing.parse(" 42 ") == 42, "parses a number with spaces");
        check(NumberGuessing.parse("abc") == null, "rejects text");
        check(NumberGuessing.parse("0") == null && NumberGuessing.parse("101") == null, "rejects out of range");
        check(NumberGuessing.parse("Q") == Integer.MIN_VALUE, "q quits");
        System.out.println(passed + " tests passed");
    }
}
