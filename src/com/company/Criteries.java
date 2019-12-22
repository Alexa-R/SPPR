package com.company;

import java.util.Scanner;

public class Criteries {
    public void valCriteria(int nk, double[] vk, String[] crit) {
        Scanner scan = new Scanner(System.in);
        int[] sk = new int[nk]; // Массив оценок критериев
        int s = 0;
        System.out.println("Введите оценку критерия: ");
        for (int i = 0; i < nk; i++) {
            System.out.print((i + 1) + ". " + crit[i] + " = ");
            sk[i] = scan.nextInt(); // Ввод оценок критерия
            if (sk[i] < 1 || sk[i] > 10) {
                System.err.println("Ошибка! Оценка критерия должна находиться в интервале от 1 до 10");
                System.exit(0);
            } else {
                s += sk[i];    // Сумма оценок критериев
            }
        }
        for (int i = 0; i < nk; i++) {
            vk[i] = (double) sk[i] / s;  // Расчет векторов оценок критериев
        }
        System.out.println("Коэффициенты приоритетов критериев:");
        for (int i = 0; i < nk; i++)   // Вывод коэффициентов приоритетов критериев
            System.out.println("[" + (i + 1) + "] = " + Math.round(vk[i] * 10000) / 10000.0);
    }
}

