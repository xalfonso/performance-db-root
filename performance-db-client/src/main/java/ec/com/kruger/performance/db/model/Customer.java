package ec.com.kruger.performance.db.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@JsonIgnoreProperties(value = {"handler"})
public class Customer {

    @Id
    @GeneratedValue(generator = "customer_generator")
    @SequenceGenerator(
            name = "customer_generator",
            sequenceName = "customer_sequence",
            initialValue = 1000
    )
    public String id;

    @Column
    public String firstName;
    @Column
    public String lastName;

}