package tn.esprit.spring4sim5.configuration;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());
    }
    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("TP étude de cas")
                .contact(contactAPI());
    }
    public Contact contactAPI() {
        Contact contact = new Contact().name("Equipe ASI II")
                .email("aymen.zouaoui@esprit.tn")
                .url("https://www.instagram.com/aymenzouaoui16/");
        return contact;
    }
    @Bean
    public GroupedOpenApi EtudiantPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Etudiant Management API")
                .pathsToMatch("/etudiant/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi UniversityPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only University Management API")
                .pathsToMatch("/universites/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi ReservationsPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Reservations Management API")
                .pathsToMatch("/reservations/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi FoyerPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Foyer Management API")
                .pathsToMatch("/foyers/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi BlocsPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Blocs Management API")
                .pathsToMatch("/blocs/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi ChambresPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Chambres Management API")
                .pathsToMatch("/chambres/**")
                .pathsToExclude("**")
                .build();
    }
}