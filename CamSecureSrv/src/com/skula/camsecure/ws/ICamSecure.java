package com.skula.camsecure.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.skula.camsecure.models.Snapshot;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ICamSecure {

	@WebMethod
	String takeSnapshot(@WebParam(name = "snapshot")Snapshot snapshot);
}