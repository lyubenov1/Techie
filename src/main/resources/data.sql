INSERT INTO brands (name, description, logo_url) VALUES
('Apple', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716235711/Brands/Apple_ticin6.jpg'),
('Samsung', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716235727/Brands/Samsung_eiuffz.jpg'),
('Google', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716235779/Brands/Google_vg5dns.jpg'),
('Huawei', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716479405/Brands/Huawei_srbchz.jpg'),
('Acer', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716235704/Brands/Acer_p2ylhp.jpg'),
('Dell', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716235712/Brands/Dell_wgfrfy.jpg'),
('HP', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716235719/Brands/HP_ghu0sb.jpg'),
('Lenovo', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716235723/Brands/Lenovo_bfkgdj.jpg'),
('Nothing', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716274386/Brands/Nothing_st5njk.png'),
('Anker', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716284560/Brands/Anker_ywdwjt.png'),
('Energizer', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716286327/Brands/Energizer_joeqac.png'),
('Insignia', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716285787/Brands/Insignia_fepyeh.jpg'),
('JBL', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716289647/Brands/Jbl_y5uwm3.png'),
('Cellularline', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716289156/Brands/Cellularline_ouu025.jpg');

INSERT INTO brands (name) VALUES
('Native Union');

INSERT INTO brands (name, description, logo_url) VALUES
('Bose', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716235715/Brands/Bose_e7j7il.jpg');


INSERT INTO categories (name, image_url, parent_id) VALUES
('Laptops', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716233519/Categories/Laptops.jpg', NULL),
('Smartphones', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716220466/Categories/Smartphones.jpg', NULL),
('Tablets', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716233290/Categories/Tablets.jpg', NULL),
('Accessories', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716331140/Categories/Accessories_iosn6f.jpg', NULL),
('Cables', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716234373/Categories/Cables.jpg', 4),
('Chargers', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716234100/Categories/Chargers.jpg', 4),
('Earbuds', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716234093/Categories/Earbuds.jpg', 4),
('Powerbanks', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716233753/Categories/Powerbanks.jpg', 4);

-- Smartphones

INSERT INTO products (name, original_price, category_id, brand_id, stock, description) VALUES
('Apple - iPhone 15 Pro 128GB - Black Titanium', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 128GB - White Titanium', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 128GB - Blue Titanium', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 128GB - Natural Titanium', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 256GB - Black Titanium', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 256GB - White Titanium', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 256GB - Blue Titanium', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 256GB - Natural Titanium', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 512GB - Black Titanium', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 512GB - White Titanium', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 512GB - Blue Titanium', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 512GB - Natural Titanium', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 1TB - Black Titanium', 1499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 1TB - White Titanium', 1499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 1TB - Blue Titanium', 1499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 1TB - Natural Titanium', 1499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 256GB - Black Titanium', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 256GB - White Titanium', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 256GB - Blue Titanium', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 256GB - Natural Titanium', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 512GB - Black Titanium', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 512GB - White Titanium', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 512GB - Blue Titanium', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 512GB - Natural Titanium', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 1TB - Black Titanium', 1599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 1TB - White Titanium', 1599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 1TB - Blue Titanium', 1599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 1TB - Natural Titanium', 1599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 128GB - Black', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 128GB - Yellow', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 128GB - Blue', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 128GB - Pink', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 128GB - Green', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 256GB - Black', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 256GB - Yellow', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 256GB - Blue', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 256GB - Pink', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 256GB - Green', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 512GB - Black', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 512GB - Yellow', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 512GB - Blue', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 512GB - Pink', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 512GB - Green', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 128GB - Black', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 128GB - Yellow', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 128GB - Blue', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 128GB - Pink', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 128GB - Green', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 256GB - Black', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 256GB - Yellow', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 256GB - Blue', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 256GB - Pink', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 256GB - Green', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 512GB - Black', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 512GB - Yellow', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 512GB - Blue', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 512GB - Pink', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 512GB - Green', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone SE (3rd generation) 64GB - Starlight', 429.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone SE (3rd generation) 64GB - Product Red', 429.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone SE (3rd generation) 64GB - Midnight', 429.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone SE (3rd generation) 128GB - Starlight', 479.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone SE (3rd generation) 128GB - Product Red', 479.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone SE (3rd generation) 128GB - Midnight', 479.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone SE (3rd generation) 256GB - Starlight', 579.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone SE (3rd generation) 256GB - Product Red', 579.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone SE (3rd generation) 256GB - Midnight', 579.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 128GB - Space Black', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 128GB - Silver', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 128GB - Gold', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 128GB - Deep Purple', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 256GB - Space Black', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 256GB - Silver', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 256GB - Gold', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 256GB - Deep Purple', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 512GB - Space Black', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 512GB - Silver', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 512GB - Gold', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 512GB - Deep Purple', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 1TB - Space Black', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 1TB - Silver', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 1TB - Gold', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 1TB - Deep Purple', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 128GB - Space Black', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 128GB - Silver', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 128GB - Gold', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 128GB - Deep Purple', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 256GB - Space Black', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 256GB - Silver', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 256GB - Gold', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 256GB - Deep Purple', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 512GB - Space Black', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 512GB - Silver', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 512GB - Gold', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 512GB - Deep Purple', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 1TB - Space Black', 1499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 1TB - Silver', 1499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 1TB - Gold', 1499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 1TB - Deep Purple', 1499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 128GB - Midnight', 699.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 128GB - Blue', 699.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 128GB - Starlight', 699.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 128GB - Purple', 699.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 256GB - Midnight', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 256GB - Blue', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 256GB - Starlight', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 256GB - Purple', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 512GB - Midnight', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 512GB - Blue', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 512GB - Starlight', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 512GB - Purple', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 128GB - Midnight', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 128GB - Blue', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 128GB - Starlight', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 128GB - Purple', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 256GB - Midnight', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 256GB - Blue', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 256GB - Starlight', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 256GB - Purple', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 512GB - Midnight', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 512GB - Blue', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 512GB - Starlight', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 512GB - Purple', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 128GB - Sierra Blue', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 128GB - Graphite', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 128GB - Silver', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 128GB - Gold', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 256GB - Sierra Blue', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 256GB - Graphite', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 256GB - Silver', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 256GB - Gold', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 512GB - Sierra Blue', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 512GB - Graphite', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 512GB - Silver', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 512GB - Gold', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 1TB - Sierra Blue', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 1TB - Graphite', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 1TB - Silver', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 1TB - Gold', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 128GB - Sierra Blue', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 128GB - Graphite', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 128GB - Silver', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 128GB - Gold', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 256GB - Sierra Blue', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 256GB - Graphite', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 256GB - Silver', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 256GB - Gold', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 512GB - Sierra Blue', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 512GB - Graphite', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 512GB - Silver', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 512GB - Gold', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 1TB - Sierra Blue', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 1TB - Graphite', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 1TB - Silver', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 1TB - Gold', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 128GB - Starlight', 599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 128GB - Midnight', 599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 128GB - Blue', 599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 128GB - Green', 599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 256GB - Starlight', 699.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 256GB - Midnight', 699.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 256GB - Blue', 699.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 256GB - Green', 699.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 512GB - Starlight', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 512GB - Midnight', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 512GB - Blue', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 512GB - Green', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 128GB - Starlight', 499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 128GB - Midnight', 499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 128GB - Blue', 499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 128GB - Green', 499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 256GB - Starlight', 599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 256GB - Midnight', 599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 256GB - Blue', 599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 256GB - Green', 599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 512GB - Starlight', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 512GB - Midnight', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 512GB - Blue', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 512GB - Green', 799.00, 2, 1, 50, 'dummy description'),
('Samsung - Galaxy A55 - 8GB RAM 128GB - IceBlue', 399.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy A55 - 8GB RAM 256GB - IceBlue', 449.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy A55 - 12GB RAM 256GB - IceBlue', 499.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy A55 - 8GB RAM 128GB - Lilac', 399.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy A55 - 8GB RAM 256GB - Lilac', 449.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy A55 - 12GB RAM 256GB - Lilac', 499.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy A55 - 8GB RAM 128GB - Navy', 399.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy A55 - 8GB RAM 256GB - Navy', 449.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy A55 - 12GB RAM 256GB - Navy', 499.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy A55 - 8GB RAM 128GB - Lemon', 399.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy A55 - 8GB RAM 256GB - Lemon', 449.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy A55 - 12GB RAM 256GB - Lemon', 499.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy Z FLIP 5 - 256GB - Mint', 999.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy Z FLIP 5 - 256GB - Cream', 999.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy Z FLIP 5 - 256GB - Lavender', 999.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy Z FLIP 5 - 256GB - Graphite', 999.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy Z FLIP 5 - 512GB - Mint', 1119.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy Z FLIP 5 - 512GB - Cream', 1119.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy Z FLIP 5 - 512GB - Lavender', 1119.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy Z FLIP 5 - 512GB - Graphite', 1119.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy Z FOLD 5 - 256GB - Icy Blue', 1799.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy Z FOLD 5 - 256GB - Cream', 1799.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy Z FOLD 5 - 256GB - Phantom Black', 1799.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy Z FOLD 5 - 512GB - Icy Blue', 1919.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy Z FOLD 5 - 512GB - Cream', 1919.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy Z FOLD 5 - 512GB - Phantom Black', 1919.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy Z FOLD 5 - 1TB - Icy Blue', 2159.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy Z FOLD 5 - 1TB - Cream', 2159.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy Z FOLD 5 - 1TB - Phantom Black', 2159.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 Ultra - 256GB - Titanium Black', 1299.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 Ultra - 256GB - Titanium Gray', 1299.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 Ultra - 256GB - Titanium Violet', 1299.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 Ultra - 256GB - Titanium Yellow', 1299.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 Ultra - 512GB - Titanium Black', 1419.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 Ultra - 512GB - Titanium Gray', 1419.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 Ultra - 512GB - Titanium Violet', 1419.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 Ultra - 512GB - Titanium Yellow', 1419.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 Ultra - 1TB - Titanium Black', 1659.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 Ultra - 1TB - Titanium Gray', 1659.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 Ultra - 1TB - Titanium Violet', 1659.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 Ultra - 1TB - Titanium Yellow', 1659.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 - 128GB - Onyx Black', 799.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 - 128GB - Marble Grey', 799.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 - 128GB - Cobalt Violet', 799.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 - 128GB - Amber Yellow', 799.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 - 256GB - Onyx Black', 859.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 - 256GB - Marble Grey', 859.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 - 256GB - Cobalt Violet', 859.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 - 256GB - Amber Yellow', 859.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 - 512GB - Onyx Black', 999.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 - 512GB - Marble Grey', 999.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 - 512GB - Cobalt Violet', 999.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24 - 512GB - Amber Yellow', 999.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24+ - 256GB - Onyx Black', 999.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24+ - 256GB - Marble Grey', 999.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24+ - 256GB - Cobalt Violet', 999.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24+ - 256GB - Amber Yellow', 999.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24+ - 512GB - Onyx Black', 1119.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24+ - 512GB - Marble Grey', 1119.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24+ - 512GB - Cobalt Violet', 1119.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S24+ - 512GB - Amber Yellow', 1119.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23 - 128GB - Phantom Black', 699.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23 - 128GB - Graphite', 699.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23 - 128GB - Green', 699.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23 - 128GB - Cream', 699.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23 - 256GB - Phantom Black', 759.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23 - 256GB - Graphite', 759.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23 - 256GB - Green', 759.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23 - 256GB - Cream', 759.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23 - 512GB - Phantom Black', 899.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23 - 512GB - Graphite', 899.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23 - 512GB - Green', 899.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23 - 512GB - Cream', 899.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23+ - 256GB - Phantom Black', 899.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23+ - 256GB - Graphite', 899.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23+ - 256GB - Green', 899.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23+ - 256GB - Cream', 899.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23+ - 512GB - Phantom Black', 1019.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23+ - 512GB - Graphite', 1019.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23+ - 512GB - Green', 1019.00, 2, 2, 50, 'dummy description'),
('Samsung - Galaxy S23+ - 512GB - Cream', 1019.00, 2, 2, 50, 'dummy description'),
('Huawei - Nova 10 SE - 128GB 6GB RAM - Starry Black', 229.00, 2, 4, 50, 'dummy description'),
('Huawei - Nova 10 SE - 128GB 6GB RAM - Starry Silver', 229.00, 2, 4, 50, 'dummy description'),
('Huawei - Nova 10 SE - 128GB 8GB RAM - Starry Black', 249.00, 2, 4, 50, 'dummy description'),
('Huawei - Nova 10 SE - 128GB 8GB RAM - Starry Silver', 249.00, 2, 4, 50, 'dummy description'),
('Huawei - Nova 10 SE - 256GB 8GB RAM - Starry Black', 309.00, 2, 4, 50, 'dummy description'),
('Huawei - Nova 10 SE - 256GB 8GB RAM - Starry Silver', 309.00, 2, 4, 50, 'dummy description'),
('Huawei - Nova 12 SE - 256GB 8GB RAM - Green', 429.00, 2, 4, 50, 'dummy description'),
('Huawei - Nova Y91 - 128GB 6GB RAM - Moonlight Silver', 279.00, 2, 4, 50, 'dummy description'),
('Huawei - Nova Y91 - 128GB 8GB RAM - Moonlight Silver', 309.00, 2, 4, 50, 'dummy description'),
('Huawei - Nova Y91 - 256GB 8GB RAM - Moonlight Silver', 379.00, 2, 4, 50, 'dummy description'),
('Huawei - Pura 70 - 256GB - Black', 979.00, 2, 4, 50, 'dummy description'),
('Huawei - Pura 70 - 512GB - Black', 1079.00, 2, 4, 50, 'dummy description'),
('Huawei - Pura 70 - 1TB - Black', 1219.00, 2, 4, 50, 'dummy description'),
('Huawei - Pura 70 - 256GB - White', 979.00, 2, 4, 50, 'dummy description'),
('Huawei - Pura 70 - 512GB - White', 1079.00, 2, 4, 50, 'dummy description'),
('Huawei - Pura 70 - 1TB - White', 1219.00, 2, 4, 50, 'dummy description'),
('Huawei - Pura 70 Pro - 256GB - Black', 1129.00, 2, 4, 50, 'dummy description'),
('Huawei - Pura 70 Pro - 512GB - Black', 1229.00, 2, 4, 50, 'dummy description'),
('Huawei - Pura 70 Pro - 1TB - Black', 1349.00, 2, 4, 50, 'dummy description'),
('Huawei - Pura 70 Pro - 256GB - White', 1129.00, 2, 4, 50, 'dummy description'),
('Huawei - Pura 70 Pro - 512GB - White', 1229.00, 2, 4, 50, 'dummy description'),
('Huawei - Pura 70 Pro - 1TB - White', 1349.00, 2, 4, 50, 'dummy description'),
('Huawei - Pura 70 Ultra - 512GB - Black', 1579.00, 2, 4, 50, 'dummy description'),
('Huawei - Pura 70 Ultra - 1TB - Black', 1719.00, 2, 4, 50, 'dummy description'),
('Huawei - Pura 70 Ultra - 512GB - Green', 1579.00, 2, 4, 50, 'dummy description'),
('Huawei - Pura 70 Ultra - 1TB - Green', 1719.00, 2, 4, 50, 'dummy description'),
('Nothing - Phone (2) - 128GB 8GB RAM - Dark Gray', 600.00, 2, 9, 50, 'dummy description'),
('Nothing - Phone (2) - 256GB 12GB RAM - Dark Gray', 729.00, 2, 9, 50, 'dummy description'),
('Nothing - Phone (2) - 512GB 12GB RAM - Dark Gray', 849.00, 2, 9, 50, 'dummy description'),
('Nothing - Phone (2) - 128GB 8GB RAM - White', 600.00, 2, 9, 50, 'dummy description'),
('Nothing - Phone (2) - 256GB 12GB RAM - White', 729.00, 2, 9, 50, 'dummy description'),
('Nothing - Phone (2) - 512GB 12GB RAM - White', 849.00, 2, 9, 50, 'dummy description'),
('Nothing - Phone (2a) - 128GB 8GB RAM - Black', 389.00, 2, 9, 50, 'dummy description'),
('Nothing - Phone (2a) - 256GB 8GB RAM - Black', 469.00, 2, 9, 50, 'dummy description'),
('Nothing - Phone (2a) - 256GB 12GB RAM - Black', 499.00, 2, 9, 50, 'dummy description'),
('Nothing - Phone (2a) - 128GB 8GB RAM - White', 389.00, 2, 9, 50, 'dummy description'),
('Nothing - Phone (2a) - 256GB 8GB RAM - White', 469.00, 2, 9, 50, 'dummy description'),
('Nothing - Phone (2a) - 256GB 12GB RAM - White', 499.00, 2, 9, 50, 'dummy description'),
('Google - Pixel Fold - 256GB - Obsidian', 1799.00, 2, 3, 50, 'dummy description'),
('Google - Pixel Fold - 512GB - Obsidian', 1919.00, 2, 3, 50, 'dummy description'),
('Google - Pixel Fold - 256GB - Porcelain', 1799.00, 2, 3, 50, 'dummy description'),
('Google - Pixel Fold - 512GB - Porcelain', 1919.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 7a - 128GB - Charcoal', 499.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 7a - 128GB - Sea', 499.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 7a - 128GB - Snow', 499.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 7 - 128GB - Lemongrass', 579.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 7 - 256GB - Lemongrass', 679.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 7 - 128GB - Snow', 579.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 7 - 256GB - Snow', 679.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 7 Pro - 128GB 12GB RAM - Obsidian', 879.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 7 Pro - 256GB 12GB RAM - Obsidian', 979.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 7 Pro - 512GB 12GB RAM - Obsidian', 1079.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 7 Pro - 128GB 8GB RAM - Obsidian', 779.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 7 Pro - 256GB 8GB RAM - Obsidian', 819.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8 Pro - 128GB - Obsidian', 999.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8 Pro - 128GB - Porcelain', 999.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8 Pro - 128GB - Bay', 999.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8 Pro - 256GB - Obsidian', 1059.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8 Pro - 256GB - Porcelain', 1059.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8 Pro - 256GB - Bay', 1059.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8 Pro - 512GB - Obsidian', 1179.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8 Pro - 512GB - Porcelain', 1179.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8 Pro - 512GB - Bay', 1179.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8 Pro - 1TB - Obsidian', 1399.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8 Pro - 1TB - Porcelain', 1399.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8 Pro - 1TB - Bay', 1399.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8 - 128GB - Obsidian', 699.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8 - 128GB - Rose', 699.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8 - 256GB - Obsidian', 759.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8 - 256GB - Rose', 759.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8a - 128GB - Obsidian', 499.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8a - 256GB - Obsidian', 559.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8a - 128GB - Bay', 499.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8a - 256GB - Bay', 559.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8a - 128GB - Porcelain', 499.00, 2, 3, 50, 'dummy description'),
('Google - Pixel 8a - 256GB - Porcelain', 559.00, 2, 3, 50, 'dummy description'),


('Apple - iPad Pro 13" (2024) - 256GB - Space Black', 1299.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Pro 13" (2024) - 512GB - Space Black', 1499.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Pro 13" (2024) - 1TB - Space Black', 1899.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Pro 13" (2024) - 2TB - Space Black', 2299.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Pro 13" (2024) - 256GB - Silver', 1299.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Pro 13" (2024) - 512GB - Silver', 1499.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Pro 13" (2024) - 1TB - Silver', 1899.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Pro 13" (2024) - 2TB - Silver', 2299.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Pro 11" (2024) - 256GB - Space Black', 999.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Pro 11" (2024) - 512GB - Space Black', 1199.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Pro 11" (2024) - 1TB - Space Black', 1599.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Pro 11" (2024) - 2TB - Space Black', 1999.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Pro 11" (2024) - 256GB - Silver', 999.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Pro 11" (2024) - 512GB - Silver', 1199.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Pro 11" (2024) - 1TB - Silver', 1599.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Pro 11" (2024) - 2TB - Silver', 1999.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 13" (2024) - 128GB - Space Gray', 799.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 13" (2024) - 256GB - Space Gray', 899.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 13" (2024) - 512GB - Space Gray', 1099.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 13" (2024) - 1TB - Space Gray', 1299.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 13" (2024) - 128GB - Purple', 799.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 13" (2024) - 256GB - Purple', 899.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 13" (2024) - 512GB - Purple', 1099.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 13" (2024) - 1TB - Purple', 1299.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 13" (2024) - 128GB - Starlight', 799.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 13" (2024) - 256GB - Starlight', 899.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 13" (2024) - 512GB - Starlight', 1099.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 13" (2024) - 1TB - Starlight', 1299.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 11" (2024) - 128GB - Space Gray', 599.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 11" (2024) - 256GB - Space Gray', 699.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 11" (2024) - 512GB - Space Gray', 899.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 11" (2024) - 1TB - Space Gray', 1099.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 11" (2024) - 128GB - Purple', 599.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 11" (2024) - 256GB - Purple', 699.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 11" (2024) - 512GB - Purple', 899.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 11" (2024) - 1TB - Purple', 1099.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 11" (2024) - 128GB - Starlight', 599.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 11" (2024) - 256GB - Starlight', 699.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 11" (2024) - 512GB - Starlight', 899.00, 3, 1, 50, 'dummy description'),
('Apple - iPad Air 11" (2024) - 1TB - Starlight', 1099.00, 3, 1, 50, 'dummy description'),
('Apple - iPad 10.9" (2022) - 64GB - Blue', 349.00, 3, 1, 50, 'dummy description'),
('Apple - iPad 10.9" (2022) - 256GB - Blue', 499.00, 3, 1, 50, 'dummy description'),
('Apple - iPad 10.9" (2022) - 64GB - Silver', 349.00, 3, 1, 50, 'dummy description'),
('Apple - iPad 10.9" (2022) - 256GB - Silver', 499.00, 3, 1, 50, 'dummy description'),
('Huawei - MatePad 10.4" (2022) - 64GB 4GB RAM - Midnight Grey', 429.00, 3, 4, 50, 'dummy description'),
('Huawei - MatePad 10.4" (2022) - 64GB 6GB RAM - Midnight Grey', 459.00, 3, 4, 50, 'dummy description'),
('Huawei - MatePad 10.4" (2022) - 128GB 4GB RAM - Midnight Grey', 459.00, 3, 4, 50, 'dummy description'),
('Huawei - MatePad 10.4" (2022) - 128GB 6GB RAM - Midnight Grey', 499.00, 3, 4, 50, 'dummy description'),
('Huawei - MatePad T 10 (2021) - 64GB 2GB RAM - Deepsea Blue', 199.00, 3, 4, 50, 'dummy description'),
('Huawei - MatePad T 10 (2021) - 64GB 4GB RAM - Deepsea Blue', 229.00, 3, 4, 50, 'dummy description'),
('Lenovo - Tab M10 Plus Gen 3 - 32GB 3GB RAM - Storm Grey', 259.00, 3, 8, 50, 'dummy description'),
('Lenovo - Tab M10 Plus Gen 3 - 64GB 4GB RAM - Storm Grey', 279.00, 3, 8, 50, 'dummy description'),
('Lenovo - Tab M10 Plus Gen 3 - 128GB 4GB RAM - Storm Grey', 289.00, 3, 8, 50, 'dummy description'),
('Lenovo - Tab M10 Plus Gen 3 - 128GB 6GB RAM - Storm Grey', 319.00, 3, 8, 50, 'dummy description'),
('Lenovo - Tab M11 - 64GB 4GB RAM - Arctic Grey', 179.00, 3, 8, 50, 'dummy description'),
('Lenovo - Tab M11 - 128GB 4GB RAM - Arctic Grey', 199.00, 3, 8, 50, 'dummy description'),
('Lenovo - Tab M11 - 128GB 8GB RAM - Arctic Grey', 229.00, 3, 8, 50, 'dummy description'),
('Lenovo - Tab P11 Gen 2 - 64GB 4GB RAM - Storm Grey', 339.00, 3, 8, 50, 'dummy description'),
('Lenovo - Tab P11 Gen 2 - 128GB 4GB RAM - Storm Grey', 369.00, 3, 8, 50, 'dummy description'),
('Lenovo - Tab P11 Gen 2 - 128GB 6GB RAM - Storm Grey', 389.00, 3, 8, 50, 'dummy description'),
('Lenovo - Tab P12 - 128GB 4GB RAM - Storm Grey', 379.00, 3, 8, 50, 'dummy description'),
('Lenovo - Tab P12 - 128GB 8GB RAM - Storm Grey', 409.00, 3, 8, 50, 'dummy description'),
('Lenovo - Tab P12 - 256GB 8GB RAM - Storm Grey', 449.00, 3, 8, 50, 'dummy description'),
('Samsung - Galaxy Tab S9+ - 256GB 12GB RAM - Graphite', 999.00, 3, 2, 50, 'dummy description'),
('Samsung - Galaxy Tab S9+ - 512GB 12GB RAM - Graphite', 1119.00, 3, 2, 50, 'dummy description'),
('Samsung - Galaxy Tab A9 - 64GB 4GB RAM - Silver', 199.00, 3, 2, 50, 'dummy description'),
('Samsung - Galaxy Tab A9 - 128GB 4GB RAM - Silver', 229.00, 3, 2, 50, 'dummy description'),
('Samsung - Galaxy Tab A9 - 128GB 8GB RAM - Silver', 259.00, 3, 2, 50, 'dummy description'),
('Samsung - Galaxy Tab A9 - 64GB 4GB RAM - Navy', 199.00, 3, 2, 50, 'dummy description'),
('Samsung - Galaxy Tab A9 - 128GB 4GB RAM - Navy', 229.00, 3, 8, 50, 'dummy description'),
('Samsung - Galaxy Tab A9 - 128GB 8GB RAM - Navy', 259.00, 3, 2, 50, 'dummy description'),
('Samsung - Galaxy Tab S9 - 128GB 8GB RAM - Graphite', 799.00, 3, 2, 50, 'dummy description'),
('Samsung - Galaxy Tab S9 - 256GB 12GB RAM - Graphite', 949.00, 3, 2, 50, 'dummy description'),
('Samsung - Galaxy Tab S9 Ultra - 256GB 12GB RAM - Beige', 1299.00, 3, 2, 50, 'dummy description'),
('Samsung - Galaxy Tab S9 Ultra - 512GB 12GB RAM - Beige', 1399.00, 3, 2, 50, 'dummy description'),
('Samsung - Galaxy Tab S9 Ultra - 1TB 12GB RAM - Beige', 1599.00, 3, 2, 50, 'dummy description'),
('Samsung - Galaxy Tab S9 Ultra - 1TB 16GB RAM - Beige', 1699.00, 3, 2, 50, 'dummy description'),
('Samsung - Galaxy Tab S9 Ultra - 256GB 12GB RAM - Graphite', 1299.00, 3, 2, 50, 'dummy description'),
('Samsung - Galaxy Tab S9 Ultra - 512GB 12GB RAM - Graphite', 1399.00, 3, 2, 50, 'dummy description'),
('Samsung - Galaxy Tab S9 Ultra - 1TB 12GB RAM - Graphite', 1599.00, 3, 2, 50, 'dummy description'),
('Samsung - Galaxy Tab S9 Ultra - 1TB 16GB RAM - Graphite', 1699.00, 3, 2, 50, 'dummy description'),


('Apple - Macbook Air 13" (M3 chip) - 512GB SSD 8GB RAM - Midnight', 1299.00, 1, 1, 50, 'dummy description'),
('Apple - Macbook Air 13" (M3 chip) - 512GB SSD 16GB RAM - Midnight', 1499.00, 1, 1, 50, 'dummy description'),
('Apple - Macbook Air 13" (M3 chip) - 512GB SSD 8GB RAM - Starlight', 1299.00, 1, 1, 50, 'dummy description'),
('Apple - Macbook Air 13" (M3 chip) - 512GB SSD 16GB RAM - Starlight', 1499.00, 1, 1, 50, 'dummy description'),
('Apple - Macbook Air 13" (M3 chip) - 512GB SSD 8GB RAM - Space Gray', 1299.00, 1, 1, 50, 'dummy description'),
('Apple - Macbook Air 13" (M3 chip) - 512GB SSD 16GB RAM - Space Gray', 1499.00, 1, 1, 50, 'dummy description'),
('Apple - Macbook Air 15" (M3 chip) - 512GB SSD 8GB RAM - Midnight', 1499.00, 1, 1, 50, 'dummy description'),
('Apple - Macbook Air 15" (M3 chip) - 512GB SSD 16GB RAM - Midnight', 1699.00, 1, 1, 50, 'dummy description'),
('Apple - Macbook Air 15" (M3 chip) - 512GB SSD 8GB RAM - Starlight', 1499.00, 1, 1, 50, 'dummy description'),
('Apple - Macbook Air 15" (M3 chip) - 512GB SSD 16GB RAM - Starlight', 1699.00, 1, 1, 50, 'dummy description'),
('Apple - Macbook Air 15" (M3 chip) - 512GB SSD 8GB RAM - Space Gray', 1499.00, 1, 1, 50, 'dummy description'),
('Apple - Macbook Air 15" (M3 chip) - 512GB SSD 16GB RAM - Space Gray', 1699.00, 1, 1, 50, 'dummy description'),
('Apple - Macbook Pro 14" (M3 chip) - 1 TB SSD 8GB RAM - Silver', 1799.00, 1, 1, 50, 'dummy description'),
('Apple - Macbook Pro 14" (M3 chip) - 1 TB SSD 8GB RAM - Space Black', 1799.00, 1, 1, 50, 'dummy description'),
('Apple - Macbook Pro 14" (M3 chip) - 1 TB SSD 16GB RAM - Silver', 1999.00, 1, 1, 50, 'dummy description'),
('Apple - Macbook Pro 14" (M3 chip) - 1 TB SSD 16GB RAM - Space Black', 1999.00, 1, 1, 50, 'dummy description'),
('Acer - Chromebook Plus 515 – 15.6" - Steel Gray', 399.00, 1, 5, 50, 'dummy description'),
('Acer - Aspire 3 Thin & Light Laptop - 15.6" - Steam Blue', 599.00, 1, 5, 50, 'dummy description'),
('Acer - Nitro V ANV15-51-789J 15.6" - Obsidian Black', 1099.00, 1, 5, 50, 'dummy description'),
('Acer - Predator Helios 18 Gaming Laptop - 18"  - Abyssal Black', 2999.00, 1, 5, 50, 'dummy description'),
('Acer - Chromebook 516 GE Cloud Gaming Laptop - 16" - Titanium Gray', 649.00, 1, 5, 50, 'dummy description'),
('Acer - Chromebook 315 – 15.6" - Silver', 199.00, 1, 5, 50, 'dummy description'),
('Acer - Predator Helios Neo 16" - Steel Gray', 1199.00, 1, 5, 50, 'dummy description'),
('Acer - Aspire Vero - 15.6” - Cobblestone Gray', 629.00, 1, 5, 50, 'dummy description'),
('Acer - Chromebook 314 Laptop -14" - Charcoal Black', 269.00, 1, 5, 50, 'dummy description'),
('Acer - Nitro V ANV15-41-R2Y3 Gaming Laptop– 15.6" - Obsidian Black', 949.00, 1, 5, 50, 'dummy description'),
('Dell G15 15.6" FHD 120Hz Gaming Laptop - 1TB SSD - Dark Shadow Gray w/ Black Thermal Shelf" - Obsidian Black', 899.00, 1, 6, 50, 'dummy description'),
('Dell - Inspiron 16.0" 2-in-1 Touch Laptop - 512GB SSD - Dark River Blue', 849.00, 1, 6, 50, 'dummy description'),
('Dell – Inspiron 14” 2-in-1 Touch Laptop – 1TB SDD - Ice Blue', 999.00, 1, 6, 50, 'dummy description'),
('Dell - 16" 13th Generation Gaming Laptop - 1TB SSD - Metallic Nightshade', 1599.00, 1, 6, 50, 'dummy description'),
('Dell - Inspiron 14.0" 2-in-1 Touch Laptop - 512GB SSD - Platinum Silver', 729.00, 1, 6, 50, 'dummy description'),
('Dell Inspiron 15 Touch Screen Laptop –512GB SSD - Carbon Black', 629.00, 1, 6, 50, 'dummy description'),
('Lenovo - Yoga 7i 2-in-1 16" 2K Touchscreen Laptop - 1TB SSD - Storm Grey', 1049.00, 1, 8, 50, 'dummy description'),
('Lenovo - Ideapad 1 15.6" Full HD Touchscreen Laptop - 256GB SSD - Abyss Blue', 579.00, 1, 8, 50, 'dummy description'),
('Lenovo - Ideapad 1 15.6" Full HD Touchscreen Laptop - 512GB SSD - Cloud Gray', 799.00, 1, 8, 50, 'dummy description'),
('Lenovo - Yoga 7 16" WUXGA 2 in 1 Touch Screen Laptop - 512GB SSD - Arctic Grey', 749.00, 1, 8, 50, 'dummy description'),
('Lenovo - Legion Slim 5 14.5" OLED Gaming Laptop - 1 TB SSD - Storm Grey', 1479.00, 1, 8, 50, 'dummy description'),
('HP - 14" Laptop - 64GB eMMC - Snowflake White', 179.00, 1, 7, 50, 'dummy description'),
('HP - 14" Laptop - 128GB eMMC - Rose Gold', 199.00, 1, 7, 50, 'dummy description'),
('HP - 14" Laptop - 64GB eMMC - Indigo Blue', 179.00, 1, 7, 50, 'dummy description'),
('HP - Envy 2-in-1 15.6" Full HD Touch-Screen Laptop - 256GB SSD - Natural Silver', 919.00, 1, 7, 50, 'dummy description'),
('HP - Victus 15.6" Full HD 144Hz Gaming Laptop - 512GB SSD - Performance Blue', 879.00, 1, 7, 50, 'dummy description'),
('HP - 14" Chromebook Laptop - 64GB eMMC - Modern Gray', 299.00, 1, 7, 50, 'dummy description'),
('HP - Envy 17.3" Full HD Touch-Screen Laptop - 1TB SSD - Glacier Silver', 1349.00, 1, 7, 50, 'dummy description'),

('Native Union - 10" USB Type C-to-USB Type A Cable - Zebra', 29.99, 5, 15, 50, 'Charge your mobile phone or tablet conveniently with this Native Union belt cable. The 10-foot length offers flexible placement, extending the distance between the socket and device for easy reach while charging. This Native Union belt cable features a reinforced construction with DuPont Kevlar fiber that offers durability, and a genuine leather strap ensures tangle-free use.'),
('Insignia - 10" USB-A to Lightning Charge-and-Sync Cable - Moon Gray', 15.99, 5, 12, 50, 'Whether you’re calling loved ones, texting friends, or ordering takeout food online, your phone is vital to your lifestyle. It’s important to keep it charged and ready to go at a moment’s notice. The Insignia NS-MLA1021MG 10 ft. Lightning to USB Charge-and-Sync Cable is more than up to the task. It’ll not only charge your Lightning-enabled iPhone, iPad or iPod, but also let you transfer files and sync your device. Its long 10 ft. length gives you flexible placement options and its braided jacket keeps the cable both protected and looking stylish. Trust this Insignia Lightning to USB Cable to help keep you ready for the challenges of everyday life.'),
('Apple - 6.6" (2M) USB Type C-to-Lightning Charging Cable - White', 24.99, 5, 1, 50, 'This 6.6'' (2M) USB-C 2.0 cable connects your iPhone, iPad, or iPod with Lightning connector to your computer''s USB-C port for syncing and charging. Or you can connect to the Apple USB-C Power Adapter for convenient charging from a wall outlet.'),
('Apple - 3.3" USB Type C-to-Lightning Charging Cable - White', 19.99, 5, 1, 50, 'Connect your iPhone, iPad, or iPod with Lightning connector to your USB-C or Thunderbolt 3 (USB-C) enabled Mac for syncing and charging, or to your USB-C enabled iPad for charging. You can also use this cable with your Apple 18W, 20W, 29W, 30W, 61W, 87W or 96W USB‑C Power Adapter to charge your iOS device and even take advantage of the fast-charging feature on select iPhone and iPad models.'),
('Apple - 6.6" USB Type A-to-Lightning Charging Cable - White', 29.99, 5, 1, 50, 'Connect your compatible Apple® device to your computer''s USB port with this Apple MD819ZM/A cable which features a Lightning connector to help charge and sync your iPad® mini, iPad with Retina, iPhone® 5, 5s or 5c and more.'),
('Insignia - 10" USB-A to USB-CA Charge-and-Sync Cable - Charcoal', 12.99, 5, 12, 50, 'When your smartphone battery dies, you lose the ability to stay connected. Whether it’s social media, your calendar or just the internet, nothing’s worse than a device with a low battery and no way to charge it. The Insignia 10'' USB-A to USB-C Charge-and-Sync Cable lets you power and transfer files from USB-C smartphones, tablets and more. Slim connectors with a textured grip fit into cases, keeping your device protected. With a charcoal-gray braided design, you can count on its durable exterior for everyday use. This long 10 ft. cable keeps you connected to everything that’s important.'),
('Samsung - 65W 6" USB Type C-to-USB Type C Device Cable - Black', 24.99, 5, 2, 50, 'Enjoy fast charging and fast data transmission at the same time. With up to 65W power delivery on Samsung laptops, up to 45W Super Fast Charging 2.0 on compatible smartphones and USB 2.0 data transfer speeds, you don''t have to switch cables for optimized performance.'),
('Insignia - 4" USB-A to USB-C Charge-and-Sync Cable (2 Pack) - Charcoal', 14.99, 5, 12, 50, 'When your smartphone battery dies, you lose the ability to stay connected. Whether it’s social media, your calendar or just the internet, nothing’s worse than a device with a low battery and no way to charge it. The Insignia NS-MCA421C2 4'' USB-A to USB-C Charge-and-Sync Cable (2 Pack) lets you power and transfer files from USB-C smartphones, tablets and more. Slim connectors with a textured grip fit into cases, keeping your device protected. With a charcoal-gray braided design, you can count on its durable exterior for everyday use. This long 4 ft. cable keeps you connected to everything that’s important.'),
('Anker - PowerLine III Flow USB-C to Lightning Cable 6-ft - Purple', 29.99, 5, 10, 50, 'PowerLine III Flow USB-C to Lightning Cable: Super Strong, Surprisingly Soft. Once you’ve held this surprisingly soft silica gel cable in your hand, you’ll never go back to regular cables. Features a triple-layered system of copper wires, flexible graphene, and silica gel for enhanced flexibility without any loss in durability. The result is a cable with a tensile strength of 220 lbs (100 kg) and a 25,000-bend lifespan. More than enough to take the strain of a dangling iPhone or iPad. Use the included silica gel strap to keep the cable neatly coiled when stored away in a drawer, bag, pocket, or anywhere else. Note: Travel pouch not included. Find a look to suit you and your iPhone. PowerLine III Flow comes in 5 fresh finishes: Coral Pink, Lavender Grey, Mint Green, Cloud White, and Midnight Black. Compatible with Power Delivery fast charging to charge your iPhone, iPad, or any other Lightning device at its maximum possible speed. Note: Requires a compatible Power Delivery high-speed charger.'),
('Anker - 322 USB-A to USB-C Cable - 6ft, Nylon - Black', 11.99, 5, 10, 50, 'Experience superior quality with our USB-C to USB-C cable, crafted from high-quality materials and tested to withstand up to 175 lbs without breaking, ensuring a lifespan of up to 12,000 uses. Safety is our priority, and this product has passed rigorous tests to meet USB-IF''s strict safety standards, delivering a safe and reliable charging experience. Enjoy universal compatibility as this cable works seamlessly with all USB-C devices, including phones, laptops, cameras, and a wide range of Samsung Galaxy and Pixel models. Trust in our commitment to quality and safety.'),
('Insignia - 150" Cat-6 Ethernet Cable - Gray', 54.99, 5, 12, 50, 'Set up a versatile home network with this Insignia Ethernet cable. Its 150-foot length provides plenty of leeway, so you can connect to a network switch or modem in another room, and it supports 10/100/1000 Mbps speeds for versatile use. This Insignia Ethernet cable has snagless connectors, so you can plug and unplug it numerous times without wearing it down.'),
('Insignia™ - 25" 4K Ultra HD HDMI Cable - Black', 79.99, 5, 12, 50, 'Use this Insignia HDMI cable to set up your ideal entertainment system in your home. An in-wall rating keeps the tangle of wires from view, and the 25-foot length offers a range of placement options. This Insignia HDMI cable handles the latest in 4K HDMI systems, and Ethernet capabilities expand your possibilities.'),

('Apple - MagSafe iPhone Charger - White', 33.99, 6, 1, 50, 'The MagSafe Charger makes wireless charging a snap. The perfectly aligned magnets attach to your iPhone 15, iPhone 15 Pro, iPhone 13 or iPhone 13 Pro, iPhone 12 or iPhone 12 Pro and provide faster wireless charging.'),
('Samsung - SmartThings Station with Power Adapter - Black', 79.99, 6, 2, 50, 'Invite intelligence into your home. Beyond charging your device, SmartThings Station is designed to make your day and night run smoothly with smart features, automated experiences and convenient control of your home.'),
('Samsung - Wireless Charger Pad Trio - Black', 89.99, 6, 2, 50, 'With room to hold three devices at once — a smartwatch and two phones, or a smartwatch, earbuds, and phone — you can power up your ecosystem all at once**. So when you’re done for the day, just put your devices down in one place to be ready for tomorrow.'),
('Samsung - 25W Super Fast Charging Wall Charger USB-C - Black', 15.99, 6, 2, 50, 'Super fast charging up to 25W with compatible devices and other USB devices will charge at varying rates also works with USB-C cable.'),
('Insignia™ - 72.5W 2-Port USB-C/USB Foldable Wall Charger for Laptops, Smartphone, and Tablet - White', 22.99, 6, 12, 50, 'Don’t let your laptop or smartphone battery die as you work throughout the day. The Insignia NS-PW372AC1W22 72.5W 2-Port USB-C/USB Wall Charger has a 72.5-watt output to quickly charge your laptop, smartphone, tablet or other device. It has a USB-C and a standard USB port so you can connect your cables (not included) and charge two devices simultaneously. Its compact and durable body with a foldable plug easily fits into a purse or pocket, ready for when you need it. A simple white design pairs well with your other accessories. Keep your laptop and phone both working as hard as you do with this dual-port, easy-to-carry charger.'),
('Samsung - Super Fast Charging 65W Trio Adapter - Black', 59.99, 6, 2, 50, 'Maximize your charging time. Power up a wide range of devices from earbuds to laptops.'),
('Google - 30W USB-C Charger and Cable - Clearly White', 35.00, 6, 3, 50, 'Charge your Google products and other USB-C devices quickly with the 30W USB-C Charger. It’s compact enough to take wherever you go.'),
('Apple - 20W USB-C Power Adapter - White', 14.99, 6, 1, 50, 'The Apple 20W USB-C Power Adapter offers fast, efficient charging at home, in the office, or on the go. While the power adapter is compatible with any USB-C-enabled device, Apple recommends pairing it with the 11-inch iPad Pro and 12.9-inch iPad Pro (3rd generation) for optimal charging performance. The Apple 20W USB-C Power Adapter offers fast, efficient charging at home, in the office, or on the go. Pair it with iPhone 8 or later for fast charging–50 percent battery in around 35 minutes.* Or pair it with the iPad Pro and iPad Air for optimal charging performance. Compatible with any USB-C enabled device. *Charging cable sold separately.'),
('Insignia™ - 30W USB-C Foldable Compact Wall Charger Bundle with 6’ USB-C to C cable for Smartphones, Tablets and More - White', 24.99, 6, 12, 50, 'Don’t let the battery of your device die as you work throughout the day. The Insignia NS-MW3130C1W24B 30W USB-C Foldable Compact Wall Charger for Smartphones, Tablets and More has a 30-watt output to quickly charge all your USB-C devices. Its compact, durable body and a foldable plug easily fit into a purse or pocket, ready for when you need it. An included 6 ft. USB-C cable provides flexible placement options and is braided for an improved look and feel. All that and a simple white design pairs well with your other accessories. Keep your devices working as hard as you do with this easy-to-carry charger.'),
('Anker - 735 65W 3 Port USB Foldable Fast Wall Charger with GaN for iPhone/Samsung/Tablets/Laptops - Black', 39.99, 6, 10, 50, 'Instead of filling up your house (and the planet) with an extra charger for each new device you buy, Anker 735 charger has the power you need to charge the majority of your personal devices with just a single charger.'),

('Cellularline Power Bank Essence 20000 Portable Charger 20000 mAh - Input 1 x USB-C, 1 x Micro USB 10.5 W - Output 1 x USB 12 W - Black', 39.99, 8, 14, 50, 'ESSENCE is the Cellularline portable battery charger that ensures optimal performance when the smartphone needs to be charged in an emergency and provides up to 12W of power. It has two USB-C and Micro USB input ports for charging the battery charger and a USB output for charging the device. The design has been studied for best performance: the non-slip paint gives it a solid grip and the soft material coating feels comfortable.'),
('Cellularline Power Bank Essence 5000 mAh Portable Charger - Input 1 x USB-C, 1 x Micro USB 10.5 W - Output 1 x USB 12 W (Blue)', 27.99, 8, 14, 50, 'Essence is the cellularline power bank that guarantees excellent performance for emergency charging of the smartphone and delivers up to 12W of power. It is equipped with two INPUT USB-C and MICRO-USB ports for charging the charger and an OUTPUT USB port for charging the device. The design is designed to provide the best performance: the non-slip coating and soft-touch coating give strength to the grip and feel comfortable.'),
('Anker - Power Bank (10000mAh, 20W, 3-Port) - Black', 39.99, 8, 10, 50, 'Elevate your charging experience with the PowerCore III Sense (10000mAh, 20W, 3-Port). This power bank offers versatile charging options, featuring Triple Charging Modes including a 20W Power Delivery USB-C port, a PowerIQ-enabled USB-A port, and a trickle-charging mode for low-power devices. Charge two devices simultaneously through its dual USB ports. With exquisite craftsmanship, its sleek design and cool-blue LED light wheel showcase the battery level elegantly. Quality is paramount inside and out. Recharge swiftly in just 4.5 hours using a USB-C Power Delivery wall charger (charger not included), or approximately 10.2 hours with a USB-A charger and cable (not included). Elevate your charging game with PowerCore III Sense 10K.'),
('Anker PowerCore III Sense 20K USB-C Portable Battery Charger - Black', 49.99, 8, 10, 50, 'Anker PoweCore III Sense 20K Portable Charger is one of the slimmest Power Delivery portable power banks around. It offers high-speed charging for virtually any mobile device on the market. With its large 20,000mAh cell capacity, you can keep all your devices charged for days, wherever you are. The power bank comes with two PowerIQ USB-A outputs for dual-device charging and one Power Delivery USB-C input for extremely quick recharging. The Anker MultiProtect safety system includes high-voltage protection, current regulation, temperature control, and more to keep you and your devices safe. On top of its charging power, you can keep a stylish and professional look with the fabric exterior. This is all you need in a charging companion. Compatible with iPhone 13/13 Pro/12/12 Pro/12 Pro Max/8/X/XR, Samsung, iPad Pro, and More.'),
('Anker 737 Power Bank - Black', 189.99, 8, 10, 50, 'The Anker 737 Power Bank (Black) is a powerful portable charger with a massive 24,000mAh capacity, allowing you to charge your devices multiple times. It supports fast charging technology for various devices, including laptops, and features multiple ports for charging multiple devices at once. An integrated digital display provides information like charging power and estimated recharge time. This black colored power bank is a reliable option for keeping your devices powered up wherever you go.'),
('Anker - Power Bank (24000mAh, 140W, 3-Port) - Black', 109.99, 8, 10, 50, 'Harness the power of Power Delivery 3.1, boasting a remarkable 140W output for lightning-fast recharges of laptops, tablets, and phones. Charge a MacBook Pro 14" up to 80% in just 51 minutes, or achieve the same with a 140W charger in a swift 40 minutes. Stay informed with real-time insights, showing power levels, estimated full charge times, and power bank temperature. With a generous 24,000 mAh capacity, charge a MacBook Air 1.3 times or multiple iPhones on the go. Designed for convenience and compliance, it adheres to boarding regulations while maintaining exceptional portability. Connect to any port for optimal charging efficiency. Our intelligent temperature monitoring system ensures safety with a consistent temperature 10% below international guidelines. Embrace the future of charging with unparalleled performance and safety.'),
('Energizer - MAX 30,000mAh 15W USB-C 3-Port Universal Portable Battery Charger/Power Bank w/ LCD screen for Smartphones & Accessories - Black', 59.99, 8, 11, 50, 'Charge your mobile devices quickly and efficiently with this Energizer power bank.  This portable charger provides 30,000mAh capacity to charge smartphones, tablets, smartwatches, headphones, ear buds, and more.  The bright LCD screen displays the current battery level so you always know how much power is left. The 30,000mAh battery provides up to 108 hours of additional power to smartphones while the two USB 2.1 Type-A ports with Rapid Charge technology deliver power consistently and efficiently to up to two devices at once at 10.5W. The USB-C output provides up to 15W of charging power. Charge up to thee devices at once via two USB-A outputs and one USB-C output. The textured surface prevents slippage, scratches and fingerprints. Energizer PowerSafe Management protects against short circuit, overcurrent, overcharge and overdischarge for your power bank and devices. A USB-C Cable is included for recharging the power bank quickly and efficiently.'),
('Energizer - Ultimate Lithium 30,000 mAh 30W PD USB-C Universal Portable Battery Charger/Power Bank with 6 Ports and LCD Display - Black', 69.99, 8, 11, 50, 'Charge your mobile devices including Smartphones, Compuiters, Tablets, earbuds and most USB devices with this Energizer power bank. The six outputs, including 4 Smart USB-A and 2 USB-C, can charge six devices at the same time. The 30W USB-C Power Delivery technology allows you to fast charge the new iPhones from 0 to 50% in only 30 minutes, and other USB-C devices. The two 30W USB-C Power Delivery outputs also support laptop charging. Four USB-A ports charge devices at 18W to charge Android devices from 0-50% in 30 minutes. The dual inputs allow you to recharge through USB-C or micro-USB based on your convenience. The LCD screen indicator shows the battery charging status at a quick glance. Energizer PowerSafe Management guarantees against short circuit, overcurrent, overcharge and overdischarge for your power bank and devices.'),


('AirPods Pro (2nd generation) with MagSafe Charging Case (USB‑C)', 249.00, 7, 1, 50, 'The AirPods Pro (2nd generation) with MagSafe Charging Case (USB-C) are Apple''s premium wireless earbuds, designed to provide an exceptional audio experience with several advanced features. These earbuds come with enhanced Active Noise Cancellation (ANC) that effectively blocks out external noise, making them ideal for use in various environments. Additionally, they feature a Transparency Mode, allowing users to hear and interact with the surroundings without removing the earbuds.

One of the standout features of the second-generation AirPods Pro is Personalized Spatial Audio, which creates an immersive sound experience by tailoring the audio output to the unique shape of the user''s ears. This results in a more engaging and enveloping listening experience.

Battery life has been improved, offering up to six hours of listening time with ANC enabled. The MagSafe Charging Case extends the total battery life to up to 30 hours. This case supports MagSafe for convenient and secure wireless charging and includes a USB-C port for versatile wired charging options.

The sound quality of the AirPods Pro (2nd generation) is enhanced with a new low-distortion audio driver and a custom amplifier, delivering rich and detailed sound across various music genres. Adaptive Transparency is another innovative feature that dynamically reduces the intensity of loud noises in the environment, providing a more comfortable listening experience without completely blocking out important sounds.

Both the earbuds and the charging case are sweat and water-resistant (IPX4 rated), making them suitable for workouts and outdoor activities. Additionally, the case includes a built-in speaker that integrates with the Find My app, helping users locate it if misplaced.

Overall, the AirPods Pro (2nd generation) with MagSafe Charging Case (USB-C) are designed to offer a premium and adaptable listening experience, with advanced features that cater to a wide range of user needs.'),
('AirPods (2nd generation)', 129.00, 7, 1, 50, 'The AirPods (2nd generation) are Apple''s wireless earbuds, known for their ease of use, seamless integration with Apple devices, and solid performance. They maintain the iconic design of the original AirPods and come with several enhancements that improve the overall user experience.

One of the key features of the AirPods (2nd generation) is the H1 chip, which enables faster and more stable wireless connections to your devices. This chip also allows for hands-free "Hey Siri" functionality, enabling users to control their music, make phone calls, adjust the volume, and get directions simply by using voice commands.

The battery life of the AirPods (2nd generation) is impressive, offering up to 5 hours of listening time on a single charge. The included charging case extends this to more than 24 hours of total listening time. A quick 15-minute charge in the case provides up to 3 hours of listening time or up to 2 hours of talk time, making them convenient for users on the go.

In terms of sound quality, the AirPods (2nd generation) deliver clear and balanced audio with rich bass and crisp highs. While they may not offer advanced features like Active Noise Cancellation, they provide a reliable and enjoyable listening experience for a wide range of audio content, from music and podcasts to phone calls.

The AirPods (2nd generation) are designed for comfort and a secure fit, making them suitable for a variety of activities, including workouts and daily commutes. They automatically connect to your device as soon as you put them in your ears and pause when you take them out, ensuring a smooth and intuitive user experience.

Overall, the AirPods (2nd generation) are a solid choice for anyone looking for a pair of wireless earbuds that offer convenience, reliable performance, and seamless integration with the Apple ecosystem.'),
('AirPods (3rd generation)', 169.00, 7, 1, 50, 'The AirPods (3rd generation) are Apple''s mid-tier wireless earbuds that bring several enhancements over their predecessors while maintaining the user-friendly design and seamless integration with Apple devices that the brand is known for.

One of the standout features of the AirPods (3rd generation) is the introduction of Spatial Audio with dynamic head tracking. This technology provides an immersive listening experience by adjusting the sound based on the position of your head, making it feel as though the audio is coming from all around you. This feature works particularly well with Dolby Atmos content available on Apple Music.

The AirPods (3rd generation) also boast improved sound quality, thanks to a new custom driver and high dynamic range amplifier. These components work together to deliver rich bass, crisp highs, and detailed midrange frequencies, offering a more balanced and fuller sound compared to previous generations.

Battery life has been significantly enhanced as well. The earbuds themselves offer up to 6 hours of listening time on a single charge, while the MagSafe Charging Case provides up to 30 hours of total listening time. The case supports both MagSafe and Qi wireless charging, in addition to standard Lightning cable charging, offering flexibility and convenience for users.

In terms of design, the AirPods (3rd generation) have a shorter stem and a more contoured shape, providing a better fit for a wider range of ear sizes. They are also sweat and water-resistant (IPX4 rated), making them suitable for workouts and outdoor activities.

The AirPods (3rd generation) feature the H1 chip, which enables quick and stable wireless connections to your Apple devices, seamless switching between devices, and hands-free "Hey Siri" functionality. This chip also helps reduce latency for a more responsive audio experience when watching videos or playing games.

Overall, the AirPods (3rd generation) offer a significant upgrade in sound quality, battery life, and features like Spatial Audio, making them an excellent choice for users looking for a versatile and high-performing pair of wireless earbuds within the Apple ecosystem.'),

('Anker Space A40 - Black', 59.00, 7, 10, 50, 'The Anker Soundcore Space A40 are wireless earbuds known for their impressive noise-canceling capabilities and high-quality sound. They feature advanced hybrid active noise cancellation, which effectively reduces ambient noise, making them ideal for use in noisy environments. The earbuds offer up to 10 hours of playtime on a single charge, with the charging case extending the total battery life to up to 50 hours. They support Bluetooth 5.2 for a stable and efficient connection. The Space A40 also includes customizable sound profiles through the Soundcore app, ensuring a personalized listening experience. Additionally, they are designed for comfort and secure fit, making them suitable for long listening sessions.'),
('Anker Space A40 - Navy Blue', 59.00, 7, 10, 50, 'The Anker Soundcore Space A40 are wireless earbuds known for their impressive noise-canceling capabilities and high-quality sound. They feature advanced hybrid active noise cancellation, which effectively reduces ambient noise, making them ideal for use in noisy environments. The earbuds offer up to 10 hours of playtime on a single charge, with the charging case extending the total battery life to up to 50 hours. They support Bluetooth 5.2 for a stable and efficient connection. The Space A40 also includes customizable sound profiles through the Soundcore app, ensuring a personalized listening experience. Additionally, they are designed for comfort and secure fit, making them suitable for long listening sessions.'),
('Anker Space A40 - White', 59.00, 7, 10, 50, 'The Anker Soundcore Space A40 are wireless earbuds known for their impressive noise-canceling capabilities and high-quality sound. They feature advanced hybrid active noise cancellation, which effectively reduces ambient noise, making them ideal for use in noisy environments. The earbuds offer up to 10 hours of playtime on a single charge, with the charging case extending the total battery life to up to 50 hours. They support Bluetooth 5.2 for a stable and efficient connection. The Space A40 also includes customizable sound profiles through the Soundcore app, ensuring a personalized listening experience. Additionally, they are designed for comfort and secure fit, making them suitable for long listening sessions.'),
('Anker Liberty 4 NC - Black', 99.00, 7, 10, 50, 'The Anker Liberty 4 NC are wireless earbuds designed to offer a premium listening experience with advanced features, making them a competitive choice in the market for high-quality audio products.

One of the standout features of the Liberty 4 NC is its advanced noise cancellation technology. Anker uses adaptive noise-canceling algorithms that effectively reduce ambient noise, providing an immersive listening experience even in noisy environments. This makes the Liberty 4 NC ideal for use during commutes, in busy offices, or while traveling.

The sound quality of the Liberty 4 NC is enhanced by its custom-designed drivers, which deliver rich, detailed audio with a balanced sound profile. The earbuds support high-resolution audio, ensuring that users can enjoy their music with exceptional clarity and depth.

Battery life is another strong point of the Liberty 4 NC. The earbuds offer up to 10 hours of playtime on a single charge, and the included charging case extends this to a total of up to 50 hours. This ensures that users can listen to music, make calls, or use the earbuds throughout the day without worrying about running out of power.

Connectivity is robust with Bluetooth 5.2, providing a stable and efficient connection to devices. The earbuds also support multipoint connection, allowing users to connect to two devices simultaneously and switch between them seamlessly.

Comfort and fit are carefully considered in the design of the Liberty 4 NC. The earbuds come with multiple sizes of ear tips to ensure a secure and comfortable fit for a variety of ear shapes and sizes. This makes them suitable for long listening sessions and active use.

The Liberty 4 NC also includes a transparency mode, which allows users to hear their surroundings without removing the earbuds. This feature is particularly useful for staying aware of the environment when walking or when quick interactions are needed.

Additionally, the earbuds are rated IPX5 for water resistance, making them suitable for workouts and outdoor activities where they might be exposed to sweat or light rain.'),
('Anker Liberty 4 NC - Navy Blue', 99.00, 7, 10, 50, 'The Anker Liberty 4 NC are wireless earbuds designed to offer a premium listening experience with advanced features, making them a competitive choice in the market for high-quality audio products.

One of the standout features of the Liberty 4 NC is its advanced noise cancellation technology. Anker uses adaptive noise-canceling algorithms that effectively reduce ambient noise, providing an immersive listening experience even in noisy environments. This makes the Liberty 4 NC ideal for use during commutes, in busy offices, or while traveling.

The sound quality of the Liberty 4 NC is enhanced by its custom-designed drivers, which deliver rich, detailed audio with a balanced sound profile. The earbuds support high-resolution audio, ensuring that users can enjoy their music with exceptional clarity and depth.

Battery life is another strong point of the Liberty 4 NC. The earbuds offer up to 10 hours of playtime on a single charge, and the included charging case extends this to a total of up to 50 hours. This ensures that users can listen to music, make calls, or use the earbuds throughout the day without worrying about running out of power.

Connectivity is robust with Bluetooth 5.2, providing a stable and efficient connection to devices. The earbuds also support multipoint connection, allowing users to connect to two devices simultaneously and switch between them seamlessly.

Comfort and fit are carefully considered in the design of the Liberty 4 NC. The earbuds come with multiple sizes of ear tips to ensure a secure and comfortable fit for a variety of ear shapes and sizes. This makes them suitable for long listening sessions and active use.

The Liberty 4 NC also includes a transparency mode, which allows users to hear their surroundings without removing the earbuds. This feature is particularly useful for staying aware of the environment when walking or when quick interactions are needed.

Additionally, the earbuds are rated IPX5 for water resistance, making them suitable for workouts and outdoor activities where they might be exposed to sweat or light rain.'),

('Anker Liberty 4 NC - White', 99.00, 7, 10, 50, 'The Anker Liberty 4 NC are wireless earbuds designed to offer a premium listening experience with advanced features, making them a competitive choice in the market for high-quality audio products.

One of the standout features of the Liberty 4 NC is its advanced noise cancellation technology. Anker uses adaptive noise-canceling algorithms that effectively reduce ambient noise, providing an immersive listening experience even in noisy environments. This makes the Liberty 4 NC ideal for use during commutes, in busy offices, or while traveling.

The sound quality of the Liberty 4 NC is enhanced by its custom-designed drivers, which deliver rich, detailed audio with a balanced sound profile. The earbuds support high-resolution audio, ensuring that users can enjoy their music with exceptional clarity and depth.

Battery life is another strong point of the Liberty 4 NC. The earbuds offer up to 10 hours of playtime on a single charge, and the included charging case extends this to a total of up to 50 hours. This ensures that users can listen to music, make calls, or use the earbuds throughout the day without worrying about running out of power.

Connectivity is robust with Bluetooth 5.2, providing a stable and efficient connection to devices. The earbuds also support multipoint connection, allowing users to connect to two devices simultaneously and switch between them seamlessly.

Comfort and fit are carefully considered in the design of the Liberty 4 NC. The earbuds come with multiple sizes of ear tips to ensure a secure and comfortable fit for a variety of ear shapes and sizes. This makes them suitable for long listening sessions and active use.

The Liberty 4 NC also includes a transparency mode, which allows users to hear their surroundings without removing the earbuds. This feature is particularly useful for staying aware of the environment when walking or when quick interactions are needed.

Additionally, the earbuds are rated IPX5 for water resistance, making them suitable for workouts and outdoor activities where they might be exposed to sweat or light rain.'),


('Samsung - Galaxy Buds FE - Black', 99.00, 7, 2, 50, 'The Samsung Galaxy Buds FE (Fan Edition) are wireless earbuds designed to provide a premium audio experience with a focus on comfort, style, and seamless integration with Samsung devices.

One of the key features of the Galaxy Buds FE is their sound quality. Equipped with two-way dynamic speakers and AKG-tuned sound, these earbuds deliver clear and balanced audio with rich bass and crisp highs, providing an immersive listening experience across various genres of music and media content.

Active Noise Cancellation (ANC) is another highlight of the Galaxy Buds FE. By blocking out unwanted background noise, ANC allows users to enjoy their music or take calls without distractions, making the earbuds suitable for use in noisy environments such as crowded commutes or bustling cafes.

The Galaxy Buds FE offer long-lasting battery life, with up to 6.5 hours of playtime on a single charge. The included charging case provides an additional 20 hours of battery life, ensuring that users can enjoy their favorite music or podcasts throughout the day without worrying about running out of power. The earbuds also support quick charging, allowing for an hour of playtime with just a 5-minute charge.

Comfort and fit are prioritized in the design of the Galaxy Buds FE. The earbuds feature a sleek and ergonomic design with soft silicone ear tips in multiple sizes, ensuring a secure and comfortable fit for extended wear. This makes them suitable for active use, including workouts and outdoor activities.

The Galaxy Buds FE are compatible with both Android and iOS devices, but they offer seamless integration with Samsung Galaxy smartphones and tablets. Users can easily pair the earbuds with their Samsung devices and access additional features through the Galaxy Wearable app, such as customizable touch controls, equalizer settings, and Find My Earbuds functionality.'),
('Samsung - Galaxy Buds FE - White', 99.00, 7, 2, 50, 'The Samsung Galaxy Buds FE (Fan Edition) are wireless earbuds designed to provide a premium audio experience with a focus on comfort, style, and seamless integration with Samsung devices.

One of the key features of the Galaxy Buds FE is their sound quality. Equipped with two-way dynamic speakers and AKG-tuned sound, these earbuds deliver clear and balanced audio with rich bass and crisp highs, providing an immersive listening experience across various genres of music and media content.

Active Noise Cancellation (ANC) is another highlight of the Galaxy Buds FE. By blocking out unwanted background noise, ANC allows users to enjoy their music or take calls without distractions, making the earbuds suitable for use in noisy environments such as crowded commutes or bustling cafes.

The Galaxy Buds FE offer long-lasting battery life, with up to 6.5 hours of playtime on a single charge. The included charging case provides an additional 20 hours of battery life, ensuring that users can enjoy their favorite music or podcasts throughout the day without worrying about running out of power. The earbuds also support quick charging, allowing for an hour of playtime with just a 5-minute charge.

Comfort and fit are prioritized in the design of the Galaxy Buds FE. The earbuds feature a sleek and ergonomic design with soft silicone ear tips in multiple sizes, ensuring a secure and comfortable fit for extended wear. This makes them suitable for active use, including workouts and outdoor activities.

The Galaxy Buds FE are compatible with both Android and iOS devices, but they offer seamless integration with Samsung Galaxy smartphones and tablets. Users can easily pair the earbuds with their Samsung devices and access additional features through the Galaxy Wearable app, such as customizable touch controls, equalizer settings, and Find My Earbuds functionality.'),
('Samsung - Galaxy Buds2 Pro - Bora Purple', 229.00, 7, 2, 50, 'The Samsung Galaxy Buds2 Pro are premium wireless earbuds designed to provide an exceptional audio experience with advanced features and sleek design aesthetics. These earbuds build upon the success of Samsung''s previous models while introducing several enhancements to elevate the listening experience.

One of the standout features of the Galaxy Buds2 Pro is their active noise cancellation (ANC) technology. This advanced ANC effectively reduces background noise, allowing users to immerse themselves in their music, podcasts, or calls without distractions. The earbuds also offer an adjustable ambient sound mode, which enables users to hear their surroundings when needed without removing the earbuds.

Sound quality is a key focus of the Galaxy Buds2 Pro. Equipped with premium drivers and AKG-tuned sound, these earbuds deliver rich, balanced audio with crisp highs, deep bass, and clear midrange frequencies. Whether you''re listening to music, watching videos, or taking calls, the Galaxy Buds2 Pro ensure a premium audio experience.

Battery life is impressive on the Galaxy Buds2 Pro, with up to 8 hours of continuous playback on a single charge. The included charging case provides an additional 20 hours of battery life, ensuring that users can enjoy extended listening sessions without interruption. Quick charging support allows for an hour of playback with just a 5-minute charge, providing convenience for users on the go.

Comfort and fit are paramount in the design of the Galaxy Buds2 Pro. The earbuds feature a lightweight and ergonomic design with soft silicone ear tips in multiple sizes, ensuring a secure and comfortable fit for all-day wear. This makes them suitable for various activities, including workouts and long commutes.

The Galaxy Buds2 Pro are compatible with both Android and iOS devices, but they offer seamless integration with Samsung Galaxy smartphones and tablets. Users can easily pair the earbuds with their Samsung devices and access additional features through the Galaxy Wearable app, such as customizable touch controls, equalizer settings, and Find My Earbuds functionality.'),
('Samsung - Galaxy Buds2 Pro - Graphite', 229.00, 7, 2, 50, 'The Samsung Galaxy Buds2 Pro are premium wireless earbuds designed to provide an exceptional audio experience with advanced features and sleek design aesthetics. These earbuds build upon the success of Samsung''s previous models while introducing several enhancements to elevate the listening experience.

One of the standout features of the Galaxy Buds2 Pro is their active noise cancellation (ANC) technology. This advanced ANC effectively reduces background noise, allowing users to immerse themselves in their music, podcasts, or calls without distractions. The earbuds also offer an adjustable ambient sound mode, which enables users to hear their surroundings when needed without removing the earbuds.

Sound quality is a key focus of the Galaxy Buds2 Pro. Equipped with premium drivers and AKG-tuned sound, these earbuds deliver rich, balanced audio with crisp highs, deep bass, and clear midrange frequencies. Whether you''re listening to music, watching videos, or taking calls, the Galaxy Buds2 Pro ensure a premium audio experience.

Battery life is impressive on the Galaxy Buds2 Pro, with up to 8 hours of continuous playback on a single charge. The included charging case provides an additional 20 hours of battery life, ensuring that users can enjoy extended listening sessions without interruption. Quick charging support allows for an hour of playback with just a 5-minute charge, providing convenience for users on the go.

Comfort and fit are paramount in the design of the Galaxy Buds2 Pro. The earbuds feature a lightweight and ergonomic design with soft silicone ear tips in multiple sizes, ensuring a secure and comfortable fit for all-day wear. This makes them suitable for various activities, including workouts and long commutes.

The Galaxy Buds2 Pro are compatible with both Android and iOS devices, but they offer seamless integration with Samsung Galaxy smartphones and tablets. Users can easily pair the earbuds with their Samsung devices and access additional features through the Galaxy Wearable app, such as customizable touch controls, equalizer settings, and Find My Earbuds functionality.'),
('Samsung - Galaxy Buds2 Pro - White', 229.00, 7, 2, 50, 'The Samsung Galaxy Buds2 Pro are premium wireless earbuds designed to provide an exceptional audio experience with advanced features and sleek design aesthetics. These earbuds build upon the success of Samsung''s previous models while introducing several enhancements to elevate the listening experience.

One of the standout features of the Galaxy Buds2 Pro is their active noise cancellation (ANC) technology. This advanced ANC effectively reduces background noise, allowing users to immerse themselves in their music, podcasts, or calls without distractions. The earbuds also offer an adjustable ambient sound mode, which enables users to hear their surroundings when needed without removing the earbuds.

Sound quality is a key focus of the Galaxy Buds2 Pro. Equipped with premium drivers and AKG-tuned sound, these earbuds deliver rich, balanced audio with crisp highs, deep bass, and clear midrange frequencies. Whether you''re listening to music, watching videos, or taking calls, the Galaxy Buds2 Pro ensure a premium audio experience.

Battery life is impressive on the Galaxy Buds2 Pro, with up to 8 hours of continuous playback on a single charge. The included charging case provides an additional 20 hours of battery life, ensuring that users can enjoy extended listening sessions without interruption. Quick charging support allows for an hour of playback with just a 5-minute charge, providing convenience for users on the go.

Comfort and fit are paramount in the design of the Galaxy Buds2 Pro. The earbuds feature a lightweight and ergonomic design with soft silicone ear tips in multiple sizes, ensuring a secure and comfortable fit for all-day wear. This makes them suitable for various activities, including workouts and long commutes.

The Galaxy Buds2 Pro are compatible with both Android and iOS devices, but they offer seamless integration with Samsung Galaxy smartphones and tablets. Users can easily pair the earbuds with their Samsung devices and access additional features through the Galaxy Wearable app, such as customizable touch controls, equalizer settings, and Find My Earbuds functionality.'),
('Nothing Ear 2', 159.00, 7, 9, 50, 'The Nothing Ear 2 are wireless earbuds crafted by Nothing, a technology company founded by Carl Pei, co-founder of OnePlus. These earbuds boast a distinctive transparent design, revealing the internal components and giving them a futuristic and unique appearance. Beyond their aesthetic appeal, the Ear 2 delivers high-quality sound through custom-designed 11.6mm drivers, ensuring a balanced and immersive audio experience with rich bass, clear mids, and detailed highs. Active Noise Cancellation (ANC) technology helps to block out external distractions, while a transparency mode allows users to stay aware of their surroundings when needed. With up to 34 hours of total playback time and quick charging support, the Ear 2 offers extended listening sessions without interruption. Comfortable and secure fit is ensured by customizable silicone ear tips, making them suitable for various activities and ear shapes.'),
('Nothing Ear 2(a)', 99.00, 7, 9, 50, 'The Nothing Ear 2(a) are the latest iteration of wireless earbuds from Nothing, continuing the brand''s commitment to innovative design and premium sound quality. Building upon the success of the Ear 2, the Ear 2(a) features enhancements and refinements aimed at delivering an even better user experience. While specific details about the Ear 2(a) may vary depending on the updates introduced by Nothing, users can expect similar characteristics to the Ear 2, including the transparent design, high-quality sound, active noise cancellation, long battery life, and customizable fit. The Ear 2(a) may offer improvements or additional features based on user feedback and technological advancements, further solidifying Nothing''s position as a leader in the wireless earbuds market.'),
('Bose - QuietComfort Earbuds II - Triple Black', 279.00, 7, 16, 50, 'The Bose QuietComfort Earbuds II are premium wireless earbuds designed to provide an exceptional listening experience with industry-leading noise cancellation technology, superior sound quality, and long-lasting comfort.

At the heart of the QuietComfort Earbuds II is Bose''s renowned active noise cancellation (ANC) technology, which effectively blocks out external noise and distractions, allowing users to focus on their music, podcasts, or calls without interruption. The earbuds feature an array of microphones that continuously monitor and adapt to ambient sounds, ensuring that users can enjoy their audio content in any environment.

Sound quality is a top priority for Bose, and the QuietComfort Earbuds II deliver immersive audio with clear highs, detailed mids, and deep, rich bass. The earbuds feature custom-designed drivers and Bose''s proprietary EQ technology, which optimizes the sound for a balanced and natural listening experience across various genres of music and media content.

Battery life is impressive on the QuietComfort Earbuds II, with up to 6 hours of continuous playback on a single charge. The included charging case provides an additional two full charges, extending the total battery life to up to 18 hours. Quick charging support allows for up to 2 hours of playback with just a 15-minute charge, ensuring that users can always have their earbuds ready when needed.

Comfort and fit are key considerations in the design of the QuietComfort Earbuds II. The earbuds feature a lightweight and ergonomic design with soft silicone ear tips in multiple sizes, ensuring a secure and comfortable fit for extended wear. This makes them suitable for all-day use, whether you''re working, traveling, or relaxing at home.

The QuietComfort Earbuds II also feature intuitive touch controls, allowing users to adjust volume, skip tracks, answer calls, and activate voice assistants with simple gestures. They are compatible with both Android and iOS devices and can be customized using the Bose Music app, which offers access to additional features such as personalized settings, firmware updates, and Find My Earbuds functionality.

Overall, the Bose QuietComfort Earbuds II are a top choice for users seeking premium wireless earbuds with best-in-class noise cancellation, superior sound quality, long battery life, and comfortable design.'),
('Bose - QuietComfort Earbuds II - Soapstone', 279.00, 7, 16, 50, 'The Bose QuietComfort Earbuds II are premium wireless earbuds designed to provide an exceptional listening experience with industry-leading noise cancellation technology, superior sound quality, and long-lasting comfort.

At the heart of the QuietComfort Earbuds II is Bose''s renowned active noise cancellation (ANC) technology, which effectively blocks out external noise and distractions, allowing users to focus on their music, podcasts, or calls without interruption. The earbuds feature an array of microphones that continuously monitor and adapt to ambient sounds, ensuring that users can enjoy their audio content in any environment.

Sound quality is a top priority for Bose, and the QuietComfort Earbuds II deliver immersive audio with clear highs, detailed mids, and deep, rich bass. The earbuds feature custom-designed drivers and Bose''s proprietary EQ technology, which optimizes the sound for a balanced and natural listening experience across various genres of music and media content.

Battery life is impressive on the QuietComfort Earbuds II, with up to 6 hours of continuous playback on a single charge. The included charging case provides an additional two full charges, extending the total battery life to up to 18 hours. Quick charging support allows for up to 2 hours of playback with just a 15-minute charge, ensuring that users can always have their earbuds ready when needed.

Comfort and fit are key considerations in the design of the QuietComfort Earbuds II. The earbuds feature a lightweight and ergonomic design with soft silicone ear tips in multiple sizes, ensuring a secure and comfortable fit for extended wear. This makes them suitable for all-day use, whether you''re working, traveling, or relaxing at home.

The QuietComfort Earbuds II also feature intuitive touch controls, allowing users to adjust volume, skip tracks, answer calls, and activate voice assistants with simple gestures. They are compatible with both Android and iOS devices and can be customized using the Bose Music app, which offers access to additional features such as personalized settings, firmware updates, and Find My Earbuds functionality.

Overall, the Bose QuietComfort Earbuds II are a top choice for users seeking premium wireless earbuds with best-in-class noise cancellation, superior sound quality, long battery life, and comfortable design.'),
('Bose - QuietComfort Ultra - Black', 299.00, 7, 16, 50, 'Bose QuietComfort Ultra headphones are the top-of-the-line noise-canceling headphones from Bose. They boast improved noise cancellation compared to previous models, blocking out even more distractions. Additionally, they feature a new technology called Bose Immersive Audio, which creates a more spacious and realistic listening experience by making it seem like the sound is coming from all around you. The headphones also have a built-in CustomTune technology that analyzes the shape of your ears to personalize the sound reproduction for an optimal listening experience. With crystal-clear microphone calls and a lengthy battery life, the Bose QuietComfort Ultra headphones aim to deliver an unmatched combination of noise cancellation, immersive audio, and comfort.'),
('Bose - QuietComfort Ultra - White Smoke', 299.00, 7, 16, 50, 'Bose QuietComfort Ultra headphones are the top-of-the-line noise-canceling headphones from Bose. They boast improved noise cancellation compared to previous models, blocking out even more distractions. Additionally, they feature a new technology called Bose Immersive Audio, which creates a more spacious and realistic listening experience by making it seem like the sound is coming from all around you. The headphones also have a built-in CustomTune technology that analyzes the shape of your ears to personalize the sound reproduction for an optimal listening experience. With crystal-clear microphone calls and a lengthy battery life, the Bose QuietComfort Ultra headphones aim to deliver an unmatched combination of noise cancellation, immersive audio, and comfort.'),
('Bose - QuietComfort Ultra - Moonstone Blue', 299.00, 7, 16, 50, 'Bose QuietComfort Ultra headphones are the top-of-the-line noise-canceling headphones from Bose. They boast improved noise cancellation compared to previous models, blocking out even more distractions. Additionally, they feature a new technology called Bose Immersive Audio, which creates a more spacious and realistic listening experience by making it seem like the sound is coming from all around you. The headphones also have a built-in CustomTune technology that analyzes the shape of your ears to personalize the sound reproduction for an optimal listening experience. With crystal-clear microphone calls and a lengthy battery life, the Bose QuietComfort Ultra headphones aim to deliver an unmatched combination of noise cancellation, immersive audio, and comfort.'),
('Bose - Ultra - White Smoke', 299.00, 7, 16, 50, 'The Bose Ultra Open-Ear True Wireless Open Earbuds are designed for those who want to stay aware of their surroundings while listening to music. They use Bose OpenAudio technology to deliver rich, private sound while keeping your ears completely open. The earbuds are also designed for comfort and all-day wear, and Bose advertises a 7.5-hour battery life with up to 19.5 hours of additional power from the charging case. Other features include water resistance, a built-in microphone, and adjustable EQ settings.'),
('Bose - Ultra - Black', 299.00, 7, 16, 50, 'The Bose Ultra Open-Ear True Wireless Open Earbuds are designed for those who want to stay aware of their surroundings while listening to music. They use Bose OpenAudio technology to deliver rich, private sound while keeping your ears completely open. The earbuds are also designed for comfort and all-day wear, and Bose advertises a 7.5-hour battery life with up to 19.5 hours of additional power from the charging case. Other features include water resistance, a built-in microphone, and adjustable EQ settings.'),
('JBL - Endurance Peak 3 - Black', 99.00, 7, 13, 50, 'The JBL Endurance Peak 3 are wireless sports earbuds designed to deliver high-quality sound and durability, making them ideal for workouts and outdoor activities.

One of the key features of the Endurance Peak 3 is their rugged design, built to withstand sweat, water, and rough handling. They are rated IPX7 waterproof, meaning they can be submerged in water up to 1 meter deep for 30 minutes, making them suitable for intense workouts and outdoor adventures.

The earbuds offer a secure and comfortable fit, thanks to their ergonomic design and TwistLock™ technology, which ensures they stay in place during vigorous movement. This makes them ideal for activities like running, cycling, or weightlifting.

Sound quality is another highlight of the Endurance Peak 3. They feature JBL''s signature sound, delivering powerful bass, clear mids, and crisp highs, providing an immersive listening experience for music, podcasts, and calls.

Battery life is impressive on the Endurance Peak 3, with up to 10 hours of continuous playback on a single charge. The included charging case provides an additional 30 hours of battery life, ensuring that users can enjoy extended listening sessions without interruption. Quick charging support allows for up to 1 hour of playback with just a 10-minute charge, providing convenience for users on the go.

The Endurance Peak 3 also features convenient touch controls, allowing users to adjust volume, skip tracks, answer calls, and activate voice assistants with simple gestures. They are compatible with both Android and iOS devices and can be customized using the My JBL Headphones app, which offers access to additional features such as EQ settings and firmware updates.'),
('JBL - Endurance Peak 3 - White', 99.00, 7, 13, 50, 'The JBL Endurance Peak 3 are wireless sports earbuds designed to deliver high-quality sound and durability, making them ideal for workouts and outdoor activities.

One of the key features of the Endurance Peak 3 is their rugged design, built to withstand sweat, water, and rough handling. They are rated IPX7 waterproof, meaning they can be submerged in water up to 1 meter deep for 30 minutes, making them suitable for intense workouts and outdoor adventures.

The earbuds offer a secure and comfortable fit, thanks to their ergonomic design and TwistLock™ technology, which ensures they stay in place during vigorous movement. This makes them ideal for activities like running, cycling, or weightlifting.

Sound quality is another highlight of the Endurance Peak 3. They feature JBL''s signature sound, delivering powerful bass, clear mids, and crisp highs, providing an immersive listening experience for music, podcasts, and calls.

Battery life is impressive on the Endurance Peak 3, with up to 10 hours of continuous playback on a single charge. The included charging case provides an additional 30 hours of battery life, ensuring that users can enjoy extended listening sessions without interruption. Quick charging support allows for up to 1 hour of playback with just a 10-minute charge, providing convenience for users on the go.

The Endurance Peak 3 also features convenient touch controls, allowing users to adjust volume, skip tracks, answer calls, and activate voice assistants with simple gestures. They are compatible with both Android and iOS devices and can be customized using the My JBL Headphones app, which offers access to additional features such as EQ settings and firmware updates.'),
('JBL - Tune Flex - Black', 99.00, 7, 13, 50, 'The JBL Tune Flex are wireless neckband earphones designed for convenience, comfort, and quality sound, offering a versatile listening experience suitable for various activities.

Comfort and portability are emphasized in the design of the Tune Flex. The lightweight and flexible neckband design ensures a comfortable fit for extended wear, making them ideal for daily commutes, workouts, or long listening sessions.

The earphones feature magnetic earbuds that can be clipped together when not in use, reducing tangling and making them easy to carry around. This magnetic feature also automatically pauses the music when the earbuds are clipped together, allowing users to quickly resume playback when they''re ready to listen again.

Sound quality is a priority for JBL, and the Tune Flex deliver a balanced audio experience with clear highs, detailed mids, and punchy bass. Whether you''re listening to music, watching videos, or taking calls, the earphones provide immersive sound that enhances the overall listening experience.

Battery life is impressive on the Tune Flex, offering up to 8 hours of continuous playback on a single charge. The earphones also feature quick charging support, allowing for up to 1 hour of playback with just a 10-minute charge, ensuring that users can always have their earphones ready when needed.

The Tune Flex come with a built-in microphone for hands-free calls and voice assistant access, allowing users to easily make and receive calls or control their smartphone using voice commands. They are compatible with both Android and iOS devices, providing flexibility and convenience for users across different platforms.'),
('JBL - Tune Flex - White', 99.00, 7, 13, 50, 'The JBL Tune Flex are wireless neckband earphones designed for convenience, comfort, and quality sound, offering a versatile listening experience suitable for various activities.

Comfort and portability are emphasized in the design of the Tune Flex. The lightweight and flexible neckband design ensures a comfortable fit for extended wear, making them ideal for daily commutes, workouts, or long listening sessions.

The earphones feature magnetic earbuds that can be clipped together when not in use, reducing tangling and making them easy to carry around. This magnetic feature also automatically pauses the music when the earbuds are clipped together, allowing users to quickly resume playback when they''re ready to listen again.

Sound quality is a priority for JBL, and the Tune Flex deliver a balanced audio experience with clear highs, detailed mids, and punchy bass. Whether you''re listening to music, watching videos, or taking calls, the earphones provide immersive sound that enhances the overall listening experience.

Battery life is impressive on the Tune Flex, offering up to 8 hours of continuous playback on a single charge. The earphones also feature quick charging support, allowing for up to 1 hour of playback with just a 10-minute charge, ensuring that users can always have their earphones ready when needed.

The Tune Flex come with a built-in microphone for hands-free calls and voice assistant access, allowing users to easily make and receive calls or control their smartphone using voice commands. They are compatible with both Android and iOS devices, providing flexibility and convenience for users across different platforms.'),
('JBL - Tune Flex - Blue', 99.00, 7, 13, 50, 'The JBL Tune Flex are wireless neckband earphones designed for convenience, comfort, and quality sound, offering a versatile listening experience suitable for various activities.

Comfort and portability are emphasized in the design of the Tune Flex. The lightweight and flexible neckband design ensures a comfortable fit for extended wear, making them ideal for daily commutes, workouts, or long listening sessions.

The earphones feature magnetic earbuds that can be clipped together when not in use, reducing tangling and making them easy to carry around. This magnetic feature also automatically pauses the music when the earbuds are clipped together, allowing users to quickly resume playback when they''re ready to listen again.

Sound quality is a priority for JBL, and the Tune Flex deliver a balanced audio experience with clear highs, detailed mids, and punchy bass. Whether you''re listening to music, watching videos, or taking calls, the earphones provide immersive sound that enhances the overall listening experience.

Battery life is impressive on the Tune Flex, offering up to 8 hours of continuous playback on a single charge. The earphones also feature quick charging support, allowing for up to 1 hour of playback with just a 10-minute charge, ensuring that users can always have their earphones ready when needed.

The Tune Flex come with a built-in microphone for hands-free calls and voice assistant access, allowing users to easily make and receive calls or control their smartphone using voice commands. They are compatible with both Android and iOS devices, providing flexibility and convenience for users across different platforms.'),
('JBL - Vibe Beam - Black', 49.00, 7, 13, 50, 'JBL Vibe Beam are true wireless earbuds aiming to be your everyday audio companion. They focus on three key features: impactful sound, comfortable fit, and practical functionality.

JBL''s Deep Bass Sound ensures you experience rich audio with a strong bass presence. The ergonomic design with a closed back conforms to your ears for a secure and comfortable fit. This design also blocks some external noise, further enhancing the bass response.

The Vibe Beam boasts a long battery life, offering up to 32 hours of total playtime. The earbuds themselves hold 8 hours, and the charging case provides an additional 24 hours. Even when caught off guard by a low battery, a quick 10-minute charge provides 2 hours of playback.

JBL equips the Vibe Beam for your active lifestyle with water and dust resistance. This makes them suitable for workouts or even light rain without worry. The built-in microphone allows for clear calls, while a unique feature called VoiceAware lets you adjust how much of your own voice you hear during conversations.

For those times you need to be aware of your surroundings, the Vibe Beam offers both Ambient Aware and TalkThru modes. Ambient Aware lets you hear background noise without removing the earbuds, while TalkThru allows for brief conversations without taking them out entirely.

Finally, the JBL Vibe Beam is compatible with the JBL Headphones App, which unlocks additional controls and functionalities for your earbuds.'),
('JBL - Vibe Beam - White', 49.00, 7, 13, 50, 'JBL Vibe Beam are true wireless earbuds aiming to be your everyday audio companion. They focus on three key features: impactful sound, comfortable fit, and practical functionality.

JBL''s Deep Bass Sound ensures you experience rich audio with a strong bass presence. The ergonomic design with a closed back conforms to your ears for a secure and comfortable fit. This design also blocks some external noise, further enhancing the bass response.

The Vibe Beam boasts a long battery life, offering up to 32 hours of total playtime. The earbuds themselves hold 8 hours, and the charging case provides an additional 24 hours. Even when caught off guard by a low battery, a quick 10-minute charge provides 2 hours of playback.

JBL equips the Vibe Beam for your active lifestyle with water and dust resistance. This makes them suitable for workouts or even light rain without worry. The built-in microphone allows for clear calls, while a unique feature called VoiceAware lets you adjust how much of your own voice you hear during conversations.

For those times you need to be aware of your surroundings, the Vibe Beam offers both Ambient Aware and TalkThru modes. Ambient Aware lets you hear background noise without removing the earbuds, while TalkThru allows for brief conversations without taking them out entirely.

Finally, the JBL Vibe Beam is compatible with the JBL Headphones App, which unlocks additional controls and functionalities for your earbuds.');




INSERT INTO smartphones (id, screen_size, screen_resolution, ram, storage, battery_capacity, front_camera, rear_camera, refresh_rate, color, operating_system, year_of_release) VALUES
(1, '6.1 inches', '2556 x 1179 pixels', '8 GB', '128 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 'iOS', 2023),
(2, '6.1 inches', '2556 x 1179 pixels', '8 GB', '128 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2023),
(3, '6.1 inches', '2556 x 1179 pixels', '8 GB', '128 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'blue', 'iOS', 2023),
(4, '6.1 inches', '2556 x 1179 pixels', '8 GB', '128 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'natural', 'iOS', 2023),
(5, '6.1 inches', '2556 x 1179 pixels', '8 GB', '256 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 'iOS', 2023),
(6, '6.1 inches', '2556 x 1179 pixels', '8 GB', '256 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2023),
(7, '6.1 inches', '2556 x 1179 pixels', '8 GB', '256 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'blue', 'iOS', 2023),
(8, '6.1 inches', '2556 x 1179 pixels', '8 GB', '256 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'natural', 'iOS', 2023),
(9, '6.1 inches', '2556 x 1179 pixels', '8 GB', '512 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 'iOS', 2023),
(10, '6.1 inches', '2556 x 1179 pixels', '8 GB', '512 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2023),
(11, '6.1 inches', '2556 x 1179 pixels', '8 GB', '512 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'blue', 'iOS', 2023),
(12, '6.1 inches', '2556 x 1179 pixels', '8 GB', '512 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'natural', 'iOS', 2023),
(13, '6.1 inches', '2556 x 1179 pixels', '8 GB', '1 TB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 'iOS', 2023),
(14, '6.1 inches', '2556 x 1179 pixels', '8 GB', '1 TB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2023),
(15, '6.1 inches', '2556 x 1179 pixels', '8 GB', '1 TB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'blue', 'iOS', 2023),
(16, '6.1 inches', '2556 x 1179 pixels', '8 GB', '1 TB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'natural', 'iOS', 2023),
(17, '6.7 inches', '2796 x 1290 pixels', '8 GB', '256 GB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 'iOS', 2023),
(18, '6.7 inches', '2796 x 1290 pixels', '8 GB', '256 GB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2023),
(19, '6.7 inches', '2796 x 1290 pixels', '8 GB', '256 GB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'blue', 'iOS', 2023),
(20, '6.7 inches', '2796 x 1290 pixels', '8 GB', '256 GB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'natural', 'iOS', 2023),
(21, '6.7 inches', '2796 x 1290 pixels', '8 GB', '512 GB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 'iOS', 2023),
(22, '6.7 inches', '2796 x 1290 pixels', '8 GB', '512 GB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2023),
(23, '6.7 inches', '2796 x 1290 pixels', '8 GB', '512 GB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'blue', 'iOS', 2023),
(24, '6.7 inches', '2796 x 1290 pixels', '8 GB', '512 GB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'natural', 'iOS', 2023),
(25, '6.7 inches', '2796 x 1290 pixels', '8 GB', '1 TB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 'iOS', 2023),
(26, '6.7 inches', '2796 x 1290 pixels', '8 GB', '1 TB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2023),
(27, '6.7 inches', '2796 x 1290 pixels', '8 GB', '1 TB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'blue', 'iOS', 2023),
(28, '6.7 inches', '2796 x 1290 pixels', '8 GB', '1 TB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'natural', 'iOS', 2023),
(29, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'black', 'iOS', 2023),
(30, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'yellow', 'iOS', 2023),
(31, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'blue', 'iOS', 2023),
(32, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'pink', 'iOS', 2023),
(33, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'green', 'iOS', 2023),
(34, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'black', 'iOS', 2023),
(35, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'yellow', 'iOS', 2023),
(36, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'blue', 'iOS', 2023),
(37, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'pink', 'iOS', 2023),
(38, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'green', 'iOS', 2023),
(39, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'black', 'iOS', 2023),
(40, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'yellow', 'iOS', 2023),
(41, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'blue', 'iOS', 2023),
(42, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'pink', 'iOS', 2023),
(43, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'green', 'iOS', 2023),
(44, '6.7 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'black', 'iOS', 2023),
(45, '6.7 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'yellow', 'iOS', 2023),
(46, '6.7 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'blue', 'iOS', 2023),
(47, '6.7 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'pink', 'iOS', 2023),
(48, '6.7 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'green', 'iOS', 2023),
(49, '6.7 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'black', 'iOS', 2023),
(50, '6.7 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'yellow', 'iOS', 2023),
(51, '6.7 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'blue', 'iOS', 2023),
(52, '6.7 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'pink', 'iOS', 2023),
(53, '6.7 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'green', 'iOS', 2023),
(54, '6.7 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'black', 'iOS', 2023),
(55, '6.7 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'yellow', 'iOS', 2023),
(56, '6.7 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'blue', 'iOS', 2023),
(57, '6.7 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'pink', 'iOS', 2023),
(58, '6.7 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'green', 'iOS', 2023),
(59, '4.7 inches', '1334 x 750 pixels', '4 GB', '64 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'white', 'iOS', 2022),
(60, '4.7 inches', '1334 x 750 pixels', '4 GB', '64 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'red', 'iOS', 2022),
(61, '4.7 inches', '1334 x 750 pixels', '4 GB', '64 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'blue', 'iOS', 2022),
(62, '4.7 inches', '1334 x 750 pixels', '4 GB', '128 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'white', 'iOS', 2022),
(63, '4.7 inches', '1334 x 750 pixels', '4 GB', '128 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'red', 'iOS', 2022),
(64, '4.7 inches', '1334 x 750 pixels', '4 GB', '128 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'blue', 'iOS', 2022),
(65, '4.7 inches', '1334 x 750 pixels', '4 GB', '257 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'white', 'iOS', 2022),
(66, '4.7 inches', '1334 x 750 pixels', '4 GB', '257 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'red', 'iOS', 2022),
(67, '4.7 inches', '1334 x 750 pixels', '4 GB', '257 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'blue', 'iOS', 2022),
(68, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 'iOS', 2022),
(69, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2022),
(70, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'gold', 'iOS', 2022),
(71, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'purple', 'iOS', 2022),
(72, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 'iOS', 2022),
(73, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2022),
(74, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'gold', 'iOS', 2022),
(75, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'purple', 'iOS', 2022),
(76, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 'iOS', 2022),
(77, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2022),
(78, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'gold', 'iOS', 2022),
(79, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'purple', 'iOS', 2022),
(80, '6.1 inches', '2556 x 1179 pixels', '6 GB', '1 TB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 'iOS', 2022),
(81, '6.1 inches', '2556 x 1179 pixels', '6 GB', '1 TB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2022),
(82, '6.1 inches', '2556 x 1179 pixels', '6 GB', '1 TB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'gold', 'iOS', 2022),
(83, '6.1 inches', '2556 x 1179 pixels', '6 GB', '1 TB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'purple', 'iOS', 2022),
(84, '6.7 inches', '2796 x 1290 pixels', '6 GB', '128 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 'iOS', 2022),
(85, '6.7 inches', '2796 x 1290 pixels', '6 GB', '128 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2022),
(86, '6.7 inches', '2796 x 1290 pixels', '6 GB', '128 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'gold', 'iOS', 2022),
(87, '6.7 inches', '2796 x 1290 pixels', '6 GB', '128 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'purple', 'iOS', 2022),
(88, '6.7 inches', '2796 x 1290 pixels', '6 GB', '256 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 'iOS', 2022),
(89, '6.7 inches', '2796 x 1290 pixels', '6 GB', '256 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2022),
(90, '6.7 inches', '2796 x 1290 pixels', '6 GB', '256 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'gold', 'iOS', 2022),
(91, '6.7 inches', '2796 x 1290 pixels', '6 GB', '256 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'purple', 'iOS', 2022),
(92, '6.7 inches', '2796 x 1290 pixels', '6 GB', '512 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 'iOS', 2022),
(93, '6.7 inches', '2796 x 1290 pixels', '6 GB', '512 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2022),
(94, '6.7 inches', '2796 x 1290 pixels', '6 GB', '512 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'gold', 'iOS', 2022),
(95, '6.7 inches', '2796 x 1290 pixels', '6 GB', '512 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'purple', 'iOS', 2022),
(96, '6.7 inches', '2796 x 1290 pixels', '6 GB', '1 TB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 'iOS', 2022),
(97, '6.7 inches', '2796 x 1290 pixels', '6 GB', '1 TB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2022),
(98, '6.7 inches', '2796 x 1290 pixels', '6 GB', '1 TB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'gold', 'iOS', 2022),
(99, '6.7 inches', '2796 x 1290 pixels', '6 GB', '1 TB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'purple', 'iOS', 2022),
(100, '6.1 inches', '2532 x 1170 pixels', '6 GB', '128 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2022),
(101, '6.1 inches', '2532 x 1170 pixels', '6 GB', '128 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2022),
(102, '6.1 inches', '2532 x 1170 pixels', '6 GB', '128 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 'iOS', 2022),
(103, '6.1 inches', '2532 x 1170 pixels', '6 GB', '128 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'purple', 'iOS', 2022),
(104, '6.1 inches', '2532 x 1170 pixels', '6 GB', '256 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2022),
(105, '6.1 inches', '2532 x 1170 pixels', '6 GB', '256 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2022),
(106, '6.1 inches', '2532 x 1170 pixels', '6 GB', '256 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 'iOS', 2022),
(107, '6.1 inches', '2532 x 1170 pixels', '6 GB', '256 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'purple', 'iOS', 2022),
(108, '6.1 inches', '2532 x 1170 pixels', '6 GB', '512 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2022),
(109, '6.1 inches', '2532 x 1170 pixels', '6 GB', '512 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2022),
(110, '6.1 inches', '2532 x 1170 pixels', '6 GB', '512 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 'iOS', 2022),
(111, '6.1 inches', '2532 x 1170 pixels', '6 GB', '512 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'purple', 'iOS', 2022),
(112, '6.7 inches', '2778 x 1284 pixels', '6 GB', '128 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2022),
(113, '6.7 inches', '2778 x 1284 pixels', '6 GB', '128 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2022),
(114, '6.7 inches', '2778 x 1284 pixels', '6 GB', '128 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 'iOS', 2022),
(115, '6.7 inches', '2778 x 1284 pixels', '6 GB', '128 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'purple', 'iOS', 2022),
(116, '6.7 inches', '2778 x 1284 pixels', '6 GB', '256 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2022),
(117, '6.7 inches', '2778 x 1284 pixels', '6 GB', '256 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2022),
(118, '6.7 inches', '2778 x 1284 pixels', '6 GB', '256 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 'iOS', 2022),
(119, '6.7 inches', '2778 x 1284 pixels', '6 GB', '256 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'purple', 'iOS', 2022),
(120, '6.7 inches', '2778 x 1284 pixels', '6 GB', '512 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2022),
(121, '6.7 inches', '2778 x 1284 pixels', '6 GB', '512 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2022),
(122, '6.7 inches', '2778 x 1284 pixels', '6 GB', '512 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 'iOS', 2022),
(123, '6.7 inches', '2778 x 1284 pixels', '6 GB', '512 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'purple', 'iOS', 2022),
(124, '6.1 inches', '2532 x 1170 pixels', '6 GB', '128 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'blue', 'iOS', 2021),
(125, '6.1 inches', '2532 x 1170 pixels', '6 GB', '128 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'graphite', 'iOS', 2021),
(126, '6.1 inches', '2532 x 1170 pixels', '6 GB', '128 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2021),
(127, '6.1 inches', '2532 x 1170 pixels', '6 GB', '128 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'gold', 'iOS', 2021),
(128, '6.1 inches', '2532 x 1170 pixels', '6 GB', '256 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'blue', 'iOS', 2021),
(129, '6.1 inches', '2532 x 1170 pixels', '6 GB', '256 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'graphite', 'iOS', 2021),
(130, '6.1 inches', '2532 x 1170 pixels', '6 GB', '256 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2021),
(131, '6.1 inches', '2532 x 1170 pixels', '6 GB', '256 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'gold', 'iOS', 2021),
(132, '6.1 inches', '2532 x 1170 pixels', '6 GB', '512 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'blue', 'iOS', 2021),
(133, '6.1 inches', '2532 x 1170 pixels', '6 GB', '512 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'graphite', 'iOS', 2021),
(134, '6.1 inches', '2532 x 1170 pixels', '6 GB', '512 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2021),
(135, '6.1 inches', '2532 x 1170 pixels', '6 GB', '512 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'gold', 'iOS', 2021),
(136, '6.1 inches', '2532 x 1170 pixels', '6 GB', '1 TB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'blue', 'iOS', 2021),
(137, '6.1 inches', '2532 x 1170 pixels', '6 GB', '1 TB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'graphite', 'iOS', 2021),
(138, '6.1 inches', '2532 x 1170 pixels', '6 GB', '1 TB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2021),
(139, '6.1 inches', '2532 x 1170 pixels', '6 GB', '1 TB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'gold', 'iOS', 2021),
(140, '6.7 inches', '2778 x 1284 pixels', '6 GB', '128 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'blue', 'iOS', 2021),
(141, '6.7 inches', '2778 x 1284 pixels', '6 GB', '128 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'graphite', 'iOS', 2021),
(142, '6.7 inches', '2778 x 1284 pixels', '6 GB', '128 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2021),
(143, '6.7 inches', '2778 x 1284 pixels', '6 GB', '128 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'gold', 'iOS', 2021),
(144, '6.7 inches', '2778 x 1284 pixels', '6 GB', '256 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'blue', 'iOS', 2021),
(145, '6.7 inches', '2778 x 1284 pixels', '6 GB', '256 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'graphite', 'iOS', 2021),
(146, '6.7 inches', '2778 x 1284 pixels', '6 GB', '256 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2021),
(147, '6.7 inches', '2778 x 1284 pixels', '6 GB', '256 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'gold', 'iOS', 2021),
(148, '6.7 inches', '2778 x 1284 pixels', '6 GB', '512 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'blue', 'iOS', 2021),
(149, '6.7 inches', '2778 x 1284 pixels', '6 GB', '512 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'graphite', 'iOS', 2021),
(150, '6.7 inches', '2778 x 1284 pixels', '6 GB', '512 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2021),
(151, '6.7 inches', '2778 x 1284 pixels', '6 GB', '512 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'gold', 'iOS', 2021),
(152, '6.7 inches', '2778 x 1284 pixels', '6 GB', '1 TB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'blue', 'iOS', 2021),
(153, '6.7 inches', '2778 x 1284 pixels', '6 GB', '1 TB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'graphite', 'iOS', 2021),
(154, '6.7 inches', '2778 x 1284 pixels', '6 GB', '1 TB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'white', 'iOS', 2021),
(155, '6.7 inches', '2778 x 1284 pixels', '6 GB', '1 TB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'gold', 'iOS', 2021),
(156, '6.1 inches', '2532 x 1170 pixels', '4 GB', '128 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 'iOS', 2021),
(157, '6.1 inches', '2532 x 1170 pixels', '4 GB', '128 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2021),
(158, '6.1 inches', '2532 x 1170 pixels', '4 GB', '128 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2021),
(159, '6.1 inches', '2532 x 1170 pixels', '4 GB', '128 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'green', 'iOS', 2021),
(160, '6.1 inches', '2532 x 1170 pixels', '4 GB', '256 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 'iOS', 2021),
(161, '6.1 inches', '2532 x 1170 pixels', '4 GB', '256 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2021),
(162, '6.1 inches', '2532 x 1170 pixels', '4 GB', '256 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2021),
(163, '6.1 inches', '2532 x 1170 pixels', '4 GB', '256 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'green', 'iOS', 2021),
(164, '6.1 inches', '2532 x 1170 pixels', '4 GB', '512 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 'iOS', 2021),
(165, '6.1 inches', '2532 x 1170 pixels', '4 GB', '512 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2021),
(166, '6.1 inches', '2532 x 1170 pixels', '4 GB', '512 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2021),
(167, '6.1 inches', '2532 x 1170 pixels', '4 GB', '512 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'green', 'iOS', 2021),
(168, '5.4 inches', '2340 x 1080 pixels', '4 GB', '128 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 'iOS', 2021),
(169, '5.4 inches', '2340 x 1080 pixels', '4 GB', '128 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2022),
(170, '5.4 inches', '2340 x 1080 pixels', '4 GB', '128 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2021),
(171, '5.4 inches', '2340 x 1080 pixels', '4 GB', '128 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'green', 'iOS', 2021),
(172, '5.4 inches', '2340 x 1080 pixels', '4 GB', '256 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 'iOS', 2021),
(173, '5.4 inches', '2340 x 1080 pixels', '4 GB', '256 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2021),
(174, '5.4 inches', '2340 x 1080 pixels', '4 GB', '256 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2021),
(175, '5.4 inches', '2340 x 1080 pixels', '4 GB', '256 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'green', 'iOS', 2021),
(176, '5.4 inches', '2340 x 1080 pixels', '4 GB', '512 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 'iOS', 2021),
(177, '5.4 inches', '2340 x 1080 pixels', '4 GB', '512 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2021),
(178, '5.4 inches', '2340 x 1080 pixels', '4 GB', '512 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 'iOS', 2021),
(179, '5.4 inches', '2340 x 1080 pixels', '4 GB', '512 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'green', 'iOS', 2021),
(180, '6.6 inches', '2340 x 1080 pixels', '8 GB', '128 GB', '5000 mAh', '32 MP', '50 + 12 + 5 MP', '120 Hz', 'blue', 'Android', 2024),
(181, '6.6 inches', '2340 x 1080 pixels', '8 GB', '256 GB', '5000 mAh', '32 MP', '50 + 12 + 5 MP', '120 Hz', 'blue', 'Android', 2024),
(182, '6.6 inches', '2340 x 1080 pixels', '12 GB', '256 GB', '5000 mAh', '32 MP', '50 + 12 + 5 MP', '120 Hz', 'blue', 'Android', 2024),
(183, '6.6 inches', '2340 x 1080 pixels', '8 GB', '128 GB', '5000 mAh', '32 MP', '50 + 12 + 5 MP', '120 Hz', 'purple', 'Android', 2024),
(184, '6.6 inches', '2340 x 1080 pixels', '8 GB', '256 GB', '5000 mAh', '32 MP', '50 + 12 + 5 MP', '120 Hz', 'purple', 'Android', 2024),
(185, '6.6 inches', '2340 x 1080 pixels', '12 GB', '256 GB', '5000 mAh', '32 MP', '50 + 12 + 5 MP', '120 Hz', 'purple', 'Android', 2024),
(186, '6.6 inches', '2340 x 1080 pixels', '8 GB', '128 GB', '5000 mAh', '32 MP', '50 + 12 + 5 MP', '120 Hz', 'blue', 'Android', 2024),
(187, '6.6 inches', '2340 x 1080 pixels', '8 GB', '256 GB', '5000 mAh', '32 MP', '50 + 12 + 5 MP', '120 Hz', 'blue', 'Android', 2024),
(188, '6.6 inches', '2340 x 1080 pixels', '12 GB', '256 GB', '5000 mAh', '32 MP', '50 + 12 + 5 MP', '120 Hz', 'blue', 'Android', 2024),
(189, '6.6 inches', '2340 x 1080 pixels', '8 GB', '128 GB', '5000 mAh', '32 MP', '50 + 12 + 5 MP', '120 Hz', 'yellow', 'Android', 2024),
(190, '6.6 inches', '2340 x 1080 pixels', '8 GB', '256 GB', '5000 mAh', '32 MP', '50 + 12 + 5 MP', '120 Hz', 'yellow', 'Android', 2024),
(191, '6.6 inches', '2340 x 1080 pixels', '12 GB', '256 GB', '5000 mAh', '32 MP', '50 + 12 + 5 MP', '120 Hz', 'yellow', 'Android', 2024),
(192, '6.7 inches', '2640 x 1080 pixels', '8 GB', '256 GB', '3700 mAh', '10 MP', '12 + 12 MP', '120 Hz', 'mint', 'Android', 2023),
(193, '6.7 inches', '2640 x 1080 pixels', '8 GB', '256 GB', '3700 mAh', '10 MP', '12 + 12 MP', '120 Hz', 'cream', 'Android', 2023),
(194, '6.7 inches', '2640 x 1080 pixels', '8 GB', '256 GB', '3700 mAh', '10 MP', '12 + 12 MP', '120 Hz', 'purple', 'Android', 2023),
(195, '6.7 inches', '2640 x 1080 pixels', '8 GB', '256 GB', '3700 mAh', '10 MP', '12 + 12 MP', '120 Hz', 'graphite', 'Android', 2023),
(196, '6.7 inches', '2640 x 1080 pixels', '8 GB', '512 GB', '3700 mAh', '10 MP', '12 + 12 MP', '120 Hz', 'mint', 'Android', 2023),
(197, '6.7 inches', '2640 x 1080 pixels', '8 GB', '512 GB', '3700 mAh', '10 MP', '12 + 12 MP', '120 Hz', 'cream', 'Android', 2023),
(198, '6.7 inches', '2640 x 1080 pixels', '8 GB', '512 GB', '3700 mAh', '10 MP', '12 + 12 MP', '120 Hz', 'purple', 'Android', 2023),
(199, '6.7 inches', '2640 x 1080 pixels', '8 GB', '512 GB', '3700 mAh', '10 MP', '12 + 12 MP', '120 Hz', 'graphite', 'Android', 2023),
(200, '7.6 inches', '2176 x 1812 pixels', '12 GB', '256 GB', '4400 mAh', '10 + 4 MP', '50 + 10 + 12 MP', '120 Hz', 'blue', 'Android', 2023),
(201, '7.6 inches', '2176 x 1812 pixels', '12 GB', '256 GB', '4400 mAh', '10 + 4 MP', '50 + 10 + 12 MP', '120 Hz', 'cream', 'Android', 2023),
(202, '7.6 inches', '2176 x 1812 pixels', '12 GB', '256 GB', '4400 mAh', '10 + 4 MP', '50 + 10 + 12 MP', '120 Hz', 'black', 'Android', 2023),
(203, '7.6 inches', '2176 x 1812 pixels', '12 GB', '512 GB', '4400 mAh', '10 + 4 MP', '50 + 10 + 12 MP', '120 Hz', 'blue', 'Android', 2023),
(204, '7.6 inches', '2176 x 1812 pixels', '12 GB', '512 GB', '4400 mAh', '10 + 4 MP', '50 + 10 + 12 MP', '120 Hz', 'cream', 'Android', 2023),
(205, '7.6 inches', '2176 x 1812 pixels', '12 GB', '512 GB', '4400 mAh', '10 + 4 MP', '50 + 10 + 12 MP', '120 Hz', 'black', 'Android', 2023),
(206, '7.6 inches', '2176 x 1812 pixels', '12 GB', '1 TB', '4400 mAh', '10 + 4 MP', '50 + 10 + 12 MP', '120 Hz', 'blue', 'Android', 2023),
(207, '7.6 inches', '2176 x 1812 pixels', '12 GB', '1 TB', '4400 mAh', '10 + 4 MP', '50 + 10 + 12 MP', '120 Hz', 'cream', 'Android', 2023),
(208, '7.6 inches', '2176 x 1812 pixels', '12 GB', '1 TB', '4400 mAh', '10 + 4 MP', '50 + 10 + 12 MP', '120 Hz', 'black', 'Android', 2023),
(209, '6.8 inches', '3120 x 1440 pixels', '12 GB', '256 GB', '5000 mAh', '12 MP', '200 + 10 + 50 + 12 MP', '120 Hz', 'black', 'Android', 2024),
(210, '6.8 inches', '3120 x 1440 pixels', '12 GB', '256 GB', '5000 mAh', '12 MP', '200 + 10 + 50 + 12 MP', '120 Hz', 'grey', 'Android', 2024),
(211, '6.8 inches', '3120 x 1440 pixels', '12 GB', '256 GB', '5000 mAh', '12 MP', '200 + 10 + 50 + 12 MP', '120 Hz', 'purple', 'Android', 2024),
(212, '6.8 inches', '3120 x 1440 pixels', '12 GB', '256 GB', '5000 mAh', '12 MP', '200 + 10 + 50 + 12 MP', '120 Hz', 'yellow', 'Android', 2024),
(213, '6.8 inches', '3120 x 1440 pixels', '12 GB', '512 GB', '5000 mAh', '12 MP', '200 + 10 + 50 + 12 MP', '120 Hz', 'black', 'Android', 2024),
(214, '6.8 inches', '3120 x 1440 pixels', '12 GB', '512 GB', '5000 mAh', '12 MP', '200 + 10 + 50 + 12 MP', '120 Hz', 'grey', 'Android', 2024),
(215, '6.8 inches', '3120 x 1440 pixels', '12 GB', '512 GB', '5000 mAh', '12 MP', '200 + 10 + 50 + 12 MP', '120 Hz', 'purple', 'Android', 2024),
(216, '6.8 inches', '3120 x 1440 pixels', '12 GB', '512 GB', '5000 mAh', '12 MP', '200 + 10 + 50 + 12 MP', '120 Hz', 'yellow', 'Android', 2024),
(217, '6.8 inches', '3120 x 1440 pixels', '12 GB', '1 TB', '5000 mAh', '12 MP', '200 + 10 + 50 + 12 MP', '120 Hz', 'black', 'Android', 2024),
(218, '6.8 inches', '3120 x 1440 pixels', '12 GB', '1 TB', '5000 mAh', '12 MP', '200 + 10 + 50 + 12 MP', '120 Hz', 'grey', 'Android', 2024),
(219, '6.8 inches', '3120 x 1440 pixels', '12 GB', '1 TB', '5000 mAh', '12 MP', '200 + 10 + 50 + 12 MP', '120 Hz', 'purple', 'Android', 2024),
(220, '6.8 inches', '3120 x 1440 pixels', '12 GB', '1 TB', '5000 mAh', '12 MP', '200 + 10 + 50 + 12 MP', '120 Hz', 'yellow', 'Android', 2024),
(221, '6.2 inches', '2340 x 1080 pixels', '8 GB', '128 GB', '4000 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'black', 'Android', 2024),
(222, '6.2 inches', '2340 x 1080 pixels', '8 GB', '128 GB', '4000 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'grey', 'Android', 2024),
(223, '6.2 inches', '2340 x 1080 pixels', '8 GB', '128 GB', '4000 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'purple', 'Android', 2024),
(224, '6.2 inches', '2340 x 1080 pixels', '8 GB', '128 GB', '4000 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'yellow', 'Android', 2024),
(225, '6.2 inches', '2340 x 1080 pixels', '8 GB', '256 GB', '4000 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'black', 'Android', 2024),
(226, '6.2 inches', '2340 x 1080 pixels', '8 GB', '256 GB', '4000 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'grey', 'Android', 2024),
(227, '6.2 inches', '2340 x 1080 pixels', '8 GB', '256 GB', '4000 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'purple', 'Android', 2024),
(228, '6.2 inches', '2340 x 1080 pixels', '8 GB', '256 GB', '4000 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'yellow', 'Android', 2024),
(229, '6.2 inches', '2340 x 1080 pixels', '8 GB', '512 GB', '4000 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'black', 'Android', 2024),
(230, '6.2 inches', '2340 x 1080 pixels', '8 GB', '512 GB', '4000 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'grey', 'Android', 2024),
(231, '6.2 inches', '2340 x 1080 pixels', '8 GB', '512 GB', '4000 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'purple', 'Android', 2024),
(232, '6.2 inches', '2340 x 1080 pixels', '8 GB', '512 GB', '4000 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'yellow', 'Android', 2024),
(233, '6.7 inches', '3120 x 1440 pixels', '12 GB', '256 GB', '4900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'black', 'Android', 2024),
(234, '6.7 inches', '3120 x 1440 pixels', '12 GB', '256 GB', '4900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'grey', 'Android', 2024),
(235, '6.7 inches', '3120 x 1440 pixels', '12 GB', '256 GB', '4900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'purple', 'Android', 2024),
(236, '6.7 inches', '3120 x 1440 pixels', '12 GB', '256 GB', '4900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'yellow', 'Android', 2024),
(237, '6.7 inches', '3120 x 1440 pixels', '12 GB', '512 GB', '4900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'black', 'Android', 2024),
(238, '6.7 inches', '3120 x 1440 pixels', '12 GB', '512 GB', '4900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'grey', 'Android', 2024),
(239, '6.7 inches', '3120 x 1440 pixels', '12 GB', '512 GB', '4900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'purple', 'Android', 2024),
(240, '6.7 inches', '3120 x 1440 pixels', '12 GB', '512 GB', '4900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'yellow', 'Android', 2024),
(241, '6.1 inches', '2340 x 1080 pixels', '8 GB', '128 GB', '3900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'black', 'Android', 2023),
(242, '6.1 inches', '2340 x 1080 pixels', '8 GB', '128 GB', '3900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'graphite', 'Android', 2023),
(243, '6.1 inches', '2340 x 1080 pixels', '8 GB', '128 GB', '3900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'green', 'Android', 2023),
(244, '6.1 inches', '2340 x 1080 pixels', '8 GB', '128 GB', '3900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'cream', 'Android', 2023),
(245, '6.1 inches', '2340 x 1080 pixels', '8 GB', '256 GB', '3900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'black', 'Android', 2023),
(246, '6.1 inches', '2340 x 1080 pixels', '8 GB', '256 GB', '3900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'graphite', 'Android', 2023),
(247, '6.1 inches', '2340 x 1080 pixels', '8 GB', '256 GB', '3900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'green', 'Android', 2023),
(248, '6.1 inches', '2340 x 1080 pixels', '8 GB', '256 GB', '3900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'cream', 'Android', 2023),
(249, '6.1 inches', '2340 x 1080 pixels', '8 GB', '512 GB', '3900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'black', 'Android', 2023),
(250, '6.1 inches', '2340 x 1080 pixels', '8 GB', '512 GB', '3900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'graphite', 'Android', 2023),
(251, '6.1 inches', '2340 x 1080 pixels', '8 GB', '512 GB', '3900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'green', 'Android', 2023),
(252, '6.1 inches', '2340 x 1080 pixels', '8 GB', '512 GB', '3900 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'cream', 'Android', 2023),
(253, '6.6 inches', '2340 x 1080 pixels', '8 GB', '256 GB', '4700 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'black', 'Android', 2023),
(254, '6.6 inches', '2340 x 1080 pixels', '8 GB', '256 GB', '4700 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'graphite', 'Android', 2023),
(255, '6.6 inches', '2340 x 1080 pixels', '8 GB', '256 GB', '4700 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'green', 'Android', 2023),
(256, '6.6 inches', '2340 x 1080 pixels', '8 GB', '256 GB', '4700 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'cream', 'Android', 2023),
(257, '6.6 inches', '2340 x 1080 pixels', '8 GB', '512 GB', '4700 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'black', 'Android', 2023),
(258, '6.6 inches', '2340 x 1080 pixels', '8 GB', '512 GB', '4700 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'graphite', 'Android', 2023),
(259, '6.6 inches', '2340 x 1080 pixels', '8 GB', '512 GB', '4700 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'green', 'Android', 2023),
(260, '6.6 inches', '2340 x 1080 pixels', '8 GB', '512 GB', '4700 mAh', '12 MP', '50 + 10 + 12 MP', '120 Hz', 'cream', 'Android', 2023),
(261, '6.67 inches', '2400 x 1080 pixels', '6 GB', '128 GB', '4500 mAh', '16 MP', '108 + 8 + 2 MP', '90 Hz', 'black', 'Android', 2022),
(262, '6.67 inches', '2400 x 1080 pixels', '6 GB', '128 GB', '4500 mAh', '16 MP', '108 + 8 + 2 MP', '90 Hz', 'silver', 'Android', 2022),
(263, '6.67 inches', '2400 x 1080 pixels', '8 GB', '128 GB', '4500 mAh', '16 MP', '108 + 8 + 2 MP', '90 Hz', 'black', 'Android', 2022),
(264, '6.67 inches', '2400 x 1080 pixels', '8 GB', '128 GB', '4500 mAh', '16 MP', '108 + 8 + 2 MP', '90 Hz', 'silver', 'Android', 2022),
(265, '6.67 inches', '2400 x 1080 pixels', '8 GB', '256 GB', '4500 mAh', '16 MP', '108 + 8 + 2 MP', '90 Hz', 'black', 'Android', 2022),
(266, '6.67 inches', '2400 x 1080 pixels', '8 GB', '256 GB', '4500 mAh', '16 MP', '108 + 8 + 2 MP', '90 Hz', 'silver', 'Android', 2022),
(267, '6.67 inches', '2400 x 1080 pixels', '8 GB', '256 GB', '4500 mAh', '32 MP', '108 + 8 + 2 MP', '90 Hz', 'green', 'Android', 2024),
(268, '6.95 inches', '2376 x 1080 pixels', '6 GB', '128 GB', '7000 mAh', '8 MP', '108 + 8 + 2 MP', '90 Hz', 'silver', 'Android', 2023),
(269, '6.95 inches', '2376 x 1080 pixels', '8 GB', '128 GB', '7000 mAh', '8 MP', '108 + 8 + 2 MP', '90 Hz', 'silver', 'Android', 2023),
(270, '6.95 inches', '2376 x 1080 pixels', '8 GB', '256 GB', '7000 mAh', '8 MP', '50 + 2 MP', '90 Hz', 'silver', 'Android', 2023),
(271, '6.6 inches', '2760 x 1256 pixels', '12 GB', '256 GB', '4900 mAh', '13 MP', '50 + 12 + 13 MP', '120 Hz', 'black', 'Android', 2024),
(272, '6.6 inches', '2760 x 1256 pixels', '12 GB', '512 GB', '4900 mAh', '13 MP', '50 + 12 + 13 MP', '120 Hz', 'black', 'Android', 2024),
(273, '6.6 inches', '2760 x 1256 pixels', '12 GB', '1 TB', '4900 mAh', '13 MP', '50 + 12 + 13 MP', '120 Hz', 'black', 'Android', 2024),
(274, '6.6 inches', '2760 x 1256 pixels', '12 GB', '256 GB', '4900 mAh', '13 MP', '50 + 12 + 13 MP', '120 Hz', 'white', 'Android', 2024),
(275, '6.6 inches', '2760 x 1256 pixels', '12 GB', '512 GB', '4900 mAh', '13 MP', '50 + 12 + 13 MP', '120 Hz', 'white', 'Android', 2024),
(276, '6.6 inches', '2760 x 1256 pixels', '12 GB', '1 TB', '4900 mAh', '13 MP', '50 + 12 + 13 MP', '120 Hz', 'white', 'Android', 2024),
(277, '6.8 inches', '2844 x 1260 pixels', '12 GB', '256 GB', '5050 mAh', '13 MP', '50 + 48 + 12.5 MP', '120 Hz', 'black', 'Android', 2024),
(278, '6.8 inches', '2844 x 1260 pixels', '12 GB', '512 GB', '5050 mAh', '13 MP', '50 + 48 + 12.5 MP', '120 Hz', 'black', 'Android', 2024),
(279, '6.8 inches', '2844 x 1260 pixels', '12 GB', '1 TB', '5050 mAh', '13 MP', '50 + 48 + 12.5 MP', '120 Hz', 'black', 'Android', 2024),
(280, '6.8 inches', '2844 x 1260 pixels', '12 GB', '256 GB', '5050 mAh', '13 MP', '50 + 48 + 12.5 MP', '120 Hz', 'white', 'Android', 2024),
(281, '6.8 inches', '2844 x 1260 pixels', '12 GB', '512 GB', '5050 mAh', '13 MP', '50 + 48 + 12.5 MP', '120 Hz', 'white', 'Android', 2024),
(282, '6.8 inches', '2844 x 1260 pixels', '12 GB', '1 TB', '5050 mAh', '13 MP', '50 + 48 + 12.5 MP', '120 Hz', 'white', 'Android', 2024),
(283, '6.8 inches', '2844 x 1260 pixels', '16 GB', '512 GB', '5200 mAh', '13 MP', '50 + 50 + 40 MP', '120 Hz', 'black', 'Android', 2024),
(284, '6.8 inches', '2844 x 1260 pixels', '16 GB', '1 TB', '5200 mAh', '13 MP', '50 + 50 + 40 MP', '120 Hz', 'black', 'Android', 2024),
(285, '6.8 inches', '2844 x 1260 pixels', '16 GB', '512 GB', '5200 mAh', '13 MP', '50 + 50 + 40 MP', '120 Hz', 'green', 'Android', 2024),
(286, '6.8 inches', '2844 x 1260 pixels', '16 GB', '1 TB', '5200 mAh', '13 MP', '50 + 50 + 40 MP', '120 Hz', 'green', 'Android', 2024),
(287, '6.7 inches', '2412 x 1080 pixels', '8 GB', '128 GB', '4700 mAh', '32 MP', '50 + 50 MP', '120 Hz', 'black', 'Android', 2023),
(288, '6.7 inches', '2412 x 1080 pixels', '12 GB', '256 GB', '4700 mAh', '32 MP', '50 + 50 MP', '120 Hz', 'black', 'Android', 2023),
(289, '6.7 inches', '2412 x 1080 pixels', '12 GB', '512 GB', '4700 mAh', '32 MP', '50 + 50 MP', '120 Hz', 'black', 'Android', 2023),
(290, '6.7 inches', '2412 x 1080 pixels', '8 GB', '128 GB', '4700 mAh', '32 MP', '50 + 50 MP', '120 Hz', 'white', 'Android', 2023),
(291, '6.7 inches', '2412 x 1080 pixels', '12 GB', '256 GB', '4700 mAh', '32 MP', '50 + 50 MP', '120 Hz', 'white', 'Android', 2023),
(292, '6.7 inches', '2412 x 1080 pixels', '12 GB', '512 GB', '4700 mAh', '32 MP', '50 + 50 MP', '120 Hz', 'white', 'Android', 2023),
(293, '6.7 inches', '2412 x 1080 pixels', '8 GB', '128 GB', '5000 mAh', '32 MP', '50 + 50 MP', '120 Hz', 'black', 'Android', 2024),
(294, '6.7 inches', '2412 x 1080 pixels', '8 GB', '256 GB', '5000 mAh', '32 MP', '50 + 50 MP', '120 Hz', 'black', 'Android', 2024),
(295, '6.7 inches', '2412 x 1080 pixels', '12 GB', '256 GB', '5000 mAh', '32 MP', '50 + 50 MP', '120 Hz', 'black', 'Android', 2024),
(296, '6.7 inches', '2412 x 1080 pixels', '8 GB', '128 GB', '5000 mAh', '32 MP', '50 + 50 MP', '120 Hz', 'white', 'Android', 2024),
(297, '6.7 inches', '2412 x 1080 pixels', '8 GB', '256 GB', '5000 mAh', '32 MP', '50 + 50 MP', '120 Hz', 'white', 'Android', 2024),
(298, '6.7 inches', '2412 x 1080 pixels', '12 GB', '256 GB', '5000 mAh', '32 MP', '50 + 50 MP', '120 Hz', 'white', 'Android', 2024),
(299, '7.6 inches', '2208 x 1840 pixels', '12 GB', '256 GB', '4821 mAh', '8 + 9.5 MP', '48 + 10.8 + 10.8 MP', '120 Hz', 'black', 'Android', 2023),
(300, '7.6 inches', '2208 x 1840 pixels', '12 GB', '512 GB', '4821 mAh', '8 + 9.5 MP', '48 + 10.8 + 10.8 MP', '120 Hz', 'black', 'Android', 2023),
(301, '7.6 inches', '2208 x 1840 pixels', '12 GB', '256 GB', '4821 mAh', '8 + 9.5 MP', '48 + 10.8 + 10.8 MP', '120 Hz', 'porcelain', 'Android', 2023),
(302, '7.6 inches', '2208 x 1840 pixels', '12 GB', '512 GB', '4821 mAh', '8 + 9.5 MP', '48 + 10.8 + 10.8 MP', '120 Hz', 'porcelain', 'Android', 2023),
(303, '6.1 inches', '2400 x 1080 pixels', '8 GB', '128 GB', '4385 mAh', '13 MP', '64 + 13 MP', '90 Hz', 'grey', 'Android', 2023),
(304, '6.1 inches', '2400 x 1080 pixels', '8 GB', '128 GB', '4385 mAh', '13 MP', '64 + 13 MP', '90 Hz', 'blue', 'Android', 2023),
(305, '6.1 inches', '2400 x 1080 pixels', '8 GB', '128 GB', '4385 mAh', '13 MP', '64 + 13 MP', '90 Hz', 'white', 'Android', 2023),
(306, '6.3 inches', '2208 x 1080 pixels', '8 GB', '128 GB', '4355 mAh', '10.8 MP', '50 + 12 MP', '90 Hz', 'green', 'Android', 2022),
(307, '6.3 inches', '2208 x 1080 pixels', '8 GB', '256 GB', '4355 mAh', '10.8 MP', '50 + 12 MP', '90 Hz', 'green', 'Android', 2022),
(308, '6.3 inches', '2208 x 1080 pixels', '8 GB', '128 GB', '4355 mAh', '10.8 MP', '50 + 12 MP', '90 Hz', 'white', 'Android', 2022),
(309, '6.3 inches', '2208 x 1080 pixels', '8 GB', '256 GB', '4355 mAh', '10.8 MP', '50 + 12 MP', '90 Hz', 'white', 'Android', 2022),
(310, '6.7 inches', '3120 x 1440 pixels', '12 GB', '128 GB', '5000 mAh', '10.8 MP', '50 + 48 + 12 MP', '120 Hz', 'black', 'Android', 2022),
(311, '6.7 inches', '3120 x 1440 pixels', '12 GB', '256 GB', '5000 mAh', '10.8 MP', '50 + 48 + 12 MP', '120 Hz', 'black', 'Android', 2022),
(312, '6.7 inches', '3120 x 1440 pixels', '12 GB', '512 GB', '5000 mAh', '10.8 MP', '50 + 48 + 12 MP', '120 Hz', 'black', 'Android', 2022),
(313, '6.7 inches', '3120 x 1440 pixels', '8 GB', '128 GB', '5000 mAh', '10.8 MP', '50 + 48 + 12 MP', '120 Hz', 'black', 'Android', 2022),
(314, '6.7 inches', '3120 x 1440 pixels', '8 GB', '256 GB', '5000 mAh', '10.8 MP', '50 + 48 + 12 MP', '120 Hz', 'black', 'Android', 2022),
(315, '6.7 inches', '2992 x 1344 pixels', '12 GB', '128 GB', '5050 mAh', '10.5 MP', '50 + 48 + 48 MP', '120 Hz', 'black', 'Android', 2023),
(316, '6.7 inches', '2992 x 1344 pixels', '12 GB', '128 GB', '5050 mAh', '10.5 MP', '50 + 48 + 48 MP', '120 Hz', 'porcelain', 'Android', 2023),
(317, '6.7 inches', '2992 x 1344 pixels', '12 GB', '128 GB', '5050 mAh', '10.5 MP', '50 + 48 + 48 MP', '120 Hz', 'blue', 'Android', 2023),
(318, '6.7 inches', '2992 x 1344 pixels', '12 GB', '256 GB', '5050 mAh', '10.5 MP', '50 + 48 + 48 MP', '120 Hz', 'black', 'Android', 2023),
(319, '6.7 inches', '2992 x 1344 pixels', '12 GB', '256 GB', '5050 mAh', '10.5 MP', '50 + 48 + 48 MP', '120 Hz', 'porcelain', 'Android', 2023),
(320, '6.7 inches', '2992 x 1344 pixels', '12 GB', '256 GB', '5050 mAh', '10.5 MP', '50 + 48 + 48 MP', '120 Hz', 'blue', 'Android', 2023),
(321, '6.7 inches', '2992 x 1344 pixels', '12 GB', '512 GB', '5050 mAh', '10.5 MP', '50 + 48 + 48 MP', '120 Hz', 'black', 'Android', 2023),
(322, '6.7 inches', '2992 x 1344 pixels', '12 GB', '512 GB', '5050 mAh', '10.5 MP', '50 + 48 + 48 MP', '120 Hz', 'porcelain', 'Android', 2023),
(323, '6.7 inches', '2992 x 1344 pixels', '12 GB', '512 GB', '5050 mAh', '10.5 MP', '50 + 48 + 48 MP', '120 Hz', 'blue', 'Android', 2023),
(324, '6.7 inches', '2992 x 1344 pixels', '12 GB', '1 TB', '5050 mAh', '10.5 MP', '50 + 48 + 48 MP', '120 Hz', 'black', 'Android', 2023),
(325, '6.7 inches', '2992 x 1344 pixels', '12 GB', '1 TB', '5050 mAh', '10.5 MP', '50 + 48 + 48 MP', '120 Hz', 'porcelain', 'Android', 2023),
(326, '6.7 inches', '2992 x 1344 pixels', '12 GB', '1 TB', '5050 mAh', '10.5 MP', '50 + 48 + 48 MP', '120 Hz', 'blue', 'Android', 2023),
(327, '6.2 inches', '2400 x 1080 pixels', '8 GB', '128 GB', '4575 mAh', '10.5 MP', '50 + 12 MP', '120 Hz', 'black', 'Android', 2023),
(328, '6.2 inches', '2400 x 1080 pixels', '8 GB', '128 GB', '4575 mAh', '10.5 MP', '50 + 12 MP', '120 Hz', 'cream', 'Android', 2023),
(329, '6.2 inches', '2400 x 1080 pixels', '8 GB', '256 GB', '4575 mAh', '10.5 MP', '50 + 12 MP', '120 Hz', 'black', 'Android', 2023),
(330, '6.2 inches', '2400 x 1080 pixels', '8 GB', '256 GB', '4575 mAh', '10.5 MP', '50 + 12 MP', '120 Hz', 'cream', 'Android', 2023),
(331, '6.1 inches', '2400 x 1080 pixels', '8 GB', '128 GB', '4492 mAh', '13 MP', '64 + 13 MP', '120 Hz', 'black', 'Android', 2024),
(332, '6.1 inches', '2400 x 1080 pixels', '8 GB', '128 GB', '4492 mAh', '13 MP', '64 + 13 MP', '120 Hz', 'black', 'Android', 2024),
(333, '6.1 inches', '2400 x 1080 pixels', '8 GB', '128 GB', '4492 mAh', '13 MP', '64 + 13 MP', '120 Hz', 'blue', 'Android', 2024),
(334, '6.1 inches', '2400 x 1080 pixels', '8 GB', '128 GB', '4492 mAh', '13 MP', '64 + 13 MP', '120 Hz', 'blue', 'Android', 2024),
(335, '6.1 inches', '2400 x 1080 pixels', '8 GB', '128 GB', '4492 mAh', '13 MP', '64 + 13 MP', '120 Hz', 'porcelain', 'Android', 2024),
(336, '6.1 inches', '2400 x 1080 pixels', '8 GB', '128 GB', '4492 mAh', '13 MP', '64 + 13 MP', '120 Hz', 'porcelain', 'Android', 2024);



INSERT INTO tablets (id, screen_size, screen_resolution, ram, storage, battery_capacity, front_camera, rear_camera, refresh_rate, color, operating_system, year_of_release) VALUES
(337, '13 inches', '2752 x 2064 pixels', '8 GB', '256 GB', '10340 mAh', '12 MP', '12 MP', '120 Hz', 'black', 'iOS', 2024),
(338, '13 inches', '2752 x 2064 pixels', '8 GB', '512 GB', '10340 mAh', '12 MP', '12 MP', '120 Hz', 'black', 'iOS', 2024),
(339, '13 inches', '2752 x 2064 pixels', '16 GB', '1 TB', '10340 mAh', '12 MP', '12 MP', '120 Hz', 'black', 'iOS', 2024),
(340, '13 inches', '2752 x 2064 pixels', '16 GB', '2 TB', '10340 mAh', '12 MP', '12 MP', '120 Hz', 'black', 'iOS', 2024),
(341, '13 inches', '2752 x 2064 pixels', '8 GB', '256 GB', '10340 mAh', '12 MP', '12 MP', '120 Hz', 'silver', 'iOS', 2024),
(342, '13 inches', '2752 x 2064 pixels', '8 GB', '512 GB', '10340 mAh', '12 MP', '12 MP', '120 Hz', 'silver', 'iOS', 2024),
(343, '13 inches', '2752 x 2064 pixels', '16 GB', '1 TB', '10340 mAh', '12 MP', '12 MP', '120 Hz', 'silver', 'iOS', 2024),
(344, '13 inches', '2752 x 2064 pixels', '16 GB', '2 TB', '10340 mAh', '12 MP', '12 MP', '120 Hz', 'silver', 'iOS', 2024),
(345, '11 inches', '2420 x 1668 pixels', '8 GB', '256 GB', '8340 mAh', '12 MP', '12 MP', '120 Hz', 'black', 'iOS', 2024),
(346, '11 inches', '2420 x 1668 pixels', '8 GB', '512 GB', '8340 mAh', '12 MP', '12 MP', '120 Hz', 'black', 'iOS', 2024),
(347, '11 inches', '2420 x 1668 pixels', '16 GB', '1 TB', '8340mAh', '12 MP', '12 MP', '120 Hz', 'black', 'iOS', 2024),
(348, '11 inches', '2420 x 1668 pixels', '16 GB', '2 TB', '8340mAh', '12 MP', '12 MP', '120 Hz', 'black', 'iOS', 2024),
(349, '11 inches', '2420 x 1668 pixels', '8 GB', '256 GB', '8340 mAh', '12 MP', '12 MP', '120 Hz', 'silver', 'iOS', 2024),
(350, '11 inches', '2420 x 1668 pixels', '8 GB', '512 GB', '8340 mAh', '12 MP', '12 MP', '120 Hz', 'silver', 'iOS', 2024),
(351, '11 inches', '2420 x 1668 pixels', '16 GB', '1 TB', '8340mAh', '12 MP', '12 MP', '120 Hz', 'silver', 'iOS', 2024),
(352, '11 inches', '2420 x 1668 pixels', '16 GB', '2 TB', '8340mAh', '12 MP', '12 MP', '120 Hz', 'silver', 'iOS', 2024),
(353, '13 inches', '2732 x 2048 pixels', '8 GB', '128 GB', '9705 mAh', '12 MP', '12 MP', '60 Hz', 'grey', 'iOS', 2024),
(354, '13 inches', '2732 x 2048 pixels', '8 GB', '256 GB', '9705 mAh', '12 MP', '12 MP', '60 Hz', 'grey', 'iOS', 2024),
(355, '13 inches', '2732 x 2048 pixels', '8 GB', '512 GB', '9705 mAh', '12 MP', '12 MP', '60 Hz', 'grey', 'iOS', 2024),
(356, '13 inches', '2732 x 2048 pixels', '8 GB', '1 TB', '9705 mAh', '12 MP', '12 MP', '60 Hz', 'grey', 'iOS', 2024),
(357, '13 inches', '2732 x 2048 pixels', '8 GB', '128 GB', '9705 mAh', '12 MP', '12 MP', '60 Hz', 'purple', 'iOS', 2024),
(358, '13 inches', '2732 x 2048 pixels', '8 GB', '256 GB', '9705 mAh', '12 MP', '12 MP', '60 Hz', 'purple', 'iOS', 2024),
(359, '13 inches', '2732 x 2048 pixels', '8 GB', '512 GB', '9705 mAh', '12 MP', '12 MP', '60 Hz', 'purple', 'iOS', 2024),
(360, '13 inches', '2732 x 2048 pixels', '8 GB', '1 TB', '9705 mAh', '12 MP', '12 MP', '60 Hz', 'purple', 'iOS', 2024),
(361, '13 inches', '2732 x 2048 pixels', '8 GB', '128 GB', '9705 mAh', '12 MP', '12 MP', '60 Hz', 'white', 'iOS', 2024),
(362, '13 inches', '2732 x 2048 pixels', '8 GB', '256 GB', '9705 mAh', '12 MP', '12 MP', '60 Hz', 'white', 'iOS', 2024),
(363, '13 inches', '2732 x 2048 pixels', '8 GB', '512 GB', '9705 mAh', '12 MP', '12 MP', '60 Hz', 'white', 'iOS', 2024),
(364, '13 inches', '2732 x 2048 pixels', '8 GB', '1 TB', '9705 mAh', '12 MP', '12 MP', '60 Hz', 'white', 'iOS', 2024),
(365, '11 inches', '2360 x 1640 pixels', '8 GB', '128 GB', '7606 mAh', '12 MP', '12 MP', '60 Hz', 'grey', 'iOS', 2024),
(366, '11 inches', '2360 x 1640 pixels', '8 GB', '256 GB', '7606 mAh', '12 MP', '12 MP', '60 Hz', 'grey', 'iOS', 2024),
(367, '11 inches', '2360 x 1640 pixels', '8 GB', '512 GB', '7606 mAh', '12 MP', '12 MP', '60 Hz', 'grey', 'iOS', 2024),
(368, '11 inches', '2360 x 1640 pixels', '8 GB', '1 TB', '7606 mAh', '12 MP', '12 MP', '60 Hz', 'grey', 'iOS', 2024),
(369, '11 inches', '2360 x 1640 pixels', '8 GB', '128 GB', '7606 mAh', '12 MP', '12 MP', '60 Hz', 'purple', 'iOS', 2024),
(370, '11 inches', '2360 x 1640 pixels', '8 GB', '256 GB', '7606 mAh', '12 MP', '12 MP', '60 Hz', 'purple', 'iOS', 2024),
(371, '11 inches', '2360 x 1640 pixels', '8 GB', '512 GB', '7606 mAh', '12 MP', '12 MP', '60 Hz', 'purple', 'iOS', 2024),
(372, '11 inches', '2360 x 1640 pixels', '8 GB', '1 TB', '7606 mAh', '12 MP', '12 MP', '60 Hz', 'purple', 'iOS', 2024),
(373, '11 inches', '2360 x 1640 pixels', '8 GB', '128 GB', '7606 mAh', '12 MP', '12 MP', '60 Hz', 'white', 'iOS', 2024),
(374, '11 inches', '2360 x 1640 pixels', '8 GB', '256 GB', '7606 mAh', '12 MP', '12 MP', '60 Hz', 'white', 'iOS', 2024),
(375, '11 inches', '2360 x 1640 pixels', '8 GB', '512 GB', '7606 mAh', '12 MP', '12 MP', '60 Hz', 'white', 'iOS', 2024),
(376, '11 inches', '2360 x 1640 pixels', '8 GB', '1 TB', '7606 mAh', '12 MP', '12 MP', '60 Hz', 'white', 'iOS', 2024),
(377, '10.9 inches', '2360 x 1640 pixels', '4 GB', '64 GB', '7606 mAh', '12 MP', '12 MP', '60 Hz', 'blue', 'iOS', 2022),
(378, '10.9 inches', '2360 x 1640 pixels', '4 GB', '256 GB', '7606 mAh', '12 MP', '12 MP', '60 Hz', 'blue', 'iOS', 2022),
(379, '10.9 inches', '2360 x 1640 pixels', '4 GB', '64 GB', '7606 mAh', '12 MP', '12 MP', '60 Hz', 'silver', 'iOS', 2022),
(380, '10.9 inches', '2360 x 1640 pixels', '4 GB', '256 GB', '7606 mAh', '12 MP', '12 MP', '60 Hz', 'silver', 'iOS', 2022),
(381, '10.4 inches', '2000 x 1200 pixels', '4 GB', '64 GB', '7250 mAh', '8 MP', '8 MP', '60 Hz', 'grey', 'Android', 2022),
(382, '10.4 inches', '2000 x 1200 pixels', '6 GB', '64 GB', '7250 mAh', '8 MP', '8 MP', '60 Hz', 'grey', 'Android', 2022),
(383, '10.4 inches', '2000 x 1200 pixels', '4 GB', '128 GB', '7250 mAh', '8 MP', '8 MP', '60 Hz', 'grey', 'Android', 2022),
(384, '10.4 inches', '2000 x 1200 pixels', '6 GB', '128 GB', '7250 mAh', '8 MP', '8 MP', '60 Hz', 'grey', 'Android', 2022),
(385, '9.7 inches', '1280 x 800 pixels', '2 GB', '64 GB', '5100 mAh', '2 MP', '5 MP', '60 Hz', 'blue', 'Android', 2021),
(386, '9.7 inches', '1280 x 800 pixels', '4 GB', '64 GB', '5100 mAh', '2 MP', '5 MP', '60 Hz', 'blue', 'Android', 2021),
(387, '10.61 inches', '2000 x 1200 pixels', '3 GB', '32 GB', '7700 mAh', '8 MP', '8 MP', '60 Hz', 'grey', 'Android', 2022),
(388, '10.61 inches', '2000 x 1200 pixels', '4 GB', '64 GB', '7700 mAh', '8 MP', '8 MP', '60 Hz', 'grey', 'Android', 2022),
(389, '10.61 inches', '2000 x 1200 pixels', '4 GB', '128 GB', '7700 mAh', '8 MP', '8 MP', '60 Hz', 'grey', 'Android', 2022),
(390, '10.61 inches', '2000 x 1200 pixels', '6 GB', '128 GB', '7700 mAh', '8 MP', '8 MP', '60 Hz', 'grey', 'Android', 2022),
(391, '11 inches', '1920 x 1200 pixels', '4 GB', '64 GB', '7040 mAh', '8 MP', '13 + 8 MP', '60 Hz', 'grey', 'Android', 2024),
(392, '11 inches', '1920 x 1200 pixels', '4 GB', '128 GB', '7040 mAh', '8 MP', '13 + 8 MP', '60 Hz', 'grey', 'Android', 2024),
(393, '11 inches', '1920 x 1200 pixels', '8 GB', '128 GB', '7040 mAh', '8 MP', '13 + 8 MP', '60 Hz', 'grey', 'Android', 2024),
(394, '11.5 inches', '2000 x 1200 pixels', '4 GB', '64 GB', '7700 mAh', '8 MP', '13 MP', '60 Hz', 'grey', 'Android', 2022),
(395, '11.5 inches', '2000 x 1200 pixels', '4 GB', '128 GB', '7700 mAh', '8 MP', '13 MP', '60 Hz', 'grey', 'Android', 2022),
(396, '11.5 inches', '2000 x 1200 pixels', '6 GB', '256 GB', '7700 mAh', '8 MP', '13 MP', '60 Hz', 'grey', 'Android', 2022),
(397, '12.7 inches', '2944 x 1840 pixels', '4 GB', '128 GB', '10200 mAh', '13 MP', '8 MP', '60 Hz', 'grey', 'Android', 2023),
(398, '12.7 inches', '2944 x 1840 pixels', '8 GB', '128 GB', '10200 mAh', '13 MP', '8 MP', '60 Hz', 'grey', 'Android', 2023),
(399, '12.7 inches', '2944 x 1840 pixels', '8 GB', '256 GB', '10200 mAh', '13 MP', '8 MP', '60 Hz', 'grey', 'Android', 2023),
(400, '12.4 inches', '2800 x 1752 pixels', '12 GB', '256 GB', '10090 mAh', '12 MP', '13 + 8 MP', '120 Hz', 'graphite', 'Android', 2023),
(401, '12.4 inches', '2800 x 1752 pixels', '12 GB', '512 GB', '10090 mAh', '12 MP', '13 + 8 MP', '120 Hz', 'graphite', 'Android', 2023),
(402, '8.7 inches', '1340 x 800 pixels', '4 GB', '64 GB', '5100 mAh', '2 MP', '8 MP', '60 Hz', 'silver', 'Android', 2023),
(403, '8.7 inches', '1340 x 800 pixels', '4 GB', '128 GB', '5100 mAh', '2 MP', '8 MP', '60 Hz', 'silver', 'Android', 2023),
(404, '8.7 inches', '1340 x 800 pixels', '8 GB', '128 GB', '5100 mAh', '2 MP', '8 MP', '60 Hz', 'silver', 'Android', 2023),
(405, '8.7 inches', '1340 x 800 pixels', '4 GB', '64 GB', '5100 mAh', '2 MP', '8 MP', '60 Hz', 'navy', 'Android', 2023),
(406, '8.7 inches', '1340 x 800 pixels', '4 GB', '128 GB', '5100 mAh', '2 MP', '8 MP', '60 Hz', 'navy', 'Android', 2023),
(407, '8.7 inches', '1340 x 800 pixels', '8 GB', '128 GB', '5100 mAh', '2 MP', '8 MP', '60 Hz', 'navy', 'Android', 2023),
(408, '11 inches', '2560 x 1600 pixels', '8 GB', '128 GB', '8400 mAh', '12 MP', '13 MP', '120 Hz', 'graphite', 'Android', 2023),
(409, '11 inches', '2560 x 1600 pixels', '12 GB', '256 GB', '8400 mAh', '12 MP', '13 MP', '120 Hz', 'graphite', 'Android', 2023),
(410, '14.6 inches', '2960 x 1848 pixels', '12 GB', '256 GB', '11200 mAh', '12 + 12 MP', '13 + 8 MP', '120 Hz', 'beige', 'Android', 2023),
(411, '14.6 inches', '2960 x 1848 pixels', '12 GB', '512 GB', '11200 mAh', '12 + 12 MP', '13 + 8 MP', '120 Hz', 'beige', 'Android', 2023),
(412, '14.6 inches', '2960 x 1848 pixels', '12 GB', '1 TB', '11200 mAh', '12 + 12 MP', '13 + 8 MP', '120 Hz', 'beige', 'Android', 2023),
(413, '14.6 inches', '2960 x 1848 pixels', '16 GB', '1 TB', '11200 mAh', '12 + 12 MP', '13 + 8 MP', '120 Hz', 'beige', 'Android', 2023),
(414, '14.6 inches', '2960 x 1848 pixels', '12 GB', '256 GB', '11200 mAh', '12 + 12 MP', '13 + 8 MP', '120 Hz', 'graphite', 'Android', 2023),
(415, '14.6 inches', '2960 x 1848 pixels', '12 GB', '512 GB', '11200 mAh', '12 + 12 MP', '13 + 8 MP', '120 Hz', 'graphite', 'Android', 2023),
(416, '14.6 inches', '2960 x 1848 pixels', '12 GB', '1 TB', '11200 mAh', '12 + 12 MP', '13 + 8 MP', '120 Hz', 'graphite', 'Android', 2023),
(417, '14.6 inches', '2960 x 1848 pixels', '16 GB', '1 TB', '11200 mAh', '12 + 12 MP', '13 + 8 MP', '120 Hz', 'graphite', 'Android', 2023);


INSERT INTO laptops (id,screen_size, screen_resolution, processor, gpu, ram, storage_type, storage, operating_system, color, year_of_release) VALUES
(418, '13.6 inches', '2560 x 1664 pixels', 'Apple M3', 'Apple M3 GPU (10-core)', '8 GB', 'SSD', '512 GB', 'macOS', 'blue', 2024),
(419, '13.6 inches', '2560 x 1664 pixels', 'Apple M3', 'Apple M3 GPU (10-core)', '8 GB', 'SSD', '512 GB', 'macOS', 'blue', 2024),
(420, '13.6 inches', '2560 x 1664 pixels', 'Apple M3', 'Apple M3 GPU (10-core)', '8 GB', 'SSD', '512 GB', 'macOS', 'white', 2024),
(421, '13.6 inches', '2560 x 1664 pixels', 'Apple M3', 'Apple M3 GPU (10-core)', '8 GB', 'SSD', '512 GB', 'macOS', 'white', 2024),
(422, '13.6 inches', '2560 x 1664 pixels', 'Apple M3', 'Apple M3 GPU (10-core)', '8 GB', 'SSD', '512 GB', 'macOS', 'grey', 2024),
(423, '13.6 inches', '2560 x 1664 pixels', 'Apple M3', 'Apple M3 GPU (10-core)', '8 GB', 'SSD', '512 GB', 'macOS', 'grey', 2024),
(424, '15.3 inches', '2880 x 1864 pixels', 'Apple M3', 'Apple M3 GPU (10-core)', '8 GB', 'SSD', '512 GB', 'macOS', 'blue', 2024),
(425, '15.3 inches', '2880 x 1864 pixels', 'Apple M3', 'Apple M3 GPU (10-core)', '16 GB', 'SSD', '512 GB', 'macOS', 'blue', 2024),
(426, '15.3 inches', '2880 x 1864 pixels', 'Apple M3', 'Apple M3 GPU (10-core)', '8 GB', 'SSD', '512 GB', 'macOS', 'white', 2024),
(427, '15.3 inches', '2880 x 1864 pixels', 'Apple M3', 'Apple M3 GPU (10-core)', '16 GB', 'SSD', '512 GB', 'macOS', 'white', 2024),
(428, '15.3 inches', '2880 x 1864 pixels', 'Apple M3', 'Apple M3 GPU (10-core)', '8 GB', 'SSD', '512 GB', 'macOS', 'grey', 2024),
(429, '15.3 inches', '2880 x 1864 pixels', 'Apple M3', 'Apple M3 GPU (10-core)', '16 GB', 'SSD', '512 GB', 'macOS', 'grey', 2024),
(430, '14.2 inches', '3024 x 1964 pixels', 'Apple M3', 'Apple M3 GPU (10-core)', '8 GB', 'SSD', '1 TB', 'macOS', 'silver', 2023),
(431, '14.2 inches', '3024 x 1964 pixels', 'Apple M3', 'Apple M3 GPU (10-core)', '8 GB', 'SSD', '1 TB', 'macOS', 'black', 2023),
(432, '14.2 inches', '3024 x 1964 pixels', 'Apple M3', 'Apple M3 GPU (10-core)', '16 GB', 'SSD', '1 TB', 'macOS', 'silver', 2023),
(433, '14.2 inches', '3024 x 1964 pixels', 'Apple M3', 'Apple M3 GPU (10-core)', '16 GB', 'SSD', '1 TB', 'macOS', 'black', 2023),
(434, '15.6 inches', '1920 x 1080 pixels', 'Intel 12th Generation Core i3', 'Intel UHD Graphics', '8 GB', 'UFS', '128 GB', 'Chrome OS', 'grey', 2023),
(435, '15.6 inches', '1920 x 1080 pixels', 'AMD Ryzen 5 7000 Series', 'AMD Radeon', '8 GB', 'SSD', '512 GB', 'Windows 11', 'blue', 2023),
(436, '15.6 inches', '3024 x 1964 pixels', 'Intel 13th Generation Core i7', 'NVIDIA GeForce RTX 4060', '16 GB', 'SSD', '512 GB', 'Windows 11', 'black', 2024),
(437, '18 inches', '2560 x 1600 pixels', 'Intel Core i9 14th Generation', 'NVIDIA GeForce RTX 4090', '32 GB', 'SSD', '1 TB', 'Windows 11', 'black', 2024),
(438, '16 inches', '2560 x 1600 pixels', 'Intel 12th Generation Core i5', 'Intel Iris Xe Graphics', '8 GB', 'SSD', '256 GB', 'Chrome OS', 'grey', 2022),
(439, '15.6 inches', '1366 x 768 pixels', 'Intel Celeron', 'Intel UHD Graphics 600', '4 GB', 'eMMC', '64 GB', 'Chrome OS', 'silver', 2023),
(440, '16 inches', '1920 x 1200 pixels', 'Intel 13th Generation Core i5', 'NVIDIA GeForce RTX 4050', '16 GB', 'SSD', '512 GB', 'Windows 11', 'grey', 2023),
(441, '15.6 inches', '1920 x 1080 pixels', 'Intel 13th Generation Core i5', 'Intel Iris Xe Graphics', '8 GB', 'SSD', '512 GB', 'Windows 11', 'grey', 2023),
(442, '14 inches', '1920 x 1080 pixels', 'Intel Celeron', 'Intel UHD Graphics 600', '4 GB', 'eMMC', '64 GB', 'Chrome OS', 'black', 2022),
(443, '15.6 inches', '1920 x 1080 pixels', 'AMD Ryzen 5 7000 Series', 'NVIDIA GeForce RTX 4050', '16 GB', 'SSD', '512 GB', 'Windows 11', 'black', 2024),
(444, '15.6 inches', '1920 x 1080 pixels', 'Intel Core i7', 'NVIDIA GeForce RTX 4060', '16 GB', 'SSD', '1 TB', 'Windows 11', 'grey', 2024),
(445, '16 inches', '1920 x 1200 pixels', 'AMD Ryzen 5 7530U', 'AMD Radeon', '16 GB', 'SSD', '512 GB', 'Windows 11', 'blue', 2023),
(446, '14 inches', '1920 x 1200 pixels', 'Intel Core 7 Processor', 'Intel Graphics', '16 GB', 'SSD', '1 TB', 'Windows 11', 'blue', 2024),
(447, '16 inches', '2560 x 1600 pixels', 'Intel Core i9', 'NVIDIA GeForce RTX 4060', '32 GB', 'SSD', '1 TB', 'Windows 11', 'black', 2023),
(448, '14 inches', '1920 x 1200 pixels', '13th Gen Intel Core i5', 'Intel Iris Xe Graphics', '8 GB', 'SSD', '512 GB', 'Windows 11', 'silver', 2023),
(449, '15.6 inches', '1920 x 1080 pixels', 'Intel Core i5', 'Intel UHD Graphics', '8 GB', 'SSD', '512 GB', 'Windows 11', 'black', 2024),
(450, '16 inches', '1920 x 1200 pixels', 'Intel Core Ultra 7', 'Intel Graphics', '16 GB', 'SSD', '1 TB', 'Windows 11', 'grey', 2024),
(451, '15.6 inches', '1920 x 1080 pixels', 'Ryzen 5 7520U', 'AMD Radeon Graphics', '8 GB', 'SSD', '256 GB', 'Windows 11', 'blue', 2023),
(452, '15.6 inches', '1920 x 1080 pixels', 'Ryzen 7 5700U', 'AMD Radeon Graphics', '16 GB', 'SSD', '512 GB', 'Windows 11', 'grey', 2023),
(453, '16 inches', '1920 x 1200 pixels', 'AMD Ryzen 5 7535U', 'AMD Radeon', '8 GB', 'SSD', '512 GB', 'Windows 11', 'grey', 2023),
(454, '14.5 inches', '2880 x 1800 pixels', 'Ryzen 7 7840HS', 'NVIDIA GeForce RTX 4060', '16 GB', 'SSD', '1 TB', 'Windows 11', 'grey', 2023),
(455, '14 inches', '1366 x 768 pixels', 'Intel Celeron', 'Intel UHD Graphics 600', '4 GB', 'eMMC', '64 GB', 'Windows 11', 'white', 2022),
(456, '14 inches', '1366 x 768 pixels', 'Intel Celeron', 'Intel UHD Graphics 600', '4 GB', 'eMMC', '128 GB', 'Windows 11', 'gold', 2022),
(457, '14 inches', '1366 x 768 pixels', 'Intel Celeron', 'Intel UHD Graphics 600', '4 GB', 'eMMC', '64 GB', 'Windows 11', 'blue', 2022),
(458, '15.6 inches', '1920 x 1080 pixels', 'Intel Core i5', 'NVIDIA GeForce RTX 4060', '8 GB', 'SSD', '256 GB', 'Windows 11', 'silver', 2023),
(459, '15.6 inches', '1920 x 1080 pixels', 'Intel Core i5', 'NVIDIA GeForce RTX 4060', '8 GB', 'SSD', '512 GB', 'Windows 11', 'blue', 2023),
(460, '14 inches', '1366 x 768 pixels', 'Intel Celeron', 'Intel UHD Graphics 600', '4 GB', 'eMMC', '64 GB', 'Chrome OS', 'grey', 2022),
(461, '17.3 inches', '1920 x 1080 pixels', 'Intel Core Ultra 7', 'NVIDIA GeForce RTX 4060', '16 GB', 'SSD', '1 TB', 'Windows 11', 'silver', 2024);


INSERT INTO cables (id, type) VALUES
(462, 'charging'),
(463, 'charging'),
(464, 'charging'),
(465, 'charging'),
(466, 'charging'),
(467, 'charging'),
(468, 'charging'),
(469, 'charging'),
(470, 'charging'),
(471, 'charging'),
(472, 'ethernet'),
(473, 'HDMI');


INSERT INTO chargers (id, adapter_type) VALUES
(474, 'wireless chargers'),
(475, 'wireless chargers'),
(476, 'wireless chargers'),
(477, 'wall chargers'),
(478, 'wall chargers'),
(479, 'wall chargers'),
(480, 'wall chargers'),
(481, 'wall chargers'),
(482, 'wall chargers'),
(483, 'wall chargers');


INSERT INTO power_banks (id, battery_capacity, color) VALUES
(484, '20 000 mAh', 'black'),
(485, '5000 mAh', 'blue'),
(486, '10 000 mAh', 'black'),
(487, '20 000 mAh', 'black'),
(488, '24 000 mAh', 'black'),
(489, '24 000 mAh', 'black'),
(490, '30 000 mAh', 'black'),
(491, '30 000 mAh', 'black');


INSERT INTO earbuds (id, connection_type, battery_life, battery_life_with_case, anc, bluetooth_version, fit, color, year_of_release) VALUES
(492, 'wireless', '6 hours', '30 hours', true, '5.3', 'in-ear', 'white', 2022),
(493, 'wireless', '5 hours', '24 hours', false, '5.0', 'in-ear', 'white', 2019),
(494, 'wireless', '6 hours', '30 hours', false, '5.0', 'in-ear', 'white', 2021),
(495, 'wireless', '10 hours', '50 hours', true, '5.2', 'in-ear', 'black', 2022),
(496, 'wireless', '10 hours', '50 hours', true, '5.2', 'in-ear', 'blue', 2022),
(497, 'wireless', '10 hours', '50 hours', true, '5.2', 'in-ear', 'white', 2022),
(498, 'wireless', '10 hours', '50 hours', true, '5.3', 'in-ear', 'black', 2023),
(499, 'wireless', '10 hours', '50 hours', true, '5.3', 'in-ear', 'blue', 2023),
(500, 'wireless', '10 hours', '50 hours', true, '5.3', 'in-ear', 'white', 2023),
(501, 'wireless', '6.5 hours', '26.5 hours', true, '5.2', 'in-ear', 'black', 2023),
(502, 'wireless', '6.5 hours', '26.5 hours', true, '5.2', 'in-ear', 'white', 2023),
(503, 'wireless', '8 hours', '30 hours', true, '5.3', 'in-ear', 'purple', 2022),
(504, 'wireless', '8 hours', '30 hours', true, '5.3', 'in-ear', 'graphite', 2022),
(505, 'wireless', '8 hours', '30 hours', true, '5.3', 'in-ear', 'white', 2022),
(506, 'wireless', '5 hours', '36 hours', true, '5.3', 'in-ear', 'transparent', 2023),
(507, 'wireless', '10 hours', '42.5 hours', true, '5.3', 'in-ear', 'transparent', 2024),
(508, 'wireless', '6 hours', '18 hours', true, '5.3', 'in-ear', 'black', 2022),
(509, 'wireless', '6 hours', '18 hours', true, '5.3', 'in-ear', 'white', 2022),
(510, 'wireless', '6 hours', '18 hours', true, '5.3', 'in-ear', 'black', 2023),
(511, 'wireless', '6 hours', '18 hours', true, '5.3', 'in-ear', 'white', 2023),
(512, 'wireless', '6 hours', '18 hours', true, '5.3', 'in-ear', 'blue', 2023),
(513, 'wireless', '7.5 hours', '19.5 hours', true, '5.3', 'open-ear', 'white', 2024),
(514, 'wireless', '7.5 hours', '19.5 hours', true, '5.3', 'open-ear', 'black', 2024),
(515, 'wireless', '10 hours', '40 hours', true, '5.2', 'in-ear, clip on', 'black', 2022),
(516, 'wireless', '10 hours', '40 hours', true, '5.2', 'in-ear, clip on', 'white', 2022),
(517, 'wireless', '8 hours', '24 hours', true, '5.2', 'in-ear', 'black', 2022),
(518, 'wireless', '8 hours', '24 hours', true, '5.2', 'in-ear', 'white', 2022),
(519, 'wireless', '8 hours', '24 hours', true, '5.2', 'in-ear', 'blue', 2022),
(520, 'wireless', '8 hours', '32 hours', true, '5.2', 'in-ear', 'black', 2023),
(521, 'wireless', '8 hours', '32 hours', true, '5.2', 'in-ear', 'white', 2023);
