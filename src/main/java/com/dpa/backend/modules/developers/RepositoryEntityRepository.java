package com.dpa.backend.modules.developers;

import com.dpa.backend.modules.developers.entities.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEntityRepository extends JpaRepository<Repository, Long> {
}
