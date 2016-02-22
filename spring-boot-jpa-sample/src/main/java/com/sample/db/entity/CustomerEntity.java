package com.sample.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@Table(name="customer")
@NamedQuery(name="CustomerEntity.findAll", query="SELECT c FROM CustomerEntity c")
public class CustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int customerId;

	@Column(length=70)
	private String address;

	@Column(length=40)
	private String city;

	@Column(length=80)
	private String company;

	@Column(length=40)
	private String country;

	@Column(nullable=false, length=60)
	private String email;

	@Column(length=24)
	private String fax;

	@Column(nullable=false, length=40)
	private String firstName;

	@Column(nullable=false, length=20)
	private String lastName;

	@Column(length=24)
	private String phone;

	@Column(length=10)
	private String postalCode;

	@Column(length=40)
	private String state;

	//bi-directional many-to-one association to EmployeeEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SupportRepId")
	private EmployeeEntity employee;

	//bi-directional many-to-one association to InvoiceEntity
	@OneToMany(mappedBy="customer")
	private List<InvoiceEntity> invoices;

	public CustomerEntity() {
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public EmployeeEntity getEmployee() {
		return this.employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public List<InvoiceEntity> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<InvoiceEntity> invoices) {
		this.invoices = invoices;
	}

	public InvoiceEntity addInvoice(InvoiceEntity invoice) {
		getInvoices().add(invoice);
		invoice.setCustomer(this);

		return invoice;
	}

	public InvoiceEntity removeInvoice(InvoiceEntity invoice) {
		getInvoices().remove(invoice);
		invoice.setCustomer(null);

		return invoice;
	}

}