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

INSERT INTO Car_E (id, make, model, releaseYear, fuelType, price, vehicleType, hp, mileage, colour, transmission) VALUES
(1, 'BMW', '316', 2011, 'Diesel', 6800, 'Sedan', 116, 235000, 'Pearl', 'Manual');
INSERT INTO Car_E (id, make, model, releaseYear, fuelType, price, vehicleType, hp, mileage, colour, transmission) VALUES
(2, 'Volkswagen', 'Golf', 2011, 'Gasoline', 6877, 'Hatchback', 122, 92800, 'Yellow', 'Manual');
INSERT INTO Car_E (id, make, model, releaseYear, fuelType, price, vehicleType, hp, mileage, colour, transmission) VALUES
(3, 'SEAT', 'Exeo', 2011, 'Gasoline', 6900, 'Hatchback', 160, 149300, 'Silver', 'Manual');
-- data from https://www.kaggle.com/datasets/ander289386/cars-germany

INSERT INTO Review_E (id, userId, dateTimeStamp, likes, replies) VALUES (1, 1, '09/27/2022', 0, 1);
INSERT INTO Review_E (id, userId, dateTimeStamp, likes, replies) VALUES (2, 2, '09/28/2022', 100, 12);

