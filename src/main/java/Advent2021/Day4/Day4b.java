package Advent2021.Day4;


import Utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4b {

    Utils utils = new Utils();

    public Integer execute(String filename) {

        List<String> inputList = utils.readfile(filename);

        List<Integer> bingoList = new ArrayList<>();

        List<Integer> drwaList = Arrays.asList(inputList.get(0).split(","))
                .stream().map(Integer::parseInt)
                .collect(Collectors.toList());

        List<BingoCard> bingoCardList = new ArrayList<BingoCard>();

        int count = 2;
        int numOfBoards = 0;

        while (count < inputList.size()) {
            bingoCardList.add(creatBingoCard(inputList.subList(count, count + 5)));
            count = count + 6;
            numOfBoards++;
        }

        for (Integer turn : drwaList) {

            System.out.println("NEW DRAW: " + turn);

            int point = 0;
            for (BingoCard card : bingoCardList) {
                if (bingoList.contains(point)){
                    point++;
                    continue;
                }

                System.out.println(bingoList.toString());


                System.out.println("draw: " + turn);
                card.drawNumber(turn);
                card.printBingo();
                if (card.Bingo()) {
                    System.out.println("BINGO!!!!");
                    bingoList.add(point);
                    numOfBoards--;

                    if(numOfBoards==0){
                        return card.returnScore()*turn;
                    }

                }

                point++;
            }


        }


        return 0;

    }

    private BingoCard creatBingoCard(List<String> input) {

        BingoCard bingoCard = new BingoCard();

        for (int yc = 0; yc < 5; yc++) {

            List<String> tList = Arrays.asList(input.get(yc).trim().split("\\s+"));

            List<Integer> row = Arrays.asList(input.get(yc).trim().split("\\s+"))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            for (int xc = 0; xc < 5; xc++) {
                bingoCard.setCell(xc, yc, row.get(xc), false);
            }
        }
        return bingoCard;
    }
}
