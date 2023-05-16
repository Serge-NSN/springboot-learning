package nsn.demo.springboot.tutorial.nsnspringproject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@SpringBootApplication
class NsnspringprojectApplication {
	@Bean
	fun corsConfig(): CorsFilter {
		val config = CorsConfiguration()
		config.addAllowedOrigin("http://192.168.142.99:54075")
		config.addAllowedOrigin("http://localhost:54075")
		config.addAllowedOrigin("http://127.0.0.1:54075")
		config.addAllowedHeader("*")
		val source = UrlBasedCorsConfigurationSource()
		source.registerCorsConfiguration("/actuator/**", config)
		return CorsFilter(source)
	}
}

fun main(args: Array<String>) {
	runApplication<NsnspringprojectApplication>(*args)
}
