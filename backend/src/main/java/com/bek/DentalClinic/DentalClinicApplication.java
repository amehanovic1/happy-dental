package com.bek.DentalClinic;

import com.bek.DentalClinic.enums.Gender;
import com.bek.DentalClinic.enums.Role;
import com.bek.DentalClinic.models.*;
import com.bek.DentalClinic.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DentalClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentalClinicApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(
//			UserRepository userRepository,
//			PatientRepository patientRepository,
//			DoctorRepository doctorRepository,
//			AppointmentRepository appointmentRepository,
//			ProductRepository productRepository,
//			OrderRepository orderRepository) {
//
//		return args -> {
//			// --- Korisnici ---
//			User admin1 = new User("Robert", "Taylor", Role.ADMIN, "robert.taylor@example.com", "password");
//			User admin2 = new User("Olivia", "Miller", Role.ADMIN, "olivia.miller@example.com", "password");
//
//			User doctorUser1 = new User("Emily", "Williams", Role.DOCTOR, "emily.williams@example.com", "password");
//			User doctorUser2 = new User("David", "Brown", Role.DOCTOR, "david.brown@example.com", "password");
//			User doctorUser3 = new User("Jessica", "Jones", Role.DOCTOR, "jessica.jones@example.com", "password");
//			User doctorUser4 = new User("Mark", "Wilson", Role.DOCTOR, "mark.wilson@example.com", "password");
//			User doctorUser5 = new User("Laura", "Moore", Role.DOCTOR, "laura.moore@example.com", "password");
//
//			User patientUser1 = new User("John", "Doe", Role.PATIENT, "john.doe@example.com", "password");
//			User patientUser2 = new User("Jane", "Smith", Role.PATIENT, "jane.smith@example.com", "password");
//			User patientUser3 = new User("Michael", "Johnson", Role.PATIENT, "michael.johnson@example.com", "password");
//			User patientUser4 = new User("Sophia", "Martinez", Role.PATIENT, "sophia.martinez@example.com", "password");
//			User patientUser5 = new User("Daniel", "Garcia", Role.PATIENT, "daniel.garcia@example.com", "password");
//			User patientUser6 = new User("Emma", "Davis", Role.PATIENT, "emma.davis@example.com", "password");
//			User patientUser7 = new User("James", "Martinez", Role.PATIENT, "james.martinez@example.com", "password");
//			User patientUser8 = new User("Isabella", "Rodriguez", Role.PATIENT, "isabella.rodriguez@example.com", "password");
//			User patientUser9 = new User("Benjamin", "Lopez", Role.PATIENT, "benjamin.lopez@example.com", "password");
//			User patientUser10 = new User("Mia", "Gonzalez", Role.PATIENT, "mia.gonzalez@example.com", "password");
//
//			List<User> users = List.of(
//					admin1, admin2,
//					doctorUser1, doctorUser2, doctorUser3, doctorUser4, doctorUser5,
//					patientUser1, patientUser2, patientUser3, patientUser4, patientUser5,
//					patientUser6, patientUser7, patientUser8, patientUser9, patientUser10
//			);
//
//			userRepository.saveAll(users);
//
//			// Ponovno učitaj korisnike da dobijemo generisane ID-jeve
//			List<User> savedUsers = userRepository.findAll();
//
//			// --- Pacijenti ---
//			Patient p1 = new Patient(LocalDate.of(1990, 1, 1), "New York", Gender.Male, "123 Main St", "123456789", getUserIdByEmail(savedUsers, "john.doe@example.com"));
//			Patient p2 = new Patient(LocalDate.of(1985, 5, 15), "Los Angeles", Gender.Female, "456 Elm St", "987654321", getUserIdByEmail(savedUsers, "jane.smith@example.com"));
//			Patient p3 = new Patient(LocalDate.of(1988, 8, 20), "Chicago", Gender.Male, "789 Oak St", "456123789", getUserIdByEmail(savedUsers, "michael.johnson@example.com"));
//			Patient p4 = new Patient(LocalDate.of(1992, 12, 5), "Houston", Gender.Female, "321 Pine St", "987123654", getUserIdByEmail(savedUsers, "sophia.martinez@example.com"));
//			Patient p5 = new Patient(LocalDate.of(1978, 3, 10), "Miami", Gender.Male, "654 Maple St", "321987654", getUserIdByEmail(savedUsers, "daniel.garcia@example.com"));
//			Patient p6 = new Patient(LocalDate.of(1982, 6, 25), "Denver", Gender.Female, "987 Birch St", "654789123", getUserIdByEmail(savedUsers, "emma.davis@example.com"));
//			Patient p7 = new Patient(LocalDate.of(1975, 9, 30), "Seattle", Gender.Male, "147 Walnut St", "987654123", getUserIdByEmail(savedUsers, "james.martinez@example.com"));
//			Patient p8 = new Patient(LocalDate.of(1995, 11, 12), "Boston", Gender.Female, "258 Cedar St", "123987456", getUserIdByEmail(savedUsers, "isabella.rodriguez@example.com"));
//			Patient p9 = new Patient(LocalDate.of(1989, 4, 18), "San Francisco", Gender.Male, "369 Elm St", "789654321", getUserIdByEmail(savedUsers, "benjamin.lopez@example.com"));
//			Patient p10 = new Patient(LocalDate.of(1987, 7, 7), "Phoenix", Gender.Female, "741 Oak St", "456789123", getUserIdByEmail(savedUsers, "mia.gonzalez@example.com"));
//
//			patientRepository.saveAll(List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
//
//			// --- Doktori ---
//			Doctor d1 = new Doctor("Dentist", getUserIdByEmail(savedUsers, "emily.williams@example.com"));
//			Doctor d2 = new Doctor("Orthodontist", getUserIdByEmail(savedUsers, "david.brown@example.com"));
//			Doctor d3 = new Doctor("Surgeon", getUserIdByEmail(savedUsers, "jessica.jones@example.com"));
//			Doctor d4 = new Doctor("Endodontist", getUserIdByEmail(savedUsers, "mark.wilson@example.com"));
//			Doctor d5 = new Doctor("Periodontist", getUserIdByEmail(savedUsers, "laura.moore@example.com"));
//
//			doctorRepository.saveAll(List.of(d1, d2, d3, d4, d5));
//
//			// Ponovo učitaj doktore i pacijente da dobijemo njihove ID-jeve
//			List<Doctor> savedDoctors = doctorRepository.findAll();
//			List<Patient> savedPatients = patientRepository.findAll();
//
//			// --- Appointment (termini) ---
//			Appointment a1 = new Appointment(LocalDateTime.now().plusDays(1), savedDoctors.get(0).getId(), savedPatients.get(0).getId());
//			Appointment a2 = new Appointment(LocalDateTime.now().plusDays(2), savedDoctors.get(1).getId(), savedPatients.get(1).getId());
//			Appointment a3 = new Appointment(LocalDateTime.now().plusDays(3), savedDoctors.get(2).getId(), savedPatients.get(2).getId());
//			Appointment a4 = new Appointment(LocalDateTime.now().plusDays(4), savedDoctors.get(3).getId(), savedPatients.get(3).getId());
//			Appointment a5 = new Appointment(LocalDateTime.now().plusDays(5), savedDoctors.get(4).getId(), savedPatients.get(4).getId());
//
//			appointmentRepository.saveAll(List.of(a1, a2, a3, a4, a5));
//
//			// --- Proizvodi ---
//			Product prod1 = new Product("Dental Floss", "Waxed dental floss, mint flavor", 10, 150);
//			Product prod2 = new Product("Toothpaste", "Fluoride toothpaste for sensitive teeth", 5, 300);
//			Product prod3 = new Product("Mouthwash", "Antiseptic mouthwash", 8, 200);
//			Product prod4 = new Product("Toothbrush", "Soft-bristle toothbrush", 3, 500);
//			Product prod5 = new Product("Dental Picks", "Disposable dental picks", 15, 100);
//			productRepository.saveAll(List.of(prod1, prod2, prod3, prod4, prod5));
//
//			// --- Narudžbe ---
//			Order o1 = new Order(LocalDateTime.now().minusDays(1), 30, prod1.getId(), savedPatients.get(0).getUserId());
//			Order o2 = new Order(LocalDateTime.now().minusDays(2), 50, prod2.getId(), savedPatients.get(1).getUserId());
//			Order o3 = new Order(LocalDateTime.now().minusDays(3), 20, prod3.getId(), savedPatients.get(2).getUserId());
//			Order o4 = new Order(LocalDateTime.now().minusDays(4), 60, prod4.getId(), savedPatients.get(3).getUserId());
//			Order o5 = new Order(LocalDateTime.now().minusDays(5), 10, prod5.getId(), savedPatients.get(4).getUserId());
//
//			orderRepository.saveAll(List.of(o1, o2, o3, o4, o5));
//		};
//	}

//	private Integer getUserIdByEmail(List<User> users, String email) {
//		return users.stream()
//				.filter(u -> u.getEmail().equals(email))
//				.findFirst()
//				.map(User::getId)
//				.orElseThrow(() -> new RuntimeException("User not found: " + email));
//	}

	public class PasswordHashGenerator {
		public static void main(String[] args) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String rawPassword = "password";
			String encodedPassword = encoder.encode(rawPassword);
			System.out.println(encodedPassword);
		}
	}


}
