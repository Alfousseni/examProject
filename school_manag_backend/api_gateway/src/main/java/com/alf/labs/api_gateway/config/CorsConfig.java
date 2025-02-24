//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.web.cors.reactive.CorsWebFilter;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.List;
//
//@Configuration
//public class CorsConfig implements WebMvcConfigurer {
//
////    @Bean
////    public CorsWebFilter corsFilter() {
////        CorsConfiguration config = new CorsConfiguration();
//////        config.setAllowedOrigins(List.of("http://localhost:4200")); // Remplace "*" par l'URL de ton frontend si nécessaire
//////        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//////        config.setAllowedHeaders(List.of("*"));
//////        config.setAllowCredentials(true);
////        config.addAllowedOrigin("*");
////        config.addAllowedMethod("*");
////        config.addAllowedHeader("*");
////        config.setAllowCredentials(true);
////
////        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////        source.registerCorsConfiguration("/**", config);
////
////        return new CorsWebFilter(source);
////    }
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                .allowedHeaders("*")
//                .allowCredentials(true);
//    }
//}
