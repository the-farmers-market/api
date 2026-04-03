-- Seed roles
INSERT INTO roles (id, name, description) VALUES
    (uuid_generate_v4(), 'ADMIN', 'Platform administrator'),
    (uuid_generate_v4(), 'BUYER', 'Wholesaler or retailer'),
    (uuid_generate_v4(), 'SELLER', 'Farmer or producer'),
    (uuid_generate_v4(), 'LOGISTICS', 'Delivery and transport partner'),
    (uuid_generate_v4(), 'LABOUR', 'Agricultural labourer');

-- Seed permissions
INSERT INTO permissions (id, name, description) VALUES
    (uuid_generate_v4(), 'USER_CREATE', 'Create users'),
    (uuid_generate_v4(), 'USER_READ', 'Read user details'),
    (uuid_generate_v4(), 'USER_UPDATE', 'Update user details'),
    (uuid_generate_v4(), 'USER_DELETE', 'Delete users'),
    (uuid_generate_v4(), 'PRODUCT_CREATE', 'Create products'),
    (uuid_generate_v4(), 'PRODUCT_APPROVE', 'Approve or reject products'),
    (uuid_generate_v4(), 'RFQ_CREATE', 'Create RFQs'),
    (uuid_generate_v4(), 'QUOTE_CREATE', 'Create quotes'),
    (uuid_generate_v4(), 'ORDER_CREATE', 'Create orders'),
    (uuid_generate_v4(), 'ORDER_MANAGE', 'Manage all orders'),
    (uuid_generate_v4(), 'DELIVERY_MANAGE', 'Manage deliveries'),
    (uuid_generate_v4(), 'LABOUR_BOOK', 'Book labour'),
    (uuid_generate_v4(), 'ADMIN_ALL', 'Full admin access');
