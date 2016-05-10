package com.sample.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the invoiceline database table.
 * 
 */
@Entity
@Table(name="invoiceline")
@NamedQuery(name="InvoicelineEntity.findAll", query="SELECT i FROM InvoicelineEntity i")
public class InvoicelineEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int invoiceLineId;

	@Column(nullable=false)
	private int quantity;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal unitPrice;

	//bi-directional many-to-one association to InvoiceEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="InvoiceId", nullable=false)
	private InvoiceEntity invoice;

	//bi-directional many-to-one association to TrackEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TrackId", nullable=false)
	private TrackEntity track;

	public InvoicelineEntity() {
	}

	public int getInvoiceLineId() {
		return this.invoiceLineId;
	}

	public void setInvoiceLineId(int invoiceLineId) {
		this.invoiceLineId = invoiceLineId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public InvoiceEntity getInvoice() {
		return this.invoice;
	}

	public void setInvoice(InvoiceEntity invoice) {
		this.invoice = invoice;
	}

	public TrackEntity getTrack() {
		return this.track;
	}

	public void setTrack(TrackEntity track) {
		this.track = track;
	}

}