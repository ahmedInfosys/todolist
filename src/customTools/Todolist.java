package customTools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TODOLIST database table.
 * 
 */
@Entity
@NamedQuery(name="Todolist.findAll", query="SELECT t FROM Todolist t")
public class Todolist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TODOLIST_SEQ" , sequenceName="TODOLIST_SEQ",allocationSize = 1, initialValue = 1, schema="TESTDB" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TODOLIST_SEQ")
	private long id;

	@Column(name="DATE_COMPLETED")
	private String dateCompleted;

	private String description;

	@Column(name="DUET_DATE")
	private String duetDate;

	private String proirity;

	private String status;

	//bi-directional many-to-one association to User1
	@ManyToOne
	@JoinColumn(name="USER_ID")
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User1 getUser1() {
		return this.user1;
	}

	public void setUser1(User1 user1) {
		this.user1 = user1;
	}

}