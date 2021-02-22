package cz.upce.fei.dependencyinjector.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public final class InputValidatorService {
    public boolean checkSurnameAndLastname(final String name){
        final String nameCheck = "^[A-Z]+[a-z]*[\\s]{1}[A-Z]+[a-z]*$";

        return check(name, nameCheck);
    }
    
    public boolean checkDate(final String date){
        final String dateCheck = "^[0-9]{1,2}[.]{1}[0-9]{1,2}[.]{1}[0-9]+$";

        return check(date, dateCheck);

    }
    
    public boolean checkBirthNumber(final String birthNumber){
        final String birthNumberCheck = "^[0-9]{6}[/]{1}[0-9]{4}$";

        return check(birthNumber, birthNumberCheck);

    }

    public boolean checkEmail(final String email){
        final String emailCheck = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+[.][a-zA-Z]{2,4}";

        return check(email, emailCheck);
    }
    
    private boolean check(final String text, final String rv){
        Pattern p = Pattern.compile(rv);
        Matcher m = p.matcher(text);

        return m.matches();
    }
}
