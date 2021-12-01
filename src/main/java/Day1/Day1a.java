package Day1;


import Utils.Utils;

import java.util.List;

public class Day1a {

    Utils utils = new Utils();

    public Integer executeDay1a(String filename){

        List<Integer> inputList = utils.readIntegerFile(filename);
        int numberOfDecreases = 0;

        for (int  t=1; t< inputList.size();t++){

            if (inputList.get(t) > inputList.get(t-1)){
                numberOfDecreases ++;
            }
        }

        return numberOfDecreases;
    }



}
