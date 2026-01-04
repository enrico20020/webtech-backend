package htwwebtech.webtech;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc // Ermöglicht das Testen der API-Endpunkte ohne den Server echt zu starten
class WebtechApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		// Dieser Standard-Test prüft nur, ob die App überhaupt startet
	}

	@Test
	public void testGetAllProducts() throws Exception {
		// Prüft Use-Case: Alle Produkte anzeigen
		mockMvc.perform(get("/api/products"))
				.andExpect(status().isOk());
	}

	@Test
	public void testCreateProductValidation() throws Exception {
		// Prüft die Anforderung: Input-Validierung
		// Wir senden einen leeren Namen, was laut @NotBlank verboten ist
		String invalidProductJson = "{\"name\": \"\", \"price\": 9.99}";

		mockMvc.perform(post("/api/products")
						.contentType(MediaType.APPLICATION_JSON)
						.content(invalidProductJson))
				.andExpect(status().isBadRequest()); // Erwartet 400 Bad Request
	}
}