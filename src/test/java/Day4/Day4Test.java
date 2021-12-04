package Day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day4Test {

    @Test
    public void testBingoCard(){
        BingoCard bingoCard = new BingoCard();

        bingoCard.setCell(1,1,81,true);
        bingoCard.setCell(1,2,33,true);
        bingoCard.setCell(2,1,12, true);
        bingoCard.setCell(3,3,3,true);

        assertEquals(bingoCard.getCell(1,1),true);
        assertEquals(bingoCard.getCell(3,3),true);

        bingoCard.setCell(1,1,12,false);

        assertEquals(bingoCard.getCell(1,1),false);
        assertEquals(bingoCard.getCell(3,3),true);
    }



    @Test
    void execute() {

        Day4 day4 = new Day4();

        BingoCard bingoCard = new BingoCard();
        System.out.println(day4.execute("input4a.txt"));
    }


    @Test
    void executePart2() {

        Day4b day4b = new Day4b();

//        System.out.println(day4b.execute("input4a-dev.txt"));

        System.out.println(day4b.execute("input4a.txt"));
    }
}