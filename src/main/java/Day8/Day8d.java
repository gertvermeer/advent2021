package Day8;

import Utils.Utils;
import com.sun.jdi.IntegerValue;

import java.util.*;

public class Day8d extends Utils {

    List<List<Integer>> ledList = new ArrayList<>();
    HashMap<Integer, List<Integer>> containMap = new HashMap<>();

    public Integer execute(String filename) {
        initLedList();

        List<String> inputList = readfile(filename);

        HashMap<String, List<Integer>> posNumber = new HashMap<>();


        for (int row = 0; row < inputList.size(); row++) {
            List<String> patterns = List.of(List.of(inputList.get(1).split(" \\| "))
                    .get(0).split(" "));
            for (String value : patterns) {

                value = sortString(value);

                List<Integer> postList = new ArrayList<>();

                if (posNumber.containsKey(value)) {
                    postList = posNumber.get(value);
                } else {
                    postList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
                }
                List<Integer> pos = findNumberBySize(value.length());
                posNumber.put(value, pos);
            }
        }

        for (int row = 0; row < inputList.size(); row++) {
            List<String> patterns = List.of(List.of(inputList.get(1).split(" \\| "))
                    .get(0).split(" "));
            for (String value : patterns) {
                value = sortString(value);
                if(containMap.containsKey(value) && containMap.get(value).size()==1){
                    System.out.println(" key exitsts" );
                    continue;
                }
                List<Integer> pos = findNumberBySize(value.length());

                for(Integer can: pos){
                    boolean test = true;
                    List<Integer> contain = containMap.get(can);





                }

                System.out.println(pos);


            }


        }


        return 0;
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

    private List<Integer> findNumberBySize(int size) {
        List<Integer> resultList = new ArrayList<>();
        int coint = 0;
        for (List<Integer> it : ledList) {
            if (it.size() == size) {
                resultList.add(coint);
            }
            coint++;
        }
        return resultList;
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


        for (int t = 0; t < 9; t++) {
            List<Integer> maplist = new ArrayList<>();
            for (int t2 = 0; t2 < 9; t2++) {

                if (t == t2) {
                    continue;
                }

                List<Integer> checlist = ledList.get(t);
                List<Integer> teetList = ledList.get(t2);


                if (checkContain(checlist, teetList)) {
                    maplist.add(t2);
                }

            }
            containMap.put(t, maplist);
        }


    }

    public boolean checkContain(List<Integer> from, List<Integer> to) {

        boolean contains = true;

        for (Integer t : to) {
            contains = from.contains(t) && contains;
        }

        return contains;
    }
}
