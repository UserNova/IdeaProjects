package ma.ens.tp8monitoring.service;

import io.micrometer.core.instrument.Metrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private static final Logger logger = LoggerFactory.getLogger(DemoService.class);

    public String processData() {
        Metrics.counter("custom.requests.count").increment();
        logger.info("Démarrage du traitement des données");
        try {
            Thread.sleep(500); // Simulation d’un traitement
        } catch (InterruptedException e) {
            logger.error("Erreur dans le traitement", e);
        }
        logger.info("Traitement terminé avec succès");
        logger.info("Requête enregistrée dans Prometheus"); // log supplémentaire si tu veux le voir dans application.log
        return "Traitement effectué";
    }
}