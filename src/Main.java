/**
 * Created by tommy on 2016/2/15.
 */
public class Main {
    public static void main(String[] args){
        // blocked - > true   ;   not blocked - > false
        boolean block1 = false;
        boolean block2 = false;
        boolean block3 = false;
        boolean block4 = false;
        boolean block5 = false;
        boolean block6 = false;

        // UP - > true   ;   DOWN - > false
        boolean signal1 = true;
        String s1 = "s1:true";
        boolean signal2 = false;
        String s2 = "s2:false";
        boolean signal3 = false;
        String s3 = "s3:false";
        boolean signal4 = true;
        String s4 = "s4:true";
        boolean signal5 = false;
        String s5 = "s5:false";
        boolean signal6 = true;
        String s6 = "s6:true";
        boolean signal7 = true;
        String s7 = "s7:true";
        boolean signal8 = false;
        String s8 = "s8:false";

        // plus -> true  ;  minus -> false
        boolean point1 = true;
        boolean point2 = true;

        Route r1 = new Route("s1","s6","p1:p;p2:m",s2+";"+s3+";"+s5,"b2;p1;b4","r4");
        Route r2 = new Route("s6","s7","p2:p",s8+";"+s4,"p2;b5","r3");
        Route r3 = new Route("s8","s3","p2:m;p1:p",s7+";"+s6+";"+s1,"b5;p2;b3","r2;r4");
        Route r4 = new Route("s3","s2","p1:m",s1+";"+s5,"b3;p1;b2","r1;r3");


    }
}
