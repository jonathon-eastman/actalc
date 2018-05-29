package com.antm.fdsm.caas.actadm;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.antm.fdsm.orcl.oac.AnalyticCloudPlatform;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;

public class RptgAsoCubeService {

	public void updateTime() {
		
	}
	
	public void loadHistory() {
		EssbaseServer server = AnalyticCloudPlatform.getEssbaseServer("fdsm-dev-oac01.anthem.com");
		try {
			EssbaseCube loadAsoActadm = server.getApplication(ServiceDefs.RPTG_NAME_BASE).getCube(ServiceDefs.RPTG_NAME_BASE);
			loadAsoActadm.clear();
			Files.newDirectoryStream(Paths.get(ServiceDefs.HOME_DIRECTORY + ServiceDefs.PROJECT_DIRECTORY + "/" + ServiceDefs.HISTORY_DIRECTORY), path -> path.toFile().isFile())
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
	
	public void loadCurrentPeriodIncremental() {
		
	}
	
	public void loadCurrentPeriodWithPartialClear() {
		
	}
	
	
}
