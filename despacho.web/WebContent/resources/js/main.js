var AppRouter = Backbone.Router.extend({

    routes: {
        ""                  	: "home",
        "usuarios"   			: "usuarios",
        "usuarios/add"         	: "addUsuario",
        "usuarios/:username"    : "usuarioDetails",
        "configuracion"   		: "configuracion",
    },

    initialize: function () {
        this.headerView = new HeaderView();
        $('.header').html(this.headerView.el);
    },

    usuarios: function(page) {
    	if (!this.usuariosView) {
            this.usuariosView = new UsuariosView();
        }
    	
    	$("#content").html(this.usuariosView.el);
    	this.headerView.selectMenuItem('usuarios-menu');
    	
        var usuarioList = new UsuarioCollection();
        usuarioList.fetch({success: function() {
        	$("#content .grid").html(new UsuarioListView({model: usuarioList}).el);
        }});
    },

    usuarioDetails: function (username) {
        var usuario = new Usuario({username: username});
        usuario.fetch({success: function(){
            $("#content").html(new UsuarioView({model: usuario}).el);
        }});
        
        this.headerView.selectMenuItem();
    },

    addUsuario: function() {
        var usuario = new Usuario();
        $('#content').html(new UsuarioView({model: usuario}).el);
        this.headerView.selectMenuItem();
    },

    configuracion: function () {
        if (!this.configuracionView) {
            this.configuracionView = new ConfiguracionView();
        }
        
        $('#content').html(this.configuracionView.el);
        this.headerView.selectMenuItem('configuracion-menu');
    },
    
    home: function () {
        if (!this.homeView) {
            this.homeView = new HomeView();
        }
        
        $('#content').html(this.homeView.el);
        this.headerView.selectMenuItem('home-menu');
    }
});

utils.loadTemplate(['HomeView', 'HeaderView', 'UsuariosView', 'UsuarioView', 'UsuarioListItemView', 'ConfiguracionView'], function() {
    app = new AppRouter();
    Backbone.history.start();
});
