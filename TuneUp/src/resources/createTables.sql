/**
 * Author:  bemccandless
 * Created: May 8, 2017
 */
DROP TABLE maintenance_items;
DROP TABLE vehicles;

CREATE TABLE vehicles (
    id int not null generated always as identity,
    driver varchar (30) not null,
    make varchar (20) not null,
    model varchar (20) not null,
    "year" int not null,
    mileage int not null,

    PRIMARY KEY (id)
);

CREATE TABLE maintenance_items (
    id int not null generated always as identity,
    vehicle_id int not null,
    "TYPE" varchar (50) not null,
    mileage int not null,
    service_date date not null,
    price varchar(50) not null,

    PRIMARY KEY (id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
    
);

-- add vehicles
insert into vehicles (driver, make, model, "year", mileage)
    values ('Brian', 'Honda', 'Civic', 2005, 166000);
insert into vehicles (driver, make, model, "year", mileage)
    values ('Amy', 'Honda', 'Odyssey', 2003, 257000);
insert into vehicles (driver, make, model, "year", mileage)
    values ('Bruce', 'Toyota', 'Corolla', 1992, 344000);
insert into vehicles (driver, make, model, "year", mileage)
    values ('Margie', 'Ford', 'Focus', 2017, 3200);
insert into vehicles (driver, make, model, "year", mileage)
    values ('Bill', 'Ford', 'F-150', 2001, 97000);

-- add maintenance items for vehicles
insert into maintenance_items (vehicle_id, "TYPE", mileage, service_date, price)
    values (1, 'Oil Change', 163222, date('2017-02-14'), '$35.67');
insert into maintenance_items (vehicle_id, "TYPE", mileage, service_date, price)
    values (1, 'New Tires', 155778, date('2015-11-02'), '$408.98');
insert into maintenance_items (vehicle_id, "TYPE", mileage, service_date, price)
    values (1, 'Tire Rotation', 161220, date('2016-03-27'), '$5.99');

insert into maintenance_items (vehicle_id, "TYPE", mileage, service_date, price)
    values (2, 'Oil Change', 47548, date('2016-07-28'), '$38.40');
insert into maintenance_items (vehicle_id, "TYPE", mileage, service_date, price)
    values (2, 'Air Filter Replacement', 47548, date('2016-07-28'), '$12.00');

insert into maintenance_items (vehicle_id, "TYPE", mileage, service_date, price)
    values (3, 'Brake Replacement', 33741, date('2017-05-10'), '$76.05');

select * from tuneup.MAINTENANCE_ITEMS;
select * from tuneup.VEHICLES;