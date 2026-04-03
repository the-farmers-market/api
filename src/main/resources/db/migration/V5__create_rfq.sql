CREATE TABLE rfqs (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    buyer_id UUID NOT NULL REFERENCES users(id),
    product_id UUID NOT NULL REFERENCES products(id),
    quantity INTEGER NOT NULL,
    desired_price DECIMAL(12,2),
    delivery_date DATE,
    delivery_location TEXT,
    notes TEXT,
    status VARCHAR(20) NOT NULL DEFAULT 'OPEN',
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE quotes (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    rfq_id UUID NOT NULL REFERENCES rfqs(id),
    seller_id UUID NOT NULL REFERENCES users(id),
    price_per_unit DECIMAL(12,2) NOT NULL,
    total_price DECIMAL(12,2) NOT NULL,
    valid_until TIMESTAMP,
    notes TEXT,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX idx_rfqs_buyer ON rfqs(buyer_id);
CREATE INDEX idx_rfqs_product ON rfqs(product_id);
CREATE INDEX idx_quotes_rfq ON quotes(rfq_id);
CREATE INDEX idx_quotes_seller ON quotes(seller_id);
