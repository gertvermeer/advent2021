package Day7;

import Advent2021.Day7.Day7;
import Advent2021.Day7.Day7b;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day7Test {

    @Test
    void execute() {
        Day7 day7 = new Day7();
        System.out.println(day7.execute("input7a.txt"));
    }

    @Test
    void executeb() {
        Day7b day7 = new Day7b();
        System.out.println(day7.execute("7a"));
    }


    @Test
    void unitest() {

        Day7b day7 = new Day7b();

        System.out.println(day7.fuel(2));
        int dist = day7.fuel(1);
        assertEquals(1,dist);
        assertEquals(3,day7.fuel(2).intValue() );
        assertEquals(66,day7.fuel(11).intValue() );
    }
}
