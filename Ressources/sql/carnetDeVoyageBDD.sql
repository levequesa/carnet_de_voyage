--
-- Création de la base de données
--
CREATE DATABASE voyage;

--
-- Création des users
-- Même noms que les profils dans github
--

CREATE USER 'voyageur'@'localhost' IDENTIFIED WITH caching_sha2_password BY 'voyage';

--
-- Attribution des droits
--

GRANT ALL ON voyage.* TO  'voyageur'@'localhost';

--
-- Remonté des droits
--

FLUSH PRIVILEGES;
