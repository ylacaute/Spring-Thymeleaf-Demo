package org.yla.demo.thymeleaf.core.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;


public class EnumToStringConverter<T extends ConversionService & FormatterRegistry> implements Converter<Enum<?>, String> {

	@Autowired
    private MessageSource messageSource;

	public EnumToStringConverter(T formattingConversionService) {
        super();
        formattingConversionService.addConverter(this);
    }

    @Override
    public String convert(Enum<?> value) {
        String output = value.toString();
        String keyMsg = value.getClass().getSimpleName()+"."+value.toString();
        try {
            output = this.messageSource.getMessage(keyMsg, null, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e) {
            System.err.println("No message resource found for " + keyMsg + " add this to the resource bundle");
        }
        return output;
    }
}