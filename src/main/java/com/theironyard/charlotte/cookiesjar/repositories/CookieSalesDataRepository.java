package com.theironyard.charlotte.cookiesjar.repositories;

import com.theironyard.charlotte.cookiesjar.models.CookieSalesData;
import org.springframework.data.repository.CrudRepository;

// WHEN WE DEFINE AN INTERFACE:
// We extend CrudRepository. The first Class inside the angle brackets
// is the Class of the objects we're trying to track.
// the SECOND class in the angle brackets is the type of the ID
// column in that class (is normally "Integer", could also be "Long")
public interface CookieSalesDataRepository
        extends CrudRepository<CookieSalesData, Integer> {
}
