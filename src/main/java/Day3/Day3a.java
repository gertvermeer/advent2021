package Day3;


import Utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day3a {

    Utils utils = new Utils();

    public Integer execute(String filename){

        List<String> inputList = utils.readfile(filename);

        List<String> negInputList = List.copyOf(inputList);


        int number1 = 0;
        int count = 0;

        int oxygen = 0;
        int co2 = 0;

        int numberOfDigits = inputList.get(0).length();

        while (count <numberOfDigits && inputList.size()>1){
            String vert = getVerticalString(count, inputList);
            char dom = dominant(vert);
            inputList = removeRow(dom, count,inputList);
            count ++;
        }

        count = 0;
        while (count <numberOfDigits && negInputList.size()>1){

            String vert = getVerticalString(count, negInputList);
            char dom = dominant(vert);
            negInputList = removeRow(Inverse(dom), count,negInputList);
            count ++;
        }


        oxygen = Integer.parseInt(inputList.get(0),2);
        co2 = Integer.parseInt(negInputList.get(0),2);

        return oxygen * co2;
    }

    private char Inverse(char c){
        if (c=='1'){
            return '0';
        }
        return '1';
    }

    private String getVerticalString(final int row, List<String> inputlist){
        
        
        String result = "";

        String t = inputlist.stream().map(s -> s.charAt(row)).collect(Collectors.toList()).toString();

        StringBuilder b = new StringBuilder();

        String a =  b.append(1).toString();



        for (String elememt : inputlist){
            result = result + elememt.charAt(row);
        }
        return result;
    }

    private char dominant(String input){
        if(input.chars().filter(s -> s == '0').count() > input.chars().filter(s -> s == '1').count()){
            return '0';
        } else {
            return '1';
        }
    }

    private List <String> removeRow(char dominant, int x, List<String> input){

        List <String> resulSet = new ArrayList<>();
        for (String element : input){
            if(element.charAt(x) == dominant){
                resulSet.add(element);
            }
        }
        return resulSet;

    }

}
