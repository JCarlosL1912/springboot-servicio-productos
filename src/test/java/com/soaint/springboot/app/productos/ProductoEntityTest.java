package com.soaint.springboot.app.productos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.soaint.springboot.app.productos.models.entity.Producto;

@DataJpaTest
public class ProductoEntityTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	private Producto producto;
	
	@BeforeEach
	public void setUp() {
		producto = new Producto();
	}

	@Test
	public void productoFieldsNull() {
		entityManager.persist(producto);
	}
}
