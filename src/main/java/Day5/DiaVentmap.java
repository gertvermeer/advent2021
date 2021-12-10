package Day5;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class DiaVentmap {

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
            return;

        }
        if(xo==xe){
            int from = min(yo,ye);
            int to = max(yo,ye);
            for(int t= from; t<=to;t++){
                hitCell(xo,t);
            }
            return;
        }

        int xfactor = 1;
        int yfactor = 1;
        if(xo>xe){ xfactor = -1;};
        if(yo>ye){ yfactor = -1;};
        int steps = Math.abs(ye-yo);
        int count = 0;
        while (count <= steps){

            hitCell(xo,yo);
            xo = xo + xfactor;
            yo = yo + yfactor;
            count++;


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
        }
        return score;
    }

}
