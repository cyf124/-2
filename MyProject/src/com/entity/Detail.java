package com.entity;
import java.sql.Timestamp;

	/**
	 * Detail entity. @author MyEclipse Persistence Tools
	 */

	public class Detail implements java.io.Serializable {

		// Fields

		private static final long serialVersionUID = 1L;
		private Integer id;
		private String username;
		private String sex;
		private Integer age;
		private String location;
		private String phone;
		private String email;
		private String school;
		private String hometown;
		private String description;
		private Timestamp time;

		// Constructors

		/** default constructor */
		public Detail() {
		}

		/** full constructor */
		public Detail(String username, String sex, Integer age, String location,
				String phone, String email, String school, String hometown,
				String description, Timestamp time) {
			this.username = username;
			this.sex = sex;
			this.age = age;
			this.location = location;
			this.phone = phone;
			this.email = email;
			this.school = school;
			this.hometown = hometown;
			this.description = description;
			this.time = time;
		}

		// Property accessors

		public Integer getId() {
			return this.id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUsername() {
			return this.username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getSex() {
			return this.sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public Integer getAge() {
			return this.age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getLocation() {
			return this.location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getPhone() {
			return this.phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return this.email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSchool() {
			return this.school;
		}

		public void setSchool(String school) {
			this.school = school;
		}

		public String getHometown() {
			return this.hometown;
		}

		public void setHometown(String hometown) {
			this.hometown = hometown;
		}

		public String getDescription() {
			return this.description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Timestamp getTime() {
			return this.time;
		}

		public void setTime(Timestamp time) {
			this.time = time;
		}

	}


