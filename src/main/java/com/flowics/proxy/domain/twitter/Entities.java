package com.flowics.proxy.domain.twitter;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Entities {

	private List<Hashtags> hashtags = new ArrayList<Hashtags>();
	
	private List<Media> media = new ArrayList<Media>();
	
	private List<URL> urls =  new ArrayList<URL>();
	
	private List<UserMentions> user_mentions = new ArrayList<UserMentions>();
	
	private List<Symbols> symbols = new ArrayList<Symbols>();

	private List<Polls> polls = new ArrayList<Polls>();

	
	
	public List<Hashtags> getHashtags() {
		return hashtags;
	}

	public void setHashtags(List<Hashtags> hashtags) {
		this.hashtags = hashtags;
	}

	public List<Media> getMedia() {
		return media;
	}

	public void setMedia(List<Media> media) {
		this.media = media;
	}

	public List<URL> getUrls() {
		return urls;
	}

	public void setUrls(List<URL> urls) {
		this.urls = urls;
	}

	public List<UserMentions> getUser_mentions() {
		return user_mentions;
	}

	public void setUser_mentions(List<UserMentions> user_mentions) {
		this.user_mentions = user_mentions;
	}

	public List<Symbols> getSymbols() {
		return symbols;
	}

	public void setSymbols(List<Symbols> symbols) {
		this.symbols = symbols;
	}

	public List<Polls> getPolls() {
		return polls;
	}

	public void setPolls(List<Polls> polls) {
		this.polls = polls;
	}
	
	
}
