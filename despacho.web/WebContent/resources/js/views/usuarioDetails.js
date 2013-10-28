window.UsuarioView = Backbone.View.extend({

    initialize: function () {
        this.render();
    },

    render: function () {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    },

    events: {
        "change"        : "change",
        "click .save"   : "beforeSave",
        "click .delete" : "deleteUsuario"
    },

    change: function (event) {
        // Remove any existing alert message
        utils.hideAlert();

        // Apply the change to the model
        var target = event.target;
        var change = {};
        change[target.name] = target.value;
        this.model.set(change);

        // Run validation rule (if any) on changed item
        var check = this.model.validateItem(target.id);
        if (check.isValid === false) {
            utils.addValidationError(target.id, check.message);
        } else {
            utils.removeValidationError(target.id);
        }
    },

    beforeSave: function () {
        var self = this;
        var check = this.model.validateAll();
        if (check.isValid === false) {
            utils.displayValidationErrors(check.messages);
            return false;
        }
        
        this.saveUsuario();
        return false;
    },

    saveUsuario: function () {
        var self = this;
        this.model.save(null, {
            success: function (model) {
                self.render();
                app.navigate('usuarios/' + model.username, false);
                utils.showAlert('Success!', 'Usuario guardado!', 'alert-success');
            },
            error: function () {
                utils.showAlert('Error', 'Ocurrio un error mientras se trataba de guardar los cambios.', 'alert-error');
            }
        });
    },

    deleteUsuario: function () {
        this.model.destroy({
            success: function () {
                alert('Usuario borrado.');
                window.history.back();
            }
        });
        
        return false;
    },

});
