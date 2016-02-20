import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy on 2016/2/15.
 */
public class Route {
    String source;
    String dest;
    List<Signal> signals = new ArrayList<>();
    String path;
    String conflicts;

    public Route(String source,String dest,String path){
        this.source = source;
        this.dest = dest;
        this.path = path;
    }

    public List<Section> getSection(String source,String dest){
        List<Section> list = new ArrayList<>();
        return list;
    }

    public Route(String source, String dest, String block, String signal, String path, String conflict) {
        this.source = source;
        this.dest = dest;

        String[] blockArray;

        if (block.contains(";")){
            blockArray = block.split(";");
            for (int i=0;i<blockArray.length;i++){
                String[] ps = blockArray[i].split(":");
//                Section p = new Section(ps[0],Boolean.parseBoolean(ps[1]));
//                System.out.println(p.getName()+" "+p.getFlag());
//                sections.add(p);
            }
        }else {
            blockArray = block.split(":");
//            Section p = new Section(blockArray[0],Boolean.parseBoolean(blockArray[1]));
//            System.out.println(p.getName()+" "+p.getFlag());
//            sections.add(p);
        }

        if (signal.contains(";")) {
            String[] signalList = signal.split(";");
            for (int i = 0; i < signalList.length; i++) {
                String[] ss = signalList[i].split(":");
//                Signal s = new Signal(ss[0],Boolean.parseBoolean(ss[1]));
//                System.out.println(s.getName() + " " + s.getFlag());
//                signals.add(s);
            }
        }else {
            String[] ss = signal.split(":");
//            Signal s = new Signal(ss[0],Boolean.parseBoolean(ss[1]));
//            System.out.println(s.getName()+" "+s.getFlag());
//            signals.add(s);
        }
/*

        if (path.contains(";")){
            String[] pathList = path.split(";");
            for (int i = 0; i < pathList.length; i++) {
                Path p = new Path(pathList[i]);
                System.out.println(p.getName());
                paths.add(p);
            }
        }else {
            Path p = new Path(path);
            System.out.println(p.getName());
            paths.add(p);
        }
*/


        this.conflicts = conflict;


//        System.out.println(this.source+" "+this.dest+" "+points+" "+signals+" "+paths+" "+conflicts);
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public List<Signal> getSignals() {
        return signals;
    }

    public void setSignals(List<Signal> signals) {
        this.signals = signals;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getConflicts() {
        return conflicts;
    }

    public void setConflicts(String conflicts) {
        this.conflicts = conflicts;
    }
}
