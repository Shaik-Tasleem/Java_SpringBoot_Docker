package Apimovie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tv_shows")
public class TvShowModel {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;
	    private String releaseYear;
	    private String genres;
	    private String synopsis;
	    private String externalApiId;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getReleaseYear() {
			return releaseYear;
		}
		public void setReleaseYear(String releaseYear) {
			this.releaseYear = releaseYear;
		}
		public String getGenres() {
			return genres;
		}
		public void setGenres(String genres) {
			this.genres = genres;
		}
		public String getSynopsis() {
			return synopsis;
		}
		public void setSynopsis(String synopsis) {
			this.synopsis = synopsis;
		}
		public String getExternalApiId() {
			return externalApiId;
		}
		public void setExternalApiId(String externalApiId) {
			this.externalApiId = externalApiId;
		}
	    
}
