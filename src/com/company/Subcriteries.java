package com.company;

import java.util.Scanner;

public class Subcriteries {
    public void valSubcriteria(int nk, int np, double[][] vp, String[] crit, String[][] subcrit) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите оценку каждого из подкритериев (от 1 до 10):");
        int[][] pk = new int[nk][np]; // Массив оценок подкритериев
        int[] sp = new int[nk]; // Массив суммы оценок подкритериев
        for (int i = 0; i < nk; i++) {
            System.out.println((i + 1) + ". " + crit[i]);
            for (int j = 0; j < np; j++) {
                System.out.print((i + 1) + "." + (j + 1) + ". " + subcrit[i][j] + " = ");
                pk[i][j] = scan.nextInt(); // Ввод оценок подкритериев
                if (pk[i][j] < 1 || pk[i][j] > 10) {
                    System.err.println("Ошибка! Оценка подкритерия должна находиться в интервале от 1 до 10");
                    System.exit(0);
                } else {
                    sp[i] += pk[i][j]; // Сумма оценок подкритериев
                }
            }
        }
        for (int i = 0; i < nk; i++) {
            for (int j = 0; j < np; j++) {
                vp[i][j] = (double) pk[i][j] / sp[i];    // Расчет векторов оценок подкритериев
            }
        }
        System.out.println("Коэффициенты приоритетов подкритериев [критерий][подкритерий]:");
        for (int i = 0; i < nk; i++) {   // Вывод коэффициентов приоритетов подкритериев
            for (int j = 0; j < np; j++)
                System.out.println("[" + (i + 1) + "] [" + (j + 1) + "] = " + Math.round(vp[i][j] * 10000) / 10000.0);
        }
    }
}
        /*public static double maxVal(double[][] p){
            double max = Double.MIN_VALUE;

            for (int i = 0; i < p.length; i++) {
                for (int j = 0; j < p[i].length; j++) {


                    if (p[i][j] > max) {

                        max = p[i][j];
                    }
                }
            }
            return max;
        }*/


