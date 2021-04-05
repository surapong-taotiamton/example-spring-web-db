package test.spring.webdb.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "people")
public class People {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "ADDRESS")
    private String address;
}
