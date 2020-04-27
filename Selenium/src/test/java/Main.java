import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    public static int[] tab (){
        int [] tab = new int [15];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = i;
        }

        int [] finalTab = new int [tab[10]/10];
        //System.out.println(tab[10]/10);
        //System.out.println(finalTab.length);
        for (int i = 0; i < finalTab.length; i++) {
            finalTab[i] = tab[tab.length-1-i];
        }

        return finalTab;
    }

    public static void swicher (String sight){
        switch (sight){
            case "AA":
                System.out.println(sight += "B");

            case "A" :
                System.out.println(sight += "A");
                break;

            case "B":
                System.out.println(sight += "A");

            default: swicher(sight);
        }
    }

    public static int bittersweet () {

        int a = 011;
        //System.out.println(Integer.toBinaryString(a));
        //System.out.println(a>>1);
        //System.out.println(a>>1<<2);

        return a>>(3&1)<<2;

    }

    public static class A{
        int wrt;
        public A(){
            System.out.println("KA");
        }

        public void show(){
            System.out.println("I'm A");
        }
    }

    public static class B extends A{
        public B(){
            System.out.println("KB");
        }

        public void show(){
            System.out.println("I'm B");
        }
    }

    public static class C extends B{
        public C(){
            super();
            System.out.println("KC");
        }

        public void show(){
            System.out.println("I'm C");
        }

        public void sShow(){
            super.show();
        }
    }

    public static String [] spliter (){
        String a = "1230 189 21323 3043 23 023 1111";
        return a.split("\\b\\d[1-3][1-3]\\b");
    }

    public static void main(String[] args) {

        int a = 15;
        //System.out.println(BigInteger.valueOf(a).byteValue());
        System.out.println(BigInteger.valueOf(63).bitCount());
        System.out.println(BigInteger.valueOf(51).testBit(0));
        System.out.println(Integer.toBinaryString(-90));
        System.out.println(Integer.parseInt("01111", 2));
        System.out.println(Integer.reverseBytes(16));
        System.out.println(Integer.reverse(16));

  /*      System.out.println("\tA");
        System.out.println(Arrays.toString(tab()));

        System.out.println("\tB");

        int matrix[][] = {
                {1,2,3,1,2,3},
                {4,5,6,0},
                {7,8,9}
        };

        for (int i = 0; i < matrix[2].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("\tC");
        swicher("A");

        System.out.println("\tD");
        System.out.println(bittersweet());

        System.out.println("\tE");
        System.out.println(bittersweet());

        System.out.println("\tF");*/
        //A[] objTab = {new A(), new B(), new C()};
        A[] objTab = new A[4];
        System.out.println("////");
        objTab[0] = new A();
        System.out.println("////");
        objTab[1] = new B();
        System.out.println("////");
        objTab[2] = new C();
        System.out.println("////");

        System.out.println("\tG");
        for (int i = 0; i < objTab.length-1; i++) {
            objTab[i].show();
        }

        System.out.println("\tH");
        ((C)objTab[2]).sShow();

        System.out.println("\tI");
        try{
            objTab[10].show();
        }catch (IndexOutOfBoundsException e){
            System.out.println("IBE");
        }catch (NullPointerException e){
            System.out.println("NPE");
        }catch (Exception e){
            System.out.println("EER");
        }


        try{
            objTab[3].show();
        }catch (IndexOutOfBoundsException e){
            System.out.println("IBE");
        }catch (NullPointerException e){
            System.out.println("NPE");
        }catch (Exception e){
            System.out.println("EER");
        }

        try{
            objTab[1].show();
        }catch (Exception e){
            System.out.println("EER");
        }

        System.out.println("\tJ");
        System.out.println(Arrays.toString(spliter()));

    }
        /*int matrix [][] = {
                {1, 2, 3, 4, 0},
                {8, 7, 6, 5, 1},
                {9, 12, 10, 11, 3},
                {9, 12, 10, 11, 7},
                {8, 7, 6, 5, 9},
        };




        try{
            //System.out.println("F " + pow(matrix, 5, 2));
        } catch (IndexOutOfBoundsException e){
            System.out.println("A Error!");
        }

        String s1 = "Ala ma kota";
        String s2 = new String("Ala ma kota");
        System.out.println("S " + s2.equals(s1));

        int d = s1 == s2 ? 20:30;

        A a = new A(10);
        A b = new B(d, 20);
        A c = new C(50, 40);

        A [] tab = {a, b, c};

        for(int i = tab.length-1; i >= 0; i-=2){
            try{
                tab[i].show();
            } catch (ErrorA errorA) {
                System.out.println(errorA.getMessage());
            }finally {
                System.out.println("PPJ FASSED");
            }
        }

        String s = "XYZ";
        int x = 0;
        boolean is = false;
        if(is = true){
            s += "Z";
        }
        else{
            s += "Y";
        }
        switch (s){
            case "XYZ":
                System.out.println("Hah");
            case "XYZY":
                System.out.println("XD");
                break;
            case "XYZZ":
                System.out.println("IksDe");
                break;
            default:
                System.out.println("Awesome!");
        }

        int o = 2; // ocena z PPJ
        System.out.println(((o++ + ++o + o + --o) - 1 )/ o++);

        int lastMatrix [][] = {
                {1, 2, 3, 4, 5},
                {5, 4, 3},
                {6, 7, 8, 9},
                {9, 8, 7, 6, 5},
        };
        for(int i = 0; i < lastMatrix.length; i++){
            for (int j = lastMatrix[i].length-1; j > 0; j--) {
                //System.out.println(i + " " + j + "\n");
                System.out.print(lastMatrix[i][j] + " ");
                j--;
            }//
            System.out.println();
        }

    }

    public static int pow(int tab[][], int a, int b){
        if(b == 1){
            return 007;
        }
        else{
            System.out.println((a-2) + " " + (a/b+1));

            int res = pow(tab,a-2, a/b+1) + tab[a-1][a-1];
            int s = tab[a-1][a-1];
            System.out.println(s);
            return res;
        }
    }
}

class A{

    int wrtI;

    public A(int wrtI){
        this.wrtI = wrtI + 5;
        System.out.println("A " + wrtI);
    }

    public void show() throws ErrorA{
        if(wrtI <= 10){
            throw new ErrorA("Line 65 - error");
        }
        else{
            System.out.println("A " + wrtI);
        }
    }

}

class B
        extends A{
    int wrtJ, wrtK = -10;

    public B(int wrtI, int wrtJ, int wrtK){
        super(wrtI);
        this.wrtJ = wrtJ;
        wrtK = wrtK - 10;
        System.out.println("B3 " + wrtK);
    }

    public B(int wrtI, int wrtJ){
        this(wrtI, wrtJ, 40);
        System.out.println("B2 " + this.wrtK + wrtI);
    }

    public void show(){
        System.out.println("B" + wrtJ + " " + wrtK);
    }

}

class C
        extends A {

    int wrtL;

    public C(int wrtI, int wrtL) {
        super(wrtI);
        this.setL(wrtL);
        System.out.println("C " + this.wrtL);
    }

    public void setL(int wrtL){
        this.wrtL = wrtL - 40;
        do{
            System.out.println("DO " + this.wrtL);
            this.wrtL = this.wrtL - 2;
        }while (wrtL < 0);
    }

    public void show(){
        System.out.println("C" + wrtL + wrtI);
    }

}

class ErrorA extends Exception{
    ErrorA(String txt){
        super(txt);
    }
}

class ErrorB extends Exception{
    ErrorB(String txt){
        super("Error2 " + txt);
    }*/
}