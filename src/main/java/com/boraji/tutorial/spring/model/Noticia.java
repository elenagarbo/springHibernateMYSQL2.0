package com.boraji.tutorial.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "NEWS")

public class Noticia {
  @Id
  @Column(name = "ID")
  private int id;

  @Column(name = "TITLE", nullable = false)
  private String title;

  @Column(name = "DESCRIPTION", nullable = false)
  private String description;

//@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//  private Set<Authorities> authorities = new HashSet<>();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}


//  public Set<Authorities> getAuthorities() {
//    return authorities;
//  }
//
//  public void setAuthorities(Set<Authorities> authorities) {
//    this.authorities = authorities;
//  }
}
