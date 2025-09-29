package TTTTstudy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();

        System.out.println(A*5);
        System.out.println(A*8);
        System.out.println(A*3);
        System.out.println(A*B);



        scan.close();
    }

}

