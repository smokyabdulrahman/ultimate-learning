package me.alrahma.ultimatelearning.url.shortner.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Url {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    @OneToMany(cascade=ALL, targetEntity = UrlStats.class)
    public Set<UrlStats> urlStats;

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
