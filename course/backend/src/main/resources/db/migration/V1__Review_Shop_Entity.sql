CREATE TABLE review
(
    id      UUID    NOT NULL,
    text    VARCHAR(255),
    rating  INTEGER NOT NULL,
    shop_id UUID,
    CONSTRAINT pk_review PRIMARY KEY (id)
);

CREATE TABLE shop
(
    id   UUID NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_shop PRIMARY KEY (id)
);

ALTER TABLE review
    ADD CONSTRAINT FK_REVIEW_ON_SHOP FOREIGN KEY (shop_id) REFERENCES shop (id);
