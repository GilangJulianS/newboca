package com.boca.custom;

/**
 * Created by gilang on 25/09/2015.
 */
public class Venue {

	public String name;
	public String address;
	public String phone;
	public String info;

	public Venue(String name, String address, String info, String phoneNumber){
		this.name = name;
		this.address = address;
		this.info = info;
		this.phone = phoneNumber;
	}
}
