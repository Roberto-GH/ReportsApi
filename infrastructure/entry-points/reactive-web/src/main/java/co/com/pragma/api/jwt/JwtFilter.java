package co.com.pragma.api.jwt;

import co.com.pragma.api.constants.ReportsWebKeys;
import co.com.pragma.api.exception.AuthenticationApiException;
import co.com.pragma.model.report.exception.ErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

@Component
public class JwtFilter implements WebFilter {

  private static final Logger LOG = LoggerFactory.getLogger(JwtFilter.class);

  @Override
  @NonNull
  public Mono<Void> filter(ServerWebExchange exchange, @NonNull WebFilterChain chain) {
    ServerHttpRequest request = exchange.getRequest();
    String path = request.getPath().value();
    LOG.info("Path filter jwt => {}", path);
    if (path.contains(ReportsWebKeys.STRING_AUTH) || path.contains(ReportsWebKeys.STRING_SWAGGER) || path.contains(ReportsWebKeys.STRING_DOCS) ||
        path.contains(ReportsWebKeys.STRING_WEBJARS) || path.contains(ReportsWebKeys.STRING_ACTUATOR)) {
      return chain.filter(exchange);
    }
    String auth = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
    if(auth == null)
      return Mono.error(new AuthenticationApiException(ErrorEnum.INVALID_TOKEN, ReportsWebKeys.NO_TOKEN));
    if(!auth.startsWith(ReportsWebKeys.BEARER))
      return Mono.error(new AuthenticationApiException(ErrorEnum.INVALID_TOKEN, ReportsWebKeys.INVALID_TOKEN));
    String token = auth.replace(ReportsWebKeys.BEARER, ReportsWebKeys.STRING_BLANK);
    exchange.getAttributes().put(ReportsWebKeys.TOKEN, token);
    return chain.filter(exchange);
  }

}
