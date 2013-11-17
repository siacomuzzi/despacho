window.OrdenListView = Backbone.View.extend({

    initialize: function () {
        this.render();
    },

    render: function () {
        $(this.el).html(this.template());
        this.getOrdenes(1);
        return this;
    },

    getOrdenes: function(page) {
      var ordenesList = new OrdenesCollection();
      var el = this.el;

      ordenesList.fetch({
        success: function(results) {
            var ordenes = results.models;
            var len = ordenes.length;

            $('.ordenes tr', el).remove();

            for (var i = 0; i < len; i++) {
                $('.ordenes', el).append(new OrdenListItemView({ model: ordenes[i] }).render().el);
            }
        },
        error: function(model, error) {
            if (error) {
                utils.showAlert('Error!', 'Ocurrio un error al intentar obtener la lista de ordenes de despacho.', 'alert-danger', el);
            }
      }});
    }
});

window.OrdenListItemView = Backbone.View.extend({
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
