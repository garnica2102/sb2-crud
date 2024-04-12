package com.gran.solte.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gran.solte.model.Empleado;
import com.gran.solte.services.EmpleadoService;
import com.gran.solte.util.ApiResponse;

/**

 * Esta clase define los métodos del controlador
 * @author: Edgar Garnica Camacho
 * @version: 0.1, 09/04/2024
 */
@RestController
@RequestMapping("/gs")
public class EmpleadoController {
	
	  @Autowired
	  private EmpleadoService service;
	  
	  @GetMapping("/bienvenido")
	  public String bienvenido() {
		  return "BackEnd(Edgar Garnica Camacho) Gran Solte V1 09/04/2024";
	  }
	  
	  // empleados/crear
	  //Servicio para guardar un registro
	  //Método: POST
	  @RequestMapping(value = "/empleados/crear", method = RequestMethod.POST)
	  public Empleado crearEmpleado(@RequestBody Empleado empleado) {
		  service.save(empleado);
		  return empleado;
	  }
  
	  // /gs/empleados/{id}
	  // Servicios para obtener un registro
	  // Métodp GET
	  @RequestMapping(value = "/empleados/{id}", method = RequestMethod.GET)
	  public Optional<Empleado> getEmpleadoById(@PathVariable(name = "id") String id) {
	    return Optional.ofNullable(service.findById(id));
	  }
	   
	  // /gs/empleados/{id}/modificar
	  // Servicio para modificar un registro
	  // Método: PUT
	  @RequestMapping(value = "/empleados/modificar/{id}", method = RequestMethod.PUT)
	   public ResponseEntity<ApiResponse> updateEmpleado(@PathVariable(name = "id") String id, 
			   @RequestBody Empleado empleado) {
	        return ResponseEntity.ok(service.update(id, empleado));
	   }
	  

  	  // /gs/empleados/{id}/borrarg
	  // Servicio de borrado de empleados
	  // Método: DELETE
	  @RequestMapping(value = "/empleados/borrar/{id}", method = RequestMethod.DELETE)
	  public void deleteEmpleado(@PathVariable(name = "id") String id) {
	    service.delete(id);
	  }
}
