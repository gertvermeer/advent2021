package Day16;

import Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Day16a extends Utils {

    String binInput;



    public long execute(String filename) {
        Pointer pointer = new Pointer(0);


        List<String> inputList = readfile(filename);
        binInput = hexToBinary(inputList.get(0));

        List<Paket> paketList = new ArrayList<>();

        while(pointer.value< binInput.length()){
            paketList.add(readPacket(pointer));
        }



        return 0;
    }


    private Paket readPacket(Pointer p){
        Paket paket = new Paket();
        paket.setV(binToInt(p.getValue(),p.getValue()+3));
        p.increase(3);
        paket.setT(binToInt(p.getValue(),p.getValue()+3));
        p.increase(3);


        if (paket.getT() ==4){
            paket.setValue(readType4(p));
            p.increase(3);
            return paket;
        }

        // Operatar pakket

        paket.setI(binToInt(p.getValue(),p.getValue()+1));
        p.increase(1);

//        if(paket.getI() ==0){
//            paket.setL(p.getValue()p.getValue(),p.getValue()+ 11);
//            p.increase(11);
//
//            int end = p.getValue() + paket.getValue();
//            while (p.getValue()<end){
//
//            }
//
//
//        }

        p.increase(1);
        return paket;
    }

    private Integer readType4(Pointer pointer){

        boolean last = false;
        String num = "";
        while (!last){
            last = binToInt(pointer.getValue(), pointer.getValue()+1) ==0;
            pointer.increase(1);
            num = num + binInput.substring(pointer.getValue(),pointer.getValue()+4);
            pointer.increase(4);
        }
        return Integer.parseInt(num,2);
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
