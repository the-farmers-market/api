CREATE TABLE deliveries (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    order_id UUID NOT NULL REFERENCES orders(id),
    partner_id UUID REFERENCES users(id),
    pickup_address TEXT,
    delivery_address TEXT,
    status VARCHAR(20) NOT NULL DEFAULT 'ASSIGNED',
    estimated_delivery TIMESTAMP,
    actual_delivery TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE delivery_tracking (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    delivery_id UUID NOT NULL REFERENCES deliveries(id),
    status VARCHAR(20) NOT NULL,
    location_lat DECIMAL(10,7),
    location_lng DECIMAL(10,7),
    notes TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX idx_deliveries_order ON deliveries(order_id);
CREATE INDEX idx_deliveries_partner ON deliveries(partner_id);
