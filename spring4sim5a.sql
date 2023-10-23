-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 23 oct. 2023 à 02:28
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `spring4sim5a`
--

-- --------------------------------------------------------

--
-- Structure de la table `bloc`
--

CREATE TABLE `bloc` (
  `idbloc` bigint(20) NOT NULL,
  `capacitybloc` bigint(20) NOT NULL,
  `nombloc` varchar(255) DEFAULT NULL,
  `chambre_idchambre` bigint(20) DEFAULT NULL,
  `foyer_idfoyer` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

CREATE TABLE `chambre` (
  `idchambre` bigint(20) NOT NULL,
  `numchmbre` bigint(20) NOT NULL,
  `typec` enum('DOUBLE','SIMPLE','TRIPLE') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `chambre_reservations`
--

CREATE TABLE `chambre_reservations` (
  `chambre_idchambre` bigint(20) NOT NULL,
  `reservations_idreservation` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `idetudiant` bigint(20) NOT NULL,
  `cin` bigint(20) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `ecole` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `prenome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant_res`
--

CREATE TABLE `etudiant_res` (
  `etudiant_idetudiant` bigint(20) NOT NULL,
  `res_idreservation` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `foyer`
--

CREATE TABLE `foyer` (
  `idfoyer` bigint(20) NOT NULL,
  `capacity_foyer` bigint(20) NOT NULL,
  `nom_foyer` varchar(255) DEFAULT NULL,
  `universite_iduniversite` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `idreservation` bigint(20) NOT NULL,
  `anneuniversaire` datetime(6) DEFAULT NULL,
  `estvalide` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reservation_seq`
--

CREATE TABLE `reservation_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `reservation_seq`
--

INSERT INTO `reservation_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `universite`
--

CREATE TABLE `universite` (
  `iduniversite` bigint(20) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `nomnivercsite` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `bloc`
--
ALTER TABLE `bloc`
  ADD PRIMARY KEY (`idbloc`),
  ADD KEY `FKa4oc9hi2hu3g8dw0tns9yfg7r` (`chambre_idchambre`),
  ADD KEY `FKgvhuyo6h2aah1sljdudfw5ped` (`foyer_idfoyer`);

--
-- Index pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD PRIMARY KEY (`idchambre`);

--
-- Index pour la table `chambre_reservations`
--
ALTER TABLE `chambre_reservations`
  ADD PRIMARY KEY (`chambre_idchambre`,`reservations_idreservation`),
  ADD UNIQUE KEY `UK_t7aaacb4er9in18s8oiba318n` (`reservations_idreservation`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`idetudiant`);

--
-- Index pour la table `etudiant_res`
--
ALTER TABLE `etudiant_res`
  ADD PRIMARY KEY (`etudiant_idetudiant`,`res_idreservation`),
  ADD KEY `FK2c4uaqvl8gsldkjonlr0ndln6` (`res_idreservation`);

--
-- Index pour la table `foyer`
--
ALTER TABLE `foyer`
  ADD PRIMARY KEY (`idfoyer`),
  ADD UNIQUE KEY `UK_np2g8nknquxoghkeubyylb9ue` (`universite_iduniversite`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`idreservation`);

--
-- Index pour la table `universite`
--
ALTER TABLE `universite`
  ADD PRIMARY KEY (`iduniversite`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `bloc`
--
ALTER TABLE `bloc`
  MODIFY `idbloc` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `chambre`
--
ALTER TABLE `chambre`
  MODIFY `idchambre` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `idetudiant` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `foyer`
--
ALTER TABLE `foyer`
  MODIFY `idfoyer` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `universite`
--
ALTER TABLE `universite`
  MODIFY `iduniversite` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `bloc`
--
ALTER TABLE `bloc`
  ADD CONSTRAINT `FKa4oc9hi2hu3g8dw0tns9yfg7r` FOREIGN KEY (`chambre_idchambre`) REFERENCES `chambre` (`idchambre`),
  ADD CONSTRAINT `FKgvhuyo6h2aah1sljdudfw5ped` FOREIGN KEY (`foyer_idfoyer`) REFERENCES `foyer` (`idfoyer`);

--
-- Contraintes pour la table `chambre_reservations`
--
ALTER TABLE `chambre_reservations`
  ADD CONSTRAINT `FK500r2uf7dm9anpgd5rhdex9my` FOREIGN KEY (`chambre_idchambre`) REFERENCES `chambre` (`idchambre`),
  ADD CONSTRAINT `FKlv1gq4cchoyjx2fptfpr2rkre` FOREIGN KEY (`reservations_idreservation`) REFERENCES `reservation` (`idreservation`);

--
-- Contraintes pour la table `etudiant_res`
--
ALTER TABLE `etudiant_res`
  ADD CONSTRAINT `FK2c4uaqvl8gsldkjonlr0ndln6` FOREIGN KEY (`res_idreservation`) REFERENCES `reservation` (`idreservation`),
  ADD CONSTRAINT `FKgo16328f2pw0efvt1gde79dwl` FOREIGN KEY (`etudiant_idetudiant`) REFERENCES `etudiant` (`idetudiant`);

--
-- Contraintes pour la table `foyer`
--
ALTER TABLE `foyer`
  ADD CONSTRAINT `FKqunhi3mfu3d5t8y9cpxd3murd` FOREIGN KEY (`universite_iduniversite`) REFERENCES `universite` (`iduniversite`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
