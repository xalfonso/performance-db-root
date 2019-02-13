package ec.com.kruger.performance.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@JsonIgnoreProperties(value = {"handler"})
public class Person {

    @Id
    @Column(name="ID")
    private String id;
    
    @Version
    @JsonIgnore
    private Long version;
    
    @Column(name="first_Name")
    private String firstName;
    
    @Column(name="last_Name")
    private String lastName;
    
    @Column(name="age")
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
