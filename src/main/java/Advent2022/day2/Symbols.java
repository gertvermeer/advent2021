package Advent2022.day2;

public enum Symbols {

    Rock, Paper, Siccor;

    public static Symbols from (String input){
        if(input.equals("X") ||input.equals("A")){
            return Rock;
        }
        if(input.equals("Y") ||input.equals("B")){
            return Paper;
        }
        if(input.equals("Z") ||input.equals("C")){
            return Siccor;
        }
        return null;
    }

    public static int Score(Symbols symbols1, Symbols symbols2){
        if (symbols1 == symbols2){
            return 3;
        }
        if(symbols2==Rock && symbols1==Siccor) return 6;
        if(symbols2==Paper && symbols1==Rock) return 6;
        if(symbols2==Siccor && symbols1==Paper) return 6;

        return 0;
    }


    public static Symbols opponwnt(Symbols symbols1, String res){

        if(res.equals("Y")) return symbols1;

        if(res.equals("X")){
            if(symbols1==Rock) return Siccor;
            if(symbols1==Paper) return Rock;
            if(symbols1==Siccor) return Paper;
        }

        if(res.equals("Z")){
            if(symbols1==Rock) return Paper;
            if(symbols1==Paper) return Siccor;
            if(symbols1==Siccor) return Rock;
        }
        return null;
    }

}
