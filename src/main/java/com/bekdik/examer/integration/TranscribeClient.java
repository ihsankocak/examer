package com.bekdik.examer.integration;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.nio.ByteBuffer;
import java.util.concurrent.Flow.Subscriber;

public class TranscribeClient {
	public String transcribe(byte[] audio) {
		HttpRequest request = HttpRequest.newBuilder()
				  .uri(URI.create("https://speech.googleapis.com/v1/speech:recognize"))
				  .POST(HttpRequest.BodyPublishers.ofString("{\"config\":{\r\n"
				  		+ "      \"languageCode\":\"tr-TR\",\r\n"
				  		+ "      \"encoding\":UTF-8\r\n"
				  		+ "      \"sampleRateHertz\":16000\r\n"
				  		+ "      \"enableTimeWordOffsets\":true\r\n"
				  		+ "  },\r\n"
				  		+ "  \"audio\":{\r\n"
				  		+ "    \"content\":\"INPUT_AUDIO\"\r\n"
				  		+ "  }}"))
				  .build();
		return "not implemented";
	}

}
