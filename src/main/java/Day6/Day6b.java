package Day6;

import Day2.Coord;
import Utils.Utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Day6b {

    Utils utils = new Utils();

    HashMap <String, Coord> commandMap = new HashMap<String, Coord>();


    public BigInteger execute(String filename, int numOfDays){


        List<String> commandList = utils.readfile(filename);

        List<String> fishtempList = Arrays.asList(commandList.get(0).split(","));
        List<Integer> fishList = fishtempList.stream().map(Integer::parseInt).collect(Collectors.toList());


        List<BigInteger> fishFreqList = new ArrayList<>();


        for (int t=0; t<9;t++){
            fishFreqList.add(BigInteger.valueOf(0));
        }

        for(int fish: fishList){
            fishFreqList.set(fish, fishFreqList.get(fish).add(BigInteger.valueOf(1)));
        }

        int day =0;

        while (day< numOfDays){

            BigInteger newFish = fishFreqList.get(0);
            BigInteger sixDayFish = fishFreqList.get(7);


            for(int t = 0; t<8;t++){
                fishFreqList.set(t, fishFreqList.get(t+1));
            }

            fishFreqList.set(6, sixDayFish.add(newFish));
            fishFreqList.set(8, newFish);
            day ++;
            System.out.print(day);
        }
        System.out.println();
        BigInteger sum = BigInteger.valueOf(0);
        for (BigInteger freq: fishFreqList){
            sum = sum.add(freq);
        }
        return sum;
    }
}
