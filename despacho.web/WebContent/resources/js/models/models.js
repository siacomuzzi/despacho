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
