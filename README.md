# DAAR Projet 2 ElasticSearch

Hugo GUERRIER 3970839
Emilie SIAU 3700323

## Infos

Le dépôt et la suppression de CV dans la banque de CV fonctionne.
La recherche de terme (ex:"Java") fonctionne dans la banque de CV.
Les logs ont été initiés mais faute de temps, non réalisés.

## Launch the project

Lancer ElasticSearch \
`mvn clean spring-boot:run` \
Tomcat              localhost:8080 \
ElasticSearch       localhost:9200 \

Indexer un CV : POST /api/v1/cvlib?file=MY_FILE \
Rechercher un CV : GET /api/v1/cvlib?q=MY_REQUEST \
Supprimer un CV : DELETE /api/v1/cvlib?id=CV_ID
