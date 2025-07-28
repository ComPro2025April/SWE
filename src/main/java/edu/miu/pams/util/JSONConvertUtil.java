package edu.miu.pams.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.miu.pams.model.Patient;

import java.util.List;

public class JSONConvertUtil {
    public static Patient[] parsePatients(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule()); // for LocalDate
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
            mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);

            List<Patient> list = mapper.readValue(json, new TypeReference<List<Patient>>() {});
            return list.toArray(new Patient[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return new Patient[0];
        }
    }
}
