INSERT INTO Fournisseur(IdFournisseur,NomFournisseur,AdresseFournisseur) VALUES
    (next_fournisseur_id(), 'HomeoPharma','AmbanyAtsimo'),
    (next_fournisseur_id(), 'Pharmacie de la Gare','Analakely');

INSERT INTO Categorie(NomCategorie) VALUES
    ('Medicament Avec ordonnance'),
    ('Medicament Sans ordonnance'),
    ('Parapharmacie'),
    ('Sante et Bien etre'),
    ('Jeune et Maman'),
    ('Premiers Soins'),
    ('Pathologie Specifique'),
    ('Produit saisonniers');


INSERT INTO SousCategorie(IdSousCategorie,NomSousCategorie) VALUES
    ('Antibiotiques'),
    ('Psychotropes'),
    ('Digestif'),
    ('Hypolipémiants'),
    ('Antihypertenseurs'),
    ('Antidiabétiques'),
    ('Antidouleurs'),
    ('Soins de la peau'),
    ('Hygiene'),
    ('Capillaires'),
    ('Bucco-dentaires'),
    ('Complements alimentaires'),
    ('Aromatherapie'),
    ('Desinfectants'),
    ('Materiel'),
    ('Maux de gorge'),
