window.UsuarioListView = Backbone.View.extend({

    initialize: function () {
        this.render();
    },

    render: function () {
        var usuarios = this.model.models;

        $(this.el).html('<ul class="thumbnails"></ul>');

        for (var i = 0; i < usuarios.length; i++) {
            $('.thumbnails', this.el).append(new UsuarioListItemView({model: usuarios[i]}).render().el);
        }

        return this;
    }
});

window.UsuarioListItemView = Backbone.View.extend({

    tagName: "li",

    className: "span3",

    initialize: function () {
        this.model.bind("change", this.render, this);
        this.model.bind("destroy", this.close, this);
    },

    render: function () {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    }

});
