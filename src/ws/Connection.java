package ws;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


import bean.Persona;

@Path("Connector")
public class Connection {
	
	List<Persona> listaPersonas = new ArrayList<Persona>();
	
	public Connection() {
		super();
		Persona yo = new Persona("pedro", "perez");
		listaPersonas.add(yo);
	 }
	
	@GET
	@Path("/getpersonas")
	@Produces(MediaType.TEXT_PLAIN)
	public String getPersonas() {
	 
		return listaPersonas.toString();
		
	}
	 
	@POST
	@Path("/addpersonas")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPersona(InputStream incomingData) {
		StringBuilder crunchifyBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				crunchifyBuilder.append(line);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + crunchifyBuilder.toString());
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity("OK").build();
		//Persona p = new Persona(parametros.getFirst("nombre"), parametros.getFirst("apellidos"));
		//listaPersonas.add(p);
	
	}
	
}
