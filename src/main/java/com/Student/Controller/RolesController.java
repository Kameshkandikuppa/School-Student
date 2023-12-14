package com.Student.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList; 
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController;
import com.Student.Entity.Roles; 
import com.Student.Entity.Screen; 
import jakarta.persistence.EntityManager; 
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
  
  @RestController
  @RequestMapping("/roles") 
  
  public class RolesController {
  
  @Autowired 
  private EntityManager entityManager;
  
  @GetMapping 
  public List<Roles> getAllRoles() { 
  TypedQuery<Roles> 
  
  query =entityManager.createQuery("SELECT p FROM Roles p", Roles.class);
  List<Roles>
  roles= query.getResultList(); 
  return roles; 
  
  }
  
  @GetMapping("/{id}") 
  
  public ResponseEntity<Roles>
  getRolesById(@PathVariable(value = "id") 
  
  int RolesId) {
	  Roles roles = entityManager.find(Roles.class, RolesId); 
  if (roles == null) {
	  return
  ResponseEntity.notFound().build(); 
	  }
  return ResponseEntity.ok().body(roles);
  }
  
  @PostMapping
  
  @Transactional
  public Roles createroles( @RequestBody Roles roles) {
 
	  List<Screen> screens = new ArrayList<>(); 
  for (Screen screen:roles.getScreen()) { 
	  Screen managedScreen = entityManager.find(Screen.class,screen.getId()); 
	  screens.add(managedScreen); 
  } 
  roles.setScreen(screens);
  entityManager.persist(roles);
  entityManager.flush(); 
  return roles; 
  } 
  
}