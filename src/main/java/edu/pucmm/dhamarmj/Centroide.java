package edu.pucmm.dhamarmj;

import java.util.HashMap;

public class Centroide {
    private int id;
    HashMap<String,String> values;
    private double clusterSizes;

    public Centroide(int id) {
        this.id = id;
    }
    public Centroide(int id,HashMap<String, String> values) {
        this.id = id;
        this.values = values;
    }


    public Centroide(HashMap<String, String> values, double clusterSizes) {
        this.values = values;
        this.clusterSizes = clusterSizes;
    }

    public Centroide(int id, HashMap<String, String> values, double clusterSizes) {
        this.id = id;
        this.values = values;
        this.clusterSizes = clusterSizes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<String, String> getValues() {
        return values;
    }

    public void setValues(HashMap<String, String> values) {
        this.values = values;
    }

    public double getClusterSizes() {
        return clusterSizes;
    }

    public void setClusterSizes(int clusterSizes) {
        this.clusterSizes = clusterSizes;
    }
}
