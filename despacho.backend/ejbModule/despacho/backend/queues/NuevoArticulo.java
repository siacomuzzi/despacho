package despacho.backend.queues;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import ar.edu.uade.integracion.VO.ArticuloVO;
import despacho.backend.servicios.ServicioArticulos;
import despacho.backend.utils.Configuracion;
import despacho.backend.utils.Logger;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"), 
		@ActivationConfigProperty(propertyName = "destination", propertyValue = Configuracion.IngresoArticuloQueueName)
}, mappedName = Configuracion.IngresoArticuloQueueName) 
public class NuevoArticulo implements MessageListener { 

	@EJB
	private ServicioArticulos servicioArticulos;

	public void onMessage(Message message) { 
		if (message instanceof ObjectMessage) { 

			try { 
				ObjectMessage inboundMessage = (ObjectMessage) message; 
				ArticuloVO articulo = (ArticuloVO) inboundMessage.getObject();
				
				this.servicioArticulos.ingresarArticulo(articulo);
			} catch (Exception e) { 
				e.printStackTrace();
				Logger.info("DCH01", e.getMessage());
			} 
		} 
	}
}
