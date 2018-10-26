package br.usp.sibi.beholder.controllers;

import java.util.List;
import javax.ws.rs.PathParam;
import javax.persistence.Id;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import br.usp.sibi.beholder.dao.ServiceDao;
import br.usp.sibi.beholder.models.Service;
import br.usp.sibi.beholder.models.Status;

@Path("/service")
public class ServiceController {

	/*
	 * public ServiceController() { register(new CORSFilter()); }
	 */

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getServiceById(@PathParam("id") int id) {
		return Response.ok().entity(ServiceDao.byId(id)).build();
	}
	
	@GET
	@Path("/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getServiceByName(@PathParam("name") String name) {
		return Response.ok().entity(ServiceDao.byName(name)).build();
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllServices() {
		List<Service> services = ServiceDao.all();
		return Response.ok().entity(services).build();
	}
	
	@GET
	@Path("/check/{name}")
	public Response checkName(@PathParam("name") String name) {
		Integer id = ServiceDao.getIdByName(name);
		return Response.ok(id).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	public Response addService(Service service) {
		Integer id = ServiceDao.insert(service);
		return Response.ok(id).build();
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateService(Service service) {
		Boolean updated = ServiceDao.update(service);
		return Response.ok(updated).build();
	}
	
	/*@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStatus(Status status) {
		Boolean updated = ServiceDao.updateStatus(status);
		return Response.ok(updated).build();
	}*/

	@DELETE
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteService(@PathParam("id") int id) {
		Boolean deleted = ServiceDao.delete(id);
		return Response.ok(deleted).build();
	}
	
	@DELETE
	@Path("/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteService(@PathParam("name") String name) {
		Boolean deleted = ServiceDao.deleteByName(name);
		return Response.ok(deleted).build();
	}
}