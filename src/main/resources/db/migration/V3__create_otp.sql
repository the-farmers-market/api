CREATE TABLE otp_verifications (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    phone VARCHAR(20),
    email VARCHAR(255),
    country VARCHAR(10),
    otp_code VARCHAR(10) NOT NULL,
    purpose VARCHAR(50) NOT NULL,
    is_verified BOOLEAN NOT NULL DEFAULT FALSE,
    expires_at TIMESTAMP NOT NULL,
    attempts INTEGER NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX idx_otp_phone ON otp_verifications(phone, purpose);
CREATE INDEX idx_otp_email ON otp_verifications(email, purpose);
