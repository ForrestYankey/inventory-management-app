BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO hello (string) VALUES ('Hello, World!');

INSERT INTO inventory (name, descripiton, quantity, price)
VALUES
    ('Running Shoes', 'Lightweight running shoes for optimal performance.', 50, 79.99),
    ('Basketball Sneakers', 'High-top basketball sneakers with ankle support.', 30, 109.95),
    ('Casual Sneakers', 'Stylish and comfortable sneakers for everyday wear.', 40, 64.99),
    ('Trail Running Shoes', 'Durable trail running shoes for outdoor adventures.', 25, 89.99),
    ('Athletic Training Shoes', 'Versatile training shoes for various sports activities.', 35, 74.95),
    ('Formal Dress Shoes', 'Elegant dress shoes for formal occasions.', 15, 129.99),
    ('Hiking Boots', 'Sturdy hiking boots with waterproof features.', 20, 109.95),
    ('Skateboarding Shoes', 'Durable skateboarding shoes for skate enthusiasts.', 28, 54.99),
    ('Flip-Flops', 'Comfortable flip-flops for casual and beachwear.', 60, 19.99),
    ('Winter Boots', 'Insulated winter boots to keep your feet warm in cold weather.', 18, 79.95);

COMMIT TRANSACTION;
