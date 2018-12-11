package com.cttic.service.domain.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Teacher1Repository extends JpaRepository<Teacher1, Integer>, JpaSpecificationExecutor<Teacher1> {

}
