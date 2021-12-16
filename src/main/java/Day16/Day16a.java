package Day16;

import Utils.Utils;

import java.util.List;

public class Day16a extends Utils {

    String binInput;

    public long execute(String filename) {


        List<String> inputList = readfile(filename);
        binInput = hexToBinary(inputList.get(0));
        Integer version = Integer.parseInt(binInput.substring(0,3),2);
        Integer packetId = Integer.parseInt(binInput.substring(3,6),2);


        if(packetId !=4){

            Integer lengtId = binToInt(6,7);
            System.out.println("lengtId: " + lengtId);




        }

        System.out.println("version: " + version + " ID: "+ packetId);




        return 0;
    }


    private Integer binToInt(int start, int end){
        return Integer.parseInt(binInput.substring(start,end),2);
    }

    private String hexToBinary(String hex) {

        String res = "";

        for(int t =0; t< hex.length();t++){
            int i = Integer.parseInt(hex.substring(t,t+1), 16);
            String bin = ("0000" + Integer.toBinaryString(i));
            res = res +bin.substring(bin.length()-4,bin.length());
        }

        return res;
    }
}
