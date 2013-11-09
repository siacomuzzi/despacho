package despacho.backend.utils;

import java.io.*;
import java.util.*;

import javax.jms.*;
import javax.naming.*;

public class MensajeAsincronico {
	public static void EnviarObjeto(String url, String queueName, String user, String password, Serializable objeto) throws NamingException, JMSException {
		
		final Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, url));
		env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", user));
		env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", password));

		Context context = new InitialContext(env);

		// Buscar la Connection Factory en JNDI
		String connectionFactoryString = System.getProperty("connection.factory", "jms/RemoteConnectionFactory");
		ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);
		
		// Buscar la Cola en JNDI
		String destinationString = System.getProperty("destination", queueName);
		Destination  destination = (Destination) context.lookup(destinationString);
		
		// Crear la connection y la session a partir de la connection
		Connection connection = connectionFactory.createConnection(System.getProperty("username", user), System.getProperty("password", password));
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		connection.start();
		
		// Crear un producer para enviar mensajes usando la session
		MessageProducer producer = session.createProducer(destination);
		
		// Crear un mensaje de tipo object y setearle el contenido
		ObjectMessage message = session.createObjectMessage();
		message.setObject(objeto);
		
		// Enviar el mensaje
		producer.send(message);
		
		// Cerrar la session y la connection
		session.close();
		connection.close();
	}
}
