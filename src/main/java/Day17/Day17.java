package Day17;

import Day16.Pointer;
import Utils.Utils;

import java.util.List;

public class Day17 extends Utils {


    int xstart;
    int ystart;
    int xend;
    int yend;
    int x=0;
    int y=0;
    int xspeed =7;
    int yspeed=2;
    int yMax = 0;

    public long execute(String filename) {

        List<String> inputList = readfile(filename);
        String [] from = inputList.get(0).split(",");
        from[0] = from[0].replace("x=","");
        xstart = Integer.parseInt(from[0].replaceAll("\\.\\..*",""));
        xend = Integer.parseInt(from[0].replaceAll(".*\\.\\.",""));
        from[1] = from[1].replace(" y=-","");
        yend = -Integer.parseInt(from[1].replaceAll("\\.\\..*",""));
        ystart = -Integer.parseInt(from[1].replaceAll(".*\\.\\.\\-",""));


        shoot(7,2);
        System.out.println("YMax: " + yMax);

        x=0;y=0;
        shoot(6,3);
        System.out.println("YMax: " + yMax);

        x=0;y=0;yMax=0;
        shoot(9,0);
        System.out.println("YMax: " + yMax);

        x=0;y=0;yMax=0;
        shoot(17,-4);
        System.out.println("YMax: " + yMax);


        for (int xsp = xstart)







        return 0l;
    }



    private boolean shoot(int xs, int ys){
        x = x+xs;
        y = y+ys;
        while(!missedTarget()){
            xs = xs -1;
            ys = ys -1;
            if(xs <0){
                xs = 0;
            }
            x = x+xs;
            y = y+ys;

            yMax = Math.max(yMax,y);
            if(x>=xstart && x<=xend && y>=yend && y <=ystart){
                System.out.println("hit at: x:" + x + "y: " + y);
                return true;
            }
        }

        return false;

    }


    private boolean missedTarget(){
        if(x>xend || y<yend){
            System.out.println("missed at: x:" + x + "y: " + y);
            return true;
        }

        return false;
    }

}

