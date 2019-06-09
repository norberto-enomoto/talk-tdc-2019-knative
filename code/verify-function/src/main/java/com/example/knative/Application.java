package com.example.knative;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import com.example.knative.domain.CallService;
import java.net.URISyntaxException;
import org.apache.http.HttpStatus;

public class Application {

  public static void main(String args[]) {
    String port = System.getenv("PORT");
    port(port != null ? Integer.valueOf(port) : 8080);

    // GET /
    final String defaultMessage = "Default message use the environment TARGET to set a new one";
    final String targetEnvironment = System.getenv("TARGET");
    final String message = targetEnvironment != null ? targetEnvironment : defaultMessage;
    get("/", (req, res) -> message);

    // Twilio POST ***
    final String accountSid = System.getenv("TWILIO_ACCOUNT");
    final String authToken = System.getenv("TWILIO_TOKEN");
    final String accountNumber = System.getenv("TWILIO_ACCOUNT_NUMBER");
    final CallService callService = new CallService(accountSid, authToken, accountNumber);
    post("/calls", ((request, response) -> {
      response.status(HttpStatus.SC_ACCEPTED);
      return response;
    }));
  }

}