package Day5;

import Advent2021.Day5.Day5;
import Advent2021.Day5.Day5b;
import org.junit.jupiter.api.Test;

class Day5Test {

    @Test
    void execute() {

        Day5 day5 = new Day5();

        System.out.println(day5.execute("input5a-dev.txt"));

        System.out.println(day5.execute("input5a.txt"));
    }

    @Test
    void executeDay5b() {

        Day5b day5 = new Day5b();

        System.out.println(day5.execute("input5a-dev.txt"));

        System.out.println(day5.execute("input5a.txt"));
    }
}