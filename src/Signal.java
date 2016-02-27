import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy on 2016/2/15.
 */
public class Signal {
    public static final Signal dao = new Signal();


    String name;
    int direction;// 0 -> DOWN    1 -> UP
    int position=0;//0 -> stop    1 -> go
    String blockName;//control which block to access

    String next;//next signals   s2;s4;s6
    String previous;//previous signals  s1;s2

    String[] nextArray;
    List<String> neighs = new ArrayList<>();
    List<String> visited = new ArrayList<>();

    public Signal() {
    }

    public Signal(String name, int direction, String blockName,String previous,String next) {
        this.name = name;
        this.direction = direction;
        this.blockName = blockName;
        this.next = next;
        this.previous = previous;

        String s = this.getNext();
        String[] ss;
        if (s.contains(";")) {// more than one signal
            ss = s.split(";");
        } else if (!s.equals("")) {// one signal
            ss = new String[1];
            ss[0] = s;
        } else {//no signal
            ss = new String[1];
            ss[0] = "";
        }
        for (int i = 0; i < ss.length; i++) {
            this.neighs.add(ss[i]);
        }

    }

    /**
     * get route by its name
     *
     * */
    public Signal getByName(List<Signal> signals,String name){
        Signal s = null;
        for (int i = 0; i < signals.size(); i++) {
            Signal signal = signals.get(i);
            if (signal.getName().equals(name)){
                s=signal;
                break;
            }
        }
        return s;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<String> getNeighs() {
        return neighs;
    }

    public void setNeighs(List<String> neighs) {
        this.neighs = neighs;
    }

    public List<String> getVisited() {
        return visited;
    }

    public void setVisited(List<String> visited) {
        this.visited = visited;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String[] getNextArray() {
        return nextArray;
    }

    public void setNextArray(String[] nextArray) {
        this.nextArray = nextArray;
    }
}
