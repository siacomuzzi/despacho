/**
 * SolicitudArticuloVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package despacho.backend.servicios;

public class SolicitudArticuloVO  implements java.io.Serializable {
    private despacho.backend.servicios.ItemSolicitudArticuloVO[] articulos;

    private java.lang.String estado;

    private java.util.Calendar fecha;

    private java.lang.String idDespacho;

    private java.lang.String idSolicitudArticulo;

    public SolicitudArticuloVO() {
    }

    public SolicitudArticuloVO(
           despacho.backend.servicios.ItemSolicitudArticuloVO[] articulos,
           java.lang.String estado,
           java.util.Calendar fecha,
           java.lang.String idDespacho,
           java.lang.String idSolicitudArticulo) {
           this.articulos = articulos;
           this.estado = estado;
           this.fecha = fecha;
           this.idDespacho = idDespacho;
           this.idSolicitudArticulo = idSolicitudArticulo;
    }


    /**
     * Gets the articulos value for this SolicitudArticuloVO.
     * 
     * @return articulos
     */
    public despacho.backend.servicios.ItemSolicitudArticuloVO[] getArticulos() {
        return articulos;
    }


    /**
     * Sets the articulos value for this SolicitudArticuloVO.
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
     * Gets the estado value for this SolicitudArticuloVO.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this SolicitudArticuloVO.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the fecha value for this SolicitudArticuloVO.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this SolicitudArticuloVO.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the idDespacho value for this SolicitudArticuloVO.
     * 
     * @return idDespacho
     */
    public java.lang.String getIdDespacho() {
        return idDespacho;
    }


    /**
     * Sets the idDespacho value for this SolicitudArticuloVO.
     * 
     * @param idDespacho
     */
    public void setIdDespacho(java.lang.String idDespacho) {
        this.idDespacho = idDespacho;
    }


    /**
     * Gets the idSolicitudArticulo value for this SolicitudArticuloVO.
     * 
     * @return idSolicitudArticulo
     */
    public java.lang.String getIdSolicitudArticulo() {
        return idSolicitudArticulo;
    }


    /**
     * Sets the idSolicitudArticulo value for this SolicitudArticuloVO.
     * 
     * @param idSolicitudArticulo
     */
    public void setIdSolicitudArticulo(java.lang.String idSolicitudArticulo) {
        this.idSolicitudArticulo = idSolicitudArticulo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SolicitudArticuloVO)) return false;
        SolicitudArticuloVO other = (SolicitudArticuloVO) obj;
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
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.idDespacho==null && other.getIdDespacho()==null) || 
             (this.idDespacho!=null &&
              this.idDespacho.equals(other.getIdDespacho()))) &&
            ((this.idSolicitudArticulo==null && other.getIdSolicitudArticulo()==null) || 
             (this.idSolicitudArticulo!=null &&
              this.idSolicitudArticulo.equals(other.getIdSolicitudArticulo())));
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
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getIdDespacho() != null) {
            _hashCode += getIdDespacho().hashCode();
        }
        if (getIdSolicitudArticulo() != null) {
            _hashCode += getIdSolicitudArticulo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SolicitudArticuloVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicios.backend.despacho/", "solicitudArticuloVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("articulos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "articulos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicios.backend.despacho/", "itemSolicitudArticuloVO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idDespacho");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idDespacho"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idSolicitudArticulo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idSolicitudArticulo"));
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
