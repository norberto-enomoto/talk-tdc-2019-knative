package com.example.knative;

import static spark.Spark.get;
import static spark.Spark.port;

public class Application {

  public static void main(String args[]) {
    String port = System.getenv("PORT");
    port(port != null ? Integer.valueOf(port) : 8080);

    // GET /
    final String defaultMessage = "Default message use the environment TARGET to set a new one";
    final String targetEnvironment = System.getenv("TARGET");
    final String message = targetEnvironment != null ? targetEnvironment : defaultMessage;
    get("/", (req, res) -> message);
  }

}