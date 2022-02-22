package org.example.utils;

import java.util.Scanner;

public class ScannerUtil {
    Scanner scanner = new Scanner(System.in);

    public int nextIntAndMoveToTheNextLine() {
        int integer = scanner.nextInt();
        scanner.nextLine();
        return integer;
    }

    public String nextLine() {
        return scanner.nextLine();
    }

}
