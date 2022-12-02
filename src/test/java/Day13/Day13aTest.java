package Day13;

import Advent2021.Day13.Day13a;
import org.junit.jupiter.api.Test;

class Day13aTest {

    @Test
    void execute() {

        Day13a day = new Day13a();

        System.out.println(day.execute("13a-dev"));
        day = new Day13a();
        System.out.println(day.execute("13"));
    }
}