package test.spring.webdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.spring.webdb.entity.People;
import test.spring.webdb.repository.PeopleRepository;

import java.util.List;
import java.util.UUID;

@RestController
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepository;

    @GetMapping("/test-create")
    public void testCreate() {
        People people = new People()
                .setId(UUID.randomUUID().toString())
                .setFullName("Normal Programmer")
                .setAge(2)
                .setAddress("In blog")
                ;
        peopleRepository.save(people);
    }

    @GetMapping("/test-select-with-method-name")
    public List<People> testSelectWithMethod() {
        return peopleRepository.findByAgeGreaterThanAndFullNameStartingWith(50, "B");
    }

    @GetMapping("/test-select-with-query")
    public List<People> testSelectWithQuery() {
        return peopleRepository.myQuery(50, "B");
    }

    @GetMapping("/test-select-with-page")
    public List<People> testSelectWithMethodAndPage() {
        Pageable pageable = PageRequest.of(0, 2, Sort.by(Sort.Direction.DESC, "age"));
        Page<People> result = peopleRepository.findByAgeGreaterThanAndFullNameStartingWith(50, "B", pageable);
        return result.getContent();
    }

}
