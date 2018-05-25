package com.antm.fdsm.caas.actadm;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.antm.fdsm.orcl.oac.AnalyticCloudPlatform;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;


public class HistoryService {

	public static final String PROJECT_DIRECTORY = "actadm";
	public static final String HISTORY_DIRECTORY = "history";
	public static final String HOME_DIRECTORY = AnalyticCloudPlatform.getFileHome();
	public static void main(String [] args) {
		HistoryService.run();
	}

	public static void run() {
		
		EssbaseServer server = AnalyticCloudPlatform.getEssbaseServer("fdsm-dev-oac01.anthem.com");
		try {
			EssbaseCube loadAsoActadm = server.getApplication("LOAD-ASO-ACTADM").getCube("LOAD-ASO-ACTADM");
			loadAsoActadm.clear();
			Files.newDirectoryStream(Paths.get(HOME_DIRECTORY + PROJECT_DIRECTORY + "/data/act/"), path -> path.toFile().isFile())
				.forEach(f -> {
					if (f.toString().endsWith(".txt")) {
						loadAsoActadm.load( (loadFile, ruleFile) -> {
							loadFile.localPath(f.toString());
							ruleFile.aiSourceFile(f.toString());
						});
					}
				}
			);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}