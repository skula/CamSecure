package com.skula.camsecure.ws;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import com.skula.camsecure.models.Snapshot;

@WebService(endpointInterface = "com.skula.camsecure.ws.ICamSecure")
public class CamSecureImpl implements ICamSecure {
	private static final String SCRIPT_PATH = "/home/pi/Scripts/PROD/camsecure/camsecure.sh";
	@Resource
	WebServiceContext wsctx;

	@Override
	public String takeSnapshot(Snapshot snapshot) {

		if (isAuthentified(snapshot)) {
			try {
				Process p = Runtime.getRuntime().exec(SCRIPT_PATH + " " + snapshot.getMailAddress());
			} catch (IOException e) {
				return "Error: " + e.getMessage();
			}
			return "Snaphot sent!";
		} else {
			return "Unauthorized user !";
		}
	}

	public boolean isAuthentified(Snapshot s) {
		return s.getLogin().equals("slown") && s.getPassWord().equals("plop");
	}
}