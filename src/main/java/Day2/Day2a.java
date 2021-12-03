package Day2;

import Utils.Utils;

import java.util.HashMap;
import java.util.List;

public class Day2a {

    Utils utils = new Utils();

    HashMap <String, Coord> commandMap = new HashMap<String, Coord>();


    public Integer executeDay2a(String filename){

        commandMap.put("forward", new Coord(1,0));
        commandMap.put("backward", new Coord(-1,0));
        commandMap.put("up", new Coord(0,-1));
        commandMap.put("down", new Coord(0,1));

        List<String> commandList = utils.readfile(filename);

        int horizontalPos = 0;
        int verticalPos =0;

        for (String command : commandList){

            List<String> commandElement = List.of(command.split(" "));
            horizontalPos = horizontalPos + commandMap.get(commandElement.get(0)).getX() * Integer.parseInt(commandElement.get(1)) ;
            verticalPos = verticalPos + commandMap.get(commandElement.get(0)).getZ() * Integer.parseInt(commandElement.get(1)) ;

        }


        return horizontalPos*verticalPos;
    }
}
