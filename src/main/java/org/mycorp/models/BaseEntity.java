package org.mycorp.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.PROPERTY)
public abstract class BaseEntity {
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }
}
