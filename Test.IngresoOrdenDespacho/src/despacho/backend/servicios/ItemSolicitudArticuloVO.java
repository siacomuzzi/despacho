/**
 * ItemSolicitudArticuloVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package despacho.backend.servicios;

public class ItemSolicitudArticuloVO  implements java.io.Serializable {
    private int cantSolicitada;

    private java.lang.String idArticulo;

    public ItemSolicitudArticuloVO() {
    }

    public ItemSolicitudArticuloVO(
           int cantSolicitada,
           java.lang.String idArticulo) {
           this.cantSolicitada = cantSolicitada;
           this.idArticulo = idArticulo;
    }


    /**
     * Gets the cantSolicitada value for this ItemSolicitudArticuloVO.
     * 
     * @return cantSolicitada
     */
    public int getCantSolicitada() {
        return cantSolicitada;
    }


    /**
     * Sets the cantSolicitada value for this ItemSolicitudArticuloVO.
     * 
     * @param cantSolicitada
     */
    public void setCantSolicitada(int cantSolicitada) {
        this.cantSolicitada = cantSolicitada;
    }


    /**
     * Gets the idArticulo value for this ItemSolicitudArticuloVO.
     * 
     * @return idArticulo
     */
    public java.lang.String getIdArticulo() {
        return idArticulo;
    }


    /**
     * Sets the idArticulo value for this ItemSolicitudArticuloVO.
     * 
     * @param idArticulo
     */
    public void setIdArticulo(java.lang.String idArticulo) {
        this.idArticulo = idArticulo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ItemSolicitudArticuloVO)) return false;
        ItemSolicitudArticuloVO other = (ItemSolicitudArticuloVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cantSolicitada == other.getCantSolicitada() &&
            ((this.idArticulo==null && other.getIdArticulo()==null) || 
             (this.idArticulo!=null &&
              this.idArticulo.equals(other.getIdArticulo())));
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
        _hashCode += getCantSolicitada();
        if (getIdArticulo() != null) {
            _hashCode += getIdArticulo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ItemSolicitudArticuloVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicios.backend.despacho/", "itemSolicitudArticuloVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantSolicitada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cantSolicitada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idArticulo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idArticulo"));
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
