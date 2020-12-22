package io.mano.core.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmployeeTest {
	
	@Test
	public void testEmpProps() {
		Employee emp = new Employee(8, "Manohar", "SE");
		assertEquals(8, emp.getId());
		assertEquals("Manohar", emp.getName());
		assertEquals("SE", emp.getRole());
	}

}
