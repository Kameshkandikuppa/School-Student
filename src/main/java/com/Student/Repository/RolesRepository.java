package com.Student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Student.Entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {

}