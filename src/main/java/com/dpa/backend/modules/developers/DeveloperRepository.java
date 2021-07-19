package com.dpa.backend.modules.developers;

import com.dpa.backend.modules.developers.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
