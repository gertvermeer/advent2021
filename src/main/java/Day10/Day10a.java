package Day10;

import Day9.Coord;
import Utils.Utils;

import java.util.*;

public class Day10a extends Utils {

    HashMap<Character, Character> closingChar = new HashMap<>();
    HashMap<Character, Integer> scoreMap = new HashMap<>();
    List<Character> stacklist = new ArrayList<>();

    public Integer execute(String filename) {


        List<String> inputList = readfile(filename);

        HashMap<Character, Integer> stack = new HashMap<>();
        closingChar = new HashMap<>();
        closingChar.put(')', '(');
        closingChar.put('}', '{');
        closingChar.put(']', '[');
        closingChar.put('>', '<');

        stacklist.add('a');
        stacklist.add('a');


        scoreMap = new HashMap<>();
        scoreMap.put(')', 3);
        scoreMap.put('}', 1197);
        scoreMap.put(']', 57);
        scoreMap.put('>', 25137);

        int sum = 0;

        for (String row : inputList) {
            sum = sum+ processRow(row);


        }


        return sum;
    }

    private Integer processRow(String row) {

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
                return scoreMap.get(code);
            }


        }

        return 0;
    }




}
