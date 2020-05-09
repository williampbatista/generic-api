package br.com.tarz.genericapi.filter;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "customerFilter")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerFilter {
	
	private Integer id;
	
	private Integer document;
	
	private String name;
	
	private String tradeName;
	
	private List<Integer> ids;
	
	private Date createDateBegin;
	
	private Date createDateEnd;
	

}
