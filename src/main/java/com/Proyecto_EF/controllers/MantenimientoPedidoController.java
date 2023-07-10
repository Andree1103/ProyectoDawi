package com.Proyecto_EF.controllers;

import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Proyecto_EF.entity.Cliente;
import com.Proyecto_EF.entity.DetallePedido;
import com.Proyecto_EF.entity.ListaProductos;
import com.Proyecto_EF.entity.Pedido;
import com.Proyecto_EF.entity.Producto;
import com.Proyecto_EF.entity.Usuario;
import com.Proyecto_EF.services.ClienteService;
import com.Proyecto_EF.services.PedidoService;
import com.Proyecto_EF.services.ProductoService;
import com.Proyecto_EF.services.UsuarioService;
import com.Proyecto_EF.utils.Libreria;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/Pedidos")
public class MantenimientoPedidoController {
	@Autowired
	private UsuarioService servUsuario;
	@Autowired
	private ProductoService servProducto;
	@Autowired
	private ClienteService servCliente;
	@Autowired
	private PedidoService servPedido;
	@RequestMapping("/Lista")
	public String lista(Model model) {
		model.addAttribute("pedidos",servPedido.listarPedidos());
		return "mantenimiento-pedidos";
	}
	@RequestMapping("/Registrar")
	public String registrarPedido(Model model,Authentication auth) {
		String vLogin = auth.getName();
		Usuario u = servUsuario.loginUsuario(vLogin);
		model.addAttribute("USUARIO",u);
		model.addAttribute("productos",servProducto.listarProductos());
		return "registro-pedido";
	}
	@RequestMapping("/Editar")
	public String editarPedido(Model model,Authentication auth) {
		String vLogin = auth.getName();
		Usuario u = servUsuario.loginUsuario(vLogin);
		model.addAttribute("USUARIO",u);
		model.addAttribute("productos",servProducto.listarProductos());
		return "editar-pedido";
	}
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("id") int id, 
							@RequestParam("fechaActual")String fechaActual,
							@RequestParam("fechaEntrega")String fechaEntrega,
							@RequestParam("precioEnvio")double precioEnvio,
							@RequestParam("idCliente")int idCli,
							@RequestParam("estado") int estado,
							HttpSession session,Authentication auth) {
		String vLogin = auth.getName();
		Usuario u = servUsuario.loginUsuario(vLogin);
		int idPed = 0;
		List<Pedido> pedidosLista = servPedido.listarPedidos();
		for(Pedido p:pedidosLista) {
			if(p.getId()>idPed) {idPed = p.getId();}
		}
		try {
			Pedido bean = new Pedido();
			bean.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fechaActual));
			bean.setFechaEntrega(new SimpleDateFormat("yyyy-MM-dd").parse(fechaEntrega));
			bean.setPrecioEnvio(precioEnvio);
			Cliente cli = new Cliente();
			cli.setId(idCli);
			bean.setCliente(cli);
			bean.setEstado(estado);
			bean.setUsuario(u);
			List<ListaProductos> data = (List<ListaProductos>) session.getAttribute("carrito");
			List<DetallePedido> lista = new ArrayList<DetallePedido>();
			for(ListaProductos lp:data) {
				DetallePedido d = new DetallePedido();				
				Producto pro = new Producto();
				pro.setId(lp.getId());
				d.setCantidad(lp.getCantidad());
				d.setProducto(pro);
				d.setPrecio(lp.getPrecio());
				Pedido ben =  new Pedido();
				ben.setId(idPed);
				d.setPedido(ben);
				lista.add(d);
			}			
			bean.setListaDetallePedido(lista);
			servPedido.registrarPedido(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/Pedidos/Venta_Pedido";
	}
	@RequestMapping("/adicionar")
	@ResponseBody
	public List<ListaProductos> adicionar(@RequestParam("id") int id, 
							@RequestParam("nombre")String nom,
							@RequestParam("precio")double pre,
							@RequestParam("cantidad")int cantidad,
							HttpSession session) {
		List<ListaProductos> data =null;
		if(session.getAttribute("carrito")==null)
			data = new ArrayList<ListaProductos>();
		else
			data = (List<ListaProductos>) session.getAttribute("carrito");
		ListaProductos bean = new ListaProductos();
		bean.setId(id);
		bean.setNombre(nom);
		bean.setPrecio(pre);
		bean.setCantidad(cantidad);		
		data.add(bean);
		session.setAttribute("carrito",data);		
		return data;
	}
	@RequestMapping("/eliminar")
	@ResponseBody
	public List<ListaProductos> eliminar(@RequestParam("id") int id, HttpSession session){
		List<ListaProductos> data = (List<ListaProductos>) session.getAttribute("carrito");
		for (ListaProductos d:data) {
			if(d.getId()==id) {
				data.remove(d);
				break;
			}
		}
		session.setAttribute("carrito", data);
		return data;
	}
	@RequestMapping("/listarClientes")
	@ResponseBody
	public List<Cliente> listarClientes(@RequestParam("apellido") String ape){
		List<Cliente> data = servCliente.listarClientesPorApellido(ape + "%");
		return data;
	}
	@RequestMapping("/reporte")
	public void reporte(HttpServletResponse response) {
		try {
			List<Pedido> data = servPedido.listarPedidos();
			File file=ResourceUtils.getFile("classpath:reporte_pedidos.jrxml");
			JRBeanCollectionDataSource info=new JRBeanCollectionDataSource(data);
			JasperPrint print=Libreria.generarReporte(file, info);
			response.setContentType("application/pdf");
			OutputStream salida=response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(print, salida);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
