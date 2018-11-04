package br.com.aevc.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.aevc.loja.Servidor;

public class ProjetoTest {
	
	private HttpServer server;
	
	@Before
	public void startServidor() {
		server = Servidor.inicializaServidor();
	}
	
	@After
	public void stopServidor() {
		server.stop();
	}
	
	@Test
	public void testarConsumoRecursoProjetos() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/");
		String conteudo = target.path("projetos/id").request().get(String.class);
		Assert.assertNotNull(conteudo);
	}
}
