package exam01;

public class Ex02 {
    public static void main(String[] args) {

        Calculator cal1 = new ProxyCalculator(new ImplCalculator());
        long result1 = cal1.factorial(10);
        System.out.println("result1 = " + result1  );

        Calculator cal2 = new ProxyCalculator(new RecCalculator());
        long result2 = cal2.factorial(10);
        System.out.println("result2 = " + result2  );

    }
}