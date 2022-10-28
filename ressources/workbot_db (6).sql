-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 27 oct. 2022 à 21:11
-- Version du serveur : 10.4.25-MariaDB
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `workbot_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `badge`
--

CREATE TABLE `badge` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `candidature`
--

CREATE TABLE `candidature` (
  `id` int(11) NOT NULL,
  `id_offre` int(11) DEFAULT NULL,
  `idcondidat` int(11) DEFAULT NULL,
  `statut` varchar(255) NOT NULL,
  `lettreMotivation` varchar(255) NOT NULL,
  `noteTest` varchar(10) NOT NULL,
  `dateAjout` varchar(250) NOT NULL,
  `Cv` varchar(255) NOT NULL,
  `NiveauFrancais` varchar(255) NOT NULL,
  `NiveauAnglais` varchar(255) NOT NULL,
  `diplome` varchar(255) NOT NULL,
  `dateExpiration` varchar(255) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `TypeCondidature` varchar(255) NOT NULL,
  `Experience` varchar(25) NOT NULL,
  `Domaine` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `candidature`
--

INSERT INTO `candidature` (`id`, `id_offre`, `idcondidat`, `statut`, `lettreMotivation`, `noteTest`, `dateAjout`, `Cv`, `NiveauFrancais`, `NiveauAnglais`, `diplome`, `dateExpiration`, `titre`, `TypeCondidature`, `Experience`, `Domaine`) VALUES
(34, NULL, 1, 'hhh', 'ggg', 'yyy', 'nnn', '', '', '', '', '', '', '', '', ''),
(35, NULL, 1, 'hh', 'hhh', 'tt', '[value-6]', 'xnxx', '', '', '', '', '', '', '', ''),
(36, NULL, 1, 'hh', 'hhh', 'tt', '[value-6]', 'xnxx', '[value-10]', '[value-10]', '', '', '', '', '', ''),
(38, NULL, 1, '[value-4]', '[value-5]', '[value-6]', '[value-7]', '[value-8]', '[value-9]', '[value-10]', '[value-11]', '', '', '', '', ''),
(39, NULL, 1, '[value-4]', '[value-5]', '[value-6]', '[value-7]', '[value-8]', '[value-9]', '[value-10]', '[value-11]', '', '', '', '', ''),
(40, NULL, 1, '[value-4]', '[value-5]', '[value-6]', '[value-7]', '[value-8]', '[value-9]', '[value-10]', '[value-11]', '', '', '', '', ''),
(41, NULL, 1, '[value-4]', '[value-5]', '[value-6]', '[value-7]', '[value-8]', '[value-9]', '[value-10]', '[value-11]', '[value-12]', '[value-13]', '', '', ''),
(42, NULL, 1, '[value-4]', '[value-5]', '[value-6]', '[value-7]', '[value-8]', '[value-9]', '[value-10]', '[value-11]', '[value-12]', '[value-13]', '[value-14]', '[value-15]', '[value-16]'),
(43, 3, 3, 'non traité', 'fhch', ' ', '2022-10-27', 'Browse', 'Notions', 'Notions', 'Electrique', 'gs', 'jgchvjkl', 'offre', 'fch', 'zfe');

-- --------------------------------------------------------

--
-- Structure de la table `captcha`
--

CREATE TABLE `captcha` (
  `id` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `captcha`
--

INSERT INTO `captcha` (`id`, `status`) VALUES
(0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `nomCategorie` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `certification`
--

CREATE TABLE `certification` (
  `id` int(11) NOT NULL,
  `titreCours` varchar(100) NOT NULL,
  `titreTest` varchar(100) NOT NULL,
  `dateAjout` varchar(50) NOT NULL,
  `lien` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `certif_badge`
--

CREATE TABLE `certif_badge` (
  `id_user` int(11) DEFAULT NULL,
  `id_certif` int(11) DEFAULT NULL,
  `id_badge` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `contrat`
--

CREATE TABLE `contrat` (
  `id` int(11) NOT NULL,
  `typeContrat` varchar(100) DEFAULT NULL,
  `dateDebut` date DEFAULT NULL,
  `salaire` varchar(30) DEFAULT NULL,
  `dateFin` date DEFAULT NULL,
  `lien` varchar(300) DEFAULT NULL,
  `id_candidature` int(11) DEFAULT NULL,
  `dateCreation` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE `cours` (
  `id` int(11) NOT NULL,
  `titre` varchar(100) NOT NULL,
  `matiere` varchar(100) NOT NULL,
  `domaine` varchar(200) NOT NULL,
  `categorie` varchar(30) NOT NULL,
  `chemin` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `entretien`
--

CREATE TABLE `entretien` (
  `id` int(11) NOT NULL,
  `date` varchar(55) NOT NULL,
  `lienMeet` varchar(350) NOT NULL,
  `id_candidature` int(11) NOT NULL,
  `heure` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `evennement`
--

CREATE TABLE `evennement` (
  `id` int(11) NOT NULL,
  `dateDebut` varchar(25) NOT NULL,
  `dateFin` varchar(25) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `heureDebut` varchar(30) NOT NULL,
  `heureFin` varchar(30) NOT NULL,
  `nbPlaces` int(11) NOT NULL,
  `prix` varchar(20) DEFAULT NULL,
  `flyer` varchar(300) DEFAULT NULL,
  `video` varchar(300) DEFAULT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `evennement`
--

INSERT INTO `evennement` (`id`, `dateDebut`, `dateFin`, `libelle`, `heureDebut`, `heureFin`, `nbPlaces`, `prix`, `flyer`, `video`, `id_user`) VALUES
(1, '2hfxcgvjnk,', 'datefin', 'dfgh', 'hn', 'b,n;,', 5, 'gfgh', '', '', 4);

-- --------------------------------------------------------

--
-- Structure de la table `offre`
--

CREATE TABLE `offre` (
  `id` int(11) NOT NULL,
  `titre` varchar(300) DEFAULT NULL,
  `salaire` varchar(255) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `domaine` varchar(200) DEFAULT NULL,
  `dateExpiration` varchar(200) DEFAULT NULL,
  `dureeStage` varchar(200) DEFAULT NULL,
  `typeStage` varchar(20) DEFAULT NULL,
  `dureeContrat` varchar(30) DEFAULT NULL,
  `typeContrat` varchar(30) DEFAULT NULL,
  `anneeExperience` varchar(30) DEFAULT NULL,
  `id_Soc` int(11) DEFAULT NULL,
  `modeTravail` varchar(25) DEFAULT NULL,
  `lieu` varchar(250) DEFAULT NULL,
  `id_test` int(11) DEFAULT NULL,
  `typeOffre` varchar(15) DEFAULT NULL,
  `dateAjout` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `offre`
--

INSERT INTO `offre` (`id`, `titre`, `salaire`, `description`, `domaine`, `dateExpiration`, `dureeStage`, `typeStage`, `dureeContrat`, `typeContrat`, `anneeExperience`, `id_Soc`, `modeTravail`, `lieu`, `id_test`, `typeOffre`, `dateAjout`) VALUES
(3, 'jgchvjkl', 'zqefdz', 'zef', 'zfe', 'gs', 'sgs', NULL, NULL, NULL, NULL, 4, NULL, NULL, NULL, 'Stage', '2022-34-44');

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

CREATE TABLE `participation` (
  `id` int(11) NOT NULL,
  `id_event` int(11) NOT NULL,
  `id_userP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation_avis`
--

CREATE TABLE `reclamation_avis` (
  `id` int(11) NOT NULL,
  `objet` varchar(255) DEFAULT NULL,
  `dateAjout` varchar(25) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `image` varchar(300) DEFAULT NULL,
  `note` int(11) DEFAULT NULL,
  `id_categorie` int(11) NOT NULL,
  `id_compte` int(11) NOT NULL,
  `id_societe` int(11) DEFAULT NULL,
  `id_offre` int(11) DEFAULT NULL,
  `id_event` int(11) DEFAULT NULL,
  `id_candidat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `sponsor`
--

CREATE TABLE `sponsor` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `logo` varchar(100) NOT NULL,
  `id_evenement` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `test`
--

CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `titre` varchar(300) NOT NULL,
  `domaine` varchar(50) DEFAULT NULL,
  `description` varchar(350) DEFAULT NULL,
  `lien` varchar(350) NOT NULL,
  `categorie` varchar(100) DEFAULT NULL,
  `id_soc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `prenom` varchar(25) DEFAULT NULL,
  `tel` varchar(30) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `mdp` varchar(30) DEFAULT NULL,
  `adresse` varchar(30) DEFAULT NULL,
  `photo` varchar(300) DEFAULT NULL,
  `questionSecu` varchar(300) DEFAULT NULL,
  `reponseSecu` varchar(300) DEFAULT NULL,
  `methode` varchar(200) DEFAULT NULL,
  `formeJuridique` varchar(300) DEFAULT NULL,
  `raisonSociale` varchar(300) DEFAULT NULL,
  `domaine` varchar(300) DEFAULT NULL,
  `pattente` varchar(300) DEFAULT NULL,
  `nomSociete` varchar(300) DEFAULT NULL,
  `diplome` varchar(300) DEFAULT NULL,
  `experience` varchar(250) DEFAULT NULL,
  `niveauFr` varchar(20) DEFAULT NULL,
  `niveauAng` varchar(20) DEFAULT NULL,
  `competance` varchar(250) DEFAULT NULL,
  `cv` varchar(350) DEFAULT NULL,
  `portfolio` varchar(350) DEFAULT NULL,
  `bio` varchar(500) DEFAULT NULL,
  `typeCandidat` varchar(50) DEFAULT NULL,
  `note` float DEFAULT NULL,
  `role` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='user mohsen';

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `tel`, `email`, `mdp`, `adresse`, `photo`, `questionSecu`, `reponseSecu`, `methode`, `formeJuridique`, `raisonSociale`, `domaine`, `pattente`, `nomSociete`, `diplome`, `experience`, `niveauFr`, `niveauAng`, `competance`, `cv`, `portfolio`, `bio`, `typeCandidat`, `note`, `role`) VALUES
(1, 'nader', 'jardak', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ''),
(2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'sociéte'),
(3, 'ilyes', 'bettaieb', '90446128', 'ilyes.bettaieb@esprit.tn', '12345678', 'nabeul', NULL, 'Quel est votre animal préféré?', 'mohsen', NULL, NULL, NULL, 'info', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'candidat'),
(4, 'nader', ' ', '90446128', 'jardak.nader@esprit.tn', '12345678', 'sfax', NULL, 'Quel est votre animal préféré?', 'mohsen', NULL, NULL, NULL, 'tech', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'sociéte');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `badge`
--
ALTER TABLE `badge`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `candidature`
--
ALTER TABLE `candidature`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idcondidat` (`idcondidat`),
  ADD KEY `id_offre` (`id_offre`);

--
-- Index pour la table `captcha`
--
ALTER TABLE `captcha`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `certification`
--
ALTER TABLE `certification`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `certif_badge`
--
ALTER TABLE `certif_badge`
  ADD KEY `fk_certif` (`id_certif`),
  ADD KEY `fk_user` (`id_user`),
  ADD KEY `fb_badge` (`id_badge`);

--
-- Index pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_candidature` (`id_candidature`);

--
-- Index pour la table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `entretien`
--
ALTER TABLE `entretien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_candidature` (`id_candidature`);

--
-- Index pour la table `evennement`
--
ALTER TABLE `evennement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`);

--
-- Index pour la table `offre`
--
ALTER TABLE `offre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_Soc` (`id_Soc`),
  ADD KEY `id_test` (`id_test`);

--
-- Index pour la table `participation`
--
ALTER TABLE `participation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_participation_event` (`id_event`),
  ADD KEY `fk_participation_user` (`id_userP`);

--
-- Index pour la table `reclamation_avis`
--
ALTER TABLE `reclamation_avis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_avis_categorie` (`id_categorie`),
  ADD KEY `fk_avis_user` (`id_compte`),
  ADD KEY `id_offre` (`id_offre`),
  ADD KEY `id_societe` (`id_societe`);

--
-- Index pour la table `sponsor`
--
ALTER TABLE `sponsor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_sponsor_evennement` (`id_evenement`);

--
-- Index pour la table `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_soc` (`id_soc`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `badge`
--
ALTER TABLE `badge`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `candidature`
--
ALTER TABLE `candidature`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT pour la table `captcha`
--
ALTER TABLE `captcha`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `certification`
--
ALTER TABLE `certification`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `cours`
--
ALTER TABLE `cours`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `entretien`
--
ALTER TABLE `entretien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `evennement`
--
ALTER TABLE `evennement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `offre`
--
ALTER TABLE `offre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `participation`
--
ALTER TABLE `participation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `reclamation_avis`
--
ALTER TABLE `reclamation_avis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `sponsor`
--
ALTER TABLE `sponsor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `test`
--
ALTER TABLE `test`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `candidature`
--
ALTER TABLE `candidature`
  ADD CONSTRAINT `candidature_ibfk_1` FOREIGN KEY (`idcondidat`) REFERENCES `utilisateur` (`id`) ON DELETE SET NULL,
  ADD CONSTRAINT `candidature_ibfk_2` FOREIGN KEY (`id_offre`) REFERENCES `offre` (`id`) ON DELETE SET NULL;

--
-- Contraintes pour la table `certif_badge`
--
ALTER TABLE `certif_badge`
  ADD CONSTRAINT `fb_badge` FOREIGN KEY (`id_badge`) REFERENCES `badge` (`id`) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_certif` FOREIGN KEY (`id_certif`) REFERENCES `certification` (`id`) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`id_user`) REFERENCES `utilisateur` (`id`) ON DELETE SET NULL;

--
-- Contraintes pour la table `entretien`
--
ALTER TABLE `entretien`
  ADD CONSTRAINT `entretien_ibfk_1` FOREIGN KEY (`id_candidature`) REFERENCES `candidature` (`id`);

--
-- Contraintes pour la table `offre`
--
ALTER TABLE `offre`
  ADD CONSTRAINT `offre_ibfk_1` FOREIGN KEY (`id_Soc`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `offre_ibfk_2` FOREIGN KEY (`id_test`) REFERENCES `test` (`id`) ON DELETE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
