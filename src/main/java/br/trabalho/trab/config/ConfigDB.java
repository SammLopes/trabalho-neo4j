package br.trabalho.trab.config;


import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigDB {
    
    @Bean("neo4j")
    org.neo4j.cypherdsl.core.renderer.Configuration cypherDslConfiguration() {
        return org.neo4j.cypherdsl.core.renderer.Configuration
        .newConfig()
        .withDialect(Dialect.NEO4J_5).build();
     }


}
