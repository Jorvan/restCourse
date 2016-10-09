package com.truper.courses.rest.service;

import java.util.List;

import com.truper.courses.rest.model.POC_POJO;
import com.truper.infra.exception.BaseException;

public interface RestPOCServices {

	List<POC_POJO> restPOCService() throws BaseException;

	List<POC_POJO> restPOCService(Integer id) throws BaseException;

}
