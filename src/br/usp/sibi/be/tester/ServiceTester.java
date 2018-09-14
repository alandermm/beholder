package br.usp.sibi.be.tester;

import java.awt.print.Printable;

import com.mysql.cj.xdevapi.JsonArray;

import br.usp.sibi.beholder.controllers.ServiceController;
import br.usp.sibi.beholder.dao.ServiceDao;
import br.usp.sibi.beholder.models.Service;
import br.usp.sibi.beholder.utils.JerseyApplication;

public class ServiceTester {

	public static void main(String[] args) {
		Service service = new Service();
		service.setName("Site");
		service.setStatus(0);
		service.setStatusDescription("OK");
		service.setUrlIcon("assets/images/site_logo.png");
		service.setAdditionalInformation("Funcionando");

		ServiceController controller = new ServiceController();

		System.out.print(controller.deleteService("Site"));
		
		//ServiceDao dao = new ServiceDao();
		//Service service2 = null;
		//System.out.println(dao.insert(service));
		//dao.deleteByName("Site2");
		
		/*service2 = dao.byId(1);
		
		if(service2 != null)
			System.out.print(service2.getName());
		else
			System.out.print("Sistema não encontrado");
		JsonArray json = new JsonArray();*/
	}
}