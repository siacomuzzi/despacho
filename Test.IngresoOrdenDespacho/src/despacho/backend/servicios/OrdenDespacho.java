/**
 * OrdenDespacho.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package despacho.backend.servicios;

public class OrdenDespacho  implements java.io.Serializable {
    private despacho.backend.servicios.ArticuloOrdenDespacho[] articulos;

    private java.lang.String codigo;

    private java.lang.String estado;

    public OrdenDespacho() {
    }

    public OrdenDespacho(
           despacho.backend.servicios.ArticuloOrdenDespacho[] articulos,
           java.lang.String codigo,
           java.lang.String estado) {
           this.articulos = articulos;
           this.codigo = codigo;
           this.estado = estado;
    }


    /**
     * Gets the articulos value for this OrdenDespacho.
     * 
     * @return articulos
     */
    public despacho.backend.servicios.ArticuloOrdenDespacho[] getArticulos() {
        return articulos;
    }


    /**
     * Sets the articulos value for this OrdenDespacho.
     * 
     * @param articulos
     */
    public void setArticulos(despacho.backend.servicios.ArticuloOrdenDespacho[] articulos) {
        this.articulos = articulos;
    }

    public despacho.backend.servicios.ArticuloOrdenDespacho getArticulos(int i) {
        return this.articulos[i];
    }

    public void setArticulos(int i, despacho.backend.servicios.ArticuloOrdenDespacho _value) {
        this.articulos[i] = _value;
    }


    /**
     * Gets the codigo value for this OrdenDespacho.
     * 
     * @return codigo
     */
    public java.lang.String getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this OrdenDespacho.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the estado value for this OrdenDespacho.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this OrdenDespacho.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OrdenDespacho)) return false;
        OrdenDespacho other = (OrdenDespacho) obj;
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
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado())));
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
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OrdenDespacho.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicios.backend.despacho/", "ordenDespacho"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("articulos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "articulos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicios.backend.despacho/", "articuloOrdenDespacho"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estado"));
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
