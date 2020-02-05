CREATE TABLE posts(
    id UUID PRIMARY KEY,
    name VARCHAR(255),
);

CREATE TABLE comments(
    id UUID PRIMARY KEY,
    body VARCHAR(255),
    post_id UUID NOT NULL REFERENCES posts,
);
