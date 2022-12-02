package Day8;

import Advent2021.Day8.Day8;
import Advent2021.Day8.Day8e;
import org.junit.jupiter.api.Test;

class Day8Test {

    @Test
    void execute() {
        Day8 day8 = new Day8();
//        System.out.println(day8.execute("8-dev"));
        System.out.println(day8.execute("8"));
    }

    @Test
    void executeb() {
        Day8e day8 = new Day8e();
//        System.out.println(day8.execute("8-dev"));
        System.out.println(day8.execute("8"));
    }

    @Test
    void filterOnlength() {
    }
}