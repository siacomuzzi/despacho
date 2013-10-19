package despacho.web.infrastructure;

import javax.naming.NamingException;

public class MyBusinessDelegate {
	private IService service;
    private ServiceLocator serviceLocator = new ServiceLocator();

    public MyBusinessDelegate() {
        this.init();
    }

    private void init() {
        try {
        	if (service == null) {
        		service = serviceLocator.getServiceBusinessObject("xxxxxEAR/yyyyyBean/remote"); // TODO: obtener URL del bean de un archivo de configuracion 
            }
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public Object getData() {
    	return service.getData();
    }
}