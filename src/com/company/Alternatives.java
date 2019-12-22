package com.company;

import java.util.Scanner;

public class Alternatives {
    public void valAter(int na, int krp, int nk, int np, double[][] va, String[] alt, String[][] subcrit) {
        Scanner scan = new Scanner(System.in);
        int numb1 = 1;
        int numb2 = 1;
        System.out.println("Введите оценку альтернатив по подкритериям (от 1 до 10):");
        int[][] ma = new int[krp][na]; // Массив оценок альтернатив
        int[] sa = new int[krp]; // Массив суммы оценок альтернатив
        System.out.println("Подкритерии: ");

        for (int i = 0; i < nk; i++) {
            for (int j = 0; j < np; j++) {
                System.out.println((numb1++) + ". " + subcrit[i][j] + " "); // Вывод подкритериев
            }
        }
        for (int i = 0; i < krp; i++) {
            System.out.println("Подкритерий: " + (numb2++));
            for (int j = 0; j < na; j++) {
                System.out.print("    Альтернатива: " + alt[j] + " = ");
                ma[i][j] = scan.nextInt(); // Ввод оценок альтернатив
                if (ma[i][j] < 1 || ma[i][j] > 10) {
                    System.err.println("Ошибка! Оценка альтернативы должна находиться в интервале от 1 до 10");
                    System.exit(0);
                } else {
                    sa[i] += ma[i][j]; // Сумма оценок альтернатив
                }
            }
        }
        for (int i = 0; i < krp; i++) {
            for (int j = 0; j < na; j++) {
                va[i][j] = (double) ma[i][j] / sa[i];    // Расчет векторов оценок альтернатив
            }
        }
        System.out.println(" ");
        System.out.println("Коэффициенты локальных приоритетов альтернатив [подкритерий][альтернатива]:");
        for (int i = 0; i < krp; i++) {   // Вывод коэффициентов локальных приоритетов альтернатив
            for (int j = 0; j < na; j++) {
                System.out.println("[" + (i + 1) + "] [" + (j + 1) + "] = " + Math.round(va[i][j] * 10000) / 10000.0);
            }
        }
    }
}
