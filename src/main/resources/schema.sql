CREATE TABLE IF NOT EXISTS transfusion_requests (
    id BIGSERIAL PRIMARY KEY,
    patient_id BIGINT NOT NULL,
    blood_type VARCHAR(10) NOT NULL,
    location VARCHAR(255),
    status VARCHAR(50) NOT NULL,
    request_timestamp TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS donation_schedules (
    id BIGSERIAL PRIMARY KEY,
    donor_id BIGINT NOT NULL,
    blood_type VARCHAR(10) NOT NULL,
    location VARCHAR(255),
    availability_date TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL
);