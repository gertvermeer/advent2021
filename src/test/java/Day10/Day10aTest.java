package Day10;

import Day9.Day9a;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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