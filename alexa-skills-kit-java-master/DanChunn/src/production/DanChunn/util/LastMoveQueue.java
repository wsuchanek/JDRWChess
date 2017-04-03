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
        if (this.size() >= 5){
            this.dequeue();
        }
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
            System.out.println("No moves have been made.");
            return null;
        } else {
            List<String> moves = new ArrayList<String>();
            System.out.println("The last 5 moves from most recent to oldest: ");
            for (int i = this.size()-1; i >= 0; i--){
                String current = this.elements.get(i);
                System.out.println(current);
                moves.add(current);
            }
            return moves;
        }
    }

    @Override
    public Iterator<String> iterator() {
        return elements.iterator();
    }
}