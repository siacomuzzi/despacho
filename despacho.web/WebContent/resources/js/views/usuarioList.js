window.UsuarioListView = Backbone.View.extend({

    initialize: function () {
        this.render();
    },

    events: {
        "click #openUserModal": 					"openUserModal",
        "click #addUser": 							"addUser",
        "keypress #addUserModal input, textarea": 	"addUser"
    },

    render: function () {
        $(this.el).html(this.template());
        this.getUsers(1);
        return this;
    },

    getUsers: function(page) {
      var usersList = new UsuarioCollection();
      var el = this.el;

      usersList.fetch({
        success: function(results) {
            var users = results.models;
            var len = users.length;

            $('.users tr', el).remove();

            for (var i = 0; i < len; i++) {
                $('.users', el).append(new UsuarioListItemView({ model: users[i] }).render().el);
            }
        },
        error: function(model, error) {
            if (error) {
                utils.showAlert('Error!', 'Ocurrio un error al intentar obtener la lista de usuarios.', 'alert-danger', el);
            }
      }});
    },

    openUserModal: function(e) {
        e.preventDefault();

        $($(e.target).attr('href'), e.target.parentElement.parentElement).on('shown.bs.modal', function () {
            $('input#username', this).focus();
        });
    },

    addUser: function(e) {
        if (typeof e.keyCode != "undefined" && e.keyCode != 13) { return; }
        e.preventDefault();

        var username = $.trim($('#addUserModal #username').val());
        var password = $.trim($('#addUserModal #password').val());
        var nombre = $.trim($('#addUserModal #nombre').val());
        var apellido = $.trim($('#addUserModal #apellido').val());
        var activo = $('#addUserModal #activo')[0].checked;

        var user = new Usuario(
        {
            username: username,
            password: password,
            nombre: nombre,
            apellido: apellido,
            activo: activo
        });

        var check = user.validateAll();
        if (check.isValid === false) {
            utils.displayValidationErrors(check.messages, '#addUserModal');
            return false;
        }
        
        user.url = function() { return 'api/users'; };
        user.isNew = function() { return true; };

        user.save(null, {
            success: function(model) {
                $('#addUserModal').modal('hide');
                
                // Clean form
                $('#addUserModal input, textarea').val("");
                $('#addUserModal input').removeAttr('checked');
                $('#addUserModal .control-group').removeClass('error');
                $('#addUserModal .help-inline').text("");
                $('#addUserModal .alert').hide();

                $('tbody.users', this.el).append(new UsuarioListItemView({ model: model }).render().el);
            },
            error: function(model, error) {
                if (error.status == 500 || error.status == 400 || error.status == 404) {
                    utils.showAlert('Error!', 'Ocurrio un error al intentar guardar el usuario.', 'alert-danger', '#addUserModal');
                }
            }
        });

        return this;
    }
});

window.UsuarioListItemView = Backbone.View.extend({
    tagName: 'tr',

    events: {
        "click #editUser": 			"editUser",
        "click #deleteUser": 		"deleteUser",
        "click #updateUser": 		"updateUser",
        "click #cancelUpdateUser": 	"cancelUpdateUser",
        "keypress td input": 		"updateUser",
        "keydown td input": 		"cancelUpdateUser"
    },

    initialize: function () {
        this.model.bind('change', this.render, this);
        this.model.bind('destroy', this.close, this);
    },

    render: function () {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    },

    editUser: function(e) {
        e.preventDefault();
        var $tr = $(e.target).closest('tr');
        $tr.addClass('editing');
        $('td:nth-child(2) input', $tr).focus();
    },

    cancelUpdateUser: function(e) {
        if (typeof e.keyCode != "undefined" && e.keyCode != 27) { return; }
        e.preventDefault();
        var $tr = $(e.target).closest('tr');
        $tr.removeClass('editing');
    },

    updateUser: function(e) {
        if (typeof e.keyCode != "undefined" && e.keyCode != 13) { return; }
        e.preventDefault();
        var $tr = $(e.target).closest('tr');

        var username = $('span#username', $tr).text();
        var nombre = $('input#nombre', $tr).val();
        var apellido = $('input#apellido', $tr).val();
        var activo = $('input#activo', $tr)[0].checked;

        var el = this.el.parentElement.parentElement.parentElement;

        var user = new Usuario({
            username: username,
            password: 'placeholder', // Password no se actualiza en el PUT
            nombre: nombre,
            apellido: apellido,
            activo: activo
        });

        var check = user.validateAll();
        if (check.isValid === false) {
            utils.displayValidationErrors(check.messages, el);
            $('.alert', '#addUserModal').hide();
            return false;
        }

        this.model.save(
        { 
        	username: username,
            nombre: nombre,
            apellido: apellido,
            activo: activo
        },
        {
            success: function(model) {
                $('.alert', el).hide();
            },
            error: function(model, error) {
                if (error.status == 500 || error.status == 400 || error.status == 404) {
                    utils.showAlert('Error!', 'Ocurrio un error al intentar guardar el usuario.', 'alert-danger', el);
                    $('.alert', '#addUserModal').hide();
                };
            }
        });

        $tr.removeClass('editing');
    },

    deleteUser: function(e) {
        e.preventDefault();
        var el = this.el;
        
        if (confirm('Esta seguro que desea borrar el usuario seleccionado?')) {
            this.model.destroy({success: function(model) {
                var $tr = $(e.target).closest('tr');
                $tr.remove();
            },
            error: function(model, error) {
                utils.showAlert('Error!', 'Ocurrio un error al intentar borrar un usuario.', 'alert-danger', el.parentElement.parentElement.parentElement);
                $('.alert', '#addUserModal').hide();
            }});
        }
    },
});
