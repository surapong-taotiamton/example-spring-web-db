package test.spring.webdb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test.spring.webdb.entity.People;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, String> {
    List<People> findByAgeGreaterThanAndFullNameStartingWith(Integer age, String fullName);

    Page<People> findByAgeGreaterThanAndFullNameStartingWith(Integer age, String fullName,
                                                             Pageable pageable);

    @Query("SELECT p FROM People p WHERE p.age > :age AND p.fullName like CONCAT(:fullName, '%') ")
    List<People> myQuery(
            @Param("age") Integer age,
            @Param("fullName") String fullName
    );


}
