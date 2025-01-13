/** Clasa pentru controller la diferite functionalitati (create,edit,delete,view)
* @author Iordache Alex
* @version 12 Ianuarie 2025
*/
package com.AI.Activties.controllers;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AI.Activties.models.Activity;
import com.AI.Activties.models.ActivityDTO;
import com.AI.Activties.services.activitiesRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/activities")
public class activitiesController {
	
	@Autowired
	private activitiesRepository repo;
	
	@GetMapping({"", "/"})
	public String showProductList (Model model) {
		List<Activity> activities = repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
		model.addAttribute("activities", activities);
		return "activities/index";
	}
	
	@GetMapping("/create")
	public String showCreatePage (Model model) {
		ActivityDTO activityDTO = new ActivityDTO();
		model.addAttribute("activityDTO", activityDTO);
		return "activities/CreateActivity";
	}
	
	@PostMapping ("/create")
	public String createProduct(
			@Valid @ModelAttribute ActivityDTO activityDTO,
			BindingResult result
			) {
		
		if (result.hasErrors()) {
			return "activities/CreateActivity";
		}
		
		Date createdAt = new Date();
		
		Activity activity = new Activity();
		activity.setName(activityDTO.getName());
		activity.setDescription(activityDTO.getDescription());
		activity.setState(activityDTO.getState());
		activity.setCreatedAt(createdAt);
		
		repo.save(activity);
		
		return "redirect:/activities";
	}
	
	
	@GetMapping("/edit")
	public String showEditPage(
			Model model,
			@RequestParam int id
			) {
		
		try {
			Activity activity = repo.findById(id).get();
			model.addAttribute("activity", activity);
			
			ActivityDTO activitydto = new ActivityDTO();
			activitydto.setName(activity.getName());
			activitydto.setDescription(activity.getDescription());
			activitydto.setState(activity.getState());
			
			model.addAttribute("activitydto", activitydto);
		}
		catch (Exception ex) {
			System.out.println("Exception:" + ex.getMessage());
			return "redirect:/activities";
		}
		return "activities/EditActivity";
	}
	
	@PostMapping("/edit")
	public String updateProduct(
			Model model,
			@RequestParam int id,
			@Valid @ModelAttribute ActivityDTO activityDTO,
			BindingResult result
			) {
		
		try {
			Activity activity = repo.findById(id).get();
			model.addAttribute("activity",activity);
			
			if(result.hasErrors()) {
				return "activities/EditActivty";
			}
			
			activity.setName(activityDTO.getName());
			activity.setDescription(activityDTO.getDescription());
			activity.setState(activityDTO.getState());
			
			repo.save(activity);
			
		}
		catch (Exception ex) {
			System.out.println("Exception:" + ex.getMessage());
			return "redirect:/activities";
		}
		return "redirect:/activities";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(
			@RequestParam int id
			) {
		
		Activity activity = repo.findById(id).get();
		repo.delete(activity);
		
		return "redirect:/activities";
	}
	
	
}
