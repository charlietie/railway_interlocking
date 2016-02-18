import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy on 2016/2/18.
 */
public class FileHandler {
    /**
     * read content from a file
     * @param filename
     * @return the content of the file
     */
    static String read(String filename){
        File file = new File(filename);
        Reader reader = null;
        String s="";
        try {
            // read one byte at a time
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                if (((char) tempchar) != '\r') {
//                    System.out.print((char) tempchar);
                    s+=(char) tempchar;
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

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

    public List<Block> getBlock(){
        List<Block> list = new ArrayList<>();
        Block b1 = new Block("b1",0);
        Block b2 = new Block("b2",0);
        Block b3 = new Block("b3",0);
        Block b4 = new Block("b4",0);
        Block b5 = new Block("b5",0);
        Block b6 = new Block("b6",0);
        Block p1 = new Block("p1",1);
        Block p2 = new Block("p2",1);

//        b1.setNeighs(b1.getNeighs().add(b2));

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

}
