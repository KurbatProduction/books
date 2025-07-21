CREATE TABLE IF NOT EXISTS public.authors (
    id              uuid                        NOT NULL,
    name            varchar(50)                 NOT NULL,
    create_date     timestamp with time zone    NOT NULL    DEFAULT NOW(),
    update_date     timestamp with time zone    NOT NULL    DEFAULT NOW(),
    PRIMARY KEY (id)
)