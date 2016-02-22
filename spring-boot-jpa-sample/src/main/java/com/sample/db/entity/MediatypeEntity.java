package com.sample.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mediatype database table.
 * 
 */
@Entity
@Table(name="mediatype")
@NamedQuery(name="MediatypeEntity.findAll", query="SELECT m FROM MediatypeEntity m")
public class MediatypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int mediaTypeId;

	@Column(length=120)
	private String name;

	//bi-directional many-to-one association to TrackEntity
	@OneToMany(mappedBy="mediatype")
	private List<TrackEntity> tracks;

	public MediatypeEntity() {
	}

	public int getMediaTypeId() {
		return this.mediaTypeId;
	}

	public void setMediaTypeId(int mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
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
		track.setMediatype(this);

		return track;
	}

	public TrackEntity removeTrack(TrackEntity track) {
		getTracks().remove(track);
		track.setMediatype(null);

		return track;
	}

}