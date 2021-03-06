package es.bit.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.bit.models.Proyecto;
import es.bit.models.Tarea;
import es.bit.models.Usuario;

@Path("/tareas")
public class TareasService {

	private static List<Tarea> tareas;
	static {
		tareas= new ArrayList();
		tareas.add(new Tarea(1, "Crear site", 20, new Proyecto(), new Usuario()));
		tareas.add(new Tarea(2, "Lanzar pruebas pre", 10, new Proyecto(), new Usuario()));
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTareas() {
		return Response.status(Response.Status.OK)
				.entity(tareas)
				.build();
	}
	
}
