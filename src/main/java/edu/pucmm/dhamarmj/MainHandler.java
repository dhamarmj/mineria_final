package edu.pucmm.dhamarmj;

import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.SerializationHelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.staticFiles;

public class MainHandler {

    public MainHandler() throws Exception {
        km = (SimpleKMeans) SerializationHelper.read("C:/Users/Dhamar/Documents/model_zoo.model");
        datafile = readDataFile("C:/Users/Dhamar/Documents/zoo.arff");
        data = new Instances(datafile);
    }
    SimpleKMeans km;
    List<String> attributenames = Arrays.asList("animal", "hair", "feathers", "eggs", "milk", "airborne", "aquatic", "predator", "toothed", "backbone", "breathes", "venomous", "fins", "legs", "tail", "domestic", "catsize", "type");
    BufferedReader datafile;
    Instances data;
    HashMap<String, String> single_data = new HashMap<>();
    Instancia instancia;
    Centroide centroide;
    private List<Instancia> list_instancias = new ArrayList<>();
    private List<Centroide> list_centroides = new ArrayList<>();

    public void startup() throws Exception{
        staticFiles.location("/publico");

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(MainHandler.class, "/templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);
     //   startValues();

        get("/", (request, response) -> {
            return new ModelAndView(null, "home.ftl");
        }, freeMarkerEngine);

        get("/rest/centroides", (request, response) -> {
            List<Centroide> centroides = list_centroides;

            response.header("Content-Type", "application/json");
            return centroides;
        }, JsonUtilitario.json());

        get("/rest/instancias", (request, response) -> {

            List<Instancia> instancias =  getInstancias();
            System.out.println(instancias.size());
            response.header("Content-Type", "application/json");
            return instancias;
        }, JsonUtilitario.json());


    }

    public List<Instancia> getInstancias() throws Exception{
        //INSTANCIAS!!
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.numAttributes(); j++) {
                validateAttribute(attributenames, data, single_data, data, i, j);
            }
            instancia = new Instancia(i, single_data);
            this.list_instancias.add(instancia);
        }
        //ASSIGNMENTS
        int[] assignments = km.getAssignments();
        int i = 0;
        for (int clusterNum : assignments) {
            this.list_instancias.get(i).setClusterNum(clusterNum);
            i++;
        }

        return this.list_instancias;
    }

    public void getCentroides() throws Exception {
        //CENTROIDES~!
        Instances centroids = km.getClusterCentroids();
        for (int i = 0; i < km.getNumClusters(); i++) {
            for (int j = 0; j < centroids.numAttributes(); j++) {
                validateAttribute(attributenames, data, single_data, centroids, i, j);
            }
            centroide = new Centroide(i, single_data, km.getClusterSizes()[i]);
            this.list_centroides.add(centroide);
        }
    }

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
