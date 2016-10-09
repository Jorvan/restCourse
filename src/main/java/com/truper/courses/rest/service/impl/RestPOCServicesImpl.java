package com.truper.courses.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.truper.courses.rest.dao.RestPOC_DAO;
import com.truper.courses.rest.dao.impl.RestPOC_DAO_Impl;
import com.truper.courses.rest.model.POC_POJO;
import com.truper.courses.rest.service.RestPOCServices;
import com.truper.infra.exception.BaseException;

public class RestPOCServicesImpl implements RestPOCServices {

	private RestPOC_DAO dao;

	{
		dao = new RestPOC_DAO_Impl();
	}

	// XXX MOCK
	@Override
	public List<POC_POJO> restPOCService() throws BaseException {
		List<POC_POJO> mockResponse = new ArrayList<POC_POJO>();
		addNewPOJO(mockResponse, 1);
		addNewPOJO(mockResponse, 2);
		return mockResponse;
	}

	@Override
	public List<POC_POJO> restPOCService(Integer id) throws BaseException {
		List<POC_POJO> mockResponse = new ArrayList<POC_POJO>();
		POC_POJO pojo = dao.getPOC_POJO(id);
		mockResponse.add(pojo);
		return mockResponse;
	}

	private void addNewPOJO(List<POC_POJO> listToAddPOJO, Integer pojoIdToAdd)
			throws BaseException {
		if (listToAddPOJO == null) {
			throw new BaseException("La lista no debe ser nula");
		}
		POC_POJO pojo = dao.getPOC_POJO(pojoIdToAdd);
		listToAddPOJO.add(pojo);
	}

	@Test
	public void addNewPOJOTest() throws BaseException {
		List<POC_POJO> l = new ArrayList<POC_POJO>();
		addNewPOJO(l, 1);
		Assert.assertTrue(l.size() == 1);
	}

	@Test
	public void addNewPOJOTestEX() {
		List<POC_POJO> l = null;
		try {
			addNewPOJO(l, 1);
			Assert.fail("Debe mandar error con lista nula");
		} catch (BaseException e) {
			// Es correcto no manejar la excepcion
		}
	}

}
