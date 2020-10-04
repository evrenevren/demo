package com.demo.main.data.repository;

import com.demo.main.data.entity.SupportRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupportRequestRepository extends JpaRepository<SupportRequestEntity, UUID> {
}
