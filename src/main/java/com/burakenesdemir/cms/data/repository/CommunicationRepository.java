package com.burakenesdemir.cms.data.repository;

import com.burakenesdemir.cms.data.entity.Communication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationRepository extends JpaRepository<Communication,String> {
}
