package Day12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day12aTest {

    @Test
    void execute() {

        Day12a day = new Day12a();
//
//        System.out.println(day.execute("12a-dev"));
//        day = new Day12a();
//        System.out.println(day.execute("12a-dev2"));
//        day = new Day12a();
//        System.out.println(day.execute("12a-dev3"));
        day = new Day12a();
        System.out.println(day.execute("12a"));
    }

    @Test
    void executeb() {

        Day12b day = new Day12b();

        System.out.println(day.execute("12a-dev"));
        day = new Day12b();
        System.out.println(day.execute("12a-dev2"));
        day = new Day12b();
        System.out.println(day.execute("12a-dev3"));
        day = new Day12b();
        System.out.println(day.execute("12a"));
    }


}