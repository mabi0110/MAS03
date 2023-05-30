package model.dynamiczne;

import java.time.Year;

public class UserDyn extends PersonDyn {

    private String identifier;

    public UserDyn(PersonDyn personDyn, String identifier) {
        super(personDyn.getFirstName(), personDyn.getLastName(), personDyn.getBirthYear());
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return super.toString() + "UserDyn{" +
                "identifier='" + identifier + '\'' +
                '}';
    }
}
