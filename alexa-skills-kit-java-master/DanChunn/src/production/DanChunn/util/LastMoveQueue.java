package production.DanChunn.util;

import java.util.Queue;
import java.util.Stack;
import java.util.*;

/**
 * Created by willsuchanek on 4/3/17.
 */
public class LastMoveQueue<String> implements Iterable<String> {

    private LinkedList<String> elements = new LinkedList<String>();

    public void enqueue(String element) {
        elements.add(element);
    }

    public String dequeue() {
        return elements.removeFirst();
    }

    public String peek() {
        return elements.getFirst();
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

    @Override
    public Iterator<String> iterator() {
        return elements.iterator();
    }
}