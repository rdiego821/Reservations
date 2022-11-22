package com.amenity_reservation_system;

import com.amenity_reservation_system.model.AmenityType;
import com.amenity_reservation_system.model.Capacity;
import com.amenity_reservation_system.model.Reservation;
import com.amenity_reservation_system.model.User;
import com.amenity_reservation_system.repos.CapacityRepository;
import com.amenity_reservation_system.repos.ReservationRepository;
import com.amenity_reservation_system.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class AmenityReservationSystemApplication {

    private Map<AmenityType, Integer> initialCapacities =
            new HashMap<>() {
                {
                    put(AmenityType.GYM, 20);
                    put(AmenityType.POOL, 4);
                    put(AmenityType.SAUNA, 1);
                }
            };

    public static void main(final String[] args) {
        SpringApplication.run(AmenityReservationSystemApplication.class, args);
    }

    /*
    @Bean
    public CommandLineRunner loadData(UserRepository userRepository,
                                      ReservationRepository reservationRepository) {
        return (args) -> {
            User user =
                    userRepository.save(
                            new User("Yigit Kemal Erinc",
                                    "yigiterinc",
                                    bCryptPasswordEncoder().encode("12345")));
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Reservation reservation =
                    Reservation.builder()
                            .reservationDate(localDate)
                            .startTime(LocalTime.of(12, 00))
                            .endTime(LocalTime.of(13, 00))
                            .dateCreated(OffsetDateTime.now())
                            .lastUpdated(OffsetDateTime.now())
                            .user(user)
                            .amenityType(AmenityType.POOL)
                            .build();

            reservationRepository.save(reservation);
        };
    }

     */

    @Bean
    public CommandLineRunner loadData(
            UserRepository userRepository,
            CapacityRepository capacityRepository) {
        return (args) -> {
            userRepository.save(
                    new User("Yigit Kemal Erinc", "yigiterinc", bCryptPasswordEncoder().encode("12345")));

            for (AmenityType amenityType : initialCapacities.keySet()) {
                capacityRepository.save(new Capacity(amenityType, initialCapacities.get(amenityType)));
            }
        };
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
