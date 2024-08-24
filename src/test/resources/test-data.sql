-- Clearing the existing data
DELETE FROM wishlist_product;
DELETE FROM wishlist;
DELETE FROM cart_item;
DELETE FROM cart;
DELETE FROM review_images;
DELETE FROM review_vote;
DELETE FROM reviews;
DELETE FROM product_images;
DELETE FROM smartphones;
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
    (1, 'testAdmin', 'testadmin@example.com', 'testPassword1.', 'Test', 'Admin', NULL, NULL, NOW(), true),
    (2, 'testUser', 'testuser@example.com', 'testPassword1.', 'Test', 'User', NULL, NULL, NOW(), false),
    (3, 'testBlacklistedUser', 'testblacklisted@example.com', 'testPassword1.', 'Test', 'Blacklisted', NULL, NULL, NOW(), false),
    (4, 'testNotYetBlacklistedUser', 'testnotblacklisted@example.com', 'testPassword1.', 'Not', 'Blacklisted', NULL, NULL, NOW(), true);

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

INSERT INTO categories (id, name, image_url, parent_id) VALUES
    (1, 'Smartphones', 'https://example.com/image1.jpg', null);

INSERT INTO brands (id, name) VALUES
    (1, 'Apple');

INSERT INTO products (id, name, original_price, category_id, brand_id, stock, description, discount)
VALUES
    (1, 'iPhone 14 Pro', 999.99, 1, 1, 100, 'The iPhone 14 Pro offers advanced features including a powerful A16 Bionic chip and ProMotion display.', null),
    (2, 'iPhone 15 Pro', 999.99, 1, 1, 100, 'Test description.', 10.00);

INSERT INTO smartphones (id, screen_size, screen_resolution, ram, storage, battery_capacity, front_camera, rear_camera, refresh_rate, color, operating_system, year_of_release) VALUES
    (1, '6.1 inches', '2556 x 1179 pixels', '8 GB', '128 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 'iOS', 2022),
    (2, '6.1 inches', '2556 x 1179 pixels', '8 GB', '128 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2023);

INSERT INTO product_images (id, product_id, image_url, is_primary)
VALUES
    (1, 1, 'https://example.com/image1.jpg', true),
    (2, 2, 'https://example.com/image2.jpg', true);

INSERT INTO reviews (id, comment, downvote_count, product_id, product_rating, timestamp, upvote_count, user_id)
VALUES (10, 'Good product!', 2, 1, 4, NOW(), 3, 1),
       (11, 'Terrible!', 4, 1, 1, NOW(), 0, 2);

INSERT INTO review_images (id, image_url, public_id, review_id)
VALUES (10, 'https://res.cloudinary.com/dztiecgdt/image/upload/v1724228314/project/reviews/1/phrx15rdk0qru9e0sjbs.png', 'project/reviews/1/phrx15rdk0qru9e0sjbs', 11);

INSERT INTO review_vote (id, is_upvote, review_id, user_id)
VALUES
    (5, FALSE, 10, 2),
    (6, FALSE, 11, 1);

INSERT INTO cart (id, anonymous_id, updated_at, user_id)
VALUES
    (11, null, NOW(), 2);

INSERT INTO cart_item (id, quantity, total_price, cart_id, product_id)
VALUES
    (100, 3, 2999.97, 11, 1);

INSERT INTO wishlist (id, name, user_id)
VALUES
    (1, 'Test user wishlist', 2),
    (2, 'Test admin wishlist', 1);

INSERT INTO wishlist_product (wishlist_id, product_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 1);