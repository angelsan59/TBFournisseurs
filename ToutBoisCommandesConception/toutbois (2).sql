-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 17 Janvier 2017 à 13:56
-- Version du serveur :  10.1.16-MariaDB
-- Version de PHP :  5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `toutbois`
--

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id_com` int(11) NOT NULL,
  `date_com` date NOT NULL,
  `date_livr` date NOT NULL,
  `statut` varchar(50) NOT NULL,
  `code_fou` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `code_fou` int(11) NOT NULL,
  `enseigne` varchar(50) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `cp` varchar(50) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `pays` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` int(11) NOT NULL,
  `siret` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `fournit`
--

CREATE TABLE `fournit` (
  `code_fou` int(11) NOT NULL,
  `code_prod` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ligne_commande`
--

CREATE TABLE `ligne_commande` (
  `qte` int(11) DEFAULT NULL,
  `id_com` int(11) NOT NULL,
  `code_prod` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `code_prod` int(11) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `pu` double DEFAULT NULL,
  `remise` float DEFAULT NULL,
  `qte_stock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`code_prod`, `designation`, `image`, `pu`, `remise`, `qte_stock`) VALUES
(1, 'chaise empire', 'chaise.JPG', 19, 2, 20),
(6, 'armoire vitrée', 'armoire.jpg', 179, 3, 20),
(7, 'armoire verte', 'armoire2.jpg', 150, 0, 4),
(8, 'banc bouleau', 'banc.jpg', 20, 0, 10),
(9, 'bibliothèque', 'bibliotheque.JPG', 60, 6, 30),
(10, 'grande bibliothèque', 'bibliotheque2.JPG', 179, 0, 10),
(11, 'buffet brut', 'buffet2.JPG', 200, 4, 5),
(13, 'buffet blanc', 'buffetblanc.JPG', 60, 2, 5),
(14, 'bureau classique', 'bureau.JPG', 50, 10, 15),
(15, 'bureau gris', 'bureau2.JPG', 50, 10, 5),
(16, 'bureau moderne', 'bureau3.JPG', 40, 0, 10),
(17, 'chaise foncée', 'chaise2.JPG', 15, 0, 10),
(18, 'chaise blanche naturel', 'chaise3.JPG', 15, 2, 10),
(19, 'chaise classique', 'chaise4.JPG', 12, 0, 15),
(20, 'commode moderne', 'commode.JPG', 150, 15, 20),
(21, 'commode classique large', 'commode2.JPG', 150, 15, 12),
(22, 'commode foncée étroite', 'commode3.JPG', 80, 12, 12),
(23, 'commode naturelle classique large', 'commode4.JPG', 160, 14, 20),
(24, 'desserte moderne naturel', 'desserte.JPG', 70, 3, 20),
(25, 'grande bibliothèque de coin foncée', 'gdebibliotheque.JPG', 200, 10, 2),
(26, 'meuble bas moderne', 'meublebas.JPG', 80, 0, 20),
(27, 'bibliothèque étroite casiers', 'minibibli.JPG', 70, 15, 5),
(28, 'table basse petite claire', 'minitable.JPG', 20, 0, 20),
(29, 'penderie classique naturel', 'penderie.JPG', 100, 10, 10),
(30, 'secrétaire empire noir', 'secretaire.JPG', 80, 5, 5),
(31, 'table blanche', 'table.JPG', 60, 2, 8),
(32, 'table basse naturel plateau', 'tablebasse.JPG', 70, 1, 10),
(33, 'table carrée foncée', 'tablecarree.JPG', 60, 0, 10),
(34, 'table de chevet classique naturel', 'tablechevet.JPG', 50, 3, 5),
(35, 'table de chevet verte plateau naturel', 'tablechevet2.JPG', 50, 5, 6),
(36, 'table pour ordinateur blanche plateau naturel', 'tableordi.JPG', 50, 0, 15),
(37, 'table à rabats naturel', 'tablerabats.JPG', 80, 6, 13),
(38, 'étagère de coin', 'tabletteangle.JPG', 40, 0, 6);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id_com`);

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`code_fou`);

--
-- Index pour la table `ligne_commande`
--
ALTER TABLE `ligne_commande`
  ADD PRIMARY KEY (`id_com`,`code_prod`),
  ADD KEY `FK_contenir_code_prod` (`code_prod`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`code_prod`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id_com` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `code_fou` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `code_prod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `ligne_commande`
--
ALTER TABLE `ligne_commande`
  ADD CONSTRAINT `FK_contenir_code_prod` FOREIGN KEY (`code_prod`) REFERENCES `produit` (`code_prod`),
  ADD CONSTRAINT `FK_contenir_id_com` FOREIGN KEY (`id_com`) REFERENCES `commande` (`id_com`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
