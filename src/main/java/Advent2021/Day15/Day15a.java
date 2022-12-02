package Advent2021.Day15;

import Utils.Utils;

import java.util.*;

public class Day15a extends Utils {


    int xMax;
    int yMax;
    int[][] array;
    int[][] distance;

    HashMap<String, Long> shortestDistFromStart = new HashMap<>();
    HashMap<String, Long> previousVertex = new HashMap<>();
    List<String> visted = new ArrayList<>();
    List<String> unvisited = new ArrayList<>();




    boolean found = false;

    public long execute(String filename) {
        long lights = 0;

        List<String> inputList = readfile(filename);
        xMax = inputList.get(0).length();
        yMax = inputList.size();
        array = new int[xMax][yMax];
        distance = new int[xMax][yMax];

        for (int y = 0; y < yMax; y++) {
            String row = inputList.get(y);
            for (int x = 0; x < xMax; x++) {
               String key = x+","+y;
               shortestDistFromStart.put(key, Long.MAX_VALUE);
               unvisited.add(key);
               array[x][y] = Character.getNumericValue(row.charAt(x));

            }
        }

        shortestDistFromStart.put("0,0",0L);


        while (unvisited.size()!=0){


            String smallesDistance = findSmallestDistance();
            int x  = Integer.parseInt(List.of(smallesDistance.split(",")).get(0));
            int y  = Integer.parseInt(List.of(smallesDistance.split(",")).get(1));

            if(visted.contains((xMax-1) +"," + (yMax-1))){
                return shortestDistFromStart.get((xMax-1) +"," + (yMax-1));
            }

            long distance =shortestDistFromStart.get(smallesDistance);
            if(x+1<xMax){
                calcDistance(x+1,y,array[x+1][y]+distance);
            }
            if(y+1<yMax){
                calcDistance(x,y+1,array[x][y+1]+distance);
            }
            if(x-1>=0){
                calcDistance(x-1,y,array[x-1][y]+distance);
            }
            if(y-1>=0){
                calcDistance(x,y-1,array[x][y-1]+distance);
            }
            String key = x+","+y;
            visted.add(key);
            unvisited.remove(key);
 //           System.out.println(visted.size() + "-" + unvisited.size());
        }
        String lastKey = (xMax-1) +"," + (yMax-1);

        return shortestDistFromStart.get(lastKey);
    }


    private void calcDistance (int x, int y, long newDistance){
        if (visted.contains(x+","+y)){
            return;
        }
        if (newDistance< shortestDistFromStart.get(x+","+y)){
            shortestDistFromStart.put(x+","+y,newDistance);
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
