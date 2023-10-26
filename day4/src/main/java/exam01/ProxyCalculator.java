package exam01;

public class ProxyCalculator implements Calculator{

    private Calculator calculator;

    // 열린 구조
    public ProxyCalculator(Calculator calculator) {
        this.calculator = calculator;

    }

    // 캡슐화
    @Override
    public long factorial(long num) {
        long timeS1 = System.nanoTime();
        try{
            long result = calculator.factorial(num); // 핵심 기능(대신 수행)

            return result;
        } finally {
            long timeE1 = System.nanoTime();
            System.out.println("time = " + (timeE1- timeS1));
        }
    }
}
