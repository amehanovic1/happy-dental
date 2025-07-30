DELETE FROM orders;
DELETE FROM appointment;
DELETE FROM doctor;
DELETE FROM patient;
DELETE FROM product;
DELETE FROM users;

-- --- User ---
INSERT INTO users (first_name, last_name, role, email, password) VALUES
   ('Robert', 'Taylor', 'ADMIN', 'robert.taylor@example.com', '$2a$12$etvYOkX69p38LEQC9t55keuFwU2t4BNeG53hgCNRTs1Axk3hz6tZW'),
   ('Olivia', 'Miller', 'ADMIN', 'olivia.miller@example.com', '$2a$12$etvYOkX69p38LEQC9t55keuFwU2t4BNeG53hgCNRTs1Axk3hz6tZW'),

   ('Emily', 'Williams', 'DOCTOR', 'emily.williams@example.com', '$2a$12$etvYOkX69p38LEQC9t55keuFwU2t4BNeG53hgCNRTs1Axk3hz6tZW'),
   ('David', 'Brown', 'DOCTOR', 'david.brown@example.com', '$2a$12$t1bDoNfegGdBx1PyUPNolOlwE73lhS8hlXeIvZUJ1RODkGFM8XsGS'),
   ('Jessica', 'Jones', 'DOCTOR', 'jessica.jones@example.com', '$2a$12$t1bDoNfegGdBx1PyUPNolOlwE73lhS8hlXeIvZUJ1RODkGFM8XsGS'),
   ('Mark', 'Wilson', 'DOCTOR', 'mark.wilson@example.com', '$2a$12$t1bDoNfegGdBx1PyUPNolOlwE73lhS8hlXeIvZUJ1RODkGFM8XsGS'),
   ('Laura', 'Moore', 'DOCTOR', 'laura.moore@example.com', '$2a$12$t1bDoNfegGdBx1PyUPNolOlwE73lhS8hlXeIvZUJ1RODkGFM8XsGS'),

   ('John', 'Doe', 'PATIENT', 'john.doe@example.com', '$2a$12$etvYOkX69p38LEQC9t55keuFwU2t4BNeG53hgCNRTs1Axk3hz6tZW'),
   ('Jane', 'Smith', 'PATIENT', 'jane.smith@example.com', '$2a$12$t1bDoNfegGdBx1PyUPNolOlwE73lhS8hlXeIvZUJ1RODkGFM8XsGS'),
   ('Michael', 'Johnson', 'PATIENT', 'michael.johnson@example.com', '$2a$12$t1bDoNfegGdBx1PyUPNolOlwE73lhS8hlXeIvZUJ1RODkGFM8XsGS'),
   ('Sophia', 'Martinez', 'PATIENT', 'sophia.martinez@example.com', '$2a$12$t1bDoNfegGdBx1PyUPNolOlwE73lhS8hlXeIvZUJ1RODkGFM8XsGS'),
   ('Daniel', 'Garcia', 'PATIENT', 'daniel.garcia@example.com', '$2a$12$t1bDoNfegGdBx1PyUPNolOlwE73lhS8hlXeIvZUJ1RODkGFM8XsGS'),
   ('Emma', 'Davis', 'PATIENT', 'emma.davis@example.com', '$2a$12$t1bDoNfegGdBx1PyUPNolOlwE73lhS8hlXeIvZUJ1RODkGFM8XsGS'),
   ('James', 'Martinez', 'PATIENT', 'james.martinez@example.com', '$2a$12$t1bDoNfegGdBx1PyUPNolOlwE73lhS8hlXeIvZUJ1RODkGFM8XsGS'),
   ('Isabella', 'Rodriguez', 'PATIENT', 'isabella.rodriguez@example.com', '$2a$12$t1bDoNfegGdBx1PyUPNolOlwE73lhS8hlXeIvZUJ1RODkGFM8XsGS'),
   ('Benjamin', 'Lopez', 'PATIENT', 'benjamin.lopez@example.com', '$2a$12$t1bDoNfegGdBx1PyUPNolOlwE73lhS8hlXeIvZUJ1RODkGFM8XsGS'),
   ('Mia', 'Gonzalez', 'PATIENT', 'mia.gonzalez@example.com', '$2a$12$t1bDoNfegGdBx1PyUPNolOlwE73lhS8hlXeIvZUJ1RODkGFM8XsGS');

-- --- Patient ---
INSERT INTO patient (birthdate, city, gender, address, phone_number, user_id) VALUES
    ('1990-01-01', 'New York', 'Male', '123 Main St', '123456789', (SELECT id FROM users WHERE email='john.doe@example.com')),
    ('1985-05-15', 'Los Angeles', 'Female', '456 Elm St', '987654321', (SELECT id FROM users WHERE email='jane.smith@example.com')),
    ('1988-08-20', 'Chicago', 'Male', '789 Oak St', '456123789', (SELECT id FROM users WHERE email='michael.johnson@example.com')),
    ('1992-12-05', 'Houston', 'Female', '321 Pine St', '987123654', (SELECT id FROM users WHERE email='sophia.martinez@example.com')),
    ('1978-03-10', 'Miami', 'Male', '654 Maple St', '321987654', (SELECT id FROM users WHERE email='daniel.garcia@example.com')),
    ('1982-06-25', 'Denver', 'Female', '987 Birch St', '654789123', (SELECT id FROM users WHERE email='emma.davis@example.com')),
    ('1975-09-30', 'Seattle', 'Male', '147 Walnut St', '987654123', (SELECT id FROM users WHERE email='james.martinez@example.com')),
    ('1995-11-12', 'Boston', 'Female', '258 Cedar St', '123987456', (SELECT id FROM users WHERE email='isabella.rodriguez@example.com')),
    ('1989-04-18', 'San Francisco', 'Male', '369 Elm St', '789654321', (SELECT id FROM users WHERE email='benjamin.lopez@example.com')),
    ('1987-07-07', 'Phoenix', 'Female', '741 Oak St', '456789123', (SELECT id FROM users WHERE email='mia.gonzalez@example.com'));

-- --- Doctor ---
INSERT INTO doctor (specialization, user_id) VALUES
     ('Dentist', (SELECT id FROM users WHERE email='emily.williams@example.com')),
     ('Orthodontist', (SELECT id FROM users WHERE email='david.brown@example.com')),
     ('Surgeon', (SELECT id FROM users WHERE email='jessica.jones@example.com')),
     ('Endodontist', (SELECT id FROM users WHERE email='mark.wilson@example.com')),
     ('Periodontist', (SELECT id FROM users WHERE email='laura.moore@example.com'));
-- --- Product ---
INSERT INTO product (product_name, description, unit_price, quantity_available) VALUES
     ('Dental Floss', 'Waxed dental floss, mint flavor', 150, 10),
     ('Toothpaste', 'Fluoride toothpaste for sensitive teeth', 300, 5),
     ('Mouthwash', 'Antiseptic mouthwash', 200, 8),
     ('Toothbrush', 'Soft-bristle toothbrush', 500, 3),
     ('Dental Picks', 'Disposable dental picks',  100, 15);

-- --- Appointment ---
INSERT INTO appointment (appointment_date_time, doctor_id, patient_id) VALUES
    (NOW() + INTERVAL '1 day', (SELECT d.id FROM doctor d JOIN "users" u ON d.user_id = u.id WHERE u.email='emily.williams@example.com'),
    (SELECT p.id FROM patient p JOIN "users" u ON p.user_id = u.id WHERE u.email='john.doe@example.com')),

    (NOW() + INTERVAL '2 day', (SELECT d.id FROM doctor d JOIN "users" u ON d.user_id = u.id WHERE u.email='david.brown@example.com'),
    (SELECT p.id FROM patient p JOIN "users" u ON p.user_id = u.id WHERE u.email='jane.smith@example.com')),

    (NOW() + INTERVAL '3 day', (SELECT d.id FROM doctor d JOIN "users" u ON d.user_id = u.id WHERE u.email='jessica.jones@example.com'),
    (SELECT p.id FROM patient p JOIN "users" u ON p.user_id = u.id WHERE u.email='michael.johnson@example.com')),

    (NOW() + INTERVAL '4 day', (SELECT d.id FROM doctor d JOIN "users" u ON d.user_id = u.id WHERE u.email='mark.wilson@example.com'),
    (SELECT p.id FROM patient p JOIN "users" u ON p.user_id = u.id WHERE u.email='sophia.martinez@example.com')),

    (NOW() + INTERVAL '5 day', (SELECT d.id FROM doctor d JOIN "users" u ON d.user_id = u.id WHERE u.email='laura.moore@example.com'),
    (SELECT p.id FROM patient p JOIN "users" u ON p.user_id = u.id WHERE u.email='daniel.garcia@example.com'));

-- --- Orders ---
INSERT INTO orders (order_date_time, quantity_ordered, product_id, user_id, is_order_canceled, is_order_confirmed) VALUES
   (NOW() - INTERVAL '1 day', 30, (SELECT id FROM product WHERE product_name='Dental Floss'), (SELECT id FROM users WHERE email='john.doe@example.com'), false, false),
   (NOW() - INTERVAL '2 day', 50, (SELECT id FROM product WHERE product_name='Toothpaste'), (SELECT id FROM users WHERE email='jane.smith@example.com'), false, false),
   (NOW() - INTERVAL '3 day', 20, (SELECT id FROM product WHERE product_name='Mouthwash'), (SELECT id FROM users WHERE email='michael.johnson@example.com'), false, false),
   (NOW() - INTERVAL '4 day', 60, (SELECT id FROM product WHERE product_name='Toothbrush'), (SELECT id FROM users WHERE email='sophia.martinez@example.com'), false, false),
   (NOW() - INTERVAL '5 day', 10, (SELECT id FROM product WHERE product_name='Dental Picks'), (SELECT id FROM users WHERE email='daniel.garcia@example.com'), false, false);
