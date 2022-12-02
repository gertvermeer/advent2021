package Advent2021.Day5;


import Utils.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day5 {

    Utils utils = new Utils();

    public Integer execute(String filename) {

        List<String> inputList = utils.readfile(filename);
        Ventmap ventmap = new Ventmap();

        int pointer = 0;

        while (pointer< inputList.size()){
            String line = inputList.get(pointer);
            String from = line.replaceAll("->.*","").trim();
            String to = line.replaceAll(".* ->","").trim();

            List<Integer> fromList = Arrays.stream(from.split(",")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> toList = Arrays.stream(to.split(",")).map(Integer::parseInt).collect(Collectors.toList());


            ventmap.trackRoute(fromList.get(0), fromList.get(1), toList.get(0), toList.get(1));
          //  ventmap.printGrid();

            //System.out.println("XXXXXXXXXXXXXXXXXX");






            pointer ++;
        }






        return ventmap.determineScore();

    }

}
