package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.model.Calculator;

public interface OperationRepository extends JpaRepository<Calculator,Long> {
}
