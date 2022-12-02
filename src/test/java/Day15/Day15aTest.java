package Day15;

import Advent2021.Day15.Day15a;
import Advent2021.Day15.Day15b;
import org.junit.jupiter.api.Test;

class Day15aTest {

    @Test
    void execute() {
        Day15a day = new Day15a();
        System.out.println(day.execute("15-dev"));
    }

    @Test
    void execute1() {
        Day15a day = new Day15a();
        System.out.println(day.execute("15"));
    }

    @Test
    void executeb() {
        Day15b day = new Day15b();
        System.out.println(day.execute("15-dev"));
    }

    @Test
    void execute1b() {
        Day15b day = new Day15b();
        System.out.println(day.execute("15"));
    }



}