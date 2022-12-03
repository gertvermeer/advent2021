package Advent2022.day2;

import Utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class Solve {

    Utils utils = new Utils();

    public int solve1(){
        List<String> input = utils.readfile("/day2/input1.txt");
       int pointer = 0;
       int score =0;
        HashMap<Symbols, Integer> shapeScore = new HashMap<>();
        shapeScore.put(Symbols.Rock, 1);
        shapeScore.put(Symbols.Paper, 2);
        shapeScore.put(Symbols.Siccor, 3);
       while(pointer<input.size()){
           Symbols him = Symbols.from(input.get(pointer).substring(0,1));
           Symbols me = Symbols.from(input.get(pointer).substring(2,3));
           score = score +Symbols.Score(him,me);
           System.out.print(score + "-");
           score = score + shapeScore.get(me);
           System.out.println(score);
           pointer ++;
       }
        return score;
    }

    public int solve2(){
        List<String> input = utils.readfile("/day2/input1.txt");
        int pointer = 0;
        int score =0;
        HashMap<Symbols, Integer> shapeScore = new HashMap<>();
        shapeScore.put(Symbols.Rock, 1);
        shapeScore.put(Symbols.Paper, 2);
        shapeScore.put(Symbols.Siccor, 3);
        while(pointer<input.size()){
            Symbols him = Symbols.from(input.get(pointer).substring(0,1));
            Symbols me = Symbols.opponwnt(him,input.get(pointer).substring(2,3));
            score = score +Symbols.Score(him,me);
            System.out.print(score + "-");
            score = score + shapeScore.get(me);
            System.out.println(score);
            pointer ++;
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(new Solve().solve2());
    }
}
