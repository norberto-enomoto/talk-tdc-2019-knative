package com.example.knative.domain;

import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Say;

public class MountCallMessage {

  public static void main(String[] args) {
    String message = "Hello The Developer's Conference 2019";
    Say say = new Say.Builder(message).build();
    VoiceResponse response = new VoiceResponse.Builder().say(say).build();
    System.out.println(response.toXml());
  }

}