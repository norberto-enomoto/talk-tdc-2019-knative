package com.example.knative.domain;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import java.net.URI;
import java.net.URISyntaxException;

public class CallService {

  private final String twilioAccountNumber;

  private CallService(String twilioAccountNumber) {
    this.twilioAccountNumber = twilioAccountNumber;
  }

  public CallService(String accountSid, String authToken, String twilioAccountNumber) {
    this.twilioAccountNumber = twilioAccountNumber;
    Twilio.init(accountSid, authToken);
  }

  public void makeCall(final String to, final String textUri) throws URISyntaxException {
    final PhoneNumber from = new PhoneNumber(twilioAccountNumber);
    final PhoneNumber receiver = new PhoneNumber(to);
    final URI uri = new URI(textUri);

    Call.creator(receiver, from, uri).create();
  }

}