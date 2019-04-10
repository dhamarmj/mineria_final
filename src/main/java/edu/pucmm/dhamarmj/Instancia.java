package edu.pucmm.dhamarmj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Instancia {
    private int id;
    HashMap<String,String> values;
    private int clusterNum;


    public Instancia(int id) {
        this.id = id;
        this.values = new HashMap<>();
    }
    public Instancia(int id, HashMap<String,String> values) {
        this.id = id;
        this.values = values;
    }

    public Instancia(int id, HashMap<String,String> values, int clusterNum) {
        this.id = id;
        this.clusterNum = clusterNum;
        this.values = values;
    }
    public Instancia(int id, int clusterNum) {
        this.id = id;
        this.clusterNum = clusterNum;
        this.values = new HashMap<>();
    }

    public HashMap<String, String> getValues() {
        return values;
    }

    public void setValues(HashMap<String, String> values) {
        this.values = values;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClusterNum() {
        return clusterNum;
    }

    public void setClusterNum(int clusterNum) {
        this.clusterNum = clusterNum;
    }
}
