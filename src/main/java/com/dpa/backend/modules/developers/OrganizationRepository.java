package com.dpa.backend.modules.developers;

import com.dpa.backend.modules.developers.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
