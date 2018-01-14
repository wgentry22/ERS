package com.gtrain.Testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testing {

	@Test
	public void test() {
		ModelFieldsNotNull model = new ModelFieldsNotNull();
		boolean employee = model.employeeFieldsNotNull();
		boolean manager = model.managerFieldsNotNull();
		boolean pending = model.pendingRequestFieldsNotNull();
		boolean resolved = model.resolvedRequestFieldsNotNull();
		boolean morePending = model.morePendingThanResolved();
		
		assertTrue(employee);
		assertTrue(manager);
		assertTrue(pending);
		assertTrue(resolved);
		assertTrue(morePending);
	}

}
