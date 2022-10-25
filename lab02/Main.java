import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println("argument: " + args[0]);
        int p = 397;
        int q = 103;
        int n = p * q;
        int fiN = fi(p, q);

        int e = 3;
        while (euclid(e, fiN) != 1){
            e += 2;
        }

        int d = extendedEuclid(e, fiN);

        System.out.println("n = " + n + " e = " + e + " d = " + d);

        byte[] tab = new byte[args[0].length()];

        // copy argument into byte array
        for (int i = 0; i < args[0].length(); i++){
            tab[i] = (byte) args[0].charAt(i);
        }

        // encode argument
        BigInteger[] encodedTab = new BigInteger[tab.length];

        for (int i = 0; i < tab.length; i++){
            encodedTab[i] = BigInteger.valueOf(tab[i]).modPow(BigInteger.valueOf(e), BigInteger.valueOf(n));
        }

        // decode argument
        char[] decodedTab = new char[encodedTab.length];

        for (int i = 0; i < encodedTab.length; i++){
            decodedTab[i] =  (char) Byte.parseByte(encodedTab[i].modPow(BigInteger.valueOf(d), BigInteger.valueOf(n)).toString());
        }

        // print decoded
        String result = "";
        for (int i = 0; i < decodedTab.length; i++){
            result += decodedTab[i];
        }

        System.out.println("decoded: " + result);
    }

    public static int fi(int p, int q) {
        return (p - 1) * (q - 1);
    }

    public static int euclid(int a, int b){
        int temp;
        while(b != 0){
            temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    public static int extendedEuclid(int a, int b){
        int x0 = 1;
        int x = 0;
        int b0 = b;
        int q, temp;

        while(b != 0){
            q = a / b;
            temp = x;
            x = x0 - q * x;
            x0 = temp;
            temp = a % b;
            a = b;
            b = temp;
        }

        if (x0 < 0) {
            x0 = x0 + b0;
        }

        return x0;
    }
}