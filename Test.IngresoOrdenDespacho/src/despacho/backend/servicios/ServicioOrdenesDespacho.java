/**
 * ServicioOrdenesDespacho.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package despacho.backend.servicios;

public interface ServicioOrdenesDespacho extends java.rmi.Remote {
    public void ingresarOrdenDespacho(despacho.backend.servicios.OrdenDespachoVO arg0) throws java.rmi.RemoteException;
    public void completarOrdenDespacho(int arg0) throws java.rmi.RemoteException;
}
