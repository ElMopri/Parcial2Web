package co.edu.ufps.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String first_n;
	private String last_n;
	private LocalDateTime birthdate;
	
	@ManyToOne
	@JoinColumn(name="dep_id")
	private Department dep_id;
	
	@ManyToOne
	@JoinColumn(name="pos_id")
	private Position pos_id;
	private LocalDateTime entry_date;
	
	@OneToMany(mappedBy = "employee_id", cascade= CascadeType.ALL)
	@JsonIgnore
	List<ProjectAssignment> projectAssignment = null;
	
	@ManyToMany
	@JoinTable(
			  name = "visit",
			  joinColumns = @JoinColumn(name = "employee_id"),
			  inverseJoinColumns = @JoinColumn(name = "department_id"))
   List<Department> departments;
	
		public void addDepartment(Department department) {
		this.departments.add(department);
	}
	
	public void removeDepartment(Department department) {
		this.departments.remove(department);
	}
}
