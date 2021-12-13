package Day13;

import Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Day13a extends Utils {


    int xMax = 0;
    int yMax = 0;
    int[][] array;

    public Long execute(String filename) {
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


        printGrid();


    return 0L;
    }


    private void fold (String dir, Integer value){
        if(dir.equals("y")){



        }
    }

    private void  printGrid(){

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
