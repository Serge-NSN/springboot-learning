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
		config.addAllowedOrigin("http://192.168.65.99:4200")
		config.addAllowedOrigin("http://localhost:4200")
		config.addAllowedMethod("POST")
		config.addAllowedMethod("GET")
		config.addAllowedHeader("*")
		val source = UrlBasedCorsConfigurationSource()
		source.registerCorsConfiguration("/**", config)
		return CorsFilter(source)
	}
}

fun main(args: Array<String>) {
	runApplication<NsnspringprojectApplication>(*args)
}
