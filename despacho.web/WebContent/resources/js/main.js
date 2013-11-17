var AppRouter = Backbone.Router.extend({

    routes: {
        ""                  	: "home",
        "usuarios"   			: "usuarios",
        "configuracion"   		: "configuracion",
        "articulos"   			: "articulos",
        "ordenes"   			: "ordenes",
        "solicitudes"   		: "solicitudes"
    },

    initialize: function () {
        this.headerView = new HeaderView();
        $('.header').html(this.headerView.el);
    },

    usuarios: function(page) {
    	var usuarioList = new UsuarioCollection();
        
    	usuarioList.fetch({success: function(){
            $('#content').html(new UsuarioListView({ model: usuarioList }).el);
        }});

        this.headerView.selectMenuItem('usuarios-menu');
    },

    configuracion: function () {
    	var configuracionList = new ConfiguracionCollection();
        
    	configuracionList.fetch({success: function(){
            $('#content').html(new ConfiguracionListView({ model: configuracionList }).el);
        }});
    	
        this.headerView.selectMenuItem('configuracion-menu');
    },
    
    articulos: function () {
    	var articulosList = new ArticulosCollection();
        
    	articulosList.fetch({success: function(){
            $('#content').html(new ArticuloListView({ model: articulosList }).el);
        }});
    	
        this.headerView.selectMenuItem('articulos-menu');
    },
    
    home: function () {
        if (!this.homeView) {
            this.homeView = new HomeView();
        }
        
        $('#content').html(this.homeView.el);
        this.headerView.selectMenuItem('home-menu');
    }
});

$(document).on({
    ajaxStart: function() {
        $('.load-modal', this).css("display", "block");
    },
    ajaxStop: function() {
        $('.load-modal', this).css("display", "none");
    }
});

utils.loadTemplate(['HomeView', 'HeaderView', 'UsuarioListView', 'UsuarioListItemView', 'ConfiguracionListView', 'ConfiguracionListItemView', 'ArticuloListItemView', 'ArticuloListView'], function() {
    app = new AppRouter();
    Backbone.history.start();
});
