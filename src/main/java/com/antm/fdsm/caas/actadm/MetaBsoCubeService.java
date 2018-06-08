package com.antm.fdsm.caas.actadm;

import com.antm.fdsm.orcl.oac.AnalyticCloudPlatform;
import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;

public class MetaBsoCubeService {
	
	private EssbaseServer server = AnalyticCloudPlatform.getEssbaseServer("fdsm-dev-oac01.anthem.com");
	private EssbaseCube metaBsoCube = server.getApplication(ServiceDefs.META_NAME_BSO_01).getCube(ServiceDefs.META_NAME_BSO_01);
	
	public CalcBsoCubeService prepareCalcCube() {
		metaBsoCube.copyToNewApplication(ServiceDefs.CALC_NAME_BSO_01).getCube(ServiceDefs.META_NAME_BSO_01).rename(ServiceDefs.CALC_NAME_BSO_01);
		CalcBsoCubeService cube = new CalcBsoCubeService();
		return cube;
	}
	
}
