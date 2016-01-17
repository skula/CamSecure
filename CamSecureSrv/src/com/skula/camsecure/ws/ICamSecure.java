package com.skula.camsecure.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.skula.camsecure.models.Snapshot;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface ICamSecure {
	@WebMethod(operationName = "takeSnapshot", action = "http://ws.camsecure.skula.com/takeSnapshot")
	String takeSnapshot(
			@WebParam(name = "snapshot", targetNamespace = "http://ws.camsecure.skula.com/") Snapshot snapshot);
}