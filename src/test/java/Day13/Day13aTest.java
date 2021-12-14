package Day13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day13aTest {

    @Test
    void execute() {

        Day13a day = new Day13a();

        System.out.println(day.execute("13a-dev"));
        day = new Day13a();
        System.out.println(day.execute("13"));
    }
}