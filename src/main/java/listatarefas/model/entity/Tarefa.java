package listatarefas.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import listatarefas.constantes.StatusTarefaEnum;

@Entity
@Table(name = "tb_tarefa")
public class Tarefa implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id_tarefa")
	private Long id;
 
	@Column(name = "nm_tarefa")
	private String  nome;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	private Usuario usuario;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFim;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name= "status_tarefa", length = 1)
	private StatusTarefaEnum statusTarefaEnum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public StatusTarefaEnum getStatusTarefaEnum() {
		return statusTarefaEnum;
	}

	public void setStatusTarefaEnum(StatusTarefaEnum statusTarefaEnum) {
		this.statusTarefaEnum = statusTarefaEnum;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result
				+ ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime
				* result
				+ ((statusTarefaEnum == null) ? 0 : statusTarefaEnum.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (statusTarefaEnum != other.statusTarefaEnum)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}


}
