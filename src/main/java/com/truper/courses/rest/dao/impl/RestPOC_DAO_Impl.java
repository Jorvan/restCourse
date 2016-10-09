package com.truper.courses.rest.dao.impl;

import org.junit.Assert;
import org.junit.Test;

import com.truper.courses.rest.dao.RestPOC_DAO;
import com.truper.courses.rest.model.POC_POJO;

public class RestPOC_DAO_Impl implements RestPOC_DAO {

	// XXX MOCK
	@Override
	public POC_POJO getPOC_POJO(Integer id) {
		POC_POJO pojo;
		pojo = new POC_POJO();
		String cadena = buildCadena(id);
		pojo.setCadena(cadena);
		pojo.setEntero(id);
		return pojo;
	}

	private String buildCadena(Integer id) {
		StringBuilder sb;
		String cadena;
		sb = new StringBuilder();
		sb.append("String EX: ");
		sb.append(id);
		cadena = sb.toString();
		return cadena;
	}

	@Test
	public void buildCadenaTest() {
		String actual = buildCadena(1);
		String expected = "String EX: 1";
		Assert.assertEquals(expected, actual);
	}

}
