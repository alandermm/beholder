package br.usp.sibi.beholder.controllers;

import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.usp.sibi.beholder.dao.ServicoDao;
import br.usp.sibi.beholder.models.Servico;

@Path("/servico")
public class ServicoController {

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getServicoById(@PathParam("id") int id) {
		return Response.ok().entity(ServicoDao.porId(id)).build();
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllServicos(){
		List<Servico> servicos = ServicoDao.todos();
		return Response.ok().entity(servicos).build();
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createServico(Servico servico) {
		ServicoDao.inserir(servico);
		return Response.ok().build();
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateServico(Servico servico) {
		ServicoDao.atualizar(servico);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteService(@PathParam("id") int id) {
		ServicoDao.excluir(id);
		return Response.ok().build();
	}
}
