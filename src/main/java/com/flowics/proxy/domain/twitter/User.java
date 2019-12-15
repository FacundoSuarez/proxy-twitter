package com.flowics.proxy.domain.twitter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	private Long id;

	private String id_str;
	
	private String name;
	
	private String screen_name;
	
	private String location;
	
	private Object derived; //FIXME
	
	private String url;
	
	private String description;
	
	@JsonProperty("protected")
	private Boolean is_protected; //FIXME como le vas a poner protected a un aributo man dale
	
	private Boolean verified;
	
	private int followers_count;
	
	private int friends_count;
	
	private int listed_count;
	
	private int favourites_count;
	
	private int statuses_count;
	
	private String created_at;
	
	private String profile_banner_url;
	
	private String profile_image_url_https;
	
	private Boolean default_profile;
	
	private Boolean default_profile_image;
	
	private String[] withheld_in_countries;
	
	private String withheld_scope;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getId_str() {
		return id_str;
	}

	public void setId_str(String id_str) {
		this.id_str = id_str;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreen_name() {
		return screen_name;
	}

	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Object getDerived() {
		return derived;
	}

	public void setDerived(Object derived) {
		this.derived = derived;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIs_protected() {
		return is_protected;
	}

	public void setIs_protected(Boolean is_protected) {
		this.is_protected = is_protected;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public int getFollowers_count() {
		return followers_count;
	}

	public void setFollowers_count(int followers_count) {
		this.followers_count = followers_count;
	}

	public int getFriends_count() {
		return friends_count;
	}

	public void setFriends_count(int friends_count) {
		this.friends_count = friends_count;
	}

	public int getListed_count() {
		return listed_count;
	}

	public void setListed_count(int listed_count) {
		this.listed_count = listed_count;
	}

	public int getFavourites_count() {
		return favourites_count;
	}

	public void setFavourites_count(int favourites_count) {
		this.favourites_count = favourites_count;
	}

	public int getStatuses_count() {
		return statuses_count;
	}

	public void setStatuses_count(int statuses_count) {
		this.statuses_count = statuses_count;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getProfile_banner_url() {
		return profile_banner_url;
	}

	public void setProfile_banner_url(String profile_banner_url) {
		this.profile_banner_url = profile_banner_url;
	}

	public String getProfile_image_url_https() {
		return profile_image_url_https;
	}

	public void setProfile_image_url_https(String profile_image_url_https) {
		this.profile_image_url_https = profile_image_url_https;
	}

	public Boolean getDefault_profile() {
		return default_profile;
	}

	public void setDefault_profile(Boolean default_profile) {
		this.default_profile = default_profile;
	}

	public Boolean getDefault_profile_image() {
		return default_profile_image;
	}

	public void setDefault_profile_image(Boolean default_profile_image) {
		this.default_profile_image = default_profile_image;
	}

	public String[] getWithheld_in_countries() {
		return withheld_in_countries;
	}

	public void setWithheld_in_countries(String[] withheld_in_countries) {
		this.withheld_in_countries = withheld_in_countries;
	}

	public String getWithheld_scope() {
		return withheld_scope;
	}

	public void setWithheld_scope(String withheld_scope) {
		this.withheld_scope = withheld_scope;
	}
	
	

}
