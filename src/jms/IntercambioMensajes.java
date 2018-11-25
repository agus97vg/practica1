package jms;

import java.util.ArrayList;
import java.util.Enumeration;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;





public class IntercambioMensajes {
	
	
	public ArrayList <Message> recibirMensajes(String Usuario){
		
		InitialContext contextoInicial = null;
		QueueConnectionFactory factory = null;
		Queue queue = null;
		QueueConnection  connection = null;
		QueueSession  session = null;
		ArrayList <Message> listaMensajes = new ArrayList <Message>();

		
		try {

			contextoInicial = new InitialContext();
		factory =(QueueConnectionFactory) contextoInicial.lookup(InformacionProperties.getQCF());
		queue = (Queue) contextoInicial.lookup(InformacionProperties.getQueueMensajes());
			
		
		connection = factory.createQueueConnection();
		connection.start();
		session = connection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
		QueueBrowser browser = session.createBrowser(queue);
		Enumeration msgs = browser.getEnumeration();
	
			
		if ( !msgs.hasMoreElements() ) { 
		    System.out.println("No messages in queue");
		} else { 
		    while (msgs.hasMoreElements()) { 
		    	
		        Message tempMsg = (Message)msgs.nextElement();
		       
		        	if(tempMsg.getJMSCorrelationID().equals(Usuario))
						listaMensajes.add(tempMsg);   
		        	
		        
	        
		        
		    }
		}
		
		
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaMensajes;
}
		
	
	
	
public ArrayList <Message> recibirMensajesReserva(String Usuario){
		
		InitialContext contextoInicial = null;
		QueueConnectionFactory factory = null;
		Queue queue = null;
		QueueConnection  connection = null;
		QueueSession  session = null;
		ArrayList <Message> listaMensajes = new ArrayList <Message>();

		
		try {

			contextoInicial = new InitialContext();
		factory =(QueueConnectionFactory) contextoInicial.lookup(InformacionProperties.getQCF());
		queue = (Queue) contextoInicial.lookup(InformacionProperties.getQueueReservas());
			
		
		connection = factory.createQueueConnection();
		connection.start();
		session = connection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
		QueueBrowser browser = session.createBrowser(queue);
		Enumeration msgs = browser.getEnumeration();
		
	
		String filter = "JMSCorrelationID = '" + Usuario  + "'";
		TextMessage m = null;
		int i =0;
		QueueReceiver receiver	= session.createReceiver(queue, filter);
		if ( !msgs.hasMoreElements() ) { 
		    System.out.println("No messages in queue");
		} else { 
		    while (msgs.hasMoreElements()) { 
		    	
		        Message tempMsg = (Message)msgs.nextElement();
		        
		        	//AQUI DABA EL PROBLEMA DE LOS CORCHETES
					if(tempMsg.getJMSCorrelationID().equals(Usuario)) {
		        	
						System.out.println("Se hace el receiver numero "+i);
		        		m = (TextMessage) receiver.receive();
						listaMensajes.add(m);
						i++;        	
		        
					}
		        
		    }
		}
		
		
		connection.close();
		
		
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listaMensajes;
}	
	
public void enviarMensajes(String mensaje, String destino, String emisor){
		
		InitialContext context = null;
		QueueConnectionFactory factory=null;
		Queue cola=null;
		QueueConnection connection;
		QueueSession session;
		
		QueueSender qsender;
		TextMessage	txtMsg;	

		
		try {
			context = new InitialContext();
			factory = (QueueConnectionFactory) context.lookup(InformacionProperties.getQCF());
			cola = (Queue) context.lookup(InformacionProperties.getQueueMensajes());
			connection = factory.createQueueConnection();
			connection.start();
			session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			qsender = session.createSender(cola);
			txtMsg	=	session.createTextMessage(mensaje);
			txtMsg.setJMSCorrelationID(destino);
			txtMsg.setStringProperty("JMSXUserID", emisor);
			
			qsender.send(txtMsg);
			connection.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
		System.out.println("El mensaje ha sido correctamente enviado");

		
	}


public void enviarMensajeReserva(String mensaje, String destino, String emisor, String fechaIni, String fechaFin, String nombreAloja){
	
	InitialContext context = null;
	QueueConnectionFactory factory=null;
	Queue cola=null;
	QueueConnection connection;
	QueueSession session;
	
	QueueSender qsender;
	TextMessage	txtMsg;	

	
	System.out.println(mensaje);
	System.out.println(destino);
	System.out.println(emisor);
	
	try {
		context = new InitialContext();
		factory = (QueueConnectionFactory) context.lookup(InformacionProperties.getQCF());
		cola = (Queue) context.lookup(InformacionProperties.getQueueReservas());
		connection = factory.createQueueConnection();
		connection.start();
		session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		qsender = session.createSender(cola);
		txtMsg	=	session.createTextMessage(mensaje);
		txtMsg.setJMSCorrelationID(destino);
		txtMsg.setStringProperty("JMSXUserID", emisor);
		txtMsg.setStringProperty("JMSXFechaIni", fechaIni);
		txtMsg.setStringProperty("JMSXFechaFin", fechaFin);
		txtMsg.setStringProperty("JMSXNombre", nombreAloja);
		qsender.send(txtMsg);
		connection.close();
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JMSException e) {
		// TODO Auto-generated catch block 
		e.printStackTrace();
	}
	
	System.out.println("El mensaje ha sido correctamente enviado");

	
}

}
