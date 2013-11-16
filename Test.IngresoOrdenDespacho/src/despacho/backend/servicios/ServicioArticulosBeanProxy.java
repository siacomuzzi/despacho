package despacho.backend.servicios;

public class ServicioArticulosBeanProxy implements despacho.backend.servicios.ServicioArticulosBean {
  private String _endpoint = null;
  private despacho.backend.servicios.ServicioArticulosBean servicioArticulosBean = null;
  
  public ServicioArticulosBeanProxy() {
    _initServicioArticulosBeanProxy();
  }
  
  public ServicioArticulosBeanProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioArticulosBeanProxy();
  }
  
  private void _initServicioArticulosBeanProxy() {
    try {
      servicioArticulosBean = (new despacho.backend.servicios.ServicioArticulosBeanServiceLocator()).getServicioArticulosBeanPort();
      if (servicioArticulosBean != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioArticulosBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioArticulosBean)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioArticulosBean != null)
      ((javax.xml.rpc.Stub)servicioArticulosBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public despacho.backend.servicios.ServicioArticulosBean getServicioArticulosBean() {
    if (servicioArticulosBean == null)
      _initServicioArticulosBeanProxy();
    return servicioArticulosBean;
  }
  
  public java.lang.Boolean recepcionArticulosParaDespachar(despacho.backend.servicios.SolicitudArticuloVO arg0) throws java.rmi.RemoteException{
    if (servicioArticulosBean == null)
      _initServicioArticulosBeanProxy();
    return servicioArticulosBean.recepcionArticulosParaDespachar(arg0);
  }
  
  public void ingresarArticulo(despacho.backend.servicios.ArticuloVO arg0) throws java.rmi.RemoteException{
    if (servicioArticulosBean == null)
      _initServicioArticulosBeanProxy();
    servicioArticulosBean.ingresarArticulo(arg0);
  }
  
  
}