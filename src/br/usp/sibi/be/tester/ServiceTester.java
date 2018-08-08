package br.usp.sibi.be.tester;

import com.mysql.cj.xdevapi.JsonArray;

import br.usp.sibi.beholder.controllers.ServicoController;
import br.usp.sibi.beholder.dao.ServicoDao;
import br.usp.sibi.beholder.models.Servico;
import br.usp.sibi.beholder.utils.JerseyApplication;

public class ServiceTester {

	public static void main(String[] args) {
		Servico service = new Servico();
		service.setNome("Site 3");
		service.setStatus(0);
		service.setDescricaoStatus("OK 3");
		service.setUrlIcone("assets/images/site_logo.png");
		service.setInformacoesAdicionais("Funcionando");

		ServicoController controller = new ServicoController();

		controller.addServico(service);
		JsonArray json = new JsonArray();
	}
}