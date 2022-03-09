package org.example.controller.utils;

import java.util.Scanner;

public class ScannerUtil {
 private  static final Scanner SCANNER = new Scanner(System.in);

    public static int nextIntAndMoveToTheNextLine() {
        try {
            return  SCANNER.nextInt();
        } finally {
            SCANNER.nextLine();
        }


    }

    public static double nextDoubleAndMoveToTheNextLine(){
        try {
            return SCANNER.nextDouble();
        } finally {
            SCANNER.nextLine();
        }

    }

    public static String nextLine() {
        return SCANNER.nextLine();
    }

}
