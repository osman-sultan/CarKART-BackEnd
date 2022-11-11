INSERT INTO User_E (id, username, firstName, lastName, email, password, address) VALUES
(1, 'user1', 'Bart', 'Holomew', 'b.holomew@email.com', 'bholomew', '123 Hello St.');
INSERT INTO User_E (id, username, firstName, lastName, email, password, address) VALUES
(2, 'user2', 'Ozzington', 'Smith', 'o.smith@email.com', 'osmith', '231 Bye St.');
INSERT INTO User_E (id, username, firstName, lastName, email, password, address) VALUES
(3, 'user3', 'John', 'Doe', 'j.doe@email.com', 'jdoe', '321 Thanks Ave.');

INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('BMW', 'Germany', 1916, 'Munich', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/BMW_logo_%28gray%29.svg/1200px-BMW_logo_%28gray%29.svg.png');
-- data from https://en.wikipedia.org/wiki/BMW
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('Volkswagen', 'Germany', 1937, 'Wolfsburg', 'https://upload.wikimedia.org/wikipedia/commons/6/6d/Volkswagen_logo_2019.svg');
-- data from https://en.wikipedia.org/wiki/Volkswagen
INSERT INTO Company_E (make, country, yearFounded, hq, logoURL) VALUES ('SEAT', 'Spain', 1950, 'Martorell', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/SEAT_Logo_from_2017.svg/2560px-SEAT_Logo_from_2017.svg.png');
-- data from https://en.wikipedia.org/wiki/SEAT

INSERT INTO Car_E (id, make, model, releaseYear, fuelType, price, vehicleType, hp, mileage, colour, transmission, carURL) VALUES
(1, 'BMW', '316', 2011, 'Diesel', 6800, 'Sedan', 116, 235000, 'Pearl', 'Manual', 'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_default/v1/editorial/vhs/BMW%20316i.png');
INSERT INTO Car_E (id, make, model, releaseYear, fuelType, price, vehicleType, hp, mileage, colour, transmission, carURL) VALUES
(2, 'Volkswagen', 'Golf', 2011, 'Gasoline', 6877, 'Hatchback', 122, 92800, 'Yellow', 'Manual', 'https://www.motortrend.com/uploads/sites/10/2015/11/2011-volkswagen-golf-6-at-pzev-3-door-hatchback-angular-front.png');
INSERT INTO Car_E (id, make, model, releaseYear, fuelType, price, vehicleType, hp, mileage, colour, transmission, carURL) VALUES
(3, 'SEAT', 'Exeo', 2011, 'Gasoline', 6900, 'Hatchback', 160, 149300, 'Silver', 'Manual', 'https://upload.wikimedia.org/wikipedia/commons/6/67/2011_SEAT_Exeo_Sport_Tech_CR_TDi_168_2.0_Front.jpg');
-- data from https://www.kaggle.com/datasets/ander289386/cars-germany

INSERT INTO Review_E (id, userId, carId, dateTimeStamp, reviewText, likes, replies) VALUES (1, 1, 1, '09/27/2022', 'Amazing car!', 0, 1);
INSERT INTO Review_E (id, userId, carId, dateTimeStamp, reviewText, likes, replies) VALUES (2, 2, 3, '09/28/2022', 'This car should not exist.', 100, 12);

