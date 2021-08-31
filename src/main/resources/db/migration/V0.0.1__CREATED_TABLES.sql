DROP TABLE IF EXISTS public.address;
CREATE TABLE public.address
(
    id             bigserial    NOT NULL,
    zip_code       varchar(255) NULL,
    state          varchar(255) NULL,
    city           varchar(255) NULL,
    street_address varchar(255) NULL,
    number         int          NULL,
    complement     varchar(255) NULL,
    neighborhood   varchar(255) NULL,
    type_address   varchar(255) NULL,
    person_id      int8         NULL,
    CONSTRAINT address_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.file_storage;
CREATE TABLE public.file_storage
(
    id          bigserial    NOT NULL,
    doc_type    varchar(255) NULL,
    name        varchar(255) NULL,
    description varchar(255) NULL,
    path        varchar(255) NULL,
    file_type   varchar(255) NULL,
    person_id   int8         NULL,
    CONSTRAINT file_storage_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.naturalness;
CREATE TABLE public.naturalness
(
    id        bigserial    NOT NULL,
    country   varchar(255) NULL,
    state     varchar(255) NULL,
    city      varchar(255) NULL,
    person_id int8         NOT NULL,
    CONSTRAINT naturalness_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.person;
CREATE TABLE public.person
(
    id                   bigserial      NOT NULL,
    number_id            varchar(255)   NULL,
    fiscal_number        varchar(255)   NULL,
    name                 varchar(255)   NULL,
    birth_date           timestamp      NULL,
    patrimony            numeric(19, 2) NULL,
    politically_exposed  bool           NULL,
    monthly_income       numeric(19, 2) NULL,
    gender               varchar(255)   NULL,
    marital_status       varchar(255)   NULL,
    schooling            varchar(255)   NULL,
    card_type            varchar(255)   NULL,
    issuing_agency       varchar(255)   NULL,
    shipping_date        varchar(255)   NULL,
    maternal_affiliation varchar(255)   NULL,
    paternal_affiliation varchar(255)   NULL,
    name_spouse          varchar(255)   NULL,
    fiscal_number_spouse varchar(255)   NULL,
    password             varchar(255)   NULL,
    person_biro_id       int8           NULL,
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.professional_data;
CREATE TABLE public.professional_data
(
    id         bigserial    NOT NULL,
    occupation varchar(255) NOT NULL,
    company    varchar(255) NULL,
    person_id  int8         NOT NULL,
    CONSTRAINT professional_data_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.contact_detail;
CREATE TABLE public.contact_detail
(
    id        bigserial    NOT NULL,
    email     varchar(255) NOT NULL,
    phone     varchar(255) NULL,
    person_id int8         NOT NULL,
    CONSTRAINT contact_detail_pkey PRIMARY KEY (id)
);
