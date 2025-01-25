package com.example.grafana.graphql;

import static graphql.Scalars.GraphQLString;

import graphql.schema.DataFetcher;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;

public class Mutation {

  public static GraphQLObjectType mutationType() {
    return GraphQLObjectType.newObject()
        .name("Mutation")
        .field(
            GraphQLFieldDefinition.newFieldDefinition()
                .name("createMessage")
                .type(GraphQLString)
                .argument(arg -> arg.name("message").type(GraphQLString))
                .dataFetcher(createMessageFetcher())
                .build())
        .build();
  }

  private static DataFetcher<String> createMessageFetcher() {
    return environment -> "Created: " + environment.getArgument("message");
  }
}
