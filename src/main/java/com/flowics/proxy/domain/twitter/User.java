package com.flowics.proxy.domain.twitter;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
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
	
	private UrlUserEntities entities;
	
	private String utc_offset;
	
	private String time_zone;
	
	private boolean geo_enabled;
	
	private String lang;
	
	private boolean contributors_enabled;
	
	private boolean is_translator;
	
	private boolean is_translation_enabled;
	
	private String profile_background_color;
	
	private String profile_background_image_url;
	
	private String profile_background_image_url_https;
	
	private String profile_image_url;
	
	private boolean profile_background_tile;

	private String profile_link_color;
	
	private String profile_sidebar_border_color;
	
	private String profile_sidebar_fill_color;
	
	private String profile_text_color;
	
	private boolean profile_use_background_image;
	
	private boolean has_extended_profile;

	private boolean can_media_tag;
	
	private String followed_by;
	
	private String following;
	
	private String follow_request_sent;
	
	private String notifications;
	
	private String translator_type;
	
	private String profile_location;
	
	private Status status;
	
	
	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getProfile_location() {
		return profile_location;
	}

	public void setProfile_location(String profile_location) {
		this.profile_location = profile_location;
	}

	public boolean isContributors_enabled() {
		return contributors_enabled;
	}

	public void setContributors_enabled(boolean contributors_enabled) {
		this.contributors_enabled = contributors_enabled;
	}

	public boolean isIs_translator() {
		return is_translator;
	}

	public void setIs_translator(boolean is_translator) {
		this.is_translator = is_translator;
	}

	public boolean isIs_translation_enabled() {
		return is_translation_enabled;
	}

	public void setIs_translation_enabled(boolean is_translation_enabled) {
		this.is_translation_enabled = is_translation_enabled;
	}

	public String getProfile_background_color() {
		return profile_background_color;
	}

	public void setProfile_background_color(String profile_background_color) {
		this.profile_background_color = profile_background_color;
	}

	public String getProfile_background_image_url() {
		return profile_background_image_url;
	}

	public void setProfile_background_image_url(String profile_background_image_url) {
		this.profile_background_image_url = profile_background_image_url;
	}

	public String getProfile_background_image_url_https() {
		return profile_background_image_url_https;
	}

	public void setProfile_background_image_url_https(String profile_background_image_url_https) {
		this.profile_background_image_url_https = profile_background_image_url_https;
	}

	public String getProfile_image_url() {
		return profile_image_url;
	}

	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}

	public boolean isProfile_background_tile() {
		return profile_background_tile;
	}

	public void setProfile_background_tile(boolean profile_background_tile) {
		this.profile_background_tile = profile_background_tile;
	}

	public String getProfile_link_color() {
		return profile_link_color;
	}

	public void setProfile_link_color(String profile_link_color) {
		this.profile_link_color = profile_link_color;
	}

	public String getProfile_sidebar_border_color() {
		return profile_sidebar_border_color;
	}

	public void setProfile_sidebar_border_color(String profile_sidebar_border_color) {
		this.profile_sidebar_border_color = profile_sidebar_border_color;
	}

	public String getProfile_sidebar_fill_color() {
		return profile_sidebar_fill_color;
	}

	public void setProfile_sidebar_fill_color(String profile_sidebar_fill_color) {
		this.profile_sidebar_fill_color = profile_sidebar_fill_color;
	}

	public String getProfile_text_color() {
		return profile_text_color;
	}

	public void setProfile_text_color(String profile_text_color) {
		this.profile_text_color = profile_text_color;
	}

	public boolean isProfile_use_background_image() {
		return profile_use_background_image;
	}

	public void setProfile_use_background_image(boolean profile_use_background_image) {
		this.profile_use_background_image = profile_use_background_image;
	}

	public boolean isHas_extended_profile() {
		return has_extended_profile;
	}

	public void setHas_extended_profile(boolean has_extended_profile) {
		this.has_extended_profile = has_extended_profile;
	}

	public boolean isCan_media_tag() {
		return can_media_tag;
	}

	public void setCan_media_tag(boolean can_media_tag) {
		this.can_media_tag = can_media_tag;
	}

	public String getFollowed_by() {
		return followed_by;
	}

	public void setFollowed_by(String followed_by) {
		this.followed_by = followed_by;
	}

	public String getFollowing() {
		return following;
	}

	public void setFollowing(String following) {
		this.following = following;
	}

	public String getFollow_request_sent() {
		return follow_request_sent;
	}

	public void setFollow_request_sent(String follow_request_sent) {
		this.follow_request_sent = follow_request_sent;
	}

	public String getNotifications() {
		return notifications;
	}

	public void setNotifications(String notifications) {
		this.notifications = notifications;
	}

	public String getTranslator_type() {
		return translator_type;
	}

	public void setTranslator_type(String translator_type) {
		this.translator_type = translator_type;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public boolean isGeo_enabled() {
		return geo_enabled;
	}

	public void setGeo_enabled(boolean geo_enabled) {
		this.geo_enabled = geo_enabled;
	}

	public String getTime_zone() {
		return time_zone;
	}

	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}

	public String getUtc_offset() {
		return utc_offset;
	}

	public void setUtc_offset(String utc_offset) {
		this.utc_offset = utc_offset;
	}

	public UrlUserEntities getEntities() {
		return entities;
	}

	public void setEntities(UrlUserEntities entities) {
		this.entities = entities;
	}

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
