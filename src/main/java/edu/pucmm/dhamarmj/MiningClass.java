package edu.pucmm.dhamarmj;

import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.SerializationHelper;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.io.*;

public class MiningClass {



    public MiningClass() {

    }



//    public List<Instancia> sortbyvalue() {
//        if (list_instancias.size() == 0)
//            return null;
//
//        List<Instancia> instancias = new ArrayList<>();
//        for (Instancia i: list_instancias){
//
//          //  i.getValues().get("type")
//
//        }
//
//
//        return instancias;
//    }



    private static void validateAttribute(List<String> attributenames, Instances data, HashMap<String, String> single_data, Instances centroids, int i, int j) {
        if (j == 13) {
            double val = centroids.instance(i).value(j);
            single_data.put(attributenames.get(j), Double.toString(val));
        } else
            single_data.put(attributenames.get(j), data.instance(i).stringValue(j));
    }

    public static BufferedReader readDataFile(String filename) {
        BufferedReader inputReader = null;

        try {
            inputReader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + filename);
        }

        return inputReader;
    }
}
