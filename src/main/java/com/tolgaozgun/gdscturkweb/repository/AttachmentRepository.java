package com.tolgaozgun.gdscturkweb.repository;

import com.tolgaozgun.gdscturkweb.entity.AttachmentEntity;
import com.tolgaozgun.gdscturkweb.entity.CampaignEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttachmentRepository extends JpaRepository<AttachmentEntity, Long> {

    Optional<AttachmentEntity> findById(@NonNull Long id);

    List<AttachmentEntity> findAll();


}