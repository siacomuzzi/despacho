window.SolicitudListView = Backbone.View.extend({

    initialize: function () {
        this.render();
    },

    render: function () {
        $(this.el).html(this.template());
        this.getSolicitudes(1);
        return this;
    },

    getSolicitudes: function(page) {
      var solicitudesList = new SolicitudesCollection();
      var el = this.el;

      solicitudesList.fetch({
        success: function(results) {
            var solicitudes = results.models;
            var len = solicitudes.length;

            $('.solicitudes tr', el).remove();

            for (var i = 0; i < len; i++) {
                $('.solicitudes', el).append(new SolicitudListItemView({ model: solicitudes[i] }).render().el);
            }
        },
        error: function(model, error) {
            if (error) {
                utils.showAlert('Error!', 'Ocurrio un error al intentar obtener la lista de solicitudes.', 'alert-danger', el);
            }
      }});
    }
});

window.SolicitudListItemView = Backbone.View.extend({
    tagName: 'tr',

    initialize: function () {
        this.model.bind('change', this.render, this);
        this.model.bind('destroy', this.close, this);
    },

    render: function () {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    }
});
