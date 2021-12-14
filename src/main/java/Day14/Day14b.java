package Day14;

import Utils.Utils;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Day14b extends Utils {


    HashMap<String, String> rulesMap = new HashMap<>();
    HashMap<String, BigInteger> countTupleMap = new HashMap<>();
    HashMap<String, BigInteger> countCharMap = new HashMap<>();

    String polymer;
    int numRules = 0;

    public BigInteger execute(String filename) {
        List<String> inputList = readfile(filename);

        polymer = inputList.get(0);

        for(int t = 0; t<= polymer.length()-2; t++){
            increaseMap(polymer.substring(t,t+2), countTupleMap,1);

        }
        for(int t = 0; t<= polymer.length()-1; t++){
            increaseMap(polymer.substring(t,t+1), countCharMap,1);
        }


        numRules =inputList.size()-2;

        for(int t=2; t<inputList.size();t++){
            String [] row = inputList.get(t).split("->");
            List<String> toRules = new ArrayList<>();
            rulesMap.put(row[0].trim(), row[1].trim());
        }


        for(int step = 0; step < 2;step++){
            procces();
        }

        BigInteger max = BigInteger.valueOf(0);
        BigInteger min = BigInteger.valueOf(-1);


        return BigInteger.valueOf(0);
    }


    private void increaseMap(String key, HashMap<String, BigInteger> map, int value){
        if(map.containsKey(key)){
            map.put(key, map.get(key).add(BigInteger.valueOf(value)));
        } else {
            map.put(key, BigInteger.valueOf(1));
        }

    }

    private void procces(){

        List<String> valueSet = countTupleMap
                .entrySet()
                .stream()
                .filter(value -> value.getValue().intValueExact() != 0)
                .map(s -> s.getKey())
                .collect(Collectors.toList());

        for (String key : valueSet){
            String toChar = rulesMap.get(key);

            String firstCombi = key.charAt(0) + toChar;
            String secondCombi = toChar + key.charAt(1);
            increaseMap(toChar,countCharMap,1);
            increaseMap(key, countTupleMap,-1);
            increaseMap(firstCombi,countTupleMap,1);
            increaseMap(secondCombi,countTupleMap,1);
        }
    }

}