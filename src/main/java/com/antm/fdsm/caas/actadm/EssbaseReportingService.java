package com.antm.fdsm.caas.actadm;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.antm.fdsm.orcl.oac.AnalyticCloudPlatform;
import com.antm.fdsm.orcl.oac.EssbaseApplication;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;

public class EssbaseReportingService {
	
	private EssbaseServer server = AnalyticCloudPlatform.getEssbaseServer("fdsm-dev-oac01.anthem.com");
	private EssbaseApplication rptgAso01App = server.getApplication(ServiceDefs.RPTG_NAME_ASO_01);
	private EssbaseCube rptgAso01Cube = rptgAso01App.getCube(ServiceDefs.RPTG_NAME_ASO_01);
	
	public EssbaseReportingService clearAllData() {
		rptgAso01Cube.clear();
		return this;
	}
	
	public EssbaseReportingService loadHistory() {	
		rptgAso01Cube.loadFilesInDirectory(ServiceDefs.DIRECTORY_HOME + ServiceDefs.DIRECTORY_PROJECT + "/" + ServiceDefs.DIRECTORY_DATA + "/" + ServiceDefs.DIRECTORY_HISTORY);
		return this;
	}
	
	public void loadCurrentPeriodIncremental() {
		try {
			Files.newDirectoryStream(Paths.get(ServiceDefs.DIRECTORY_HOME + ServiceDefs.DIRECTORY_PROJECT + "/" + ServiceDefs.DIRECTORY_HISTORY), path -> path.toFile().isFile())
				.forEach(f -> {
					if (f.toString().endsWith(".txt")) {
						rptgAso01Cube.load( (loadFile, ruleFile) -> {
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
	
	public EssbaseReportingService loadCurrentPeriodBase() {
		rptgAso01Cube.loadFilesInDirectory(ServiceDefs.DIRECTORY_HOME + ServiceDefs.DIRECTORY_PROJECT + "/" + ServiceDefs.DIRECTORY_DATA + "/" + ServiceDefs.DIRECTORY_BASE);
		return this;
	}
	
	public void loadCurrentPeriodWithPartialClear() {
		
	}
	
	public EssbaseReportingService moveToProduction1() {
		rptgAso01App.rename(ServiceDefs.RPTG_NAME_PRIMARY).getCube(ServiceDefs.RPTG_NAME_ASO_01).rename(ServiceDefs.RPTG_NAME_PRIMARY);
		return this;
	}
	
	public EssbaseReportingService moveToProduction2() {
		rptgAso01App.rename(ServiceDefs.RPTG_NAME_SECONDARY).getCube(ServiceDefs.RPTG_NAME_ASO_01).rename(ServiceDefs.RPTG_NAME_SECONDARY);
		return this;
	}
	
	public void updateTime() {
		
	}
}
