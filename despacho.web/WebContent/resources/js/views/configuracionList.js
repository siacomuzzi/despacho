window.ConfiguracionListView = Backbone.View.extend({

    initialize: function () {
        this.render();
    },

    render: function () {
        $(this.el).html(this.template());
        this.geConfiguracion(1);
        return this;
    },

    geConfiguracion: function(page) {
      var configuracionList = new ConfiguracionCollection();
      var el = this.el;

      configuracionList.fetch({
        success: function(results) {
            var configuracion = results.models;
            var len = configuracion.length;

            $('.configuracion tr', el).remove();

            for (var i = 0; i < len; i++) {
                $('.configuracion', el).append(new ConfiguracionListItemView({ model: configuracion[i] }).render().el);
            }
        },
        error: function(model, error) {
            if (error) {
                utils.showAlert('Error!', 'Ocurrio un error al intentar obtener la lista de configuracion.', 'alert-danger', el);
            }
      }});
    }
});

window.ConfiguracionListItemView = Backbone.View.extend({
    tagName: 'tr',

    events: {
        "click #editConfiguracion": 			"editConfiguracion",
        "click #updateConfiguracion": 			"updateConfiguracion",
        "click #cancelUpdateConfiguracion": 	"cancelUpdateConfiguracion",
        "keypress td input": 					"updateConfiguracion",
        "keydown td input": 					"cancelUpdateConfiguracion"
    },

    initialize: function () {
        this.model.bind('change', this.render, this);
        this.model.bind('destroy', this.close, this);
    },

    render: function () {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    },

    editConfiguracion: function(e) {
        e.preventDefault();
        var $tr = $(e.target).closest('tr');
        $tr.addClass('editing');
        $('td:nth-child(2) input', $tr).focus();
    },

    cancelUpdateConfiguracion: function(e) {
        if (typeof e.keyCode != "undefined" && e.keyCode != 27) { return; }
        e.preventDefault();
        var $tr = $(e.target).closest('tr');
        $tr.removeClass('editing');
    },

    updateConfiguracion: function(e) {
        if (typeof e.keyCode != "undefined" && e.keyCode != 13) { return; }
        e.preventDefault();

        $tr.removeClass('editing');
    }
});
