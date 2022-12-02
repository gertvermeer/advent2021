package Advent2021.Day8;

import Utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Day8b extends Utils {

    List<List<Integer>> ledList = new ArrayList<>();


    public Integer execute(String filename) {


        List<List<Character>> optLedList = new ArrayList<>();

        List<String> inputList = readfile(filename);

        ledList.add(Arrays.asList(0, 1, 2, 4, 5, 6)); //0
        ledList.add(Arrays.asList(2, 5)); //1
        ledList.add(Arrays.asList(0, 2, 3, 4, 6)); //2
        ledList.add(Arrays.asList(0, 2, 3, 5, 6)); //3
        ledList.add(Arrays.asList(1, 2, 3, 5)); //4
        ledList.add(Arrays.asList(0, 1, 3, 5, 6)); //5
        ledList.add(Arrays.asList(0, 1, 3, 4, 5, 6)); //6
        ledList.add(Arrays.asList(0, 2, 5)); //7
        ledList.add(Arrays.asList(0, 1, 2, 3, 4, 5, 6)); //8
        ledList.add(Arrays.asList(0, 1, 2, 3, 5, 6)); //9


        HashMap<Character, List<Integer>> connectionMap = new HashMap<>();

        connectionMap.put('a', Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        connectionMap.put('b', Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        connectionMap.put('c', Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        connectionMap.put('d', Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        connectionMap.put('e', Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        connectionMap.put('f', Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        connectionMap.put('g', Arrays.asList(0, 1, 2, 3, 4, 5, 6));

        List<String> resultList = new ArrayList<>();
        for (int t = 0; t < 10; t++) {
            resultList.add("");
        }

        for (int row = 0; row < inputList.size(); row++) {
            List<String> patterns = List.of(List.of(inputList.get(1).split(" \\| "))
                    .get(0).split(" "));
            for (String value : patterns) {
                // Digit 1;

                switch (value.length()) {
                    case 2:
                        resultList.set(7, value);
                        break;
                    case 3:
                        resultList.set(1, value);
                        break;
                    case 4:
                        resultList.set(4, value);
                        break;
                    case 7:
                        resultList.set(8, value);
                }

                if (value.length() == 2 || value.length() == 3 || value.length() == 4) {
                    List<Integer> ledCon = ledList.stream().filter(ls -> ls.size() == value.length()).collect(Collectors.toList()).get(0);
                    for (char c : value.toCharArray()) {
                        List<Integer> option = connectionMap.get(c);
                        option = filterList(option, ledCon);
                        connectionMap.put(c, option);
                    }
                }
            }
        }

        for (int row = 0; row < inputList.size(); row++) {
            List<String> patterns = List.of(List.of(inputList.get(1).split(" \\| "))
                    .get(0).split(" "));
            for (String value : patterns) {
                List<Integer> ledCon = ledList.stream().filter(ls -> ls.size() == value.length()).collect(Collectors.toList()).get(0);
                System.out.println(value);

                List<Integer> optionList = possible(value.length());
                List<Integer> possible = addList(optionList);

                for (char c : value.toCharArray()) {
                    List<Integer> option = connectionMap.get(c);
                    option = filterList(option, possible);
                    connectionMap.put(c, option);
                }

            }
        }
        return 0;
    }


    public List<Integer> filterList(List<Integer> input, List<Integer> filter) {
        return input.stream().filter(s -> filter.contains(s)).collect(Collectors.toList());
    }

    public List<Integer> addList(List<Integer> input) {

        List<Integer> result = new ArrayList<>();
        for (Integer num : input) {
            result.addAll(ledList.get(num));
        }
        return result;
    }


    public List<Integer> possible(int length) {
        List<Integer> resultList = new ArrayList<>();
        int count = 0;
        for (List<Integer> lijst : ledList) {
            if (lijst.size() == length) {
                resultList.add(count);
            }
            count++;
        }
        return resultList;

    }

    public HashMap<Character, List<Character>> initHashmap(HashMap<Character, List<Character>> resultMap) {
        resultMap.put('a', Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g'));
        resultMap.put('b', Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g'));
        resultMap.put('c', Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g'));
        resultMap.put('d', Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g'));
        resultMap.put('e', Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g'));
        resultMap.put('f', Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g'));
        resultMap.put('g', Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g'));
        return resultMap;
    }

    ;


}
