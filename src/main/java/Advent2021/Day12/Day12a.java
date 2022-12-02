package Advent2021.Day12;

import Utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day12a extends Utils {

    Map<String,List<String>> map= new HashMap<>();

    List<String> routList = new ArrayList<>();

    public Integer execute(String filename) {


        List<String> inputList = readfile(filename);

        Map<String,List<String>> map= new HashMap<>();

        for(String row : inputList){
            String[] rowArr = row.split("-");
            addRoute(rowArr[0],rowArr[1]);
        }
        findRoute("start");

        return routList.size();
    }

    public void findRoute(String  currentRoute){
        List<String> nodeList = List.of(currentRoute.split("-"));
        String lastElem = nodeList.get(nodeList.size()-1);
        List<String> options = map.get(lastElem);
        for(String node: options){

            if(node.equals("end")){
                routList.add(currentRoute +"-" +node);
                continue;
            }

            if(node.equals("start")){
                continue;
            }
            if(Character.isLowerCase(node.charAt(0)) && currentRoute.contains(node)){
                continue;
            }

            findRoute(currentRoute+ "-"+node);

        }
        return;
    }

    public void addRoute(String from, String to){
        List<String>  connect = new ArrayList<>();
        if(map.containsKey(from)){
            connect = map.get(from);
        }
        connect.add(to);
        map.put(from, connect);

        connect = new ArrayList<>();
        if(map.containsKey(to)){
            connect = map.get(to);
        }
        connect.add(from);
        map.put(to, connect);

    }

}
