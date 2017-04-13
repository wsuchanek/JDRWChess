package production.DanChunn.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Iterator;


/**
 * Created by willsuchanek on 4/3/17.
 */

public class LastMoveQueue{

    private ArrayList<String> elements = new ArrayList<>();

    private ArrayList<int[]> numElem = new ArrayList<>();

    public void enqueue(String element) {
        elements.add(element);
    }

    public void addMoves(int[] element) {numElem.add(element);}

    public String dequeue() {
        return elements.remove(elements.size() - 1);
    }

    public String peek() {
        return elements.get(0);
    }

    public void clear() {
        elements.clear();
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public List<String> printLastFiveMoves(){

        if (this.isEmpty()){
            System.out.println("\nNo moves have been made.\n");
            return null;
        } else {
            List<String> moves = new ArrayList<String>();
            System.out.println("\nThe last 5 moves from most recent to oldest: ");
            for (int i = this.size()-1; i >= this.size()-5; i--){
                String current = this.elements.get(i);
                System.out.println(current);
                moves.add(current);
                if (i == 0){
                    break;
                }
            }
            System.out.println();
            return moves;
        }
    }
    public String saveGameFile(){
        String strToOut = "";

        for (String line: elements){
            strToOut+=line+"\n";
        }
        File file = new File("alexa-skills-kit-java-master/DanChunn/src/production/DanChunn/util/save.txt");
        file.delete();
        try {
            FileWriter writer = new FileWriter("alexa-skills-kit-java-master/DanChunn/src/production/DanChunn/util/save.txt",true);
            writer.write(strToOut);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strToOut;

    }

    /**
     *
     * @return returns the whole string that is written to the Load.txt.
     * @post creates a file called Load.txt that has a integer representation of all the moves made in the saved game
     */
    public String saveGameFileLoad(){
        String strToOut = "";

        for (int[] temp : numElem){
            strToOut+=Integer.toString(temp[0]) + Integer.toString(temp[1]) + " " + Integer.toString(temp[2]) + Integer.toString(temp[3])+"\n";
        }
        File file = new File("alexa-skills-kit-java-master/DanChunn/src/production/DanChunn/util/Load.txt");
        file.delete();
        try {
            FileWriter writer = new FileWriter("alexa-skills-kit-java-master/DanChunn/src/production/DanChunn/util/Load.txt",true);
            writer.write(strToOut);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strToOut;

    }

}