-- Clearing the existing data
DELETE FROM review_images;
DELETE FROM review_vote;
DELETE FROM reviews;
DELETE FROM product_images;
DELETE FROM products;
DELETE FROM categories;
DELETE FROM brands;
DELETE FROM brands;
DELETE FROM blacklist;
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
    (2, 'testUser', 'testuser@example.com', 'password456', 'Test', 'User', NULL, NULL, NOW(), false),
    (3, 'testBlacklistedUser', 'testblacklisted@example.com', 'password456', 'Test', 'Blacklisted', NULL, NULL, NOW(), false),
    (4, 'testNotYetBlacklistedUser', 'testnotblacklisted@example.com', 'password456', 'Not', 'Blacklisted', NULL, NULL, NOW(), false);

-- Associating users with roles
INSERT INTO users_roles (user_id, role_id) VALUES (1, 3);  -- ADMIN role
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);  -- USER role
INSERT INTO users_roles (user_id, role_id) VALUES (2, 1);  -- USER role
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);  -- MODERATOR role
INSERT INTO users_roles (user_id, role_id) VALUES (3, 1);  -- USER role
INSERT INTO users_roles (user_id, role_id) VALUES (4, 1);  -- USER role

-- Inserting addresses for testAdmin
INSERT INTO address (name, address_line_1, address_line_2, city, country, zipcode, user_id) VALUES
    ('Home', '123 Main St', NULL, 'Springfield', 'USA', '12345', 1),
    ('Work', '456 Corporate Blvd', 'Suite 100', 'Metropolis', 'USA', '67890', 1),
    ('Vacation Home', '789 Ocean Dr', NULL, 'Miami', 'USA', '54321', 1);

-- Blacklist the user `testBlacklistedUser`
INSERT INTO blacklist (user_id, reason, timestamp)
SELECT id, 'Violation of terms of service', NOW()
FROM users
WHERE username = 'testBlacklistedUser';

INSERT INTO categories (id, name, image_url) VALUES
    (1, 'Smartphones', 'https://example.com/image1.jpg');

INSERT INTO brands (id, name) VALUES
    (1, 'Apple');

INSERT INTO products (id, name, original_price, category_id, brand_id, stock, description)
VALUES
    (1, 'iPhone 14 Pro', 999.99, 1, 1, 100, 'The iPhone 14 Pro offers advanced features including a powerful A16 Bionic chip and ProMotion display.');

INSERT INTO product_images (id, product_id, image_url, is_primary)
VALUES
    (1, 1, 'https://example.com/image1.jpg', true);

INSERT INTO reviews (id, comment, downvote_count, product_id, product_rating, timestamp, upvote_count, user_id)
VALUES (10, 'Good product!', 2, 1, 4, NOW(), 3, 1),
       (11, 'Terrible!', 4, 1, 1, NOW(), 0, 2);

INSERT INTO review_images (id, image_url, public_id, review_id)
VALUES (10, 'https://res.cloudinary.com/dztiecgdt/image/upload/v1724228314/project/reviews/1/phrx15rdk0qru9e0sjbs.png', 'project/reviews/1/phrx15rdk0qru9e0sjbs', 11);

INSERT INTO review_vote (id, is_upvote, review_id, user_id)
VALUES
    (5, FALSE, 10, 2),
    (6, FALSE, 11, 1);
