package Day6;

import Advent2021.Day6.Day6a;
import Advent2021.Day6.Day6b;
import org.junit.jupiter.api.Test;

class Day6aTest {

    @Test
    void execute() {

        Day6a day6 = new Day6a();

        System.out.println(day6.execute("input6a-dev.txt",18));
        System.out.println(day6.execute("input6a-dev.txt",80));


    }

    @Test
    void executeb(){

        Day6b day6b = new Day6b();
        System.out.println();
//        System.out.println(day6b.execute("input6a-dev.txt",256).toString());

        System.out.println(day6b.execute("input6a.txt",256).toString());

    }
}