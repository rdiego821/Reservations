package com.amenity_reservation_system.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name = "\"user\"")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    @Column(nullable = false, unique = true)
    private String fullName = "Diego";

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String passwordHash;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Reservation> reservations = new HashSet<>();

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated = OffsetDateTime.of(
            LocalDate.of(2015, 10, 18),
            LocalTime.of(11, 20, 30, 1000),
            ZoneOffset.ofHours(-5));

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated = OffsetDateTime.of(
            LocalDate.of(2015, 10, 18),
            LocalTime.of(11, 20, 30, 1000),
            ZoneOffset.ofHours(-5));

    @PrePersist
    public void prePersist() {
        dateCreated = OffsetDateTime.now();
        lastUpdated = dateCreated;
    }

    @PreUpdate
    public void preUpdate() {
        lastUpdated = OffsetDateTime.now();
    }

    public User(String fullName, String username, String passwordHash) {
        this.fullName = fullName;
        this.username = username;
        this.passwordHash = passwordHash;
    }
}
