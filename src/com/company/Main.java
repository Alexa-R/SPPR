package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        System.out.println("Здравствуйте, уважаемый пользователь! Введите нужный символ:" +
                "\nS - Начать работу" +
                "\nE - Выйти из программы");
        input = scan.nextLine();
        System.out.println(" ");
        while (!"E".equals(input)) {
            System.out.println("Укажите название проблемы: ");
            String problem = scan.nextLine();
            System.out.println("Введите количество критериев: ");
            int nk = scan.nextInt();
            if (nk <= 1) {
                System.err.println("Ошибка, количество критериев должно быть больше 1");
                System.exit(0);
            }
            System.out.println("Введите количество подкритериев: ");
            int np = scan.nextInt();
            if (np <= 1) {
                System.err.println("Ошибка, количество подкритериев должно быть больше 1");
                System.exit(0);
            }
            System.out.println("Введите количество альтернатив: ");
            int na = scan.nextInt();
            if (na <= 1) {
                System.err.println("Ошибка, количество альтернатив должно быть больше 1");
                System.exit(0);
            }

            String[] crit = new String[nk]; //Массив названий критериев
            String[][] subcrit = new String[nk][np]; //Массив названий подкритериев
            for (int i = 0; i < nk; i++) {
                System.out.println("Введите название критерия " + (i + 1) + ": " + scan.nextLine());
                crit[i] = scan.nextLine(); // Ввод названий критериев
                System.out.println(" ");
                System.out.println("Введите названия подкритериев для критерия " + crit[i] + ": ");
                for (int j = 0; j < np; j++) {
                    subcrit[i][j] = scan.nextLine(); // Ввод названий подкритериев
                }
            }
            String[] alt = new String[na]; //Массив названий альтернатив
            for (int i = 0; i < na; i++) {
                System.out.println("Введите название альтернативы " + (i + 1) + ": " + scan.nextLine());
                alt[i] = scan.nextLine();
            }
            /*List list = new List();
            list.showList(problem, crit, subcrit, alt, nk, np);*/
            System.out.println(" ");
            System.out.println("Оцените значимость критериев, подкритериев и альтернатив.");
            System.out.println(" ");
            System.out.println("Шкала оценок: " +
                    "\n10 баллов - очень высокая значимость" +
                    "\n8 баллов - высокая значимость" +
                    "\n6 баллов - средняя значимость" +
                    "\n4 балла - низкая значимость" +
                    "\n2 балла - очень низкая значимость");
            System.out.println(" ");
            double[] vk = new double[nk]; // Массив оценок критериев
            Criteries criteries = new Criteries();
            criteries.valCriteria(nk, vk, crit);

            double[][] vp = new double[nk][np]; // Массив оценок подкритериев
            Subcriteries subcriteries = new Subcriteries();
            subcriteries.valSubcriteria(nk, np, vp, crit, subcrit);

            int krp = np * nk;  // Количество всех подкритериев

            double[][] va = new double[krp][na];  // Массив оценок альтернатив
            System.out.println(" ");
            Alternatives alternatives = new Alternatives();
            alternatives.valAter(na, krp, nk, np, va, alt, subcrit);

            double[] prp = new double[krp];   // Массив коэффициентов приоритетов подкритерий
            for (int i = 0, n = 0; i < nk; i++)
                for (int j = 0; j < np; j++) {
                    prp[n] = vk[i] * vp[i][j];
                    n++;
                }
            double[][] ap = new double[krp][na];    // Массив векторов альтернатив по подкритериям
            for (int i = 0; i < na; i++)
                for (int j = 0; j < krp; j++)
                    ap[j][i] = prp[j] * va[j][i];

            double[] gl = new double[na];    // Массив коэффициентов глобальных приоритетов альтернатив

            double max = 0;   // Инициализация максимального значения коэффициента глобального приоритета альтернатив
            int number = 0;   // Инициализация номера этого коэффициента

            for (int i = 0; i < na; i++) {
                for (int j = 0; j < krp; j++)
                    gl[i] += ap[j][i];

                System.out.println("Оценка альтернативы [" + (i + 1) + "] = " + Math.round(gl[i] * 10000) / 10000.0);
                if (gl[i] > max) {
                    max = gl[i];
                    number = i;
                }
            }
            System.out.println(" ");
            System.out.println("Наиболее подходящая альтернатива: " + alt[number]);
            System.out.println(" ");
            System.out.println("Рассчеты произведены! Введите нужный символ:" +
                    "\nA - Оценить другую проблему" +
                    "\nE - Выйти из программы");
            input = scan.nextLine();
            System.out.println(" ");
        }
    }
}