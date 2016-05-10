package com.sample.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the track database table.
 * 
 */
@Entity
@Table(name="track")
@NamedQuery(name="TrackEntity.findAll", query="SELECT t FROM TrackEntity t")
public class TrackEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int trackId;

	private int bytes;

	@Column(length=220)
	private String composer;

	@Column(nullable=false)
	private int milliseconds;

	@Column(nullable=false, length=200)
	private String name;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal unitPrice;

	//bi-directional many-to-one association to InvoicelineEntity
	@OneToMany(mappedBy="track")
	private List<InvoicelineEntity> invoicelines;

	//bi-directional many-to-many association to PlaylistEntity
	@ManyToMany
	@JoinTable(
		name="playlisttrack"
		, joinColumns={
			@JoinColumn(name="TrackId", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="PlaylistId", nullable=false)
			}
		)
	private List<PlaylistEntity> playlists;

	//bi-directional many-to-one association to AlbumEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AlbumId")
	private AlbumEntity album;

	//bi-directional many-to-one association to GenreEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GenreId")
	private GenreEntity genre;

	//bi-directional many-to-one association to MediatypeEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MediaTypeId", nullable=false)
	private MediatypeEntity mediatype;

	public TrackEntity() {
	}

	public int getTrackId() {
		return this.trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public int getBytes() {
		return this.bytes;
	}

	public void setBytes(int bytes) {
		this.bytes = bytes;
	}

	public String getComposer() {
		return this.composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public int getMilliseconds() {
		return this.milliseconds;
	}

	public void setMilliseconds(int milliseconds) {
		this.milliseconds = milliseconds;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public List<InvoicelineEntity> getInvoicelines() {
		return this.invoicelines;
	}

	public void setInvoicelines(List<InvoicelineEntity> invoicelines) {
		this.invoicelines = invoicelines;
	}

	public InvoicelineEntity addInvoiceline(InvoicelineEntity invoiceline) {
		getInvoicelines().add(invoiceline);
		invoiceline.setTrack(this);

		return invoiceline;
	}

	public InvoicelineEntity removeInvoiceline(InvoicelineEntity invoiceline) {
		getInvoicelines().remove(invoiceline);
		invoiceline.setTrack(null);

		return invoiceline;
	}

	public List<PlaylistEntity> getPlaylists() {
		return this.playlists;
	}

	public void setPlaylists(List<PlaylistEntity> playlists) {
		this.playlists = playlists;
	}

	public AlbumEntity getAlbum() {
		return this.album;
	}

	public void setAlbum(AlbumEntity album) {
		this.album = album;
	}

	public GenreEntity getGenre() {
		return this.genre;
	}

	public void setGenre(GenreEntity genre) {
		this.genre = genre;
	}

	public MediatypeEntity getMediatype() {
		return this.mediatype;
	}

	public void setMediatype(MediatypeEntity mediatype) {
		this.mediatype = mediatype;
	}

}