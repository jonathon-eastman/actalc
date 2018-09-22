package com.antm.fdsm.caas.actalc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.antm.fdsm.orcl.oac.EssbaseCube;
import com.antm.fdsm.orcl.oac.EssbaseServer;
import com.antm.fdsm.orcl.oac.MdxOutputFile;
import com.antm.fdsm.orcl.utils.Singleton;

public class Actadm2CubeService {
	
	private Singleton service;
	private EssbaseServer server;
	private EssbaseCube actadm2;

	public Actadm2CubeService(Singleton oacServiceSingleton) {
		service = oacServiceSingleton;
		server = new EssbaseServer(service);
		actadm2 = server.getApplication(service, "ACTADM2").getCube("ACTADM2");
	}
	
	public CompletableFuture<Void> extractUnallocated()  {
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
			try {
				MdxOutputFile extract = actadm2.runMdx("extract_unallocated_adm_from_actadm2.mdx", Def.DIR_MDX + "/unallocated_admin.txt").get();
				extract.applicationName(Def.CALC_NAME)
					.cubeName(Def.CALC_NAME)
					.removeHeader()
					.addHeaderRecord("From Center|Admin Exp Alloc|Headcount Alloc")
					.returnCloud();
			} 
			catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		});
		return cf;
	}
	
}
