package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils2021 {


    public List<String> readfile(String filename){
        if(!filename.contains(".txt")){
            filename = "input"+filename+".txt";
        }

        List<String> resultsList = new ArrayList<String>();
        try {
            File myObj = new File("src/main/resources/"+ filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                resultsList.add(data);
                // System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return resultsList;
    }

    public List<Integer> readIntegerFile(String filename){
        List<Integer> resultsList = new ArrayList<Integer>();
        try {
            File myObj = new File("src/main/resources/"+ filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                resultsList.add(Integer.parseInt(myReader.nextLine()));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return resultsList;
    }

    public List<String> readTranspodedFile(String filename){
        List<String> resultsList = new ArrayList<String>();
        try {

            boolean initialized = false;

            File myObj = new File("src/main/resources/"+ filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String readString = myReader.nextLine();
                if (!initialized){
                    for (int t = 0 ; t<readString.length();t++){
                        resultsList.add("");
                    }
                    initialized = true;
                }
                for (int t=0; t<readString.length();t++){
                    resultsList.set(t,resultsList.get(t)+readString.charAt(t));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return resultsList;
    }

}