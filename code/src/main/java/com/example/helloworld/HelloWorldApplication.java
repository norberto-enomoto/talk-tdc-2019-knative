package com.example.helloworld;

import static spark.Spark.get;
import static spark.Spark.port;

public class HelloWorldApplication {

  public static void main(String args[]) {
    port(Integer.valueOf(System.getenv("PORT")));
    final String defaultMessage = "Default message use the environment TARGET to set a new one";
    final String targetEnvironment = System.getenv("TARGET");
    final String message = targetEnvironment != null ? targetEnvironment : defaultMessage;
    get("/", (req, res) -> message);
  }

}