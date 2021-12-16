package Day16;

import Utils.Utils;

import java.util.List;

public class Day16a extends Utils {

    String binInput;

    Pointer pointer = new Pointer(0);

    public long execute(String filename) {


        List<String> inputList = readfile(filename);
        binInput = hexToBinary(inputList.get(0));
        Integer version = binToInt(0,3);
        Integer packetId = binToInt(3,6);
        System.out.println("version: " + version + " ID: "+ packetId);

        int L=0;

        if(packetId !=4) {
            pointer.setValue(6);
            L = getPacket(pointer);
            System.out.println("L: " + L);
        }

        while (pointer.getValue()<L){

            Paket p = readPacket(pointer);

            System.out.println("Packet: "+ getPacket(pointer));


        }


        return 0;
    }


    private Paket readPacket(Pointer p){
        Paket paket = new Paket();
        paket.setVersion(binToInt(p.getValue(),p.getValue()+3));
        p.increase(3);
        paket.setId(binToInt(p.getValue(),p.getValue()+3));
        p.increase(3);
        paket.setI(binToInt(p.getValue(),p.getValue()+1));
        p.increase(1);
        if (paket.getI() ==0){
            p.setValue(binToInt(p.getValue(),p.getValue()+11));
            p.increase(11);
        } else {
            p.setValue(binToInt(p.getValue(),p.getValue()+15));
            p.increase(15);
        }
        return paket;
    }

    private int getPacket(Pointer p){
        int res =0;
        int id =binToInt(p.getValue(),p.getValue()+1);
        if(id == 0){
            res= binToInt(p.getValue()+1,p.getValue()+16);
            pointer.increase(16);
        } else {
            res = binToInt(p.getValue()+1,p.getValue()+12);
            pointer.increase(12);
        }
        return res;
    }

    private int detLength(int p, Pointer pointer){
        int id =binToInt(p,p+1);
        if(id == 0){
            pointer.increase(16);
            return binToInt(p+1,p+16);
        }
        pointer.increase(12);
        return binToInt(p+1,p+12);
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
