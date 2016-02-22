import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy on 2016/2/15.
 */
public class Section{
    String name;
    int type;// 0 -> block     1 -> point
    int position;// 0 -> PLUS    1 -> MINUS   3 -> npt point
    String previous;// previous section
    String next;// next section
    String occupy;//occupy by which route   r1,b2
//    List<Section> neighs = new ArrayList<>();// 2 neighs for track and 3 neighs for point

    public Section(String name, int type, String previous, String next) {
        this.name = name;
        this.type = type;
        this.previous = previous;
        this.next = next;
//        this.position = position;
    }

    public String getOccupy() {
        return occupy;
    }

    public void setOccupy(String occupy) {
        this.occupy = occupy;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
