INSERT INTO utilisateur (pseudo,password) VALUES
("Xeth","toto"),
("toto","root");

INSERT INTO Priorite (niveau) VALUES
('Haute'),
('Moyenne'),
('Basse');

INSERT INTO Tache (description, valide, priorite_id) VALUES
('Compléter le rapport annuel', FALSE, 1), -- Haute
('Préparer la réunion de projet', FALSE, 2), -- Moyenne
('Mettre à jour le site web', TRUE, 3), -- Basse)
('Organiser l equipe pour le sprint', FALSE, 1); -- Haute

INSERT INTO utilisateur_tache (utilisateur_id, tache_id) VALUES
(1, 1), -- Alice -> Compléter le rapport
(1, 2), -- Alice -> Préparer la réunion
(2, 3), -- Bob -> Mettre à jour le site
(2, 4), -- Claire -> Organiser l'équipe
(2, 4); -- Bob -> Organiser l'équipe


INSERT INTO droit (nom) VALUES
("admin"),
("redacteur"),
("employe");