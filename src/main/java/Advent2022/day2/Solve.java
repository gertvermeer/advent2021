package Advent2022.day2;

import Utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solve {

    Utils utils = new Utils();

    public int solve1(){
        List<String> input = utils.readfile("/day1/input1.txt");

        int max = 0;
        int counter = 0;
        int pointer = 0;
        Integer sum =0;
        while (pointer < input.size()){
            while (pointer <input.size() && !input.get(pointer).equals("")){
                sum = sum + Integer.parseInt(input.get(pointer));
                pointer ++;
            }
            if (sum > max){
                max = sum;
            }
            sum = 0;
            pointer ++;
        }

        return max;
    }

    public int solve2(){
        List<String> input = utils.readfile("/day1/input1.txt");

        int max = 0;
        int counter = 0;
        int pointer = 0;
        Integer sum =0;
        List<Integer> totalList = new ArrayList<>();
        while (pointer < input.size()){
            while (pointer <input.size() && !input.get(pointer).equals("")){
                sum = sum + Integer.parseInt(input.get(pointer));
                pointer ++;
            }
            totalList.add(sum);
            sum = 0;
            pointer ++;
        }
        Collections.sort(totalList,Collections.reverseOrder());

        List<Integer> test = totalList.subList(0,3);

        return  totalList.subList(0,3).stream().reduce(0, Integer::sum);

    }

    public static void main(String[] args) {
        System.out.println(new Solve().solve2());
    }
}
