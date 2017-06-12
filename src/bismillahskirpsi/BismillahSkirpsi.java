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
            /*0*/{0, 3, 18, 23, 29, 17, 23, 21, 10, 20, 29, 50, 55, 17, 10, 11, 14},
            /*1*/ {3, 0, 15, 17, 26, 14, 20, 23, 13, 23, 32, 53, 58, 20, 13, 14, 16},
            /*2*/ {18, 15, 0, 35, 41, 29, 35, 38, 41, 38, 47, 68, 73, 35, 28, 29, 22},
            /*3*/ {23, 17, 35, 0, 14, 14, 19, 40, 33, 43, 52, 73, 78, 40, 33, 24, 33},
            /*4*/ {29, 26, 41, 14, 0, 28, 33, 60, 39, 49, 58, 79, 84, 46, 39, 10, 33},
            /*5*/ {17, 14, 29, 14, 28, 0, 5, 35, 27, 37, 46, 67, 72, 34, 45, 26, 30},
            /*6*/ {23, 20, 35, 19, 33, 5, 0, 40, 33, 43, 52, 73, 78, 40, 33, 31, 35},
            /*7*/ {21, 23, 38, 40, 60, 35, 40, 0, 31, 41, 50, 71, 76, 38, 31, 28, 8},
            /*8*/ {10, 13, 41, 33, 39, 27, 33, 31, 0, 10, 17, 40, 45, 19, 7, 18, 18},
            /*9*/ {20, 23, 38, 43, 49, 37, 43, 41, 10, 0, 7, 30, 35, 29, 17, 27, 15},
            /*10*/ {29, 32, 47, 52, 58, 46, 52, 50, 17, 7, 0, 21, 42, 36, 24, 33, 13},
            /*11*/ {50, 53, 68, 73, 79, 67, 73, 71, 40, 30, 21, 0, 25, 57, 45, 58, 31},
            /*12*/ {55, 58, 73, 78, 84, 72, 78, 76, 45, 35, 42, 25, 0, 64, 52, 77, 57},
            /*13*/ {17, 20, 35, 40, 46, 34, 40, 38, 19, 29, 36, 57, 64, 0, 12, 8, 32},
            /*14*/ {10, 13, 28, 33, 39, 45, 33, 31, 7, 17, 24, 45, 52, 12, 0, 12, 22},
            /*15*/ {11, 14, 29, 24, 10, 26, 31, 28, 18, 27, 33, 58, 77, 8, 12, 0, 28},
            /*16*/ {14, 16, 22, 33, 33, 30, 35, 8, 18, 15, 13, 31, 57, 32, 22, 28, 0},};
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
            ArrayList<Integer> kotake = new ArrayList<Integer>();
            for (int j = 1; j <= jumlahTujuan; j++) {
                kotake.add(new Integer(j));
            }
            Collections.shuffle(kotake);
            for (int j = 0; j < jumlahTujuan; j++) {
                gen1[j] = kotake.get(j);
            }
            sales1 = gen2[1] - 1;
            sales2 = gen2[1] - 1 + gen2[2];
            sales3 = gen2[1] - 1 + gen2[2] + gen2[3];
            sales4 = gen2[1] - 1 + gen2[2] + gen2[3] + gen2[4];
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
            segmen1 = String.valueOf("" + gen1[0] + " " + gen1[1] + " " + gen1[2] + " " + gen1[3] + " " + gen1[4]
                    + " " + gen1[5] + " " + gen1[6] + " " + gen1[7] + " " + gen1[8]
                    + " " + gen1[9] + " " + gen1[10] + " " + gen1[11] + " " + gen1[12]
                    + " " + gen1[13] + " " + gen1[14] + " " + gen1[15]);

            segmen2 = String.valueOf("" + gen2[1] + " " + gen2[2] + " " + gen2[3] + " " + gen2[4]);
            System.out.println("Kromosom " + segmen1 + "\t\t" + segmen2);
            //       fitness = hitungFitness(segmen1);
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
            String p1, p2, c1, c2, ps1, ps2, individuCrossover;
            for (int j = 0; j < icr; j++) {
                individuCrossover = "cc " + (j + 1);
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
                pop = new Populasi(individuCrossover, c1, ps1);
                populasi.add(pop);
//                Populasi anagen1 = new Populasi("c1", c1, ps1);
//                reproduksi.add(anagen1);

            }
            // mutasi
            int p1randomMutasi;
            String individuMutasi;
            for (int j = 0; j < imr; j++) {
                individuMutasi = "cm " + (j + 1);
                p1randomMutasi = rand.nextInt(popSize);
                p1 = populasi.get(p1randomMutasi).getSegmen1();
                ps1 = populasi.get(p1randomMutasi).getSegmen2();
                c2 = mutasi(p1);
                System.out.println("p1 " + p1);
                System.out.println("Hasil Mutasi " + c2);
                pop = new Populasi(individuMutasi, c2, ps1);
                populasi.add(pop);
//                Populasi anagen2 = new Populasi("c1", c2, ps1);
//                reproduksi.add(anagen2);
            }
            //Evaluasi
            String segmenGet1, segmenGet2;
            int rubah1[] = new int[17], rubah2[] = new int[17];
            int sales1x, sales2x, sales3x, sales4x;
            System.out.println("\n");
            for (int j = 0; j < 6; j++) {
                individu = "P" + (j + 1);
                segmenGet1 = populasi.get(j).getSegmen1();
                segmenGet2 = populasi.get(j).getSegmen2();
                String[] segmenCek1 = segmenGet1.split(" ");
                String[] segmenCek2 = segmenGet2.split(" ");

                for (int l = 0; l < segmenCek1.length; l++) {
                    rubah1[l] = Integer.valueOf(segmenCek1[l]);
                    //      System.out.print("Cek Rubah " + rubah1[l] + " ");
                }
                for (int m = 0; m < segmenCek2.length; m++) {
                    rubah2[m] = Integer.valueOf(segmenCek2[m]);
                    //    System.out.print("Cek Rubahwwwwr " + rubah2[m] + " ");
                }
                //  System.out.println("\n");
                double totalNilai = 0, jarakSales1 = 0, jarakSales2 = 0, jarakSales3 = 0, jarakSales4 = 0,
                        beratSales1 = 0, beratSales2 = 0, beratSales3 = 0, beratSales4 = 0,
                        volumeSales1 = 0, volumeSales2 = 0, volumeSales3 = 0, volumeSales4 = 0,
                        beratMuatanSales1 = 0, beratMuatanSales2 = 0, beratMuatanSales3 = 0, beratMuatanSales4 = 0,
                        volumeMuatanSales1 = 0, volumeMuatanSales2 = 0, volumeMuatanSales3 = 0, volumeMuatanSales4 = 0,
                        nilaiSales1 = 0, nilaiSales2 = 0, nilaiSales3 = 0, nilaiSales4 = 0;
                int sebar = 0;
//                System.out.println("Segmen" + segmenGet2);
//                System.out.println("" + rubah2[0]);
//                System.out.println("" + rubah2[1]);
//                System.out.println("" + rubah2[2]);
//                System.out.println("" + rubah2[3]);
                sales1x = rubah2[0] - 1;
                sales2x = rubah2[0] - 1 + rubah2[1];
                sales3x = rubah2[0] - 1 + rubah2[1] + rubah2[2];
                sales4x = rubah2[0] - 1 + rubah2[1] + rubah2[2] + rubah2[3];
                while (sebar < jumlahTujuan) {
                    if (sebar <= sales1x) {
                        //   System.out.println("sales 1 " + rubah1[sebar]);
                        while (sebar <= sales1x) {
                            jarakSales1 += jarak[rubah1[sebar]][rubah1[sebar + 1]];
                            //  System.out.print(" Jarak sales 1 " + jarakSales1);
                            beratSales1 += beratBarang[rubah1[sebar]];
                            //  System.out.print("BeratSales 1 " + beratSales1);
                            volumeSales1 += volumeBarang[rubah1[sebar]];
                            sebar++;
                        }
                        if (maxVolumeMuatan >= volumeSales1) {
                            volumeMuatanSales1 = 0;
                        } else {
                            volumeMuatanSales1 = 1000;
                        }
                        if (maxBeratMuatan >= beratSales1) {
                            beratMuatanSales1 = 0;
                        } else {
                            beratMuatanSales1 = 1000;
                        }
//                        System.out.println("\n");
//                        System.out.println("Jarak Sales " + jarakSales1);
//                        System.out.println("Berat Muatan " + beratMuatanSales1);
//                        System.out.println("Volume Muatan " + volumeMuatanSales1);
                        nilaiSales1 = (jarakSales1 + beratMuatanSales1 + volumeMuatanSales1);
//                        System.out.println("Nilai sales " + nilaiSales1);
                        sebar -= 1;
                    } else if (sebar <= sales2x) {
                        //   System.out.println("\n");
                        //     System.out.println("sales 2 " + rubah1[sebar]);
                        while (sebar <= sales2x) {
                            jarakSales2 += jarak[rubah1[sebar]][rubah1[sebar + 1]];
                            // System.out.print(" Jarak sales 2 " + jarakSales2);
                            beratSales2 += beratBarang[rubah1[sebar]];
                            //System.out.print("BeratSales 2 " + beratSales2);
                            volumeSales2 += volumeBarang[rubah1[sebar]];
                            sebar++;
                        }
                        if (maxVolumeMuatan >= volumeSales2) {
                            volumeMuatanSales2 = 0;
                        } else {
                            volumeMuatanSales2 = 1000;
                        }
                        if (maxBeratMuatan >= beratSales2) {
                            beratMuatanSales2 = 0;
                        } else {
                            beratMuatanSales2 = 1000;
                        }
                        //    System.out.println("\n");
//                        System.out.println("Jarak Sales " + jarakSales2);
//                        System.out.println("Berat Muatan " + beratMuatanSales2);
//                        System.out.println("Volune Muatan " + volumeMuatanSales2);
                        nilaiSales2 = (jarakSales2 + beratMuatanSales2 + volumeMuatanSales2);
//                        System.out.println("Nilai sales " + nilaiSales2);
                        sebar -= 1;
                    } else if (sebar <= sales3x) {
                        //   System.out.println("\n");
                        //     System.out.println("sales 3 " + rubah1[sebar]);
                        while (sebar <= sales3x) {
                            jarakSales3 += jarak[rubah1[sebar]][rubah1[sebar + 1]];
                            //  System.out.print(" Jarak sales 3 " + jarakSales3);
                            beratSales3 += beratBarang[rubah1[sebar]];
                            //  System.out.print("BeratSales 3 " + beratSales3);
                            volumeSales3 += volumeBarang[rubah1[sebar]];
                            sebar++;
                        }
                        if (maxVolumeMuatan2 >= volumeSales3) {
                            volumeMuatanSales3 = 0;
                        } else {
                            volumeMuatanSales3 = 1000;
                        }
                        if (maxBeratMuatan2 >= beratSales3) {
                            beratMuatanSales3 = 0;
                        } else {
                            beratMuatanSales3 = 1000;
                        }
//                        System.out.println("\n");
//                        System.out.println("Jarak Sales " + jarakSales3);
//                        System.out.println("Volume Muatan " + volumeMuatanSales3);
                        nilaiSales4 = (jarakSales3 + beratMuatanSales3 + volumeMuatanSales3);
//                        System.out.println("Nilai sales " + nilaiSales3);
                        sebar -= 1;
                    } else if (sebar <= sales4x) {
                        //   System.out.println("\n");
                        //  System.out.println("sales 4 " + rubah1[sebar]);
                        while (sebar <= sales4x) {
                            jarakSales4 += jarak[rubah1[sebar]][rubah1[sebar + 1]];
                            //     System.out.print(" Jarak sales 4 " + jarakSales4);
                            beratSales4 += beratBarang[rubah1[sebar]];
                            //       System.out.print("BeratSales 1 " + beratSales4);
                            volumeSales1 += volumeBarang[rubah1[sebar]];
                            sebar++;
                        }
                        if (maxVolumeMuatan2 >= volumeSales4) {
                            volumeMuatanSales4 = 0;
                        } else {
                            volumeMuatanSales4 = 1000;
                        }
                        if (maxBeratMuatan2 >= beratSales4) {
                            beratMuatanSales4 = 0;
                        } else {
                            beratMuatanSales4 = 1000;
                        }
//                        System.out.println("\n");
//                        System.out.println("Jarak Sales " + jarakSales4);
//                        System.out.println("Berat Muatan " + beratMuatanSales4);
//                        System.out.println("Volume Muatan " + volumeMuatanSales4);
                        nilaiSales4 = (jarakSales4 + beratMuatanSales4 + volumeMuatanSales4);
//                        System.out.println("Nilai sales " + nilaiSales4);
                        sebar -= 1;
                    }
                    sebar++;
                }
                totalNilai = (nilaiSales1 + nilaiSales2 + nilaiSales3 + nilaiSales4);
                fitness = 1 / totalNilai;

                //   System.out.println("p1 " + p1);
                //System.out.println("Hasil Mutasi " + c2);
                pop = new Populasi(individu, populasi.get(j).getSegmen1(), populasi.get(j).getSegmen2(), fitness);
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
                    //  ygDiHapus += populasi.get(j);
                    // ygDiHapus += populasi.get(j);
                }
            }
            System.out.println("Individu Terbaik " + populasi.get(0));
            System.out.println("Individu Terpilih " + stlhDiClear);
//            System.out.println(" ygDiHapus " + ygDiHapus);
            String segmen1Terbaik, segmen2Terbaik;
//            int rubah1[] = new int[17], rubah2[] = new int[17];
//            int sales1x, sales2x, sales3x, sales4x;
            segmen1Terbaik = populasi.get(0).getSegmen1();
            segmen2Terbaik = populasi.get(0).getSegmen2();
            String[] segmen1TerbaikSplit = segmen1Terbaik.split(" ");
            String[] segmen2TerbaikSplit = segmen2Terbaik.split(" ");

            System.out.println("Coba Kota " + populasi.get(0).getSegmen1());

            String ceklagi = "";
            //    cek += populasi.get(1).getSegmen1();
            for (int l = 0; l < popSize; l++) {
                ceklagi += populasi.get(l) + "";
            }
            System.out.print("CekLagi " + ceklagi);

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
}
