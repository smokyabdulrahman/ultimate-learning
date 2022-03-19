package me.alrahma.ultimatelearning.url.shortner.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Url {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Column(
            updatable = false,
            nullable = false
    )
    @Getter
    @Setter
    private String fullUrl;

    @Column(
            unique = true,
            updatable = false,
            nullable = false
    )
    @Getter
    @Setter
    private String slug;

    @Column(
            nullable = false
    )
    @Getter
    @Setter
    private int numberOfVisits = 0;

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
