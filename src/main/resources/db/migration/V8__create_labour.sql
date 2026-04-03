CREATE TABLE labour_profiles (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id UUID NOT NULL UNIQUE REFERENCES users(id),
    skills TEXT,
    experience_years INTEGER,
    daily_rate DECIMAL(10,2),
    availability_status VARCHAR(20) NOT NULL DEFAULT 'AVAILABLE',
    service_area VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE labour_bookings (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    labour_id UUID NOT NULL REFERENCES labour_profiles(id),
    booked_by UUID NOT NULL REFERENCES users(id),
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    total_cost DECIMAL(10,2),
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    notes TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX idx_labour_bookings_labour ON labour_bookings(labour_id);
CREATE INDEX idx_labour_bookings_booked_by ON labour_bookings(booked_by);
