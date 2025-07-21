CREATE TABLE IF NOT EXISTS public.books (
    id              uuid                        NOT NULL,
    name            varchar(50)                 NOT NULL,
    description     varchar,
    price           int                         NOT NULL,
    author_id       uuid                        NOT NULL,
    create_date     timestamp with time zone    NOT NULL    DEFAULT NOW(),
    update_date     timestamp with time zone    NOT NULL    DEFAULT NOW(),
    PRIMARY KEY (id),
    CONSTRAINT author_id_fk
        FOREIGN KEY (author_id)
        REFERENCES authors (id)
)