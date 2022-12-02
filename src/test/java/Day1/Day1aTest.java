package Day1;


import Advent2021.Day1.Day1a;
import Advent2021.Day1.Day1b;
import org.junit.jupiter.api.Test;

class Day1aTest {


    @Test
    void executeDay1() {

        Day1a day1a = new Day1a();

        System.out.println(day1a.executeDay1a("input1a-dev.txt"));

        System.out.println(day1a.executeDay1a("input1a.txt"));

    }

    @Test
    void executeDay1b(){
        Day1b day1b = new Day1b();

        System.out.println(day1b.executeDay1("input1a-dev.txt"));

        System.out.println(day1b.executeDay1("input1a.txt"));

    }
}