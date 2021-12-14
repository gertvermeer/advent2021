package Day13;

import Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Day13a extends Utils {


    int xMax = 0;
    int yMax = 0;
    int[][] array;

    public Integer execute(String filename) {
        long lights = 0;

        List<String> coordList = new ArrayList<>();
        List<String> foldListDir = new ArrayList<>();
        List<Integer> foldListVal = new ArrayList<>();

        List<String> inputList = readfile(filename);

        int pointer = 0;
        while (!inputList.get(pointer).equals("")) {
            String[] row = inputList.get(pointer).split(",");
            xMax = Math.max(xMax, Integer.parseInt(row[0])+1);
            yMax = Math.max(yMax, Integer.parseInt(row[1])+1);
            pointer++;
        }
        pointer++;
        while (pointer < inputList.size()) {
            String[] row = inputList.get(pointer).split(" ");
            String[] pair = row[2].split("=");
            foldListDir.add(pair[0]);
            foldListVal.add(Integer.parseInt(pair[1]));
            pointer++;
        }
        array = new int[xMax][yMax];
        for(int y = 0; y<yMax; y++){
            for (int x=0 ; x<xMax; x++){
                array[x][y] = 0;
            }
        }
        pointer = 0;
        while (!inputList.get(pointer).equals("")) {
            String[] row = inputList.get(pointer).split(",");
            array[Integer.parseInt(row[0])][Integer.parseInt(row[1])] = 1;
            pointer++;
        }


        //printGrid();
        for(int t = 0; t<foldListDir.size();t++){
            fold(foldListDir.get(t),foldListVal.get(t));
        }
        printGrid();

    return countArray();
    }


    private void fold (String dir, Integer value){
        if(dir.equals("y")){
            for(int yc = value+1; yc<yMax;yc++){
                for(int xc = 0; xc<xMax;xc++){
                    int pr = array[xc][yc-(yc-value+1)];
                    int pra = array[xc][yc];
                    if(array[xc][yc] ==1){
                        array[xc][value-(yc-value)] = array[xc][yc];
                    }
                }
            }
            yMax = value;
        }

        if(dir.equals("x")){
            for(int yc = 0; yc<yMax;yc++){
                for(int xc = value+1; xc<xMax;xc++){
                    if(array[xc][yc] ==1){
                        array[value-(xc-value)][yc] = array[xc][yc];
                    }
                }
            }
            xMax = value;
        }

    }

    private int countArray(){
        int sum = 0;
        for(int y = 0; y<yMax; y++){
            for (int x=0 ; x<xMax; x++){
                if (array[x][y] ==1){
                    sum++;
                }
            }
        }
        return sum;
    }

    private void  printGrid(){
        System.out.println();
        System.out.println("Grid:");
        System.out.println("");
        for(int y = 0; y<yMax; y++){
            for (int x=0 ; x<xMax; x++){
                if (array[x][y] ==1){
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }

    }

}
