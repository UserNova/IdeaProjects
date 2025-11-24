# Objectif :
L’objectif de ce TP est de comprendre comment déléguer l’authentification d’une application Spring Boot à un fournisseur externe tel que Google ou Keycloak en utilisant le protocole OAuth2 et la norme OpenID Connect (OIDC).
L’utilisateur ne s’authentifie plus directement auprès de l’application, mais auprès d’un service d’identité de confiance, qui délivre un token d’accès (Access Token) et un token d’identité (ID Token).

Cette approche correspond aux pratiques modernes utilisées dans les architectures distribuées, les API sécurisées, et les systèmes Single Sign-On (SSO).

# Compétences développées : 

À la fin de ce TP, l’étudiant sera capable de :

- Expliquer les principes et acteurs du protocole OAuth2.
- Configurer une application Spring Boot en tant que client OAuth2.
- Mettre en place une authentification avec Google ou Keycloak .
- Extraire et afficher les informations du profil utilisateur à partir du token d’identité.
- Comprendre le flux complet d’autorisation et les notions de redirection et scopes.

# Test et validation :

1- Lancer l’application.
2- Accéder à http://localhost:8080/profile.
3- Le système redirige automatiquement vers la page de connexion Google ou Keycloak.
4- Après authentification, la page profile.html affiche le nom, l’email et la photo.

# DEMO : 

<img width="930" height="572" alt="Capture d&#39;écran 2025-11-24 225415" src="https://github.com/user-attachments/assets/0c72a987-f642-4ba9-85a6-2c345d456662" />


# Conclusion : 

Ce TP permet de comprendre comment externaliser l’authentification d’une application Spring Boot tout en maintenant une sécurité robuste et standardisée.
Grâce à OAuth2 et OpenID Connect, l’application ne gère plus directement les identifiants utilisateurs : elle délègue cette responsabilité à un fournisseur de confiance, améliorant ainsi la sécurité, la scalabilité et la conformité de l’ensemble du système.
