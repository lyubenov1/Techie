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
('Huawei - Nova 12 SE - 256GB 8GB RAM - Green', 429.00, 2, 4, 50, 'The Huawei Nova 12 SE is a stylish and feature-packed smartphone designed to elevate your mobile experience. With its sleek design, powerful performance, and advanced camera capabilities, the Nova 12 SE offers everything you need to stay connected, entertained, and productive on the go.

At the heart of the Nova 12 SE is a powerful processor coupled with ample RAM, ensuring smooth and responsive performance for all your daily tasks. Whether you''re browsing the web, streaming videos, or playing games, the Nova 12 SE delivers a seamless user experience that keeps up with your fast-paced lifestyle.

The Nova 12 SE also features a stunning display that immerses you in your favorite content with vibrant colors and crisp details. With its high resolution and expansive screen real estate, the Nova 12 SE is perfect for watching movies, browsing photos, and playing games, providing an immersive viewing experience that brings your content to life.

Photography enthusiasts will appreciate the Nova 12 SE''s advanced camera system, which allows you to capture stunning photos and videos with ease. Equipped with multiple lenses, including wide-angle, ultra-wide-angle, and telephoto options, as well as advanced AI-powered features, the Nova 12 SE empowers you to unleash your creativity and capture every moment with professional-quality results.

In addition to its powerful performance and imaging capabilities, the Nova 12 SE offers a range of intelligent features and functionalities designed to enhance your everyday life. From advanced security and privacy features to seamless connectivity and productivity tools, the Nova 12 SE puts the power of innovation at your fingertips, helping you stay organized, connected, and productive wherever you go.

With its sleek design, powerful performance, and advanced camera capabilities, the Huawei Nova 12 SE is the perfect companion for your mobile lifestyle. Whether you''re a tech enthusiast, a photography buff, or a busy professional, the Nova 12 SE offers everything you need to stay connected, entertained, and productive on the go.'),
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
('Huawei - MatePad T 10 (2021) - 64GB 2GB RAM - Deepsea Blue', 199.00, 3, 4, 50, 'The Huawei MatePad T 10 is a compact and affordable tablet designed for everyday use. With its 10-inch display, it offers a comfortable viewing experience for browsing the web, watching videos, and reading e-books. Powered by Huawei''s efficient hardware and software, it delivers smooth performance for basic tasks like email, social media, and light gaming. Its sleek and lightweight design makes it easy to carry around, while its long battery life ensures you can stay connected throughout the day without needing to recharge frequently. Overall, the MatePad T 10 is a reliable and budget-friendly option for users seeking a simple and functional tablet experience.'),
('Huawei - MatePad T 10 (2021) - 64GB 4GB RAM - Deepsea Blue', 229.00, 3, 4, 50, 'The Huawei MatePad T 10 is a compact and affordable tablet designed for everyday use. With its 10-inch display, it offers a comfortable viewing experience for browsing the web, watching videos, and reading e-books. Powered by Huawei''s efficient hardware and software, it delivers smooth performance for basic tasks like email, social media, and light gaming. Its sleek and lightweight design makes it easy to carry around, while its long battery life ensures you can stay connected throughout the day without needing to recharge frequently. Overall, the MatePad T 10 is a reliable and budget-friendly option for users seeking a simple and functional tablet experience.'),
('Lenovo - Tab M10 Plus Gen 3 - 32GB 3GB RAM - Storm Grey', 259.00, 3, 8, 50, 'dummy description'),
('Lenovo - Tab M10 Plus Gen 3 - 64GB 4GB RAM - Storm Grey', 279.00, 3, 8, 50, 'dummy description'),
('Lenovo - Tab M10 Plus Gen 3 - 128GB 4GB RAM - Storm Grey', 289.00, 3, 8, 50, 'dummy description'),
('Lenovo - Tab M10 Plus Gen 3 - 128GB 6GB RAM - Storm Grey', 319.00, 3, 8, 50, 'dummy description'),
('Lenovo - Tab M11 - 64GB 4GB RAM - Arctic Grey', 179.00, 3, 8, 50, 'The Lenovo Tab M11 is a sleek and versatile tablet designed to meet your everyday needs with ease. Featuring a vibrant 11-inch display, this tablet offers crisp visuals and immersive viewing experiences for movies, games, and more. With its powerful processor and responsive performance, the Tab M11 ensures smooth multitasking and efficient productivity on the go. Its lightweight and portable design make it perfect for use at home, in the office, or on the move. Equipped with dual speakers, the Tab M11 delivers immersive audio experiences for music, movies, and video calls. With Wi-Fi connectivity and a range of ports, including USB-C, this tablet keeps you connected and productive wherever you are.'),
('Lenovo - Tab M11 - 128GB 4GB RAM - Arctic Grey', 199.00, 3, 8, 50, 'The Lenovo Tab M11 is a sleek and versatile tablet designed to meet your everyday needs with ease. Featuring a vibrant 11-inch display, this tablet offers crisp visuals and immersive viewing experiences for movies, games, and more. With its powerful processor and responsive performance, the Tab M11 ensures smooth multitasking and efficient productivity on the go. Its lightweight and portable design make it perfect for use at home, in the office, or on the move. Equipped with dual speakers, the Tab M11 delivers immersive audio experiences for music, movies, and video calls. With Wi-Fi connectivity and a range of ports, including USB-C, this tablet keeps you connected and productive wherever you are.'),
('Lenovo - Tab M11 - 128GB 8GB RAM - Arctic Grey', 229.00, 3, 8, 50, 'The Lenovo Tab M11 is a sleek and versatile tablet designed to meet your everyday needs with ease. Featuring a vibrant 11-inch display, this tablet offers crisp visuals and immersive viewing experiences for movies, games, and more. With its powerful processor and responsive performance, the Tab M11 ensures smooth multitasking and efficient productivity on the go. Its lightweight and portable design make it perfect for use at home, in the office, or on the move. Equipped with dual speakers, the Tab M11 delivers immersive audio experiences for music, movies, and video calls. With Wi-Fi connectivity and a range of ports, including USB-C, this tablet keeps you connected and productive wherever you are.'),
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


('Apple - Macbook Air 13" (M3 chip) - 512GB SSD 8GB RAM - Midnight', 1299.00, 1, 1, 50, 'The Apple MacBook Air 13" with the M3 chip is a lightweight and portable laptop designed for everyday computing tasks. Here''s an overview of its key features:

M3 Chip: The MacBook Air is powered by Apple''s M3 chip, which delivers impressive performance and energy efficiency. The M3 chip is designed to handle everyday tasks with ease, including web browsing, email, document editing, and multimedia consumption.

Retina Display: The MacBook Air features a stunning 13.3-inch Retina display with True Tone technology, providing vibrant colors, sharp text, and lifelike images. The high-resolution screen offers an immersive viewing experience for browsing the web, watching movies, and editing photos.

Thin and Lightweight Design: Weighing just around 2.8 pounds and measuring 0.63 inches thin, the MacBook Air is incredibly portable, making it ideal for users who are always on the go. Its sleek and minimalist design is crafted from 100% recycled aluminum, making it both stylish and eco-friendly.

Magic Keyboard: The MacBook Air is equipped with Apple''s Magic Keyboard, featuring a comfortable typing experience with a scissor mechanism and 1mm of key travel. The keyboard also includes a Touch ID sensor for secure authentication and Apple Pay.

All-Day Battery Life: With up to 15 hours of battery life, the MacBook Air provides all-day power for work, school, and entertainment. Whether you''re working from a coffee shop or watching movies on a long flight, you can rely on the MacBook Air to keep up with your busy lifestyle.

macOS: The MacBook Air comes pre-installed with macOS, Apple''s intuitive and user-friendly operating system. macOS offers a seamless and integrated experience across all Apple devices, with features like iCloud, Siri, and Continuity for effortless multitasking and productivity.

Thunderbolt 3 Ports: The MacBook Air is equipped with two Thunderbolt 3 (USB-C) ports, providing fast data transfer speeds and versatile connectivity options. You can connect external displays, storage devices, and other accessories with ease.

Audio and Camera: The MacBook Air features stereo speakers with wide stereo sound for immersive audio experiences. It also includes a 720p FaceTime HD camera, perfect for video calls and conferences.

Environmentally Friendly: Apple is committed to reducing its environmental impact, and the MacBook Air reflects this commitment with its energy-efficient design, use of recycled materials, and eco-friendly manufacturing processes.'),
('Apple - Macbook Air 13" (M3 chip) - 512GB SSD 16GB RAM - Midnight', 1499.00, 1, 1, 50, 'The Apple MacBook Air 13" with the M3 chip is a lightweight and portable laptop designed for everyday computing tasks. Here''s an overview of its key features:

M3 Chip: The MacBook Air is powered by Apple''s M3 chip, which delivers impressive performance and energy efficiency. The M3 chip is designed to handle everyday tasks with ease, including web browsing, email, document editing, and multimedia consumption.

Retina Display: The MacBook Air features a stunning 13.3-inch Retina display with True Tone technology, providing vibrant colors, sharp text, and lifelike images. The high-resolution screen offers an immersive viewing experience for browsing the web, watching movies, and editing photos.

Thin and Lightweight Design: Weighing just around 2.8 pounds and measuring 0.63 inches thin, the MacBook Air is incredibly portable, making it ideal for users who are always on the go. Its sleek and minimalist design is crafted from 100% recycled aluminum, making it both stylish and eco-friendly.

Magic Keyboard: The MacBook Air is equipped with Apple''s Magic Keyboard, featuring a comfortable typing experience with a scissor mechanism and 1mm of key travel. The keyboard also includes a Touch ID sensor for secure authentication and Apple Pay.

All-Day Battery Life: With up to 15 hours of battery life, the MacBook Air provides all-day power for work, school, and entertainment. Whether you''re working from a coffee shop or watching movies on a long flight, you can rely on the MacBook Air to keep up with your busy lifestyle.

macOS: The MacBook Air comes pre-installed with macOS, Apple''s intuitive and user-friendly operating system. macOS offers a seamless and integrated experience across all Apple devices, with features like iCloud, Siri, and Continuity for effortless multitasking and productivity.

Thunderbolt 3 Ports: The MacBook Air is equipped with two Thunderbolt 3 (USB-C) ports, providing fast data transfer speeds and versatile connectivity options. You can connect external displays, storage devices, and other accessories with ease.

Audio and Camera: The MacBook Air features stereo speakers with wide stereo sound for immersive audio experiences. It also includes a 720p FaceTime HD camera, perfect for video calls and conferences.

Environmentally Friendly: Apple is committed to reducing its environmental impact, and the MacBook Air reflects this commitment with its energy-efficient design, use of recycled materials, and eco-friendly manufacturing processes.'),
('Apple - Macbook Air 13" (M3 chip) - 512GB SSD 8GB RAM - Starlight', 1299.00, 1, 1, 50, 'The Apple MacBook Air 13" with the M3 chip is a lightweight and portable laptop designed for everyday computing tasks. Here''s an overview of its key features:

M3 Chip: The MacBook Air is powered by Apple''s M3 chip, which delivers impressive performance and energy efficiency. The M3 chip is designed to handle everyday tasks with ease, including web browsing, email, document editing, and multimedia consumption.

Retina Display: The MacBook Air features a stunning 13.3-inch Retina display with True Tone technology, providing vibrant colors, sharp text, and lifelike images. The high-resolution screen offers an immersive viewing experience for browsing the web, watching movies, and editing photos.

Thin and Lightweight Design: Weighing just around 2.8 pounds and measuring 0.63 inches thin, the MacBook Air is incredibly portable, making it ideal for users who are always on the go. Its sleek and minimalist design is crafted from 100% recycled aluminum, making it both stylish and eco-friendly.

Magic Keyboard: The MacBook Air is equipped with Apple''s Magic Keyboard, featuring a comfortable typing experience with a scissor mechanism and 1mm of key travel. The keyboard also includes a Touch ID sensor for secure authentication and Apple Pay.

All-Day Battery Life: With up to 15 hours of battery life, the MacBook Air provides all-day power for work, school, and entertainment. Whether you''re working from a coffee shop or watching movies on a long flight, you can rely on the MacBook Air to keep up with your busy lifestyle.

macOS: The MacBook Air comes pre-installed with macOS, Apple''s intuitive and user-friendly operating system. macOS offers a seamless and integrated experience across all Apple devices, with features like iCloud, Siri, and Continuity for effortless multitasking and productivity.

Thunderbolt 3 Ports: The MacBook Air is equipped with two Thunderbolt 3 (USB-C) ports, providing fast data transfer speeds and versatile connectivity options. You can connect external displays, storage devices, and other accessories with ease.

Audio and Camera: The MacBook Air features stereo speakers with wide stereo sound for immersive audio experiences. It also includes a 720p FaceTime HD camera, perfect for video calls and conferences.

Environmentally Friendly: Apple is committed to reducing its environmental impact, and the MacBook Air reflects this commitment with its energy-efficient design, use of recycled materials, and eco-friendly manufacturing processes.'),
('Apple - Macbook Air 13" (M3 chip) - 512GB SSD 16GB RAM - Starlight', 1499.00, 1, 1, 50, 'The Apple MacBook Air 13" with the M3 chip is a lightweight and portable laptop designed for everyday computing tasks. Here''s an overview of its key features:

M3 Chip: The MacBook Air is powered by Apple''s M3 chip, which delivers impressive performance and energy efficiency. The M3 chip is designed to handle everyday tasks with ease, including web browsing, email, document editing, and multimedia consumption.

Retina Display: The MacBook Air features a stunning 13.3-inch Retina display with True Tone technology, providing vibrant colors, sharp text, and lifelike images. The high-resolution screen offers an immersive viewing experience for browsing the web, watching movies, and editing photos.

Thin and Lightweight Design: Weighing just around 2.8 pounds and measuring 0.63 inches thin, the MacBook Air is incredibly portable, making it ideal for users who are always on the go. Its sleek and minimalist design is crafted from 100% recycled aluminum, making it both stylish and eco-friendly.

Magic Keyboard: The MacBook Air is equipped with Apple''s Magic Keyboard, featuring a comfortable typing experience with a scissor mechanism and 1mm of key travel. The keyboard also includes a Touch ID sensor for secure authentication and Apple Pay.

All-Day Battery Life: With up to 15 hours of battery life, the MacBook Air provides all-day power for work, school, and entertainment. Whether you''re working from a coffee shop or watching movies on a long flight, you can rely on the MacBook Air to keep up with your busy lifestyle.

macOS: The MacBook Air comes pre-installed with macOS, Apple''s intuitive and user-friendly operating system. macOS offers a seamless and integrated experience across all Apple devices, with features like iCloud, Siri, and Continuity for effortless multitasking and productivity.

Thunderbolt 3 Ports: The MacBook Air is equipped with two Thunderbolt 3 (USB-C) ports, providing fast data transfer speeds and versatile connectivity options. You can connect external displays, storage devices, and other accessories with ease.

Audio and Camera: The MacBook Air features stereo speakers with wide stereo sound for immersive audio experiences. It also includes a 720p FaceTime HD camera, perfect for video calls and conferences.

Environmentally Friendly: Apple is committed to reducing its environmental impact, and the MacBook Air reflects this commitment with its energy-efficient design, use of recycled materials, and eco-friendly manufacturing processes.'),
('Apple - Macbook Air 13" (M3 chip) - 512GB SSD 8GB RAM - Space Gray', 1299.00, 1, 1, 50, 'The Apple MacBook Air 13" with the M3 chip is a lightweight and portable laptop designed for everyday computing tasks. Here''s an overview of its key features:

M3 Chip: The MacBook Air is powered by Apple''s M3 chip, which delivers impressive performance and energy efficiency. The M3 chip is designed to handle everyday tasks with ease, including web browsing, email, document editing, and multimedia consumption.

Retina Display: The MacBook Air features a stunning 13.3-inch Retina display with True Tone technology, providing vibrant colors, sharp text, and lifelike images. The high-resolution screen offers an immersive viewing experience for browsing the web, watching movies, and editing photos.

Thin and Lightweight Design: Weighing just around 2.8 pounds and measuring 0.63 inches thin, the MacBook Air is incredibly portable, making it ideal for users who are always on the go. Its sleek and minimalist design is crafted from 100% recycled aluminum, making it both stylish and eco-friendly.

Magic Keyboard: The MacBook Air is equipped with Apple''s Magic Keyboard, featuring a comfortable typing experience with a scissor mechanism and 1mm of key travel. The keyboard also includes a Touch ID sensor for secure authentication and Apple Pay.

All-Day Battery Life: With up to 15 hours of battery life, the MacBook Air provides all-day power for work, school, and entertainment. Whether you''re working from a coffee shop or watching movies on a long flight, you can rely on the MacBook Air to keep up with your busy lifestyle.

macOS: The MacBook Air comes pre-installed with macOS, Apple''s intuitive and user-friendly operating system. macOS offers a seamless and integrated experience across all Apple devices, with features like iCloud, Siri, and Continuity for effortless multitasking and productivity.

Thunderbolt 3 Ports: The MacBook Air is equipped with two Thunderbolt 3 (USB-C) ports, providing fast data transfer speeds and versatile connectivity options. You can connect external displays, storage devices, and other accessories with ease.

Audio and Camera: The MacBook Air features stereo speakers with wide stereo sound for immersive audio experiences. It also includes a 720p FaceTime HD camera, perfect for video calls and conferences.

Environmentally Friendly: Apple is committed to reducing its environmental impact, and the MacBook Air reflects this commitment with its energy-efficient design, use of recycled materials, and eco-friendly manufacturing processes.'),
('Apple - Macbook Air 13" (M3 chip) - 512GB SSD 16GB RAM - Space Gray', 1499.00, 1, 1, 50, 'The Apple MacBook Air 13" with the M3 chip is a lightweight and portable laptop designed for everyday computing tasks. Here''s an overview of its key features:

M3 Chip: The MacBook Air is powered by Apple''s M3 chip, which delivers impressive performance and energy efficiency. The M3 chip is designed to handle everyday tasks with ease, including web browsing, email, document editing, and multimedia consumption.

Retina Display: The MacBook Air features a stunning 13.3-inch Retina display with True Tone technology, providing vibrant colors, sharp text, and lifelike images. The high-resolution screen offers an immersive viewing experience for browsing the web, watching movies, and editing photos.

Thin and Lightweight Design: Weighing just around 2.8 pounds and measuring 0.63 inches thin, the MacBook Air is incredibly portable, making it ideal for users who are always on the go. Its sleek and minimalist design is crafted from 100% recycled aluminum, making it both stylish and eco-friendly.

Magic Keyboard: The MacBook Air is equipped with Apple''s Magic Keyboard, featuring a comfortable typing experience with a scissor mechanism and 1mm of key travel. The keyboard also includes a Touch ID sensor for secure authentication and Apple Pay.

All-Day Battery Life: With up to 15 hours of battery life, the MacBook Air provides all-day power for work, school, and entertainment. Whether you''re working from a coffee shop or watching movies on a long flight, you can rely on the MacBook Air to keep up with your busy lifestyle.

macOS: The MacBook Air comes pre-installed with macOS, Apple''s intuitive and user-friendly operating system. macOS offers a seamless and integrated experience across all Apple devices, with features like iCloud, Siri, and Continuity for effortless multitasking and productivity.

Thunderbolt 3 Ports: The MacBook Air is equipped with two Thunderbolt 3 (USB-C) ports, providing fast data transfer speeds and versatile connectivity options. You can connect external displays, storage devices, and other accessories with ease.

Audio and Camera: The MacBook Air features stereo speakers with wide stereo sound for immersive audio experiences. It also includes a 720p FaceTime HD camera, perfect for video calls and conferences.

Environmentally Friendly: Apple is committed to reducing its environmental impact, and the MacBook Air reflects this commitment with its energy-efficient design, use of recycled materials, and eco-friendly manufacturing processes.'),
('Apple - Macbook Air 15" (M3 chip) - 512GB SSD 8GB RAM - Midnight', 1499.00, 1, 1, 50, 'Introducing the cutting-edge 15-inch M3 MacBook Air, a powerhouse of performance crafted by Apple''s pioneering silicon technology. Tailored for the modern digital nomad, this fanless marvel delivers unparalleled efficiency and power.

Harnessing the might of the M3 chip, this laptop elevates your productivity, effortlessly handling tasks like 4K video editing in Final Cut Pro, precise photo retouching, and seamless content management system navigation.

Experience unmatched comfort and functionality with its spacious full-sized keyboard, expansive trackpad, and immersive audio, courtesy of six speakers with integrated subwoofers—all encased in a sleek, premium design.

While its 15-inch LED screen may not boast the highest resolution or the latest panel tech, it remains a steadfast companion for your productivity pursuits.

With remarkable battery endurance, the MacBook Air offers nearly two full workdays of power for standard office tasks and maintains 4-5 hours of runtime during demanding video editing sessions.

Connect with ease using two USB-C ports and a MagSafe port for swift charging, now complemented by the ability to link to dual external monitors—a feature previously unseen in M-powered MacBook Air models.'),
('Apple - Macbook Air 15" (M3 chip) - 512GB SSD 16GB RAM - Midnight', 1699.00, 1, 1, 50, 'Introducing the cutting-edge 15-inch M3 MacBook Air, a powerhouse of performance crafted by Apple''s pioneering silicon technology. Tailored for the modern digital nomad, this fanless marvel delivers unparalleled efficiency and power.

Harnessing the might of the M3 chip, this laptop elevates your productivity, effortlessly handling tasks like 4K video editing in Final Cut Pro, precise photo retouching, and seamless content management system navigation.

Experience unmatched comfort and functionality with its spacious full-sized keyboard, expansive trackpad, and immersive audio, courtesy of six speakers with integrated subwoofers—all encased in a sleek, premium design.

While its 15-inch LED screen may not boast the highest resolution or the latest panel tech, it remains a steadfast companion for your productivity pursuits.

With remarkable battery endurance, the MacBook Air offers nearly two full workdays of power for standard office tasks and maintains 4-5 hours of runtime during demanding video editing sessions.

Connect with ease using two USB-C ports and a MagSafe port for swift charging, now complemented by the ability to link to dual external monitors—a feature previously unseen in M-powered MacBook Air models.'),
('Apple - Macbook Air 15" (M3 chip) - 512GB SSD 8GB RAM - Starlight', 1499.00, 1, 1, 50, 'Introducing the cutting-edge 15-inch M3 MacBook Air, a powerhouse of performance crafted by Apple''s pioneering silicon technology. Tailored for the modern digital nomad, this fanless marvel delivers unparalleled efficiency and power.

Harnessing the might of the M3 chip, this laptop elevates your productivity, effortlessly handling tasks like 4K video editing in Final Cut Pro, precise photo retouching, and seamless content management system navigation.

Experience unmatched comfort and functionality with its spacious full-sized keyboard, expansive trackpad, and immersive audio, courtesy of six speakers with integrated subwoofers—all encased in a sleek, premium design.

While its 15-inch LED screen may not boast the highest resolution or the latest panel tech, it remains a steadfast companion for your productivity pursuits.

With remarkable battery endurance, the MacBook Air offers nearly two full workdays of power for standard office tasks and maintains 4-5 hours of runtime during demanding video editing sessions.

Connect with ease using two USB-C ports and a MagSafe port for swift charging, now complemented by the ability to link to dual external monitors—a feature previously unseen in M-powered MacBook Air models.'),
('Apple - Macbook Air 15" (M3 chip) - 512GB SSD 16GB RAM - Starlight', 1699.00, 1, 1, 50, 'Introducing the cutting-edge 15-inch M3 MacBook Air, a powerhouse of performance crafted by Apple''s pioneering silicon technology. Tailored for the modern digital nomad, this fanless marvel delivers unparalleled efficiency and power.

Harnessing the might of the M3 chip, this laptop elevates your productivity, effortlessly handling tasks like 4K video editing in Final Cut Pro, precise photo retouching, and seamless content management system navigation.

Experience unmatched comfort and functionality with its spacious full-sized keyboard, expansive trackpad, and immersive audio, courtesy of six speakers with integrated subwoofers—all encased in a sleek, premium design.

While its 15-inch LED screen may not boast the highest resolution or the latest panel tech, it remains a steadfast companion for your productivity pursuits.

With remarkable battery endurance, the MacBook Air offers nearly two full workdays of power for standard office tasks and maintains 4-5 hours of runtime during demanding video editing sessions.

Connect with ease using two USB-C ports and a MagSafe port for swift charging, now complemented by the ability to link to dual external monitors—a feature previously unseen in M-powered MacBook Air models.'),
('Apple - Macbook Air 15" (M3 chip) - 512GB SSD 8GB RAM - Space Gray', 1499.00, 1, 1, 50, 'Introducing the cutting-edge 15-inch M3 MacBook Air, a powerhouse of performance crafted by Apple''s pioneering silicon technology. Tailored for the modern digital nomad, this fanless marvel delivers unparalleled efficiency and power.

Harnessing the might of the M3 chip, this laptop elevates your productivity, effortlessly handling tasks like 4K video editing in Final Cut Pro, precise photo retouching, and seamless content management system navigation.

Experience unmatched comfort and functionality with its spacious full-sized keyboard, expansive trackpad, and immersive audio, courtesy of six speakers with integrated subwoofers—all encased in a sleek, premium design.

While its 15-inch LED screen may not boast the highest resolution or the latest panel tech, it remains a steadfast companion for your productivity pursuits.

With remarkable battery endurance, the MacBook Air offers nearly two full workdays of power for standard office tasks and maintains 4-5 hours of runtime during demanding video editing sessions.

Connect with ease using two USB-C ports and a MagSafe port for swift charging, now complemented by the ability to link to dual external monitors—a feature previously unseen in M-powered MacBook Air models.'),
('Apple - Macbook Air 15" (M3 chip) - 512GB SSD 16GB RAM - Space Gray', 1699.00, 1, 1, 50, 'Introducing the cutting-edge 15-inch M3 MacBook Air, a powerhouse of performance crafted by Apple''s pioneering silicon technology. Tailored for the modern digital nomad, this fanless marvel delivers unparalleled efficiency and power.

Harnessing the might of the M3 chip, this laptop elevates your productivity, effortlessly handling tasks like 4K video editing in Final Cut Pro, precise photo retouching, and seamless content management system navigation.

Experience unmatched comfort and functionality with its spacious full-sized keyboard, expansive trackpad, and immersive audio, courtesy of six speakers with integrated subwoofers—all encased in a sleek, premium design.

While its 15-inch LED screen may not boast the highest resolution or the latest panel tech, it remains a steadfast companion for your productivity pursuits.

With remarkable battery endurance, the MacBook Air offers nearly two full workdays of power for standard office tasks and maintains 4-5 hours of runtime during demanding video editing sessions.

Connect with ease using two USB-C ports and a MagSafe port for swift charging, now complemented by the ability to link to dual external monitors—a feature previously unseen in M-powered MacBook Air models.'),
('Apple - Macbook Pro 14" (M3 chip) - 1 TB SSD 8GB RAM - Silver', 1799.00, 1, 1, 50, 'Introducing the revolutionary Apple MacBook Pro 14" equipped with the cutting-edge M3 chip, marking a new era in laptop performance and efficiency. Designed to meet the demands of professionals and creatives alike, this powerhouse delivers unmatched speed and versatility.

Powered by Apple''s groundbreaking M3 chip, this MacBook Pro 14" redefines what''s possible, offering blazing-fast performance for intensive tasks such as video editing, graphic design, and software development.

Experience unparalleled precision and responsiveness with the MacBook Pro''s vibrant 14-inch Retina display, boasting stunning visuals and true-to-life colors that bring your content to life.

Designed with productivity in mind, the MacBook Pro features a sleek and compact design, making it perfect for on-the-go professionals. Its innovative MagSafe charging port ensures effortless charging, while the array of Thunderbolt 4 ports provides lightning-fast data transfer and connectivity to peripherals.

With its advanced thermal architecture, the MacBook Pro 14" stays cool and quiet even under heavy workloads, ensuring optimal performance at all times.

Whether you''re editing videos, crunching numbers, or designing masterpieces, the Apple MacBook Pro 14" with M3 chip empowers you to unleash your creativity and accomplish more than ever before.'),
('Apple - Macbook Pro 14" (M3 chip) - 1 TB SSD 8GB RAM - Space Black', 1799.00, 1, 1, 50, 'Introducing the revolutionary Apple MacBook Pro 14" equipped with the cutting-edge M3 chip, marking a new era in laptop performance and efficiency. Designed to meet the demands of professionals and creatives alike, this powerhouse delivers unmatched speed and versatility.

Powered by Apple''s groundbreaking M3 chip, this MacBook Pro 14" redefines what''s possible, offering blazing-fast performance for intensive tasks such as video editing, graphic design, and software development.

Experience unparalleled precision and responsiveness with the MacBook Pro''s vibrant 14-inch Retina display, boasting stunning visuals and true-to-life colors that bring your content to life.

Designed with productivity in mind, the MacBook Pro features a sleek and compact design, making it perfect for on-the-go professionals. Its innovative MagSafe charging port ensures effortless charging, while the array of Thunderbolt 4 ports provides lightning-fast data transfer and connectivity to peripherals.

With its advanced thermal architecture, the MacBook Pro 14" stays cool and quiet even under heavy workloads, ensuring optimal performance at all times.

Whether you''re editing videos, crunching numbers, or designing masterpieces, the Apple MacBook Pro 14" with M3 chip empowers you to unleash your creativity and accomplish more than ever before.'),
('Apple - Macbook Pro 14" (M3 chip) - 1 TB SSD 16GB RAM - Silver', 1999.00, 1, 1, 50, 'Introducing the revolutionary Apple MacBook Pro 14" equipped with the cutting-edge M3 chip, marking a new era in laptop performance and efficiency. Designed to meet the demands of professionals and creatives alike, this powerhouse delivers unmatched speed and versatility.

Powered by Apple''s groundbreaking M3 chip, this MacBook Pro 14" redefines what''s possible, offering blazing-fast performance for intensive tasks such as video editing, graphic design, and software development.

Experience unparalleled precision and responsiveness with the MacBook Pro''s vibrant 14-inch Retina display, boasting stunning visuals and true-to-life colors that bring your content to life.

Designed with productivity in mind, the MacBook Pro features a sleek and compact design, making it perfect for on-the-go professionals. Its innovative MagSafe charging port ensures effortless charging, while the array of Thunderbolt 4 ports provides lightning-fast data transfer and connectivity to peripherals.

With its advanced thermal architecture, the MacBook Pro 14" stays cool and quiet even under heavy workloads, ensuring optimal performance at all times.

Whether you''re editing videos, crunching numbers, or designing masterpieces, the Apple MacBook Pro 14" with M3 chip empowers you to unleash your creativity and accomplish more than ever before.'),
('Apple - Macbook Pro 14" (M3 chip) - 1 TB SSD 16GB RAM - Space Black', 1999.00, 1, 1, 50, 'Introducing the revolutionary Apple MacBook Pro 14" equipped with the cutting-edge M3 chip, marking a new era in laptop performance and efficiency. Designed to meet the demands of professionals and creatives alike, this powerhouse delivers unmatched speed and versatility.

Powered by Apple''s groundbreaking M3 chip, this MacBook Pro 14" redefines what''s possible, offering blazing-fast performance for intensive tasks such as video editing, graphic design, and software development.

Experience unparalleled precision and responsiveness with the MacBook Pro''s vibrant 14-inch Retina display, boasting stunning visuals and true-to-life colors that bring your content to life.

Designed with productivity in mind, the MacBook Pro features a sleek and compact design, making it perfect for on-the-go professionals. Its innovative MagSafe charging port ensures effortless charging, while the array of Thunderbolt 4 ports provides lightning-fast data transfer and connectivity to peripherals.

With its advanced thermal architecture, the MacBook Pro 14" stays cool and quiet even under heavy workloads, ensuring optimal performance at all times.

Whether you''re editing videos, crunching numbers, or designing masterpieces, the Apple MacBook Pro 14" with M3 chip empowers you to unleash your creativity and accomplish more than ever before.'),
('Acer - Chromebook Plus 515 – 15.6" - Steel Gray', 399.00, 1, 5, 50, 'The Acer Chromebook Plus 515 in Steel Gray is a versatile and sleek laptop designed to offer seamless productivity and entertainment experiences. Here''s an overview of its key features:

Chrome OS: The Chromebook Plus 515 runs on Chrome OS, providing a fast, simple, and secure computing experience. With access to the Google Play Store, you can download and use a wide range of apps, including productivity tools, games, and entertainment apps.

Large Display: Featuring a 15.6-inch Full HD display, the Chromebook Plus 515 offers immersive visuals for work, streaming, and browsing. The spacious screen provides ample space for multitasking, allowing you to view multiple windows and tabs simultaneously.

Convertible Design: The Chromebook Plus 515 features a versatile 2-in-1 design with a 360-degree hinge, allowing you to switch between laptop, tent, stand, and tablet modes with ease. This flexibility enables you to use the device in various configurations to suit your needs.

Stylish and Durable: With its sleek Steel Gray finish, the Chromebook Plus 515 exudes style and sophistication. The durable construction ensures long-lasting performance, making it suitable for use in various environments, including classrooms, offices, and homes.

Performance: Powered by an Intel processor and equipped with ample RAM, the Chromebook Plus 515 delivers smooth and responsive performance for everyday tasks. Whether you''re browsing the web, editing documents, or streaming videos, the laptop handles tasks efficiently.

Long Battery Life: The Chromebook Plus 515 is designed to keep up with your busy day thanks to its long-lasting battery life. With a single charge, you can enjoy hours of productivity, entertainment, and browsing without needing to recharge frequently.

Connectivity: The Chromebook Plus 515 offers a variety of connectivity options, including USB ports, HDMI, and a microSD card slot, allowing you to connect to external devices and expand storage as needed. It also features built-in Wi-Fi and Bluetooth for wireless connectivity.

Built-in Security: Chrome OS comes with built-in security features, including automatic updates and built-in virus protection, to keep your device safe and secure. Your data is encrypted and stored securely in the cloud, ensuring peace of mind wherever you go.'),
('Acer - Aspire 3 Thin & Light Laptop - 15.6" - Steam Blue', 599.00, 1, 5, 50, 'The Acer Aspire 3 Thin & Light Laptop in Steam Blue is a versatile and portable computing device designed for everyday use. Here''s an overview of its key features:

Design and Portability: The Aspire 3 boasts a thin and light design, making it easy to carry around for work or study. The steam blue color adds a stylish touch, distinguishing it from traditional laptops. Its sleek profile and lightweight construction ensure portability without compromising on performance.

Display: With a 15.6-inch display, the Aspire 3 offers ample screen real estate for productivity tasks, multimedia consumption, and more. The HD resolution delivers crisp visuals, making it suitable for web browsing, document editing, and streaming content.

Performance: Equipped with an Intel Core processor and integrated graphics, the Aspire 3 delivers reliable performance for everyday computing tasks. Whether you''re browsing the web, checking emails, or running productivity applications, the laptop ensures smooth and responsive performance.

Storage: The laptop features ample storage space to store your files, documents, and multimedia content. With a spacious hard drive or solid-state drive (SSD), you can store large files, install applications, and enjoy fast boot times and data access speeds.

Connectivity: The Aspire 3 comes with a variety of connectivity options, including USB ports, HDMI, and more, allowing you to connect to external devices such as monitors, printers, and storage drives. It also features built-in Wi-Fi and Bluetooth connectivity for wireless communication and networking.

Battery Life: Thanks to its efficient design and power-saving features, the Aspire 3 offers long battery life, allowing you to work or study for extended periods without needing to recharge frequently. Whether you''re on the go or working from home, you can rely on the laptop to keep up with your busy lifestyle.

Operating System: The Aspire 3 comes pre-installed with Windows operating system, providing a familiar and user-friendly interface for seamless productivity and entertainment. You can access a wide range of applications, software, and online services to meet your computing needs.'),
('Acer - Nitro V ANV15-51-789J 15.6" - Obsidian Black', 1099.00, 1, 5, 50, 'The Acer Nitro V ANV15-51-789J is a high-performance gaming laptop designed to deliver an immersive gaming experience with its powerful hardware and sleek design. Here''s an overview of its key features:

Performance: The Nitro V is equipped with powerful hardware, including the latest Intel Core i7 processor and NVIDIA GeForce GTX graphics. This combination provides smooth gameplay and fast rendering speeds, allowing you to enjoy the latest AAA titles at high settings without lag or stuttering.

Display: The laptop features a 15.6-inch Full HD display with a high refresh rate, delivering crisp visuals and smooth motion during gameplay. Whether you''re exploring detailed environments or engaging in fast-paced action, the display ensures an immersive gaming experience with vibrant colors and sharp detail.

Cooling: To keep temperatures in check during intense gaming sessions, the Nitro V is equipped with advanced cooling technology. It features multiple cooling fans, heat pipes, and strategically placed vents to effectively dissipate heat and maintain optimal performance even under heavy load.

Design: With its sleek and modern design, the Nitro V stands out as a stylish gaming laptop. The obsidian black finish gives it a premium look, while the angular lines and red accents add a touch of aggressiveness. The slim profile and lightweight design make it easy to carry around for gaming on the go.

Connectivity: The laptop offers a variety of connectivity options, including USB Type-C, HDMI, and more, allowing you to connect to external displays, gaming peripherals, and other devices with ease. Whether you''re gaming at home or on the go, you have plenty of options for expanding your setup.

Audio: The Nitro V features high-quality audio with built-in speakers and audio enhancements to deliver immersive sound during gameplay. Whether you''re listening to in-game audio cues or enjoying your favorite music and movies, the laptop provides clear and powerful sound that enhances the overall gaming experience.'),
('Acer - Predator Helios 18 Gaming Laptop - 18"  - Abyssal Black', 2999.00, 1, 5, 50, 'The Acer Predator Helios 18 Gaming Laptop is a powerhouse designed for serious gamers and enthusiasts who demand top-tier performance and immersive gaming experiences. With its large 18-inch display, high-end hardware, and cutting-edge features, it''s built to handle the most demanding games and intensive tasks with ease.

The centerpiece of the Predator Helios 18 is its expansive 18-inch display, which offers a stunning visual experience with vibrant colors, sharp detail, and smooth gameplay. Whether you''re battling in intense firefights or exploring vast open worlds, the high-resolution screen delivers immersive visuals that bring your games to life.

Under the hood, the Predator Helios 18 is powered by high-performance hardware, including the latest Intel Core i9 processor and NVIDIA GeForce RTX graphics, providing blazing-fast speeds and exceptional graphics performance. Whether you''re playing the latest AAA titles, streaming 4K content, or running demanding applications, the laptop delivers smooth, responsive performance without compromise.

The Predator Helios 18 also features advanced cooling technology to keep temperatures in check during intense gaming sessions. With multiple cooling fans, heat pipes, and strategically placed vents, the laptop effectively dissipates heat to prevent overheating and maintain optimal performance even under heavy load.

In terms of connectivity, the Predator Helios 18 offers a comprehensive selection of ports and interfaces, including USB Type-C, HDMI, DisplayPort, and more, allowing you to connect to a wide range of devices and peripherals. Whether you''re connecting to external displays, gaming accessories, or storage devices, you have plenty of options for expanding your setup.

The laptop also features customizable RGB lighting, allowing you to personalize the look and feel of your gaming experience. With Acer''s PredatorSense software, you can easily customize lighting effects, adjust fan speeds, and monitor system performance to optimize your gaming experience.

In addition to its gaming prowess, the Predator Helios 18 doubles as a powerful productivity machine, thanks to its powerful hardware and expansive display. Whether you''re editing videos, rendering 3D graphics, or multitasking between multiple applications, the laptop delivers the performance and versatility you need to stay productive.'),
('Acer - Chromebook 516 GE Cloud Gaming Laptop - 16" - Titanium Gray', 649.00, 1, 5, 50, 'The Acer Chromebook 516 GE Cloud Gaming Laptop is a powerful and versatile device designed to provide an immersive gaming experience while maintaining the convenience and simplicity of Chrome OS. With its large 16-inch display, robust hardware, and cloud gaming capabilities, it''s an excellent choice for gamers who prefer the flexibility of cloud-based gaming platforms.

At the heart of the Chromebook 516 GE is its powerful hardware, including an Intel processor and integrated Intel UHD graphics, which deliver smooth performance for gaming, multitasking, and productivity tasks. Whether you''re playing graphics-intensive games, streaming multimedia content, or running productivity apps, the laptop offers responsive performance to meet your needs.

One of the standout features of the Chromebook 516 GE is its large 16-inch Full HD display, which provides immersive visuals and vibrant colors for an enhanced gaming experience. The high-resolution screen delivers crisp detail and clarity, allowing you to enjoy your favorite games with stunning graphics and smooth gameplay.

With cloud gaming capabilities, the Acer Chromebook 516 GE allows you to access a wide range of gaming titles from popular cloud gaming platforms, such as Google Stadia, NVIDIA GeForce NOW, and Xbox Cloud Gaming. By streaming games over the internet, you can play AAA titles without the need for high-end hardware, giving you the flexibility to game on the go or from the comfort of your home.

The Chromebook 516 GE also offers a variety of connectivity options, including USB Type-C and Type-A ports, HDMI output, and a microSD card reader, allowing you to connect external devices and peripherals with ease. Whether you''re connecting to external displays, transferring files, or charging your devices, you have plenty of options for expanding your connectivity.

As a Chromebook, the Acer Chromebook 516 GE runs on Chrome OS, Google''s lightweight and secure operating system designed for cloud-based computing. With built-in access to Google''s suite of productivity apps, such as Google Docs, Sheets, and Slides, you can collaborate with others in real-time and seamlessly sync your files across devices.

The Chromebook 516 GE features a durable and lightweight design, making it easy to carry around whether you''re gaming on the go or working from home. The Titanium Gray finish gives it a modern and professional look, while the robust construction ensures long-lasting performance.'),
('Acer - Chromebook 315 – 15.6" - Silver', 199.00, 1, 5, 50, 'The Acer Chromebook 315 is a versatile and affordable laptop designed to provide users with a seamless Chrome OS experience for work, school, or entertainment. With its large 15.6-inch display, solid performance, and long battery life, it''s a practical choice for users who value productivity and convenience.

The Chromebook 315 features a spacious 15.6-inch Full HD display, providing ample screen real estate for multitasking, streaming content, or browsing the web. The high-resolution screen delivers crisp visuals and vibrant colors, making it ideal for viewing documents, presentations, or multimedia content with clarity and detail.

Powered by an AMD processor, paired with integrated Radeon graphics, the Chromebook 315 offers smooth performance for everyday tasks, such as web browsing, document editing, and streaming video. Whether you''re working on Google Docs, checking emails, or watching online videos, the laptop delivers responsive performance to keep up with your workflow.

One of the key benefits of the Chromebook 315 is its long battery life, allowing you to stay productive throughout the day without constantly searching for a power outlet. With up to 12 hours of battery life on a single charge, you can work, study, or enjoy entertainment without worrying about running out of power.

As a Chromebook, the Acer Chromebook 315 runs on Chrome OS, Google''s lightweight and secure operating system designed for cloud-based computing. With built-in access to Google''s suite of productivity apps, such as Google Docs, Sheets, and Slides, you can collaborate with others in real-time and seamlessly sync your files across devices.

The Chromebook 315 also offers a range of connectivity options, including USB Type-C and Type-A ports, HDMI output, and a microSD card reader, allowing you to connect external devices and peripherals with ease. Whether you''re connecting to external displays, transferring files, or charging your devices, you have plenty of options for expanding your connectivity.

With its sleek and lightweight design, the Acer Chromebook 315 is easy to carry around, whether you''re traveling between classes, commuting to work, or working from home. The Silver finish gives it a modern and professional look, while the durable construction ensures long-lasting performance.'),
('Acer - Predator Helios Neo 16" - Steel Gray', 1199.00, 1, 5, 50, 'The Acer Predator Helios Neo is a powerful gaming laptop designed to deliver immersive gaming experiences with high-performance hardware and cutting-edge features. With its sleek design, vibrant display, and robust specifications, it''s a compelling choice for gamers who demand top-tier performance and reliability.

At the heart of the Predator Helios Neo is a powerful processor, such as an Intel Core i7 or AMD Ryzen CPU, paired with dedicated NVIDIA GeForce RTX graphics. This combination ensures smooth gameplay and fast rendering of graphics-intensive scenes, allowing you to enjoy the latest AAA titles at high settings without sacrificing performance.

The laptop features a spacious 16-inch display with a high refresh rate and fast response time, providing fluid visuals and sharp details during gameplay. Whether you''re engaging in fast-paced action or exploring open-world environments, the display delivers smooth motion and vibrant colors for an immersive gaming experience.

To enhance gameplay immersion, the Predator Helios Neo is equipped with advanced cooling technology to prevent overheating during intense gaming sessions. Acer''s cooling solutions, such as custom-designed cooling fans and heat pipes, help dissipate heat efficiently, ensuring consistent performance and longevity for your hardware components.

In addition to its gaming prowess, the Predator Helios Neo offers a range of connectivity options, including multiple USB ports, HDMI output, and Thunderbolt support, allowing you to connect external devices and peripherals with ease. Whether you''re using gaming accessories, external displays, or storage devices, you have plenty of options for expanding your setup.'),
('Acer - Aspire Vero - 15.6” - Cobblestone Gray', 629.00, 1, 5, 50, 'The Acer Aspire Vero is a sustainable and environmentally friendly laptop designed to minimize its ecological footprint while delivering reliable performance for everyday computing tasks. With its eco-conscious design, versatile features, and stylish appearance, it''s a compelling choice for environmentally conscious consumers seeking a responsible computing solution.

The Aspire Vero features a 15.6-inch display with a crisp HD resolution, providing clear visuals and vibrant colors for an immersive viewing experience. Whether you''re working on documents, browsing the web, or streaming multimedia content, the display offers sharp details and excellent clarity.

Powered by an efficient Intel processor and equipped with ample RAM and storage options, the Aspire Vero delivers smooth performance for multitasking, web browsing, productivity tasks, and multimedia consumption. Whether you''re running multiple applications simultaneously or editing photos and videos, you can expect responsive performance and efficient computing power.

One of the standout features of the Aspire Vero is its eco-friendly design. Constructed from post-consumer recycled (PCR) plastic and featuring a modular design for easy repair and upgradability, the laptop is designed to minimize its environmental impact throughout its lifecycle. Additionally, the packaging is made from recycled materials and is fully recyclable, further reducing waste and promoting sustainability.

In terms of connectivity, the Aspire Vero offers a range of ports and wireless options for versatile connectivity. Whether you''re connecting to peripherals, external displays, or wireless networks, you have plenty of options to suit your needs.'),
('Acer - Chromebook 314 Laptop -14" - Charcoal Black', 269.00, 1, 5, 50, 'The Acer Chromebook 314 Laptop is a versatile and affordable computing solution designed for productivity, entertainment, and everyday tasks. With its sleek design, compact form factor, and reliable performance, it''s an ideal choice for students, professionals, and anyone in need of a reliable and portable device.

Featuring a 14-inch display with a crisp HD resolution, the Chromebook 314 delivers clear visuals and vibrant colors for an immersive viewing experience. Whether you''re working on documents, browsing the web, or streaming your favorite content, the display provides sharp details and excellent clarity.

Powered by an Intel Celeron processor and equipped with up to 4GB of RAM, the Chromebook 314 offers smooth performance for multitasking, web browsing, and productivity tasks. The efficient hardware configuration ensures fast load times and responsive performance, allowing you to work efficiently and stay productive throughout the day.

With Chrome OS, the Chromebook 314 provides a seamless and user-friendly computing experience. Designed for simplicity and security, Chrome OS offers fast boot times, automatic updates, and built-in virus protection, ensuring a hassle-free experience with minimal maintenance required.'),
('Acer - Nitro V ANV15-41-R2Y3 Gaming Laptop– 15.6" - Obsidian Black', 949.00, 1, 5, 50, 'The Acer Nitro V ANV15-41-R2Y3 Gaming Laptop is a powerful gaming machine designed to deliver immersive gaming experiences and high-performance computing. With its sleek design and robust hardware specifications, it''s an ideal choice for gamers and multimedia enthusiasts alike.

The laptop features a 15.6-inch Full HD display, providing crisp visuals and vibrant colors for an immersive gaming experience. The high-resolution screen ensures sharp details and smooth gameplay, allowing you to enjoy your favorite games with stunning clarity.

Powered by an Intel Core processor and NVIDIA GeForce graphics card, the Acer Nitro V offers smooth performance for gaming, content creation, and multitasking. The combination of powerful CPU and GPU ensures fast load times, smooth frame rates, and responsive gameplay, even for the most demanding titles.

Equipped with ample storage options, including a large-capacity SSD, the laptop provides fast boot times and quick access to your games, applications, and files. The SSD also enhances overall system responsiveness, making it ideal for multitasking and productivity tasks.

The laptop''s sleek and stylish design, featuring an Obsidian Black finish, exudes sophistication and blends seamlessly into any gaming setup or workspace. The durable construction and attention to detail reflect Acer''s commitment to quality and craftsmanship.

With advanced cooling technology and optimized thermal management, the Acer Nitro V stays cool and stable during intense gaming sessions, ensuring maximum performance without throttling or overheating. The dual-fan cooling system and strategically placed vents keep internal components at optimal temperatures for smooth and reliable operation.

Featuring a backlit keyboard with customizable lighting options, the Acer Nitro V offers comfortable typing and gaming in any lighting condition. The precision touchpad provides accurate navigation and responsive control, enhancing the overall user experience.

With a comprehensive selection of ports and connectivity options, including USB Type-C, HDMI, and Gigabit Ethernet, the Acer Nitro V offers versatile connectivity for peripherals, external displays, and high-speed internet access. Whether you''re gaming at home or on the go, you can stay connected and productive with ease.'),
('Dell G15 15.6" FHD 120Hz Gaming Laptop - 1TB SSD - Dark Shadow Gray w/ Black Thermal Shelf" - Obsidian Black', 899.00, 1, 6, 50, 'The Dell G15 15.6" is a mid-range gaming laptop aiming to strike a chord between affordability and performance. It caters to those who want to experience the latest titles in smooth, high frame rates, but at a 1080p resolution.

The 15.6-inch display offers a Full HD resolution (1920 x 1080) with a 120Hz refresh rate. This translates to a smoother and more responsive experience compared to traditional 60Hz displays, especially noticeable in fast-paced games. However, some gamers might prefer a sharper visual experience offered by higher resolutions.

Thankfully, the Dell G15 doesn''t skimp on storage and memory.  It boasts 16GB of DDR5 RAM, a significant upgrade over DDR4 in terms of speed. The 1TB PCIe NVMe SSD provides ample space for games, applications, and your personal files.

The design leans towards a practical approach. Built with dark shadow gray plastic and a black thermal shelf, it might not win any design awards, but it prioritizes a sturdy and well-built feel. The weight falls around the 5.3-pound mark, making it reasonably portable for a gaming laptop.

Battery life, a common weakness for gaming laptops, isn''t the G15''s strong suit either. Expect 4-5 hours of light use on a single charge. If you plan on venturing into the world of gaming, you''ll likely need to stay plugged in.

On the upside, the Dell G15 offers a healthy variety of ports including three USB-A ports, a USB-C port, an HDMI port, an Ethernet port, and a headphone jack, ensuring compatibility with your existing peripherals.

In conclusion, the Dell G15 15.6" strikes a balance between price and performance for 1080p gaming. It delivers a smooth gaming experience with a 120Hz display and offers ample storage space. However, keep in mind the shorter battery life and the potential trade-off for gamers seeking a sharper visual experience.'),
('Dell - Inspiron 16.0" 2-in-1 Touch Laptop - 512GB SSD - Dark River Blue', 849.00, 1, 6, 50, 'The Dell Inspiron 16 2-in-1 is a convertible laptop designed for users who prioritize flexibility and a large display. Here''s a breakdown of its key features:

Two Worlds in One: This laptop hinges can flip 360 degrees, transforming it from a traditional laptop to a tablet in seconds. This versatility allows you to use it for tasks like browsing the web, watching videos, or even drawing with a compatible stylus (sold separately) in a comfortable tablet mode.

Spacious Display: The 16-inch touchscreen display offers ample screen real estate, perfect for multitasking, creative work, or enjoying entertainment. The FHD+ (1920 x 1200) resolution delivers good image quality, while the glossy finish provides vibrant colors. However, some users might prefer a higher resolution for sharper visuals, especially when working with text or detailed graphics.'),
('Dell – Inspiron 14” 2-in-1 Touch Laptop – 1TB SDD - Ice Blue', 999.00, 1, 6, 50, 'The Dell Inspiron 14 2-in-1 is a versatile laptop designed for users who crave both portability and flexibility. Here''s a closer look at what it offers:

Form Meets Function: This 2-in-1 boasts a 360-degree hinge, allowing you to seamlessly switch between a traditional laptop and a tablet. This opens doors for comfortable browsing, watching videos, or even creative endeavors like drawing with a compatible stylus (not included). The 14-inch touchscreen provides a spacious work area that''s perfect for multitasking on the go, while remaining relatively portable thanks to its smaller size.

Visual Appeal: The display offers a crisp Full HD+ resolution (1920 x 1200) for enjoyable visuals. The Ice Blue color adds a touch of personality to the design.  While the FHD+ resolution delivers good image quality, users who prioritize razor-sharp details for tasks like photo editing might prefer a higher resolution display.

Performance Packed:  Under the hood, you''ll find an 11th or 12th Gen Intel Core processor (depending on configuration) that tackles everyday tasks and light multitasking with ease.  This is paired with 16GB of DDR5 memory, ensuring smooth performance when switching between applications. Storage is handled by a generous 1TB SSD, providing ample space for your files, programs, and operating system.

Added Conveniences: The backlit keyboard allows for comfortable typing in low-light environments. Some configurations might include a fingerprint reader for an extra layer of security.'),
('Dell - 16" 13th Generation Gaming Laptop - 1TB SSD - Metallic Nightshade', 1599.00, 1, 6, 50, 'Unleash your inner champion with the Dell 16-inch Gaming Laptop. This powerhouse laptop boasts a sprawling 16-inch display, cloaked in a captivating Metallic Nightshade finish. Dive deeper into expansive game worlds with stunning visuals, brought to life by either a Full HD or QHD+ resolution option. Experience silky-smooth gameplay thanks to high refresh rates, ensuring every in-game detail is razor-sharp and every action feels incredibly responsive.

Dominate the competition with the latest 13th Gen Intel Core processor under the hood. This processor joins forces with a powerful NVIDIA GeForce RTX graphics card, delivering the muscle to conquer even the most demanding games at high settings. Whether you''re battling dragons or crafting intricate worlds, this laptop offers the performance to fuel your passion.

Store your entire gaming library with ease thanks to a massive 1TB SSD. No more agonizing choices – with this much space, you can install all your favorite games, applications, and the operating system without a second thought. The sleek and stylish design, accentuated by the Metallic Nightshade finish, complements any setup. But don''t let the good looks fool you – this laptop prioritizes keeping things cool with an efficient heat dissipation system, ensuring your gaming sessions stay uninterrupted.

This Dell 16-inch Gaming Laptop is the perfect companion for gamers who demand both style and substance. Conquer your opponents, create breathtaking visuals, and immerse yourself in the world of gaming like never before.'),
('Dell - Inspiron 14.0" 2-in-1 Touch Laptop - 512GB SSD - Platinum Silver', 729.00, 1, 6, 50, 'The Dell Inspiron 14 2-in-1 Touch Laptop in Platinum Silver is a versatile laptop designed for users who crave a balance between portability and functionality. Let''s delve into its key features:

Two Worlds in One: This laptop boasts a 360-degree hinge, allowing you to effortlessly convert it from a traditional laptop to a tablet. This flexibility empowers you to browse the web, watch videos, or even unleash your creativity with a compatible stylus (sold separately) in a comfortable tablet mode.

Designed for On-the-Go: The 14-inch touchscreen display offers a good amount of screen real estate for multitasking and entertainment while remaining relatively portable thanks to its compact size. The Platinum Silver finish adds a touch of sophistication to the design.

Visual Fidelity: The display offers a crisp Full HD+ resolution (1920 x 1200) for enjoyable visuals. While FHD+ provides good image quality, users who prioritize razor-sharp details for tasks like photo editing might prefer a higher resolution display.

Performance Under the Hood:  Depending on the specific configuration, you might find an 11th Gen Intel Core processor or a newer 12th Gen Intel Core processor. Both options should handle everyday tasks and light multitasking with ease. The processor is paired with 16GB of DDR4 or DDR5 memory (depending on configuration) ensuring smooth performance when switching between applications. Storage is provided by a 512GB SSD, offering ample space for your files, programs, and operating system.'),
('Dell Inspiron 15 Touch Screen Laptop –512GB SSD - Carbon Black', 629.00, 1, 6, 50, 'The Dell Inspiron 15 Touch Screen Laptop with 512GB SSD in Carbon Black is a mid-range laptop aiming to please users who juggle productivity, entertainment, and a touch of creative flair.

The 15.6-inch touchscreen display offers ample space for multitasking, watching videos, or browsing the web. The touchscreen itself allows for intuitive interaction and potentially light creative work with a compatible stylus (usually sold separately).

Performance varies depending on the specific configuration. You might find 11th Gen or 12th Gen Intel Core processors or AMD Ryzen processors powering this laptop. The processor you choose will determine how well it tackles everyday tasks, multitasking, and even some light content creation. Most configurations come with 8GB of DDR4 memory, which is sufficient for most everyday tasks, but some users might prefer 16GB for smoother handling of multiple programs running at once.

Storage won''t be a concern with the 512GB SSD. This offers a significant speed boost and overall responsiveness compared to traditional hard drives, making your everyday computing experience snappier.

The Carbon Black finish gives the laptop a professional and sleek look. Build quality might be plastic, but it should be sturdy enough for everyday use. While a 15-inch screen provides a generous viewing area, the weight typically falls around 4-5 pounds, making it reasonably portable for its size.

A backlit keyboard allows for comfortable typing in low-light environments, and some configurations might include an integrated fingerprint reader for added security. Dell laptops typically come with the user-friendly Windows operating system, most likely Windows 11 Home in this case.'),
('Lenovo - Yoga 7i 2-in-1 16" 2K Touchscreen Laptop - 1TB SSD - Storm Grey', 1049.00, 1, 8, 50, 'The Lenovo Yoga 7i 2-in-1 16" 2K Touchscreen Laptop offers a versatile computing experience with its flexible design and powerful performance. Featuring an Intel Core Ultra 7 155U processor and 16GB of memory, this laptop delivers smooth multitasking and efficient performance for a variety of tasks, from productivity work to multimedia entertainment.

The vibrant 16" 2K touchscreen display provides crisp visuals and responsive touch controls, allowing you to interact with your content effortlessly. Whether you''re watching movies, browsing the web, or creating digital art, the high-resolution screen offers immersive viewing experiences.

With a spacious 1TB SSD, you''ll have ample storage space for your files, applications, and media collections. The SSD also ensures fast boot-up times and quick access to your data, enhancing overall system responsiveness.

Designed for portability and convenience, the Yoga 7i features a sleek and lightweight design in Storm Grey, making it easy to carry with you wherever you go. Its 2-in-1 convertible design allows you to use it as a traditional laptop or switch to tablet mode for touchscreen interactions and creative tasks.

Whether you''re working on the go, streaming content, or staying connected with friends and family, the Lenovo Yoga 7i offers the performance, versatility, and flexibility to meet your computing needs.'),
('Lenovo - Ideapad 1 15.6" Full HD Touchscreen Laptop - 256GB SSD - Abyss Blue', 579.00, 1, 8, 50, 'The Lenovo Ideapad 1 15.6" Full HD Touchscreen Laptop combines affordability with functionality, making it an ideal choice for everyday computing tasks. With its 15.6" Full HD touchscreen display, this laptop offers crisp visuals and intuitive touch controls, allowing you to navigate and interact with your content with ease.

Powered by an efficient processor, the Ideapad 1 delivers reliable performance for web browsing, productivity tasks, and multimedia entertainment. Its compact and lightweight design makes it easy to carry with you wherever you go, while the touchscreen functionality adds versatility to your computing experience.

Additionally, the laptop offers a range of connectivity options, including USB ports, HDMI, and Wi-Fi, allowing you to easily connect peripherals and accessories.

Whether you''re working on school projects, streaming videos, or staying connected with friends and family, the Lenovo Ideapad 1 provides the essential features you need for everyday computing, all at an affordable price point.'),
('Lenovo - Ideapad 1 15.6" Full HD Touchscreen Laptop - 512GB SSD - Cloud Gray', 799.00, 1, 8, 50, 'The Lenovo Ideapad 1 15.6" Full HD Touchscreen Laptop combines affordability with functionality, making it an ideal choice for everyday computing tasks. With its 15.6" Full HD touchscreen display, this laptop offers crisp visuals and intuitive touch controls, allowing you to navigate and interact with your content with ease.

Powered by an efficient processor, the Ideapad 1 delivers reliable performance for web browsing, productivity tasks, and multimedia entertainment. Its compact and lightweight design makes it easy to carry with you wherever you go, while the touchscreen functionality adds versatility to your computing experience.

Additionally, the laptop offers a range of connectivity options, including USB ports, HDMI, and Wi-Fi, allowing you to easily connect peripherals and accessories.

Whether you''re working on school projects, streaming videos, or staying connected with friends and family, the Lenovo Ideapad 1 provides the essential features you need for everyday computing, all at an affordable price point.'),
('Lenovo - Yoga 7 16" WUXGA 2 in 1 Touch Screen Laptop - 512GB SSD - Arctic Grey', 749.00, 1, 8, 50, 'The Lenovo Yoga 7 16" WUXGA 2-in-1 Touch Screen Laptop offers a premium computing experience with its versatile design and powerful performance. Featuring a stunning 16" WUXGA touchscreen display, this laptop delivers sharp and vibrant visuals, perfect for multimedia consumption, creative work, and productivity tasks.

Equipped with a spacious 512GB SSD, the Yoga 7 provides ample storage space for your files, applications, and multimedia content, ensuring fast access and smooth performance. Whether you''re storing large media files or installing software, you''ll have plenty of room to accommodate your needs.

The 2-in-1 design allows you to use the Yoga 7 in multiple modes, including laptop, tent, stand, and tablet modes, providing flexibility for different tasks and environments. Whether you''re typing documents, watching movies, or sketching ideas with the included stylus, you can find the perfect angle and orientation for your needs.

Powered by high-performance components, such as an Intel Core processor, the Yoga 7 delivers smooth multitasking and responsive performance, allowing you to tackle demanding tasks with ease. Additionally, with features like fast SSD storage and ample RAM, you can enjoy quick boot times, rapid application launches, and seamless multitasking.

With its sleek and stylish Arctic Grey finish, the Lenovo Yoga 7 exudes elegance and sophistication, making it a statement piece wherever you go. Whether you''re working on-the-go, attending meetings, or enjoying entertainment at home, the Yoga 7 is designed to complement your lifestyle with its blend of performance, versatility, and style.'),
('Lenovo - Legion Slim 5 14.5" OLED Gaming Laptop - 1 TB SSD - Storm Grey', 1479.00, 1, 8, 50, 'The Lenovo Legion Slim 5 14.5" OLED Gaming Laptop is a powerhouse designed for gaming enthusiasts who demand high performance in a sleek and portable package. Boasting a stunning 14.5" OLED display, this laptop delivers vibrant colors, deep blacks, and crisp details, immersing you in your favorite games with lifelike visuals.

Equipped with a spacious 1TB SSD, the Legion Slim 5 provides ample storage space for your game library, ensuring fast load times and smooth gameplay. Whether you''re installing large AAA titles or storing multimedia content, you''ll have plenty of room to accommodate your needs.

Under the hood, the Legion Slim 5 is powered by high-performance components, including powerful processors and dedicated graphics cards, allowing you to tackle the latest games with ease. With features like advanced cooling systems and optimized performance settings, you can push your gaming experience to the next level without worrying about overheating or performance throttling.

Despite its powerful internals, the Legion Slim 5 maintains a slim and lightweight design, making it ideal for gaming on-the-go. Whether you''re gaming at home, at a friend''s house, or on a road trip, you can take your gaming experience with you wherever you go.

The Storm Grey finish adds a touch of sophistication to the laptop''s design, making it a stylish choice for gamers who appreciate both performance and aesthetics. Whether you''re battling opponents in intense multiplayer matches or exploring vast open worlds, the Lenovo Legion Slim 5 is designed to deliver an exceptional gaming experience in a portable and stylish package.'),
('HP - 14" Laptop - 64GB eMMC - Snowflake White', 179.00, 1, 7, 50, 'The HP 14" Laptop offers a compact and versatile computing solution with options for either a 64GB eMMC storage or a 128GB storage configuration. This laptop is designed for users who prioritize portability and affordability without sacrificing performance. With its 14-inch display, it strikes a balance between screen real estate and compactness, making it suitable for productivity tasks, web browsing, and multimedia consumption.'),
('HP - 14" Laptop - 128GB eMMC - Rose Gold', 199.00, 1, 7, 50, 'The HP 14" Laptop offers a compact and versatile computing solution with options for either a 64GB eMMC storage or a 128GB storage configuration. This laptop is designed for users who prioritize portability and affordability without sacrificing performance. With its 14-inch display, it strikes a balance between screen real estate and compactness, making it suitable for productivity tasks, web browsing, and multimedia consumption.'),
('HP - 14" Laptop - 64GB eMMC - Indigo Blue', 179.00, 1, 7, 50, 'The HP 14" Laptop offers a compact and versatile computing solution with options for either a 64GB eMMC storage or a 128GB storage configuration. This laptop is designed for users who prioritize portability and affordability without sacrificing performance. With its 14-inch display, it strikes a balance between screen real estate and compactness, making it suitable for productivity tasks, web browsing, and multimedia consumption.'),
('HP - Envy 2-in-1 15.6" Full HD Touch-Screen Laptop - 256GB SSD - Natural Silver', 919.00, 1, 7, 50, 'The HP Envy 2-in-1 15.6" Full HD Touch-Screen Laptop combines versatility, power, and style to offer a premium computing experience. With its 2-in-1 design, it seamlessly transitions between laptop and tablet modes, providing flexibility for various tasks and activities.

Featuring a vibrant 15.6-inch Full HD touch-screen display, this laptop delivers stunning visuals and responsive touch functionality, enhancing both productivity and entertainment experiences. The touch-screen interface enables intuitive navigation and interaction with content, whether you''re browsing the web, editing documents, or enjoying multimedia.

Powered by a solid-state drive (SSD) with a capacity of 256GB, the HP Envy ensures fast boot times, snappy performance, and ample storage for your files, applications, and multimedia content. The SSD storage also contributes to energy efficiency and quieter operation compared to traditional hard drives.

The sleek and elegant design of the laptop, finished in Natural Silver, exudes sophistication and professionalism, making it suitable for both work and leisure environments. The slim profile and lightweight construction enhance portability, allowing you to take your laptop with you wherever you go.

Equipped with powerful hardware, including an Intel processor, this laptop delivers smooth multitasking performance and responsive computing, enabling you to tackle demanding tasks with ease. Additionally, the inclusion of features such as built-in speakers, webcam, and microphone enhances communication and multimedia capabilities.'),
('HP - Victus 15.6" Full HD 144Hz Gaming Laptop - 512GB SSD - Performance Blue', 879.00, 1, 7, 50, 'The HP Victus 15.6" Full HD 144Hz Gaming Laptop is designed to deliver powerful performance and immersive gaming experiences in a stylish and portable package. Engineered for gamers and content creators, this laptop combines high-performance hardware with thoughtful design elements to meet the demands of modern computing.

Featuring a vibrant 15.6-inch Full HD display with a high refresh rate of 144Hz, the Victus gaming laptop delivers smooth visuals and fluid motion, enhancing gameplay and multimedia viewing. The Full HD resolution ensures sharp details and vibrant colors, while the high refresh rate reduces motion blur and screen tearing for a more responsive gaming experience.

Powered by a fast and reliable 512GB solid-state drive (SSD), this laptop offers ample storage space for games, applications, and multimedia content while delivering quick boot times and snappy responsiveness. The SSD storage also contributes to faster load times, allowing you to jump into your favorite games without delay.'),
('HP - 14" Chromebook Laptop - 64GB eMMC - Modern Gray', 299.00, 1, 7, 50, 'The HP 14" Chromebook Laptop is a sleek and efficient computing device designed for productivity and versatility in a lightweight package. With its modern gray finish and compact design, this Chromebook offers portability and style for users on the go.

Powered by Chrome OS, the HP 14" Chromebook provides a streamlined and secure computing experience, optimized for web-based applications and cloud computing. The operating system ensures fast boot times, seamless updates, and built-in virus protection, allowing users to focus on their tasks without worrying about system maintenance.

Equipped with a 14-inch display, this Chromebook delivers crisp visuals and immersive viewing experiences for productivity tasks, multimedia consumption, and web browsing. The display size strikes a balance between portability and usability, making it ideal for both work and entertainment purposes.

The Chromebook is equipped with a 64GB embedded MultiMediaCard (eMMC) storage, providing ample space for storing files, documents, and multimedia content. Additionally, users can take advantage of cloud storage options such as Google Drive for expanding storage and accessing files from anywhere with an internet connection.'),
('HP - Envy 17.3" Full HD Touch-Screen Laptop - 1TB SSD - Glacier Silver', 1349.00, 1, 7, 50, 'The HP Envy 17.3" Full HD Touch-Screen Laptop in Glacier Silver combines power, elegance, and versatility to cater to a wide range of computing needs. With its expansive display, high-performance hardware, and premium design, it offers a luxurious computing experience suitable for demanding tasks and multimedia entertainment.

The laptop features a spacious 17.3-inch Full HD touch-screen display, providing immersive visuals with vibrant colors and sharp details. The touch-screen functionality adds convenience and interactivity, allowing users to navigate the operating system and interact with applications with ease.

Equipped with a 1TB solid-state drive (SSD), the HP Envy offers ample storage space for storing large files, multimedia content, and software applications. The SSD ensures fast boot times, rapid data access, and smooth multitasking, enhancing overall system responsiveness and performance.

Powered by high-performance Intel processors and integrated graphics, the HP Envy delivers smooth computing performance for productivity tasks, creative work, multimedia editing, and light gaming. Whether you''re multitasking between applications, streaming HD videos, or editing photos, this laptop can handle it all with ease.

The laptop''s sleek and stylish Glacier Silver design exudes sophistication, making it a statement piece in any environment, whether you''re working in the office or relaxing at home. The premium build quality and attention to detail reflect HP''s commitment to craftsmanship and aesthetics.

Featuring a full-size keyboard with a numeric keypad and backlit keys, the HP Envy offers comfortable typing in any lighting condition, enhancing productivity during late-night work sessions or dimly lit environments. The precision touchpad provides smooth and responsive navigation, ensuring an intuitive user experience.

With advanced connectivity options including Wi-Fi 6, Bluetooth, USB Type-C, HDMI, and more, the HP Envy offers seamless connectivity for peripherals, external displays, and high-speed internet access. Whether you''re transferring files, streaming content, or connecting to external devices, this laptop provides reliable and versatile connectivity options.'),

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
('Insignia - 25" 4K Ultra HD HDMI Cable - Black', 79.99, 5, 12, 50, 'Use this Insignia HDMI cable to set up your ideal entertainment system in your home. An in-wall rating keeps the tangle of wires from view, and the 25-foot length offers a range of placement options. This Insignia HDMI cable handles the latest in 4K HDMI systems, and Ethernet capabilities expand your possibilities.'),

('Apple - MagSafe iPhone Charger - White', 33.99, 6, 1, 50, 'The MagSafe Charger makes wireless charging a snap. The perfectly aligned magnets attach to your iPhone 15, iPhone 15 Pro, iPhone 13 or iPhone 13 Pro, iPhone 12 or iPhone 12 Pro and provide faster wireless charging.'),
('Samsung - SmartThings Station with Power Adapter - Black', 79.99, 6, 2, 50, 'Invite intelligence into your home. Beyond charging your device, SmartThings Station is designed to make your day and night run smoothly with smart features, automated experiences and convenient control of your home.'),
('Samsung - Wireless Charger Pad Trio - Black', 89.99, 6, 2, 50, 'With room to hold three devices at once — a smartwatch and two phones, or a smartwatch, earbuds, and phone — you can power up your ecosystem all at once**. So when you’re done for the day, just put your devices down in one place to be ready for tomorrow.'),
('Samsung - 25W Super Fast Charging Wall Charger USB-C - Black', 15.99, 6, 2, 50, 'Super fast charging up to 25W with compatible devices and other USB devices will charge at varying rates also works with USB-C cable.'),
('Insignia - 72.5W 2-Port USB-C, USB Foldable Wall Charger for Laptops, Smartphone, and Tablet - White', 22.99, 6, 12, 50, 'Don’t let your laptop or smartphone battery die as you work throughout the day. The Insignia NS-PW372AC1W22 72.5W 2-Port USB-C/USB Wall Charger has a 72.5-watt output to quickly charge your laptop, smartphone, tablet or other device. It has a USB-C and a standard USB port so you can connect your cables (not included) and charge two devices simultaneously. Its compact and durable body with a foldable plug easily fits into a purse or pocket, ready for when you need it. A simple white design pairs well with your other accessories. Keep your laptop and phone both working as hard as you do with this dual-port, easy-to-carry charger.'),
('Samsung - Super Fast Charging 65W Trio Adapter - Black', 59.99, 6, 2, 50, 'Maximize your charging time. Power up a wide range of devices from earbuds to laptops.'),
('Google - 30W USB-C Charger and Cable - Clearly White', 35.00, 6, 3, 50, 'Charge your Google products and other USB-C devices quickly with the 30W USB-C Charger. It’s compact enough to take wherever you go.'),
('Apple - 20W USB-C Power Adapter - White', 14.99, 6, 1, 50, 'The Apple 20W USB-C Power Adapter offers fast, efficient charging at home, in the office, or on the go. While the power adapter is compatible with any USB-C-enabled device, Apple recommends pairing it with the 11-inch iPad Pro and 12.9-inch iPad Pro (3rd generation) for optimal charging performance. The Apple 20W USB-C Power Adapter offers fast, efficient charging at home, in the office, or on the go. Pair it with iPhone 8 or later for fast charging–50 percent battery in around 35 minutes.* Or pair it with the iPad Pro and iPad Air for optimal charging performance. Compatible with any USB-C enabled device. *Charging cable sold separately.'),
('Insignia - 30W USB-C Foldable Compact Wall Charger Bundle with 6’ USB-C to C cable for Smartphones, Tablets and More - White', 24.99, 6, 12, 50, 'Don’t let the battery of your device die as you work throughout the day. The Insignia NS-MW3130C1W24B 30W USB-C Foldable Compact Wall Charger for Smartphones, Tablets and More has a 30-watt output to quickly charge all your USB-C devices. Its compact, durable body and a foldable plug easily fit into a purse or pocket, ready for when you need it. An included 6 ft. USB-C cable provides flexible placement options and is braided for an improved look and feel. All that and a simple white design pairs well with your other accessories. Keep your devices working as hard as you do with this easy-to-carry charger.'),
('Anker - 735 65W 3 Port USB Foldable Fast Wall Charger with GaN for iPhone, Samsung, Tablets, Laptops - Black', 39.99, 6, 10, 50, 'Instead of filling up your house (and the planet) with an extra charger for each new device you buy, Anker 735 charger has the power you need to charge the majority of your personal devices with just a single charger.'),

('Cellularline Power Bank Essence 20000 Portable Charger 20000 mAh - Input 1 x USB-C, 1 x Micro USB 10.5 W - Output 1 x USB 12 W - Black', 39.99, 8, 14, 50, 'ESSENCE is the Cellularline portable battery charger that ensures optimal performance when the smartphone needs to be charged in an emergency and provides up to 12W of power. It has two USB-C and Micro USB input ports for charging the battery charger and a USB output for charging the device. The design has been studied for best performance: the non-slip paint gives it a solid grip and the soft material coating feels comfortable.'),
('Cellularline Power Bank Essence 5000 mAh Portable Charger - Input 1 x USB-C, 1 x Micro USB 10.5 W - Output 1 x USB 12 W (Blue)', 27.99, 8, 14, 50, 'Essence is the cellularline power bank that guarantees excellent performance for emergency charging of the smartphone and delivers up to 12W of power. It is equipped with two INPUT USB-C and MICRO-USB ports for charging the charger and an OUTPUT USB port for charging the device. The design is designed to provide the best performance: the non-slip coating and soft-touch coating give strength to the grip and feel comfortable.'),
('Anker - Power Bank (10000mAh, 20W, 3-Port) - Black', 39.99, 8, 10, 50, 'Elevate your charging experience with the PowerCore III Sense (10000mAh, 20W, 3-Port). This power bank offers versatile charging options, featuring Triple Charging Modes including a 20W Power Delivery USB-C port, a PowerIQ-enabled USB-A port, and a trickle-charging mode for low-power devices. Charge two devices simultaneously through its dual USB ports. With exquisite craftsmanship, its sleek design and cool-blue LED light wheel showcase the battery level elegantly. Quality is paramount inside and out. Recharge swiftly in just 4.5 hours using a USB-C Power Delivery wall charger (charger not included), or approximately 10.2 hours with a USB-A charger and cable (not included). Elevate your charging game with PowerCore III Sense 10K.'),
('Anker PowerCore III Sense 20K USB-C Portable Battery Charger - Black', 49.99, 8, 10, 50, 'Anker PoweCore III Sense 20K Portable Charger is one of the slimmest Power Delivery portable power banks around. It offers high-speed charging for virtually any mobile device on the market. With its large 20,000mAh cell capacity, you can keep all your devices charged for days, wherever you are. The power bank comes with two PowerIQ USB-A outputs for dual-device charging and one Power Delivery USB-C input for extremely quick recharging. The Anker MultiProtect safety system includes high-voltage protection, current regulation, temperature control, and more to keep you and your devices safe. On top of its charging power, you can keep a stylish and professional look with the fabric exterior. This is all you need in a charging companion. Compatible with iPhone 13/13 Pro/12/12 Pro/12 Pro Max/8/X/XR, Samsung, iPad Pro, and More.'),
('Anker 737 Power Bank - Black', 189.99, 8, 10, 50, 'The Anker 737 Power Bank (Black) is a powerful portable charger with a massive 24,000mAh capacity, allowing you to charge your devices multiple times. It supports fast charging technology for various devices, including laptops, and features multiple ports for charging multiple devices at once. An integrated digital display provides information like charging power and estimated recharge time. This black colored power bank is a reliable option for keeping your devices powered up wherever you go.'),
('Anker - Power Bank (24000mAh, 140W, 3-Port) - Black', 109.99, 8, 10, 50, 'Harness the power of Power Delivery 3.1, boasting a remarkable 140W output for lightning-fast recharges of laptops, tablets, and phones. Charge a MacBook Pro 14" up to 80% in just 51 minutes, or achieve the same with a 140W charger in a swift 40 minutes. Stay informed with real-time insights, showing power levels, estimated full charge times, and power bank temperature. With a generous 24,000 mAh capacity, charge a MacBook Air 1.3 times or multiple iPhones on the go. Designed for convenience and compliance, it adheres to boarding regulations while maintaining exceptional portability. Connect to any port for optimal charging efficiency. Our intelligent temperature monitoring system ensures safety with a consistent temperature 10% below international guidelines. Embrace the future of charging with unparalleled performance and safety.'),
('Energizer - MAX 30,000mAh 15W USB-C 3-Port Universal Portable Power Bank with LCD screen for Smartphones & Accessories - Black', 59.99, 8, 11, 50, 'Charge your mobile devices quickly and efficiently with this Energizer power bank.  This portable charger provides 30,000mAh capacity to charge smartphones, tablets, smartwatches, headphones, ear buds, and more.  The bright LCD screen displays the current battery level so you always know how much power is left. The 30,000mAh battery provides up to 108 hours of additional power to smartphones while the two USB 2.1 Type-A ports with Rapid Charge technology deliver power consistently and efficiently to up to two devices at once at 10.5W. The USB-C output provides up to 15W of charging power. Charge up to thee devices at once via two USB-A outputs and one USB-C output. The textured surface prevents slippage, scratches and fingerprints. Energizer PowerSafe Management protects against short circuit, overcurrent, overcharge and overdischarge for your power bank and devices. A USB-C Cable is included for recharging the power bank quickly and efficiently.'),
('Energizer - Ultimate Lithium 30,000 mAh 30W PD USB-C Universal Portable Power Bank with 6 Ports and LCD Display - Black', 69.99, 8, 11, 50, 'Charge your mobile devices including Smartphones, Compuiters, Tablets, earbuds and most USB devices with this Energizer power bank. The six outputs, including 4 Smart USB-A and 2 USB-C, can charge six devices at the same time. The 30W USB-C Power Delivery technology allows you to fast charge the new iPhones from 0 to 50% in only 30 minutes, and other USB-C devices. The two 30W USB-C Power Delivery outputs also support laptop charging. Four USB-A ports charge devices at 18W to charge Android devices from 0-50% in 30 minutes. The dual inputs allow you to recharge through USB-C or micro-USB based on your convenience. The LCD screen indicator shows the battery charging status at a quick glance. Energizer PowerSafe Management guarantees against short circuit, overcurrent, overcharge and overdischarge for your power bank and devices.'),


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
(65, '4.7 inches', '1334 x 750 pixels', '4 GB', '256 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'white', 'iOS', 2022),
(66, '4.7 inches', '1334 x 750 pixels', '4 GB', '256 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'red', 'iOS', 2022),
(67, '4.7 inches', '1334 x 750 pixels', '4 GB', '256 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'blue', 'iOS', 2022),
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



UPDATE products
SET description = 'The iPad Pro 2024 is a revolutionary leap forward in the realm of tablets, seamlessly blending cutting-edge technology with sleek design to offer users an unparalleled experience. At the heart of this device lies its stunning Liquid Retina XDR display, stretching from edge to edge with vibrant colors, deep blacks, and incredible brightness levels. This display isn''t just for show; it''s a canvas for creativity, a window into immersive entertainment, and a tool for productivity.

Powered by the latest iteration of Apple''s custom-designed A-series chip, the iPad Pro 2024 delivers unparalleled performance. Whether you''re editing 4K videos, rendering complex 3D models, or running the most demanding apps, this tablet handles it all with ease. Multitasking is effortless, thanks to the seamless integration of hardware and software, allowing you to switch between apps fluidly and without delay.

But the iPad Pro 2024 isn''t just about power; it''s about precision too. With support for the Apple Pencil, you can sketch, annotate, and design with unparalleled accuracy and responsiveness. Whether you''re an artist, an architect, or a student taking notes in class, the Apple Pencil unlocks new possibilities and transforms the way you interact with your device.

In addition to its performance and precision, the iPad Pro 2024 is also a versatile tool for connectivity and communication. With built-in Face ID, you can securely unlock your device, authenticate purchases, and access sensitive information with just a glance. And with support for 5G connectivity, you can stay connected wherever you go, whether you''re streaming content, participating in video calls, or downloading large files on the go.

The iPad Pro 2024 also boasts a range of advanced features and accessories that further enhance its capabilities. With USB-C connectivity, you can connect a wide range of peripherals and accessories, from external displays to cameras to storage devices. And with support for the latest accessories, including the Magic Keyboard and the Smart Folio, you can customize your iPad Pro to suit your needs and preferences.'
WHERE name LIKE 'Apple - iPad Pro%';



UPDATE products
SET description = 'The iPad Air 2024 is a remarkable blend of power, portability, and versatility, setting a new standard for what a mid-range tablet can offer. Designed to be both sleek and functional, it boasts a stunning Liquid Retina display that immerses you in vivid colors and sharp details, whether you''re watching movies, browsing the web, or creating content.

Under the hood, the iPad Air 2024 is powered by Apple''s latest A-series chip, delivering impressive performance and responsiveness for everyday tasks and demanding applications alike. Whether you''re editing photos, gaming, or multitasking between apps, you''ll experience smooth performance and snappy responsiveness.

One of the standout features of the iPad Air 2024 is its compatibility with the second-generation Apple Pencil, allowing you to sketch, take notes, and annotate documents with precision and ease. Whether you''re a student, an artist, or a professional, the Apple Pencil unlocks new possibilities and enhances your productivity.

In terms of connectivity, the iPad Air 2024 offers the convenience of USB-C, making it easy to connect to a wide range of accessories and peripherals, from external storage drives to keyboards to displays. With support for Wi-Fi 6 and optional 5G connectivity, you can stay connected wherever you go, whether you''re at home, at work, or on the go.

The iPad Air 2024 also features a sleek and lightweight design, making it easy to take with you wherever you go. Whether you''re traveling, commuting, or simply moving around the house, its compact form factor and all-day battery life ensure that you can stay productive and entertained throughout the day.'
WHERE name LIKE 'Apple - iPad Air%';



UPDATE products
SET description = 'The iPad 10.9" 2022, also known as the iPad Air 5th generation, represents a significant leap forward in performance, design, and versatility within the iPad lineup. With a larger display compared to previous Air models, this tablet strikes a perfect balance between portability and productivity, making it ideal for a wide range of users, from students to professionals.

At the heart of the iPad 10.9" 2022 is the powerful A15 Bionic chip, delivering blazing-fast performance and graphics capabilities that rival many laptops. Whether you''re multitasking with multiple apps, editing photos and videos, or playing immersive games, you''ll experience smooth and responsive performance that enhances your overall productivity and entertainment experience.

The tablet features a stunning Liquid Retina display with True Tone technology, offering vibrant colors, sharp details, and a wide viewing angle that brings your content to life. Whether you''re watching movies, browsing the web, or sketching with the Apple Pencil, you''ll enjoy an immersive and enjoyable viewing experience that''s perfect for both work and play.

Speaking of the Apple Pencil, the iPad 10.9" 2022 supports the 2nd generation Apple Pencil, allowing you to take notes, draw, and annotate documents with precision and ease. Whether you''re a student taking notes in class, an artist sketching on the go, or a professional annotating documents in meetings, the Apple Pencil unlocks new possibilities and enhances your creativity and productivity.

In terms of design, the iPad 10.9" 2022 features a sleek and modern aesthetic, with slim bezels and a Touch ID sensor built into the top button for secure and convenient authentication. Its lightweight and durable aluminum chassis make it easy to carry with you wherever you go, while its all-day battery life ensures that you can stay productive and entertained throughout the day.

With the latest version of iPadOS, the iPad 10.9" 2022 offers powerful multitasking features, intuitive gestures, and seamless integration with other Apple devices, allowing you to work and play across multiple devices with ease. Whether you''re using Slide Over to quickly access your favorite apps, Split View to multitask between two apps, or Universal Control to seamlessly move between your iPad and Mac, iPadOS delivers a truly versatile and productive computing experience.'
WHERE name LIKE 'Apple - iPad 10.9"%';



UPDATE products
SET description = 'The Huawei MatePad 10.4" (2022) is a versatile and feature-rich tablet designed to enhance productivity, creativity, and entertainment experiences. With its spacious 10.4-inch display, users can enjoy immersive viewing for multimedia content, gaming, and productivity tasks. Powered by Huawei''s advanced hardware and software technologies, including a powerful chipset and optimized operating system, the MatePad 10.4" delivers smooth performance and efficient multitasking capabilities.

Equipped with a high-resolution display, the MatePad 10.4" ensures crisp and vibrant visuals, making it ideal for streaming videos, browsing photos, and reading e-books. Additionally, Huawei''s innovative display technologies help reduce eye strain during extended use.

The MatePad 10.4" boasts a sleek and modern design, featuring slim bezels and a premium build quality that exudes sophistication. Its lightweight and portable design make it convenient to carry around for on-the-go use, whether at home, in the office, or while traveling.

For creative professionals and enthusiasts, the MatePad 10.4" offers a range of productivity tools and features, including support for stylus input. With Huawei''s M-Pen stylus (sold separately), users can sketch, draw, take notes, and annotate documents with precision and ease.

In terms of connectivity, the MatePad 10.4" offers versatile options, including Wi-Fi and optional LTE support, allowing users to stay connected wherever they go. Additionally, it features a range of ports for connecting peripherals and accessories, ensuring compatibility with various devices and accessories.'
WHERE name LIKE 'Huawei - MatePad 10.4" (2022)%';



UPDATE products
SET description = 'The Lenovo Tab M10 Plus Gen 3 is a versatile and feature-rich tablet designed to provide users with an immersive multimedia experience, efficient productivity tools, and seamless connectivity. With its sleek design and advanced features, it caters to both entertainment enthusiasts and professionals seeking enhanced productivity on the go.

Featuring a vibrant 10.1-inch display, the Tab M10 Plus Gen 3 delivers crisp visuals and immersive viewing experiences for streaming movies, browsing photos, playing games, and more. The Full HD resolution ensures sharp detail and vivid colors, making every image and video come to life with stunning clarity.

Powered by a robust processor and optimized software, the Tab M10 Plus Gen 3 offers smooth performance and responsive multitasking capabilities. Whether you''re browsing the web, running productivity apps, or enjoying graphics-intensive games, this tablet delivers a seamless user experience with minimal lag.

With its slim and lightweight design, the Tab M10 Plus Gen 3 is highly portable and convenient to carry around, whether you''re at home, in the office, or on the move. Its durable construction and ergonomic design make it comfortable to hold for extended periods, while the slim bezels maximize the screen-to-body ratio for an immersive viewing experience.

Equipped with dual speakers tuned by Dolby Atmos®, the Tab M10 Plus Gen 3 delivers immersive audio experiences with rich, room-filling sound. Whether you''re watching movies, listening to music, or video chatting with friends and family, you''ll enjoy clear and powerful audio that enhances your multimedia experience.

The Tab M10 Plus Gen 3 offers versatile connectivity options, including Wi-Fi and optional LTE support, allowing you to stay connected wherever you go. Additionally, it features a range of ports, including USB-C and audio jacks, for connecting peripherals and accessories, ensuring compatibility with a wide range of devices.'
WHERE name LIKE 'Lenovo - Tab M10 Plus Gen 3%';



UPDATE products
SET description = 'The Lenovo Tab P11 Gen 2 is a versatile and powerful tablet designed to enhance your digital experience. With its stunning 11-inch display, this tablet delivers crisp visuals and vibrant colors, making it perfect for entertainment, productivity, and everything in between. Powered by a high-performance processor and ample RAM, the Tab P11 Gen 2 offers smooth multitasking and responsive performance, allowing you to breeze through your daily tasks with ease.

Featuring a sleek and stylish design, the Tab P11 Gen 2 is both lightweight and portable, making it easy to take with you wherever you go. Whether you''re watching movies, browsing the web, or getting work done on the go, this tablet is up to the task. Plus, with support for optional accessories like a keyboard and stylus, you can customize your Tab P11 Gen 2 to suit your needs.

Equipped with dual speakers tuned by Dolby Atmos, the Tab P11 Gen 2 delivers immersive audio that brings your favorite content to life. Whether you''re listening to music, watching movies, or video chatting with friends and family, you''ll enjoy rich, detailed sound that fills the room.

With features like facial recognition and a secure fingerprint sensor, the Tab P11 Gen 2 offers peace of mind knowing that your personal information is protected. Plus, with long battery life and fast charging capabilities, you can stay connected and productive throughout the day without having to worry about running out of power.'
WHERE name LIKE 'Lenovo - Tab P11 Gen 2%';



UPDATE products
SET description = 'The Lenovo Tab P12 is a premium tablet designed to deliver exceptional performance and versatility for both work and play. Boasting a stunning 12.6-inch OLED display with vivid colors and crisp details, this tablet provides an immersive viewing experience that''s perfect for streaming movies, browsing the web, or getting work done on the go.

Powered by a high-performance processor and ample RAM, the Tab P12 offers smooth multitasking and responsive performance, allowing you to seamlessly switch between apps and tasks without any lag or slowdown. Whether you''re editing documents, playing games, or running demanding applications, this tablet can handle it all with ease.

With its sleek and stylish design, the Tab P12 is both lightweight and portable, making it easy to take with you wherever you go. Whether you''re commuting to work, traveling on vacation, or simply relaxing at home, this tablet is the perfect companion for staying connected and entertained on the move.

Equipped with quad speakers tuned by Dolby Atmos, the Tab P12 delivers immersive audio that brings your favorite content to life. Whether you''re listening to music, watching movies, or video chatting with friends and family, you''ll enjoy rich, detailed sound that fills the room.

The Tab P12 also features a range of advanced features to enhance your productivity and convenience, including optional accessories like a keyboard and stylus for added versatility. Plus, with long battery life and fast charging capabilities, you can stay connected and productive throughout the day without having to worry about running out of power.'
WHERE name LIKE 'Lenovo - Tab P12%';



UPDATE products
SET description = 'The Samsung Galaxy Tab S9 is a premium Android tablet designed to deliver exceptional performance and productivity. Boasting a stunning 12.4-inch Super AMOLED display with a crisp resolution, the Tab S9 offers immersive visuals and vibrant colors, perfect for watching movies, playing games, or getting work done on the go.

Equipped with a powerful octa-core processor and ample RAM, the Galaxy Tab S9 ensures smooth multitasking and responsiveness, allowing you to seamlessly switch between apps and tasks without any lag. Whether you''re editing documents, browsing the web, or streaming content, you can expect fast and efficient performance.

With its sleek and lightweight design, the Tab S9 is easy to carry around and comfortable to use for extended periods. The slim bezels surrounding the display maximize screen real estate, giving you more room to work and play. Plus, the tablet features a premium build quality and a range of color options to suit your style.

The Galaxy Tab S9 also offers advanced connectivity options, including Wi-Fi and optional 5G support, so you can stay connected wherever you go. Additionally, it comes with a variety of productivity features, such as Samsung DeX support, allowing you to transform your tablet into a desktop-like experience for enhanced productivity.

With long battery life and fast charging capabilities, the Galaxy Tab S9 keeps up with your busy lifestyle, allowing you to stay productive and entertained throughout the day without having to worry about running out of power. Whether you''re a student, professional, or multimedia enthusiast, the Samsung Galaxy Tab S9 is the perfect companion for work and play.'
WHERE name LIKE 'Samsung - Galaxy Tab S9%';




UPDATE products
SET description = 'The Samsung Galaxy Tab S9+ is a top-of-the-line tablet that combines cutting-edge technology with sleek design to deliver an exceptional user experience. With its large 12.4-inch Super AMOLED display, this tablet offers stunning visuals with vibrant colors, deep blacks, and sharp details, making it perfect for watching movies, playing games, or browsing the web.

Powered by a high-performance processor and ample RAM, the Galaxy Tab S9+ delivers smooth and responsive performance, allowing you to multitask with ease and run demanding applications without any lag or slowdown. Whether you''re editing documents, streaming videos, or gaming, this tablet can handle it all with ease.

In addition to its powerful performance, the Galaxy Tab S9+ also offers a range of advanced features to enhance your productivity and entertainment experience. With support for the S Pen stylus (sold separately), you can take notes, draw, and navigate the interface with precision and ease. Plus, with Samsung DeX support, you can transform your tablet into a desktop-like experience, allowing you to multitask with multiple windows and applications.

The Galaxy Tab S9+ also features a long-lasting battery that provides all-day power, so you can stay productive and entertained without having to constantly worry about recharging. And with fast charging capabilities, you can quickly top up the battery when you''re running low on power.'
WHERE name LIKE 'Samsung - Galaxy Tab S9+%';





UPDATE products
SET description = 'The Samsung Galaxy Tab A9 is a versatile and affordable tablet designed to meet your everyday needs. With its sleek and compact design, it''s easy to take with you wherever you go, whether you''re commuting, traveling, or simply relaxing at home.

Featuring a vibrant 10.1-inch display, the Galaxy Tab A9 offers crisp and clear visuals, making it perfect for watching movies, browsing the web, or playing games. With its immersive sound quality, you can enjoy an enhanced audio experience that brings your favorite content to life.

Powered by a quad-core processor and ample RAM, the Galaxy Tab A9 delivers smooth and responsive performance, allowing you to multitask with ease and run your favorite apps without any lag or slowdown. Plus, with expandable storage options, you can easily store all your photos, videos, and files without worrying about running out of space.

The Galaxy Tab A9 also features a long-lasting battery that provides up to 13 hours of video playback on a single charge, so you can stay entertained all day long without having to constantly recharge. And with its family-friendly features, including parental controls and Kids Mode, you can rest assured knowing that your tablet is safe and secure for users of all ages.

Whether you''re looking for a tablet for entertainment, productivity, or education, the Samsung Galaxy Tab A9 has you covered. With its affordable price tag and versatile features, it''s the perfect companion for your everyday life.'
WHERE name LIKE 'Samsung - Galaxy Tab A9%';




UPDATE products
SET description = 'The Samsung Galaxy Tab S9 Ultra is a powerhouse Android tablet that redefines the boundaries of mobile productivity and entertainment. Featuring a massive 14.6-inch Super AMOLED display with stunning 4K resolution, this tablet delivers an immersive viewing experience with crystal-clear visuals and vibrant colors.

Powered by a cutting-edge octa-core processor and generous RAM, the Galaxy Tab S9 Ultra offers blazing-fast performance and seamless multitasking capabilities. Whether you''re editing high-resolution photos and videos, playing graphics-intensive games, or running multiple apps simultaneously, this tablet handles it all with ease.

The sleek and stylish design of the Galaxy Tab S9 Ultra makes it a standout device in any setting. With its slim bezels and premium build quality, the tablet exudes sophistication while providing a comfortable grip for extended use. Plus, the tablet is available in a range of sleek colors to suit your personal style.

Equipped with advanced connectivity options such as Wi-Fi 6E and optional 5G support, the Galaxy Tab S9 Ultra ensures lightning-fast internet speeds and seamless connectivity wherever you go. Whether you''re streaming high-definition content, video conferencing, or downloading large files, you can count on reliable performance and connectivity.

The Galaxy Tab S9 Ultra also boasts a range of productivity features to help you get more done on the go. With support for Samsung DeX, you can transform your tablet into a desktop-like experience, complete with multi-window support and mouse and keyboard compatibility. Additionally, the tablet comes with an S Pen stylus for precise input and creative expression.

Thanks to its long-lasting battery life and fast charging capabilities, the Galaxy Tab S9 Ultra keeps up with your busy lifestyle. Whether you''re working, studying, or enjoying multimedia content, you can stay productive and entertained without having to worry about running out of power.

Overall, the Samsung Galaxy Tab S9 Ultra sets a new standard for premium Android tablets, offering an unrivaled combination of performance, versatility, and style. Whether you''re a professional, student, or multimedia enthusiast, this tablet is sure to elevate your mobile computing experience to new heights.'
WHERE name LIKE 'Samsung - Galaxy Tab S9 Ultra%';





UPDATE products
SET description = 'The Apple iPhone 15 represents the epitome of innovation and sophistication in the realm of smartphones. With its sleek design, cutting-edge features, and powerful performance, it sets a new standard for what a mobile device can achieve.

At the heart of the iPhone 15 is Apple''s most advanced chip to date, delivering lightning-fast performance and unparalleled efficiency. Whether you''re multitasking, gaming, or streaming content, the iPhone 15 effortlessly handles every task with ease, ensuring a smooth and responsive user experience.

The iPhone 15''s stunning display immerses you in your favorite content like never before. With vibrant colors, deep blacks, and true-to-life contrast, every image and video comes to life with breathtaking clarity and detail. Whether you''re browsing the web, watching movies, or editing photos, the iPhone 15''s display delivers an unmatched viewing experience.

Photography enthusiasts will appreciate the iPhone 15''s advanced camera system, which takes smartphone photography to new heights. With its cutting-edge sensors, powerful image processing algorithms, and innovative features like Night mode and Deep Fusion, the iPhone 15 captures stunning photos and videos in any lighting condition.

Security is a top priority with the iPhone 15, thanks to features like Face ID facial recognition and encrypted data storage. Your personal information remains secure and protected, giving you peace of mind knowing that your privacy is safeguarded at all times.

The iPhone 15 also introduces a range of innovative features designed to enhance your daily life. From wireless charging and fast charging capabilities to water and dust resistance, the iPhone 15 is built to withstand the rigors of everyday use while keeping you connected and productive.

With support for lightning-fast 5G connectivity, the iPhone 15 ensures that you stay connected wherever you go. Whether you''re streaming high-definition content, downloading large files, or video chatting with friends and family, you can count on the iPhone 15 to deliver reliable performance and blazing-fast speeds.'
WHERE name LIKE 'Apple - iPhone 15%';






UPDATE products
SET description = 'The Apple iPhone 15 Pro represents the pinnacle of mobile technology, blending cutting-edge innovation with timeless design. Boasting a stunning 6.7-inch Super Retina XDR display, this flagship smartphone delivers an immersive viewing experience with true-to-life colors, deep blacks, and HDR support for stunning contrast.

At the heart of the iPhone 15 Pro lies Apple''s most powerful chip yet, offering unparalleled performance and efficiency for everything from gaming to multitasking. With advanced machine learning capabilities and enhanced neural processing, the iPhone 15 Pro delivers blazing-fast performance while maximizing battery life.

The iPhone 15 Pro''s camera system is a marvel of engineering, featuring a triple-lens setup that takes smartphone photography to new heights. With a combination of wide, ultra-wide, and telephoto lenses, along with advanced computational photography features, the iPhone 15 Pro captures breathtaking photos and videos in any environment.

The device''s ProMotion technology ensures silky-smooth scrolling and responsiveness, while True Tone technology automatically adjusts the display''s color temperature to match the surrounding ambient light, providing a more comfortable viewing experience.

Security and privacy are paramount with the iPhone 15 Pro, thanks to features like Face ID facial recognition and encrypted communication protocols. Your personal data is protected at every level, giving you peace of mind knowing that your information is secure.

The iPhone 15 Pro also introduces new features and improvements to enhance the overall user experience. From faster wireless charging to improved water and dust resistance, every aspect of the device is meticulously crafted to delight users and exceed expectations.

With support for 5G connectivity, the iPhone 15 Pro ensures lightning-fast download and streaming speeds, enabling seamless access to content and services wherever you go. Whether you''re streaming high-definition video, playing online games, or video chatting with friends and family, the iPhone 15 Pro delivers a next-level mobile experience.

In summary, the Apple iPhone 15 Pro is a masterpiece of technology and design, offering unrivaled performance, photography capabilities, and user experience. With its innovative features and iconic design, the iPhone 15 Pro sets a new standard for what a smartphone can be.'
WHERE name LIKE 'Apple - iPhone 15 Pro%';





UPDATE products
SET description = 'The Apple iPhone 15 Pro Max epitomizes the pinnacle of mobile excellence, seamlessly blending cutting-edge technology with exquisite craftsmanship. With its expansive 6.9-inch Super Retina XDR display, this flagship smartphone offers an immersive visual experience that sets a new standard for mobile viewing.

Powering the iPhone 15 Pro Max is Apple''s most advanced chip to date, delivering unparalleled performance and efficiency. With its neural engine and machine learning capabilities, the device effortlessly handles intensive tasks while maximizing battery life, ensuring smooth and responsive operation throughout the day.

Photography enthusiasts will appreciate the iPhone 15 Pro Max''s sophisticated camera system, featuring a triple-lens setup that captures stunning photos and videos with remarkable detail and clarity. Whether shooting in low light or capturing expansive landscapes, the device delivers professional-quality results every time.

The ProMotion technology enhances the fluidity of on-screen content, providing a smooth and responsive user experience that is second to none. True Tone technology adjusts the display''s color temperature based on ambient lighting conditions, ensuring accurate color reproduction in any environment.

Security is a top priority with the iPhone 15 Pro Max, thanks to features like Face ID facial recognition and robust encryption protocols. With advanced privacy features built into every aspect of the device, users can trust that their personal information remains secure at all times.

In addition to its technological prowess, the iPhone 15 Pro Max boasts a range of innovative features designed to enhance the user experience. From seamless wireless charging to industry-leading water and dust resistance, every aspect of the device is engineered for convenience and reliability.

With support for lightning-fast 5G connectivity, the iPhone 15 Pro Max enables users to stay connected and productive wherever they go. Whether streaming high-definition content, downloading large files, or engaging in video calls, the device delivers unmatched speed and reliability.'
WHERE name LIKE 'Apple - iPhone 15 Pro Max%';







UPDATE products
SET description = 'The Apple iPhone 15 Plus is a testament to Apple''s commitment to innovation and excellence in the realm of smartphones. Building upon the success of its predecessors, the iPhone 15 Plus introduces a host of groundbreaking features and enhancements that redefine what a mobile device can achieve.

At the heart of the iPhone 15 Plus is Apple''s most advanced chip yet, delivering unparalleled performance, efficiency, and intelligence. Whether you''re multitasking, gaming, or streaming content, the iPhone 15 Plus effortlessly handles every task with lightning-fast speed and responsiveness, ensuring a seamless and enjoyable user experience.

One of the standout features of the iPhone 15 Plus is its stunning Super Retina XDR display. With vibrant colors, deep blacks, and true-to-life contrast, the display immerses you in your favorite content, whether you''re browsing the web, watching movies, or playing games. The larger screen size of the iPhone 15 Plus provides an even more immersive viewing experience, making it ideal for multimedia consumption and productivity tasks.

Photography enthusiasts will appreciate the iPhone 15 Plus''s advanced camera system, which pushes the boundaries of smartphone photography. Equipped with state-of-the-art sensors, powerful image processing algorithms, and innovative features like Night mode, Deep Fusion, and ProRAW, the iPhone 15 Plus captures stunning photos and videos with exceptional detail, clarity, and dynamic range.

Security is a top priority with the iPhone 15 Plus, thanks to features like Face ID facial recognition and advanced encryption technologies. Your personal information remains secure and protected, giving you peace of mind knowing that your privacy is safeguarded at all times.

The iPhone 15 Plus also introduces a range of innovative features designed to enhance your daily life. From wireless charging and fast charging capabilities to water and dust resistance, the iPhone 15 Plus is built to withstand the rigors of everyday use while keeping you connected and productive.

With support for lightning-fast 5G connectivity, the iPhone 15 Plus ensures that you stay connected wherever you go. Whether you''re streaming high-definition content, downloading large files, or video chatting with friends and family, you can count on the iPhone 15 Plus to deliver reliable performance and blazing-fast speeds.'
WHERE name LIKE 'Apple - iPhone 15 Plus%';






UPDATE products
SET description = 'The Apple iPhone SE (3rd generation) represents a perfect blend of power, performance, and affordability, making it an enticing option for those seeking a high-quality smartphone experience without breaking the bank.

At the core of the iPhone SE (3rd generation) lies Apple''s formidable A15 Bionic chip, the same powerful processor found in the flagship iPhone models. This chip ensures smooth and responsive performance across a wide range of tasks, from everyday browsing and messaging to graphics-intensive gaming and productivity apps. With the A15 Bionic chip, the iPhone SE (3rd generation) delivers impressive performance and efficiency, allowing users to enjoy a seamless user experience without compromise.

The iPhone SE (3rd generation) features a compact yet vibrant Retina HD display, providing crisp visuals and accurate colors for an immersive viewing experience. Whether you''re watching videos, browsing photos, or reading text, the display offers excellent clarity and detail, making it easy to enjoy your favorite content on the go.

Photography enthusiasts will appreciate the iPhone SE (3rd generation)''s advanced camera system, which includes a 12-megapixel rear camera capable of capturing stunning photos and videos. With features like Smart HDR 4, Night mode, and Portrait mode, users can capture beautiful images with impressive detail and depth, even in challenging lighting conditions.

The iPhone SE (3rd generation) also boasts a range of other features designed to enhance the overall user experience. These include Touch ID for secure authentication, support for 5G connectivity for faster download speeds and smoother streaming, and a durable design that is water and dust resistant.

With its compact size, powerful performance, and affordable price point, the Apple iPhone SE (3rd generation) is an excellent choice for users who prioritize value and functionality in a smartphone. Whether you''re a student, a professional, or simply looking for a reliable mobile device, the iPhone SE (3rd generation) offers everything you need to stay connected, productive, and entertained.'
WHERE name LIKE 'Apple - iPhone SE (3rd generation)%';





UPDATE products
SET description = 'The Apple iPhone 14 represents the latest evolution in smartphone technology, combining sleek design, powerful performance, and innovative features to deliver an exceptional user experience.

At the heart of the iPhone 14 is the formidable A16 Bionic chip, engineered to deliver lightning-fast speeds, seamless multitasking, and energy efficiency. Whether you''re streaming high-definition content, playing graphics-intensive games, or tackling productivity tasks, the A16 chip ensures smooth performance and responsiveness.

The iPhone 14 boasts a stunning Super Retina XDR display, offering vivid colors, deep blacks, and high brightness levels for an immersive viewing experience. With its edge-to-edge design and ProMotion technology, the display delivers fluid animations and responsive touch interactions, making every interaction feel natural and engaging.

Photography enthusiasts will appreciate the advanced camera system of the iPhone 14, which includes upgraded sensors and optics for capturing stunning photos and videos. Whether you''re shooting in low light, capturing fast-moving subjects, or experimenting with creative effects, the iPhone 14''s camera delivers impressive results with ease.

In addition to its performance and camera capabilities, the iPhone 14 offers a range of features designed to enhance everyday usability and convenience. These include 5G connectivity for faster download speeds and reduced latency, MagSafe technology for easy wireless charging and accessory compatibility, and enhanced durability with Ceramic Shield front cover and IP68 water and dust resistance rating.

With its sleek design, powerful performance, and innovative features, the Apple iPhone 14 is the perfect companion for staying connected, productive, and entertained on the go. Whether you''re a professional user or a casual consumer, the iPhone 14 delivers a premium mobile experience that exceeds expectations.'
WHERE name LIKE 'Apple - iPhone 14%';






UPDATE products
SET description = 'The Apple iPhone 14 Pro redefines premium smartphone experience with its cutting-edge technology, stunning design, and exceptional performance, making it a standout choice for tech enthusiasts and professionals alike.

At the heart of the iPhone 14 Pro lies Apple''s next-generation A16 Bionic chip, engineered to deliver unparalleled speed, efficiency, and intelligence. This powerful processor ensures seamless multitasking, smooth gaming, and swift app launches, while also optimizing battery life for all-day usage. With the A16 Bionic chip, the iPhone 14 Pro sets new standards for performance and power efficiency in the smartphone industry.

The iPhone 14 Pro features a breathtaking Super Retina XDR display, offering vibrant colors, deep blacks, and incredible contrast for an immersive viewing experience. With ProMotion technology, the display automatically adjusts its refresh rate up to 120Hz, ensuring fluid scrolling, responsive touch input, and smooth animations. Whether you''re watching videos, browsing photos, or playing games, the iPhone 14 Pro''s display delivers stunning visual quality with exceptional clarity and detail.

Photography enthusiasts will appreciate the iPhone 14 Pro''s advanced camera system, which includes a triple-lens setup with upgraded sensors and optics. The 12-megapixel Ultra Wide, Wide, and Telephoto lenses work together seamlessly to capture stunning photos and videos in any lighting condition. With features like Night mode, Deep Fusion, and Smart HDR 5, users can capture lifelike images with outstanding detail, dynamic range, and color accuracy.

In addition to its impressive performance and camera capabilities, the iPhone 14 Pro offers a range of other innovative features designed to enhance the overall user experience. These include support for 5G connectivity for faster download speeds and lower latency, MagSafe technology for easy wireless charging and accessories compatibility, and enhanced durability with Ceramic Shield front cover and IP68 water and dust resistance rating.

With its sleek design, powerhouse performance, and advanced features, the Apple iPhone 14 Pro is the ultimate expression of innovation and craftsmanship in the smartphone market. Whether you''re a photographer, a creative professional, or simply an enthusiast looking for the best, the iPhone 14 Pro delivers a premium smartphone experience that exceeds expectations.'
WHERE name LIKE 'Apple - iPhone 14 Pro%';





UPDATE products
SET description = 'The Apple iPhone 14 Pro Max represents the pinnacle of smartphone technology, boasting an array of advanced features, unparalleled performance, and stunning design that elevate the mobile experience to new heights.

At the core of the iPhone 14 Pro Max is the groundbreaking A16 Bionic chip, Apple''s most powerful and efficient processor to date. With its cutting-edge architecture and neural engine, the A16 chip delivers blazing-fast speeds, seamless multitasking, and AI-powered performance enhancements. Whether you''re gaming, streaming, or tackling demanding tasks, the iPhone 14 Pro Max effortlessly handles everything with unmatched efficiency.

One of the standout features of the iPhone 14 Pro Max is its expansive Super Retina XDR display, offering an immersive viewing experience like never before. With its edge-to-edge design and ProMotion technology, the display delivers stunning visuals with vibrant colors, deep blacks, and HDR support for true-to-life imagery. Whether you''re watching movies, browsing photos, or playing games, every moment comes to life with unparalleled clarity and detail.

Photography enthusiasts will appreciate the iPhone 14 Pro Max''s state-of-the-art camera system, which combines advanced hardware and intelligent software to capture breathtaking photos and videos. The triple-lens setup features upgraded sensors and optics, including a 12-megapixel Ultra Wide, Wide, and Telephoto lens, enabling you to capture stunning images with incredible detail, dynamic range, and low-light performance. With features like Night mode, Deep Fusion, and Smart HDR 5, every shot is a masterpiece.

In addition to its exceptional performance and camera capabilities, the iPhone 14 Pro Max offers a host of other innovative features designed to enhance the overall user experience. These include 5G connectivity for lightning-fast download speeds and lower latency, MagSafe technology for effortless wireless charging and accessory compatibility, and enhanced durability with Ceramic Shield front cover and IP68 water and dust resistance rating.

With its sleek design, powerhouse performance, and cutting-edge features, the Apple iPhone 14 Pro Max sets a new standard for premium smartphones. Whether you''re a professional photographer, a creative enthusiast, or simply someone who demands the best, the iPhone 14 Pro Max delivers an unrivaled mobile experience that pushes the boundaries of innovation.'
WHERE name LIKE 'Apple - iPhone 14 Pro Max%';







UPDATE products
SET description = 'The Apple iPhone 14 Plus epitomizes the pinnacle of smartphone innovation, blending cutting-edge technology with elegant design to redefine the mobile experience.

Central to the iPhone 14 Plus is the formidable A16 Bionic chip, meticulously crafted to deliver unparalleled performance, seamless multitasking, and exceptional energy efficiency. Whether you''re engaging in demanding tasks, streaming high-definition content, or immersing yourself in graphically-rich games, the A16 chip ensures smooth, responsive performance that exceeds expectations.

The iPhone 14 Plus showcases a stunning Super Retina XDR display, boasting vibrant colors, deep blacks, and remarkable brightness levels for an immersive visual experience. With its edge-to-edge design and ProMotion technology, the display offers fluid animations and precise touch responsiveness, elevating every interaction to new heights of fluidity and engagement.

Photography enthusiasts will revel in the advanced camera system of the iPhone 14 Plus, featuring upgraded sensors and optics that empower users to capture breathtaking photos and videos with ease. From low-light environments to fast-paced action scenes, the iPhone 14 Plus delivers stunning results that rival professional-grade cameras, allowing users to unleash their creativity without compromise.

In addition to its powerhouse performance and cutting-edge camera capabilities, the iPhone 14 Plus integrates a range of features designed to enhance daily convenience and productivity. These include lightning-fast 5G connectivity for seamless streaming and browsing, MagSafe technology for effortless wireless charging and accessory compatibility, and enhanced durability with its Ceramic Shield front cover and IP68 water and dust resistance rating.

With its sleek design, powerhouse performance, and innovative features, the Apple iPhone 14 Plus stands as a testament to Apple''s unwavering commitment to excellence. Whether you''re a discerning professional or a tech-savvy consumer, the iPhone 14 Plus redefines what''s possible in the realm of mobile technology, offering a premium experience that surpasses expectations.'
WHERE name LIKE 'Apple - iPhone 14 Plus%';





UPDATE products
SET description = 'The Apple iPhone 13 represents the epitome of sleek design, cutting-edge technology, and seamless functionality, offering users an unparalleled mobile experience.

At its core, the iPhone 13 is powered by the lightning-fast A15 Bionic chip, delivering unrivaled performance, energy efficiency, and advanced computational capabilities. Whether you''re navigating intensive apps, streaming high-definition content, or capturing stunning photos and videos, the A15 chip ensures smooth, responsive performance that exceeds expectations.

One of the standout features of the iPhone 13 is its vibrant Super Retina XDR display, which immerses users in stunning visuals with true-to-life colors, deep blacks, and remarkable brightness levels. With True Tone technology and HDR support, the display elevates every photo, video, and gaming experience to new heights of clarity and detail.

Photography enthusiasts will appreciate the advanced dual-camera system of the iPhone 13, featuring improved sensors and optics for capturing breathtaking images in any setting. From vibrant landscapes to striking portraits, the iPhone 13 empowers users to unleash their creativity and capture memories with exceptional clarity and precision.

In addition to its powerful performance and impressive camera capabilities, the iPhone 13 offers a range of innovative features designed to enhance daily convenience and productivity. These include lightning-fast 5G connectivity for seamless streaming and browsing, MagSafe technology for easy wireless charging and accessory compatibility, and enhanced durability with its Ceramic Shield front cover and IP68 water and dust resistance rating.'
WHERE name LIKE 'Apple - iPhone 13%';






UPDATE products
SET description = 'The Apple iPhone 13 Pro represents the epitome of mobile technology, seamlessly blending cutting-edge innovation with iconic design to deliver an unparalleled user experience.

At the heart of the iPhone 13 Pro lies the powerful A15 Bionic chip, meticulously engineered to deliver lightning-fast performance, energy efficiency, and groundbreaking computational capabilities. Whether you''re navigating demanding apps, multitasking with ease, or immersing yourself in graphically-intensive games, the A15 chip ensures smooth, responsive performance that exceeds expectations.

The iPhone 13 Pro boasts a stunning Super Retina XDR display, featuring ProMotion technology for fluid scrolling and incredibly smooth visuals. With its True Tone technology and HDR support, the display delivers true-to-life colors, deep blacks, and remarkable brightness levels, elevating every photo, video, and gaming experience to new heights of immersion and clarity.

Photography enthusiasts will appreciate the advanced camera system of the iPhone 13 Pro, featuring a triple-camera setup with improved sensors and optics. From capturing detailed landscapes to stunning portraits with depth-of-field effects, the iPhone 13 Pro empowers users to unleash their creativity and capture memories with exceptional clarity and precision.

In addition to its powerhouse performance and cutting-edge camera capabilities, the iPhone 13 Pro integrates a range of features designed to enhance daily convenience and productivity. These include lightning-fast 5G connectivity for seamless streaming and browsing, MagSafe technology for effortless wireless charging and accessory compatibility, and enhanced durability with its Ceramic Shield front cover and IP68 water and dust resistance rating.'
WHERE name LIKE 'Apple - iPhone 13 Pro%';






UPDATE products
SET description = 'The Apple iPhone 13 Pro Max epitomizes the pinnacle of mobile technology, seamlessly blending cutting-edge innovation with iconic design to deliver an unparalleled user experience.

At its core, the iPhone 13 Pro Max harnesses the remarkable power of the A15 Bionic chip, meticulously engineered to deliver lightning-fast performance, energy efficiency, and groundbreaking computational capabilities. Whether you''re navigating demanding apps, multitasking effortlessly, or immersing yourself in graphically-intensive games, the A15 chip ensures smooth, responsive performance that exceeds expectations.

One of the standout features of the iPhone 13 Pro Max is its expansive Super Retina XDR display, boasting ProMotion technology for fluid scrolling and incredibly smooth visuals. With True Tone technology and HDR support, the display delivers true-to-life colors, deep blacks, and remarkable brightness levels, elevating every photo, video, and gaming experience to new heights of immersion and clarity.

Photography enthusiasts will marvel at the advanced camera system of the iPhone 13 Pro Max, featuring a sophisticated triple-camera setup with improved sensors and optics. From capturing breathtaking landscapes to stunning portraits with depth-of-field effects, the iPhone 13 Pro Max empowers users to unleash their creativity and capture memories with exceptional clarity and precision.

In addition to its powerhouse performance and cutting-edge camera capabilities, the iPhone 13 Pro Max integrates a range of features designed to enhance daily convenience and productivity. These include lightning-fast 5G connectivity for seamless streaming and browsing, MagSafe technology for effortless wireless charging and accessory compatibility, and enhanced durability with its Ceramic Shield front cover and IP68 water and dust resistance rating.'
WHERE name LIKE 'Apple - iPhone 13 Pro Max%';









UPDATE products
SET description = 'The Apple iPhone 13 Mini packs immense power and capability into a compact design, making it the perfect companion for those who prioritize portability without compromising on performance.

Driven by the cutting-edge A15 Bionic chip, the iPhone 13 Mini delivers blazing-fast speeds, seamless multitasking, and exceptional energy efficiency. Whether you''re gaming, streaming, or tackling productivity tasks, the A15 chip ensures smooth performance and responsiveness, even in the most demanding situations.

Despite its diminutive size, the iPhone 13 Mini boasts a stunning Super Retina XDR display that brings content to life with vibrant colors, deep blacks, and impressive brightness levels. Whether you''re enjoying your favorite movies, browsing the web, or scrolling through social media, the compact yet immersive display ensures an enjoyable viewing experience every time.

Photography enthusiasts will appreciate the advanced camera system of the iPhone 13 Mini, which includes dual lenses capable of capturing stunning photos and videos with remarkable detail and clarity. From scenic landscapes to candid portraits, the iPhone 13 Mini empowers users to unleash their creativity and capture memories with professional-quality results.

In addition to its powerful performance and impressive camera capabilities, the iPhone 13 Mini offers a range of innovative features designed to enhance daily convenience and productivity. These include lightning-fast 5G connectivity for seamless streaming and browsing, MagSafe technology for easy wireless charging and accessory compatibility, and enhanced durability with its Ceramic Shield front cover and IP68 water and dust resistance rating.'
WHERE name LIKE 'Apple - iPhone 13 Mini%';





UPDATE products
SET description = 'The Samsung Galaxy A55 is a mid-range smartphone that offers an exceptional combination of performance, features, and affordability, making it an ideal choice for budget-conscious consumers seeking a premium mobile experience.

Powered by a robust octa-core processor and ample RAM, the Galaxy A55 delivers smooth and responsive performance, allowing you to seamlessly navigate through apps, multitask with ease, and enjoy lag-free gaming and multimedia experiences.

The device features a vibrant and immersive Super AMOLED display, which boasts rich colors, deep contrasts, and sharp details, making it perfect for watching videos, browsing photos, and playing games. With its expansive screen real estate, the Galaxy A55 provides a truly immersive viewing experience that brings content to life.

Photography enthusiasts will appreciate the versatile camera system of the Galaxy A55, which includes multiple lenses to cater to a variety of shooting scenarios. Whether you''re capturing stunning landscapes, striking portraits, or detailed close-ups, the Galaxy A55''s camera setup allows you to unleash your creativity and capture memorable moments with ease.

In addition to its impressive performance and camera capabilities, the Galaxy A55 offers a range of convenient features and functionalities to enhance your everyday mobile experience. These include a long-lasting battery that keeps you connected throughout the day, fast charging support for quick top-ups on the go, and a secure and intuitive user interface that ensures effortless navigation and operation.'
WHERE name LIKE 'Samsung - Galaxy A55%';






UPDATE products
SET description = 'The Samsung Galaxy Z Flip 5 is a cutting-edge smartphone that redefines the concept of mobile innovation with its revolutionary foldable design and advanced features.

At the heart of the Galaxy Z Flip 5 is its innovative foldable display, which allows the device to seamlessly transition between a compact clamshell form factor and a full-sized smartphone. This flexible display not only offers a unique and futuristic user experience but also enhances portability by allowing the device to easily fit into pockets and bags.

The Galaxy Z Flip 5 boasts a stunning Dynamic AMOLED display with vibrant colors, deep contrasts, and crisp details, providing an immersive viewing experience for multimedia content, gaming, and productivity tasks. Whether you''re watching videos, browsing the web, or multitasking with multiple apps, the Galaxy Z Flip 5''s display delivers exceptional visual quality and clarity.

In addition to its innovative design, the Galaxy Z Flip 5 is equipped with powerful hardware and features to meet the demands of modern smartphone users. With its fast and efficient processor, generous RAM, and ample storage space, the Galaxy Z Flip 5 offers smooth performance for everyday tasks, including web browsing, social media, and gaming.

Photography enthusiasts will appreciate the Galaxy Z Flip 5''s versatile camera system, which includes multiple lenses for capturing stunning photos and videos in various lighting conditions. Whether you''re shooting landscapes, portraits, or close-ups, the Galaxy Z Flip 5''s camera setup delivers impressive results with rich colors, sharp details, and balanced exposures.

The Galaxy Z Flip 5 also offers a range of innovative features and functionalities to enhance your mobile experience, including 5G connectivity for ultra-fast download and streaming speeds, wireless charging support for convenient power-ups, and a suite of advanced security features to keep your data safe and secure.'
WHERE name LIKE 'Samsung - Galaxy Z FLIP 5%';






UPDATE products
SET description = 'The Samsung Galaxy Z Fold 5 represents the pinnacle of mobile innovation, seamlessly merging the functionality of a smartphone and a tablet into a single, foldable device. With its revolutionary design, advanced features, and cutting-edge technology, the Galaxy Z Fold 5 redefines the way we interact with our digital world.

At the heart of the Galaxy Z Fold 5 is its innovative foldable display, which effortlessly transforms the device from a compact smartphone into a spacious tablet experience. Whether you''re checking emails, watching videos, or multitasking with multiple apps, the Galaxy Z Fold 5''s flexible display provides a seamless and immersive user experience.

The Galaxy Z Fold 5 boasts a stunning Infinity Flex display, offering vibrant colors, sharp details, and smooth transitions. With its expansive screen real estate, the Galaxy Z Fold 5 is perfect for productivity tasks, creative endeavors, and entertainment activities, allowing you to do more with your device than ever before.

Powered by a high-performance processor and ample RAM, the Galaxy Z Fold 5 delivers smooth and responsive performance for even the most demanding tasks. Whether you''re gaming, streaming content, or running multiple apps simultaneously, the Galaxy Z Fold 5 ensures a lag-free experience, so you can stay productive and entertained wherever you go.

In addition to its innovative design and powerful performance, the Galaxy Z Fold 5 features a versatile camera system that lets you capture stunning photos and videos in any environment. With multiple lenses, including ultra-wide and telephoto options, the Galaxy Z Fold 5 empowers you to unleash your creativity and capture memories with incredible detail and clarity.

The Galaxy Z Fold 5 also offers a range of advanced features and functionalities to enhance your mobile experience, including 5G connectivity for blazing-fast download speeds, S Pen support for precise input and creativity, and a long-lasting battery that keeps you connected throughout the day.

With its groundbreaking design, advanced features, and unparalleled versatility, the Samsung Galaxy Z Fold 5 is not just a smartphone – it''s a game-changer. Whether you''re a multitasking professional, a creative enthusiast, or a tech-savvy trendsetter, the Galaxy Z Fold 5 redefines what''s possible with mobile technology, allowing you to work smarter, play harder, and stay connected like never before.'
WHERE name LIKE 'Samsung - Galaxy Z FOLD 5%';




UPDATE products
SET description = 'The Samsung Galaxy S24 is a flagship smartphone that embodies the pinnacle of innovation, functionality, and style. Crafted to exceed the expectations of discerning users, this device represents the culmination of Samsung''s relentless pursuit of excellence in mobile technology.

At the core of the Galaxy S24 lies its breathtaking display, which sets a new standard for visual immersion and clarity. Featuring a vibrant Super AMOLED panel with high resolution and a high refresh rate, the Galaxy S24 delivers stunningly vivid colors, sharp details, and fluid motion. Whether you''re streaming videos, browsing the web, or gaming, the display offers an unparalleled viewing experience that captivates the senses.

Underneath its sleek exterior, the Galaxy S24 is powered by cutting-edge hardware that ensures smooth performance and responsiveness in every task. Equipped with a powerful processor, ample RAM, and advanced graphics capabilities, this smartphone effortlessly handles multitasking, gaming, and productivity with ease. From streaming high-definition content to running demanding applications, the Galaxy S24 delivers uncompromising performance that keeps up with your busy lifestyle.

Photography enthusiasts will appreciate the Galaxy S24''s versatile camera system, which empowers you to capture stunning images and videos in any scenario. With multiple lenses, including ultra-wide, wide-angle, and telephoto options, as well as advanced AI-driven features, the Galaxy S24 lets you unleash your creativity and capture moments with incredible clarity, detail, and depth.

In addition to its exceptional performance and imaging capabilities, the Galaxy S24 offers a host of intelligent features and functionalities designed to enhance your everyday life. From seamless connectivity and fast wireless charging to robust security features and intuitive user experiences, Samsung has thoughtfully integrated a range of innovations into the Galaxy S24 to make your mobile experience more convenient, secure, and enjoyable.

Complementing its advanced features, the Galaxy S24 boasts a sleek and sophisticated design that reflects Samsung''s commitment to craftsmanship and elegance. With its premium materials, refined finishes, and ergonomic form factor, the Galaxy S24 not only looks stunning but also feels comfortable and natural in the hand, ensuring a luxurious user experience from every angle.'
WHERE name LIKE 'Samsung - Galaxy S24%';





UPDATE products
SET description = 'The Samsung Galaxy S24 Ultra is the epitome of flagship smartphones, offering an unparalleled blend of cutting-edge technology, innovative features, and stunning design. Designed to exceed the expectations of even the most discerning users, the Galaxy S24 Ultra sets a new standard for mobile excellence.

At the heart of the Galaxy S24 Ultra is its stunning display, which delivers an immersive viewing experience like no other. Featuring a vibrant Super AMOLED panel with a high refresh rate, the Galaxy S24 Ultra brings your content to life with vivid colors, crisp details, and smooth animations. Whether you''re streaming your favorite movies, browsing the web, or playing the latest games, the Galaxy S24 Ultra''s display ensures an unmatched visual experience.

Beyond its breathtaking display, the Galaxy S24 Ultra is packed with cutting-edge features and technologies that empower you to do more with your smartphone. Powered by a state-of-the-art processor and ample RAM, the Galaxy S24 Ultra delivers lightning-fast performance for seamless multitasking, gaming, and productivity. With its advanced camera system, including multiple lenses and AI-powered enhancements, the Galaxy S24 Ultra lets you capture stunning photos and videos with ease, whether you''re shooting in bright daylight or low-light conditions.

The Galaxy S24 Ultra also boasts a range of innovative features designed to enhance your mobile experience. From ultra-fast 5G connectivity and wireless charging to advanced security features like facial recognition and fingerprint scanning, the Galaxy S24 Ultra offers everything you need to stay connected, productive, and secure on the go.

In addition to its impressive performance and feature set, the Galaxy S24 Ultra features a sleek and stylish design that exudes sophistication and craftsmanship. With its slim profile, premium materials, and ergonomic curves, the Galaxy S24 Ultra looks and feels like a true flagship device, making a statement wherever you go.

Whether you''re a power user who demands the best in performance and features or a trendsetter who values style and design, the Samsung Galaxy S24 Ultra delivers on all fronts. With its unparalleled combination of cutting-edge technology, innovative features, and stunning design, the Galaxy S24 Ultra redefines what''s possible with a smartphone, setting a new standard for excellence in the mobile industry.'
WHERE name LIKE 'Samsung - Galaxy S24 Ultra%';








UPDATE products
SET description = 'The Samsung Galaxy S24+ represents the epitome of innovation and excellence in the world of smartphones. Designed to exceed the expectations of even the most demanding users, this flagship device combines cutting-edge technology with sleek design to deliver a premium mobile experience like no other.

At the heart of the Galaxy S24+ is its stunning display, which sets a new standard for visual brilliance and immersion. Boasting a large and vibrant Super AMOLED panel with high resolution and a high refresh rate, the Galaxy S24+ offers breathtaking clarity, vivid colors, and smooth motion that bring content to life in unprecedented detail. Whether you''re streaming your favorite movies, browsing the web, or gaming, the display ensures an unparalleled viewing experience that captivates the senses.

Underneath its elegant exterior, the Galaxy S24+ is powered by state-of-the-art hardware that delivers blazing-fast performance and responsiveness in every task. With a powerful processor, ample RAM, and advanced graphics capabilities, this smartphone effortlessly handles multitasking, gaming, and productivity with ease. Whether you''re launching apps, editing photos, or streaming content, the Galaxy S24+ delivers seamless performance that keeps up with your busy lifestyle.

Photography enthusiasts will appreciate the Galaxy S24+''s versatile camera system, which empowers you to capture stunning images and videos with ease. Featuring multiple lenses, including ultra-wide, wide-angle, and telephoto options, as well as advanced AI-driven features, the Galaxy S24+ allows you to unleash your creativity and capture moments with exceptional clarity, detail, and depth. Whether you''re shooting in broad daylight or low-light conditions, the Galaxy S24+ ensures that every shot is a masterpiece.

In addition to its outstanding performance and imaging capabilities, the Galaxy S24+ offers a wealth of intelligent features and functionalities designed to enhance your everyday life. From seamless connectivity and fast wireless charging to robust security features and intuitive user experiences, Samsung has incorporated a range of innovations into the Galaxy S24+ to make your mobile experience more convenient, secure, and enjoyable.

Complementing its advanced features, the Galaxy S24+ boasts a sleek and sophisticated design that exudes elegance and sophistication. With its premium materials, refined finishes, and ergonomic form factor, the Galaxy S24+ not only looks stunning but also feels comfortable and natural in the hand, ensuring a luxurious user experience from every angle.'
WHERE name LIKE 'Samsung - Galaxy S24+%';






UPDATE products
SET description = 'The Samsung Galaxy S23 represents the pinnacle of innovation and performance in the realm of smartphones. Crafted with meticulous attention to detail and powered by cutting-edge technology, this flagship device offers an unparalleled mobile experience that is sure to impress even the most discerning users.

At the heart of the Galaxy S23 is its stunning display, which sets a new standard for visual excellence. Featuring a large and vibrant Super AMOLED panel with high resolution and a high refresh rate, the Galaxy S23 delivers breathtaking clarity, vibrant colors, and smooth motion that bring content to life with astonishing detail. Whether you''re streaming your favorite movies, browsing the web, or gaming, the display ensures an immersive and captivating viewing experience that leaves you spellbound.

Underneath its sleek exterior, the Galaxy S23 is powered by state-of-the-art hardware that delivers exceptional performance and responsiveness in every task. Equipped with a powerful processor, ample RAM, and advanced graphics capabilities, this smartphone effortlessly handles multitasking, gaming, and productivity with effortless ease. Whether you''re launching apps, editing photos, or streaming content, the Galaxy S23 delivers seamless performance that keeps up with your busy lifestyle.

Photography enthusiasts will appreciate the Galaxy S23''s advanced camera system, which empowers you to capture stunning images and videos with professional-grade quality. Boasting multiple lenses, including ultra-wide, wide-angle, and telephoto options, as well as advanced AI-driven features, the Galaxy S23 enables you to unleash your creativity and capture moments with unparalleled clarity, detail, and depth. Whether you''re shooting in bright daylight or low-light conditions, the Galaxy S23 ensures that every shot is a masterpiece.

In addition to its impressive performance and imaging capabilities, the Galaxy S23 offers a host of intelligent features and functionalities designed to enhance your everyday life. From seamless connectivity and fast wireless charging to robust security features and intuitive user experiences, Samsung has incorporated a range of innovations into the Galaxy S23 to make your mobile experience more convenient, secure, and enjoyable.

Complementing its advanced features, the Galaxy S23 boasts a sleek and stylish design that exudes sophistication and elegance. With its premium materials, refined finishes, and ergonomic form factor, the Galaxy S23 not only looks stunning but also feels comfortable and natural in the hand, ensuring a luxurious user experience from every angle.'
WHERE name LIKE 'Samsung - Galaxy S23%';






UPDATE products
SET description = 'The Samsung Galaxy S23+ is a testament to Samsung''s relentless pursuit of innovation and excellence in the realm of smartphones. With its cutting-edge features, powerful performance, and refined design, the Galaxy S23+ offers a premium mobile experience that exceeds expectations.

At the heart of the Galaxy S23+ is its stunning display, which sets a new standard for visual excellence. Boasting a large Dynamic AMOLED panel with a high refresh rate and HDR support, the Galaxy S23+ delivers vibrant colors, deep blacks, and razor-sharp details that bring content to life with stunning clarity and realism. Whether you''re watching movies, playing games, or browsing the web, the immersive display ensures an unrivaled viewing experience that captivates your senses.

Under the hood, the Galaxy S23+ is powered by a powerful processor and ample RAM, ensuring smooth performance and responsiveness in every task. Whether you''re multitasking, gaming, or streaming content, the Galaxy S23+ delivers seamless performance that keeps up with your demands. Plus, with 5G connectivity, you can enjoy blazing-fast download and streaming speeds, allowing you to stay connected and productive wherever you go.

Photography enthusiasts will appreciate the Galaxy S23+''s advanced camera system, which captures stunning photos and videos with remarkable clarity and detail. Featuring multiple lenses, including ultra-wide, wide-angle, and telephoto options, as well as advanced AI-powered features, the Galaxy S23+ empowers you to unleash your creativity and capture moments with professional-grade quality. Whether you''re shooting landscapes, portraits, or close-ups, the Galaxy S23+ delivers exceptional results that are sure to impress.

In addition to its impressive performance and imaging capabilities, the Galaxy S23+ offers a range of intelligent features and functionalities designed to enhance your everyday life. From secure biometric authentication and robust privacy controls to seamless integration with Samsung''s ecosystem of devices and services, the Galaxy S23+ puts the power of innovation at your fingertips, empowering you to do more and worry less.

Complementing its advanced features, the Galaxy S23+ boasts a sleek and stylish design that reflects Samsung''s commitment to craftsmanship and quality. With its premium materials, refined finishes, and ergonomic form factor, the Galaxy S23+ not only looks stunning but also feels comfortable and natural in the hand, ensuring a luxurious user experience that stands out from the crowd.'
WHERE name LIKE 'Samsung - Galaxy S23+%';





UPDATE products
SET description = 'The Huawei Nova 10 SE embodies Huawei''s commitment to delivering a premium smartphone experience at an accessible price point. Packed with features, style, and performance, the Nova 10 SE is designed to meet the needs of modern users who demand more from their devices.

At the forefront of the Nova 10 SE is its sleek and stylish design, which combines premium materials and craftsmanship to create a device that looks as good as it performs. With its slim profile, curved edges, and refined finish, the Nova 10 SE exudes elegance and sophistication, making it a statement piece wherever you go.

Powering the Nova 10 SE is a capable processor paired with ample RAM, ensuring smooth performance and responsiveness in everyday tasks. Whether you''re browsing the web, streaming content, or multitasking between apps, the Nova 10 SE delivers a fluid and seamless user experience that keeps up with your busy lifestyle.

The Nova 10 SE also boasts a stunning display that brings your content to life with vibrant colors and crisp details. Featuring a large AMOLED panel with high resolution and HDR support, the Nova 10 SE immerses you in your favorite movies, games, and photos with stunning clarity and realism. Plus, with slim bezels and a high screen-to-body ratio, you get more screen real estate in a compact form factor, maximizing your viewing experience without sacrificing comfort or portability.

Photography enthusiasts will appreciate the Nova 10 SE''s versatile camera system, which captures stunning photos and videos in any setting. Equipped with multiple lenses, including wide-angle, ultra-wide-angle, and depth sensors, as well as advanced AI-powered features, the Nova 10 SE empowers you to unleash your creativity and capture memorable moments with professional-quality results. Whether you''re shooting landscapes, portraits, or close-ups, the Nova 10 SE ensures that every shot is a masterpiece.

In addition to its impressive performance and imaging capabilities, the Nova 10 SE offers a range of intelligent features and functionalities designed to enhance your everyday life. From advanced security and privacy features to seamless connectivity and productivity tools, the Nova 10 SE puts the power of innovation at your fingertips, empowering you to do more, see more, and be more in every moment.'
WHERE name LIKE 'Huawei - Nova 10 SE%';





UPDATE products
SET description = 'The Huawei Nova Y91 is a budget-friendly smartphone designed to offer essential features and reliable performance for everyday use. With its sleek design, vibrant display, and capable camera system, the Nova Y91 provides a satisfying user experience at an affordable price point.

Featuring a modern and ergonomic design, the Nova Y91 boasts a sleek and compact form factor that is comfortable to hold and easy to carry. Its smooth curves and slim profile make it a stylish accessory that complements any lifestyle.

Equipped with a bright and vibrant display, the Nova Y91 delivers an immersive viewing experience for all your favorite content. Whether you''re browsing the web, watching videos, or scrolling through social media, the Nova Y91''s crisp display ensures that every image and video looks sharp and vibrant.

The Nova Y91 also features a capable camera system that allows you to capture life''s memorable moments with ease. With its primary rear camera and front-facing selfie camera, you can snap high-quality photos and selfies to share with friends and family. Additionally, the Nova Y91 offers various camera modes and features, such as portrait mode and HDR, to enhance your photography experience.

Under the hood, the Nova Y91 is powered by a reliable processor and ample RAM, ensuring smooth performance for everyday tasks. Whether you''re multitasking between apps, browsing the web, or playing casual games, the Nova Y91 delivers responsive performance that keeps up with your busy lifestyle.

In terms of software, the Nova Y91 runs on Huawei''s EMUI operating system, which offers a clean and intuitive user interface. With features like app shortcuts, gesture navigation, and built-in optimizations, EMUI provides a seamless user experience that is both efficient and user-friendly.'
WHERE name LIKE 'Huawei - Nova Y91%';





UPDATE products
SET description = 'The Huawei Pura 70 is a sleek and stylish smartphone designed to deliver a premium user experience with its advanced features and modern design. Boasting a stunning display, powerful performance, and versatile camera system, the Pura 70 is a versatile device that meets the needs of both casual users and tech enthusiasts alike.

At the heart of the Huawei Pura 70 is its vibrant display, which offers an immersive viewing experience for all your multimedia content. With its high-resolution screen and vivid colors, the Pura 70 brings your favorite movies, games, and photos to life with stunning clarity and detail. Whether you''re streaming videos, browsing the web, or scrolling through social media, the Pura 70''s display ensures an enjoyable viewing experience every time.

Equipped with a powerful processor and ample RAM, the Huawei Pura 70 delivers smooth and responsive performance for all your daily tasks. Whether you''re multitasking between apps, playing graphics-intensive games, or streaming HD video, the Pura 70 can handle it all with ease. Plus, with its long-lasting battery life, you can stay connected and productive throughout the day without worrying about running out of power.

In the camera department, the Huawei Pura 70 shines with its versatile camera system, which allows you to capture stunning photos and videos in any situation. With its high-resolution primary camera, you can snap detailed photos with rich colors and sharp clarity. Plus, with features like portrait mode, night mode, and AI scene recognition, you can take your photography to the next level and capture professional-looking shots with ease.

The Huawei Pura 70 also offers a range of other features and capabilities to enhance your smartphone experience. From advanced security features like facial recognition and fingerprint scanning to convenient tools like voice assistant and gesture controls, the Pura 70 is designed to make your life easier and more enjoyable.'
WHERE name LIKE 'Huawei - Pura 70%';






UPDATE products
SET description = 'The Huawei Pura 70 Pro is a flagship smartphone that redefines the boundaries of mobile technology, combining cutting-edge features with exquisite design craftsmanship. With its powerful performance, stunning display, advanced camera system, and innovative features, the Pura 70 Pro sets new standards for what a smartphone can achieve.

At the heart of the Huawei Pura 70 Pro is its blazing-fast processor and generous RAM, which work together to deliver unparalleled performance for all your computing needs. Whether you''re streaming HD videos, playing graphics-intensive games, or multitasking between multiple apps, the Pura 70 Pro can handle it all with ease, ensuring smooth and responsive performance at all times.

The Pura 70 Pro boasts a gorgeous display that immerses you in your favorite content with vibrant colors, deep contrasts, and stunning clarity. Whether you''re watching movies, browsing photos, or reading articles, every detail comes to life on the Pura 70 Pro''s high-resolution screen, providing an unparalleled viewing experience that''s second to none.

When it comes to photography, the Huawei Pura 70 Pro excels with its advanced camera system, which features a versatile array of lenses and sensors to help you capture stunning photos and videos in any situation. From crisp landscapes to detailed close-ups, the Pura 70 Pro''s camera delivers exceptional image quality with rich colors, sharp details, and natural-looking skin tones, ensuring that every shot you take is a masterpiece.

In addition to its powerful performance and stunning camera capabilities, the Huawei Pura 70 Pro also offers a range of innovative features and functionalities to enhance your smartphone experience. From advanced security features like facial recognition and fingerprint scanning to convenient tools like voice assistant and gesture controls, the Pura 70 Pro is designed to make your life easier and more enjoyable.'
WHERE name LIKE 'Pura 70 Pro%';






UPDATE products
SET description = 'The Huawei Pura 70 Ultra is a marvel of smartphone engineering, pushing the boundaries of innovation to deliver an unparalleled mobile experience. Boasting cutting-edge features, premium design, and exceptional performance, the Pura 70 Ultra stands at the pinnacle of Huawei''s flagship lineup, catering to discerning users who demand the very best.

At the core of the Huawei Pura 70 Ultra lies its powerful processor and generous RAM, which work in harmony to deliver lightning-fast performance and seamless multitasking. Whether you''re streaming high-definition content, playing graphics-intensive games, or switching between multiple apps, the Pura 70 Ultra ensures smooth and responsive operation, empowering you to do more with ease.

One of the standout features of the Pura 70 Ultra is its stunning display, which captivates with its vibrant colors, sharp contrasts, and immersive visuals. Whether you''re watching movies, browsing photos, or gaming, every detail springs to life on the Pura 70 Ultra''s expansive screen, offering an unrivaled viewing experience that''s truly breathtaking.

Photography enthusiasts will appreciate the Huawei Pura 70 Ultra''s advanced camera system, which raises the bar for smartphone photography. Equipped with a versatile array of lenses and sensors, including ultra-wide, telephoto, and macro capabilities, the Pura 70 Ultra empowers you to unleash your creativity and capture stunning photos and videos in any scenario. From sweeping landscapes to detailed close-ups, every shot taken with the Pura 70 Ultra is a masterpiece in the making.

In addition to its impressive performance and imaging capabilities, the Huawei Pura 70 Ultra offers a host of innovative features and intelligent functionalities designed to enhance your everyday life. Whether it''s advanced security features like facial recognition and fingerprint scanning, immersive audio experiences with stereo speakers, or intuitive software enhancements that streamline your user experience, the Pura 70 Ultra is packed with thoughtful touches that elevate your smartphone experience to new heights.

Crafted with precision and attention to detail, the Huawei Pura 70 Ultra exudes sophistication and elegance from every angle. Its sleek, seamless design, premium materials, and refined finishes make it a true symbol of luxury and style, while its ergonomic form factor ensures a comfortable grip and effortless usability.'
WHERE name LIKE 'Huawei - Pura 70 Ultra%';





UPDATE products
SET description = 'The Nothing Phone (2) represents a bold leap into the future of mobile technology, redefining what a smartphone can be with its minimalist design, innovative features, and uncompromising performance. Crafted with precision and attention to detail, the Nothing Phone (2) embodies the ethos of its namesake brand, delivering a seamless and immersive user experience that seamlessly integrates into your daily life.

At the heart of the Nothing Phone (2) lies a powerful processor and advanced hardware components, meticulously engineered to deliver blazing-fast performance, smooth multitasking, and exceptional efficiency. Whether you''re streaming high-definition content, playing immersive games, or tackling productivity tasks, the Nothing Phone (2) effortlessly handles whatever you throw at it, ensuring a responsive and fluid user experience at all times.

The Nothing Phone (2) boasts a stunning display that captivates with its vivid colors, sharp details, and expansive viewing angles. Whether you''re watching movies, browsing the web, or scrolling through social media, every interaction with the Nothing Phone (2) is a feast for the eyes, thanks to its immersive screen that brings your content to life in vibrant clarity.

In the camera department, the Nothing Phone (2) excels with its advanced imaging capabilities, allowing you to capture stunning photos and videos with ease. Equipped with a versatile array of lenses, intelligent software algorithms, and cutting-edge camera features, the Nothing Phone (2) empowers you to unleash your creativity and capture moments like a pro, whether it''s sweeping landscapes, detailed close-ups, or dynamic action shots.

Beyond its performance and imaging prowess, the Nothing Phone (2) is packed with innovative features and thoughtful touches that enhance your mobile experience. From intuitive gesture controls and customizable shortcuts to intelligent AI assistance and enhanced security features, the Nothing Phone (2) puts the power of innovation at your fingertips, making every interaction with your smartphone more intuitive, seamless, and enjoyable.

Designed to stand out from the crowd, the Nothing Phone (2) sports a sleek and minimalist design that exudes sophistication and elegance. With its seamless glass panels, refined metal frame, and minimalist aesthetic, the Nothing Phone (2) is a true masterpiece of modern design, making a statement wherever you go.'
WHERE name LIKE 'Nothing - Phone (2)%';





UPDATE products
SET description = 'The Nothing Phone (2a) is a testament to minimalist elegance and innovative technology, embodying the ethos of its namesake brand with a design that is both strikingly simple and refreshingly modern. Crafted with meticulous attention to detail and a commitment to excellence, the Nothing Phone (2a) redefines what a smartphone can be, offering a seamless and immersive user experience that seamlessly integrates into your daily life.

At its core, the Nothing Phone (2a) is powered by cutting-edge hardware and advanced software, delivering lightning-fast performance, seamless multitasking, and exceptional efficiency. Whether you''re streaming your favorite content, playing immersive games, or tackling productivity tasks, the Nothing Phone (2a) effortlessly handles whatever you throw at it, ensuring a smooth and responsive user experience at all times.

One of the standout features of the Nothing Phone (2a) is its stunning display, which captivates with its vibrant colors, sharp details, and immersive visuals. Whether you''re watching movies, browsing the web, or scrolling through social media, every interaction with the Nothing Phone (2a) is a feast for the eyes, thanks to its expansive screen that brings your content to life in vivid clarity.

In the camera department, the Nothing Phone (2a) excels with its advanced imaging capabilities, allowing you to capture stunning photos and videos with ease. Equipped with a versatile array of lenses, intelligent software algorithms, and cutting-edge camera features, the Nothing Phone (2a) empowers you to unleash your creativity and capture moments like a pro, whether it''s sweeping landscapes, detailed close-ups, or dynamic action shots.

Beyond its performance and imaging prowess, the Nothing Phone (2a) is packed with innovative features and thoughtful touches that enhance your mobile experience. From intuitive gesture controls and customizable shortcuts to intelligent AI assistance and enhanced security features, the Nothing Phone (2a) puts the power of innovation at your fingertips, making every interaction with your smartphone more intuitive, seamless, and enjoyable.

Designed to turn heads and spark conversation, the Nothing Phone (2a) sports a sleek and minimalist design that exudes sophistication and style. With its seamless glass panels, refined metal frame, and minimalist aesthetic, the Nothing Phone (2a) is a true work of art, making a bold statement wherever you go.'
WHERE name LIKE 'Nothing - Phone (2a)%';





UPDATE products
SET description = 'The Google Pixel Fold is a groundbreaking foldable smartphone that combines cutting-edge technology with innovative design, offering users a new way to experience mobile computing. With its flexible display and versatile form factor, the Pixel Fold redefines the boundaries of smartphone design and functionality, allowing users to seamlessly transition between different modes of use.

At the heart of the Pixel Fold is its flexible OLED display, which bends and folds to provide users with a larger screen real estate when needed, while still maintaining the portability and convenience of a traditional smartphone. Whether you''re watching videos, browsing the web, or multitasking between apps, the Pixel Fold''s expansive display delivers immersive visuals and crisp details, making every interaction a pleasure.

Powered by Google''s advanced software and hardware technologies, the Pixel Fold offers a seamless and intuitive user experience that''s optimized for productivity, creativity, and entertainment. With features like split-screen multitasking, app continuity, and adaptive UI, the Pixel Fold adapts to your needs and preferences, allowing you to stay productive and connected no matter where you are.

In terms of performance, the Pixel Fold is equipped with powerful hardware components and optimized software algorithms, ensuring smooth and responsive performance for even the most demanding tasks. Whether you''re gaming, streaming content, or editing photos and videos, the Pixel Fold delivers blazing-fast performance and seamless multitasking, thanks to its cutting-edge processor and ample RAM.

When it comes to photography, the Pixel Fold excels with its advanced camera system, which is designed to capture stunning photos and videos in any lighting condition. Whether you''re taking portraits, landscapes, or low-light shots, the Pixel Fold''s high-quality camera sensors and intelligent image processing algorithms ensure that every shot is crisp, clear, and vibrant.

In terms of design, the Pixel Fold is sleek, stylish, and ergonomically designed, with a premium build quality and attention to detail that sets it apart from other smartphones on the market. From its slim profile and smooth curves to its durable construction and refined finishes, the Pixel Fold exudes sophistication and elegance, making it a true statement piece.'
WHERE name LIKE 'Google - Pixel Fold%';





UPDATE products
SET description = 'The Google Pixel 7 is the latest flagship smartphone from Google, offering an exceptional combination of cutting-edge technology, innovative features, and sleek design. With its powerful performance, stunning display, advanced camera system, and seamless software experience, the Pixel 7 sets a new standard for what a smartphone can deliver.

At the core of the Pixel 7 is its powerful Qualcomm Snapdragon processor, which ensures smooth and responsive performance for even the most demanding tasks. Whether you''re streaming videos, playing games, or multitasking between apps, the Pixel 7 delivers lightning-fast performance and efficiency, allowing you to stay productive and entertained throughout the day.

The Pixel 7 features a stunning display that''s perfect for immersive entertainment and productivity. With its high-resolution OLED panel and vibrant colors, the Pixel 7 brings your photos, videos, and games to life with stunning clarity and detail. Whether you''re watching movies, browsing the web, or editing photos, the Pixel 7''s display ensures an exceptional viewing experience every time.

In terms of photography, the Pixel 7 excels with its advanced camera system, which is designed to capture stunning photos and videos in any lighting condition. With its high-resolution main camera, ultra-wide lens, and advanced imaging algorithms, the Pixel 7 delivers breathtaking results with rich colors, sharp details, and true-to-life tones. Whether you''re shooting portraits, landscapes, or low-light scenes, the Pixel 7''s camera system ensures that you always get the perfect shot.

One of the standout features of the Pixel 7 is its intuitive software experience, powered by Google''s latest Android operating system. With features like the Google Assistant, you can easily control your device with voice commands, get answers to your questions, and stay organized throughout your day. Additionally, the Pixel 7 receives regular software updates and security patches directly from Google, ensuring that your device stays up to date and protected against the latest threats.

In terms of design, the Pixel 7 boasts a sleek and modern aesthetic that''s both stylish and functional. With its slim profile, smooth curves, and premium materials, the Pixel 7 exudes sophistication and elegance, making it a pleasure to hold and use. Whether you choose the sleek black variant or the vibrant color options, the Pixel 7 is sure to turn heads wherever you go.'
WHERE name LIKE 'Google - Pixel 7%';






UPDATE products
SET description = 'The Google Pixel 7a is a highly anticipated addition to Google''s renowned lineup of smartphones, combining cutting-edge features with the signature Pixel experience. With its impressive specifications and intuitive software, the Pixel 7a aims to deliver an exceptional user experience for both casual users and tech enthusiasts alike.

At the heart of the Pixel 7a is its powerful Qualcomm Snapdragon processor, which ensures smooth performance and responsiveness for everyday tasks, such as browsing the web, streaming content, and multitasking between apps. Whether you''re checking emails, playing games, or editing photos, the Pixel 7a delivers a seamless and lag-free experience, thanks to its efficient hardware configuration.

The Pixel 7a sports a vibrant and immersive display that''s perfect for enjoying your favorite content in stunning detail. With its high-resolution screen and accurate color reproduction, the Pixel 7a brings your photos, videos, and games to life with crisp clarity and vibrant colors. Whether you''re watching movies on the go or browsing social media at home, the Pixel 7a''s display ensures an engaging viewing experience every time.

In terms of photography, the Pixel 7a shines with its advanced camera system, which is designed to capture beautiful photos and videos in any lighting condition. Equipped with a high-resolution main camera and advanced imaging algorithms, the Pixel 7a delivers stunning results with rich colors, sharp details, and natural-looking skin tones. Whether you''re shooting portraits, landscapes, or low-light scenes, the Pixel 7a''s camera system ensures that you always get the perfect shot.

One of the standout features of the Pixel 7a is its intuitive software experience, powered by Google''s latest Android operating system. With features like the Google Assistant, you can easily control your device with voice commands, get answers to your questions, and stay organized throughout your day. Additionally, the Pixel 7a receives regular software updates and security patches directly from Google, ensuring that your device stays up to date and protected against the latest threats.

In terms of design, the Pixel 7a features a sleek and modern aesthetic that''s both stylish and functional. With its slim profile, smooth curves, and premium materials, the Pixel 7a exudes sophistication and elegance, making it a pleasure to hold and use. Whether you choose the sleek black variant or the vibrant color options, the Pixel 7a is sure to turn heads wherever you go.'
WHERE name LIKE 'Google - Pixel 7a%';







UPDATE products
SET description = 'The Google Pixel 7 Pro stands as a pinnacle of smartphone innovation, boasting cutting-edge technology, exceptional performance, and a stunning design. Crafted to redefine your mobile experience, this flagship device seamlessly integrates advanced features with a sleek aesthetic, offering users a premium smartphone experience like no other.

At its heart lies a formidable Qualcomm Snapdragon processor, delivering unparalleled speed, efficiency, and responsiveness. Whether you''re multitasking between apps, gaming, or streaming content, the Pixel 7 Pro ensures smooth performance and effortless navigation, empowering you to tackle any task with ease.

The Pixel 7 Pro''s display is nothing short of breathtaking. Featuring an expansive OLED panel with vibrant colors, deep blacks, and stunning contrast, every image and video is brought to life with unparalleled clarity and detail. Whether you''re binge-watching your favorite shows or editing photos, the Pixel 7 Pro''s display elevates your viewing experience to new heights.

Photography enthusiasts will rejoice in the Pixel 7 Pro''s cutting-edge camera system. With its advanced sensor technology, versatile lens options, and powerful image processing capabilities, the Pixel 7 Pro captures breathtaking photos and videos in any lighting condition. From stunning landscapes to detailed close-ups, every shot is imbued with rich colors, sharp details, and lifelike textures, allowing you to unleash your creativity and capture the world in stunning clarity.

Beyond its exceptional hardware, the Pixel 7 Pro delivers a seamless software experience powered by Google''s latest Android operating system. With intuitive features like the Google Assistant and seamless integration with Google services, staying connected, organized, and productive has never been easier. Plus, with regular software updates and security patches directly from Google, your Pixel 7 Pro remains optimized and protected against the latest threats.

Designed with sophistication and style in mind, the Pixel 7 Pro features a sleek and modern aesthetic that''s sure to turn heads. With its premium materials, refined finish, and attention to detail, the Pixel 7 Pro exudes elegance and craftsmanship, making it a true statement piece.'
WHERE name LIKE 'Google - Pixel 7 Pro%';




UPDATE products
SET description = 'The Google Pixel 8 is a smartphone aimed at users who prioritize camera quality and a clean software experience.  It boasts a powerful Google Tensor G3 processor, built on a 4nm architecture, which should offer users smooth performance and fast speeds. The phone runs Android 14, the latest version of Google''s operating system,  out of the box,  meaning you''ll get the newest features and security updates directly from Google.

The Pixel 8 shines in the camera department. It features a dual camera system on the back, with a main 50-megapixel wide sensor and a 12-megapixel ultrawide sensor. This combination allows you to capture stunning photos and videos in a variety of lighting conditions. Google''s computational photography software is some of the best in the business, and the Pixel 8 takes full advantage of it. You can expect features like Night Sight, which brightens up low-light photos without introducing grain, and Super Res Zoom, which allows you to zoom in on your subjects without losing quality. The Pixel 8 also boasts a new Macro Focus mode, which lets you capture close-up shots with incredible detail.

The Pixel 8 has a 6.2-inch OLED display with a 120Hz refresh rate, which means that the screen will be smooth and responsive, perfect for gaming and watching videos. The battery is a decent 4575mAh, and it supports fast charging, so you can get back up and running quickly when your phone runs low on juice.'
WHERE name LIKE 'Google - Pixel 8%';




UPDATE products
SET description = 'The Google Pixel 8 Pro represents the pinnacle of smartphone technology, combining cutting-edge innovation with sleek design to deliver an unparalleled user experience. From its powerful performance to its stunning display and advanced camera capabilities, the Pixel 8 Pro sets a new standard for what a flagship smartphone can achieve.

At the core of the Pixel 8 Pro is Qualcomm''s latest Snapdragon processor, ensuring lightning-fast performance and seamless multitasking. Whether you''re gaming, streaming, or tackling productivity tasks, the Pixel 8 Pro delivers smooth, responsive performance that keeps up with your busy lifestyle.

The Pixel 8 Pro boasts a breathtaking display that immerses you in your favorite content like never before. Featuring an expansive OLED panel with vibrant colors, deep blacks, and crisp details, every image and video comes to life with stunning clarity and realism. Whether you''re watching movies, browsing the web, or editing photos, the Pixel 8 Pro''s display provides an unmatched viewing experience.

Photography enthusiasts will appreciate the Pixel 8 Pro''s advanced camera system, which captures stunning photos and videos in any lighting conditions. With its versatile lens options, powerful image processing capabilities, and AI-enhanced features, the Pixel 8 Pro ensures that every shot is a masterpiece. From vibrant landscapes to detailed portraits, the Pixel 8 Pro empowers you to unleash your creativity and capture the world in breathtaking detail.

Beyond its impressive hardware, the Pixel 8 Pro offers a seamless software experience powered by Google''s latest Android operating system. With intuitive features like the Google Assistant and seamless integration with Google services, the Pixel 8 Pro keeps you connected, organized, and productive throughout your day. Plus, with regular software updates and security patches directly from Google, your Pixel 8 Pro remains optimized and protected against the latest threats.

Designed with both style and durability in mind, the Pixel 8 Pro features a sleek and modern design that''s sure to turn heads. With premium materials, refined finishes, and attention to detail, the Pixel 8 Pro exudes sophistication and craftsmanship, making it a true statement piece.'
WHERE name LIKE 'Google - Pixel 8 Pro%';






UPDATE products
SET description = 'The Google Pixel 8a is a mid-range option for those seeking a balance between affordability and excellent camera performance.  It shares many similarities with its pricier sibling, the Pixel 8, but with a few key differences.

The Pixel 8a features a slightly smaller 6.1-inch OLED display,  but it still retains a smooth 120Hz refresh rate for a great viewing experience.  Under the hood, you''ll find the same Google Tensor G3 processor as the Pixel 8, ensuring snappy performance for everyday tasks and even some light gaming.  Like the Pixel 8, it runs the latest Android 14 operating system,  providing access to all the latest features and Google''s promise of updates for up to 7 years.

The biggest difference lies in the camera system. While the Pixel 8a still boasts impressive photography, it opts for a 64-megapixel main sensor instead of the 50-megapixel sensor found on the Pixel 8.  However, megapixels aren''t everything, and Google''s computational photography software helps the Pixel 8a capture exceptional photos and videos.  You''ll still get features like Night Sight for low-light photography and Super Res Zoom for zooming in without sacrificing quality.  The ultrawide sensor remains the same at 13-megapixels, offering great options for capturing expansive landscapes or fitting more people into group shots.

The Pixel 8a packs a slightly smaller 4404mAh battery compared to the Pixel 8, but Google still advertises a full 24+ hours of battery life on a single charge. It also supports fast charging, so you can quickly get back on track when needed.'
WHERE name LIKE 'Google - Pixel 8a%';




/*
UPDATE products
SET description = ''
WHERE name LIKE '%';













