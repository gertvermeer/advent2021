package Day14;

import Advent2021.Day14.Day14a;
import Advent2021.Day14.Day14b;
import org.junit.jupiter.api.Test;

class Day14aTest {

    @Test
    void executedev() {

        Day14a day = new Day14a();
        System.out.println(day.execute("14a-dev"));
    }

    @Test
    void executea() {

        Day14a day = new Day14a();
        System.out.println(day.execute("14a"));
    }

    @Test
    void executeb() {

        Day14b day = new Day14b();
        System.out.println(day.execute("14a-dev"));
    }

    @Test
    void executeb2() {

        Day14b day = new Day14b();
        System.out.println(day.execute("14a"));
    }

}