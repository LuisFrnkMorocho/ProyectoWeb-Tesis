package ec.edu.ctrlsolutions;

import javax.faces.webapp.FacesServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.sun.faces.config.ConfigureListener;

@SpringBootApplication
@ComponentScan("ec.edu.ctrlsolutions")
@EnableJpaRepositories("ec.edu.ctrlsolutions.repository")
@EntityScan("ec.edu.ctrlsolutions.model")
public class CtrlsolutionsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CtrlsolutionsWebApplication.class, args);
	}

	@SuppressWarnings("rawtypes")
	@Bean
	public ServletRegistrationBean facesServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
		registration.setLoadOnStartup(1);
		registration.addUrlMappings("*.jsf");
		return registration;
	}

	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return servletContext -> {
			servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
			servletContext.setInitParameter("primefaces.FONT_AWESOME", "true");
			servletContext.setInitParameter("javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE",
					"true");
			//servletContext.setInitParameter("primefaces.THEME", "bootstrap");
		};
	}

	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<>(new ConfigureListener());
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
