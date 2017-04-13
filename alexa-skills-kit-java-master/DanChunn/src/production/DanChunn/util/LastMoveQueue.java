package production.DanChunn.util;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Iterator;


/**
 * This is a class that is a modified version of a queue, built off of Array Lists
 * It is used for saving and loading game files
 * Created by willsuchanek on 4/3/17.
 * @author willsuchanek
 */
public class LastMoveQueue{

    private ArrayList<String> elements = new ArrayList<>();
    private ArrayList<int[]> numElem = new ArrayList<>();

    /**
     * Enqueue to the elements list
     * @param element String of a move to be added into the queue
     */
    public void enqueue(String element) {
        elements.add(element);
    }

    /**
     * enqueues a number into the numElem class
     * @param element List of strings to be added to numElem
     */
    public void addMoves(int[] element) {numElem.add(element);}

    /**
     * Removes the last element in the elements Array
     * @return String - last move in the Array
     */
    public String dequeue() {
        return elements.remove(elements.size() - 1);
    }

    /**
     * Looks at the element in the front of the Queue
     * @return String - Element in the front of the Queue
     */
    public String peek() {
        return elements.get(0);
    }

    /**
     * Deletes the whole Queue
     * @post Queue is emptied
     */
    public void clear() {
        elements.clear();
    }

    /**
     * Gets size of the elements Array
     * @return  Int - Size of Elements Queue
     */
    public int size() {
        return elements.size();
    }

    /**
     * Checks to see if elements is empty
     * @return true if elements is empty
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * When this function is called it looks at the last 5 strings in the Elements Array and prints returns them (in a list)
     * to depict the last 5 moves that were made
     * @return List of Strings (last 5 moves)
     * @pre moves need to have been made, won't break if there aren't any though
     */
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

    /**
     * Looks at the elements ArrayList and adds all of them into a document in order.
     * This document is a save file of every move that was made in a game, in order.
     * It is used to resume the game later.
     * @return String - the string being written to the file
     * @pre Game needs to have been started and moves need to be in the queue
     * @post Creates a file in util directory called save.txt
     */
    public String saveGameFile(){
        String strToOut = "";

        for (String line: elements){
            strToOut+=line+"\n";
        }
        //File file = new File("/DanChunn/src/production/DanChunn/util/save.txt");
        //file.delete();
        try {
            PrintWriter writer = new PrintWriter("DanChunn/src/production/DanChunn/util/save.txt");
            writer.print(strToOut);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strToOut;

    }

    public String saveGameFileLoad(){
        String strToOut = "";

        for (int[] temp : numElem){
            strToOut+=Integer.toString(temp[0]) + Integer.toString(temp[1]) + " " + Integer.toString(temp[2]) + Integer.toString(temp[3])+"\n";
        }
        //File file = new File("/DanChunn/src/production/DanChunn/util/Load.txt");
        //file.delete();
        try {
            PrintWriter writer = new PrintWriter("DanChunn/src/production/DanChunn/util/Load.txt");
            writer.print(strToOut);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strToOut;

    }

}