package com.tolgaozgun.gdscturkweb.controller;

import com.tolgaozgun.gdscturkweb.dto.request.country.CreateCountryRequest;
import com.tolgaozgun.gdscturkweb.dto.request.country.EditCountryRequest;
import com.tolgaozgun.gdscturkweb.dto.response.Response;
import com.tolgaozgun.gdscturkweb.exception.BaseException;
import com.tolgaozgun.gdscturkweb.exception.ExceptionLogger;
import com.tolgaozgun.gdscturkweb.model.Country;
import com.tolgaozgun.gdscturkweb.service.CountryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("countries")
public class CountryController {

    private final CountryService countryService;

    @GetMapping( path = "")
    public ResponseEntity<Object> getAllCountries() {
        try {
            List<Country> countryList = countryService.getAllCountries();
            return Response.create("Gathered all countries", HttpStatus.OK, countryList);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping( path = "{countryId}")
    public ResponseEntity<Object> getCountryById(@PathVariable Long countryId) {
        try {
            Country country = countryService.getCountry(countryId);
            return Response.create("Found the countru", HttpStatus.OK, country);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "create")
    public ResponseEntity<Object> createCountry(@Valid @RequestBody CreateCountryRequest createCountryRequest) {
        try {
            Country country = countryService.createCountry(createCountryRequest);
            return Response.create("Country created successfully", HttpStatus.OK, country);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "edit/{countryId}")
    public ResponseEntity<Object> editCountry(@PathVariable Long countryId, @Valid @RequestBody EditCountryRequest editCountryRequest) {
        try {
            Country country = countryService.editCountry(countryId, editCountryRequest);
            return Response.create("Country edited successfully", HttpStatus.OK, country);
        } catch (BaseException baseException) {
            return Response.create(baseException);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
