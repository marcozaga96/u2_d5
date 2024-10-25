CREATE TABLE "utente"(
    "id" UUID NOT NULL,
    "username" VARCHAR(255) NOT NULL,
    "nome e cognome" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "utente" ADD PRIMARY KEY("id");
CREATE TABLE "edeificio"(
    "id" UUID NOT NULL,
    "nome" VARCHAR(255) NOT NULL,
    "indirizzo" VARCHAR(255) NOT NULL,
    "citta" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "edeificio" ADD PRIMARY KEY("id");
CREATE TABLE "postazione"(
    "id" UUID NOT NULL,
    "descrizione" VARCHAR(255) NOT NULL,
    "tipo" VARCHAR(255) CHECK
        ("tipo" IN('')) NOT NULL,
        "numero di occupanti" BIGINT NOT NULL
);
ALTER TABLE
    "postazione" ADD PRIMARY KEY("id");
CREATE TABLE "prenotazione"(
    "id" UUID NOT NULL,
    "giorno" DATE NOT NULL
);
ALTER TABLE
    "prenotazione" ADD PRIMARY KEY("id");
ALTER TABLE
    "postazione" ADD CONSTRAINT "postazione_id_foreign" FOREIGN KEY("id") REFERENCES "prenotazione"("id");
ALTER TABLE
    "prenotazione" ADD CONSTRAINT "prenotazione_id_foreign" FOREIGN KEY("id") REFERENCES "utente"("id");
ALTER TABLE
    "postazione" ADD CONSTRAINT "postazione_id_foreign" FOREIGN KEY("id") REFERENCES "edeificio"("id");