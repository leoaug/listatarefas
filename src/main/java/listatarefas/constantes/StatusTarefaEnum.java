package listatarefas.constantes;

public enum StatusTarefaEnum {
	ATIVA (1,"Ativo"),
	CANCELADA(2, "Cancelado");
	
	private Integer valor;
	private String label;
	
	private StatusTarefaEnum(Integer valor,String label) {
		this.valor = valor;
		this.label = label;
	}

	public Integer getValor() {
		return valor;
	}

	public String getLabel() {
		return label;
	}
	
}
