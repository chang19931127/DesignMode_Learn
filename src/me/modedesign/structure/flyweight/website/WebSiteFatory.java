package me.modedesign.structure.flyweight.website;

import java.util.Hashtable;

/**
 * 
 * @author 43994897
 *	Õ¯’æπ§≥ß¿‡
 */
public class WebSiteFatory {
	private Hashtable<String, WebSite> flyWeights = new Hashtable<String, WebSite>();
	
	public WebSite  getWebSiteCategory(String key){
		if( ! flyWeights.containsKey(key)) flyWeights.put(key, new ConcreterWebSite(key));
		return flyWeights.get(key);	
	}
	
	public int getWebSiteCount(){
		return flyWeights.size();
	}
}
