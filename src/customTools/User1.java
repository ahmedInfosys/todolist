package customTools;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the USER1 database table.
 * 
 */
@Entity
@NamedQuery(name="User1.findAll", query="SELECT u FROM User1 u")
public class User1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id

	@SequenceGenerator(name="USER1_USERID_GENERATOR" , sequenceName="USER1_SEQ",  allocationSize = 1, initialValue = 1, schema="TESTDB")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER1_USERID_GENERATOR")
	@Column(name="USER_ID")
	private long userId;

	private BigDecimal birthyear;

	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	private String password;

	//bi-directional many-to-one association to Todolist
	@OneToMany(mappedBy="user1")
	private List<Todolist> todolists;

	public User1() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public BigDecimal getBirthyear() {
		return this.birthyear;
	}

	public void setBirthyear(BigDecimal birthyear) {
		this.birthyear = birthyear;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Todolist> getTodolists() {
		return this.todolists;
	}

	public void setTodolists(List<Todolist> todolists) {
		this.todolists = todolists;
	}

	public Todolist addTodolist(Todolist todolist) {
		getTodolists().add(todolist);
		todolist.setUser1(this);

		return todolist;
	}

	public Todolist removeTodolist(Todolist todolist) {
		getTodolists().remove(todolist);
		todolist.setUser1(null);

		return todolist;
	}

}