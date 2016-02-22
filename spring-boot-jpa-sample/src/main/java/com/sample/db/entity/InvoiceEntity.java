package com.sample.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the invoice database table.
 * 
 */
@Entity
@Table(name="invoice")
@NamedQuery(name="InvoiceEntity.findAll", query="SELECT i FROM InvoiceEntity i")
public class InvoiceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int invoiceId;

	@Column(length=70)
	private String billingAddress;

	@Column(length=40)
	private String billingCity;

	@Column(length=40)
	private String billingCountry;

	@Column(length=10)
	private String billingPostalCode;

	@Column(length=40)
	private String billingState;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date invoiceDate;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal total;

	//bi-directional many-to-one association to CustomerEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CustomerId", nullable=false)
	private CustomerEntity customer;

	//bi-directional many-to-one association to InvoicelineEntity
	@OneToMany(mappedBy="invoice")
	private List<InvoicelineEntity> invoicelines;

	public InvoiceEntity() {
	}

	public int getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getBillingAddress() {
		return this.billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getBillingCity() {
		return this.billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingCountry() {
		return this.billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}

	public String getBillingPostalCode() {
		return this.billingPostalCode;
	}

	public void setBillingPostalCode(String billingPostalCode) {
		this.billingPostalCode = billingPostalCode;
	}

	public String getBillingState() {
		return this.billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public Date getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public CustomerEntity getCustomer() {
		return this.customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public List<InvoicelineEntity> getInvoicelines() {
		return this.invoicelines;
	}

	public void setInvoicelines(List<InvoicelineEntity> invoicelines) {
		this.invoicelines = invoicelines;
	}

	public InvoicelineEntity addInvoiceline(InvoicelineEntity invoiceline) {
		getInvoicelines().add(invoiceline);
		invoiceline.setInvoice(this);

		return invoiceline;
	}

	public InvoicelineEntity removeInvoiceline(InvoicelineEntity invoiceline) {
		getInvoicelines().remove(invoiceline);
		invoiceline.setInvoice(null);

		return invoiceline;
	}

}