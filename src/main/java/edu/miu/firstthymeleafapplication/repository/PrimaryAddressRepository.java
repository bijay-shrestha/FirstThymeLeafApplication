package edu.miu.firstthymeleafapplication.repository;

import edu.miu.firstthymeleafapplication.model.PrimaryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryAddressRepository extends JpaRepository<PrimaryAddress, Integer> {
}
