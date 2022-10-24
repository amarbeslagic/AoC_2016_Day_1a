import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    enum Orientation {
        SJEVER,
        ISTOK,
        ZAPAD,
        JUG
    }
    public static void main(String[] args) throws IOException {

        File file = new File("inputs//input_AoC_1a.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String s = br.readLine();

        String [] listOfStrings = s.split(",");

        for(int i=0; i<listOfStrings.length; i++){
                listOfStrings[i] = listOfStrings[i].trim();
        }

        int horisontalPosition = 0;
        int verticalPosition = 0;

        Orientation trenutnaOrjentacija = Orientation.SJEVER;

        for(String str : listOfStrings){
            char direction = str.charAt(0);
            int numOfBlocks = Integer.parseInt(str.substring(1));


            if(direction == 'R'){
                if(trenutnaOrjentacija == Orientation.SJEVER){
                    trenutnaOrjentacija = Orientation.ISTOK;
                    horisontalPosition += numOfBlocks;
                }
                else if(trenutnaOrjentacija == Orientation.ISTOK){
                    trenutnaOrjentacija = Orientation.JUG;
                    verticalPosition -= numOfBlocks;
                }
                else if(trenutnaOrjentacija == Orientation.JUG){
                    trenutnaOrjentacija = Orientation.ZAPAD;
                    horisontalPosition -= numOfBlocks;
                }
                else if(trenutnaOrjentacija == Orientation.ZAPAD){
                    trenutnaOrjentacija = Orientation.SJEVER;
                    verticalPosition += numOfBlocks;
                }
            }
            else if(direction == 'L'){
                if(trenutnaOrjentacija == Orientation.SJEVER){
                    trenutnaOrjentacija = Orientation.ZAPAD;
                    horisontalPosition -= numOfBlocks;
                }
                else if(trenutnaOrjentacija == Orientation.ISTOK){
                    trenutnaOrjentacija = Orientation.SJEVER;
                    verticalPosition += numOfBlocks;
                }
                else if(trenutnaOrjentacija == Orientation.JUG){
                    trenutnaOrjentacija = Orientation.ISTOK;
                    horisontalPosition += numOfBlocks;
                }
                else if(trenutnaOrjentacija == Orientation.ZAPAD){
                    trenutnaOrjentacija = Orientation.JUG;
                    verticalPosition -= numOfBlocks;
                }
            }
        }

//        System.out.println(horisontalPosition);
//        System.out.println(verticalPosition);

        int distance = Math.abs(horisontalPosition) + Math.abs(verticalPosition);
        System.out.println(distance);


    }
}