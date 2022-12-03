package Advent2022.day3;

import Utils.Utils;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class Solve {

    Utils utils = new Utils();

    public int solve1(){
        List<String> input = utils.readfile("/day3/input1.txt");
       int pointer = 0;
       int score = 0;
       while(pointer<input.size()){
            String bag1 = input.get(pointer).substring(0,input.get(pointer).length()/2);
            String bag2 = input.get(pointer).substring(input.get(pointer).length()/2);

            Character common = bag1.chars().mapToObj(s -> (char)(s)).filter(s-> bag2.contains(""+s)).collect(Collectors.toList()).get(0);
            int value = common;
            if(value < 97 ){
                value = (value- 38);
            } else {
                value = value-96;
            }
            score = score+ value;
           pointer ++;
       }
        return score;
    }


    public int solve2(){
        List<String> input = utils.readfile("/day3/input1.txt");
        int pointer = 0;
        int score = 0;
        while(pointer<input.size()){
            String bag1 = input.get(pointer++);
            String bag2 = input.get(pointer++);
            String bag3 = input.get(pointer++);

            List<Character> common = bag1.chars().mapToObj(s -> (char)(s)).filter(s-> bag2.contains(""+s)).collect(Collectors.toList());
            Character commonChar = common.stream().filter(s -> bag3.contains(""+s)).collect(Collectors.toList()).get(0);

            System.out.println(commonChar);
            int value = commonChar;
            if(value < 97 ){
                value = (value- 38);
            } else {
                value = value-96;
            }
            score = score+ value;


        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(new Solve().solve2());
    }
}
