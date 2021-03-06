package com.esiea.glpoo;

import java.io.File;
import java.util.ArrayList;

/**
 * Singleton
 */
public class JardinService {

	//private static final Logger LOGGER = Logger.getLogger(LapinService.class);
	private CsvJardinDao csvJardin;
	private static JardinService instance;	// Instance de la classe, pour le singleton.

	/**
	 * Constructeur prive.
	 */
	private JardinService() 
	{
		//LOGGER.debug("Constructeur");
		System.out.println("JardinService - Constructeur");

		csvJardin = new AdvancedJardinCsvDao();
	}

	/** 
	 * Singleton classique, synchro, avec creation sur demande.
	 * @return LapinService
	 */
	public static synchronized JardinService getInstance() 
	{
		if (instance == null) instance = new JardinService();

		return instance;
	}

	/**
	 * Permet de recuperer le jardin
	 * @param fileName
	 * @return List<String>
	 */
	public Jardin findAllJardin(String fileName, ArrayList<Lapin> lapins) 
	{
		File file = new File(fileName);
		csvJardin.initJardin(file, lapins);
		return csvJardin.findAllJardin();
	}

}