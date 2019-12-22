package com.company;

public class List {
    public void showList(String problem, String[] crit, String[][] subcrit, String[] alt, int nk, int np) {
        int numb = 1;
        int numba = 1;
        System.out.println("Проблема: ");
        System.out.println(problem);
        System.out.println("Критерии:");
        for (String cr : crit) {
            System.out.println((numb++) + ". " + cr + ";"); // Вывод критериев
        }
        System.out.println("Подкритерии: ");

        for (int i = 0; i < nk; i++) {
            for (int j = 0; j < np; j++) {
                System.out.println((i + 1) + "." + (j + 1) + ". " + subcrit[i][j] + " "); // Вывод подкритериев
            }
        }
        System.out.println("Альтернативы: ");
        for (String alter : alt) {
            System.out.println((numba++) + ". " + alter + ";"); // Вывод альтернатив
        }
    }
}
