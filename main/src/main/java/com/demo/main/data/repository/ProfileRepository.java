package com.demo.main.data.repository;

import com.demo.main.data.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfileRepository extends JpaRepository<ProfileEntity, UUID> {

    ProfileEntity getByEmail(String email);

}
