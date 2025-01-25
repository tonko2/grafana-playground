package com.example.grafana.controller;

import graphql.GraphQL;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class GraphQLController {

  private final GraphQL graphQL;

  @PostMapping("/graphql")
  public Map<String, Object> graphqlEndpoint(@RequestBody Map<String, String> request) {

    String query = request.get("query");

    if (query == null || query.isEmpty()) {
      throw new IllegalArgumentException("GraphQL query is required");
    }

    return graphQL.execute(query).getData();
  }
}
