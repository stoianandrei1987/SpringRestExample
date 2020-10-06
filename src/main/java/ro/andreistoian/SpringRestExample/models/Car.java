package ro.andreistoian.SpringRestExample.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "id")
    Long id;

    @JsonProperty(value = "brand")
    String brand;

    @JsonProperty(value = "name")
    String name;

    @Column(name = "price")
    @JsonProperty(value = "price")
    Integer price;


}
