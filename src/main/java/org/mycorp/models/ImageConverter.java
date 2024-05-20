package org.mycorp.models;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Base64;

@Converter
public class ImageConverter implements AttributeConverter<String, byte[]> {

    @Override
    public byte[] convertToDatabaseColumn(String s) {
        return Base64.getDecoder().decode(s);
    }

    @Override
    public String convertToEntityAttribute(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
}
