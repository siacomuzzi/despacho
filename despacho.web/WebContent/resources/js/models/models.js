// Usuario
window.Usuario = Backbone.Model.extend({

    urlRoot: window.baseUrl + "api/usuarios",
    idAttribute: "username",

    initialize: function () {
        this.validators = {};

        this.validators.username = function (value) {
            return value.length > 0 ? {isValid: true} : {isValid: false, message: "Ingrese un nombre de usuario."};
        };
    },

    validateItem: function (key) {
        return (this.validators[key]) ? this.validators[key](this.get(key)) : {isValid: true};
    },

    validateAll: function () {

        var messages = {};

        for (var key in this.validators) {
            if(this.validators.hasOwnProperty(key)) {
                var check = this.validators[key](this.get(key));
                if (check.isValid === false) {
                    messages[key] = check.message;
                }
            }
        }

        return _.size(messages) > 0 ? {isValid: false, messages: messages} : {isValid: true};
    },

    defaults: {
    	username: "",
    	nombre: "",
    	apellido: "",
    	password: "",
    	activo: true
    }
});

window.UsuarioCollection = Backbone.Collection.extend({
	model: Usuario,
    url: window.baseUrl + "api/usuarios"
});

// Configuracion
window.Configuracion = Backbone.Model.extend({

    urlRoot: window.baseUrl + "api/configuracion",
    idAttribute: "key",

    defaults: {
    	key: "",
    	value: ""
    }
});

window.ConfiguracionCollection = Backbone.Collection.extend({
	model: Configuracion,
    url: window.baseUrl + "api/configuracion"
});

// Articulos
window.Articulo = Backbone.Model.extend({

    urlRoot: window.baseUrl + "api/articulos",
    idAttribute: "idArticulo",

    defaults: {
    	idArticulo: "",
    	nombre: "",
    	marca: "",
    	categoria: "",
    	origen: "",
    	precio: "",
    	idDeposito: "",
    }
});

window.ArticulosCollection = Backbone.Collection.extend({
	model: Articulo,
    url: window.baseUrl + "api/articulos"
});

// Solicitudes
window.Solicitud = Backbone.Model.extend({

    urlRoot: window.baseUrl + "api/solicitudes",
    idAttribute: "id",

    defaults: {
    	id: "",
    	fecha: "",
    	cantidad: "",
    	estado: "",
    	codigoOrden: "",
    	articulo: "",
    	idDeposito: ""
    }
});

window.SolicitudesCollection = Backbone.Collection.extend({
	model: Solicitud,
    url: window.baseUrl + "api/solicitudes"
});

// Ordenes de Despacho
window.Orden = Backbone.Model.extend({

    urlRoot: window.baseUrl + "api/ordenes",
    idAttribute: "codOrden",

    defaults: {
    	codOrden: 0,
    	codVenta: 0,
    	codPortal: 0,
    	fecha: new Date(),
    	articulos: [],
    	nombreUsuario: "",
    	estado: ""
    }
});

window.OrdenesCollection = Backbone.Collection.extend({
	model: Orden,
    url: window.baseUrl + "api/ordenes"
});
