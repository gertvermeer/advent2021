package Advent2021.Day4;


import Utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {

    Utils utils = new Utils();

    public Integer execute(String filename) {

        List<String> inputList = utils.readfile(filename);

        List<Integer> drwaList = Arrays.asList(inputList.get(0).split(","))
                .stream().map(Integer::parseInt)
                .collect(Collectors.toList());

        List<BingoCard> bingoCardList = new ArrayList<BingoCard>();

        int count = 2;

        while (count < inputList.size()){
            bingoCardList.add(creatBingoCard(inputList.subList(count, count+5)));
            count = count +6;
        }

        for (Integer turn : drwaList){

            System.out.println("NEW DRAW: " + turn);


            for(BingoCard card: bingoCardList){
                System.out.println("draw: " + turn);
                    card.drawNumber(turn);
                    card.printBingo();
                    if(card.Bingo()){
                        System.out.println("BINGO!!!!");
                        return card.returnScore()*turn;
                    }
            }




        }



        return 0;

    }

    private BingoCard creatBingoCard(List<String> input){

        BingoCard bingoCard = new BingoCard();

        for (int yc = 0; yc<5;yc++){

            List<String> tList = Arrays.asList(input.get(yc).trim().split("\\s+"));

            List<Integer> row = Arrays.asList(input.get(yc).trim().split("\\s+"))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            for (int xc = 0; xc<5; xc++){
                bingoCard.setCell(xc,yc, row.get(xc),false);
            }
        }
        return bingoCard;
    }
}
