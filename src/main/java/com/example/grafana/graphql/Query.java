package com.example.grafana.graphql;

import static graphql.Scalars.GraphQLString;

import graphql.schema.DataFetcher;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;

public class Query {

  public static GraphQLObjectType queryType() {
    return GraphQLObjectType.newObject()
        .name("Query")
        .field(
            GraphQLFieldDefinition.newFieldDefinition()
                .name("hello")
                .type(GraphQLString)
                .dataFetcher(helloFetcher())
                .build())
        .build();
  }

  private static DataFetcher<String> helloFetcher() {
    return environment -> "Hello, GraphQL!";
  }
}
