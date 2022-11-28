INSERT INTO User_E (id, username, firstName, lastName, email, password, address) VALUES
(1, 'user1', 'Bart', 'Holomew', 'b.holomew@email.com', 'bholomew', '123 Hello St.');
INSERT INTO User_E (id, username, firstName, lastName, email, password, address) VALUES
(2, 'Osmane', 'Ozzington', 'Smith', 'o.smith@email.com', 'osmith', '231 Bye St.');
INSERT INTO User_E (id, username, firstName, lastName, email, password, address) VALUES
(3, 'Anton123', 'John', 'Doe', 'j.doe@email.com', 'jdoe', '321 Thanks Ave.');
INSERT INTO User_E (id, username, firstName, lastName, email, password, address) VALUES
(4, 'OsmanBasilKim', 'Jacob', 'Doe', 'yeo@gmail.com', 'iloveosman!', '123 Oakland St.');

INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('BMW', 'Germany', 1916, 'Munich', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/BMW_logo_%28gray%29.svg/1200px-BMW_logo_%28gray%29.svg.png');
-- data from https://en.wikipedia.org/wiki/BMW
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('Volkswagen', 'Germany', 1937, 'Wolfsburg', 'https://upload.wikimedia.org/wikipedia/commons/6/6d/Volkswagen_logo_2019.svg');
-- data from https://en.wikipedia.org/wiki/Volkswagen
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('SEAT', 'Spain', 1950, 'Martorell', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/SEAT_Logo_from_2017.svg/2560px-SEAT_Logo_from_2017.svg.png');
-- data from https://en.wikipedia.org/wiki/SEAT
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('Renault', 'France', 1898, 'Boulogne-Billancourt', 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Renault_2009_logo.svg/2048px-Renault_2009_logo.svg.png');
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('Peugeot', 'France', 1896, 'Paris', 'https://upload.wikimedia.org/wikipedia/en/thumb/f/fe/Peugeot_2021.svg/1200px-Peugeot_2021.svg.png');
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('Toyota', 'Japan', 1937, 'Aichi', 'https://www.freepnglogos.com/uploads/toyota-logo-png/toyota-logos-brands-logotypes-0.png');
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('Opel', 'Germany', 1862, 'Russelsheim', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/Opel_logo.svg/2560px-Opel_logo.svg.png');
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('Mazda', 'Japan', 1920, 'Fuchu, Hiroshima', 'https://1000logos.net/wp-content/uploads/2019/12/Mazda_Logo.png');
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('Ford', 'USA', 1903, 'Michigan', 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Ford_logo_flat.svg/2560px-Ford_logo_flat.svg.png');
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('Mercedes-Benz', 'Germany', 1926, 'Stuttgart', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Mercedes_Benz_Logo_11.jpg/1200px-Mercedes_Benz_Logo_11.jpg');
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('Chevrolet', 'USA', 1911, 'San Ramon', 'https://www.carlogos.org/logo/Chevrolet-logo-2013-2560x1440.png');
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('Audi', 'Germany', 1909, 'Ingolstadt', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Audi-Logo_2016.svg/2560px-Audi-Logo_2016.svg.png');
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('Fiat', 'Italy', 1899, 'Turin', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/Fiat_Automobiles_logo.svg/2048px-Fiat_Automobiles_logo.svg.png');
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('Kia', 'South Korea', 1944, 'Seoul', 'https://www.cnet.com/a/img/resize/148e264de9d8cc9b7a97bbe2459402fda2406809/hub/2021/01/06/19ab53c1-6b8d-4f44-a89a-b84fc7f825e8/ogi-kia.jpg?auto=webp&fit=crop&height=675&width=1200');
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('Dacia', 'Romania', 1966, 'Mioveni', 'http://listcarbrands.com/wp-content/uploads/2016/12/Dacia-Logo.png');
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('MINI', 'United Kingdom', 1969, 'Phoenix', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/MINI_logo.svg/2560px-MINI_logo.svg.png');
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('Hyundai', 'South Korea', 1967, 'Seoul', 'https://www.carlogos.org/logo/Hyundai-logo-grey-2560x1440.png');













INSERT INTO Car_E (id, make, sellerId, model, releaseYear, fuelType, price, vehicleType, hp, mileage, colour, transmission, carURL) VALUES
(1, 'BMW', 1, '316', 2011, 'Diesel', 6800, 'Sedan', 116, 235000, 'Pearl', 'Manual', 'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_default/v1/editorial/vhs/BMW%20316i.png');
INSERT INTO Car_E (id, make, sellerId, model, releaseYear, fuelType, price, vehicleType, hp, mileage, colour, transmission, carURL) VALUES
(2, 'Volkswagen', 2, 'Golf', 2011, 'Gasoline', 6877, 'Hatchback', 122, 92800, 'Yellow', 'Manual', 'https://www.motortrend.com/uploads/sites/10/2015/11/2011-volkswagen-golf-6-at-pzev-3-door-hatchback-angular-front.png');
INSERT INTO Car_E (id, make, sellerId, model, releaseYear, fuelType, price, vehicleType, hp, mileage, colour, transmission, carURL) VALUES
(3, 'SEAT', 3, 'Exeo', 2011, 'Gasoline', 6900, 'Hatchback', 160, 149300, 'Silver', 'Manual', 'https://upload.wikimedia.org/wikipedia/commons/6/67/2011_SEAT_Exeo_Sport_Tech_CR_TDi_168_2.0_Front.jpg');
-- data from https://www.kaggle.com/datasets/ander289386/cars-germany

INSERT INTO Review_E (id, userId, carId, dateTimeStamp, reviewText, likes, replies) VALUES (1, 1, 1, '09/27/2022', 'Amazing car!', 0, 1);
INSERT INTO Review_E (id, userId, carId, dateTimeStamp, reviewText, likes, replies) VALUES (2, 2, 3, '09/28/2022', 'This car should not exist.', 100, 12);

