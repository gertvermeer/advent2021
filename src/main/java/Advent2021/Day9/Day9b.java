package Advent2021.Day9;

import Utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9b extends Utils {

    int marix[][];
    boolean counted[][];
    int yMax;
    int xMax;

    public Integer execute(String filename) {


        List<Coord> lowList = new ArrayList<>();
        List<String> inputList = readfile(filename);

        yMax = inputList.size();
        xMax = inputList.get(0).length();

        marix = new int[xMax + 2][yMax + 2];
        counted = new boolean[xMax + 2][yMax + 2];

        for (int y = 0; y <= yMax + 1; y++) {
            for (int x = 0; x <= xMax + 1; x++) {
                marix[x][y] = 10;
            }
        }

        for (int y = 0; y < inputList.size(); y++) {
            for (int x = 0; x < inputList.get(0).length(); x++) {
                String row = inputList.get(y);
                int v = Character.getNumericValue(row.charAt(x));
                marix[x + 1][y + 1] = v;
            }
        }

        for (int y = 1; y < inputList.size() + 1; y++) {
            for (int x = 1; x < inputList.get(0).length() + 1; x++) {
                boolean test = true;
                test = test & marix[x-1][y] > marix[x][y];
                test = test & marix[x+1][y] > marix[x][y];
                test = test & marix[x][y-1] > marix[x][y];
                test = test & marix[x][y+1] > marix[x][y];

                if (test) {
                    lowList.add(new Coord(x, y));
                }
            }
        }

        List<Integer> basinSizeList = new ArrayList<>();

        for (Coord coord : lowList) {
            basinSizeList.add(basinsize(coord.getX(), coord.getY()));
        }


        Collections.sort(basinSizeList);
        int sum =1;
        int start =basinSizeList.size();
        for (int t=0; t<3;t++){
            sum = sum* basinSizeList.get(start-t-1);
        }

        return sum;
    }

    private int basinsize(int x, int y) {
        if (x < 1 || y < 1 || y > yMax || x > xMax) {
            return 0;
        }
        if (marix[x][y] == 9) {
            return 0;
        } else {
            marix[x][y] = 9;
            return 1 + basinsize(x + 1, y) + basinsize(x - 1, y)
                    + basinsize(x, y + 1) + basinsize(x, y - 1);
        }
    }


}
