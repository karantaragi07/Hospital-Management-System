🏥 Hospital Management System

A microservices-based Hospital Management System built using Spring Boot and MongoDb, designed to efficiently manage doctors, patients, and appointments.

---

📌 Microservices Overview

1️⃣ Doctor Service 🩺

. Manages doctor details (name, specialization, availability)

. Provides APIs for CRUD operations on doctors

2️⃣ Patient Service 👤

. Handles patient registration and record management

. Provides APIs for adding, updating, and fetching patient data

3️⃣ Appointment Service 📅

. Manages appointments between patients and doctors

. Uses WebClient to fetch doctor & patient details from respective services

---

🚀 Tech Stack

Spring Boot (Java 17+) → Microservice backend

MongoDb → Database

Spring WebClient → Service-to-service communication

Swagger (OpenAPI) → API documentation & testing

Maven/Gradle → Build tool

REST APIs → Communication layer

---

⚡ Features

. CRUD operations for Doctor, Patient, and Appointment

. REST APIs with Swagger UI documentation

. Inter-service communication using Spring WebClient

. Microservices can run independently or together

. Scalable design for future extensions

---

📂 Project Structure

```text
hospital-management-system/
│── doctor-service/        # Doctor microservice (Spring Boot)
│── patient-service/       # Patient microservice (Spring Boot)
│── appointment-service/   # Appointment microservice (Spring Boot + WebClient)
│── README.md

```

---

⚙️ Setup & Run

🔹 1. Clone Repository
```bash
git clone https://github.com/<your-username>/Hospital-Management-System.git
cd Hospital-Management-System
```
🔹 2. Run Services Individually
```bash
cd doctorService
mvn spring-boot:run
```
```bash
cd patientService
mvn spring-boot:run
```
```bash
cd appointmentService
mvn spring-boot:run
```

---

📖 API Documentation

Once the services are running, you can explore APIs via Swagger UI:

Doctor Service → http://localhost:8081/swagger-ui.html

Patient Service → http://localhost:8082/swagger-ui.html

Appointment Service → http://localhost:8083/swagger-ui.html

---

🔮 Future Enhancements

. Authentication & Authorization (JWT)

. Role-based access (Admin, Doctor, Patient)

. Notification service (Email/SMS reminders)

. Deployment on Cloud (AWS/GCP/Azure)

---

🤝 Contributing

. Fork this repo

. Create a feature branch (feature-new-module)

. Commit changes (git commit -m "Added new feature")

. Push to branch (git push origin feature-new-module)

. Open a Pull Request

---

🙌 Acknowledgements

Special thanks to all contributors and open-source projects that made this system possible.

---

📬 Contact

For any queries, suggestions, or contributions:

👨‍💻 Author: Karan Taragi

📧 Email: ksingh064002@gmail.com

🌐 GitHub: karantaragi07













