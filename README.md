# grafana-playground


### Run Grafana & Prometheus Container
```bash
docker compose up -d
 ```

### Example Get REST API
```bash
curl http://localhost:8080/hello
```

### Example GraphQL Query
```bash
curl -X POST -H "Content-Type: application/json" -d '{"query": "{ hello }"}' http://localhost:8080/graphql
```

### Prometheus URL from Grafana Container
http://prometheus:9090

### Grafana Example Query (Average requests per second)
```bash
sum(rate(http_server_requests_seconds_count{method="GET", status="200"}[1m]))
```