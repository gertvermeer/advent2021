package Day3;


import Utils.Utils;

import java.util.List;

public class Day3b {

    Utils utils = new Utils();

    public Integer execute(String filename){

        List<String> inputList = utils.readTranspodedFile(filename);

        int number1 = 0;

        String comonString = "";
        String leastString = "";

        for (String input: inputList){
            if(input.chars().filter(s -> s == '1').count() > input.length()/2){
                comonString = comonString +"1";
                leastString = leastString + "0";
            } else {
                comonString = comonString + "0";
                leastString = leastString +"1";
            }
        }



        return Integer.parseInt(comonString,2) * Integer.parseInt(leastString,2);
    }



}
