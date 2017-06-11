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
        double cr = 0.5, mr = 0.5;
        long icr = Math.round(popSize * cr);
        long imr = Math.round(popSize * mr);
        Random rand = new Random();
        double fitness;
        String individu, segmen1 = " ", segmen2 = " ";
        Populasi pop;
        int k = 0;
        ArrayList<Populasi> populasi = new ArrayList<>();
        System.out.println("Inisialisasi");
        for (int i = 0; i < popSize; i++) {
            individu = "P" + (i + 1);
            System.out.println("PopSize " + (i + 1));
            int r = 0;
            int sales1, sales2, sales3, sales4;
//            String cobaSegment1 = cobaSegment1();
//            String cobaSegment2 = cobaSegment2();
            int[] gen1 = new int[jumlahTujuan + 1];
            int[] gen2 = new int[jumlahSales + 1];

            int N1 = jumlahTujuan;
            for (int j = 1; j <= jumlahSales; j++) {
                r = rand.nextInt(N1);
                //             System.out.println("Random " + r);
                N1 -= r;
                //           System.out.println("N1 " + N1);
                if (N1 >= 0 && j <= 3) {
                    gen2[j] = r;
                    //                System.out.println("gen2 " + gen2[j]);
                } else if (j == 4) {
                    gen2[j] = N1 + r;
                    //              System.out.println("j " + j);
                }
                //   gen2[i + 1] = gen2[j];
                System.out.println("Sales ke " + (j) + " mengunjungi ke " + gen2[j] + " tujuan");
            }
            sales1 = gen2[1];
            sales2 = gen2[1] + gen2[2];
            sales3 = gen2[1] + gen2[2] + gen2[3];
            sales4 = gen2[1] + gen2[2] + gen2[3] + gen2[4];
            ArrayList<Integer> kotake = new ArrayList<Integer>();
            for (int j = 1; j <= jumlahTujuan; j++) {
                kotake.add(new Integer(j));
            }
            Collections.shuffle(kotake);
            for (int j = 0; j < jumlahTujuan; j++) {
                gen1[j] = kotake.get(j);
            }
            while (k < jumlahTujuan) {
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
//            segmen1 = String.valueOf("" + gen1[0] + " " + gen1[1] + " " + gen1[2] + " " + gen1[3] + " " + gen1[4]
//                    + " " + gen1[5] + " " + gen1[6] + " " + gen1[7] + " " + gen1[8]
//                    + " " + gen1[9] + " " + gen1[10] + " " + gen1[11] + " " + gen1[12]
//                    + " " + gen1[13] + " " + gen1[14] + " " + gen1[15]);
//
//            segmen2 = String.valueOf("" + gen2[1] + " " + gen2[2] + " " + gen2[3] + " " + gen2[4]);
//            System.out.println("Kromosom " + segmen1 + "\t\t" + segmen2);
            // fitness = hitungFitness(segmen1);
            pop = new Populasi(individu, segmen1, segmen2);
            populasi.add(pop);

            //   System.out.format("P" + (i + 1) + " gen2 " + gen2[1] + " gen2 " + gen2[2] + " gen2 " + gen2[3] + "gen2 " + gen2[4] + "\n");
        }
        //Populasi
        //Crossover

        for (int i = 0; i < maxGenerasi; i++) {
            // cross over
            System.out.println("======================ITERASI KE-" + (i + 1) + "========================");
            ArrayList<Populasi> reproduksi = new ArrayList<>(populasi);
            //   reproduksi = populasi.;

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
                c1 = crossover(p1, p2);
                System.out.println("p1 " + p1);
                System.out.println("p2 " + p2);
                System.out.println("Hasil Crossover " + c1);
                pop = new Populasi("c", c1, ps1);
                populasi.add(pop);
//                Populasi anagen1 = new Populasi("c1", c1, ps1);
//                reproduksi.add(anagen1);

            }
            // mutasi
            int p1randomMutasi;
            for (int j = 0; j < imr; j++) {
                p1randomMutasi = rand.nextInt(popSize);
                p1 = populasi.get(p1randomMutasi).getSegmen1();
                ps1 = populasi.get(p1randomMutasi).getSegmen2();
                c2 = mutasi(p1);
                System.out.println("p1 " + p1);
                System.out.println("Hasil Mutasi " + c2);
                pop = new Populasi("c2", c2, ps1);
                populasi.add(pop);
//                Populasi anagen2 = new Populasi("c1", c2, ps1);
//                reproduksi.add(anagen2);

            }
            long coba = imr + icr;
            int cekbanyak = (int) coba + popSize;
            String cek = "";
            // Populasi C = populasi.remove(1);
            //    cek += populasi.get(1).getSegmen1();
            for (int l = 0; l < populasi.size(); l++) {
                cek += populasi.get(l);
            }
            System.out.println("Cek " + cek);
            String stlhDiClear = "";
            String ygDiHapus = "";
            populasi.sort(new Populasi());
            //    populasi.clear();
            for (int j = 0; j < populasi.size(); j++) {
                if (j < popSize) {
                    stlhDiClear += populasi.get(j);
                } else if (j > popSize && j < populasi.size()) {
                    populasi.remove(j);
                    // ygDiHapus += populasi.get(j);
                }
            }
            System.out.println("stlhDiClear " + stlhDiClear);
            System.out.println(" ygDiHapus " + ygDiHapus);
            String ceklagi = "";
            //    cek += populasi.get(1).getSegmen1();
            for (int l = 0; l < popSize; l++) {
                ceklagi += populasi.get(l).getSegmen1() + "\n";
            }
            System.out.println("CekLagi " + ceklagi);

//            reproduksi.sort(new Populasi());
//            populasi.clear();
//            for (int j = 0; j < popSize; j++) {
//                populasi.add(reproduksi.get(j));
//            }
            //   System.out.println("Cek kromosom " + populasi.get(0).getKromosom());
        }

    }

    private static String crossover(String p1, String p2) {
        // ambil potongan ke 1
        Random rand = new Random();
        String potongan = "";
        int o = 0;
        String parent1[] = p1.split(" ");
        int randCros = rand.nextInt(16);
//        for (int i = 0; i < parent1.length; i++) {
//            System.out.println("paren 1 " + parent1[i]);
//        }
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
//                    System.out.println("p1 " + p1);
//                    System.out.println("Potongan " + potongan);
                }
            }
        }
        //tempel potongan
        String parent2[] = p2.split(" ");
        String p1Tambah[] = potongan.split(" ");
        String pcoba = "";
        //    System.out.println("p2 " + p2);
        for (int i = 0; i < parent2.length; i++) {
            for (int j = 0; j < p1Tambah.length; j++) {
                boolean cek = parent2[i].equals(p1Tambah[j]);
                if (cek == true) {
                    //     System.out.print(" " + parent2[i]);
                    pcoba += parent2[i] + " ";
                }
            }

        }
        //     System.out.println("Offspring " + p1 + pcoba);
        p2 = p1 + pcoba;
        return p2;

    }

    private static String mutasi(String p1) {
        Random rand = new Random();
        String ambilGen1 = "";
        String ambilGen2 = "";
        String tampung = "";
        int o = 0;
        String parent1[] = p1.split(" ");
        int randMut1 = rand.nextInt(16);
        int randMut2 = rand.nextInt(16);
//        for (int i = 0; i < parent1.length; i++) {
//            System.out.print(" " + parent1[i]);
//        }
        ambilGen1 = parent1[randMut1];
        tampung = parent1[randMut1];
        ambilGen2 = parent1[randMut2];
        parent1[randMut1] = parent1[randMut2];
        parent1[randMut2] = tampung;
        System.out.println("\n");
//        System.out.println("Ambil gen 1 " + ambilGen1);
//        System.out.println("Ambil gen 2 " + ambilGen2);
//        System.out.println("Tampung " + tampung);
        System.out.println("Swap gen " + ambilGen1 + " dengan " + ambilGen2);
        p1 = "";
        for (int j = 0; j < parent1.length; j++) {
            // System.out.print(" " + parent1[i]);
            p1 += parent1[j] + " ";
        }
        //  System.out.println("p1 " + p1);
        return p1;
    }

//    private static String cobaSegment1() {
//        String segmen1 = "";
//        int jumlahTujuan = 16;
//        int[] gen1 = new int[jumlahTujuan + 1];
//        ArrayList<Integer> kotake = new ArrayList<Integer>();
//        for (int j = 1; j <= jumlahTujuan; j++) {
//            kotake.add(new Integer(j));
//        }
//        Collections.shuffle(kotake);
//        for (int j = 0; j < jumlahTujuan; j++) {
//            gen1[j] = kotake.get(j);
//        }
//        return segmen1;
//    }
//
//    private static String cobaSegment2() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public double hitungFitness(String tujuan) {
        // hitung fitness kromosom
        long hasil, selisih;
        double fitness, total = 0;
        for (int i = 0; i < 10; i++) {

        }
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
        fitness = 1 / (1 + total);
//        System.out.println("Total " + total);
//        System.out.println("Fitness " + String.format("%.10f", fitness));
        return fitness;
    }


}
