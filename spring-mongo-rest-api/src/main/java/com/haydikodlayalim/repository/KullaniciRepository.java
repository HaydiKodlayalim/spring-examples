package com.haydikodlayalim.repository;

import com.haydikodlayalim.entity.Kullanici;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KullaniciRepository extends MongoRepository<Kullanici, String> {

}
