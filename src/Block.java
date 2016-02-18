import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy on 2016/2/15.
 */
public class Block{
    String name;
    int type;// 0 -> track     1 -> point
    int position;// 0 -> PLUS    1 -> MINUS   3 -> npt point
    List<Block> neighs = new ArrayList<>();// 2 neighs for track and 3 neighs for point

    public Block(String name, int type) {
        this.name = name;
        this.type = type;
//        this.position = position;
    }

    public List<Block> getNeighs() {
        return neighs;
    }

    public void setNeighs(List<Block> neighs) {
        this.neighs = neighs;
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
