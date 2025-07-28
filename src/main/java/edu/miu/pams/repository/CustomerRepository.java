package edu.miu.pams.repository;

import edu.miu.pams.model.Patient;

import java.time.LocalDate;

public class CustomerRepository {
    private static CustomerRepository instance;

    private CustomerRepository() {}

    public static CustomerRepository getInstance() {
        if (instance == null) {
            instance = new CustomerRepository();
        }
        return instance;
    }

    public Patient[] getAllCustomers() {
        return new Patient[]{
                new Patient(1, "Daniel", "Agar", "(641) 123-0009", "dagar@m.as", "1 N Street", LocalDate.of(1987, 1, 19)),
                new Patient(2, "Ana", "Smith", null, "amsith@te.edu", null, LocalDate.of(1948, 12, 5)),
                new Patient(3, "Marcus", "Garvey", "(123) 292-0018", null, "4 East Ave", LocalDate.of(2001, 9, 18)),
                new Patient(4, "Jeff", "Goldbloom", "(999) 165-1192", "jgold@es.co.za", null, LocalDate.of(1995, 2, 28)),
                new Patient(5, "Mary", "Washington", null, null, "30 W Burlington", LocalDate.of(1932, 5, 31))
        };
    }

    public String toJSONByHand(){
        return """
                [
                  {
                    "id": 1,
                    "firstName": "Daniel",
                    "lastName": "Agar",
                    "phoneNumber": "(641) 123-0009",
                    "email": "dagar@m.as",
                    "mailingAddress": "1 N Street",
                    "dateOfBirth": "1987-01-19"
                  },
                  {
                    "id": 2,
                    "firstName": "Ana",
                    "lastName": "Smith",
                    "phoneNumber": "",
                    "email": "amsith@te.edu",
                    "mailingAddress": "",
                    "dateOfBirth": "1948-12-05"
                  },
                  {
                    "id": 3,
                    "firstName": "Marcus",
                    "lastName": "Garvey",
                    "phoneNumber": "(123) 292-0018",
                    "email": "",
                    "mailingAddress": "4 East Ave",
                    "dateOfBirth": "2001-09-18"
                  },
                  {
                    "id": 4,
                    "firstName": "Jeff",
                    "lastName": "Goldbloom",
                    "phoneNumber": "(999) 165-1192",
                    "email": "jgold@es.co.za",
                    "mailingAddress": "",
                    "dateOfBirth": "1995-02-28"
                  },
                  {
                    "id": 5,
                    "firstName": "Mary",
                    "lastName": "Washington",
                    "phoneNumber": "",
                    "email": "",
                    "mailingAddress": "30 W Burlington",
                    "dateOfBirth": "1932-05-31"
                  }
                ]
                """;
    }
}
