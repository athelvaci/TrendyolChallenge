package com.trendyolConf.spring.model;

import javax.persistence.*;


@Entity
@Table(name = "configstorage")
public class Configuration {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	private String name;

	private String type;

	private String value;

	private int isactive;

	private String applicationname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

	public String getApplicationname() {
		return applicationname;
	}

	public void setApplicationname(String applicationname) {
		this.applicationname = applicationname;
	}

	@Override
	public String toString() {
		return "Configuration [id=" + id + ", name=" + name + ", type=" + type + ", value=" + value + ", isactive=" + isactive + ", applicationname=" + applicationname + "]";
	}

}
