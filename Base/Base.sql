-- CREATE DATABASE pharmapro;
-- \c pharmacie;


-- -- CREATE TABLE Clients(
-- --     IdClient INT PRIMARY KEY,
-- --     NomClient VARCHAR(255),
-- -- );


-- CREATE TABLE Fournisseur(
--     IdFournisseur VARCHAR(50) PRIMARY KEY,
--     NomFournisseur VARCHAR(50),
--     AdresseFournisseur VARCHAR(100)
-- );

-- CREATE TABLE Unite(
--     IdUnite SERIAL PRIMARY KEY,
--     NomUnite VARCHAR(50)
-- );

-- CREATE TABLE Aspect(
--     IdAspect SERIAL PRIMARY KEY,
--     NomAspect VARCHAR(50)
-- );

-- CREATE TABLE Categorie(
--     IdCategorie SERIAL PRIMARY KEY,
--     NomCategorie VARCHAR(50)
-- );

-- CREATE TABLE SousCategorie(
--     IdSousCategorie SERIAL PRIMARY KEY,
--     NomSousCategorie VARCHAR(50)
-- );

-- CREATE TABLE CategorieSousCategorie(
--     IdCategorie SERIAL PRIMARY KEY,
--     IdSousCategorie INT,
--     FOREIGN KEY (IdCategorie) REFERENCES Categorie(IdCategorie),
--     FOREIGN KEY (IdSousCategorie) REFERENCES SousCategorie(IdSousCategorie)
-- );

-- CREATE TABLE Produit(
--     IdProduit VARCHAR(50) PRIMARY KEY,
--     NomProduit VARCHAR(50),
--     PrixProduit DECIMAL(10,2),
--     PRIMARY KEY (IdProduit),
--     IdFournisseur VARCHAR(50),
--     Date_fabrication DATE,
--     Description TEXT,
--     FOREIGN KEY (IdFournisseur) REFERENCES Fournisseur(IdFournisseur),
--     FOREIGN KEY (IdCategorie) REFERENCES Categorie(IdCategorie)
-- );

-- -- CREATE TABLE CategorieETSousCategorieProduit(
-- --     IdCategorie VARCHAR(50),
-- --     IdSousCategorie VARCHAR(50),
-- --     IdProduit VARCHAR(50),
-- --     FOREIGN KEY (IdCategorie) REFERENCES Categorie(IdCategorie),
-- --     FOREIGN KEY (IdSousCategorie) REFERENCES SousCategorie(IdSousCategorie),
-- --     FOREIGN KEY (IdProduit) REFERENCES Produit(IdProduit)
-- -- );

-- CREATE TABLE SousCategorieProduit(
--     IdSousCategorie INT,
--     IdSousCategorie VARCHAR(50),
--     IdProduit VARCHAR(50),
--     FOREIGN KEY (IdSousCategorie) REFERENCES SousCategorie(IdSousCategorie),
--     FOREIGN KEY (IdProduit) REFERENCES Produit(IdProduit)
-- );


-- CREATE TABLE AspectProduit(
--     IdAspectProduit VARCHAR(50) PRIMARY KEY,
--     IdAspect VARCHAR(50),
--     IdProduit VARCHAR(50),
--     FOREIGN KEY (IdAspect) REFERENCES Aspect(IdAspect),
--     FOREIGN KEY (IdProduit) REFERENCES Produit(IdProduit),
-- );


-- CREATE TABLE Approvisionnement(
--     IdApprovisionnement VARCHAR(50) PRIMARY KEY,
--     IdProduit VARCHAR(50),
--     DateApprovisionnement DATE,
--     FOREIGN KEY (IdProduit) REFERENCES Produit(IdProduit)
    
-- );

-- CREATE TABLE ApprovisonnementDetails(
--     IdApprovsionnementDetails VARCHAR(50) PRIMARY KEY,
--     IdApprovisionnement VARCHAR(50),
--     IdFournisseur VARCHAR(50),
--     Quantite DECIMAL(10,2),
--     Prix DECIMAL(10,2),
--     Total DECIMAL(10,2),
--     FOREIGN KEY (IdApprovisionnement) REFERENCES Approvisionnement(IdApprovisionnement),
--     FOREIGN KEY (IdFournisseur) REFERENCES Fournisseur(IdFournisseur),
--     FOREIGN KEY (IdProduit) REFERENCES Produit(IdProduit)?
--     DatePeremption DATE
-- );

-- CREATE TABLE Vente(
--     IdVente VARCHAR(50) PRIMARY KEY,
--     PRIMARY KEY (IdVente),
--     DateVente TIMESTAMP DEFAULT NOW(),
-- );

-- CREATE TABLE DetailsVente(
--     IdDetailsVente VARCHAR(50),
--     IdDetails VARCHAR(50),
--     IdVente INT PRIMARY KEY,
--     IdProduit VARCHAR(50),
--     Quantite INT,
--     Prix DECIMAL(10,2),
--     Total DECIMAL(10,2),
--     IdUnite INT,
--     FOREIGN KEY (IdVente) REFERENCES Vente(IdVente)
-- );

-- -- CREATE TABLE Maladie(
-- --     IdMaladie VARCHAR(50),
-- --     NomMaladie VARCHAR(50),
-- --     Symptomes Text,
    
-- -- );

-- -- CREATE TABLE MaladieSousCategore(
-- --     IdMaladie VARCHAR(50),
-- --     IdSousCategorie VARCHAR(50),
-- --     FOREIGN KEY (IdMaladie) REFERENCES Maladie(IdMaladie),
-- --     FOREIGN KEY (IdSousCategorie) REFERENCES SousCategorie(IdSousCategorie)
-- -- );


CREATE DATABASE pharmapro;
\c pharmapro;

-- Table Fournisseur
CREATE TABLE Fournisseur(
    IdFournisseur VARCHAR(50) PRIMARY KEY,
    NomFournisseur VARCHAR(50),
    AdresseFournisseur VARCHAR(100)
);

-- Table Unite
CREATE TABLE Unite(
    IdUnite SERIAL PRIMARY KEY,
    NomUnite VARCHAR(50)
);

-- Table Aspect
CREATE TABLE Aspect(
    IdAspect SERIAL PRIMARY KEY,
    NomAspect VARCHAR(50)
);

-- Table Categorie
CREATE TABLE Categorie(
    IdCategorie SERIAL PRIMARY KEY,
    NomCategorie VARCHAR(50)
);

-- Table SousCategorie
CREATE TABLE SousCategorie(
    IdSousCategorie SERIAL PRIMARY KEY,
    NomSousCategorie VARCHAR(50)
);

-- Table Produit
CREATE TABLE Produit(
    IdProduit VARCHAR(50) PRIMARY KEY,
    NomProduit VARCHAR(50),
    PrixProduit DECIMAL(10,2),
    IdFournisseur VARCHAR(50),
    IdCategorie INT,
    Date_fabrication DATE,
    Description TEXT,
    FOREIGN KEY (IdFournisseur) REFERENCES Fournisseur(IdFournisseur),
    FOREIGN KEY (IdCategorie) REFERENCES Categorie(IdCategorie)
);

-- Table CategorieSousCategorie
CREATE TABLE CategorieSousCategorie(
    IdCategorie INT,
    IdSousCategorie INT,
    FOREIGN KEY (IdCategorie) REFERENCES Categorie(IdCategorie),
    FOREIGN KEY (IdSousCategorie) REFERENCES SousCategorie(IdSousCategorie)
);

-- Table SousCategorieProduit
CREATE TABLE SousCategorieProduit(
    IdSousCategorie INT,
    IdProduit VARCHAR(50),
    FOREIGN KEY (IdSousCategorie) REFERENCES SousCategorie(IdSousCategorie),
    FOREIGN KEY (IdProduit) REFERENCES Produit(IdProduit)
);

-- Table AspectProduit
CREATE TABLE AspectProduit(
    IdAspectProduit VARCHAR(50) PRIMARY KEY,
    IdAspect INT,
    IdProduit VARCHAR(50),
    FOREIGN KEY (IdAspect) REFERENCES Aspect(IdAspect),
    FOREIGN KEY (IdProduit) REFERENCES Produit(IdProduit)
);

-- Table Approvisionnement
CREATE TABLE Approvisionnement(
    IdApprovisionnement VARCHAR(50) PRIMARY KEY,
    IdProduit VARCHAR(50),
    DateApprovisionnement DATE,
    FOREIGN KEY (IdProduit) REFERENCES Produit(IdProduit)
);

-- Table ApprovisionnementDetails
CREATE TABLE ApprovisionnementDetails(
    IdApprovisionnementDetails VARCHAR(50) PRIMARY KEY,
    IdProduit VARCHAR(50),
    IdApprovisionnement VARCHAR(50),
    IdFournisseur VARCHAR(50),
    Quantite DECIMAL(10,2),
    Prix DECIMAL(10,2),
    Total DECIMAL(10,2),
    DatePeremption DATE,
    FOREIGN KEY (IdApprovisionnement) REFERENCES Approvisionnement(IdApprovisionnement),
    FOREIGN KEY (IdFournisseur) REFERENCES Fournisseur(IdFournisseur),
    FOREIGN KEY (IdProduit) REFERENCES Produit(IdProduit)
);

-- Table Vente
CREATE TABLE Vente(
    IdVente VARCHAR(50) PRIMARY KEY,
    DateVente TIMESTAMP DEFAULT NOW()
);

-- Table DetailsVente
CREATE TABLE DetailsVente(
    IdDetailsVente VARCHAR(50) PRIMARY KEY,
    IdVente VARCHAR(50),
    IdProduit VARCHAR(50),
    Quantite INT,
    Prix DECIMAL(10,2),
    Total DECIMAL(10,2),
    IdUnite INT,
    FOREIGN KEY (IdVente) REFERENCES Vente(IdVente),
    FOREIGN KEY (IdProduit) REFERENCES Produit(IdProduit),
    FOREIGN KEY (IdUnite) REFERENCES Unite(IdUnite)
);


