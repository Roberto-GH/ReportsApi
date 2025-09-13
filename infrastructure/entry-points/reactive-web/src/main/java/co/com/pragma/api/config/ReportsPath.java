package co.com.pragma.api.config;

import co.com.pragma.api.constants.ReportsWebKeys;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = ReportsWebKeys.PATH_ROUTE_REPORT)
public class ReportsPath {

  private String reports;

}
