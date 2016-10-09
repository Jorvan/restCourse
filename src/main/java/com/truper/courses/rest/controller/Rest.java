package com.truper.courses.rest.controller;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.truper.courses.rest.service.RestPOCServices;
import com.truper.courses.rest.service.impl.RestPOCServicesImpl;
import com.truper.infra.exception.BaseException;
import com.truper.infra.rs.BaseSRMController;

/**
 * Hello world!
 *
 */
@Path("/rest")
public class Rest extends BaseSRMController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8847200846909299700L;

	private RestPOCServices service;

	{
		service = new RestPOCServicesImpl();
	}

	@GET
	@Path("/poc")
	public Response getPOC() {
		Response response;
		try {
			List<?> l = service.restPOCService();
			response = buildOK_JSONResponse(l);
		} catch (BaseException e) {
			log.error(e);
			response = buildError_JSONResponse(e.getViewErrorMessage());
		}
		return response;
	}

	@POST
	@Path("/pocURL")
	public Response postPOC(String data) {
		log.debug("data: {}", data);
		Integer id = getJSONInteger(data, "id");
		Response response;
		try {
			List<?> l = service.restPOCService(id);
			response = buildOK_JSONResponse(l);
		} catch (BaseException e) {
			log.error(e);
			response = buildError_JSONResponse(e.getViewErrorMessage());
		}
		return response;
	}

	@POST
	@Path("/pocForm")
	public Response postFormDataPOC(@FormParam("id") Integer id) {
		log.debug("id: {}", id);
		Response response;
		try {
			List<?> l = service.restPOCService(id);
			response = buildOK_JSONResponse(l);
		} catch (BaseException e) {
			log.error(e);
			response = buildError_JSONResponse(e.getViewErrorMessage());
		}
		return response;
	}

}
