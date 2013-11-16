/**
 * ServicioArticulosBean.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package despacho.backend.servicios;

public interface ServicioArticulosBean extends java.rmi.Remote {
    public java.lang.Boolean recepcionArticulosParaDespachar(despacho.backend.servicios.SolicitudArticuloVO arg0) throws java.rmi.RemoteException;
    public void ingresarArticulo(despacho.backend.servicios.ArticuloVO arg0) throws java.rmi.RemoteException;
}
