package com.theironyard.charlotte.cookiesjar.repositories;

import com.theironyard.charlotte.cookiesjar.models.Cookie;
import org.springframework.data.repository.CrudRepository;

public interface CookieRepository
        extends CrudRepository<Cookie, Integer> {
}
