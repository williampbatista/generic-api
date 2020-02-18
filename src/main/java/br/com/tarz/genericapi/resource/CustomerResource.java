package br.com.tarz.genericapi.resource;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CustomerResource implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3619519530386245829L;
	private Integer id;
	private Integer code;
	private String document;
	private String personType;
	private String name;
	private String tradeName;
	private String email;

}
