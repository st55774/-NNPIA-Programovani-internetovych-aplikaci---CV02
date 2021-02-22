package cz.upce.fei.dependencyinjector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public final class NewsletterService {
    private HTMLSeparatorService htmlSeparatorService;
    private InputValidatorService inputValidatorService;

    @Autowired
    public NewsletterService(HTMLSeparatorService htmlSeparatorService, InputValidatorService inputValidatorService) {
        this.htmlSeparatorService = htmlSeparatorService;
        this.inputValidatorService = inputValidatorService;
    }

    public void registerNewsLetting(final String email){
        if(!inputValidatorService.checkEmail(email))
            System.out.println("Cannot register. Your email is wrong!");

        System.out.println("You are now register to newsletting.");
    }

    public void registerFromExternalSource(final String url){
        String htmlContent;
        try {
            htmlContent = htmlSeparatorService.download(url);
        } catch (IOException e) {
            System.out.println("Cannot download external source.");
            return;
        }

        htmlSeparatorService.separateAttributes(htmlContent, "input", "value")
            .forEach(this::registerNewsLetting);
    }
}
