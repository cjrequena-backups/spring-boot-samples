package com.sample.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the artist database table.
 * 
 */
@Entity
@Table(name="artist")
@NamedQuery(name="ArtistEntity.findAll", query="SELECT a FROM ArtistEntity a")
public class ArtistEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int artistId;

	@Column(length=120)
	private String name;

	//bi-directional many-to-one association to AlbumEntity
	@OneToMany(mappedBy="artist")
	private List<AlbumEntity> albums;

	public ArtistEntity() {
	}

	public int getArtistId() {
		return this.artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AlbumEntity> getAlbums() {
		return this.albums;
	}

	public void setAlbums(List<AlbumEntity> albums) {
		this.albums = albums;
	}

	public AlbumEntity addAlbum(AlbumEntity album) {
		getAlbums().add(album);
		album.setArtist(this);

		return album;
	}

	public AlbumEntity removeAlbum(AlbumEntity album) {
		getAlbums().remove(album);
		album.setArtist(null);

		return album;
	}

}