package com.example.grafana.config;

import static graphql.Scalars.GraphQLString;

import graphql.GraphQL;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfig {

  @Bean
  public GraphQL graphQL() {
    // Queryオブジェクトを作成
    GraphQLObjectType queryType =
        GraphQLObjectType.newObject()
            .name("Query")
            .field(
                GraphQLFieldDefinition.newFieldDefinition()
                    .name("hello")
                    .type(GraphQLString)
                    .dataFetcher(environment -> "Hello, GraphQL!") // フィールドのデータを提供
                    .build())
            .build();

    // Mutationオブジェクトを作成（オプション）
    GraphQLObjectType mutationType =
        GraphQLObjectType.newObject()
            .name("Mutation")
            .field(
                GraphQLFieldDefinition.newFieldDefinition()
                    .name("createMessage")
                    .type(GraphQLString)
                    .argument(arg -> arg.name("message").type(GraphQLString))
                    .dataFetcher(environment -> "Created: " + environment.getArgument("message"))
                    .build())
            .build();

    // スキーマを構築
    GraphQLSchema graphQLSchema =
        GraphQLSchema.newSchema()
            .query(queryType) // Queryタイプを設定
            .mutation(mutationType) // Mutationタイプを設定（必要な場合）
            .build();

    // GraphQLインスタンスを作成して返す
    return GraphQL.newGraphQL(graphQLSchema).build();
  }
}
