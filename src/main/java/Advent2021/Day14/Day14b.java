package Advent2021.Day14;

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
            increaseMap(polymer.substring(t,t+2), countTupleMap,BigInteger.valueOf(1));

        }
        for(int t = 0; t<= polymer.length()-1; t++){
            increaseMap(polymer.substring(t,t+1), countCharMap,BigInteger.valueOf(1));
        }


        numRules =inputList.size()-2;

        for(int t=2; t<inputList.size();t++){
            String [] row = inputList.get(t).split("->");
            List<String> toRules = new ArrayList<>();
            rulesMap.put(row[0].trim(), row[1].trim());
        }


        for(int step = 0; step < 40;step++){
            procces();
        }

        BigInteger max = BigInteger.valueOf(0);
        BigInteger min = BigInteger.valueOf(-1);
        for(Map.Entry<String, BigInteger> item:countCharMap.entrySet()){
            if(min.equals(BigInteger.valueOf(-1))){
                min = countCharMap.get(item.getKey());
                max = countCharMap.get(item.getKey());
            } else {
                max = max.max(countCharMap.get(item.getKey()));
                min = min.min(countCharMap.get(item.getKey()));
            }
        }

        System.out.println(" Min : " + min.toString() + "Max:" + max.toString());

        return max.subtract(min);
    }


    private void increaseMap(String key, HashMap<String, BigInteger> map, BigInteger value){
        if(map.containsKey(key)){
            map.put(key, map.get(key).add(value));
        } else {
            map.put(key, value);
        }

    }

    private void procces(){

        List<String> valueSet = countTupleMap
                .entrySet()
                .stream()
                .filter(value -> !value.getValue().equals(BigInteger.ZERO))
                .map(s -> s.getKey())
                .collect(Collectors.toList());
        List<BigInteger> valueNum = countTupleMap
                .entrySet()
                .stream()
                .filter(value -> !value.getValue().equals(BigInteger.ZERO))
                .map(s -> s.getValue())
                .collect(Collectors.toList());


        for(int t= 0; t<valueSet.size(); t++){
            String toChar = rulesMap.get(valueSet.get(t));
            String tupple = valueSet.get(t);
            BigInteger num = valueNum.get(t);
            String firstCombi = tupple.charAt(0) + toChar;
            String secondCombi = toChar + tupple.charAt(1);
            increaseMap(toChar,countCharMap,num);
            increaseMap(tupple, countTupleMap,num.negate());
            increaseMap(firstCombi,countTupleMap,num);
            increaseMap(secondCombi,countTupleMap,num);
        }
    }

}