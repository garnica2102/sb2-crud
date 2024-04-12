package com.gran.solte.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.gran.solte.exepction.EmpleadoNotFoundException;
import com.gran.solte.model.Empleado;
import com.gran.solte.repository.EmpleadoRepository;
import com.gran.solte.services.EmpleadoService;
import com.gran.solte.util.ApiResponse;
import com.gran.solte.util.Message;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	EmpleadoRepository empleadoRepository;
	
	
	/**
	* FindById
	* Busqueda por id
	* @param String Id
	* @return id.
	*/
	@Override
	public Empleado findById(String id) {
		return empleadoRepository.findById(id).orElseThrow();
	}

	/**
	* Delete
	* Elimina por id el registro
	* @param String empId
	* @return empId.
	*/
	@Override
	public void delete(String id) {
		empleadoRepository.deleteById(id);
		
	}

	/**
	* Save
	* Guarda un registro
	* @param Objeto Empleado emp
	* @return emp.
	*/
	@Override
	public void save(Empleado emp) {
		empleadoRepository.save(emp);
		
	}

	/**
	* Update
	* Actualiza los datos del registro
	* @param Objeto Empleado emp
	* @return emp.
	*/
	@Override
	public ApiResponse update(String id, Empleado emp) {
		
		Empleado empleado = empleadoRepository.findById(id)
	                .orElseThrow(() -> new EmpleadoNotFoundException(Message.EMPLEADO_NOT_FOUND, 
	                		404, HttpStatus.NOT_FOUND, LocalDateTime.now()));
		empleado.setName(emp.getName());
		empleado.setPuesto(emp.getPuesto());
		empleado.setSalario(emp.getSalario());
		empleadoRepository.save(empleado);
	        return new ApiResponse(Message.EMPLEADO_UPDATE_SUCCESSFULLY, 201, HttpStatus.OK, 
	        		LocalDateTime.now());
	}
	
	/**
	* FindEmpleadoByName
	* Busca solo el nombre del empleado
	* @param Lista Empleado
	* @return empleado.
	*/
	
	//@Override
	//public List<Empleado> findEmpleadoByName(String nombreCompleto) {
    //    List<Empleado> empleado = empleadoRepository.findEmpleadosByName(nombreCompleto);	
	//	return empleado;
	//}

}
