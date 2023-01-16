package com.example.cassandraTTL;

import com.datastax.oss.driver.api.core.session.Session;
import com.example.cassandraTTL.connection.DataStaxAstraProperties;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.ReactiveSession;
import org.springframework.data.cassandra.ReactiveSessionFactory;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.ReactiveCassandraTemplate;
import org.springframework.data.cassandra.core.ReactiveInsertOperation;
import org.springframework.data.cassandra.core.cql.ReactiveCqlTemplate;

import java.nio.file.Path;

@SpringBootApplication
@EnableConfigurationProperties(DataStaxAstraProperties.class)
@OpenAPIDefinition(info = @Info(
		title = "Cassandra TTL application",
		version = "1.0",
		description = "Cassandra TTL Service"
))
public class CassandraTtlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CassandraTtlApplication.class, args);
	}

	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
		Path bundle = astraProperties.getSecureConnectBundle().toPath();
		return builder -> builder.withCloudSecureConnectBundle(bundle);
	}

	@Bean
	public ReactiveCqlTemplate reactiveCqlTemplate(ReactiveSession reactiveSession) {
		return new ReactiveCqlTemplate(reactiveSession);
	}

}
