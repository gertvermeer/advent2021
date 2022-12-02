package Advent2021.Day10;

import Utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Day10b extends Utils {

    HashMap<Character, Character> closingChar = new HashMap<>();
    HashMap<Character, Integer> scoreMap = new HashMap<>();


    public Long execute(String filename) {


        List<String> inputList = readfile(filename);

        closingChar = new HashMap<>();
        closingChar.put(')', '(');
        closingChar.put('}', '{');
        closingChar.put(']', '[');
        closingChar.put('>', '<');


        scoreMap = new HashMap<>();
        scoreMap.put('(', 1);
        scoreMap.put('{', 3);
        scoreMap.put('[', 2);
        scoreMap.put('<', 4);

        int result = 0;

        List<Long> resultList = new ArrayList<>();

        for (String row : inputList) {
                long res = processRow(row);


                if(res>0){
                    resultList.add(res);
                }
        }

        Collections.sort(resultList);

        return resultList.get(Math.round(resultList.size()/2));
    }

    private Long processRow(String row) {

        if (!checkCorrect(row)){
            return 0L;
        }

        List<Character> stacklist = new ArrayList<>();

        for (Character code : row.toCharArray()) {
            if (code.equals('(') || code.equals('{') || code.equals('[') || code.equals('<')) {
                stacklist.add(code);
                continue;
            }
            stacklist.remove(stacklist.size() - 1);
        }

        long sum = 0;

        for(int t= stacklist.size()-1; t>=0;t--){
            sum = sum * 5;
            sum = sum + scoreMap.get(stacklist.get(t));
        }

        return sum;
    }



    private Boolean checkCorrect(String row) {
        List<Character> stacklist = new ArrayList<>();

        boolean valid = true;
        for (Character code : row.toCharArray()) {
            if (code.equals('(') || code.equals('{') || code.equals('[') || code.equals('<')) {
                stacklist.add(code);
                continue;
            }
            Character open = closingChar.get(code);
            if(stacklist.get(stacklist.size()-1).equals(open)){
                stacklist.remove(stacklist.size() - 1);
            } else{
                return false;
            }


        }

        return true;
    }


}
