package bismillahskirpsi;

import java.util.ArrayList;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anang Hanafi
 */
public class Populasi implements Comparator<Populasi> {

    private String individu, segmen1, segmen2;
    double fitness;

    public Populasi(String individu, String segmen1, String segmen2) {
        this.individu = individu;
        this.segmen1 = segmen1;
        this.segmen2 = segmen2;
    }

    public Populasi(String individu, String segmen1, String segmen2, double fitness) {
        this.individu = individu;
        this.segmen1 = segmen1;
        this.segmen2 = segmen2;
        this.fitness = fitness;
    }

    public Populasi() {

    }

    public String getIndividu() {
        return individu;
    }

    public String getSegmen1() {
        return segmen1;
    }

    public double getFitness() {
        return fitness;
    }

    public String getSegmen2() {
        return segmen2;
    }

    @Override
    public String toString() {
        return individu + "\t" + segmen1 + "\t" + "\t" + segmen2 + "\t" + String.format("%.10f", fitness) + "\n";
    }

    @Override
    public int compare(Populasi o1, Populasi o2) {
        if (o1.getFitness() > o2.getFitness()) {
            return -1;
        }
        if (o1.getFitness() < o2.getFitness()) {
            return 1;
        } else {
            return 0;
        }
    }

}
