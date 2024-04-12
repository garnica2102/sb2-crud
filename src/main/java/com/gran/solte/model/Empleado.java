package com.gran.solte.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "empleado")
public class Empleado {
	
	@Id
    private String id;
    private String name;
    private String puesto;
    private Double salario;
}
