package br.com.tarz.genericapi.resource;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductResource {

	private Long id;
	private String description;
	private Date validateDateBegin;
	private Date validateDateEnd;
	private Date createDate;
	private Date updateDate;

}
