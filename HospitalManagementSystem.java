import java.util.*;

// ---------- Entity Classes ----------
class Doctor {
    int id;
    String name;
    String specialization;

    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Doctor [ID=" + id + ", Name=" + name + ", Specialization=" + specialization + "]";
    }
}

class Patient {
    int id;
    String name;
    int age;

    Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient [ID=" + id + ", Name=" + name + ", Age=" + age + "]";
    }
}

class Appointment {
    int appointmentId;
    Doctor doctor;
    Patient patient;
    String date;

    Appointment(int appointmentId, Doctor doctor, Patient patient, String date) {
        this.appointmentId = appointmentId;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment [ID=" + appointmentId + ", Doctor=" + doctor.name +
                ", Patient=" + patient.name + ", Date=" + date + "]";
    }
}

// ---------- Main Application ----------
public class HospitalManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Doctor> doctors = new ArrayList<>();
    static List<Patient> patients = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();

    static int doctorIdCounter = 1;
    static int patientIdCounter = 1;
    static int appointmentIdCounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Add Patient");
            System.out.println("4. View Patients");
            System.out.println("5. Book Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addDoctor();
                case 2 -> viewDoctors();
                case 3 -> addPatient();
                case 4 -> viewPatients();
                case 5 -> bookAppointment();
                case 6 -> viewAppointments();
                case 7 -> {
                    System.out.println("Exiting... Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // ---------- Methods ----------
    static void addDoctor() {
        System.out.print("Enter Doctor Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();

        Doctor doctor = new Doctor(doctorIdCounter++, name, specialization);
        doctors.add(doctor);
        System.out.println("Doctor added successfully!");
    }

    static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            doctors.forEach(System.out::println);
        }
    }

    static void addPatient() {
        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        Patient patient = new Patient(patientIdCounter++, name, age);
        patients.add(patient);
        System.out.println("Patient added successfully!");
    }

    static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients available.");
        } else {
            patients.forEach(System.out::println);
        }
    }

    static void bookAppointment() {
        if (doctors.isEmpty() || patients.isEmpty()) {
            System.out.println("Add at least one doctor and one patient before booking an appointment.");
            return;
        }

        System.out.println("Select Doctor ID: ");
        viewDoctors();
        int docId = sc.nextInt();
        sc.nextLine();

        Doctor doctor = doctors.stream().filter(d -> d.id == docId).findFirst().orElse(null);
        if (doctor == null) {
            System.out.println("Invalid Doctor ID.");
            return;
        }

        System.out.println("Select Patient ID: ");
        viewPatients();
        int patId = sc.nextInt();
        sc.nextLine();

        Patient patient = patients.stream().filter(p -> p.id == patId).findFirst().orElse(null);
        if (patient == null) {
            System.out.println("Invalid Patient ID.");
            return;
        }

        System.out.print("Enter Appointment Date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        Appointment appointment = new Appointment(appointmentIdCounter++, doctor, patient, date);
        appointments.add(appointment);
        System.out.println("Appointment booked successfully!");
    }

    static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments booked.");
        } else {
            appointments.forEach(System.out::println);
        }
    }
}
