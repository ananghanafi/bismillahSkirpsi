/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillahskirpsi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javax.print.DocFlavor;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AnangHanafi
 */
public class BismillahSkirpsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] jarak = new int[][]{
            {0, 3, 18, 23, 29, 17, 23, 21, 10, 20, 29, 50, 55, 17, 10, 11, 14},
            {3, 0, 15, 17, 26, 14, 20, 23, 13, 23, 32, 53, 58, 20, 13, 14, 16},
            {18, 15, 0, 35, 41, 29, 35, 38, 41, 38, 47, 68, 73, 35, 28, 29, 22},
            {23, 17, 35, 0, 14, 14, 19, 40, 33, 43, 52, 73, 78, 40, 33, 24, 33},
            {29, 26, 41, 14, 0, 28, 33, 60, 39, 49, 58, 79, 84, 46, 39, 10, 33},
            {17, 14, 29, 14, 28, 0, 5, 35, 27, 37, 46, 67, 72, 34, 45, 26, 30},
            {23, 20, 35, 19, 33, 5, 0, 40, 33, 43, 52, 73, 78, 40, 33, 31, 35},
            {21, 23, 38, 40, 60, 35, 40, 0, 31, 41, 50, 71, 76, 38, 31, 28, 8},
            {10, 13, 41, 33, 39, 27, 33, 31, 0, 10, 17, 40, 45, 19, 7, 18, 18},
            {20, 23, 38, 43, 49, 37, 43, 41, 10, 0, 7, 30, 35, 29, 17, 27, 15},
            {29, 32, 47, 52, 58, 46, 52, 50, 17, 7, 0, 21, 42, 36, 24, 33, 13},
            {50, 53, 68, 73, 79, 67, 73, 71, 40, 30, 21, 0, 25, 57, 45, 58, 31},
            {55, 58, 73, 78, 84, 72, 78, 76, 45, 35, 42, 25, 0, 64, 52, 77, 57},
            {17, 20, 35, 40, 46, 34, 40, 38, 19, 29, 36, 57, 64, 0, 12, 8, 32},
            {10, 13, 28, 33, 39, 45, 33, 31, 7, 17, 24, 45, 52, 12, 0, 12, 22},
            {11, 14, 29, 24, 10, 26, 31, 28, 18, 27, 33, 58, 77, 8, 12, 0, 28},
            {14, 16, 22, 33, 33, 30, 35, 8, 18, 15, 13, 31, 57, 32, 22, 28, 0},};
        int[] beratBarang = new int[]{0, 4, 20, 5, 10, 3, 2, 100, 2, 40, 20, 12, 30, 4, 3, 2, 30};
        int[] volumeBarang = new int[]{0, 20, 25, 50, 2400, 400, 2500, 80, 28, 200, 450, 1000, 2400, 480, 40, 500, 220};
        int jumlahTujuan = 16, jumlahSales = 4, popSize = 6, maxGenerasi = 1;
        int maxBeratMuatan = 10, maxBeratMuatan2 = 1000, maxVolumeMuatan = 1200, maxVolumeMuatan2 = 2400;
        double cr = 0.2, mr = 0.3;
        Random rand = new Random();
        double fitness;
        String individu, segmen1, segmen2;
        Populasi pop;
        int k = 0;
        ArrayList<Populasi> populasi = new ArrayList<>();
        System.out.println("Inisialisasi");
        for (int i = 0; i < popSize; i++) {
            individu = "P" + (i + 1);
            System.out.println("PopSize " + (i + 1));
            int r = 0;
            int sales1, sales2, sales3, sales4;
            int[] gen2 = new int[5];
            int[] gen1 = new int[18];
            int N1 = jumlahTujuan;
            for (int j = 1; j <= (jumlahSales); j++) {
                r = rand.nextInt(N1);
                System.out.println("Random " + r);
                N1 -= r;
                System.out.println("N1 " + N1);
                if (N1 >= 0 && j <= 3) {
                    gen2[j] = r;
                    System.out.println("gen2 " + gen2[j]);
                } else if (j == 4) {
                    gen2[j] = N1 + r;
                    System.out.println("j " + j);
                }
                //   gen2[i + 1] = gen2[j];
                System.out.println("Sales ke " + (j) + " mengunjungi ke " + gen2[j] + " tujuan");
            }
            ArrayList<Integer> saleske = new ArrayList<Integer>();
            for (int j = 0; j < jumlahTujuan; j++) {
                saleske.add(new Integer(j));
            }
            Collections.shuffle(saleske);
            for (int j = 0; j < jumlahTujuan; j++) {
                gen1[j] = saleske.get(j);
            }
            sales1 = gen2[1];
            sales2 = gen2[1] + gen2[2];
            sales3 = gen2[1] + gen2[2] + gen2[3];
            sales4 = gen2[1] + gen2[2] + gen2[3] + gen2[4];
            k = 0;
            ArrayList<Integer> kotake = new ArrayList<Integer>();
            for (int j = 0; j < jumlahTujuan; j++) {
                kotake.add(new Integer(j));
            }
            Arrays.asList(N1);
            Collections.shuffle(kotake);
            for (int j = 0; j < jumlahTujuan; j++) {
                gen1[j] = kotake.get(j);
            }
            while (k <= jumlahTujuan) {
                if (k <= sales1) {
                    System.out.println("sales 1 " + gen1[k]);
                } else if (k <= sales2) {
                    System.out.println("sales 2 " + gen1[k]);
                } else if (k <= sales3) {
                    System.out.println("sales 3 " + gen1[k]);
                } else if (k <= sales4) {
                    System.out.println("sales 4 " + gen1[k]);
                }
                k++;
            }
            segmen1 = String.valueOf("" + gen1[1] + " " + gen1[2] + " " + gen1[3] + " " + gen1[4]
                    + " " + gen1[5] + " " + gen1[6] + " " + gen1[7] + " " + gen1[8]
                    + " " + gen1[9] + " " + gen1[10] + " " + gen1[11] + " " + gen1[12]
                    + " " + gen1[13] + " " + gen1[14] + " " + gen1[15] + " " + gen1[16]);
            segmen2 = String.valueOf("" + gen2[1] + " " + gen2[2] + " " + gen2[3] + " " + gen2[4]);
            System.out.println("Kromosom " + segmen1 + "\t\t" + segmen2);
            pop = new Populasi(individu, segmen1, segmen2);
            populasi.add(pop);
            //   System.out.format("P" + (i + 1) + " gen2 " + gen2[1] + " gen2 " + gen2[2] + " gen2 " + gen2[3] + "gen2 " + gen2[4] + "\n");
        }
        //Populasi
        //Crossover

        for (int i = 0; i < maxGenerasi; i++) {
            // cross over
            System.out.println("======================ITERASI KE-" + i + "========================");
            //           ArrayList<Populasi> reproduksi = new ArrayList<>(populasi);
//            reproduksi = populasi.;
            long icr = Math.round(popSize * cr);
            long imr = Math.round(popSize * mr);
            int randCr, p1random, p2random;
            String p1, p2, c1, c2, ps1, ps2;
            for (int j = 0; j < icr; j++) {
                p1random = rand.nextInt(popSize);
                p2random = rand.nextInt(popSize);
                p1 = populasi.get(p1random).getSegmen1();
                p2 = populasi.get(p2random).getSegmen1();
                ps1 = populasi.get(p1random).getSegmen2();
                ps2 = populasi.get(p2random).getSegmen2();
                randCr = rand.nextInt(jumlahTujuan);

                //potong
                c1 = crossover(p1, p2);
                System.out.println("p1 " + p1);
                System.out.println("p2 " + p2);
                System.out.println("Hasil Crossover " + c1);
                //              System.out.println("array " + Arrays.asList(populasi));

////                c1 = crossover(p1, p2);
////                System.out.println("Hasil cross over " + c1);
////                c1 = cekKromosom(c1);
////                System.out.println("Hasil inject " + c1);
////                Populasi anagen1 = new Populasi("c1", c1, hitungFitness(c1));
////                reproduksi.add(anagen1);
            }
            // mutasi
//            for (int j = 0; j < mr; j++) {
//                p1 = populasi.get(rand.nextInt(popSize)).getKromosom();
//                c2 = mutasi(p1);
//                System.out.println("Hasil Mutasi " + c2);
//                Populasi anagen2 = new Populasi("c1", c2, hitungFitness(c2));
//                reproduksi.add(anagen2);
//            }
//            reproduksi.sort(new Populasi());
//            populasi.clear();
//            for (int j = 0; j < popSize; j++) {
//                populasi.add(reproduksi.get(j));
//            }
//            System.out.println("Cek kromosom " + populasi.get(0).getKromosom());
        }
    }

    private static String crossover(String p1, String p2) {
        // ambil potongan ke 1
        Random rand = new Random();
        String potongan = "";
        int o = 0;
        String parent1[] = p1.split(" ");
        int randCros = rand.nextInt(16);
        for (int i = 0; i < parent1.length; i++) {
            System.out.println("paren 1 " + parent1[i]);
        }
        for (int i = 0; i < parent1.length; i++) {
            o++;
            if (o == randCros) {
                if (o == 16) {
                    potongan = p1 + " ";
                    p1 = "";
                } else if (o <= 16) {
                    int awal = i - 16;
                    int akhir = i;
                    p1 = "";
                    for (int k = 0; k < parent1.length; k++) {
                        if (k >= awal && k <= akhir) {
                            p1 += parent1[k] + " ";
                        } else {
                            potongan += parent1[k] + " ";
                        }
                    }
                    System.out.println("p1 " + p1);
                    System.out.println("Potongan " + potongan);
                }
            }
        }
        //tempel potongan
        String potongan2 = "";
        int randCros2 = rand.nextInt(16);
        String parent2[] = p2.split(" ");
        String p1Tambah[] = p1.split(" ");
        System.out.println("p2 " + p2);
        o = p1Tambah.length;
        int g = 0;
        for (int i = 0; i < parent2.length; i++) {
            o++;
//            String p1temp = p1Tambah[i].equals(parent2[i]);
//            stringMatch cek = new StringMatch();
            for (int j = 0; j < p1Tambah.length; j++) {
                boolean cek = parent2[i].equals(p1Tambah[j]);
                if (cek == true) {
 //                   g = 0;
                    //       System.out.println("Ada " + parent2[j]);
                } else {
                    g++;
                    if (g > p1Tambah.length) {
                        System.out.print(" " + parent2[j]);
                        g = 0;
                    }
                    //    System.out.println("Ada Lain " + parent2[j]);
                }
            }

        }
        System.out.println("Offspring 1 " + p1);
        System.out.println("Offspring 2 " + (potongan + p2));
        System.out.println("Potongan lagi " + potongan);
        for (int i = 0; i < parent2.length; i++) {
            o++;
            if (o == randCros2) {
                if (o == 16) {
                    potongan2 = p2 + " ";
                    p2 = "";
                } else if (o <= 16) {
                    int awal = i - 16;
                    int akhir = i;
                    p2 = "";
                    for (int k = 0; k < parent2.length; k++) {
                        if (k >= awal && k <= akhir) {
                            p2 += parent2[k] + " ";
                        } else {
                            potongan2 += parent2[k] + " ";
                        }
                    }
                    System.out.println("p2 " + p2);
                    System.out.println("Potongan " + potongan2);
                }
            }
        }
        return p2;

    }

//        int r2, l = 1;
//        int[] gen1 = new int[18];
//        r2 = rand.nextInt(jumlahTujuan);
//        while (l <= jumlahTujuan) {
//            if (gen1[l] == r2) {
//                r2 = rand.nextInt(jumlahTujuan);
//            } else {
//                gen1[k] = r2;
//                break;
//            }
//            l++;
//        }
//        System.out.println(" " + gen1[k]);
//        // Iterasi
//        for (int i = 0; i < iterasi; i++) {
//            // cross over
//            System.out.println("======================ITERASI KE-" + i + "========================");
//            ArrayList<Populasi> reproduksi = new ArrayList<>(populasi);
////            reproduksi = populasi.;
//            int ipc = Math.round(popsize * pc);
//            int ipm = Math.round(popsize * pm);
//            String p1, p2, c1, c2;
//            for (int j = 0; j < ipc; j++) {
//                p1 = populasi.get(rand.nextInt(popsize)).getKromosom();
//                p2 = populasi.get(rand.nextInt(popsize)).getKromosom();
//                c1 = crossover(p1, p2);
//                System.out.println("Hasil cross over " + c1);
//                c1 = cekKromosom(c1);
//                System.out.println("Hasil inject " + c1);
//                Populasi anagen1 = new Populasi("c1", c1, hitungFitness(c1));
//                reproduksi.add(anagen1);
//            }
//            // mutasi
//            for (int j = 0; j < ipm; j++) {
//                p1 = populasi.get(rand.nextInt(popsize)).getKromosom();
//                c2 = mutasi(p1);
//                System.out.println("Hasil Mutasi " + c2);
//                Populasi anagen2 = new Populasi("c1", c2, hitungFitness(c2));
//                reproduksi.add(anagen2);
//            }
//            reproduksi.sort(new Populasi());
//            populasi.clear();
//            for (int j = 0; j < popsize; j++) {
//                populasi.add(reproduksi.get(j));
//            }
//            System.out.println("Cek kromosom " + populasi.get(0).getKromosom());
//        }
//
//        model2.setValueAt("P1", 0, 0);
//        model2.setValueAt(populasi.get(0).getKromosom(), 0, 1);
//        model2.setValueAt(String.format("%.10f", populasi.get(0).getFitness()), 0, 2);
//        populasi.clear();
//        terbaik.setModel(model2);
//        terbaik.getColumnModel().getColumn(0).setPreferredWidth(120);
//        terbaik.getColumnModel().getColumn(1).setPreferredWidth(500);
//        terbaik.getColumnModel().getColumn(2).setPreferredWidth(250);
//        terbaik.setRowHeight(0, 45);
//        for (int i = 1; i < 6; i++) {
//
//        }
//        System.out.println("Jarak " + (jarak[0][8] + jarak[0][8]) + " Berat " + beratBarang[5] + " Volume " + volumeBarang[5]);
//
//    }
//
//    public double hitungFitness(String kromosom) {
//        // hitung fitness kromosom
//        long hasil, selisih;
//        double fitness, total = 0;
//        int[][] datamasukan = new int[datalatih.length][datalatih[0].length - 1];
//        for (int i = 0; i < datalatih.length; i++) {
//            for (int j = 0; j < datalatih[0].length - 1; j++) {
//                datamasukan[i][j] = (int) datalatih[i][j];
//            }
//        }
//        System.out.println("Kromosom\t\tYp\t\t|y-yp|");
//        for (int j = 0; j < datalatih.length; j++) {
//            hasil = Math.round(postfixEvaluate(kromosom, datamasukan[j]));
//            selisih = datalatih[j][datalatih[0].length - 1] - hasil;
//            if (selisih < 0) {
//                selisih = -selisih;
//            }
//            total += selisih;
//            System.out.println(kromosom + "\t" + hasil + "\t" + selisih);
//        }
//        fitness = 1 / (1 + total);
//        System.out.println("Total " + total);
//        System.out.println("Fitness " + String.format("%.10f", fitness));
//        return fitness;
//    }
//
//    public static int randomInisialisasi(int segmen1, int segmen2) {
//        int hasil = 0;
//        Random rand = new Random();
//        for (int i = 0; i < 10; i++) {
//
//        }
//        // inisialisasi operator
//        String[] operator = {"+", "-", "*", "/"};
//        // inisialisasi terminal
//        String[] terminal = new String[5];
//        String[] tampungan = {"x1", "x2", "x3", "x4", "0"};
//        tampungan[tampungan.length - 1] = String.valueOf(rand.nextInt(100) + 1);
//
//        ArrayList<Integer> random = new ArrayList<Integer>();
//        for (int r = 0; r < tampungan.length; r++) {
//            random.add(new Integer(r));
//        }
//        Collections.shuffle(random);
//        for (int j = 0; j < tampungan.length; j++) {
//            terminal[j] = tampungan[(int) random.get(j)];
//        }
//
//        // buat postfix random
//        int A = 0;
//        int O = 0;
//        for (int i = 0; i < ((operator.length + terminal.length)); i++) {
//            if (i < 2) {
//                hasil += terminal[A] + " ";
//                A++;
//            } else if (i == (operator.length + terminal.length) - 1) {
//                hasil += operator[rand.nextInt(4)];
//            } else if (A >= terminal.length) {
//                hasil += operator[rand.nextInt(4)] + " ";
//                O++;
//            } else if (A == (O + 1)) {
//                hasil += terminal[A] + " ";
//                A++;
//            } else if ((rand.nextInt(2) + 1) % 2 == 1) {
//                hasil += operator[rand.nextInt(4)] + " ";
//                O++;
//            } else {
//                hasil += terminal[A] + " ";
//                A++;
//            }
//        }
//        return hasil;
//    }
//
//    public String mutasi(String cek) {
//        Random rand = new Random();
//        String hasil = "";
//        String[] operator = {"+", "-", "*", "/"};
//        int jmlop = 0, o = 0;
//        String[] krom = cek.split(" ");
//        for (int i = 0; i < krom.length; i++) {
//            if (krom[i].equals("+") || krom[i].equals("-") || krom[i].equals("*") || krom[i].equals("/")) {
//                jmlop++;
//            }
//        }
//        int random = rand.nextInt(jmlop) + 1;
//        for (int i = 0; i < krom.length; i++) {
//            if (krom[i].equals("+") || krom[i].equals("-") || krom[i].equals("*") || krom[i].equals("/")) {
//                o++;
//                if (o == random) {
//                    krom[i] = operator[rand.nextInt(4)];
//                }
//            }
//            if (i == krom.length - 1) {
//                hasil += krom[i];
//            } else {
//                hasil += krom[i] + " ";
//            }
//        }
//        return hasil;
//    }
//
//    public String crossover(String p2, String p1) {
//        // ambil potongan ke 1
//        Random rand = new Random();
//        String potongan = "";
//        String[] ar = p1.split(" ");
//        int a = 0;
//        int o = 0;
//        int jmlop = 0;
//        for (int i = 0; i < ar.length; i++) {
//            if (ar[i].equals("+") || ar[i].equals("-") || ar[i].equals("*") || ar[i].equals("/")) {
//                jmlop++;
//            }
//        }
//        int random = rand.nextInt(jmlop) + 1;
//        for (int i = 0; i < ar.length; i++) {
//            if (ar[i].equals("+") || ar[i].equals("-") || ar[i].equals("*") || ar[i].equals("/")) {
//                o++;
//                if (o == random) {
//                    if (i == ar.length - 1) {
//                        potongan = p1 + " ";
//                        p1 = "";
//                    } else if (ar[i - 1].equals("+") || ar[i - 1].equals("-") || ar[i - 1].equals("*") || ar[i - 1].equals("/")) {
////                        System.out.println("potong o.leng + 1 angka");
//                        if (!ar[i - 2].equals("+") && !ar[i - 2].equals("-") && !ar[i - 2].equals("*") && !ar[i - 2].equals("/")
//                                && !ar[i - 3].equals("+") && !ar[i - 3].equals("-") && !ar[i - 3].equals("*") && !ar[i - 3].equals("/")
//                                && !ar[i - 4].equals("+") && !ar[i - 4].equals("-") && !ar[i - 4].equals("*") && !ar[i - 4].equals("/")) {
//                            int awal = i - 4;
//                            int akhir = i;
//                            p1 = "";
//                            for (int k = 0; k < ar.length; k++) {
//                                if (k >= awal && k <= akhir) {
//                                    potongan += ar[k] + " ";
//                                } else {
//                                    p1 += ar[k] + " ";
//                                }
//                            }
//                        } else {
//                            int aaa = 0;
//                            for (int j = i - 1; j >= 0; j--) {
//                                if (ar[j].equals("+") || ar[j].equals("-") || ar[j].equals("*") || ar[j].equals("/")) {
//                                } else {
//                                    aaa++;
//                                }
//                                if (aaa == o + 1) {
//                                    int awal = j;
//                                    int akhir = i;
//                                    p1 = "";
//                                    for (int k = 0; k < ar.length; k++) {
//                                        if (k >= awal && k <= akhir) {
//                                            potongan += ar[k] + " ";
//                                        } else {
//                                            p1 += ar[k] + " ";
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    } else if (ar[i - 2].equals("+") || ar[i - 2].equals("-") || ar[i - 2].equals("*") || ar[i - 2].equals("/")) {
////                        System.out.println("potong 3 angka");
//                        if ((ar[i - 3].equals("+") || ar[i - 3].equals("-") || ar[i - 3].equals("*") || ar[i - 3].equals("/"))
//                                || (ar[i - 4].equals("+") || ar[i - 4].equals("-") || ar[i - 4].equals("*") || ar[i - 4].equals("/"))) {
////                            System.out.println("potong o.leng + 1 angka");
//                            int aaa = 0;
//                            for (int j = i - 1; j >= 0; j--) {
//                                if (ar[j].equals("+") || ar[j].equals("-") || ar[j].equals("*") || ar[j].equals("/")) {
//                                } else {
//                                    aaa++;
//                                }
//                                if (aaa == o + 1) {
//                                    int awal = j;
//                                    int akhir = i;
//                                    p1 = "";
//                                    for (int k = 0; k < ar.length; k++) {
//                                        if (k >= awal && k <= akhir) {
//                                            potongan += ar[k] + " ";
//                                        } else {
//                                            p1 += ar[k] + " ";
//                                        }
//                                    }
//                                }
//                            }
//                        } else {
//                            p1 = "";
//                            int awal = i - 4;
//                            int akhir = i;
//                            p1 = "";
//                            for (int k = 0; k < ar.length; k++) {
//                                if (k >= awal && k <= akhir) {
//                                    potongan += ar[k] + " ";
//                                } else {
//                                    p1 += ar[k] + " ";
//                                }
//                            }
//                        }
//
//                    } else {
////                        System.out.println("potong 2 angka");
//                        potongan = ar[i - 2] + " " + ar[i - 1] + " " + ar[i] + " ";
//                        ar[i - 2] = "";
//                        ar[i - 1] = "";
//                        ar[i] = "";
//                        p1 = "";
//                        for (int j = 0; j < ar.length; j++) {
//                            if (ar[j].equals("")) {
//                                p1 += ar[j];
//                            } else {
//                                p1 += ar[j] + " ";
//                            }
//                        }
//                    }
//                    System.out.println(potongan);
//                    System.out.println(p1);
//                }
//            }
//        }
//        // tempel potongan ke 2
//        String potongan2 = "";
//        int random2 = rand.nextInt(4) + 1;
//        ar = p2.split(" ");
//        a = 0;
//        o = 0;
//        for (int i = 0; i < ar.length; i++) {
//            if (ar[i].equals("+") || ar[i].equals("-") || ar[i].equals("*") || ar[i].equals("/")) {
//                o++;
//                if (o == random2) {
//                    if (i == ar.length - 1) {
//                        potongan2 = p2;
//                        p2 = potongan;
//                    } else if (ar[i - 1].equals("+") || ar[i - 1].equals("-") || ar[i - 1].equals("*") || ar[i - 1].equals("/")) {
////                        System.out.println("potong o.leng + 1 angka");
//                        if (!ar[i - 2].equals("+") && !ar[i - 2].equals("-") && !ar[i - 2].equals("*") && !ar[i - 2].equals("/")
//                                && !ar[i - 3].equals("+") && !ar[i - 3].equals("-") && !ar[i - 3].equals("*") && !ar[i - 3].equals("/")
//                                && !ar[i - 4].equals("+") && !ar[i - 4].equals("-") && !ar[i - 4].equals("*") && !ar[i - 4].equals("/")) {
//                            int awal = i - 4;
//                            int akhir = i;
//                            p1 = "";
//                            for (int k = 0; k < ar.length; k++) {
//                                if (k >= awal && k <= akhir) {
//                                    if (k == akhir) {
//                                        p2 += potongan;
//                                    }
//                                    potongan2 += ar[k] + " ";
//                                } else {
//                                    p2 += ar[k] + " ";
//                                }
//                            }
//                        } else {
//                            int aaa = 0;
//                            for (int j = i - 1; j >= 0; j--) {
//                                if (ar[j].equals("+") || ar[j].equals("-") || ar[j].equals("*") || ar[j].equals("/")) {
//                                } else {
//                                    aaa++;
//                                }
//                                if (aaa == o + 1) {
//                                    int awal = j;
//                                    int akhir = i;
//                                    p2 = "";
//                                    for (int k = 0; k < ar.length; k++) {
//                                        if (k >= awal && k <= akhir) {
//                                            if (k == akhir) {
//                                                p2 += potongan;
//                                            }
//                                            potongan2 += ar[k] + " ";
//
//                                        } else {
//                                            p2 += ar[k] + " ";
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    } else if (ar[i - 2].equals("+") || ar[i - 2].equals("-") || ar[i - 2].equals("*") || ar[i - 2].equals("/")) {
////                        System.out.println("potong 3 angka");
//                        if ((ar[i - 3].equals("+") || ar[i - 3].equals("-") || ar[i - 3].equals("*") || ar[i - 3].equals("/"))
//                                || (ar[i - 4].equals("+") || ar[i - 4].equals("-") || ar[i - 4].equals("*") || ar[i - 4].equals("/"))) {
////                            System.out.println("potong o.leng + 1 angka");
//                            int aaa = 0;
//                            for (int j = i - 1; j >= 0; j--) {
//                                if (ar[j].equals("+") || ar[j].equals("-") || ar[j].equals("*") || ar[j].equals("/")) {
//                                } else {
//                                    aaa++;
//                                }
//                                if (aaa == o + 1) {
//                                    int awal = j;
//                                    int akhir = i;
//                                    p2 = "";
//                                    for (int k = 0; k < ar.length; k++) {
//                                        if (k >= awal && k <= akhir) {
//                                            if (k == akhir) {
//                                                p2 += potongan;
//                                            }
//                                            potongan2 += ar[k] + " ";
//                                        } else {
//                                            p2 += ar[k] + " ";
//                                        }
//                                    }
//                                }
//                            }
//                        } else {
//                            p2 = "";
//                            int awal = i - 4;
//                            int akhir = i;
//                            p2 = "";
//                            for (int k = 0; k < ar.length; k++) {
//                                if (k >= awal && k <= akhir) {
//                                    if (k == akhir) {
//                                        p2 += potongan;
//                                    }
//                                    potongan2 += ar[k] + " ";
//                                } else {
//                                    p2 += ar[k] + " ";
//                                }
//                            }
//                        }
//
//                    } else {
////                        System.out.println("potong 2 angka");
//                        potongan2 = ar[i - 2] + " " + ar[i - 1] + " " + ar[i];
//                        ar[i - 2] = "";
//                        ar[i - 1] = "";
//                        ar[i] = potongan;
//                        p2 = "";
//                        for (int j = 0; j < ar.length; j++) {
//                            if (ar[j].equals("")) {
//                                p2 += ar[j];
//                            } else if (ar[j].equals(potongan)) {
//                                p2 += ar[j];
//                            } else {
//                                p2 += ar[j] + " ";
//                            }
//                        }
//                    }
//                    System.out.println(potongan2);
//                    System.out.println(p2);
//                }
//            }
//
//        }
//        return p2;
}
