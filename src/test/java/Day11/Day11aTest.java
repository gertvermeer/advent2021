package Day11;

import Advent2021.Day11.Day11a;
import Advent2021.Day11.Day11b;
import org.junit.jupiter.api.Test;

class Day11aTest {

    @Test
    void execute() {

        Day11a day = new Day11a();
        //System.out.println(day.execute("11-deva"));

        System.out.println("resultaat: " + day.execute("11-dev"));

        System.out.println("resultaat: " + day.execute("11"));

    }

    @Test
    void executeb() {

        Day11b day = new Day11b();
        //System.out.println(day.execute("11-deva"));

        System.out.println("resultaat: " + day.execute("11-dev"));

        System.out.println("resultaat: " + day.execute("11"));

    }
}