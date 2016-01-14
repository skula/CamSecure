package com.skula.camsecure.ws;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import com.skula.camsecure.models.Snapshot;


@WebService(endpointInterface = "com.skula.camsecure.ws.ICamSecure")
public class CamSecureImpl implements ICamSecure{

	@Resource
	WebServiceContext wsctx;
	
	@Override
	public String takeSnapshot(Snapshot snapshot) {
		return "Hello from Java Code Geeks Server";
	}

}