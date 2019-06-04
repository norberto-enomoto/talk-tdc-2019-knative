package com.example.helloworld;

import static spark.Spark.get;
import static spark.Spark.port;

public class HelloWorldApplication {

  public static void main(String args[]) {
    port(Integer.valueOf(System.getenv("PORT")));
    final String message = (System.getenv("TARGET") != null) ? System.getenv("TARGET") : "World";
    get("/", (req, res) -> message);
  }

}