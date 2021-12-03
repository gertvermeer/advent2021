package Day2;

import org.junit.jupiter.api.Test;

class Day2Test {

    @Test
    void executeDay2a() {

        Day2a day2 = new Day2a();

        System.out.println(day2.executeDay2a("input2a-dev.txt"));

        System.out.println(day2.executeDay2a("input2a.txt"));

    }

    @Test
    void executeDay2b() {

        Day2b day2 = new Day2b();

        System.out.println(day2.executeDay2b("input2a-dev.txt"));

        System.out.println(day2.executeDay2b("input2a.txt"));

    }
}