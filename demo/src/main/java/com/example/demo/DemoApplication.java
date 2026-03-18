package com.example.demo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		loadEnv();
		SpringApplication.run(DemoApplication.class, args);
	}

	private static void loadEnv() {
		try {
			// Obtenemos la ruta absoluta del .class y subimos hasta demo/
			java.net.URI uri = DemoApplication.class
					.getProtectionDomain()
					.getCodeSource()
					.getLocation()
					.toURI();

			java.io.File classesDir = new java.io.File(uri);  // .../demo/target/classes
			String projectDir = classesDir
					.getParentFile()  // target
					.getParentFile()  // demo  ← aquí está el .env
					.getAbsolutePath();

			System.out.println("Buscando .env en: " + projectDir); // Para verificar la ruta

			Dotenv dotenv = Dotenv.configure()
					.directory(projectDir)
					.filename(".env")
					.load();

			System.setProperty("DB_URL", dotenv.get("DB_URL"));
			System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
			System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

		} catch (Exception e) {
			throw new RuntimeException("Error cargando el .env: " + e.getMessage(), e);
		}
	}
}
