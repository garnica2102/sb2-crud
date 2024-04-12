package com.gran.solte.services;

import com.gran.solte.model.Empleado;
import com.gran.solte.util.ApiResponse;

public interface EmpleadoService {
	
	Empleado findById(String id);
    void delete(String id);
    void save(Empleado emp);
    ApiResponse update(String id, Empleado emp);

}
