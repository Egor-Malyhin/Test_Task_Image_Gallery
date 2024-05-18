package org.mycorp.models;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
//import org.hibernate.annotations.Type;


@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Table(name = "images")
@Access(AccessType.PROPERTY)
public class Image extends BaseEntity {
    private String name;
    private String imageData;
    private User user;
    private LocalDateTime uploadDate;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Convert(converter = ImageConverter.class)
    @Column(name = "image_data", columnDefinition = "bytea")
    public String getImageData() {
        return imageData;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    public User getUser() {
        return user;
    }

    @Column(name = "upload_date")
    public LocalDateTime getUploadDate() {
        return uploadDate;
    }
}
