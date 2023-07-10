package com.Proyecto_EF.controllers;

import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Proyecto_EF.entity.Ciudad;
import com.Proyecto_EF.entity.Departamento;
import com.Proyecto_EF.entity.Distrito;
import com.Proyecto_EF.entity.Producto;
import com.Proyecto_EF.entity.Rol;
import com.Proyecto_EF.entity.TipoUsuario;
import com.Proyecto_EF.entity.Usuario;
import com.Proyecto_EF.services.CiudadService;
import com.Proyecto_EF.services.DepartamentoService;
import com.Proyecto_EF.services.DistritoService;
import com.Proyecto_EF.services.RolService;
import com.Proyecto_EF.services.TipoUsuarioService;
import com.Proyecto_EF.services.UsuarioService;
import com.Proyecto_EF.utils.Libreria;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/Usuarios")
public class MantenimientoUsuarioController {
	@Autowired
	private DepartamentoService servDepartamento;
	@Autowired
	private CiudadService servCiudad;
	@Autowired
	private TipoUsuarioService servTipoUsuario;
	@Autowired
	private RolService servRol;
	@Autowired
	private UsuarioService servUsuario;
	@RequestMapping("/Lista")
	public String lista(Model model) {
		model.addAttribute("departamentos", servDepartamento.listarDepartamentos());
		model.addAttribute("tiposUsuarios", servTipoUsuario.listarTipoUsuario());
		model.addAttribute("roles", servRol.listarRoles());
		model.addAttribute("usuarios", servUsuario.listarUsuarios());
		return "mantenimiento-usuarios";
	}
	@RequestMapping("/buscar")
	@ResponseBody
	public Usuario buscar(@RequestParam("id") int id) {
		Usuario bean=servUsuario.buscar(id);
		return bean;
	}
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("id") int id,
						@RequestParam("nombre") String nombre,
						@RequestParam("apellido") String apellido,
						@RequestParam("dni") String dni,
						@RequestParam("correo") String correo,
						@RequestParam("phone") String celular,
						@RequestParam("fechaNacimiento") String fechaNac,
						@RequestParam("estado") int estado,
						@RequestParam("tipoUsuario") int idTip,
						@RequestParam("rol") int idRol,
						@RequestParam("departamento") int idDep,
						@RequestParam("ciudad") int idCiu,
						@RequestParam("distrito") int idDis,
						@RequestParam("direccion") String direccion,
						RedirectAttributes redirect) {
		try {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			Usuario bean = new Usuario();
			bean.setId(id);
			bean.setNombre(nombre);
			bean.setApellido(apellido);
			bean.setDni(dni);
			bean.setCorreo(correo);
			bean.setContrasenia(encoder.encode(dni));
			bean.setCelular(celular);
			if(!(fechaNac =="")) bean.setFechaNac(new SimpleDateFormat("yyyy-MM-dd").parse(fechaNac));
			bean.setEstado(estado);
			TipoUsuario tip = new TipoUsuario();
			tip.setId(idTip);
			bean.setTipoUsuario(tip);
			Rol rol = new Rol();
			rol.setId(idRol);
			bean.setRol(rol);
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
			servUsuario.grabar(bean);
			if(id==0)
				redirect.addFlashAttribute("MENSAJE","Usuario registrado");
			else
				redirect.addFlashAttribute("MENSAJE","Usuario actualizado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la grabación");
			e.printStackTrace();
		}
		return "redirect:/Usuarios/Lista";
	}

	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("id") int id,RedirectAttributes redirect) {
		try {
			servUsuario.eliminar(id);
			redirect.addFlashAttribute("MENSAJE","Usuario eliminado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/Usuarios/Lista";
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
	public void reporte(HttpServletResponse response) {
		try {
			List<Usuario> data = servUsuario.listarUsuarios();
			File file=ResourceUtils.getFile("classpath:reporte_usuarios.jrxml");
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
