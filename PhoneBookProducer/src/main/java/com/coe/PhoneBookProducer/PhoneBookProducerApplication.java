package com.coe.PhoneBookProducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhoneBookProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneBookProducerApplication.class, args);
	}

}
/*
Producer

1. Crear la funcion que obtiene el json.
2. Obtener el Json en la funcion.
3. Parsear el json a un objeto(Tal vez lo hace en automatico).
4. Envia el objeto con su respectivo topic a nuestro consumer.
 */

/*
 Consumer
5. Obtener el objeto en nuestro consumer. En nuestra funcion de KafkaListener.
6. Leer el objeto en nuestra funcion y pasarla a un objeto DTO.
7. Instanciar un nuevo objeto de nuestro ENTIDAD.
8. Mappear nuetro DTO a nuestra instancia de la entidad.
9. Asegurarnos que nuestros datos están correctos.
10. Guardar con el repository nuestra entidad.
 */

