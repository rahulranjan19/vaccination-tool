CREATE TABLE IF NOT EXISTS beneficiary (
    bid character varying(255) NOT NULL,
    parentid character varying(255),
    signedup character varying(255),
    govid character varying(255),
    govidtype character varying(255),
    dob timestamp,
    pwd character varying(255),
    fname character varying(255),
    mname character varying(255),
    lname character varying(255),
    gender character varying(255),
    add1 character varying(255),
    add2 character varying(255),
    city character varying(255),
    state character varying(255),
    pincode int4,
    primary key (bid)
);

CREATE TABLE IF NOT EXISTS center (
    centerid character varying(255) NOT NULL,
    name character varying(255),
    address1 character varying(255),
    address2 character varying(255),
    city character varying(255),
    state character varying(255),
    pincode int4,
    primary key (centerid)
);

CREATE TABLE IF NOT EXISTS vaccine (
    vaccineid character varying(255) NOT NULL,
    name character varying(255),
    manufacturer character varying(255),
    cost decimal,
    primary key (vaccineid)
);

CREATE TABLE IF NOT EXISTS register (
    bid character varying(255) NOT null,
    vaccineid character varying(255) NOT NULL,
    centerid character varying(255) NOT NULL,
    status character varying(255),
    date timestamp,
    dosage int4,
    primary key (bid, vaccineid),
    CONSTRAINT bid_fkey FOREIGN KEY(bid) REFERENCES beneficiary(bid) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE,
    CONSTRAINT centerid_fkey FOREIGN KEY(centerid) REFERENCES center(centerid) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE,
    CONSTRAINT vaccineid_fkey FOREIGN KEY(vaccineid) REFERENCES vaccine(vaccineid) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS center_vaccine (
    centerid character varying(255) NOT NULL,
    vaccineid character varying(255) NOT NULL,
    quantity bigint,
    CONSTRAINT centerid_vaccine_fkey FOREIGN KEY(centerid) REFERENCES center(centerid) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE,
    CONSTRAINT vaccineid_vaccine_fkey FOREIGN KEY(vaccineid) REFERENCES vaccine(vaccineid) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE
);