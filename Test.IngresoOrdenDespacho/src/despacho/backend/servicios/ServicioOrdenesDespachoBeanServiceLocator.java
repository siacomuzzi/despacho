/**
 * ServicioOrdenesDespachoBeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package despacho.backend.servicios;

public class ServicioOrdenesDespachoBeanServiceLocator extends org.apache.axis.client.Service implements despacho.backend.servicios.ServicioOrdenesDespachoBeanService {

    public ServicioOrdenesDespachoBeanServiceLocator() {
    }


    public ServicioOrdenesDespachoBeanServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioOrdenesDespachoBeanServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioOrdenesDespachoPort
    private java.lang.String ServicioOrdenesDespachoPort_address = "http://localhost:8080/despacho.backend/ServicioOrdenesDespacho";

    public java.lang.String getServicioOrdenesDespachoPortAddress() {
        return ServicioOrdenesDespachoPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioOrdenesDespachoPortWSDDServiceName = "ServicioOrdenesDespachoPort";

    public java.lang.String getServicioOrdenesDespachoPortWSDDServiceName() {
        return ServicioOrdenesDespachoPortWSDDServiceName;
    }

    public void setServicioOrdenesDespachoPortWSDDServiceName(java.lang.String name) {
        ServicioOrdenesDespachoPortWSDDServiceName = name;
    }

    public despacho.backend.servicios.ServicioOrdenesDespacho getServicioOrdenesDespachoPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioOrdenesDespachoPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioOrdenesDespachoPort(endpoint);
    }

    public despacho.backend.servicios.ServicioOrdenesDespacho getServicioOrdenesDespachoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            despacho.backend.servicios.ServicioOrdenesDespachoBeanServiceSoapBindingStub _stub = new despacho.backend.servicios.ServicioOrdenesDespachoBeanServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicioOrdenesDespachoPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioOrdenesDespachoPortEndpointAddress(java.lang.String address) {
        ServicioOrdenesDespachoPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (despacho.backend.servicios.ServicioOrdenesDespacho.class.isAssignableFrom(serviceEndpointInterface)) {
                despacho.backend.servicios.ServicioOrdenesDespachoBeanServiceSoapBindingStub _stub = new despacho.backend.servicios.ServicioOrdenesDespachoBeanServiceSoapBindingStub(new java.net.URL(ServicioOrdenesDespachoPort_address), this);
                _stub.setPortName(getServicioOrdenesDespachoPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicioOrdenesDespachoPort".equals(inputPortName)) {
            return getServicioOrdenesDespachoPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicios.backend.despacho/", "ServicioOrdenesDespachoBeanService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicios.backend.despacho/", "ServicioOrdenesDespachoPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioOrdenesDespachoPort".equals(portName)) {
            setServicioOrdenesDespachoPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
