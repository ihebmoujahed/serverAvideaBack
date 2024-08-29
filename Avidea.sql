CREATE TABLE contrat (
    id_contrat SERIAL PRIMARY KEY,
    numero_contrat VARCHAR(255),
    datedebut DATE,
    datefin DATE,
    nom_assure VARCHAR(255),
    numero_immatriculation VARCHAR(255)
);
CREATE TABLE sinistre (
    id_sinistre SERIAL PRIMARY KEY,
    numero_sinistre INT,
    date_accident DATE,
    date_creation DATE,
    status VARCHAR(255) DEFAULT 'Ouvert',
    id_contrat INT,
);
CREATE TABLE photo (
    id_photo SERIAL PRIMARY KEY,
    photo BYTEA ,
    id_sinistre int,
);
