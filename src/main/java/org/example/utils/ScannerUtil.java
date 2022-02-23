package org.example.utils;

import java.util.Scanner;

public class ScannerUtil {
   static final Scanner SCANNER = new Scanner(System.in);

    public static int nextIntAndMoveToTheNextLine() {
        int integer = SCANNER.nextInt();
        SCANNER.nextLine();
        return integer;
    }

    public static String nextLine() {
        return SCANNER.nextLine();
    }

}
