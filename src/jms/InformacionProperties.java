package jms;

import java.util.*;

public class InformacionProperties {

	private static String strQCF;

	private static String strQueueReservas;

	private static String strQueueMensajes;

	private static final String nombreProperties = "InfoAplicacion";

	// **************************************************
	public InformacionProperties() {
		super();
	}

	// **************************************************
	public static String getQueueMensajes() {

		if (strQueueMensajes == null)
			cagarProperties();

		return strQueueMensajes;
	}

	// **************************************************
	public static String getQueueReservas() {

		if (strQueueReservas == null)
			cagarProperties();

		return strQueueReservas;
	}

	// **************************************************
	public static String getQCF() {

		if (strQCF == null)
			cagarProperties();

		return strQCF;
	}

	// **************************************************
	private static void cagarProperties() throws MissingResourceException {

		PropertyResourceBundle appProperties = null;

		try {

			appProperties = (PropertyResourceBundle) PropertyResourceBundle
					.getBundle(nombreProperties);

			strQCF = appProperties.getString("Info.strQCF");
			strQueueMensajes = appProperties.getString("Info.strQueueMensajes");
			strQueueReservas = appProperties.getString("Info.strQueueReservas");

		} catch (MissingResourceException e) {

			throw e;
		}

	}
}