--IdFournisseur+1
CREATE SEQUENCE fournisseur_seq START 1;

CREATE OR REPLACE FUNCTION next_fournisseur_id()
RETURNS TEXT AS $$
BEGIN
    RETURN 'FOR' || LPAD(nextval('fournisseur_seq'), 3, '0');
END;
$$ LANGUAGE plpgsql;

-- CREATE SEQUENCE Categorie_seq START 1;

-- CREATE OR REPLACE FUNCTION next_Categorie_id()
-- RETURNS TEXT AS $$
-- BEGIN
--     RETURN 'CATEG' || LPAD(nextval('Categorie_seq'), 3, '0'); 
-- END;
-- $$ LANGUAGE plpgsql;


--IdSousCategorie+1
-- CREATE SEQUENCE SousCategorie_seq START 1;

-- CREATE OR REPLACE FUNCTION next_SousCategorie_id()
-- RETURNS TEXT AS $$
-- BEGIN
--     RETURN 'CAT' || LPAD(nextval('SousCategorie_seq'), 3, '0'); 
-- END;
-- $$ LANGUAGE plpgsql;

CREATE SEQUENCE Vente_seq START 1;

CREATE OR REPLACE FUNCTION next_Vente_id()
RETURNS TEXT AS $$
BEGIN
    RETURN 'VEN' || LPAD(nextval('Vente_seq'), 3, '0'); 
END;
$$ LANGUAGE plpgsql;


CREATE SEQUENCE DetailsVente_seq START 1;

CREATE OR REPLACE FUNCTION next_DetailsVente_id()
RETURNS TEXT AS $$
BEGIN
    RETURN 'VENDT' || LPAD(nextval('DetailsVente_seq'), 3, '0'); 
END;
$$ LANGUAGE plpgsql;


-- Création de la séquence pour Approvisionnement
CREATE SEQUENCE Approvisionnement_seq START 1;

-- Fonction pour générer l'ID Approvisionnement
CREATE OR REPLACE FUNCTION next_Approvisionnement_id()
RETURNS TEXT AS $$
BEGIN 
    RETURN 'APP' || LPAD(nextval('Approvisionnement_seq')::TEXT, 3, '0');
END;
$$ LANGUAGE plpgsql;

-- Création de la séquence pour ApprovisionnementDetails
CREATE SEQUENCE ApprovisionnementDetails_seq START 1;

-- Fonction pour générer l'ID ApprovisionnementDetails
CREATE OR REPLACE FUNCTION next_ApprovisionnementDetails_id()
RETURNS TEXT AS $$
BEGIN 
    RETURN 'APPDT' || LPAD(nextval('ApprovisionnementDetails_seq')::TEXT, 3, '0');
END;
$$ LANGUAGE plpgsql;



CREATE SEQUENCE Produit_seq START 1;

CREATE OR REPLACE FUNCTION next_Produit_id()
RETURNS TEXT AS $$
BEGIN
    RETURN 'PRO' || LPAD(nextval('Produit_seq'), 3, '0'); 
END;
$$ LANGUAGE plpgsql;