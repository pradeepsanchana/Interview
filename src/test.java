import scala.math.*;

import java.math.*;

/**
 * Created by pradeepsanchana on 19/06/18.
 */
public class test {
    static String[] twins(String[] a, String[] b) {
        String[] c = new String[a.length];
        for(int i=0 ;i<a.length;++i){
            if(a[i].length() != b[i].length()){
                c[i] ="No";
            } else{
                for(int j=0;j<a[i].length();++j){
                    if(b[i].indexOf(a[i].charAt(j))%2 != j%2 && b[i].lastIndexOf(a[i].charAt(j))%2 != j%2){
                        c[i] = "No";
                        break;

                    }
                    if (j==a[i].length()-1 && c[i]!="No"){
                        c[i] ="Yes";
                    }
                }
            }
        }
        return c;
    }


    public static void main(String[] args){
        String[] a = new String[3];
        String[] b = new String[3];
        a[0] ="abc";
        a[1]= "abcd";
        int n=50;
        String c= cal(a, n);
        //for (int i=0;i<c.length;++i){
            System.out.println(c);

        //}
    }
    static String cal(String[] a,int n){
        BigInteger cou = BigInteger.valueOf(1L);
        BigInteger value = BigInteger.valueOf(1L);
        int conv = 0;
        BigInteger totalSum = BigInteger.valueOf(0L);
        for(int i=0;i<a.length;++i){

            for(int j=0;j<a[i].length();++j){
                int ch = (int)a[i].charAt(0);
                conv = (int)ch;
                value = BigInteger.valueOf(conv);
                value = value.pow(n);
                cou = value.multiply(cou);
            }
            totalSum = cou.add(totalSum);
        }
        if(totalSum.mod(BigInteger.valueOf(2L)).equals(BigInteger.valueOf(0L))){
            return "EVEN";
        } else{
            return "ODD";
        }
    }



}
