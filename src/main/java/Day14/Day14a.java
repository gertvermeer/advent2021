package Day14;

import Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Day14a extends Utils {

    List<String> fromList = new ArrayList<>();
    List<String> toList = new ArrayList<>();
    String polymer;
    int numRules = 0;

    public Integer execute(String filename) {
        List<String> inputList = readfile(filename);

        polymer = inputList.get(0);
        numRules =inputList.size()-2;

        for(int t=2; t<inputList.size();t++){
            String [] row = inputList.get(t).split("->");
            fromList.add(row[0].trim());
            String newElem = row[0].trim().charAt(0) + row[1].trim() + row[0].trim().charAt(1);
            toList.add(newElem);
        }


        for(int step = 0; step<5;step++){

            procces();
            System.out.println("polymer: " + polymer);

        }


        return 0;
    }

    private void procces(){
        for(int rule = 0; rule< numRules; rule++){

            int pointer = 1;
            while (pointer< polymer.length()){


            }
        }
    }


}