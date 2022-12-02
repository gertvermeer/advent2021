package Day9;

import Advent2021.Day9.Day9a;
import Advent2021.Day9.Day9b;
import org.junit.jupiter.api.Test;

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