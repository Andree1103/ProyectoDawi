package com.Proyecto_EF.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto_EF.entity.Postulante;

public interface PostulanteRepository extends JpaRepository<Postulante, Integer> {
}
