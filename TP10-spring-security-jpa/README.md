# Objectif :

Ce TP vise à remplacer l’authentification en mémoire utilisée dans les TP précédents par une authentification basée sur base de données.
L’étudiant apprend à :

- créer une base MySQL contenant des utilisateurs et des rôles,
- configurer Spring Data JPA pour accéder à ces données,
- utiliser un UserDetailsService personnalisé pour charger les utilisateurs depuis la base,
- et sécuriser les mots de passe à l’aide de BCrypt, un algorithme de hachage robuste.
  
L’enjeu est de rendre le système d’authentification persistant, réaliste et sécurisé, comme dans une application de production.

# Introduction conceptuelle :

Dans les TPs précédents, les utilisateurs étaient stockés en mémoire (via InMemoryUserDetailsManager).
Cette méthode, bien que pratique pour les tests, est temporaire : les comptes disparaissent dès que l’application s’arrête.

Pour une application réelle, les utilisateurs et leurs rôles doivent être stockés dans une base de données relationnelle.
Spring Security permet cela grâce à JPA (Java Persistence API) et un service d’authentification personnalisé, qui interroge la base pour charger les informations au moment du login.

# Pré-requis techniques :

- Avoir Java 17+, MySQL et Spring Boot 3.x.
- Avoir terminé les TP1 et TP2 de Spring Security.
- Comprendre les bases de JPA (entités, relations, repositories).

# Test du flux complet : 

### Lance le projet :
mvn spring-boot:run

### Ouvre ton navigateur à :
http://localhost:8080/login

### Teste les identifiants :
- admin / 1234 → accès à /admin/dashboard
- user / 1111 → accès à /user/dashboard
  
### Vérifie dans MySQL :
Les tables user, role, et user_roles ont été créées.
Les mots de passe sont bien encodés (chaîne longue avec $2a$).

# Points pédagogiques essentiels :

- Persistance : les utilisateurs sont maintenant sauvegardés en base, contrairement aux TP précédents.
- Sécurité : les mots de passe sont encodés avec BCrypt.
- Scalabilité : cette approche est extensible à des systèmes d’enregistrement, d’inscription et d’authentification OAuth2.
- Architecture : séparation nette entre couche entité, repository, service et sécurité.

# Synthèse du TP :

Ce TP permet de comprendre comment Spring Security interagit avec une base de données pour authentifier les utilisateurs de manière réelle et sécurisée.
L’étudiant apprend à gérer :

- la création d’une base d’utilisateurs et de rôles,
- la configuration d’un service de chargement d’utilisateurs personnalisé,
- l’utilisation d’un encodeur de mot de passe robuste,
- et la mise en œuvre d’un flux complet d’authentification persistante.
  
<img width="779" height="264" alt="image" src="https://github.com/user-attachments/assets/df61ea47-01aa-474d-8525-72372311135d" />
