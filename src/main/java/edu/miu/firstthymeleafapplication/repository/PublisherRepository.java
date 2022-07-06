package edu.miu.firstthymeleafapplication.repository;

import edu.miu.firstthymeleafapplication.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    // Custom Query using JPQL
    @Query(value = "select p from Publisher p where p.name = :name")
    Optional<Publisher> getPublisherByName(String name);

}
