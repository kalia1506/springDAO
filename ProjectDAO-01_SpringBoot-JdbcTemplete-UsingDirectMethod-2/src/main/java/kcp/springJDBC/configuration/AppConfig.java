package kcp.springJDBC.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ PresisatnceConfig.class, ServiceConfig.class })
public class AppConfig {
	
}
