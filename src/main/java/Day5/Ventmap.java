package Day5;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class Ventmap {

    Map<Integer, Map<Integer, Integer>> scoreCard = new HashMap<>();

    int maxx = 0;
    int maxy = 0;


    public void trackRoute(int xo, int yo, int xe, int ye){

        if(yo == ye){
            int from = min(xo,xe);
            int to = max(xo,xe);
            for(int t= from; t<=to; t++){
                hitCell(t,yo);
            }

        }
        if(xo==xe){
            int from = min(yo,ye);
            int to = max(yo,ye);
            for(int t= from; t<=to;t++){
                hitCell(xo,t);
            }

        }
    }


    private void hitCell(int x , int y){
        maxx = max(maxx,x);
        maxy = max(maxy,y);
        if(scoreCard.containsKey(x)){
            if (scoreCard.get(x).containsKey(y)){
                scoreCard.get(x).put(y,scoreCard.get(x).get(y)+1 );
            } else {
                scoreCard.get(x).put(y,1);
            }
        } else {
            scoreCard.put(x,new HashMap<>());
            scoreCard.get(x).put(y,1);
        }
    }


    public void printGrid(){
        for(int yc = 0;yc<=maxy;yc++){
            for(int xc=0;xc <=maxx; xc++){
               if (scoreCard.containsKey(xc)){
                   if (scoreCard.get(xc).containsKey(yc)){
                       System.out.print(scoreCard.get(xc).get(yc));
                   } else {
                       System.out.print(".");
                   }
               } else {
                   System.out.print(".");
               }
            }
            System.out.println();
        }

    }

    public Integer determineScore(){
        int score =0;

        for(int yc = 0;yc<=maxy;yc++){
            for(int xc=0;xc <=maxx; xc++){
                if (scoreCard.containsKey(xc)){
                    if (scoreCard.get(xc).containsKey(yc)) {
                        if (scoreCard.get(xc).get(yc) > 1) {
                            score++;
                        }
                    }
                    }
            }
            System.out.println();
        }
        return score;
    }

}
