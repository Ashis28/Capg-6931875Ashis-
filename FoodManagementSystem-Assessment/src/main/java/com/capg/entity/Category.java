package com.capg.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "category")
public class Category implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_seq_gen")
    @SequenceGenerator(
            name = "cat_seq_gen",
            sequenceName = "category_seq",
            allocationSize = 1)
	private Long id;
	
	private String categoryName;
	
	private String description;
	
	@OneToMany(
			mappedBy = "category",
			cascade = CascadeType.ALL,
			fetch=FetchType.LAZY,
			orphanRemoval=true
			)
	private List<FoodItem> items;
	
	public Category() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<FoodItem> getItems() {
		return items;
	}

	public void setItems(List<FoodItem> items) {
		this.items = items;
	}
	
	@Override
	public String toString() {
	    return "Category [id=" + id +
	           ", name=" + categoryName +
	           ", description=" + description + "]";
	}

	
}
