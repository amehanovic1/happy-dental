# Dental Clinic Management System

Developed as part of the **Business Information Systems** course at the Faculty of Electrical Engineering in Sarajevo, this Dental Clinic Management System applies ITIL principles focusing on Supplier Management and Capacity Management to optimize operational workflows and resource coordination.

---

## ITIL Service Management Implementation

### Capacity Management

- Display of available doctors:
  - `GET: /doctors`
- Doctors can view scheduled patients for the day
- Inventory monitoring within the clinic:
  - `GET: /products`

### Supplier Management

- Management of orders and suppliers
- View orders:
  - All orders: `GET: /orders`
  - Confirmed: `GET: /orders/confirmed`
  - Canceled: `GET: /orders/canceled`
- View all suppliers:
  - `GET: /orders/suppliers`

## Database Configuration

Example `application.properties` settings:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/dentalclinic
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=create
spring.jpa.defer-datasource-initialization=true
spring.sql.init.mode=always
spring.sql.init.data-locations=classpath:data.sql
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

## Project Documentation

The complete project documentation is available in PDF format. It provides detailed explanations of system design, implementation, and ITIL process integration.
You can access the documentation here: [Project Documentation](PPIS_Tim_4_DentalClinic.pdf)
