package customTools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the STATUS database table.
 * 
 */
@Entity
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STATUS_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STATUS_ID_GENERATOR")
	private long id;

	private String status;

	//bi-directional many-to-one association to Todolist
	@ManyToOne
	@JoinColumn(name="ID", referencedColumnName="STATUSID",insertable=false, updatable=false)
	private Todolist todolist;

	public Status() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Todolist getTodolist() {
		return this.todolist;
	}

	public void setTodolist(Todolist todolist) {
		this.todolist = todolist;
	}

}