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

    public void enqueue(String element) {
        elements.add(element);
    }

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
        File file = new File("DanChunn/src/production/DanChunn/util/save.txt");
        file.delete();
        try {
            FileWriter writer = new FileWriter("DanChunn/src/production/DanChunn/util/save.txt",true);
            writer.write(strToOut);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strToOut;

    }

}