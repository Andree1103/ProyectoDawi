package com.Proyecto_EF.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_EF.dao.DetallePedidoRepository;
import com.Proyecto_EF.dao.PedidoRepository;
import com.Proyecto_EF.entity.DetallePedido;
import com.Proyecto_EF.entity.Pedido;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;
	@Autowired
	private DetallePedidoRepository repoDeta;
	
	public List<Pedido> listarPedidos(){
		return repo.findAll();
	}
	public void grabar(Pedido bean) {
		repo.save(bean);
	}
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}
	public Pedido buscar(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	public void registrarPedido(Pedido bean) {
		try {
			repo.save(bean);
			for(DetallePedido dp:bean.getListaDetallePedido()) {
				repoDeta.save(dp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
