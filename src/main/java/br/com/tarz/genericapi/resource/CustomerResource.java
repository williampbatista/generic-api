package br.com.tarz.genericapi.resource;

import java.io.Serializable;

import br.com.tarz.genericapi.constants.StatusEnum;
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
	private Long code;
	private String document;
	private String personType;
	private String name;
	private String tradeName;
	private String email;
	private StatusEnum status;
	private int statusId;
	private String statusDesc;

}
