/**
 * ArticuloVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package despacho.backend.servicios;

public class ArticuloVO  implements java.io.Serializable {
    private despacho.backend.servicios.AtributoVO[] atributos;

    private java.lang.String categoria;

    private java.lang.String descripcion;

    private java.lang.String foto;

    private java.lang.String idDeposito;

    private java.lang.String idarticulo;

    private java.lang.String marca;

    private java.lang.String nombre;

    private java.lang.String origen;

    private float precio;

    private int stock;

    public ArticuloVO() {
    }

    public ArticuloVO(
           despacho.backend.servicios.AtributoVO[] atributos,
           java.lang.String categoria,
           java.lang.String descripcion,
           java.lang.String foto,
           java.lang.String idDeposito,
           java.lang.String idarticulo,
           java.lang.String marca,
           java.lang.String nombre,
           java.lang.String origen,
           float precio,
           int stock) {
           this.atributos = atributos;
           this.categoria = categoria;
           this.descripcion = descripcion;
           this.foto = foto;
           this.idDeposito = idDeposito;
           this.idarticulo = idarticulo;
           this.marca = marca;
           this.nombre = nombre;
           this.origen = origen;
           this.precio = precio;
           this.stock = stock;
    }


    /**
     * Gets the atributos value for this ArticuloVO.
     * 
     * @return atributos
     */
    public despacho.backend.servicios.AtributoVO[] getAtributos() {
        return atributos;
    }


    /**
     * Sets the atributos value for this ArticuloVO.
     * 
     * @param atributos
     */
    public void setAtributos(despacho.backend.servicios.AtributoVO[] atributos) {
        this.atributos = atributos;
    }

    public despacho.backend.servicios.AtributoVO getAtributos(int i) {
        return this.atributos[i];
    }

    public void setAtributos(int i, despacho.backend.servicios.AtributoVO _value) {
        this.atributos[i] = _value;
    }


    /**
     * Gets the categoria value for this ArticuloVO.
     * 
     * @return categoria
     */
    public java.lang.String getCategoria() {
        return categoria;
    }


    /**
     * Sets the categoria value for this ArticuloVO.
     * 
     * @param categoria
     */
    public void setCategoria(java.lang.String categoria) {
        this.categoria = categoria;
    }


    /**
     * Gets the descripcion value for this ArticuloVO.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this ArticuloVO.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the foto value for this ArticuloVO.
     * 
     * @return foto
     */
    public java.lang.String getFoto() {
        return foto;
    }


    /**
     * Sets the foto value for this ArticuloVO.
     * 
     * @param foto
     */
    public void setFoto(java.lang.String foto) {
        this.foto = foto;
    }


    /**
     * Gets the idDeposito value for this ArticuloVO.
     * 
     * @return idDeposito
     */
    public java.lang.String getIdDeposito() {
        return idDeposito;
    }


    /**
     * Sets the idDeposito value for this ArticuloVO.
     * 
     * @param idDeposito
     */
    public void setIdDeposito(java.lang.String idDeposito) {
        this.idDeposito = idDeposito;
    }


    /**
     * Gets the idarticulo value for this ArticuloVO.
     * 
     * @return idarticulo
     */
    public java.lang.String getIdarticulo() {
        return idarticulo;
    }


    /**
     * Sets the idarticulo value for this ArticuloVO.
     * 
     * @param idarticulo
     */
    public void setIdarticulo(java.lang.String idarticulo) {
        this.idarticulo = idarticulo;
    }


    /**
     * Gets the marca value for this ArticuloVO.
     * 
     * @return marca
     */
    public java.lang.String getMarca() {
        return marca;
    }


    /**
     * Sets the marca value for this ArticuloVO.
     * 
     * @param marca
     */
    public void setMarca(java.lang.String marca) {
        this.marca = marca;
    }


    /**
     * Gets the nombre value for this ArticuloVO.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this ArticuloVO.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the origen value for this ArticuloVO.
     * 
     * @return origen
     */
    public java.lang.String getOrigen() {
        return origen;
    }


    /**
     * Sets the origen value for this ArticuloVO.
     * 
     * @param origen
     */
    public void setOrigen(java.lang.String origen) {
        this.origen = origen;
    }


    /**
     * Gets the precio value for this ArticuloVO.
     * 
     * @return precio
     */
    public float getPrecio() {
        return precio;
    }


    /**
     * Sets the precio value for this ArticuloVO.
     * 
     * @param precio
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }


    /**
     * Gets the stock value for this ArticuloVO.
     * 
     * @return stock
     */
    public int getStock() {
        return stock;
    }


    /**
     * Sets the stock value for this ArticuloVO.
     * 
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArticuloVO)) return false;
        ArticuloVO other = (ArticuloVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.atributos==null && other.getAtributos()==null) || 
             (this.atributos!=null &&
              java.util.Arrays.equals(this.atributos, other.getAtributos()))) &&
            ((this.categoria==null && other.getCategoria()==null) || 
             (this.categoria!=null &&
              this.categoria.equals(other.getCategoria()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.foto==null && other.getFoto()==null) || 
             (this.foto!=null &&
              this.foto.equals(other.getFoto()))) &&
            ((this.idDeposito==null && other.getIdDeposito()==null) || 
             (this.idDeposito!=null &&
              this.idDeposito.equals(other.getIdDeposito()))) &&
            ((this.idarticulo==null && other.getIdarticulo()==null) || 
             (this.idarticulo!=null &&
              this.idarticulo.equals(other.getIdarticulo()))) &&
            ((this.marca==null && other.getMarca()==null) || 
             (this.marca!=null &&
              this.marca.equals(other.getMarca()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.origen==null && other.getOrigen()==null) || 
             (this.origen!=null &&
              this.origen.equals(other.getOrigen()))) &&
            this.precio == other.getPrecio() &&
            this.stock == other.getStock();
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
        if (getAtributos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAtributos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAtributos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCategoria() != null) {
            _hashCode += getCategoria().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getFoto() != null) {
            _hashCode += getFoto().hashCode();
        }
        if (getIdDeposito() != null) {
            _hashCode += getIdDeposito().hashCode();
        }
        if (getIdarticulo() != null) {
            _hashCode += getIdarticulo().hashCode();
        }
        if (getMarca() != null) {
            _hashCode += getMarca().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getOrigen() != null) {
            _hashCode += getOrigen().hashCode();
        }
        _hashCode += new Float(getPrecio()).hashCode();
        _hashCode += getStock();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArticuloVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicios.backend.despacho/", "articuloVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("atributos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "atributos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicios.backend.despacho/", "atributoVO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoria");
        elemField.setXmlName(new javax.xml.namespace.QName("", "categoria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("foto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "foto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idDeposito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idDeposito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idarticulo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idarticulo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("marca");
        elemField.setXmlName(new javax.xml.namespace.QName("", "marca"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("origen");
        elemField.setXmlName(new javax.xml.namespace.QName("", "origen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("precio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "precio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stock");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stock"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
