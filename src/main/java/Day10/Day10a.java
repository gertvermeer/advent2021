package Day10;

import Day9.Coord;
import Utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day10a extends Utils {

    HashMap<Character, Character> closingChar = new HashMap<>();
    HashMap<Character, Integer> scoreMap = new HashMap<>();

    public Integer execute(String filename) {


        List<String> inputList = readfile(filename);

        HashMap<Character, Integer> stack = new HashMap<>();
        closingChar = new HashMap<>();
        closingChar.put(')', '(');
        closingChar.put('}', '{');
        closingChar.put(']', '[');
        closingChar.put('>', '<');

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
        HashMap<Character, Integer> stack = new HashMap<>();
        stack.put('(', 0);
        stack.put('[', 0);
        stack.put('{', 0);
        stack.put('<', 0);

        boolean valid = true;
        for (Character code : row.toCharArray()) {
            if (code.equals('(') || code.equals('{') || code.equals('[') || code.equals('<')) {
                stack.put(code, stack.get(code) + 1);
                continue;
            }

            Character open = closingChar.get(code);
            stack.put(open, stack.get(open) -1);
            if(stack.get(open) == 0){
                if (countGrid(stack) >0){
                    return scoreMap.get(code);
                }
            }


        }

        return 0;
    }



    public Integer countGrid(HashMap<Character, Integer> stack) {
        int sum = 0;
        for (Map.Entry<Character, Integer> entry : stack.entrySet()) {
            sum = sum + entry.getValue();
        }
        return sum;
    }


}
