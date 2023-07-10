package com.Proyecto_EF.controllers;

import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Proyecto_EF.entity.Ciudad;
import com.Proyecto_EF.entity.Cliente;
import com.Proyecto_EF.entity.Departamento;
import com.Proyecto_EF.entity.Distrito;
import com.Proyecto_EF.services.CiudadService;
import com.Proyecto_EF.services.ClienteService;
import com.Proyecto_EF.services.DepartamentoService;
import com.Proyecto_EF.utils.Libreria;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



@Controller
@RequestMapping("/Clientes")
public class MantenimientoClienteController {
	@Autowired
	private DepartamentoService servDepartamento;
	@Autowired
	private CiudadService servCiudad;
	@Autowired
	private ClienteService servCliente;
	@RequestMapping("/Lista")
	public String lista(Model model) {
		
		model.addAttribute("departamentos", servDepartamento.listarDepartamentos());
		model.addAttribute("clientes",servCliente.listarClientes());
		return "mantenimiento-clientes";
	}
	@RequestMapping("/buscar")
	@ResponseBody
	public Cliente buscar(@RequestParam("id") int id) {
		Cliente bean=servCliente.buscar(id);
		return bean;
	}
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("id") int id,
						@RequestParam("nombre") String nombre,
						@RequestParam("apellido") String apellido,
						@RequestParam("correo") String correo,
						@RequestParam("phone") String celular,
						@RequestParam("fechaNacimiento") String fechaNac,
						@RequestParam("estado") int estado,
						@RequestParam("departamento") int idDep,
						@RequestParam("ciudad") int idCiu,
						@RequestParam("distrito") int idDis,
						@RequestParam("direccion") String direccion,
						RedirectAttributes redirect) {
		try {
			Cliente bean = new Cliente();
			bean.setId(id);
			bean.setNombre(nombre);
			bean.setApellido(apellido);
			bean.setCorreo(correo);
			bean.setCelular(celular);
			if(!(fechaNac =="")) bean.setFechaNac(new SimpleDateFormat("yyyy-MM-dd").parse(fechaNac));
			bean.setEstado(estado);
			if(idDep != 0) {
				Departamento dep = new Departamento();
				dep.setId(idDep);
				bean.setDepartamento(dep);				
			}else bean.setDepartamento(null);
			if(idCiu != 0) {
				Ciudad ciu = new Ciudad();
				ciu.setId(idCiu);
				bean.setCiudad(ciu);			
			}else bean.setCiudad(null);
			if(idDis != 0) {
				Distrito dis = new Distrito();				
				dis.setId(idDis);
				bean.setDistrito(dis);
			}else bean.setDistrito(null);			
			bean.setDireccion(direccion);
			servCliente.grabar(bean);
			if(id==0)
				redirect.addFlashAttribute("MENSAJE","Cliente registrado");
			else
				redirect.addFlashAttribute("MENSAJE","Cliente actualizado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la grabación");
			e.printStackTrace();
		}
		return "redirect:/Clientes/Lista";
	}

	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("id") int id,RedirectAttributes redirect) {
		try {
			servCliente.eliminar(id);
			redirect.addFlashAttribute("MENSAJE","Cliente eliminado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/Clientes/Lista";
	}
	@RequestMapping("/buscarPorDepartamento")
	@ResponseBody
	public List<Ciudad> buscarPorDepartamento(@RequestParam("id") int id) {
		List<Ciudad> data=servDepartamento.listarCiudadPorIdDepartamento(id);
		return data;
	}
	@RequestMapping("/buscarPorCiudad")
	@ResponseBody
	public List<Distrito> buscarPorCiudad(@RequestParam("id") int id) {
		List<Distrito> data=servCiudad.listarDistritoPorIdCiudad(id);
		return data;
	}
	@RequestMapping("/reporte")
	public void reporteMarca(HttpServletResponse response) {
		try {
			List<Cliente> data = servCliente.listarClientes();
			File file=ResourceUtils.getFile("classpath:reporte_clientes.jrxml");
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
