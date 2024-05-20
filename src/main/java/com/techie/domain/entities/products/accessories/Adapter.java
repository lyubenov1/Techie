package com.techie.domain.entities.products.accessories;

import com.techie.domain.entities.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "adapters")
public class Adapter extends Product {

    @Column(name = "connector_one")
    private String connectorTypeEndOne;

    @Column(name = "gender_one")
    private String genderEndOne;

    @Column(name = "connector_two")
    private String connectorTypeEndTwo;

    @Column(name = "gender_two")
    private String genderEndTwo;

}