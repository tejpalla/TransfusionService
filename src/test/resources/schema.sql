-- H2-compatible schema for testing
CREATE TABLE IF NOT EXISTS transfusion_requests (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    patient_id BIGINT NOT NULL,
    blood_type VARCHAR(10) NOT NULL,
    location_lat DECIMAL(10, 8), -- Latitude with precision for GPS coordinates
    location_lng DECIMAL(11, 8), -- Longitude with precision for GPS coordinates
    location_description TEXT, -- Human-readable location description
    status VARCHAR(50) NOT NULL DEFAULT 'PENDING',
    request_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    priority VARCHAR(20) NOT NULL DEFAULT 'NORMAL',
    medical_notes TEXT,
    hospital_id BIGINT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Enhanced donation schedules table with proper location support
CREATE TABLE IF NOT EXISTS donation_schedules (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    donor_id BIGINT NOT NULL,
    blood_type VARCHAR(10) NOT NULL,
    location_lat DECIMAL(10, 8), -- Latitude with precision for GPS coordinates
    location_lng DECIMAL(11, 8), -- Longitude with precision for GPS coordinates
    location_description TEXT, -- Human-readable location description
    availability_date TIMESTAMP NOT NULL,
    availability_end_date TIMESTAMP, -- End of availability window
    status VARCHAR(50) NOT NULL DEFAULT 'AVAILABLE',
    notes TEXT,
    organization_id BIGINT, -- Hospital/Blood bank where donation occurs
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Indexes for better performance
CREATE INDEX IF NOT EXISTS idx_transfusion_requests_patient_id ON transfusion_requests(patient_id);
CREATE INDEX IF NOT EXISTS idx_transfusion_requests_blood_type ON transfusion_requests(blood_type);
CREATE INDEX IF NOT EXISTS idx_transfusion_requests_status ON transfusion_requests(status);
CREATE INDEX IF NOT EXISTS idx_transfusion_requests_location ON transfusion_requests(location_lat, location_lng);

CREATE INDEX IF NOT EXISTS idx_donation_schedules_donor_id ON donation_schedules(donor_id);
CREATE INDEX IF NOT EXISTS idx_donation_schedules_blood_type ON donation_schedules(blood_type);
CREATE INDEX IF NOT EXISTS idx_donation_schedules_status ON donation_schedules(status);
CREATE INDEX IF NOT EXISTS idx_donation_schedules_availability ON donation_schedules(availability_date);
CREATE INDEX IF NOT EXISTS idx_donation_schedules_location ON donation_schedules(location_lat, location_lng);

-- Note: H2 doesn't support PostgreSQL-style triggers, so we skip the update triggers for testing
