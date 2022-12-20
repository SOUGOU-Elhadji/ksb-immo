package sn.ksb.immo.ksbimmo.application.configs;

import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import sn.ksb.immo.ksbimmo.application.enums.TypePropriete;
import sn.ksb.immo.ksbimmo.application.models.Role;
import sn.ksb.immo.ksbimmo.application.repositories.RoleRepo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Configuration
public class GeneralConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        //convertir du String vers java.util.Date
        mapper.addConverter(new Converter<String, Date>() {
            @Override
            public Date convert(MappingContext<String, Date> mappingContext) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                try {
                    date = format.parse(mappingContext.getSource());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return date;
            }
        });

        //convertir du java.util.Date vers String
        mapper.addConverter(new Converter<Date, String>() {
            @Override
            public String convert(MappingContext<Date, String> mappingContext) {
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                return format.format(mappingContext.getSource());
            }
        });

        mapper.addConverter(new Converter<String, TypePropriete>() {
            @Override
            public TypePropriete convert(MappingContext<String, TypePropriete> mappingContext) {
                return TypePropriete.valueOf(mappingContext.getSource().toUpperCase());
            }
        });


        return mapper;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }



}
