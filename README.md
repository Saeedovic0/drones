# Drones | Demo Spring Boot Project :fire:
[Project Description](./task-description.pdf) 

♪ Pre-requisites:
>Install docker compose: https://docs.docker.com/compose/install

---
### Build/Run:
Clone the repo and navigate to the project directory then run:
```shell
$ docker-compose up
```
The docker compose file contains a postgres database and the main backend service, the database container `postgres-db` will be up and running on port `5432` and the service container `drones-service` will be accessible via port `8080`.

---
 ### Test:
 You can test all endpoints using this [Postman Collection](drones.postman_collection.json)!

---
#### Suggestions & Improvements:

 - Auto update drone statuses as well as a fall-back scenario in case of failure.
 - Upload static images and files to AWS S3/GCP Cloud Storage or any storage solution.
 - Use a cloud task scheduler for periodic tasks/cron jobs.
 - Achieving a multitenancy service using API gateway auth via `OpenID Connect` IdentityServer4, Keycloak, Firebase Auth, AWS Cognito, etc.)
 - Use a `TSDB` (time series database) like `InfluxDB` for collecting drone sensors' data, a `realtime database` (Firebase realtime DB/Cloud firestore) or `Kafka`for tracking live updates and a NoSQL DB for logging unstructured data like `MongoDB`.
 - Add a `caching` layer if needed for scalability.
 - Leverage `asynchronous`calls via queuing (RabbitMQ, Kafka, AWS SQS, etc.).
 - Determine the best service-to-service calls approach (event-driven, gRPC, REST or Hybrid?).
 - Are you gonna use a cloud-managed service for deployment or it'll be on-premises?
 - Also you can use `ELK`, `Datadog`, `New Relic`, `Sentry`, `Prometheus`, etc. for logging and monitoring different services.
 - For collecting, tracking and redirecting events: `Segment`, `RudderStack`...
---
### Example of an initial [architecture diagram](https://github.com/MekkyUA/egfwd-cloud-project-2/blob/master/diagrams/ha-webapp-cloudformation.drawio.png):
![](https://raw.githubusercontent.com/MekkyUA/egfwd-cloud-project-2/master/diagrams/ha-webapp-cloudformation.drawio.png)

---
[Mahmoud Hamed](https://www.linkedin.com/in/mekkyua) <img src="https://cdn-icons-png.flaticon.com/512/174/174857.png" width="15" height="15">
