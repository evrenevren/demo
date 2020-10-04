package com.demo.main.data.repository;

import com.demo.main.data.entity.DebitCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DebitCardRepository extends JpaRepository<DebitCardEntity, UUID> {

    DebitCardEntity getByProfile_Id(UUID profileId);
}
