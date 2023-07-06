package com.fitbum.servicios;


import com.fitbum.servicios.mapper.AbstractServiceMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public abstract class AbstractBusinessService<E, ID, DTO,  REPO extends JpaRepository<E,ID> ,
        MAPPER extends AbstractServiceMapper<E,DTO>>  {
    private final REPO repo;
    private final MAPPER serviceMapper;


    protected AbstractBusinessService(REPO repo, MAPPER mapper) {
        this.repo = repo;
        this.serviceMapper = mapper;
    }
    public Optional<E> buscar(ID id){return  this.repo.findById(id);}
    public List<DTO> buscarTodos(){
        return  this.serviceMapper.toDto(this.repo.findAll());
    }

    public List<E> buscarEntidades(){
        return  this.repo.findAll();
    }
    public Set<E> buscarEntidadesSet(){
        Set<E> eSet = new HashSet<E>(this.repo.findAll());
        return  eSet;
    }
    public Set<DTO> buscarTodosSet(){
        Set<DTO> dtos = new HashSet<DTO>(this.serviceMapper.toDto(this.repo.findAll()));
        return  dtos;
    }

    public Page<DTO> buscarTodos(Pageable pageable){
        return  repo.findAll(pageable).map(this.serviceMapper::toDto);
    }
    public Page<E> buscarTodosEnt(Pageable pageable){
        return  repo.findAll(pageable);
    }

    //Buscar por id
    public Optional<DTO> encuentraPorId(ID id){

        return this.repo.findById(id).map(this.serviceMapper::toDto);
    }
    public Optional<E> encuentraPorIdEntity(ID id){

        return this.repo.findById(id);
    }
    public DTO guardar(DTO dto) throws Exception {
        final E entidad = serviceMapper.toEntity(dto);
        E entidadGuardada =  repo.save(entidad);
        return serviceMapper.toDto(entidadGuardada);
    }
    public DTO guardarEntidadDto(E entidad)  {
        E entidadGuardada =  repo.save(entidad);
        return serviceMapper.toDto(entidadGuardada);
    }
    public E guardarEntidadEntidad(E entidad) throws Exception {
        E entidadGuardada =  repo.save(entidad);
        return entidadGuardada;
    }
    public void  guardar(List<DTO> dtos) throws Exception {
        Iterator<DTO> it = dtos.iterator();

        while(it.hasNext()){
            E e = serviceMapper.toEntity(it.next());
            repo.save(e);
        }
    }
    public void eliminarPorId(ID id){
        this.repo.deleteById(id);
    }
    public MAPPER getMapper(){return  serviceMapper;}
    public REPO getRepo(){return  repo;}
}
