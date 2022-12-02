package Advent2021.Day8;

import Utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Day8 extends Utils {



    List<List<Character>> ledList = new ArrayList<>();

    public Integer execute(String filename){

        List<String> inputList = readfile(filename);

        ledList.add(Arrays.asList('a','b','c','e','f','g')); //0
        ledList.add(Arrays.asList('c','f')); //1
        ledList.add(Arrays.asList('a','c','d','e','g')); //2
        ledList.add(Arrays.asList('a','c','d','f','g')); //3
        ledList.add(Arrays.asList('b','c','d','f')); //4
        ledList.add(Arrays.asList('a','b','d','f','g')); //5
        ledList.add(Arrays.asList('a','b','d','e','f','g')); //6
        ledList.add(Arrays.asList('a','c','f')); //7
        ledList.add(Arrays.asList('a','b','c','d','e','f','g')); //8
        ledList.add(Arrays.asList('a','b','c','d','f','g')); //9


        HashMap<Character, List<Character>>  checkMap = new HashMap<>();
        checkMap = initHashmap(checkMap);

        int sum = 0;

        ledList.forEach(c -> System.out.println(c + ":" + c.size()));

        for (int row = 0 ; row< inputList.size(); row ++){



//            List<String> patterns = List.of(List.of(inputList.get(row).split(" \\| "))
//                    .get(0).split(" "));
//
//            for (String value : patterns){
//
//                List<Character> possibleChar = addList(filterOnlength(value.length()));
//
//                for(char c : value.toCharArray()){
//                    List<Character> charList = checkMap.get(c);
//                    checkMap.put(c,charList.stream().filter(s -> possibleChar.contains(s)).collect(Collectors.toList()));
//                }
//
//            }

            List<String> patterns = List.of(List.of(inputList.get(row).split(" \\| "))
                    .get(1).split(" "));

            for(String value : patterns){
                if (value.length() ==2 || value.length() ==7 || value.length() ==3 || value.length() ==4){
                    sum++;
                }
            }

        }


        return sum;

    }

    public List<Character> addList(List<List<Character>> input){

        List<Character> result = new ArrayList<>();
        for(List<Character> inputList : input){
            result.addAll(inputList);
        }
        return result;
    }

    public List<List<Character>> filterOnlength(int length){
        return ledList.stream().filter(s -> s.size() == length).collect(Collectors.toList());
    }

    public HashMap<Character, List<Character>> initHashmap(HashMap<Character, List<Character>> resultMap){
        resultMap.put('a',Arrays.asList('a','b','c','d','e','f','g'));
        resultMap.put('b',Arrays.asList('a','b','c','d','e','f','g'));
        resultMap.put('c',Arrays.asList('a','b','c','d','e','f','g'));
        resultMap.put('d',Arrays.asList('a','b','c','d','e','f','g'));
        resultMap.put('e',Arrays.asList('a','b','c','d','e','f','g'));
        resultMap.put('f',Arrays.asList('a','b','c','d','e','f','g'));
        resultMap.put('g',Arrays.asList('a','b','c','d','e','f','g'));
        return resultMap;
    };


}
