import java.util.*;

/**
 * Created by tommy on 2016/2/18.
 */
public class Railway {
    List<Signal> signals;
    List<Section> sections;
    List<Route> routes;
    List<Route> runnings = new ArrayList<>();//current running routes

    public Railway() {

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

    public void chooseRoute(){
        for (int i = 0; i < this.runnings.size(); i++) {
            Route route = runnings.get(i);

            System.out.println("Route "+route.getId()+" from "+route.getSource()+" to "+route.getDest()+" is running");
        }
        Random random = new Random();
        int ran = random.nextInt(this.routes.size());
        Route added = this.routes.get(ran);
        if (compute(added)) {
            this.runnings.add(added);
        }
        System.out.println("choose "+added.getId()+" to add into the route and now there are "+this.runnings.size()+" running");
    }

    public boolean compute(Route route){
        if (this.runnings.size()==0){
            System.out.println("First route "+ route.getId() +" is added");
            String path = route.getPath();
            String[] paths;
            if (path.contains(";")) {
                paths = path.split(";");
            }else {
                paths= new String[1];
                paths[0] = path;
            }
            System.out.println("paths are");
            for (int i = 0; i < paths.length; i++) {
                System.out.println(paths[i]);
            }
            List<Signal> signals = route.getSignals();

            System.out.println("signals are");
            for (int i = 0; i < signals.size(); i++) {
                System.out.println(signals.get(i).getName());
            }

            for (int i = 0; i < this.signals.size(); i++) {
                Signal s = this.signals.get(i);//
                for (int j = 0; j < signals.size(); j++) {
                    if (s.getName().equals(signals.get(j).getName())){
                        this.signals.get(i).setPosition(1);//set to stop
                        System.out.println("Signal "+this.getSignals().get(i).getName()+" is changed to stop by "+route.getId());
                    }
                }
            }


            for (int i = 0; i < paths.length; i++) {
                for (int j = 0; j < this.sections.size(); j++) {
                    Section section = this.sections.get(j);
                    if (section.getName().equals(paths[i])){
                        this.sections.get(j).setOccupy(route.getId());//set occupy to this section
                        System.out.println("Section "+this.getSections().get(j).getName()+" is occupied by "+route.getId());
                    }

                }
            }

        }else {
            for (int i = 0; i < this.runnings.size(); i++) {
                Route r = this.runnings.get(i);//running one

                System.out.println("Route " + r.getId() + " is running and its paths are" + r.getPath());

            }
        }
        return false;
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
