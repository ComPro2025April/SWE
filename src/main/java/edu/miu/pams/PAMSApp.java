package edu.miu.pams;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.miu.pams.model.Patient;
import edu.miu.pams.repository.CustomerRepository;
import edu.miu.pams.util.JSONConvertUtil;

import java.util.Arrays;
import java.util.Comparator;

public class PAMSApp {
    private final CustomerRepository customerRepository;

    public PAMSApp() {
        this.customerRepository = CustomerRepository.getInstance();
    }

    public static void main(String[] args) {
        var app = new PAMSApp();
        var customers = app.customerRepository.getAllCustomers();

        Arrays.sort(customers, Comparator.comparing(Patient::getDateOfBirth));

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule()); // support for LocalDate
            mapper.enable(SerializationFeature.INDENT_OUTPUT); // pretty print

            String jsonOutput = mapper.writeValueAsString(customers);
            System.out.println(jsonOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
