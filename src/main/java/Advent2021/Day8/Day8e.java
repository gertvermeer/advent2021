package Advent2021.Day8;

import Utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Day8e extends Utils {

    List<Integer> length = Arrays.asList(5, 2, 5, 5, 4, 5, 6, 3, 7, 6);
    List<List<Character>> ledList = new ArrayList<>();

    HashMap<Integer, Integer> lengthMap = new HashMap<>();
    HashMap<Integer, List<Integer>> longerMap = new HashMap<>();



    List<List<Integer>> containList = new ArrayList<>();

    public Integer execute(String filename) {

        int sum =0;

        List<String> inputList = readfile(filename);
        initMap();

        for (int row = 0; row < inputList.size(); row++) {

            HashMap<String, Integer> resultMap = new HashMap<>();
            HashMap<Integer, String> revReesultMap = new HashMap<>();

            List<String> patterns = List.of(List.of(inputList.get(row).split(" \\| "))
                    .get(0).split(" "));
            for (String value : patterns) {
                value = sortString(value);
                if (lengthMap.containsKey(value.length())) {
                    resultMap.put(value, lengthMap.get(value.length()));
                    revReesultMap.put(lengthMap.get(value.length()), value);
                }
            }

            patterns = List.of(List.of(inputList.get(row).split(" \\| "))
                    .get(0).split(" "));
            for (String value : patterns) {
                value = sortString(value);


                if (resultMap.containsKey(value)) {
                    continue;
                }

                List<Integer> optList = longerMap.get(value.length());
                List<Integer> resList = new ArrayList<>();


                boolean found = false;
                System.out.println("");
                for (Integer opt : optList) {
                    if (revReesultMap.containsKey(opt)) {
                        continue;
                    }
                    boolean test = true;
                    for (Integer key : revReesultMap.keySet()) {
                        int dif = diff(opt, key);
                        int tetdif = diffString(value, revReesultMap.get(key));
                        test = test && dif == tetdif;
                    }
                    if (test) {
                        resList.add(opt);
                    }
                }
                if (resList.size() == 1) {
                    resultMap.put(value, resList.get(0));
                    revReesultMap.put(resList.get(0), value);
                }
            }


            System.out.println("time");
            List<String> values = List.of(List.of(inputList.get(row).split(" \\| "))
                    .get(1).split(" "));


            int res = 0;
            for (String val : values) {

                if (val.equals("bcdef")) {
                    System.out.println();
                }


                String sorVal = sortString(val);
                res = res + resultMap.get(sortString(sorVal));
                res = res * 10;

                System.out.print(sorVal);
            }
            res = res / 10;
            sum = sum + res;
            System.out.println(res);

        }




        return sum;

    }


    private void initMap() {
        lengthMap.put(2, 1);
        lengthMap.put(4, 4);
        lengthMap.put(3, 7);
        lengthMap.put(7, 8);

        longerMap.put(5, Arrays.asList(2, 3, 5));
        longerMap.put(6, Arrays.asList(0, 6, 9));

        containList.add(Arrays.asList(1, 7));//0
        containList.add(Arrays.asList());//1
        containList.add(Arrays.asList(1));//2
        containList.add(Arrays.asList(1, 7));//3
        containList.add(Arrays.asList(1, 7));//4
        containList.add(Arrays.asList());//5
        containList.add(Arrays.asList(5));//6
        containList.add(Arrays.asList());//7
        containList.add(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9));//8
        containList.add(Arrays.asList(1, 3, 4, 5, 7));//9

        ledList.add(Arrays.asList('a', 'b', 'c', 'e', 'f', 'g')); //0
        ledList.add(Arrays.asList('c', 'f')); //1
        ledList.add(Arrays.asList('a', 'c', 'd', 'e', 'g')); //2
        ledList.add(Arrays.asList('a', 'c', 'd', 'f', 'g')); //3
        ledList.add(Arrays.asList('b', 'c', 'd', 'f')); //4
        ledList.add(Arrays.asList('a', 'b', 'd', 'f', 'g')); //5
        ledList.add(Arrays.asList('a', 'b', 'd', 'e', 'f', 'g')); //6
        ledList.add(Arrays.asList('a', 'c', 'f')); //7
        ledList.add(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g')); //8
        ledList.add(Arrays.asList('a', 'b', 'c', 'd', 'f', 'g')); //9


    }

    private Integer diffString(String first, String second) {
        int count = 0;
        if (first.length() > second.length()) {
            for (char c : first.toCharArray()) {
                if (second.indexOf(c) == -1) {
                    count++;
                }
            }
        } else {
            for (char c : second.toCharArray()) {
                if (first.indexOf(c) == -1) {
                    count++;
                }
            }
        }
        return count;
    }

    private Integer diff(int first, int second) {
        int count = 0;
        if (ledList.get(first).size() > ledList.get(second).size()) {
            for (char c : ledList.get(first)) {
                if (!ledList.get(second).contains(c)) {
                    count++;
                }
            }
        } else {
            for (char c : ledList.get(second)) {
                if (!ledList.get(first).contains(c)) {
                    count++;
                }
            }
        }
        return count;
    }


    private String sortString(String input) {

        List<Character> chList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            chList.add(c);
        }
        chList.sort(Character::compareTo);

        String result = new String();
        for (char c : chList) {
            result = result + c;
        }
        return result;
    }

}
