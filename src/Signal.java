/**
 * Created by tommy on 2016/2/15.
 */
public class Signal {

    String name;
    int direction;// 0 -> DOWN    1 -> UP
    int position=0;//0 -> stop    1 -> go
    String sectionName;//control which block to access

    public Signal(String name, int direction, String sectionName) {
        this.name = name;
        this.direction = direction;
        this.sectionName = sectionName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
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
}
