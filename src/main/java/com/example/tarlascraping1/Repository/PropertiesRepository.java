package com.example.tarlascraping1.Repository;

import com.example.tarlascraping1.Models.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties, Integer> {
    @Query("SELECT r FROM  Properties r WHERE r.properties_id = ?1")
    Properties findByPropertiesId(int id);


}
