-- Clearing the existing data
DELETE FROM users_roles;
DELETE FROM address;
DELETE FROM users;
DELETE FROM roles;

-- Inserting roles
INSERT INTO roles (id, role) VALUES (1, 'USER');
INSERT INTO roles (id, role) VALUES (2, 'MODERATOR');
INSERT INTO roles (id, role) VALUES (3, 'ADMIN');

-- Inserting users
INSERT INTO users (id, username, email_address, password, first_name, last_name, profile_image_url, public_id, created_at, is_subscribed)
VALUES
    (1, 'testAdmin', 'testadmin@example.com', 'password123', 'Test', 'Admin', 'https://example.com/profile/testadmin.jpg', 'cloudinary123', NOW(), true),
    (2, 'testUser', 'testuser@example.com', 'password456', 'Test', 'User', NULL, NULL, NOW(), false);

-- Associating users with roles
INSERT INTO users_roles (user_id, role_id) VALUES (1, 3);  -- ADMIN role
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);  -- USER role
INSERT INTO users_roles (user_id, role_id) VALUES (2, 1);  -- USER role

-- Inserting addresses for testAdmin
INSERT INTO address (name, address_line_1, address_line_2, city, country, zipcode, user_id) VALUES
    ('Home', '123 Main St', NULL, 'Springfield', 'USA', '12345', 1),
    ('Work', '456 Corporate Blvd', 'Suite 100', 'Metropolis', 'USA', '67890', 1),
    ('Vacation Home', '789 Ocean Dr', NULL, 'Miami', 'USA', '54321', 1);
