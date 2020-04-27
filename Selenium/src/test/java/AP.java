public class AP {

    public static void main(String[] args){
        int a = 32;
        int b = a << 2;
        System.out.println(Integer.toBinaryString(a) + " " + b);
        System.out.println(Integer.toBinaryString(b));

        String c = b.toString().substring(0, b.toString().length()-2);
        String d = b.toString().substring(b.toString().length()-2);
        System.out.println(c + "_" + d);
    }
}
