import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy on 2016/2/15.
 */
public class Route {
    String source;
    String dest;
    List<Point> points = new ArrayList<>();
    List<Signal> signals = new ArrayList<>();
    List<Path> paths = new ArrayList<>();
    String conflicts;

    public Route(String source, String dest, String point, String signal, String path, String conflict) {
        this.source = source;
        this.dest = dest;

        String[] pointArray;

        if (point.contains(";")){
            pointArray = point.split(";");
            for (int i=0;i<pointArray.length;i++){
                String[] ps = pointArray[i].split(":");
                Point p = new Point(ps[0],Boolean.parseBoolean(ps[1]));
                System.out.println(p.getName()+" "+p.getFlag());
                points.add(p);
            }
        }else {
            pointArray = point.split(":");
            Point p = new Point(pointArray[0],Boolean.parseBoolean(pointArray[1]));
            System.out.println(p.getName()+" "+p.getFlag());
            points.add(p);
        }

        if (signal.contains(";")) {
            String[] signalList = signal.split(";");
            for (int i = 0; i < signalList.length; i++) {
                String[] ss = signalList[i].split(":");
                Signal s = new Signal(ss[0],Boolean.parseBoolean(ss[1]));
                System.out.println(s.getName() + " " + s.getFlag());
                signals.add(s);
            }
        }else {
            String[] ss = signal.split(":");
            Signal s = new Signal(ss[0],Boolean.parseBoolean(ss[1]));
            System.out.println(s.getName()+" "+s.getFlag());
            signals.add(s);
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


        System.out.println(this.source+" "+this.dest+" "+points+" "+signals+" "+paths+" "+conflicts);
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

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
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
