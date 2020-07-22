package springboot.TestSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class OverhaulSecurityConfiguration {
    @Bean
    public AuthenticationManager authenticationManager() {
		return null;
        // ...
    }
    @Bean
    public AccessDecisionManager accessDecisionManager() {
        // ...
    	return null;
    }
    @Bean
    public SecurityFilterChain mySecurityFilterChain() {
        // ...
    	return null;
    }
    // 其他web安全相关组件和依赖配置}
}