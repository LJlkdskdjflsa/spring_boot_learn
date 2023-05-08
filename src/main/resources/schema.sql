CREATE TABLE IF NOT EXISTS Content (
    id SERIAL PRIMARY KEY ,
    title varchar(255) NOT NULL,
    description text,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    date_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    url VARCHAR(255)
);