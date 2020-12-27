# api-ux-back
test for job api-ux
#Instalacion docker image for dataBase

Docker Postgres

docker version 

#console docker


docker pull postgres:10.9-alpine

docker images

docker run -d --name prueba -e POSTGRES_PASSWORD=prueba -p 5432:5432 postgres:10.9-alpine

docker ps -a

docker ps 

docker start id

#install 
pgadmin4-4.29-x64

#In the folder installation (imagesInstalationPgAdmin) images are the images for the configuration of PgAdmin 4

#create table

-- Table: public.activities

-- DROP TABLE public.activities;

CREATE TABLE public.activities
(
    id integer NOT NULL DEFAULT nextval('activities_id_seq'::regclass),
    description character varying(200) COLLATE pg_catalog."default" NOT NULL,
    creation_date date NOT NULL,
    is_active boolean NOT NULL,
    CONSTRAINT activities_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.activities
    OWNER to postgres;
	
