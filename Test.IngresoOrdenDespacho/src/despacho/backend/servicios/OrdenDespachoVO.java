/**
 * OrdenDespachoVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package despacho.backend.servicios;

public class OrdenDespachoVO  implements java.io.Serializable {
    private despacho.backend.servicios.ItemSolicitudArticuloVO[] articulos;

    private int codOrden;

    private int codPortal;

    private int codVenta;

    private java.lang.String estado;

    private java.lang.String nombreUsuario;

    public OrdenDespachoVO() {
    }

    public OrdenDespachoVO(
           despacho.backend.servicios.ItemSolicitudArticuloVO[] articulos,
           int codOrden,
           int codPortal,
           int codVenta,
           java.lang.String estado,
           java.lang.String nombreUsuario) {
           this.articulos = articulos;
           this.codOrden = codOrden;
           this.codPortal = codPortal;
           this.codVenta = codVenta;
           this.estado = estado;
           this.nombreUsuario = nombreUsuario;
    }


    /**
     * Gets the articulos value for this OrdenDespachoVO.
     * 
     * @return articulos
     */
    public despacho.backend.servicios.ItemSolicitudArticuloVO[] getArticulos() {
        return articulos;
    }


    /**
     * Sets the articulos value for this OrdenDespachoVO.
     * 
     * @param articulos
     */
    public void setArticulos(despacho.backend.servicios.ItemSolicitudArticuloVO[] articulos) {
        this.articulos = articulos;
    }

    public despacho.backend.servicios.ItemSolicitudArticuloVO getArticulos(int i) {
        return this.articulos[i];
    }

    public void setArticulos(int i, despacho.backend.servicios.ItemSolicitudArticuloVO _value) {
        this.articulos[i] = _value;
    }


    /**
     * Gets the codOrden value for this OrdenDespachoVO.
     * 
     * @return codOrden
     */
    public int getCodOrden() {
        return codOrden;
    }


    /**
     * Sets the codOrden value for this OrdenDespachoVO.
     * 
     * @param codOrden
     */
    public void setCodOrden(int codOrden) {
        this.codOrden = codOrden;
    }


    /**
     * Gets the codPortal value for this OrdenDespachoVO.
     * 
     * @return codPortal
     */
    public int getCodPortal() {
        return codPortal;
    }


    /**
     * Sets the codPortal value for this OrdenDespachoVO.
     * 
     * @param codPortal
     */
    public void setCodPortal(int codPortal) {
        this.codPortal = codPortal;
    }


    /**
     * Gets the codVenta value for this OrdenDespachoVO.
     * 
     * @return codVenta
     */
    public int getCodVenta() {
        return codVenta;
    }


    /**
     * Sets the codVenta value for this OrdenDespachoVO.
     * 
     * @param codVenta
     */
    public void setCodVenta(int codVenta) {
        this.codVenta = codVenta;
    }


    /**
     * Gets the estado value for this OrdenDespachoVO.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this OrdenDespachoVO.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the nombreUsuario value for this OrdenDespachoVO.
     * 
     * @return nombreUsuario
     */
    public java.lang.String getNombreUsuario() {
        return nombreUsuario;
    }


    /**
     * Sets the nombreUsuario value for this OrdenDespachoVO.
     * 
     * @param nombreUsuario
     */
    public void setNombreUsuario(java.lang.String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OrdenDespachoVO)) return false;
        OrdenDespachoVO other = (OrdenDespachoVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.articulos==null && other.getArticulos()==null) || 
             (this.articulos!=null &&
              java.util.Arrays.equals(this.articulos, other.getArticulos()))) &&
            this.codOrden == other.getCodOrden() &&
            this.codPortal == other.getCodPortal() &&
            this.codVenta == other.getCodVenta() &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.nombreUsuario==null && other.getNombreUsuario()==null) || 
             (this.nombreUsuario!=null &&
              this.nombreUsuario.equals(other.getNombreUsuario())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getArticulos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArticulos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArticulos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getCodOrden();
        _hashCode += getCodPortal();
        _hashCode += getCodVenta();
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getNombreUsuario() != null) {
            _hashCode += getNombreUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OrdenDespachoVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicios.backend.despacho/", "ordenDespachoVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("articulos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "articulos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicios.backend.despacho/", "itemSolicitudArticuloVO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codOrden");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codOrden"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codPortal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codPortal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codVenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codVenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
