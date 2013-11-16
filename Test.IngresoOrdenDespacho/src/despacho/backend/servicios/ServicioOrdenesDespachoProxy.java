package despacho.backend.servicios;

public class ServicioOrdenesDespachoProxy implements despacho.backend.servicios.ServicioOrdenesDespacho {
  private String _endpoint = null;
  private despacho.backend.servicios.ServicioOrdenesDespacho servicioOrdenesDespacho = null;
  
  public ServicioOrdenesDespachoProxy() {
    _initServicioOrdenesDespachoProxy();
  }
  
  public ServicioOrdenesDespachoProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioOrdenesDespachoProxy();
  }
  
  private void _initServicioOrdenesDespachoProxy() {
    try {
      servicioOrdenesDespacho = (new despacho.backend.servicios.ServicioOrdenesDespachoBeanServiceLocator()).getServicioOrdenesDespachoPort();
      if (servicioOrdenesDespacho != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioOrdenesDespacho)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioOrdenesDespacho)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioOrdenesDespacho != null)
      ((javax.xml.rpc.Stub)servicioOrdenesDespacho)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public despacho.backend.servicios.ServicioOrdenesDespacho getServicioOrdenesDespacho() {
    if (servicioOrdenesDespacho == null)
      _initServicioOrdenesDespachoProxy();
    return servicioOrdenesDespacho;
  }
  
  public void ingresarOrdenDespacho(despacho.backend.servicios.OrdenDespachoVO arg0) throws java.rmi.RemoteException{
    if (servicioOrdenesDespacho == null)
      _initServicioOrdenesDespachoProxy();
    servicioOrdenesDespacho.ingresarOrdenDespacho(arg0);
  }
  
  public void completarOrdenDespacho(java.lang.String arg0) throws java.rmi.RemoteException{
    if (servicioOrdenesDespacho == null)
      _initServicioOrdenesDespachoProxy();
    servicioOrdenesDespacho.completarOrdenDespacho(arg0);
  }
  
  
}