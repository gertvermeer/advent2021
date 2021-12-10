package Day9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day9aTest {

    @Test
    void execute() {

        Day9a day9 = new Day9a();

        System.out.println(day9.execute("9a-dev"));
        System.out.println(day9.execute("9a"));

    }

    @Test
    void execute1() {

        Day9b day9 = new Day9b();

        System.out.println(day9.execute("9a-dev"));
        System.out.println(day9.execute("9a"));

    }
}