package com.yao;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;
import org.junit.Assert;

import static org.mockito.Mockito.when;

public class ServiceTest {
	private final static Database databaseMock = Mockito.mock(Database.class);

	private Service testedService;

	@Before
	public void setup() {
		testedService = new Service(databaseMock);
	}

	@Test
	public void service()  {
		Assert.assertNotNull(databaseMock);

		when(databaseMock.isAvailable()).thenReturn(true);

		boolean check = testedService.query("* from t");
		Assert.assertTrue(check);
	}
}
