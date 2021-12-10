package Day6;

import Day2.Coord;
import Utils.Utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Day6a {

    Utils utils = new Utils();

    HashMap <String, Coord> commandMap = new HashMap<String, Coord>();


    public Integer execute(String filename, int numOfDays){


        List<String> commandList = utils.readfile(filename);

        List<String> fishtempList = Arrays.asList(commandList.get(0).split(","));
        List<Integer> fishList = fishtempList.stream().map(Integer::parseInt).collect(Collectors.toList());




        int day =0;

        while (day< numOfDays){

            int fish = 0;
            int numOfFish = fishList.size();
            while (fish < numOfFish){
                fishList.set(fish,fishList.get(fish)-1);
                if(fishList.get(fish)< 0){
                    fishList.set(fish,6);
                    fishList.add(8);
                }
                fish++;
            }
            day++;

//            System.out.print("After "+ day + " day:");
//            fishList.forEach(f -> System.out.print(f + ","));
//            System.out.println();

        }


        return fishList.size();
    }
}
