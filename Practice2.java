import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by kohas02 on 7/4/18.
 */
public class Practice2 {
    private boolean isPrime(int num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i ==0)
                return false;
            else
                return true;
        }
        return false;
    }

    private void primeInReverseOrder(int num){

        for(int i=num;i>=2;i--){
            boolean isPrime = true;
            //this loop will chk if its prime
            for(int count = 2; count <= Math.sqrt(i); count++){
                 if(i % count ==0){
                     isPrime=false;
                 }
            }
            if(isPrime){ System.out.print(" "+i);}

        }
    }

    private int factorial(int num){
        if(num<=1)
            return 1;
        return num*factorial(num-1);
    }


    private int fibonacci(int n){

        if(n==0) return 0;
        if(n==1) return 1;

        return fibonacci(n-1)+fibonacci(n-2);
    }


    private int[] reverse(int[] array){
        List list = Arrays.asList(array);
        Collections.reverse(list);
        return array;
    }

//Trailing 0s in n! = Count of 5s in prime factors of n!
    private int countOfTrailingZerosInFactorialOfN(int n){
        int count =0;
        for(int i=5;n/i >=1;i=i*5){
            count=count+n/i;
        }
        return count;
    }

    public static void main(String[] main){
        Practice2 practice = new Practice2();

        System.out.println("7 is prime ? "+practice.isPrime(7));
        System.out.println("4 is prime ? "+practice.isPrime(4));

        System.out.println("Printing prime in reverse Order \n");
        practice.primeInReverseOrder(10);

        System.out.println("\nFactorial of 5 is "+practice.factorial(5));

        System.out.println("\n6th element in fibonacci = "+ practice.fibonacci(6) );


    }
}
