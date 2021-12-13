package Day11;

import Utils.Utils;

import java.util.Arrays;
import java.util.List;

public class Day11a extends Utils {


    int xMax;
    int yMax;
    int[][] array;

    public Long execute(String filename) {
        long lights = 0;

        List<String> inputList = readfile(filename);
        xMax = inputList.get(0).length();
        yMax = inputList.size();
        array = new int[xMax][yMax];

        for (int y = 0; y < yMax; y++) {
            String row = inputList.get(y);
            for (int x = 0; x < xMax; x++) {
                array[x][y] = Character.getNumericValue(row.charAt(x));
            }
        }

        for (int turn= 1; turn <=100;turn++){
            lights = lights +cycle();
            System.out.println("After step:" + turn);
        }
        printGrid();
        return lights;
    }

    public long cycle(){
        long num = 0;
        // step 1
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                array[x][y] = array[x][y]+1;
            }
        }
        // step 2
        while(newfire()){
            processFire();
        }
        num = num+resetLight();
        return num;
    }


    public void processFire(){
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                if(array[x][y] > 9){
                    for(int ym = Math.max((y-1),0) ; ym< Math.min(yMax, y+2) ; ym++){
                        for(int xm = Math.max((x-1),0); xm< Math.min(xMax, x+2); xm++){
                            if(x==xm && y == ym){
                                array[xm][ym] = -999999999;
                            } else {
                                array[xm][ym] = array[xm][ym]+1;
                            }

                        }
                    }
                }
            }
        }
    }


    public long resetLight(){
        long num = 0L;
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                if(array[x][y] <0) {
                    array[x][y]=0;
                    num++;
                }
            }
        }
        return num;
    }


    public boolean newfire(){
        return Arrays.stream(array).flatMapToInt(x -> Arrays.stream(x)).filter(val -> val>9).count() >0;
    }

    public void printGrid() {
        System.out.printf("prrr");
        System.out.println();
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                System.out.print(array[x][y]);
            }
            System.out.println();
        }
    }
}
