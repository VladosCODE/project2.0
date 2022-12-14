package ru.Vladislav.project2.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.Vladislav.project2.model.Person;
import ru.Vladislav.project2.service.PersonService;

@Component
public class PersonValidator implements Validator {

    private PersonService personService;

    @Autowired
    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (personService.findOne(person.getFio()) != null){
            errors.rejectValue("fio","","Такое име ФИО уже есть");
        }
    }
}
