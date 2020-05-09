package br.com.tarz.genericapi.constants;

public enum StatusEnum {

	FOI(1, "Foi"), NAO_FOI(2, "Não foi"),

	;

	private String descricao;
	private Integer id;

	StatusEnum(int id, String descricao) {
		this.descricao = descricao;
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getId() {
		return id;
	}

	public static StatusEnum getById(Integer value) {
		if (value != null) {
			for (StatusEnum status : StatusEnum.values()) {
				if (status.getId().equals(value)) {
					return status;
				}
			}
		}
		return null;
	}

}
