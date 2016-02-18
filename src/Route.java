import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy on 2016/2/15.
 */
public class Route {
    String source;
    String dest;
    List<Block> blocks = new ArrayList<>();
    List<Signal> signals = new ArrayList<>();
    List<Path> paths = new ArrayList<>();
    String conflicts;

    public Route(String source,String dest){
        this.source = source;
        this.dest = dest;


    }

    public List<Block> getBlock(String source,String dest){
        List<Block> list = new ArrayList<>();
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
//                Block p = new Block(ps[0],Boolean.parseBoolean(ps[1]));
//                System.out.println(p.getName()+" "+p.getFlag());
//                blocks.add(p);
            }
        }else {
            blockArray = block.split(":");
//            Block p = new Block(blockArray[0],Boolean.parseBoolean(blockArray[1]));
//            System.out.println(p.getName()+" "+p.getFlag());
//            blocks.add(p);
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

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public List<Signal> getSignals() {
        return signals;
    }

    public void setSignals(List<Signal> signals) {
        this.signals = signals;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }

    public String getConflicts() {
        return conflicts;
    }

    public void setConflicts(String conflicts) {
        this.conflicts = conflicts;
    }
}
