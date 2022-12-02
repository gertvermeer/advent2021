package Advent2021.Day1;


import Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Day1b {

    Utils utils = new Utils();

    public Integer executeDay1(String filename){

        List<Integer> inputList = utils.readIntegerFile(filename);
        List<Integer> averageList = new ArrayList<>();
        int numberOfDecreases = 0;

        for (int  t=0 ; t< inputList.size()-2;t++){
            averageList.add(inputList.get(t)
                            + inputList.get(t+1)
                            + inputList.get(t+2));
        }


        for (int  t=1; t< averageList.size();t++){

            if (averageList.get(t) > averageList.get(t-1)){
                numberOfDecreases ++;
            }
        }

        return numberOfDecreases;
    }



}
