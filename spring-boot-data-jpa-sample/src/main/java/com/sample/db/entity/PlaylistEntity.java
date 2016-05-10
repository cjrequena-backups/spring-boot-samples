package com.sample.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the playlist database table.
 * 
 */
@Entity
@Table(name="playlist")
@NamedQuery(name="PlaylistEntity.findAll", query="SELECT p FROM PlaylistEntity p")
public class PlaylistEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int playlistId;

	@Column(length=120)
	private String name;

	//bi-directional many-to-many association to TrackEntity
	@ManyToMany(mappedBy="playlists")
	private List<TrackEntity> tracks;

	public PlaylistEntity() {
	}

	public int getPlaylistId() {
		return this.playlistId;
	}

	public void setPlaylistId(int playlistId) {
		this.playlistId = playlistId;
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

}