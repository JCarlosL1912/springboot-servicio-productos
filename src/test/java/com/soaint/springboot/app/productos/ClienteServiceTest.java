package com.soaint.springboot.app.productos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.soaint.springboot.app.productos.models.entity.Cliente;
import com.soaint.springboot.app.productos.models.service.ClienteServiceImpl;
import com.soaint.springboot.app.productos.util.Utilitario;

@SpringBootTest
public class ClienteServiceTest {
	
	private MockMvc mockMvc;
	
	@MockBean
	ClienteServiceImpl clienteService;
	
	@Autowired
	private WebApplicationContext context;
	
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}
	
	@WithMockUser(username = "jose", password = "1234")
	@Test
	public void registarCliente() throws Exception {
		Cliente cliente = new Cliente("Leo","Messi","12345678","1234567","messi@gmail.com");
		String request = Utilitario.getJsonPrint(cliente);

		MvcResult result = mockMvc
				.perform(post("/cliente").content(request).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
				
		assertEquals(200, result.getResponse().getStatus());
	}
}
