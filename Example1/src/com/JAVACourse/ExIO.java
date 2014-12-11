/**
 * Created by kevin on 12/2/14.
 */
package com.JAVACourse;

import java.util.Scanner;
import java.io.*;

public class ExIO {
    public static void main(String []args) throws Exception {
        //Use Scanner
        System.out.println("Input a number:");
        Scanner sr = new Scanner(System.in);

        int a = sr.nextInt();

        System.out.println("Int="+a);

        //User Buffer Reader
        System.out.println("Input a String:");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.println("br = "+ br.readLine());

    }
}
