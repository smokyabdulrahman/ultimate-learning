package me.alrahma.ultimatelearning.url.shortner.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UrlStats {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @ManyToOne(targetEntity = Url.class, optional = false)
    @Setter
    private Url url;

    @Getter
    @Setter
    String deviceType;

    @Getter
    @CreationTimestamp
    private Timestamp createdAt;

    @Getter
    @UpdateTimestamp
    private Timestamp updatedAt;

    @Getter
    @Setter
    private Timestamp deletedAt;
}
