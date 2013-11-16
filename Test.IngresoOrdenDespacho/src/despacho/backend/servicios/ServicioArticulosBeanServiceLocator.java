/**
 * ServicioArticulosBeanServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package despacho.backend.servicios;

public class ServicioArticulosBeanServiceLocator extends org.apache.axis.client.Service implements despacho.backend.servicios.ServicioArticulosBeanService {

    public ServicioArticulosBeanServiceLocator() {
    }


    public ServicioArticulosBeanServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioArticulosBeanServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioArticulosBeanPort
    private java.lang.String ServicioArticulosBeanPort_address = "http://localhost:8080/despacho.backend/ServicioArticulosBean";

    public java.lang.String getServicioArticulosBeanPortAddress() {
        return ServicioArticulosBeanPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioArticulosBeanPortWSDDServiceName = "ServicioArticulosBeanPort";

    public java.lang.String getServicioArticulosBeanPortWSDDServiceName() {
        return ServicioArticulosBeanPortWSDDServiceName;
    }

    public void setServicioArticulosBeanPortWSDDServiceName(java.lang.String name) {
        ServicioArticulosBeanPortWSDDServiceName = name;
    }

    public despacho.backend.servicios.ServicioArticulosBean getServicioArticulosBeanPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioArticulosBeanPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioArticulosBeanPort(endpoint);
    }

    public despacho.backend.servicios.ServicioArticulosBean getServicioArticulosBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            despacho.backend.servicios.ServicioArticulosBeanServiceSoapBindingStub _stub = new despacho.backend.servicios.ServicioArticulosBeanServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicioArticulosBeanPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioArticulosBeanPortEndpointAddress(java.lang.String address) {
        ServicioArticulosBeanPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (despacho.backend.servicios.ServicioArticulosBean.class.isAssignableFrom(serviceEndpointInterface)) {
                despacho.backend.servicios.ServicioArticulosBeanServiceSoapBindingStub _stub = new despacho.backend.servicios.ServicioArticulosBeanServiceSoapBindingStub(new java.net.URL(ServicioArticulosBeanPort_address), this);
                _stub.setPortName(getServicioArticulosBeanPortWSDDServiceName());
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
        if ("ServicioArticulosBeanPort".equals(inputPortName)) {
            return getServicioArticulosBeanPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicios.backend.despacho/", "ServicioArticulosBeanService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicios.backend.despacho/", "ServicioArticulosBeanPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioArticulosBeanPort".equals(portName)) {
            setServicioArticulosBeanPortEndpointAddress(address);
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
