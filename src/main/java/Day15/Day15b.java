package Day15;

import Utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day15b extends Utils {


    int xMax;
    int yMax;
    int xBlock;
    int yBlock;
    int[][] array;
    int[][] distance;
    String endKey;

    HashMap<String, Long> shortestDistFromStart = new HashMap<>();
    HashMap<String, Long> previousVertex = new HashMap<>();
    List<String> visted = new ArrayList<>();
    List<String> unvisited = new ArrayList<>();




    boolean found = false;

    public long execute(String filename) {
        long lights = 0;

        List<String> inputList = readfile(filename);
        xBlock = inputList.get(0).length();
        xMax =  xBlock* 5;
        yBlock = inputList.size();
        yMax = yBlock *5;

        endKey = (xMax-1) + "," + (yMax-1);

        array = new int[xMax][yMax];
        distance = new int[xMax][yMax];

        for (int y = 0; y < yBlock; y++) {
            String row = inputList.get(y);
            for (int x = 0; x < xBlock; x++) {
               String key = x+","+y;
               shortestDistFromStart.put(key, Long.MAX_VALUE);
               unvisited.add(key);
               array[x][y] = Character.getNumericValue(row.charAt(x));

            }
        }


        for (int xb = 1; xb<5;xb++){
            for (int y = 0; y < yBlock; y++) {
                for (int x = 0; x < xBlock; x++) {
                    int xt = xb*xBlock+x;
                    int xo = (xb-1)*xBlock+x;
                    String key = xt+","+y;
                    shortestDistFromStart.put(key, Long.MAX_VALUE);
                    unvisited.add(key);
                    array[xt][y] = array[xo][y]+1;
                    if (array[xt][y] > 9){
                        array[xt][y] = 1;
                    }
                }
            }
        }

        for (int yb = 1; yb<5;yb++){
            for (int y = 0; y < yBlock; y++) {
                for (int x = 0; x < xMax; x++) {
                    int yt = yb*xBlock+y;
                    int yo = (yb-1)*yBlock+y;
                    String key = x+","+yt;
                    shortestDistFromStart.put(key, Long.MAX_VALUE);
                    unvisited.add(key);
                    array[x][yt] = array[x][yo]+1;
                    if (array[x][yt] > 9){
                        array[x][yt] = 1;
                    }
                }
            }
        }

        long starttime = System.currentTimeMillis();


        shortestDistFromStart.put("0,0",0L);


        while (unvisited.size()!=0){


            String smallesDistance = findSmallestDistance();
            int x  = Integer.parseInt(List.of(smallesDistance.split(",")).get(0));
            int y  = Integer.parseInt(List.of(smallesDistance.split(",")).get(1));

            if(visted.contains(endKey)){
                return shortestDistFromStart.get(endKey);
            }

            long distance =shortestDistFromStart.get(smallesDistance);
            if(x+1<xMax){
                calcDistance((x+1)+","+y,array[x+1][y]+distance);
            }
            if(y+1<yMax){
                calcDistance(x+"," +(y+1),array[x][y+1]+distance);
            }
            if(x-1>=0){
                calcDistance((x-1)+"," +y,array[x-1][y]+distance);
            }
            if(y-1>=0){
                calcDistance(x +","+(y-1),array[x][y-1]+distance);
            }
            String key = x+","+y;
            visted.add(key);
            unvisited.remove(key);
            if (unvisited.size() % 1000 ==0){
                System.out.println(unvisited.size() + "time: " + (System.currentTimeMillis()-starttime)/1000);
                starttime = System.currentTimeMillis();
            }
        }
        String lastKey = (xMax-1) +"," + (yMax-1);
        return shortestDistFromStart.get(lastKey);
    }


    private void calcDistance (String key, long newDistance){
        if (visted.contains(key)){
            return;
        }
        if (newDistance< shortestDistFromStart.get(key)){
            shortestDistFromStart.put(key,newDistance);
        }
    }


    private String findSmallestDistance(){
        String minKey = null;
        long minValue = Long.MAX_VALUE;
        for(String key : unvisited) {
            long value = shortestDistFromStart.get(key);
            if(value < minValue) {
                minValue = value;
                minKey = key;
            }
        }
        return minKey;
    }

}
