import java.util.List;

/**
 * Created by tommy on 2016/2/18.
 */
public class Railway {
    List<Signal> signals;
    List<Section> sections;
    List<Route> routes;

    public Railway() {
//        this.signals = signals;
//        this.sections = sections;
        JsonFile jf = new JsonFile();
        this.signals = jf.getSignal();
        this.sections = jf.getSection();
        this.routes = jf.getRoute();

        for (int i = 0; i < signals.size(); i++) {
            Signal s = signals.get(i);
            String flag = s.getPosition()==0?"STOP":"GO";
            String direction = s.getDirection()==0?"DOWN":"UP";
//            System.out.println("Signal: "+s.getName()+"("+direction+") controls block: "+s.getSectionName()+" current flag: "+flag);
        }

        for (int i = 0; i < sections.size(); i++) {
            Section b = sections.get(i);
            String type = b.getType()==0?"track":"point";
//            System.out.println("Section: "+b.getName()+" is a "+type+ " and position is "+b.getPosition());
        }
    }

    public List<Signal> getSignals() {
        return signals;
    }

    public void setSignals(List<Signal> signals) {
        this.signals = signals;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
