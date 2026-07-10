# Scripts de démarrage

```bash
# Infrastructure
mvn spring-boot:run -pl config_server -DskipTests
mvn spring-boot:run -pl discovery_service -DskipTests
mvn spring-boot:run -pl api_gateway -DskipTests

# Métier
mvn spring-boot:run -pl actualite -DskipTests
mvn spring-boot:run -pl admin -DskipTests
mvn spring-boot:run -pl coursenligne -DskipTests
mvn spring-boot:run -pl devoir -DskipTests
mvn spring-boot:run -pl domaine -DskipTests
mvn spring-boot:run -pl email -DskipTests
mvn spring-boot:run -pl empoiDuTemps -DskipTests
mvn spring-boot:run -pl Encadrement/encadrement -DskipTests
mvn spring-boot:run -pl Encadreur/encadreur -DskipTests
mvn spring-boot:run -pl enligne -DskipTests
mvn spring-boot:run -pl Enseignant/enseignant -DskipTests
mvn spring-boot:run -pl Etudiant/etudiant -DskipTests
mvn spring-boot:run -pl filiere -DskipTests
mvn spring-boot:run -pl historique -DskipTests
mvn spring-boot:run -pl matiere -DskipTests
mvn spring-boot:run -pl memoire -DskipTests
mvn spring-boot:run -pl messagerie -DskipTests
mvn spring-boot:run -pl moyenne -DskipTests
mvn spring-boot:run -pl niveau -DskipTests
mvn spring-boot:run -pl note -DskipTests
mvn spring-boot:run -pl notification -DskipTests
mvn spring-boot:run -pl organigramme -DskipTests
mvn spring-boot:run -pl presence -DskipTests
mvn spring-boot:run -pl president -DskipTests
mvn spring-boot:run -pl profile -DskipTests
mvn spring-boot:run -pl progression -DskipTests
mvn spring-boot:run -pl quiz -DskipTests
mvn spring-boot:run -pl semestre -DskipTests
mvn spring-boot:run -pl slides -DskipTests
mvn spring-boot:run -pl univesitaire -DskipTests
mvn spring-boot:run -pl utilisateur -DskipTests
mvn spring-boot:run -pl visio -DskipTests
```

Exécute la commande du module que tu veux depuis `/home/tahiry/Projects/React/siteEtec/backend/`.
