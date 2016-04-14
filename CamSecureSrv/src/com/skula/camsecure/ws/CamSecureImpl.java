package com.skula.camsecure.ws;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import com.skula.camsecure.models.Snapshot;
import com.skula.camsecure.services.DatabaseService;
import com.skula.camsecure.utils.Logger;

@WebService(endpointInterface = "com.skula.camsecure.ws.ICamSecure")
public class CamSecureImpl implements ICamSecure {
	private static final String SCRIPT_PATH = "/home/pi/Scripts/PROD/camsecure/camsecure.sh";

	@Resource
	WebServiceContext wsctx;

	@Override
	public String takeSnapshot(Snapshot snapshot) {

		DatabaseService dbs;
		try {
			dbs = new DatabaseService();

			if (dbs.isAuthentified(snapshot.getLogin(), snapshot.getPassWord())) {
				try {
					Process p = Runtime.getRuntime().exec(SCRIPT_PATH + " " + snapshot.getMailAddress());
					Logger.log("INFO", "capture de l'utilisateur '" + snapshot.getLogin() + "' pour l'adresse '"
							+ snapshot.getMailAddress() + ".");
				} catch (IOException e) {
					Logger.log("ERROR", e.getMessage());
					return "Error: " + e.getMessage();
				}
				return "Snaphot sent!";
			} else {
				Logger.log("WARNING",
						"tentative de capture échouée de l'utilisateur non enregistré '" + snapshot.getLogin() + ":"
								+ snapshot.getPassWord() + "' pour l'adresse '" + snapshot.getMailAddress());
				return "Unauthorized user !";
			}
		} catch (ClassNotFoundException e1) {
			Logger.log("ERROR", e1.getMessage());
			return e1.getMessage();
		} catch (SQLException e2) {
			Logger.log("ERROR", e2.getMessage());
			e2.printStackTrace();
			return e2.getMessage();
		}
	}

	public boolean isAuthentified(Snapshot s) {
		return s.getLogin().equals("slown") && s.getPassWord().equals("plop");
	}
}