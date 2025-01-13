/** Clasa pentru definirea functiilor care fac posibile functionalitatile aplicatiei (gettere si settere)
* @author Iordache Alex
* @version 12 Ianuarie 2025
*/
package com.AI.Activties.models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "activities")
public class Activity {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String description;
	private String state;
	
	@Column(columnDefinition = "TEXT")
	private Date createdAt;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


}
