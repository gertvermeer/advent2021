package Day9;

import Utils.Utils;

import java.util.List;

public class Day9a extends Utils {


    public Integer execute(String filename) {

        List<String> inputList = readfile(filename);

        int yMax = inputList.size();
        int xMax = inputList.get(0).length();

        int marix [][] = new int[xMax+2][yMax+2];

        for (int y=0; y<=inputList.size()+1;y++){
            for (int x=0; x<= inputList.get(0).length()+1;x++){
                marix[x][y] = 10;
            }
        }

        for (int y=0; y<inputList.size();y++){
            for (int x=0; x< inputList.get(0).length();x++){
                String row = inputList.get(y);
                int v = Character.getNumericValue(row.charAt(x));
                marix[x+1][y+1] = v;
            }
        }

        int count = 0;


        for (int y=1; y<inputList.size()+1;y++){
            for (int x=1; x< inputList.get(0).length()+1;x++){

                boolean test = true;
                test = test & marix[x-1][y] > marix[x][y];
                test = test & marix[x+1][y] > marix[x][y];
                test = test & marix[x][y-1] > marix[x][y];
                test = test & marix[x][y+1] > marix[x][y];

                if (test){
                    count = count + marix[x][y];
                }

            }
        }

    return count;
    }
}
