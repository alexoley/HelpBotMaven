package telegram.fit;

import java.math.BigInteger;
import java.util.ArrayList;

public class RoPollard {

    final static BigInteger zero = new BigInteger("0");
    final static BigInteger one = new BigInteger("1");
    final static BigInteger two = new BigInteger("2");
    final static BigInteger three = new BigInteger("3");

    private static boolean comp(int i)
    {
        if(i>=0)
            return true;
        else
            return false;
    }

    private static ArrayList calculate(String xx, String gg, String pp){
        ArrayList<ArrayList> mass = new ArrayList<>();

        BigInteger x = new BigInteger(xx);
        BigInteger g = new BigInteger(gg);
        BigInteger p = new BigInteger(pp);

        BigInteger z,u,vv;
        z = new BigInteger("1");
        u = new BigInteger("0");
        vv = new BigInteger("0");
        for(int j=0; j<Integer.MAX_VALUE; j++) {
            final BigInteger q =z;
            final BigInteger w =u;
            final BigInteger e =vv;
            mass.add(new ArrayList<BigInteger>() {{
                add(q);
                add(w);
                add(e);
            }});
            for(int i=0; i<mass.size()/2; i++) {
                if(i!=0 && mass.get(i).get(0).equals(mass.get(i*2).get(0)))
                    return mass;
            }
            if(comp(z.compareTo(zero)) && !comp(z.compareTo(p.divide(three))))
            {
                u=u.add(one).mod(p.subtract(one));
                vv=vv.mod(p.subtract(one));
            }
            if(comp(z.compareTo(p.divide(three))) && !comp(z.compareTo((p.divide(three)).multiply(two))))
            {
                u=u.multiply(two).mod(p.subtract(one));
                vv=vv.multiply(two).mod(p.subtract(one));
            }
            if(comp(z.compareTo((p.divide(three)).multiply(two))) && !comp(z.compareTo(p)))
            {
                u=u.mod(p.subtract(one));
                vv=vv.add(one).mod(p.subtract(one));
            }
            z=((x.modPow(u,p)).multiply(g.modPow(vv,p)).mod(p));
        }
        return mass;
    }

    public static String getResult(String xx, String gg, String pp){
        int i;
        ArrayList<ArrayList> mass = new ArrayList<>(calculate(xx,gg,pp));
        StringBuilder result = new StringBuilder();
        result.append("i"+"  "+"z"+"  "+"u"+"  "+"v"+"\n");
        for(i=0; i<mass.size()-1; i++){
            result.append(i+"  "+mass.get(i).get(0)+"  "+mass.get(i).get(1)+"  "+mass.get(i).get(2)+"\n");
        }
        result.append("\n");
        result.append("z"+i/2+"="+"z"+--i+"\n");
        //( 40 − 48 ) y ≡ 13 − 57 (mod 100 )
        BigInteger u2 = (BigInteger)mass.get(i).get(1);
        BigInteger u1 = (BigInteger)mass.get(i/2).get(1);
        BigInteger v1 = (BigInteger)mass.get(i/2).get(2);
        BigInteger v2 = (BigInteger)mass.get(i).get(2);
        BigInteger u2u1 = u2.subtract(u1);
        BigInteger v1v2 = v1.subtract(v2);
        result.append("( "+u2+" - "+u1+" )"+" y ≡ " +v1+" - "+v2+" (mod "+pp+")"+"\n");
        result.append(u2u1+" y ≡ " +v1v2+" (mod "+pp+")"+"\n");
        if(u2u1.compareTo(zero)==-1 && v1v2.compareTo(zero)==-1){
            result.append(u2u1.abs()+" y ≡ " +v1v2.abs()+" (mod "+pp+")"+"\n");
        }
        else if(v1v2.compareTo(zero)==-1){
            result.append(u2u1+" y ≡ " +v1v2.add(new BigInteger(pp.toString()))+" (mod "+pp+")"+"\n");
        }
        return result.toString();
    }
}

