# Objectif :

Ce TP vise à comprendre et personnaliser le mécanisme d’authentification de Spring Security.
L’objectif est de remplacer la page de connexion par défaut de Spring par un formulaire HTML personnalisé, tout en gérant :

- les erreurs de connexion,
- les redirections après authentification, la déconnexion,et la différenciation des accès selon les rôles.
  
Ce TP fait suite au TP (authentification en mémoire) et introduit la notion de flux d’authentification contrôlé par l’application.

# Introduction conceptuelle : 

Par défaut, Spring Security fournit une interface de connexion prête à l’emploi, mais très basique.

Dans un contexte professionnel, cette interface doit :

- s’intégrer à l’identité visuelle du site,
- offrir une meilleure ergonomie,
- afficher des messages d’erreur clairs,
- et gérer des redirections adaptées au rôle de l’utilisateur.


Spring Security permet cela sans redéfinir tout le mécanisme d’authentification : il suffit de brancher un formulaire HTML sur les endpoints contrôlés par le framework (/login, /authenticate, /logout, etc.).


# Test complet du flux : 

### Lance l’application :
mvn spring-boot:run

### Ouvre dans ton navigateur :
http://localhost:8080/login

### Teste les connexions :
Utilisateur : user / 1111
Administrateur : admin / 1234

### Observe :
La redirection vers /home après connexion.
Les messages d’erreur ou de déconnexion.
La restriction d’accès : un utilisateur normal ne peut pas accéder à /admin/dashboard.

# Points pédagogiques clés :

- Découplage logique/vue : le traitement d’authentification reste côté serveur (géré par Spring), la présentation est librement personnalisable.
- Simplicité du flux : un seul formulaire HTML peut gérer tout le processus d’authentification.
- Sécurité contrôlée : Spring gère automatiquement la session, les cookies et la protection CSRF.
- Flexibilité : on peut facilement ajouter un comportement dynamique selon le rôle (ex : redirection conditionnelle).

# DEMO : 

<img width="1659" height="834" alt="Capture d&#39;écran 2025-11-24 233630" src="https://github.com/user-attachments/assets/ef10f45d-b99f-4cad-a7a0-302bc354eb6d" />

<img width="731" height="437" alt="Capture d&#39;écran 2025-11-24 233653" src="https://github.com/user-attachments/assets/f2a608b4-a6a5-4ed6-8e15-86a0bcea9a75" />

<img width="1253" height="687" alt="Capture d&#39;écran 2025-11-24 233726" src="https://github.com/user-attachments/assets/0603bd92-9b53-49cb-a2c8-d0bd54915d79" />

<img width="713" height="247" alt="Capture d&#39;écran 2025-11-24 233719" src="https://github.com/user-attachments/assets/cee82583-e438-4d9c-8715-cf01705f09da" />


# Résumé du TP : 

- Création d’un formulaire d’authentification HTML.
- Intégration du formulaire à Spring Security via /authenticate.
- Gestion des messages d’erreur et de déconnexion.
- Mise en place de redirections personnalisées après connexion.
- Vérification du bon fonctionnement des filtres de sécurité.
  
