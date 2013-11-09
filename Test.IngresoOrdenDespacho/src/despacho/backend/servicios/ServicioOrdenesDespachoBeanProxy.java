package despacho.backend.servicios;

public class ServicioOrdenesDespachoBeanProxy implements despacho.backend.servicios.ServicioOrdenesDespachoBean {
  private String _endpoint = null;
  private despacho.backend.servicios.ServicioOrdenesDespachoBean servicioOrdenesDespachoBean = null;
  
  public ServicioOrdenesDespachoBeanProxy() {
    _initServicioOrdenesDespachoBeanProxy();
  }
  
  public ServicioOrdenesDespachoBeanProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioOrdenesDespachoBeanProxy();
  }
  
  private void _initServicioOrdenesDespachoBeanProxy() {
    try {
      servicioOrdenesDespachoBean = (new despacho.backend.servicios.ServicioOrdenesDespachoBeanServiceLocator()).getServicioOrdenesDespachoBeanPort();
      if (servicioOrdenesDespachoBean != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioOrdenesDespachoBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioOrdenesDespachoBean)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioOrdenesDespachoBean != null)
      ((javax.xml.rpc.Stub)servicioOrdenesDespachoBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public despacho.backend.servicios.ServicioOrdenesDespachoBean getServicioOrdenesDespachoBean() {
    if (servicioOrdenesDespachoBean == null)
      _initServicioOrdenesDespachoBeanProxy();
    return servicioOrdenesDespachoBean;
  }
  
  public void ingresarOrdenDespacho(despacho.backend.servicios.OrdenDespacho arg0) throws java.rmi.RemoteException{
    if (servicioOrdenesDespachoBean == null)
      _initServicioOrdenesDespachoBeanProxy();
    servicioOrdenesDespachoBean.ingresarOrdenDespacho(arg0);
  }
  
  public void inicializacion() throws java.rmi.RemoteException{
    if (servicioOrdenesDespachoBean == null)
      _initServicioOrdenesDespachoBeanProxy();
    servicioOrdenesDespachoBean.inicializacion();
  }
  
  
}