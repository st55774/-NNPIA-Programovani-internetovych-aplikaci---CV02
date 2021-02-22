package cz.fei.upce.injector;

import cz.fei.upce.NewsletterApp;
import cz.fei.upce.service.HTMLSeparatorService;
import cz.fei.upce.service.InputValidatorService;
import cz.fei.upce.service.NewsletterService;

public final class DependencyInjector {
    private static NewsletterService newsletterService;
    private static HTMLSeparatorService htmlSeparatorService;
    private static InputValidatorService inputValidatorService;

    public static NewsletterApp getNewsletterApp(){
        return new NewsletterApp(getNewsletterService());
    }

    private static NewsletterService getNewsletterService() {
        if(newsletterService == null)
            newsletterService = new NewsletterService(getHTMLSeparatorService(), getInputValidatorService());

        return newsletterService;
    }

    private static HTMLSeparatorService getHTMLSeparatorService() {
        if(htmlSeparatorService == null)
            htmlSeparatorService = new HTMLSeparatorService();

        return htmlSeparatorService;
    }

    private static InputValidatorService getInputValidatorService() {
        if(inputValidatorService == null)
            inputValidatorService = new InputValidatorService();

        return inputValidatorService;
    }
}
