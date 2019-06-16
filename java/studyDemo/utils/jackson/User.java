package com.mote.jackson;

public class User {
	
	private String name;
	private Integer age;
	private String city;
	
	public User() {
		super();
	}
	public User(String name, Integer age, String city) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", city=" + city + "]";
	}

}