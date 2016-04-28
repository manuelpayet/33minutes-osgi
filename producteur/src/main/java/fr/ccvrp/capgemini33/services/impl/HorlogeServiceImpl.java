package fr.ccvrp.capgemini33.services.impl;

import java.rmi.dgc.VMID;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;

import fr.ccvrp.capgemini33.services.HorlogeService;

public class HorlogeServiceImpl implements HorlogeService {

	private static final Logger LOGGER = Logger.getLogger(HorlogeServiceImpl.class);

	@Override
	public String repondre() {
		LOGGER.info("Service d'horloge invoqué");
		return String.format("(JVM %s) il est %s", getIdentifiantUniqueJvm(), LocalDateTime.now());
	}

	private String getIdentifiantUniqueJvm() {
		return new VMID().toString().split("\\:")[0];
	}
}
