package com.sample.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
@NamedQuery(name="EmployeeEntity.findAll", query="SELECT e FROM EmployeeEntity e")
public class EmployeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int employeeId;

	@Column(length=70)
	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	private Date birthDate;

	@Column(length=40)
	private String city;

	@Column(length=40)
	private String country;

	@Column(length=60)
	private String email;

	@Column(length=24)
	private String fax;

	@Column(nullable=false, length=20)
	private String firstName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date hireDate;

	@Column(nullable=false, length=20)
	private String lastName;

	@Column(length=24)
	private String phone;

	@Column(length=10)
	private String postalCode;

	@Column(length=40)
	private String state;

	@Column(length=30)
	private String title;

	//bi-directional many-to-one association to CustomerEntity
	@OneToMany(mappedBy="employee")
	private List<CustomerEntity> customers;

	//bi-directional many-to-one association to EmployeeEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ReportsTo")
	private EmployeeEntity employee;

	//bi-directional many-to-one association to EmployeeEntity
	@OneToMany(mappedBy="employee")
	private List<EmployeeEntity> employees;

	public EmployeeEntity() {
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<CustomerEntity> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<CustomerEntity> customers) {
		this.customers = customers;
	}

	public CustomerEntity addCustomer(CustomerEntity customer) {
		getCustomers().add(customer);
		customer.setEmployee(this);

		return customer;
	}

	public CustomerEntity removeCustomer(CustomerEntity customer) {
		getCustomers().remove(customer);
		customer.setEmployee(null);

		return customer;
	}

	public EmployeeEntity getEmployee() {
		return this.employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public List<EmployeeEntity> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}

	public EmployeeEntity addEmployee(EmployeeEntity employee) {
		getEmployees().add(employee);
		employee.setEmployee(this);

		return employee;
	}

	public EmployeeEntity removeEmployee(EmployeeEntity employee) {
		getEmployees().remove(employee);
		employee.setEmployee(null);

		return employee;
	}

}