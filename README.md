# TP-BDDGRAPH

Voici mon TP1 MVC :

Reprise du TP sur l'utilisation des interfaces graphiques sous swing avec interaction aux bases de données. Création de la base de données de l'applicationProcéder à la création de la base de données suivante à partir de l'outil **PHPMyadmin**s :


Nom de la BDD : bddgraph
----------
* bac
  * `idBac` int(11)
  * `libele` varchar(15)
* etudiant
  * `idEtu` int(50) NOT NULL,
  * `nom` varchar(35) NOT NULL,
  * `prenom` varchar(20) NOT NULL,
  * `dateNaiss` date NOT NULL,
  * `lieuNaiss` varchar(50) NOT NULL,
  * `sexe` varchar(50) NOT NULL,
  * `hobbies` varchar(50) NOT NULL,
  * `nationalite` varchar(50) NOT NULL,
  * `rue` varchar(50) NOT NULL,
  * `cp` varchar(50) NOT NULL,
  * `ville` varchar(30) NOT NULL,
  * `telephone` varchar(12) NOT NULL,
  * `mail` varchar(20) NOT NULL,
  * `niveau` varchar(20) NOT NULL,
  * `idFil` int(11) NOT NULL,
  * `idBac` int(11) NOT NULL
* filiere
  * `idFil` int(11) NOT NULL,
  * `nom` varchar(30) NOT NULL
* utilisateur
  * `id` int(11) NOT NULL,
  * `mail` varchar(50) NOT NULL,
  * `login` varchar(50) NOT NULL,
  * `password` varchar(50) NOT NULL 



Règles du tp non respectées :
----------
1. Avant de quitter l'application, on doit demander confirmation à l'utilisateur
2. Une fois la saisie est réalisée, les données seront insérées dans la table "etudiant". (à cause d'une erreur )
3. Prévoir un traitement qui permet d'afficher la liste de tous les étudiants dans un JTable.

>Erreur rencontrées : 
```
Parameter index out of range (2 > number of parameters, which is 1).
```
```
Data truncation: Incorrect integer value: 'DÃ©butant' for column bddgraph.etudiant.idFil at row 1
```


