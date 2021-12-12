package Day11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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