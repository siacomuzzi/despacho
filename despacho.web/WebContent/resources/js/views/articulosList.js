window.ArticuloListView = Backbone.View.extend({

    initialize: function () {
        this.render();
    },

    render: function () {
        $(this.el).html(this.template());
        this.getArticulos(1);
        return this;
    },

    getArticulos: function(page) {
      var articulosList = new ArticulosCollection();
      var el = this.el;

      articulosList.fetch({
        success: function(results) {
            var articulos = results.models;
            var len = articulos.length;

            $('.articulos tr', el).remove();

            for (var i = 0; i < len; i++) {
                $('.articulos', el).append(new ArticuloListItemView({ model: articulos[i] }).render().el);
            }
        },
        error: function(model, error) {
            if (error) {
                utils.showAlert('Error!', 'Ocurrio un error al intentar obtener la lista de articulos.', 'alert-danger', el);
            }
      }});
    }
});

window.ArticuloListItemView = Backbone.View.extend({
    tagName: 'tr',

    initialize: function () {
        this.model.bind('change', this.render, this);
        this.model.bind('destroy', this.close, this);
    },

    render: function () {
    	alert(this.model);
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    }
});
