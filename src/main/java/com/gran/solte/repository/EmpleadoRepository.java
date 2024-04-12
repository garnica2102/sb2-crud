package com.gran.solte.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gran.solte.model.Empleado;

public interface EmpleadoRepository extends MongoRepository<Empleado, String> {

}
