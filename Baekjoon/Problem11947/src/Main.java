import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static void testCase() {
        BigInteger answer = BigInteger.ZERO;

        long n = scanner.nextLong();

        Lovely input = new Lovely(n);
        Lovely middle = new Lovely((long)Math.pow(10, input.length-1)*5);

        if(input.boundary < middle.min) {
            BigInteger min = new BigInteger(Long.toString(input.min));
            answer = min.multiply(new BigInteger(Long.toString(input.max)));
        }else if(input.boundary >= middle.min) {
            BigInteger min = new BigInteger(Long.toString(middle.min));
            answer = min.multiply(new BigInteger(Long.toString(middle.max)));
        }
        System.out.println(answer);
    }

    public static void main(String[] args){
        int tc = scanner.nextInt();
        for(int t = 0 ; t < tc ; t++){
            testCase();
        }
    }
}
