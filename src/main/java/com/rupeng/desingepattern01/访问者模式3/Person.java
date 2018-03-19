package com.rupeng.desingepattern01.访问者模式3;

public class Person {

	private int ID;
	private String name;
	private int age;
	public int getId() {
		return ID;
	}
	public void setId(int id) {
		this.ID = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [id=" + ID + ", name=" + name + ", age=" + age + "]";
	}
	
}
