package com.nema.backend.repository;

import com.nema.backend.entity.Anuncio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioRepository extends MongoRepository<Anuncio,Integer> {
}
