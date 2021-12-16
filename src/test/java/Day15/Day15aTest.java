package Day15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day15aTest {

    @Test
    void execute() {
        Day15a day = new Day15a();
        System.out.println(day.execute("15-dev"));
    }

    @Test
    void execute1() {
        Day15a day = new Day15a();
        System.out.println(day.execute("15"));
    }

    @Test
    void executeb() {
        Day15b day = new Day15b();
        System.out.println(day.execute("15-dev"));
    }

    @Test
    void execute1b() {
        Day15b day = new Day15b();
        System.out.println(day.execute("15"));
    }



}