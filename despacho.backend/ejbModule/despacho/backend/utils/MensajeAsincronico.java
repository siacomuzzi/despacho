package despacho.backend.utils;

import java.io.Serializable;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

public class MensajeAsincronico {
	public static void EnviarObjeto(String url, String queueName, String user, String password, Serializable objeto) throws Exception {

		try {
			final Properties env = new Properties();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
			env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, "remote://localhost:4447"));
			env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", "test"));
			env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", "test123"));
			Context context = new InitialContext(env);

			// Buscar la Connection Factory en JNDI
			String connectionFactoryString = System.getProperty("connection.factory", "jms/RemoteConnectionFactory");
			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);

			// Buscar la Cola en JNDI
			String destinationString = System.getProperty("destination", "jms/queue/test");
			Destination  destination = (Destination) context.lookup(destinationString);

			// Crear la connection y la session a partir de la connection
			Connection connection = connectionFactory.createConnection(System.getProperty("username", "test"), System.getProperty("password", "test123"));
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
		} catch (Exception e) {
			throw e;
		}
	}
}
