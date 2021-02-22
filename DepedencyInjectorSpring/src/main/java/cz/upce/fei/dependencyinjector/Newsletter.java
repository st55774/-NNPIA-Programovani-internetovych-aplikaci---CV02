package cz.upce.fei.dependencyinjector;

import cz.upce.fei.dependencyinjector.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Newsletter {
    private NewsletterService newsletterService;

    @Autowired
    public Newsletter(NewsletterService newsletterService) {
        this.newsletterService = newsletterService;
    }

    @Bean
    public CommandLineRunner createNewsletter(){
        return args -> newsletterService.registerNewsLetting("ondrej.chrbolka@gmail.com");
    }
}
