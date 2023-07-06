package com.fitbum.servicios.mapper;

import org.modelmapper.ModelMapper;

import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractServiceMapper<E,DTO> {
    public abstract DTO toDto(E e);
    public abstract E toEntity(DTO dto) throws Exception;

    public List<E>  toEntity(List<DTO> dtos) throws Exception {
        ListIterator it = dtos.listIterator();
        List<E> list = new ArrayList<>();
        while (it.hasNext()){
            DTO dto = (DTO) it.next();
            E e = this.toEntity(dto);
            list.add(e);
        }
        return list;
    }
    public List<DTO>  toDto(List<E> e){
        return e.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Set<E> toEntity(Set<DTO> dtos) throws Exception {
        Set<E> eSet = new HashSet<E>();
        for (DTO item: dtos) {
            E e = this.toEntity(item);
            eSet.add(e);
        }
        return  eSet;
    }
    public Set<DTO>  toDto(Set<E> e){
        return e.stream().map(this::toDto).collect(Collectors.toSet());
    }
}

