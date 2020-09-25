
--
-- Table structure for table `article`
--

CREATE TABLE `article` (
  `id` int(11) NOT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `creation` date DEFAULT NULL,
  `nomarticle` varchar(255) DEFAULT NULL,
  `prix` double NOT NULL,
  `unite` varchar(255) DEFAULT NULL,
  `souscategorie` varchar(100) NOT NULL,
  `code` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `article`
--

INSERT INTO `article` (`id`, `categorie`, `creation`, `nomarticle`, `prix`, `unite`, `souscategorie`, `code`) VALUES
(1, '15', '2020-06-03', 'Coca Cola', 1800, '13', '30', 'CCA'),
(33, '15', '2020-06-03', 'Covid Organics', 1500, '13', '30', 'CVO'),
(52, '18', '2020-07-11', 'Souris', 56000, '22', '27', 'SAP');

-- --------------------------------------------------------

--
-- Table structure for table `categorie`
--

CREATE TABLE `categorie` (
  `ID` int(11) NOT NULL,
  `LIBELLE` varchar(4000) NOT NULL,
  `DESCRIPTION` varchar(4000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categorie`
--

INSERT INTO `categorie` (`ID`, `LIBELLE`, `DESCRIPTION`) VALUES
(15, 'Boisson', 'Boisson'),
(16, 'Fourniture de bureau', 'Fourniture de bureau'),
(17, 'Hydrocarbures', 'Hydrocarbures'),
(18, 'Matérielles informatiques', 'Matérielles informatiques');

-- --------------------------------------------------------

--
-- Table structure for table `depot`
--

CREATE TABLE `depot` (
  `id` int(11) NOT NULL,
  `libelle` varchar(4000) NOT NULL,
  `description` varchar(4000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `depot`
--

INSERT INTO `depot` (`id`, `libelle`, `description`) VALUES
(31, 'Grand stock', 'Depot Centrale'),
(32, 'Atelier', 'Depot Secondaire');

-- --------------------------------------------------------

--
-- Table structure for table `facture_client`
--

CREATE TABLE `facture_client` (
  `id` int(11) NOT NULL,
  `orderid` varchar(100) NOT NULL,
  `tiers` int(11) NOT NULL,
  `creation` date NOT NULL,
  `paiementdue` date NOT NULL,
  `modepaiement` int(11) NOT NULL,
  `tva` double NOT NULL,
  `etat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `facture_client`
--

INSERT INTO `facture_client` (`id`, `orderid`, `tiers`, `creation`, `paiementdue`, `modepaiement`, `tva`, `etat`) VALUES
(47, 'FCA 015 6/20', 44, '2020-07-09', '2020-07-16', 1, 20, 1),
(53, 'FCA 015 11/20', 44, '2020-07-11', '2020-07-11', 3, 20, 1),
(56, 'FCA 015 12/20', 44, '2020-07-12', '2020-07-12', 1, 10, 1),
(58, 'FCA 015 7/20', 44, '2020-07-13', '2020-07-13', 1, 20, 1);

-- --------------------------------------------------------

--
-- Table structure for table `facture_client_details`
--

CREATE TABLE `facture_client_details` (
  `id` int(11) NOT NULL,
  `produit` int(11) NOT NULL,
  `description` varchar(4000) NOT NULL,
  `quantite` double NOT NULL,
  `montant` double NOT NULL,
  `facture` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `facture_client_details`
--

INSERT INTO `facture_client_details` (`id`, `produit`, `description`, `quantite`, `montant`, `facture`) VALUES
(48, 1, 'coca bien glacée', 10, 18000, 47),
(49, 33, 'a consommer avec moderation', 12, 22500, 47),
(50, 1, 'rafraichissement', 6, 10800, 47),
(51, 1, 'test', 3, 5400, 47),
(54, 52, 'sous carton, non reconditionné', 10, 560000, 53),
(55, 1, 'coca bien glacé', 10, 18000, 53),
(57, 1, 'test facture', 15, 27000, 56),
(59, 1, 'glacée', 10, 18000, 58);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(60),
(60),
(60);

-- --------------------------------------------------------

--
-- Table structure for table `mode_paiement`
--

CREATE TABLE `mode_paiement` (
  `id` int(11) NOT NULL,
  `libelle` varchar(4000) NOT NULL,
  `description` varchar(4000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mode_paiement`
--

INSERT INTO `mode_paiement` (`id`, `libelle`, `description`) VALUES
(1, 'Chèque', 'Chèque'),
(2, 'Virement', 'Virement'),
(3, 'Espèce', 'Espèce');

-- --------------------------------------------------------

--
-- Table structure for table `mouvement`
--

CREATE TABLE `mouvement` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `reference` varchar(100) NOT NULL,
  `depot` int(11) NOT NULL,
  `designation` text NOT NULL,
  `type` varchar(100) NOT NULL,
  `article` int(11) NOT NULL,
  `entree` double NOT NULL,
  `sortie` double NOT NULL,
  `pu` double NOT NULL,
  `montant` double NOT NULL,
  `etat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mouvement`
--

INSERT INTO `mouvement` (`id`, `date`, `reference`, `depot`, `designation`, `type`, `article`, `entree`, `sortie`, `pu`, `montant`, `etat`) VALUES
(37, '2021-09-06', 'E06-1', 32, 'Test Add', 'entree', 1, 2, 0, 4000, 8000, 0),
(38, '2021-08-06', 'S02-1', 31, 'Test Sortie 1', 'sortie', 1, 0, 1, 40000, 40000, 0),
(39, '2021-09-06', 'E06-2', 31, 'Provision reunion', 'entree', 1, 10, 0, 3200, 32000, 0),
(43, '2020-06-29', 'E', 31, '', 'entree', 1, 8, 0, 1800, 14400, 1);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL,
  `role` varchar(4000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`role_id`, `role`) VALUES
(1, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `sous_categorie`
--

CREATE TABLE `sous_categorie` (
  `ID` int(11) NOT NULL,
  `LIBELLE` varchar(4000) NOT NULL,
  `CATEGORIE_ID` varchar(4000) NOT NULL,
  `DESCRIPTION` varchar(4000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sous_categorie`
--

INSERT INTO `sous_categorie` (`ID`, `LIBELLE`, `CATEGORIE_ID`, `DESCRIPTION`) VALUES
(27, 'Essence', '17', 'Essence'),
(28, 'Gasoil', '17', 'Gasoil'),
(29, 'Graisse', '17', 'Graisse'),
(30, 'Alcoolique', '15', 'Boisson Alcoolique');

-- --------------------------------------------------------

--
-- Table structure for table `tiers`
--

CREATE TABLE `tiers` (
  `id` int(11) NOT NULL,
  `nom` varchar(1000) NOT NULL,
  `adresse` text NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `gerant` text NOT NULL,
  `nif` varchar(500) NOT NULL,
  `stat` varchar(500) NOT NULL,
  `type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tiers`
--

INSERT INTO `tiers` (`id`, `nom`, `adresse`, `email`, `phone`, `gerant`, `nif`, `stat`, `type`) VALUES
(40, 'VIVO ENERGY', 'OUEST AMBOHIJANAHARY', 'vivoenergy@gmail.com', '3323456789', 'Dupond', '50 00056 3456 34', '34 5678 5678 456', '1'),
(44, 'BAOBAB TECHNOLOGY', 'IVH 35 Ter A', 'baobab-technology@gmail.com', '+261345031763', 'ALLISON', '50 00056 3456 34', '34 5678 5678 456', '1');

-- --------------------------------------------------------

--
-- Table structure for table `type_tiers`
--

CREATE TABLE `type_tiers` (
  `id` int(11) NOT NULL,
  `libelle` varchar(100) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `type_tiers`
--

INSERT INTO `type_tiers` (`id`, `libelle`, `description`) VALUES
(1, 'CLIENT', 'CLIENT'),
(2, 'FOURNISSEUR', 'FOURNISSEUR');

-- --------------------------------------------------------

--
-- Table structure for table `unite`
--

CREATE TABLE `unite` (
  `id` int(11) NOT NULL,
  `libelle` varchar(4000) NOT NULL,
  `description` varchar(4000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `unite`
--

INSERT INTO `unite` (`id`, `libelle`, `description`) VALUES
(8, 'Kg', 'Kilogramme'),
(13, 'L', 'Litre'),
(14, 'm', 'Metre'),
(20, 'Sch', 'Sachet'),
(21, 'g', 'Gramme'),
(22, 'Bte', 'Boite'),
(25, 'Sac', 'Sac');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_actif` varchar(255) DEFAULT NULL,
  `user_fullname` varchar(255) DEFAULT NULL,
  `user_projet` varchar(255) DEFAULT NULL,
  `user_shortname` varchar(255) DEFAULT NULL,
  `user_tache` varchar(255) DEFAULT NULL,
  `user_ts` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(4000) NOT NULL,
  `email` varchar(4000) NOT NULL,
  `password` varchar(4000) NOT NULL,
  `name` varchar(4000) NOT NULL,
  `last_name` varchar(3000) NOT NULL,
  `active` varchar(10) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_name`, `email`, `password`, `name`, `last_name`, `active`, `role_id`) VALUES
(7, 'alain', 'rjoealain@gmail.com', '$2a$10$as6zyP4xpYZ1c0CdqjsyQ.gFOp7xFFPFMgtOl3ggvW624CpCQnE8a', 'Joe Alain', 'Tiarilala', '1', 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_etatde_stock`
-- (See below for the actual view)
--
CREATE TABLE `v_etatde_stock` (
`id` varchar(22)
,`article` int(11)
,`depot` int(11)
,`reste` double
,`pu` double
,`montant` int(1)
);

-- --------------------------------------------------------

--
-- Structure for view `v_etatde_stock`
--
DROP TABLE IF EXISTS `v_etatde_stock`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_etatde_stock`  AS  select concat(`a`.`id`,`d`.`id`) AS `id`,`a`.`id` AS `article`,`d`.`id` AS `depot`,sum((`m`.`entree` - `m`.`sortie`)) AS `reste`,`a`.`prix` AS `pu`,0 AS `montant` from ((`mouvement` `m` join `article` `a` on((`m`.`article` = `a`.`id`))) join `depot` `d` on((`m`.`depot` = `d`.`id`))) group by `a`.`id`,`d`.`id`,`a`.`prix` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `depot`
--
ALTER TABLE `depot`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `facture_client`
--
ALTER TABLE `facture_client`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `facture_client_details`
--
ALTER TABLE `facture_client_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mode_paiement`
--
ALTER TABLE `mode_paiement`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mouvement`
--
ALTER TABLE `mouvement`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `sous_categorie`
--
ALTER TABLE `sous_categorie`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tiers`
--
ALTER TABLE `tiers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_tiers`
--
ALTER TABLE `type_tiers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `unite`
--
ALTER TABLE `unite`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `userd`
--
ALTER TABLE `userd`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `article`
--
ALTER TABLE `article`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `depot`
--
ALTER TABLE `depot`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `facture_client`
--
ALTER TABLE `facture_client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT for table `facture_client_details`
--
ALTER TABLE `facture_client_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT for table `mode_paiement`
--
ALTER TABLE `mode_paiement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `sous_categorie`
--
ALTER TABLE `sous_categorie`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `tiers`
--
ALTER TABLE `tiers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `type_tiers`
--
ALTER TABLE `type_tiers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `unite`
--
ALTER TABLE `unite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;


--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--
