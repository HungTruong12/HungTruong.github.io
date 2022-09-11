package javaapplication1;
import java.util.*;

class VDV{
    private String ma, name, where;
    private long v;
    private int h, phut;
    public VDV(String ten, String s, String gio){
        this.name = ten;
        this.where = s;
        String a[] = s.split(" "), s1 = "";
        for(String x : a)
            s1 += x.substring(0,1);
        String b[] = ten.split(" ");
        for(String x : b)
            s1 += x.substring(0,1);
        this.ma = s1;
        if(gio.charAt(2) != ':') gio = '0' + gio;
        this.h = Integer.parseInt(gio.substring(0,2)) - 6;
        this.phut = Integer.parseInt(gio.substring(3));
//        double x = ;
        this.v = Math.round(120 / (h + (double) phut/60));
    }
    public int getgio(){
        return h;
    }
    public int getphut(){
        return phut;
    }
    public String out(){
        return ma + " " + name + " " + where + " " + v + " Km/h";
    }
}
public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<VDV> a = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            a.add(new VDV(sc.nextLine(), sc.nextLine(), sc.next()));
        }
        Collections.sort(a, Comparator.comparingInt(VDV::getgio).thenComparing(VDV::getphut));
        for(VDV x : a)
            System.out.println(x.out());
    }
}
