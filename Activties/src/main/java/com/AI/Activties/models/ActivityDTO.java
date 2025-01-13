/** Clasa pentru modelarea unui obiect de tip "activitate"
* @author Iordache Alex
* @version 12 Ianuarie 2025
*/

package com.AI.Activties.models;

import jakarta.validation.constraints.*;

public class ActivityDTO {

	@NotEmpty(message = "The name is required")
	private String name;
	@NotEmpty(message = "The description is required")
	private String description;
	@NotEmpty(message = "The state is required")
	private String state;
	
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

}
