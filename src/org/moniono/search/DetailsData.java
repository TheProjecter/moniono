/*
 * mOnionO - The mobile Onion Observer
 * Copyright (C) 2012 Jens Bruhn (moniono@gmx.net)
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package org.moniono.search;


import static org.moniono.util.JSONUtil.getBoolean;
import static org.moniono.util.JSONUtil.getCalendar;
import static org.moniono.util.JSONUtil.getLong;
import static org.moniono.util.JSONUtil.getString;
import static org.moniono.util.JSONUtil.getStringArray;
import static org.moniono.util.JSONUtil.getDouble;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.moniono.util.BandwidthUtil;
import org.moniono.util.LogTags;

import android.util.Log;

public class DetailsData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1016135141030457437L;

	
	private static final String EMPTY_STRING = "";
	private static final String ZERO = "0";
	private static final int CACHE_TIMESPAN_IN_MINUTES = 5;

	private static final String NICKNAME_KEY = "nickname";
	private static final String FINGERPRINT_KEY = "fingerprint";
	private static final String HASH_KEY = "hashed_fingerprint";
	private static final String ADDRESSES_KEY = "or_addresses";
	private static final String DIR_ADDRESS_KEY = "dir_address";
	private static final String RUNNING_KEY = "running";
	private static final String FLAGS_KEY = "flags";
	private static final String LAST_RESTARTED_KEY = "last_restarted";
	private static final String EXIT_POLICY_KEY = "exit_policy";
	private static final String CONTACT_KEY = "contact";
	private static final String PLATFORM_KEY = "platform";
	private static final String FAMILY_KEY = "family";
	private static final String COUNTRY_KEY = "country";
	private static final String POOL_ASSIGNMENT_KEY = "pool_assignment";
	private static final String GEO_LATITUDE_KEY = "latitude";
	private static final String GEO_LONGITUDE_KEY = "longitude";
	
	private static final String COUNTRY_NAME_KEY = "country_name";
	private static final String REGION_NAME_KEY = "region_name";
	private static final String CITY_NAME_KEY = "city_name";
	
	private static final String AS_NAME_KEY = "as_name";
	private static final String AS_NUMBER_KEY = "as_number";
	
	
	private static final String ADVERTISED_BANDWIDTH_KEY = "advertised_bandwidth";

	private static final String BANDWIDTH_FIRST_TIME = "first";
	private static final String BANDWIDTH_LAST_TIME = "last";

	private Calendar validUntil;
	private Calendar restartTimestamp;
	private Long advertisedBandwidth;
	private String advertisedBandwidthString;
	private String nickname;
	private String originalNickname;
	private String fingerprint;
	private String[] addresses;
	private String dirAddress;
	private boolean running = false;
	private NodeFlag[] flags;
	private String[] exitPolicy;
	private String contact;
	private String platform;
	private String[] family;
	private String country;
	private String city;
	private String as;
	private String poolAssignment;
	private BandwidthData bandwidthData;
	private String geoLocation;
	private double geoLatitude = Double.NaN;
	private double geoLongitude = Double.NaN;
	private boolean geoInfo = false;

	public DetailsData(String iniNickname, String hash) {
		this.nickname = iniNickname;
		this.fingerprint = hash;
	}

	public DetailsData(JSONObject jsonDetails, String iniNickname,BandwidthData iniBData)
			throws IllegalStateException {
		this.bandwidthData = iniBData;
		try {
			this.validUntil = new GregorianCalendar();
			this.validUntil.add(Calendar.MINUTE, 5);
			this.originalNickname = getString(NICKNAME_KEY, EMPTY_STRING,
					jsonDetails);
			if (iniNickname == null) {
				this.nickname = this.originalNickname;
			} else {
				this.nickname = iniNickname;
			}
			this.fingerprint = getString(FINGERPRINT_KEY, EMPTY_STRING,
					jsonDetails);
			if(this.fingerprint.equals(EMPTY_STRING)){
				this.fingerprint = getString(HASH_KEY, EMPTY_STRING,
						jsonDetails);
			}
			this.addresses = getStringArray(ADDRESSES_KEY, null, jsonDetails);
			this.dirAddress = getString(DIR_ADDRESS_KEY, null, jsonDetails);
			this.running = getBoolean(RUNNING_KEY, false, jsonDetails);
			this.flags = getRelayFlagArray(FLAGS_KEY, null, jsonDetails);
			this.exitPolicy = getStringArray(EXIT_POLICY_KEY, null, jsonDetails);
			this.family = getStringArray(FAMILY_KEY, null, jsonDetails);
			this.contact = getString(CONTACT_KEY, null, jsonDetails);
			this.platform = getString(PLATFORM_KEY, null, jsonDetails);
			this.country = getString(COUNTRY_NAME_KEY,null,jsonDetails);
			String countryCode = getString(COUNTRY_KEY,null,jsonDetails);
			if(this.country == null && countryCode != null){
				this.country = countryCode;
			}else if(this.country != null && countryCode != null){
				this.country += " ("+countryCode+")";
			}
			this.city = getString(CITY_NAME_KEY,null,jsonDetails);
			String region = getString(REGION_NAME_KEY,null,jsonDetails);
			if(this.city == null && region != null){
				this.city = region;
			}else if(this.city != null && region != null){
				this.city += " ("+region+")";
			}
			this.as = getString(AS_NAME_KEY,null,jsonDetails);
			String asNumber = getString(AS_NUMBER_KEY,null,jsonDetails);
			if(this.as == null && asNumber != null){
				this.as = asNumber;
			}else if(this.as != null && asNumber != null){
				this.as += " ("+asNumber+")";
			}
			this.poolAssignment = getString(POOL_ASSIGNMENT_KEY,null,jsonDetails);
			this.geoLatitude = getDouble(GEO_LATITUDE_KEY,Double.NaN,jsonDetails);
			this.geoLongitude = getDouble(GEO_LONGITUDE_KEY,Double.NaN,jsonDetails);
			this.geoInfo = jsonDetails.has(GEO_LATITUDE_KEY) && jsonDetails.has(GEO_LONGITUDE_KEY);
			
			this.advertisedBandwidth = getLong(ADVERTISED_BANDWIDTH_KEY, 0, jsonDetails);
			this.advertisedBandwidthString = BandwidthUtil.getBandwidthString(this.advertisedBandwidth);
			
			this.restartTimestamp = getCalendar(LAST_RESTARTED_KEY, new GregorianCalendar(), jsonDetails);

		} catch (JSONException e) {
			throw new IllegalStateException("Illegal details file format.", e);
		}
	}

	private static final NodeFlag[] getRelayFlagArray(String key,
			NodeFlag[] defaultValue, JSONObject json) throws JSONException {
		NodeFlag[] result = defaultValue;
		if (json.has(key)) {
			JSONArray jsonArray = json.getJSONArray(key);
			result = new NodeFlag[jsonArray.length()];
			for (int i = 0; i < jsonArray.length(); i++) {
				result[i] = NodeFlag.fromAbbrev(jsonArray.getString(i));
			}
		}
		return result;
	}

	public Calendar getValidUntil() {
		return this.validUntil;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String newNickname) {
		this.nickname = newNickname;
	}

	public String getFingerprint() {
		return this.fingerprint;
	}

	public String[] getAddresses() {
		return this.addresses;
	}

	public String getDirAddress() {
		return this.dirAddress;
	}

	public boolean isRunning() {
		return this.isValid() && this.running;
	}

	public NodeFlag[] getFlags() {
		return this.flags;
	}

	public String[] getExitPolicy() {
		return this.exitPolicy;
	}

	public String getContact() {
		return this.contact;
	}

	public String getPlatform() {
		return this.platform;
	}

	public boolean isValid() {
		Calendar now = new GregorianCalendar();
		return this.validUntil != null && now.compareTo(this.validUntil) < 0;
	}

	public String getOriginalNickname() {
		return this.originalNickname;
	}

	public Calendar getRestartTimestamp() {
		return this.restartTimestamp;
	}

	public String getAdvertisedBandwidth() {
		
		return this.advertisedBandwidthString;
	}

	public String[] getFamily() {
		return this.family;
	}

	public String getCountry() {
		return this.country;
	}
	
	public String getPoolAssignment(){
		return this.poolAssignment;
	}

	public BandwidthData getBandwidthData() {
		return this.bandwidthData;
	}

	public double getGeoLatitude() {
		return this.geoLatitude;
	}

	public double getGeoLongitude() {
		return this.geoLongitude;
	}
	
	public boolean hasGeoInformation(){
		return this.geoInfo;
	}

	public String getCity() {
		return city;
	}

	public String getAs() {
		return as;
	}

}
