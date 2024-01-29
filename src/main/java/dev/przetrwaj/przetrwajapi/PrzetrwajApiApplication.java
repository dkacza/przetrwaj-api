package dev.przetrwaj.przetrwajapi;

import dev.przetrwaj.przetrwajapi.resource.type.ResourceType;
import dev.przetrwaj.przetrwajapi.resource.type.ResourceTypeRepository;
import dev.przetrwaj.przetrwajapi.resource.type.ResourceTypeService;
import dev.przetrwaj.przetrwajapi.resource.type.Units;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PrzetrwajApiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PrzetrwajApiApplication.class, args);
        ResourceTypeService bean = context.getBean(ResourceTypeService.class);

        bean.addResourceType(new ResourceType("Woda","pszna", Units.LITERS));
        bean.addResourceType(new ResourceType("Worki z Piaskiem","też pszne", Units.PIECES));
        bean.addResourceType(new ResourceType("Chleb","czerstwy", Units.PIECES));
        bean.addResourceType(new ResourceType("Ubrania","pszne", Units.KILOGRAMS));
        bean.addResourceType(new ResourceType("Apteczki","tego nie jedz", Units.PIECES));
        bean.addResourceType(new ResourceType("Benzyna","pszna", Units.LITERS));

    }


}
