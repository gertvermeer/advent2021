package Day7;

import Utils.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day7b extends Utils {


    public Integer execute(String filename){
        List<Integer> inputList =Arrays.stream(readfile(filename).get(0).split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Double avd = inputList.stream().mapToDouble(s -> s).average().getAsDouble();
        Integer average = avd.intValue();
        Integer start = average;
        Integer minDist = calcDist(start, inputList);

        int pointer = start;
        int nextDist = calcDist(pointer,inputList);
        while (nextDist <= minDist){
            pointer++;
            minDist = nextDist;
            nextDist = calcDist(pointer,inputList);
        }

        pointer--;
        nextDist = calcDist(pointer,inputList);
        while (nextDist <= minDist){
            pointer--;
            minDist = nextDist;
            nextDist = calcDist(pointer,inputList);
        }

        return minDist;


    }

    private Integer calcDist(Integer target, List<Integer> inputList){
        Integer sum = 0;
        for(Integer val: inputList){
            sum += fuel(Math.abs(val-target));

        }
        return sum;
    }

    public Integer fuel(int dist){
        int sum = 0;
        for(int t=1;t<=dist;t++){
            sum+=t;
        }
        return sum;
    }


}
