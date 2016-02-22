package com.sample.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the genre database table.
 * 
 */
@Entity
@Table(name="genre")
@NamedQuery(name="GenreEntity.findAll", query="SELECT g FROM GenreEntity g")
public class GenreEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int genreId;

	@Column(length=120)
	private String name;

	//bi-directional many-to-one association to TrackEntity
	@OneToMany(mappedBy="genre")
	private List<TrackEntity> tracks;

	public GenreEntity() {
	}

	public int getGenreId() {
		return this.genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TrackEntity> getTracks() {
		return this.tracks;
	}

	public void setTracks(List<TrackEntity> tracks) {
		this.tracks = tracks;
	}

	public TrackEntity addTrack(TrackEntity track) {
		getTracks().add(track);
		track.setGenre(this);

		return track;
	}

	public TrackEntity removeTrack(TrackEntity track) {
		getTracks().remove(track);
		track.setGenre(null);

		return track;
	}

}