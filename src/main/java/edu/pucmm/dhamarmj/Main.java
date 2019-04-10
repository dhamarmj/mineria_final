package edu.pucmm.dhamarmj;

import static spark.Spark.port;

public class Main {
    public static void main(String[] args) throws Exception {

        port(8080);

        new MainHandler().startup();

    }
}
