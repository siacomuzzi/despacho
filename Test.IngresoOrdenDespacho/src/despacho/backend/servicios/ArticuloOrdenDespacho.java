/**
 * ArticuloOrdenDespacho.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package despacho.backend.servicios;

public class ArticuloOrdenDespacho  implements java.io.Serializable {
    private java.lang.String codigo;

    private despacho.backend.servicios.Deposito deposito;

    public ArticuloOrdenDespacho() {
    }

    public ArticuloOrdenDespacho(
           java.lang.String codigo,
           despacho.backend.servicios.Deposito deposito) {
           this.codigo = codigo;
           this.deposito = deposito;
    }


    /**
     * Gets the codigo value for this ArticuloOrdenDespacho.
     * 
     * @return codigo
     */
    public java.lang.String getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this ArticuloOrdenDespacho.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the deposito value for this ArticuloOrdenDespacho.
     * 
     * @return deposito
     */
    public despacho.backend.servicios.Deposito getDeposito() {
        return deposito;
    }


    /**
     * Sets the deposito value for this ArticuloOrdenDespacho.
     * 
     * @param deposito
     */
    public void setDeposito(despacho.backend.servicios.Deposito deposito) {
        this.deposito = deposito;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArticuloOrdenDespacho)) return false;
        ArticuloOrdenDespacho other = (ArticuloOrdenDespacho) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            ((this.deposito==null && other.getDeposito()==null) || 
             (this.deposito!=null &&
              this.deposito.equals(other.getDeposito())));
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
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        if (getDeposito() != null) {
            _hashCode += getDeposito().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArticuloOrdenDespacho.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicios.backend.despacho/", "articuloOrdenDespacho"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deposito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deposito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicios.backend.despacho/", "deposito"));
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
