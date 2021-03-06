package bit.es;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;

import es.bit.models.Usuario;

public class RESTClientTest {

	private Client client = ClientBuilder.newClient();
	private String REST_URI = "http://localhost:8080/TareasProyectosJersey/rest/usuarios";
	
	@Test
	public void getUsersTest() {
		Usuario[] apiUsers = client
				.target(REST_URI)				
				.request(MediaType.APPLICATION_JSON)
				.get(Usuario[].class);

		System.out.println(apiUsers);
		assertNotNull(apiUsers);
		assertTrue(apiUsers.length>0);
	}
	
	@Test
	public void getUserTest() {
		Usuario apiUser = client
				.target(REST_URI)
				.path(String.valueOf(1))
				.request(MediaType.APPLICATION_JSON)
				.get(Usuario.class);

		System.out.println(apiUser.getNombre());
		assertNotNull(apiUser);
		assertTrue(apiUser.getUid() == 1);
	}

	@Test
	public void getUserResponseTest() {
		Response response = client
				.target(REST_URI)
				.path(String.valueOf(1))
				.request(MediaType.APPLICATION_JSON)
				.get();

		assertNotNull(response);
		System.out.println("Metadata:"+response.getMetadata());
		System.out.println("Status:"+response.getStatus());
		
		Usuario apiUser= response.readEntity(Usuario.class);
		System.out.println("Name:"+apiUser.getNombre());
		assertNotNull(apiUser);
		assertTrue(apiUser.getUid() == 1);
		
	}

	@Test
	public void postUserTest() {
		Usuario userToSend=new Usuario(0, "Paul", "pa@p.com", "pa.jpg");
		
		Usuario apiUser = client
				.target(REST_URI)
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(userToSend, MediaType.APPLICATION_JSON),Usuario.class);

		System.out.println(apiUser.getNombre());
		assertNotNull(apiUser);
		assertTrue(apiUser.getUid() != 0);
	}

}
