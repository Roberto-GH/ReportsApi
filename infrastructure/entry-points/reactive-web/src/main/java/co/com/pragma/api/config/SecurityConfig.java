package co.com.pragma.api.config;

import co.com.pragma.api.constants.ReportsWebKeys;
import co.com.pragma.api.jwt.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;

@Configuration
@EnableReactiveMethodSecurity
public class SecurityConfig {

  private final SecurityContextRepository securityContextRepository;
  private final ServerAccessDeniedHandler accessDeniedHandler;

  public SecurityConfig(SecurityContextRepository securityContextRepository, ServerAccessDeniedHandler accessDeniedHandler) {
    this.securityContextRepository = securityContextRepository;
    this.accessDeniedHandler = accessDeniedHandler;
  }

  @Bean
  public SecurityWebFilterChain filterChain(ServerHttpSecurity http, JwtFilter jwtFilter) {
    return http
      .csrf(ServerHttpSecurity.CsrfSpec::disable)
      .authorizeExchange(exchangeSpec -> exchangeSpec
        .pathMatchers(ReportsWebKeys.ALLOWED_PATHS)
        .permitAll()
        .anyExchange()
        .authenticated())
      .addFilterAfter(jwtFilter, SecurityWebFiltersOrder.FIRST)
      .exceptionHandling(spec -> spec.accessDeniedHandler(accessDeniedHandler))
      .securityContextRepository(securityContextRepository)
      .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
      .formLogin(ServerHttpSecurity.FormLoginSpec::disable)
      .logout(ServerHttpSecurity.LogoutSpec::disable)
      .build();
  }
}

