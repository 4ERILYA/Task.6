package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static double calcValueOfFunction(double x) {
        return 1 / (1 + 3 * x);
    }

    public static void main(String[] args) {
        double sumOfTermsGreaterThanE = 0;
        double x = readVariables("Input X [-1; 1] = ");
        double n = readVariables("Input n = ");
        double e = readVariables("Input e = ");

        double sumOfNTerms = findTheProgression(x, n);
        double ne = addNumbers(x, 1, e);
        double ne10 = addNumbers(x, 1, e / 10);
        double functionValue = calcValueOfFunction(x);
        printResult(e, ne, n, sumOfNTerms, sumOfTermsGreaterThanE, x, e / 10, ne10, functionValue);
    }

    private static double readVariables(String str) {
        Locale.setDefault(Locale.ROOT);
        Scanner sc = new Scanner(System.in);
        System.out.println(str);
        return sc.nextDouble();
    }

    private static double findTheProgression(double x, double n) {
        double sumOfNTerms = 0;
        for (int i = 0; i < n; i++) {
            sumOfNTerms += Math.pow(3, i) * Math.pow(x, i) * Math.pow(-1, i);
        }
        return sumOfNTerms;
    }

    private static double addNumbers(double x, double functionValue0, double e) {
        double sumOfNTerms = 0;
        double member = 0;
        for (double i = 0; Math.abs(member) < e; i++) {
            member = functionValue0 * (-3) * x;
            sumOfNTerms += member;
        }
        return sumOfNTerms;
    }

    private static void printResult(double e, double ne, double n, double sumOfNTerms, double sumOfTermsGreaterThanE,
                                    double x, double ne10, double sumOfTermsGreaterThanEDividedByTen, double functionValue) {
        System.out.printf("n = %d; sumn = %.10f%n", n, sumOfNTerms);
        System.out.printf("f(x) = %.10f%n", functionValue);
        System.out.printf("e = %.10f; ne = %d; sume = %.10f%n", e, ne, sumOfTermsGreaterThanE);
        System.out.printf("e / 10 = %.10f; ne10 = %d; sume10 = %.10f%n", e / 10, ne10, sumOfTermsGreaterThanEDividedByTen);
    }

}