package com.flowics.proxy.domain.twitter;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {
	
	private String created_at;
	
	private long id;
	
	private String id_str;
	
	private String text;
	
	private String source;
	
	private Boolean truncated;
	
	private Long in_reply_to_status_id;
	
	private String in_reply_to_status_id_str;
	
	private Long in_reply_to_user_id;
	
	private String in_reply_to_user_id_str;
	
	private String in_reply_to_screen_name;
	
	private User user;
	
	private Coordinates coordinates;
	
	private Places places;
	
	private Long quoted_status_id;
	
	private String quoted_status_id_str;
	
	private Boolean is_quote_status;
	
	private Status quoted_status;
	
	private Status retweeted_status;
	
	private int quote_count;
	
	private int reply_count;
	
	private int retweet_count;
	
	private int favorite_count;
	
	private Entities entities;
	
	private Entities extended_entities;
	
	private Boolean favorited;
	
	private Boolean retweeted;
	
	private Boolean possibly_sensitive;
	
	private String filter_level;
	
	private String lang;
	
//	private MatchigRules matching_rules;
	
//	private CurrentUserRetweet current_user_retweet;
	
//	private Scopes scopes;
	
	private Boolean withheld_copyright;
	
	private String[] withheld_in_countries;
	
	private String withheld_scope;

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getId_str() {
		return id_str;
	}

	public void setId_str(String id_str) {
		this.id_str = id_str;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Boolean getTruncated() {
		return truncated;
	}

	public void setTruncated(Boolean truncated) {
		this.truncated = truncated;
	}

	public Long getIn_reply_to_status_id() {
		return in_reply_to_status_id;
	}

	public void setIn_reply_to_status_id(Long in_reply_to_status_id) {
		this.in_reply_to_status_id = in_reply_to_status_id;
	}

	public String getIn_reply_to_status_id_str() {
		return in_reply_to_status_id_str;
	}

	public void setIn_reply_to_status_id_str(String in_reply_to_status_id_str) {
		this.in_reply_to_status_id_str = in_reply_to_status_id_str;
	}

	public Long getIn_reply_to_user_id() {
		return in_reply_to_user_id;
	}

	public void setIn_reply_to_user_id(Long in_reply_to_user_id) {
		this.in_reply_to_user_id = in_reply_to_user_id;
	}

	public String getIn_reply_to_user_id_str() {
		return in_reply_to_user_id_str;
	}

	public void setIn_reply_to_user_id_str(String in_reply_to_user_id_str) {
		this.in_reply_to_user_id_str = in_reply_to_user_id_str;
	}

	public String getIn_reply_to_screen_name() {
		return in_reply_to_screen_name;
	}

	public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
		this.in_reply_to_screen_name = in_reply_to_screen_name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public Places getPlaces() {
		return places;
	}

	public void setPlaces(Places places) {
		this.places = places;
	}

	public Long getQuoted_status_id() {
		return quoted_status_id;
	}

	public void setQuoted_status_id(Long quoted_status_id) {
		this.quoted_status_id = quoted_status_id;
	}

	public String getQuoted_status_id_str() {
		return quoted_status_id_str;
	}

	public void setQuoted_status_id_str(String quoted_status_id_str) {
		this.quoted_status_id_str = quoted_status_id_str;
	}

	public Boolean getIs_quote_status() {
		return is_quote_status;
	}

	public void setIs_quote_status(Boolean is_quote_status) {
		this.is_quote_status = is_quote_status;
	}

	public Status getQuoted_status() {
		return quoted_status;
	}

	public void setQuoted_status(Status quoted_status) {
		this.quoted_status = quoted_status;
	}

	public Status getRetweeted_status() {
		return retweeted_status;
	}

	public void setRetweeted_status(Status retweeted_status) {
		this.retweeted_status = retweeted_status;
	}

	public int getQuote_count() {
		return quote_count;
	}

	public void setQuote_count(int quote_count) {
		this.quote_count = quote_count;
	}

	public int getReply_count() {
		return reply_count;
	}

	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}

	public int getRetweet_count() {
		return retweet_count;
	}

	public void setRetweet_count(int retweet_count) {
		this.retweet_count = retweet_count;
	}

	public int getFavorite_count() {
		return favorite_count;
	}

	public void setFavorite_count(int favorite_count) {
		this.favorite_count = favorite_count;
	}

	public Entities getEntities() {
		return entities;
	}

	public void setEntities(Entities entities) {
		this.entities = entities;
	}

	public Entities getExtended_entities() {
		return extended_entities;
	}

	public void setExtended_entities(Entities extended_entities) {
		this.extended_entities = extended_entities;
	}

	public Boolean getFavorited() {
		return favorited;
	}

	public void setFavorited(Boolean favorited) {
		this.favorited = favorited;
	}

	public Boolean getRetweeted() {
		return retweeted;
	}

	public void setRetweeted(Boolean retweeted) {
		this.retweeted = retweeted;
	}

	public Boolean getPossibly_sensitive() {
		return possibly_sensitive;
	}

	public void setPossibly_sensitive(Boolean possibly_sensitive) {
		this.possibly_sensitive = possibly_sensitive;
	}

	public String getFilter_level() {
		return filter_level;
	}

	public void setFilter_level(String filter_level) {
		this.filter_level = filter_level;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Boolean getWithheld_copyright() {
		return withheld_copyright;
	}

	public void setWithheld_copyright(Boolean withheld_copyright) {
		this.withheld_copyright = withheld_copyright;
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
