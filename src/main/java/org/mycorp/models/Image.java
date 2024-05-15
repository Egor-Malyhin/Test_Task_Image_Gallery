package org.mycorp.models;

import jakarta.persistence.*;
import lombok.*;
//import org.hibernate.annotations.Type;


@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "images")
public class Image extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Lob
    @Convert(converter = ImageConverter.class)
    @Column(name = "image_data", columnDefinition = "bytea")
    private String imageData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    /*public Image(long id, String name, byte[] imageData, User user) {
        super(id);
        this.name = name;
        this.imageData = imageData;
        this.user = user;
    }*/
}
