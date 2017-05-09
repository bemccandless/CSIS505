/**
 * Author:  bemccandless
 * Created: May 8, 2017
 */
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
