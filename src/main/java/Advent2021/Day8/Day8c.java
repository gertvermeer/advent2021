package Advent2021.Day8;

import Utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day8c extends Utils {

    List<List<Integer>> ledList = new ArrayList<>();
    List<List<Character>> optionlist = new ArrayList<>();


    public Integer execute(String filename) {

        initLedList();
        List<String> inputList = readfile(filename);


        for (int row = 0; row < inputList.size(); row++) {

            List<String> patterns = List.of(List.of(inputList.get(1).split(" \\| "))
                    .get(0).split(" "));

            for (String value : patterns) {


                List<Integer> pI = posInt(value.length());
                List<Integer> elem = new ArrayList<>();
                for (int t = 0; t < pI.size(); t++) {
                    elem.addAll(ledList.get(pI.get(t)));
                }


                if (pI.size() == 1) {
                    for (int el : elem) {
                        List<Character> curList = optionlist.get(el);
                        List<Character> res = new ArrayList<>();
                        for (char c : value.toCharArray()) {
                            if (curList.contains(c)) {
                                res.add(c);
                            }
                        }
                        optionlist.set(el, res);
                    }
                }

            }

        }


        return 0;
    }

    public List<Integer> posInt(int length) {
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (List<Integer> cl : ledList) {
            if (cl.size() == length) {
                result.add(count);
            }
            count++;
        }
        return result;
    }

    public void initLedList() {
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

        for (int t = 0; t < 10; t++) {
            optionlist.add(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g'));
        }
    }
}
