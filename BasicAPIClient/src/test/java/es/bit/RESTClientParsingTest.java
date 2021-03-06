package es.bit;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;

import static org.junit.Assert.*;

public class RESTClientParsingTest {

	@Test
	public void getTest() {

		try {
			JsonNode jsonResp = RESTClientParsing.getFromAPI("http://localhost:8080/TareasProyectosJersey/rest/usuarios/1");
			System.out.println("jsonResp:"+jsonResp);
			assertNotNull(jsonResp);
			assertTrue(jsonResp.size()>0);
			assertTrue(jsonResp.get("uid").intValue()>0);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}
	
//	@Test
	public void postTest() {

		try {
			String body="{\"uid\":0,\"nombre\":\"Luis\",\"email\":\"l@l.com\",\"foto\":\"l.jpg\"}";
			String response = RESTClient.postToAPI("http://localhost:8080/TareasProyectosJersey/rest/usuarios",body);
			assertNotNull(response);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}
}
