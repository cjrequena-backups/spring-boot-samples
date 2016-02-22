package com.sample.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the album database table.
 * 
 */
@Entity
@Table(name = "album")
@NamedQuery(name = "AlbumEntity.findAll", query = "SELECT a FROM AlbumEntity a")
public class AlbumEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int albumId;

	@Column(nullable = false, length = 160)
	private String title;

	// bi-directional many-to-one association to ArtistEntity
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ArtistId", nullable = false)
	private ArtistEntity artist;

	// bi-directional many-to-one association to TrackEntity
	@OneToMany(mappedBy = "album")
	private List<TrackEntity> tracks;

	public AlbumEntity() {
	}

	public int getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArtistEntity getArtist() {
		return this.artist;
	}

	public void setArtist(ArtistEntity artist) {
		this.artist = artist;
	}

	public List<TrackEntity> getTracks() {
		return this.tracks;
	}

	public void setTracks(List<TrackEntity> tracks) {
		this.tracks = tracks;
	}

	public TrackEntity addTrack(TrackEntity track) {
		getTracks().add(track);
		track.setAlbum(this);

		return track;
	}

	public TrackEntity removeTrack(TrackEntity track) {
		getTracks().remove(track);
		track.setAlbum(null);

		return track;
	}

}