/**
 * Author:  bemccandless
 * Created: May 8, 2017
 */
DROP TABLE vehicles;
DROP TABLE maintenance_items;

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

select * from tuneup.MAINTENANCE_ITEMS;
select * from tuneup.VEHICLES;