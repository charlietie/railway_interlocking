/**
 * Created by tommy on 2016/2/15.
 */
public class Base {
    String name;
    boolean flag;

    public Base(String name, boolean flag) {
        this.name = name;
        this.flag = flag;
    }

    public Base(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
