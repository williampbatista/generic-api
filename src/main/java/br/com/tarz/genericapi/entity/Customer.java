package br.com.tarz.genericapi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.tarz.genericapi.constants.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Customer implements Serializable {
	private static final long serialVersionUID = -4293378131082655393L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_GEN")
	@SequenceGenerator(name = "CUSTOMER_GEN", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)
	private Integer id;

	@Column(nullable = false)
	private Long code;
	
	@Column(nullable = false)
	private String document;
	
	@NotBlank @Column(name = "PERSON_TYPE", nullable = false, length = 1)
	private String personType;
	
	@NotBlank @Column(nullable = false, length = 50)
	private String name;
	
	@NotBlank @Column(name = "TRADE_NAME",nullable = false, length = 50)
	private String tradeName;

	@NotBlank @Column(nullable = false, length = 50)
	private String email;
	
//	@Column(name = "MERCHANT_CATEGORY_TYPE",nullable = false)
//	private Integer merchantCategoryCode;
	
	@Column(name = "STATUS")
	@Enumerated(EnumType.ORDINAL)
	private StatusEnum status;
	
	@CreationTimestamp @Temporal(TemporalType.TIMESTAMP) @Column(name = "CREATE_DATE", updatable=false, nullable = false)
	private Date createDate;

	@UpdateTimestamp @Temporal(TemporalType.TIMESTAMP) @Column(name = "UPDATE_DATE", insertable=false)
	private Date updateDate;

}
