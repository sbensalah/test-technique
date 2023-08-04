-- Subscription type could be FIX or MOBILE. (in java code, it is represented by an ENUM with two values(FIX, MOBILE) ).
-- Field address : For more details, the field "address" could be represented in another table(id, city, post_code, street). So then, it is 
-- a @OneToOne join with client table or even @OneToMany join if the client has many addresses.
create table clients 
( 
	id bigint NOT NULL,
	first_name character varying(255),
	last_name character varying(255),
	birth_date date,
	address character varying(255)
);

-- client_id : contains id of clients. It is the column of join tables. (in java, it is represented by the annotation "@OneToMany").
create table subscriptions 
( 
	id bigint NOT NULL,
	type character varying(255),  
	phone_number integer,
	adresse_installation character varying(255),
	box_number integer,
	name_offer character varying(255),
	client_id bigint
);
-- An option contains at least one field for identification. For example its name.
-- subscriptions_id : contains id of subscriptions. It is the column of join tables. (in java, it is represented by the annotation "@OneToMany").
create table options 
( 
	id bigint NOT NULL,
	name character varying(255),
	subscriptions_id bigint
);

-- Under option contains at least one field for identification. For example its name.
-- options_id : contains id of options. It is the column of join tables. (in java, it is represented by the annotation "@OneToMany").
create table under_options 
( 
	id bigint NOT NULL,
	name character varying(255),
	options_id bigint
);
