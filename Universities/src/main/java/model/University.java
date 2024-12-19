package model;

public class University {
    private int id;
    private String name;
    private String country;
    private String website;

    public University(int id, String name, String country, String website) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.website = website;
    }

    public University(String name, String country, String website) {
		super();
		this.name = name;
		this.country = country;
		this.website = website;
	}

	public University() {
		super();
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}