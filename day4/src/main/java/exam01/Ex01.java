package exam01;

public class Ex01 {
    public static void main(String[] args) {

        ImplCalculator cal1 = new ImplCalculator();
        long result1 = cal1.factorial(10); // 핵심기능
        System.out.println("result1 = ");

        RecCalculator cal2 = new RecCalculator();
        long result2 = cal2.factorial(10); // 핵심기능
        System.out.println("result2 = ");

        System.out.println(result1);
        System.out.println(result2);

    }
}
