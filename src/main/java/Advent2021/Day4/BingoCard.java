package Advent2021.Day4;



import java.util.*;

public class BingoCard {

        Map<Integer, Map<Integer, Boolean>> scoreCard = new HashMap<>();
        Map<Integer, BingoCell> bingoCard = new HashMap<>();


        public boolean getCell(int x, int y){
            return scoreCard.get(x).get(y);
        }


        public void setCell(Integer x, Integer y, Integer value, boolean scored){
            if(scoreCard.containsKey(x)){
                scoreCard.get(x).put(y,scored);
            } else {
                scoreCard.put(x,new HashMap<>());
                scoreCard.get(x).put(y,scored);
            }

            bingoCard.put(value, new BingoCell(x,y));
        }


    public void setCell(Integer x, Integer y, boolean scored){
        if(scoreCard.containsKey(x)){
            scoreCard.get(x).put(y,scored);
        } else {
            scoreCard.put(x,new HashMap<>());
            scoreCard.get(x).put(y,scored);
        }
    }


        public void drawNumber(Integer num){
            if(bingoCard.containsKey(num)){
                setCell(bingoCard.get(num).getX(),bingoCard.get(num).getY(), true);
            }
        }


        public Integer returnScore(){
            Integer sum = 0;
            for(int xc = 0; xc<5;xc++){
                for (int yc =0; yc<5;yc++){
                    if (!getCell(xc,yc)){
                        sum = sum + findValue(xc,yc);

                    }
                }
            }
            return sum;
        }



        public boolean Bingo(){
            // check horizontal
            for(int xc = 0; xc<5;xc++){
                boolean horScore = true;
                boolean verScore = true;
                for (int yc =0; yc<5;yc++){
                    horScore = horScore && getCell(xc,yc);
                    verScore = verScore && getCell(yc,xc);
                }
                if (horScore || verScore){return true;}
            }

            // check vertical
            return false;
        }


    public void printBingo(){
        // check horizontal
        for(int yc = 0; yc<5;yc++){
            for (int xc =0; xc<5;xc++){
                if (getCell(xc,yc)){
                    System.out.print("*");
                };
                System.out.print(findValue(xc,yc)+ " ");
            }
            System.out.println();
        }

        System.out.println();
        // check vertical
    }

    private Integer findValue(int x , int y){
            for (Map.Entry<Integer, BingoCell> entr: bingoCard.entrySet()){
                if(entr.getValue().getX() ==x && entr.getValue().getY() == y){
                    return entr.getKey();
                }
            }
        return -1;
    }



}
