package com.Proyecto_EF.controllers;

import java.io.File;
import java.io.OutputStream;
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

import com.Proyecto_EF.entity.Categoria;
import com.Proyecto_EF.entity.Marca;
import com.Proyecto_EF.entity.Producto;
import com.Proyecto_EF.services.CategoriaService;
import com.Proyecto_EF.services.MarcaService;
import com.Proyecto_EF.utils.Libreria;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/CategoriasMarcas")
public class MantenimientoMarcaCategoriaController {
	@Autowired
	private CategoriaService servCategoria;
	@Autowired
	private MarcaService servMarca;
	
	@RequestMapping("/Lista")
	public String lista(Model model) {
		model.addAttribute("categorias", servCategoria.listarCategorias());
		model.addAttribute("marcas", servMarca.listarMarcas());
		return "mantenimiento-categorias-marcas";
	}
	@RequestMapping("/buscarCategoria")
	@ResponseBody
	public Categoria buscaCategoria(@RequestParam("id") int id) {
		Categoria bean=servCategoria.buscar(id);
		return bean;
	}
	@RequestMapping("/buscarMarca")
	@ResponseBody
	public Marca buscarMarca(@RequestParam("id") int id) {
		Marca bean=servMarca.buscar(id);
		return bean;
	}
	@RequestMapping("/grabarCategoria")
	public String grabarCategoria(@RequestParam("id") int id,
									@RequestParam("nombre") String nombre,
									RedirectAttributes redirect) {
		try {
			Categoria bean = new Categoria();
			bean.setId(id);
			bean.setNombre(nombre);
			servCategoria.grabar(bean);
			if(id==0)
				redirect.addFlashAttribute("MENSAJE","Categoria registrada");
			else
				redirect.addFlashAttribute("MENSAJE","Categoria actualizada");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la grabación");
			e.printStackTrace();
		}
		return "redirect:/CategoriasMarcas/Lista";
	}
	@RequestMapping("/grabarMarca")
	public String grabarMarca(@RequestParam("id") int id,
								@RequestParam("nombre") String nombre,
								RedirectAttributes redirect) {
		try {
			Marca bean = new Marca();
			bean.setId(id);
			bean.setNombre(nombre);
			servMarca.grabar(bean);
			if(id==0)
				redirect.addFlashAttribute("MENSAJE","Marca registrada");
			else
				redirect.addFlashAttribute("MENSAJE","Marca actualizada");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la grabación");
			e.printStackTrace();
		}
		return "redirect:/CategoriasMarcas/Lista";
	}
	@RequestMapping("/eliminarCategoria")
	public String eliminarCategoria(@RequestParam("id") int id,RedirectAttributes redirect) {
		try {
			servCategoria.eliminar(id);
			redirect.addFlashAttribute("MENSAJE","Categoria eliminada");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/CategoriasMarcas/Lista";
	}
	@RequestMapping("/eliminarMarca")
	public String eliminarMarca(@RequestParam("id") int id,RedirectAttributes redirect) {
		try {
			servMarca.eliminar(id);
			redirect.addFlashAttribute("MENSAJE","Marca eliminada");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/CategoriasMarcas/Lista";
	}
	@RequestMapping("/reporteCategorias")
	public void reporteCategoria(HttpServletResponse response) {
		try {
			List<Categoria> data = servCategoria.listarCategorias();
			File file=ResourceUtils.getFile("classpath:reporte_categorias.jrxml");
			JRBeanCollectionDataSource info=new JRBeanCollectionDataSource(data);
			JasperPrint print=Libreria.generarReporte(file, info);
			response.setContentType("application/pdf");
			OutputStream salida=response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(print, salida);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/reporteMarcas")
	public void reporteMarca(HttpServletResponse response) {
		try {
			List<Marca> data = servMarca.listarMarcas();
			File file=ResourceUtils.getFile("classpath:reporte_marcas.jrxml");
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
