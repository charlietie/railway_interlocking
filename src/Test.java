import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy on 2016/2/26.
 */
public class Test {
    public static void main(String[] args){
        Railway railway = new Railway();
        String source = "s1";
        String dest = "s7";

        List<Signal> signals = railway.signals;

        /*List<Route> upRoutes = new ArrayList<>();
        List<Route> downRoutes = new ArrayList<>();
        System.out.println("Current routes in railway is " + this.routes.size());
        for (int i = 0; i < this.routes.size(); i++) {
            Route route = Route.dao.getById(this.routes, this.routes.get(i).getId());
//            System.out.println("Now route is " + route.getId() + " and direction is " + route.getDirection());
            if (route.getDirection() == 1) {//signal direction=0->down  1->up
                upRoutes.add(route);
            } else {
                downRoutes.add(route);
            }
        }*/

        List<String> possible = new ArrayList<>();

        for (int i = 0; i < signals.size(); i++) {
            Signal signal =signals.get(i);
            String s = signal.getNext();
            String[] ss;
            if (s.contains(";")) {// more than one signal
                ss = s.split(";");
            } else if (!s.equals("")){// one signal
                ss = new String[1];
                ss[0]=s;
            }else {//no signal
                ss = new String[1];
                ss[0]="";
            }
            System.out.println(signal.getName()+" has "+ss.length);
            for (int j  = 0; j < ss.length; j++) {
                System.out.println(ss[j]);
            }
            railway.signals.get(i).setNextArray(ss);
            System.out.println(railway.signals.get(i).getNextArray().length);
        }

        int num = 1;//number of possibility
        for (int i = 0; i < railway.signals.size(); i++) {
            Signal signal = railway.signals.get(i);
            System.out.println(railway.signals.get(i).getName()+":");
            for (int j = 0; j < signal.getNextArray().length; j++) {
                String[] s = signal.getNextArray();
                System.out.println(s[j]);
            }
            System.out.println("\n");
        }



    }
}
