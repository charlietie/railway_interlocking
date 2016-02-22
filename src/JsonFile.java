import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy on 2016/2/20.
 */
public class JsonFile {

    public List<Signal> getSignal(){
        List<Signal> list = new ArrayList<>();
        Signal s1 = new Signal("s1",1,"b2");
        Signal s2 = new Signal("s2",0,"b1");
        Signal s3 = new Signal("s3",0,"p1");
        Signal s4 = new Signal("s4",1,"p2");
        Signal s5 = new Signal("s5",0,"p1");
        Signal s6 = new Signal("s6",1,"p2");
        Signal s7 = new Signal("s7",1,"b6");
        Signal s8 = new Signal("s8",0,"b5");
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);
        list.add(s7);
        list.add(s8);
        return list;
    }

    public List<Section> getSection(){
        List<Section> list = new ArrayList<>();
        Section b1 = new Section("b1",0,"","b2");
        Section b2 = new Section("b2",0,"b1","p1");
        Section b3 = new Section("b3",0,"p1","p2");
        Section b4 = new Section("b4",0,"p1","p2");
        Section b5 = new Section("b5",0,"p2","b6");
        Section b6 = new Section("b6",0,"b5","");
        Section p1 = new Section("p1",1,"b2","b3;b4");
        Section p2 = new Section("p2",1,"b3;b4","b5");

        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        list.add(b5);
        list.add(b6);
        list.add(p1);
        list.add(p2);
        return list;
    }

    public List<Route> getRoute(){
        List<Route> list = new ArrayList<>();
        Route route = new Route("r1","s1","s6","b2;p1;b4");
        List<Signal> signals = new ArrayList<>();
        Signal s2 = new Signal("s2",0,"b1");
        Signal s3 = new Signal("s3",0,"p1");
        Signal s5 = new Signal("s5",0,"p1");
        signals.add(s2);
        signals.add(s3);
        signals.add(s5);
        route.setSignals(signals);
        list.add(route);
        return list;
    }

    public Railway getRailway(){
        Railway railway = new Railway();
        return railway;
    }

    public static void writeFile(String filePath, String sets)
            throws  IOException {
        FileWriter fw = new FileWriter(filePath);
        PrintWriter out = new PrintWriter(fw);
        out.write(sets);
        out.println();
        fw.close();
        out.close();
    }

    public static String readFile(String path) {
        File file = new File(path);
        BufferedReader reader = null;
        String laststr = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr = laststr + tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return laststr;
    }
}
