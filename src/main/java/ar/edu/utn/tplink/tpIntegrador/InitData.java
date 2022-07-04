package ar.edu.utn.tplink.tpIntegrador;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;

import ar.edu.utn.tplink.tpIntegrador.model.Administrador;
import ar.edu.utn.tplink.tpIntegrador.model.CarritoDeCompra;
import ar.edu.utn.tplink.tpIntegrador.model.CategoriaDeProducto;
import ar.edu.utn.tplink.tpIntegrador.model.Cliente;
import ar.edu.utn.tplink.tpIntegrador.model.CuponDescuento;
import ar.edu.utn.tplink.tpIntegrador.model.ItemDeCompra;
import ar.edu.utn.tplink.tpIntegrador.model.MedioDePago;
import ar.edu.utn.tplink.tpIntegrador.model.Membresia;
import ar.edu.utn.tplink.tpIntegrador.model.MetodoDePago;
import ar.edu.utn.tplink.tpIntegrador.model.OrdenDeCompra;
import ar.edu.utn.tplink.tpIntegrador.model.Producto;
import ar.edu.utn.tplink.tpIntegrador.model.Promocion;
import ar.edu.utn.tplink.tpIntegrador.model.Proveedor;
import ar.edu.utn.tplink.tpIntegrador.model.Rol;
import ar.edu.utn.tplink.tpIntegrador.model.TipoUsuario;
import ar.edu.utn.tplink.tpIntegrador.model.Usuario;
import ar.edu.utn.tplink.tpIntegrador.model.Vendedor;
import ar.edu.utn.tplink.tpIntegrador.repository.IAdministradorRepository;
import ar.edu.utn.tplink.tpIntegrador.repository.ICarritoDeCompraRepository;
import ar.edu.utn.tplink.tpIntegrador.repository.IClienteRepository;
import ar.edu.utn.tplink.tpIntegrador.repository.IItemDeCompraRepository;
import ar.edu.utn.tplink.tpIntegrador.repository.IOrdenDeCompraRepository;
import ar.edu.utn.tplink.tpIntegrador.repository.IProductoRepository;
import ar.edu.utn.tplink.tpIntegrador.repository.IPromocionRepository;
import ar.edu.utn.tplink.tpIntegrador.repository.IProveedorRepository;
import ar.edu.utn.tplink.tpIntegrador.repository.IRolRepository;
import ar.edu.utn.tplink.tpIntegrador.repository.IUsuarioRepository;
import ar.edu.utn.tplink.tpIntegrador.repository.IVendedorRepository;




@Component
public class InitData implements CommandLineRunner {
 
	@Autowired
	IAdministradorRepository repoAdmin;
	
	@Autowired
	IProductoRepository repoProducto;
	
	@Autowired
	IProveedorRepository repoProveedor;
	
	@Autowired
	IVendedorRepository repoVendedor;
	
	@Autowired
	IRolRepository repoRol;
	
	@Autowired
	IUsuarioRepository repoUsuario;
	
	@Autowired
	IClienteRepository repoCliente;
	
	@Autowired
	IItemDeCompraRepository repoItemDeCompra;
	
	@Autowired
	IOrdenDeCompraRepository repoOrdenDeCompra;
	
	@Autowired
	ICarritoDeCompraRepository repoCarrito;
	
	@Autowired
	RepositoryRestConfiguration config;
	
	@Autowired
	IPromocionRepository repoPromocion;
	
	@Override
	public void run(String... args) throws Exception {
		config.exposeIdsFor(Producto.class,Proveedor.class,Vendedor.class,Cliente.class,CarritoDeCompra.class,ItemDeCompra.class,OrdenDeCompra.class,Administrador.class);
		if(repoProducto.count() == 0) {
			

			
			//---------Administrador-------
			
			// Administrador admin1 = new Administrador(nombre,apellido,documento)
			
			Administrador admin1 = new Administrador("Luis", "Hernandez","32456564");
			Administrador admin2 = new Administrador("Francisco", "Melomano","3456774");
			
			List<Administrador> administradores = List.of(admin1,admin2);
			
			administradores.stream().forEach(administrador->{
				repoAdmin.save(administrador);
			});
			//---------Clientes-----------
			
			//Cliente cliente = new Cliente(nombre,apellido,documento,direccion,telefono,carritoDeCompra,esMiembro, comprasRealizadas);

			Cliente cliente1 = new Cliente("Maria", "Hidalgo", "32133454","Maipu 123","112345653", true, new ArrayList<OrdenDeCompra>());
			
			Cliente cliente2 = new Cliente("Juan", "Maita","37485939","Las Heras 345","1145642353", true, new ArrayList<OrdenDeCompra>());
			
			Cliente cliente3= new Cliente("Brandon", "Maita", "43453564","Las Heras 345","1124564435", true, new ArrayList<OrdenDeCompra>());
			
			Cliente cliente4= new Cliente("Charo", "Torres", "345664323","Esmeralda 567","1133223432", true, new ArrayList<OrdenDeCompra>());

			
			List<Cliente> clientes = List.of(cliente1,cliente2,cliente3,cliente4);
			
			clientes.stream().forEach(cliente->{
				repoCliente.save(cliente);
			});
			
			//--------Roles------
			
			//Rol rol = new Rol(tiposuario)
			
			Rol rol1 = new Rol(TipoUsuario.ADMINISTRADOR);
			Rol rol2 = new Rol(TipoUsuario.VENDEDOR);
			Rol rol3 = new Rol(TipoUsuario.CLIENTE);
			List<Rol> roles = List.of(rol1,rol2,rol3);
			
			roles.stream().forEach(rol->{
				repoRol.save(rol);
			});
			
			//---------Usuarios------------
			
			//Usuario usuario = new Usuario(nombreUsuario,mail,password,rol);

			Usuario usuario1 = new Usuario("luisH","luis@gmail.com","123",rol1); 
			Usuario usuario2 = new Usuario("lauraS","laura@gmail.com","1234",rol2);
			Usuario usuario3 = new Usuario("mariaT","maria@gmail.com","12345",rol3);

			
			List<Usuario> usuarios = List.of(usuario1,usuario2,usuario3);
			
			usuarios.stream().forEach(usuario->{
				repoUsuario.save(usuario);
			});
			
			//---------Proveedores-----------
			
			 	//Proveedor proveedor = new Proveedor(nombre,direccion,cuit,telefono,mail);
			
			Proveedor proveedor1 = new Proveedor("Notco", "Saenz Peña 123, CABA", "30-23453333-1", "0800-666-432","notco@gmail.com");
			
			Proveedor proveedor2 = new Proveedor("Cabrales", "Maipu 689, CABA", "30-45677534-3","0800-345-111", "cabrales@gmail.com");
		
			Proveedor proveedor3 = new Proveedor("Almadre", "Av. Hipolito Irigoyen 454, CABA", "30-44567433-1", "0800-123-456","almadre@gmail.com");
			
			Proveedor proveedor4 = new Proveedor("Dbvsas", "Montaña 456, GBA", "30-45678886-2", "0800-123-5667","dbvsas@gmail.com");
		
			List<Proveedor> proveedores = List.of(proveedor1,proveedor2,proveedor3,proveedor4);
			
			proveedores.stream().forEach(proveedor -> {
				repoProveedor.save(proveedor);
			});	
			
			
			MedioDePago promoMedioDePago = new MedioDePago(MetodoDePago.EFECTIVO,0.10);
			CuponDescuento cuponProveedor1 = new CuponDescuento (true,0.10,proveedor1);
			CuponDescuento cuponProveedor2 = new CuponDescuento(true,0.05,proveedor2);
			Membresia membresia = new Membresia(Arrays.asList(cliente1),0.10);
			List<Promocion> promocionesIniciales=List.of(promoMedioDePago,cuponProveedor1,cuponProveedor2,membresia);
			promocionesIniciales.stream().forEach(promocion -> {
				repoPromocion.save(promocion);
			});
			
			CarritoDeCompra carritoDeCompra1 = new CarritoDeCompra(Arrays.asList(promoMedioDePago,membresia),LocalDate.now(), MetodoDePago.EFECTIVO,cliente1);
			CarritoDeCompra carritoDeCompra2 = new CarritoDeCompra(Arrays.asList(promoMedioDePago,membresia),LocalDate.now(), MetodoDePago.CREDITO,cliente2);
			List<CarritoDeCompra> carritosIniciales=List.of(carritoDeCompra1,carritoDeCompra2);
			carritosIniciales.stream().forEach(carrito -> {
				repoCarrito.save(carrito);
			});
			
			//---------Productos-----------
			
			// Producto producto = new Producto(nombre,descripcion,cantStock, categoria, precio,proveedor,imagen);

		    Producto producto1 = new Producto("Frutillas x 300gr - KARINAT","Frutas enteras 100% natural, sin endulzantes ni conservantes supercongeladas.",30,CategoriaDeProducto.CONGELADOS,538.74,proveedor1,"https://d3ugyf2ht6aenh.cloudfront.net/stores/001/434/490/products/doypack-frutillas-300-g-1000-x-100011-ade165bf163852cdb716119420288078-480-0.jpg");
		    Producto producto2 = new Producto("Not Ice Cream Chocolate Chips x 330gr 100% Vegan - NOTCO","Not Ice Cream Chocolate & Chips es un helado vegano libre de glúten a base de vegetales.",60,CategoriaDeProducto.CONGELADOS,728.84,proveedor2,"https://d3ugyf2ht6aenh.cloudfront.net/stores/001/434/490/products/7798342150356_021-8f085004b0eb0d66a316090410077705-480-0.jpg");
		    Producto producto3 = new Producto("Not Burger Premium Flow Pack x 160gr (2u) SIN TACC - NOTCO","Not Burger de NotCo 100% Vegan ",15,CategoriaDeProducto.CONGELADOS,433.77,proveedor1,"https://d3ugyf2ht6aenh.cloudfront.net/stores/001/434/490/products/flowpack-notburger-notco-gurumarket1-1e2f80a546f009d9be16049407936977-1024-10241-6122489b15fcfd150916090376032707-480-0.jpg");
		    Producto producto4 = new Producto("Bites Frambuesas Bañadas en Chocolate x 120gr - KARINAT","Fruta 100% natural entera bañada en chocolate blanco y chocolate negro.",1,CategoriaDeProducto.CONGELADOS,498.69,proveedor2,"https://d3ugyf2ht6aenh.cloudfront.net/stores/001/434/490/products/kari04_1-0f2a5645214c85e09a16027105858758-640-01-752635b088923b8a8916090865403957-480-0.jpg");
		    Producto producto5 = new Producto("Pochoclos Orgánicos con Azúcar x 80 gr - BAMBOO","Pochoclos elaborados con maíz sin transgénicos",12,CategoriaDeProducto.ALMACEN,203.69,proveedor3,"https://d3ugyf2ht6aenh.cloudfront.net/stores/001/434/490/products/pochoclo-organico-bamboo1-343a12733e8914076816331182089295-480-0.jpg");
		    Producto producto6 = new Producto("Karnevil Party x 320gr (4u) - FELICES LAS VACAS","Medallon a Base de Arveja. Más rica en proteínas",4,CategoriaDeProducto.CONGELADOS,618.16,proveedor2,"https://d3ugyf2ht6aenh.cloudfront.net/stores/001/434/490/products/feli15_1-42eca92b76d6d4359216455843364750-1024-10241-80cb3852d2eaf8a9fd16460875922249-480-0.jpg");
		    Producto producto7 = new Producto("Dulce de Leche de Almendras x 250gr - FELICES LAS VACAS","DULCE DE ALMENDRAS",2,CategoriaDeProducto.ALMACEN,277.46,proveedor1,"https://d3ugyf2ht6aenh.cloudfront.net/stores/001/434/490/products/dulce-de-leche-de-almendras-x-250g-felices-las-vacas-the-fresh-market1-25dea144388e8aa31e16461808851910-480-0.jpg");
		    Producto producto8 = new Producto("Leche de Coco Original x 1 Lt S/TACC - DALE COCO","Leche de Coco - Dale Coco",5,CategoriaDeProducto.BEBIDAS,366.46,proveedor2,"https://d3ugyf2ht6aenh.cloudfront.net/stores/001/434/490/products/dale02_1-534a93dfce6af7795c16027096294438-1024-10241-89521a855fba99075016072756498951-1024-10241-b18c7ae4836deeb64116247160855692-480-0.jpg");
		    Producto producto9 = new Producto("Galletita Cacao y Miel Orgánica x 170gr - CACHAFAZ","Galletas Orgánicas,100% harina integral orgánica. Cacao y Miel",23,CategoriaDeProducto.SNACKS,193.99,proveedor4,"https://d3ugyf2ht6aenh.cloudfront.net/stores/001/434/490/products/cach26_1-526a6ad601f84a4ef716027092798476-1024-10241-6216677d92b57f351316087691068941-480-0.jpg");
		    Producto producto10 = new Producto("Pizzas de Masa Integral Fugazzeta x 290g - BEEPURE","",25,CategoriaDeProducto.ALMACEN,578.11,proveedor3,"https://d3ugyf2ht6aenh.cloudfront.net/stores/001/434/490/products/pizza-integral-de-fugazzeta-beepure-the-fresh-market1-dc7886c4d547e558e916347818442025-480-0.jpg");
		    Producto producto11 = new Producto("Vegan Nuggets de Quinoa y Garbanzos x 300 gr - GREEN KITCHEN","Nuggets de Quinoa y Garbanzos",40,CategoriaDeProducto.ALMACEN,489.90,proveedor4,"https://d3ugyf2ht6aenh.cloudfront.net/stores/001/434/490/products/640-01-51081fd4217456524716276645843569-480-0.jpg");
		    Producto producto12 = new Producto("Jugo Detox Remolacha, Naranja y Zanahoria x 1 Lts - CUARTO CRECIENTE","JUGO DETOX REMOLACHA",10,CategoriaDeProducto.BEBIDAS,205.50 ,proveedor3,"https://d3ugyf2ht6aenh.cloudfront.net/stores/001/434/490/products/jugo-detox-remolacha-zanahoria-naranja-cuarto-creciente-the-fresh-market1-556c9759dca7a452c116334777895905-480-0.jpg");
		    Producto producto13 = new Producto("Not Chicken Nuggets x 400gr - NOTCO","Not Chicken Nuggets rebozado a base de proteina de arveja, garbanzo y haba congelado",3,CategoriaDeProducto.CONGELADOS,773.56,proveedor3,"https://d3ugyf2ht6aenh.cloudfront.net/stores/001/434/490/products/not-chicken-nuggets-not-co1-c9772ae49631aa0b7f16427883381769-480-0.jpg");
		    Producto producto14 = new Producto("Galletitas de Almendras y Harina de Garbanzos x 180 gr Sin TACC - LOVVIT","Producto libre de gluten. No contiene lácteos, colorantes ni conservantes",2,CategoriaDeProducto.SNACKS,285.62,proveedor2,"https://d3ugyf2ht6aenh.cloudfront.net/stores/001/434/490/products/lovvit-galletitas-de-almendras-sin-gluten1-109ead879a22c1b63f16496002785112-480-0.jpg");
		    Producto producto15 = new Producto("Burganas Hamburguesa de Berenjena + Pimentón Ahumado 4U x 460gr - TIENDA VEGGIE","HAMBURGUESAS VEGETALES",6,CategoriaDeProducto.CONGELADOS,352.89,proveedor1,"https://d3ugyf2ht6aenh.cloudfront.net/stores/001/434/490/products/burgana-beren1-47c34274ab54b39d8e15927023034513-1024-10241-2ed119d3140cbbacc216291567543264-480-0.jpg");
		    Producto producto16 = new Producto("Empanadas Chinas de Carne y Acelga x 276 gr - FU BAO","Mas conocidas como Gyozas, elaboradas con carne bovina y acelga.",8,CategoriaDeProducto.ALMACEN,462.04,proveedor3,"https://d3ugyf2ht6aenh.cloudfront.net/stores/001/434/490/products/fuba05_11-e97d1faf88a5d73dcd16517037553048-480-0.jpg");
		 	
		    List<Producto> productos= List.of(producto1,producto2,producto3,producto4,producto5,producto6,producto7,producto8,producto9,producto10,producto11,producto12,producto13,producto14,producto15,producto16);    
			productos.stream().forEach(producto -> {
				repoProducto.save(producto);
			});	
			
			
			//---------Vendedores-----------
			
		  	//Vendedor vendedor = new Vendedor(nombre,apellido, proveedores, direccion,documento,productos);
    
			Vendedor vendedor1 = new Vendedor("Manuel","Baigorria",List.of(proveedor1),"Suipacha 342","23456422",List.of(producto1,producto2,producto3));
			Vendedor vendedor2 = new Vendedor("Laura","Sejas",List.of(proveedor2),"Esmeralda 123","285948372",List.of(producto10,producto8));
			Vendedor vendedor3 = new Vendedor("Carola","Copa",List.of(proveedor3),"Lima 234","2134355",List.of(producto16,producto13,producto4));
			Vendedor vendedor4 = new Vendedor("Pedro","Altamira",List.of(proveedor4),"Singapur 56","43565643",List.of(producto11,producto15,producto12));
		 
			List<Vendedor> vendedores= List.of(vendedor1,vendedor2,vendedor3,vendedor4);    
			vendedores.stream().forEach(vendedor -> {
				repoVendedor.save(vendedor);
	});	
			
			//---------Item de Compra-----------
	
	//ItemDeCompra itemDeCompra1 = new ItemDeCompra(producto,cantidadDeProducto);
	    
	    ItemDeCompra itemDeCompra1 = new ItemDeCompra(producto1,2);
	    ItemDeCompra itemDeCompra2 = new ItemDeCompra(producto3,1);
	    ItemDeCompra itemDeCompra3 = new ItemDeCompra(producto1,3);
	    ItemDeCompra itemDeCompra4 = new ItemDeCompra(producto5,2);
	    ItemDeCompra itemDeCompra5 = new ItemDeCompra(producto8,4);
	    ItemDeCompra itemDeCompra6 = new ItemDeCompra(producto6,1);
	    ItemDeCompra itemDeCompra7 = new ItemDeCompra(producto9,7);
	    
		List<ItemDeCompra> items= List.of(itemDeCompra1,itemDeCompra2,itemDeCompra3,itemDeCompra4,itemDeCompra5,itemDeCompra6,itemDeCompra7);    
		items.stream().forEach(itemDeCompra -> {
			repoItemDeCompra.save(itemDeCompra);
		});	
			
		
		
		  //OrdenDeCompra ordenDeCompra1 = new OdenDeCompra(fecha,items);
		
	    OrdenDeCompra ordenDeCompra1 = new OrdenDeCompra(LocalDate.of(2021, 02, 10),List.of(itemDeCompra1,itemDeCompra2));
	    OrdenDeCompra ordenDeCompra2 = new OrdenDeCompra(LocalDate.of(2022, 05, 20),List.of(itemDeCompra2,itemDeCompra3));
	    OrdenDeCompra ordenDeCompra3 = new OrdenDeCompra(LocalDate.of(2022, 01, 30),List.of(itemDeCompra6,itemDeCompra4));
	    OrdenDeCompra ordenDeCompra4 = new OrdenDeCompra(LocalDate.of(2021, 01, 01),List.of(itemDeCompra1,itemDeCompra7));
		
		List<OrdenDeCompra> ordenes= List.of(ordenDeCompra1,ordenDeCompra2,ordenDeCompra3,ordenDeCompra4);    
		ordenes.stream().forEach(ordenDeCompra -> {
			repoOrdenDeCompra.save(ordenDeCompra);
		});	

			

		}
		
		
		

	}

}
