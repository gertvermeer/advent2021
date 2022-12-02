package Day10;

import Advent2021.Day10.Day10a;
import Advent2021.Day10.Day10b;
import org.junit.jupiter.api.Test;

class Day10aTest {

    @Test
    void execute() {

        Day10a day9 = new Day10a();

        System.out.println(day9.execute("10"));
        //System.out.println(day9.execute("9a"));

    }

    @Test
    void executeb() {

        Day10b day = new Day10b();

        System.out.println(day.execute("10"));


    }

}