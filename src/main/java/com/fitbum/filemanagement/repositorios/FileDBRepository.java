package com.fitbum.filemanagement.repositorios;


import com.fitbum.filemanagement.entidades.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface File db repository.
 */
@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {



}