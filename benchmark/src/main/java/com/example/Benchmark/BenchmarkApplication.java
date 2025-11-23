package com.example.Benchmark;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.IOException;
import java.net.URI;

public class BenchmarkApplication {

    // URL de base pour le serveur
    public static final String BASE_URI = "http://localhost:8080/";

    // EntityManagerFactory Hibernate
    private static EntityManagerFactory emf;

    public static void main(String[] args) throws IOException {
        // Initialiser Hibernate
        emf = Persistence.createEntityManagerFactory("benchmarkPU");
        System.out.println("Hibernate EntityManagerFactory créé.");

        // Configurer Jersey avec les packages contenant tes ressources @Path
        final ResourceConfig rc = new ResourceConfig()
                .packages("com.example.Benchmark.controller"); // <- mettre ici ton package

        // Lancer le serveur Grizzly
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
        System.out.println("Server started at " + BASE_URI);
        System.out.println("Press enter to stop...");

        // Attendre que l'utilisateur appuie sur Entrée
        System.in.read();

        // Arrêter le serveur et fermer Hibernate
        server.shutdownNow();
        emf.close();
        System.out.println("Server stopped and Hibernate closed.");
    }

    // Getter pour EntityManagerFactory si nécessaire dans tes DAOs
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
