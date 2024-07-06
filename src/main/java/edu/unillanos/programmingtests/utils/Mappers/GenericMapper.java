package edu.unillanos.programmingtests.utils.Mappers;

import org.modelmapper.ModelMapper;

import java.util.List;

public class GenericMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public <T> T map(Object source, Class<T> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    public List<?> mapList(List<?> source, Class<?> destinationType) {
        return source.stream()
                .map(item -> modelMapper.map(item, destinationType))
                .toList();
    }
}
