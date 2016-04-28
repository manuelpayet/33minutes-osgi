package fr.ccvrp.capgemini33.impl;

import java.rmi.dgc.VMID;

import org.apache.log4j.Logger;

import fr.ccvrp.capgemini33.services.HorlogeService;

public class HommePresse {

	private static final Logger LOGGER = Logger.getLogger(HommePresse.class);

	private HorlogeService horlogeService;

	public void setHorlogeService(HorlogeService horlogeService) {
		this.horlogeService = horlogeService;
	}

	public void demanderHeure() throws InterruptedException {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					LOGGER.info(String.format(
							"(JVM %s ) Quelle heure est-il? ==> %s",
							getIdentifiantUniqueJvm(), horlogeService.repondre()));
				}
			}
		}).start();

	}

	private String getIdentifiantUniqueJvm() {
		return new VMID().toString().split("\\:")[0];
	}
}
