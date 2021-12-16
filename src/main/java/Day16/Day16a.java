package Day16;

import Utils.Utils;

import java.util.List;

public class Day16a extends Utils {

    String binInput;

    public long execute(String filename) {


        List<String> inputList = readfile(filename);
        binInput = hexToBinary(inputList.get(0));
        Integer version = binToInt(0,3);
        Integer packetId = binToInt(3,6);
        System.out.println("version: " + version + " ID: "+ packetId);

        int pointer = 0;

        if(packetId !=4){
            int length = detLength(7);
            System.out.println("Length: "+ length);



            while(pointer< length){



            }




        }






        return 0;
    }



    private int detLength(int p){
        int id =binToInt(p,p+1);
        if(id == 0){
            return 15;
        }
        return 11;
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
