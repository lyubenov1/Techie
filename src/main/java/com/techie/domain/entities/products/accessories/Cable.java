package com.techie.domain.entities.products.accessories;

import com.techie.domain.entities.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cables")
public class Cable extends Product {

    @Column
    private String type;

    @Column
    private String length;

    @Column(name = "connector_one")
    private String connectorTypeEndOne;

    @Column(name = "connector_two")
    private String connectorTypeEndTwo;

}