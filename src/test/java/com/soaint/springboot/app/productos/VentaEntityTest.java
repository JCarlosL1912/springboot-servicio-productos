package com.soaint.springboot.app.productos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.soaint.springboot.app.productos.models.entity.Venta;

@DataJpaTest
public class VentaEntityTest {

	@Autowired
	private TestEntityManager entityManager;
	
	private Venta venta;
	
	@BeforeEach
	public void setUp() {
		venta = new Venta();
	}
	
	@Test
	public void ventaFieldsNull() {
		entityManager.persist(venta);
	}
}
