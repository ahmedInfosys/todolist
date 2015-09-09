package customTools;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TODOLIST database table.
 * 
 */
@Entity
@NamedQuery(name="Todolist.findAll", query="SELECT t FROM Todolist t")
public class Todolist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TODOLIST_ID_GENERATOR", sequenceName="TODOLIST_SEQ",allocationSize = 1, initialValue = 1, schema="TESTDB" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TODOLIST_ID_GENERATOR")
	private long id;

	@Column(name="DATE_COMPLETED")
	private String dateCompleted;

	private String description;

	@Column(name="DUET_DATE")
	private String duetDate;

	private String proirity;

	//bi-directional many-to-one association to Status
	@OneToMany(mappedBy="todolist")
	private List<Status> statuses;

	//bi-directional many-to-one association to User1
	@ManyToOne
	@JoinColumn(name="USERID",insertable=false, updatable=false)
	private User1 user1;

	public Todolist() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDateCompleted() {
		return this.dateCompleted;
	}

	public void setDateCompleted(String dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuetDate() {
		return this.duetDate;
	}

	public void setDuetDate(String duetDate) {
		this.duetDate = duetDate;
	}

	public String getProirity() {
		return this.proirity;
	}

	public void setProirity(String proirity) {
		this.proirity = proirity;
	}

	public List<Status> getStatuses() {
		return this.statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}

	public Status addStatus(Status status) {
		getStatuses().add(status);
		status.setTodolist(this);

		return status;
	}

	public Status removeStatus(Status status) {
		getStatuses().remove(status);
		status.setTodolist(null);

		return status;
	}

	public User1 getUser1() {
		return this.user1;
	}

	public void setUser1(User1 user1) {
		this.user1 = user1;
	}

}