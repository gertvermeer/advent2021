package Advent2021.Day14;

import Utils.Utils;

import java.util.*;
import java.util.stream.Collectors;

public class Day14a extends Utils {


    HashMap<String, String> rulesMap = new HashMap<>();

    String polymer;
    int numRules = 0;

    public Long execute(String filename) {
        List<String> inputList = readfile(filename);

        polymer = inputList.get(0);
        numRules =inputList.size()-2;

        for(int t=2; t<inputList.size();t++){
            String [] row = inputList.get(t).split("->");
            String newElem = row[0].trim().charAt(0) + row[1].trim() + row[0].trim().charAt(1);
            rulesMap.put(row[0].trim(), newElem);
        }


        for(int step = 0; step<10;step++){
            procces();
 //           System.out.println("polymer: " + polymer);
        }

        Set<Character> distinctChars
                = polymer.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(TreeSet::new));


        long max = 0;
        long min = 999999999999999999L;
        for(Character c : distinctChars){
            long num = polymer.chars().filter(ch -> ch==c).count();
            min = Math.min(min, num);
            max = Math.max(max,num);
        }

        System.out.println("Lengt: " + polymer.length());
        return max-min;
    }

    private void procces(){

        int pointer = 2;
        while (pointer<= polymer.length()){
            String check = polymer.substring(pointer-2,pointer);
            if (rulesMap.containsKey(polymer.substring(pointer-2,pointer))){

                polymer = polymer.substring(0,pointer-2) +
                        rulesMap.get(polymer.substring(pointer-2,pointer)) +
                        polymer.substring(pointer);
                pointer ++;

            }
            pointer ++;

        }

    }


}