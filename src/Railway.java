import java.util.*;

/**
 * Created by tommy on 2016/2/18.
 */
public class Railway {
    List<Signal> signals;
    List<Block> blocks;
    List<Route> routes;
    List<Route> runnings = new ArrayList<>();//current running routes
    List<Route> waitings = new ArrayList<>();//current waiting routes

    public Railway() {

        JsonFile jf = new JsonFile();
        this.signals = jf.getSignal();
        this.blocks = jf.getBlock();
        this.routes = jf.getRoute();

        for (int i = 0; i < signals.size(); i++) {
            Signal s = signals.get(i);
            String flag = s.getPosition() == 0 ? "STOP" : "GO";
            String direction = s.getDirection() == 0 ? "DOWN" : "UP";
//            System.out.println("Signal: "+s.getName()+"("+direction+") controls block: "+s.getBlockName()+" current flag: "+flag);
        }

        for (int i = 0; i < this.blocks.size(); i++) {
            Block b = this.blocks.get(i);
            String type = b.getType() == 0 ? "track" : "point";
//            System.out.println("Block: "+b.getName()+" is a "+type+ " and position is "+b.getPosition());
        }
    }

    public void run() {
        System.out.println("#################################");
        if (this.runnings.size() == 0) {
            System.out.println("There is no route running in the railway!");
        } else {
            for (int i = 0; i < this.runnings.size(); i++) {
                Route route = runnings.get(i);
                System.out.println("Route " + route.getId() + " from " + route.getSource() + " to " + route.getDest() + " is running");
            }
        }

        //add a random route into the railway
        Random random = new Random();
        int ran = random.nextInt(this.routes.size());
        Route added = this.routes.get(ran);
        this.waitings.add(added);

        //calculate which routes could be added into the railway
        calculate();

        System.out.println("Now there are " + this.runnings.size() + " running");
        System.out.println("#################################\n");
    }


    /**
     * compare the runnings and the waitings
     * to see if the waitings could be add into the railway
     */
    public void calculate() {
        if (this.runnings.size() == 0) {
            Route route = this.waitings.get(0);
            System.out.println("Railway now is empty.First route " + route.getId() + " is added");
            System.out.println("1 Runnings :"+this.runnings.size()+"      waitings :"+this.waitings.size());
            String path = route.getPath();
            String[] paths;
            if (path.contains(";")) {
                paths = path.split(";");
            } else {
                paths = new String[1];
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
                    if (s.getName().equals(signals.get(j).getName())) {
                        this.signals.get(i).setPosition(1);//set to stop
                        System.out.println("Signal " + this.getSignals().get(i).getName() + " is changed to stop by " + route.getId());
                    }
                }
            }


            for (int i = 0; i < paths.length; i++) {
                for (int j = 0; j < this.blocks.size(); j++) {
                    Block section = this.blocks.get(j);
                    if (section.getName().equals(paths[i])) {
                        this.blocks.get(j).setOccupy(route.getId());//set occupy to this section
                        System.out.println("Block " + this.getBlocks().get(j).getName() + " is occupied by " + route.getId());
                    }
                }
            }

            this.runnings.add(route);//add the route to the running routes
            this.waitings.clear();//clear the waiting routes

        } else {
            Iterator<Route> waiting = this.waitings.iterator();
            while (waiting.hasNext()) {
                Route route = waiting.next();
                System.out.println("Route " + route.getId() + " in the waitings is added");
                boolean flag = true;//true -> not occupied    false -> occupied
                for (int i = 0; i < this.blocks.size(); i++) {
                    String currentSecction = this.blocks.get(i).getName();
                    String path = route.getPath();
                    String[] paths;
                    if (path.contains(";")) {
                        paths = path.split(";");
                    } else {
                        paths = new String[1];
                        paths[0] = path;
                    }


                    for (int j = 0; j < paths.length; j++) {
                        System.out.println("current section name is "+currentSecction+" and this path name is "+paths[j]);
                        if (currentSecction!=null && currentSecction.equals(paths[j])) {
                            System.out.println("Block " + paths[j] + " is occupied by " + this.blocks.get(i).getOccupy());
                            flag = false;
                            break;
                        }
                    }

                    if (!flag) {
                        break;
                    }else {
                        System.out.println("This route "+route.getId()+" path "+route.getPath()+" is clear and could go now!");
                    }
                }

                if (flag) {
                    System.out.println("Add this route into runnings");
                    this.runnings.add(route);//add the route to the running routes
                    waiting.remove();
                }else {
                    System.out.println("Add this route into waitings");
                }
            }
        }
        System.out.println("2 Runnings :"+this.runnings.size()+"      waitings :"+this.waitings.size());

        for (int i = 0; i < this.runnings.size(); i++) {
            Route route = this.runnings.get(i);
            String path = route.getPath();
            String[] paths;
            if (path.contains(";")) {
                paths = path.split(";");
            } else {
                paths = new String[1];
                paths[0] = path;
            }


        }

    }

    /**
     * update the railway's
     * signals
     * blocks
     * runnings
     * waitings
     */
    public void update(Route route) {

        System.out.println("Railway now is updating by route " + route.getId());
    }


    public List<Signal> getSignals() {
        return signals;
    }

    public void setSignals(List<Signal> signals) {
        this.signals = signals;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
