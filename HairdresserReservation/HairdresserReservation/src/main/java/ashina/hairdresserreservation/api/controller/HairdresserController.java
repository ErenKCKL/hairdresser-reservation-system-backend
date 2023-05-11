package ashina.hairdresserreservation.api.controller;

import ashina.hairdresserreservation.HairdresserReservationApplication;
import ashina.hairdresserreservation.business.abstracts.HairdresserService;
import ashina.hairdresserreservation.entities.concretes.Hairdresser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/hairdressers")
public class HairdresserController {

    /**
     Hairdresser Controller Class
     This class serves as the REST API controller for the Hairdresser Reservation System.
     It handles HTTP requests related to Hairdresser entities and delegates the business
     logic to the HairdresserService.
     Annotations used:
     @RestController: Indicates that this class is a Spring REST Controller, enabling
     the creation of RESTful endpoints.
     @RequestMapping: Specifies the base path for the endpoints in this controller.
     The class contains the following endpoints:
     GET /api/hairdressers: Retrieves a list of all Hairdresser entities.
     GET /api/hairdressers/{id}: Retrieves a specific Hairdresser entity by its ID.
     POST /api/hairdressers: Creates a new Hairdresser entity.
     PUT /api/hairdressers/{id}: Updates a specific Hairdresser entity by its ID.
     DELETE /api/hairdressers/{id}: Deletes a specific Hairdresser entity by its ID.
     The HairdresserService instance is injected into the class using the @Autowired
     annotation in the constructor, allowing for loose coupling and easy testing.
     */

    private HairdresserService hairdresserService;

    @Autowired
    public HairdresserController(HairdresserService hairdresserService) {
        this.hairdresserService = hairdresserService;
    }


    @GetMapping
    public ResponseEntity<List<Hairdresser>> getAllHairdressers() {
        List<Hairdresser> hairdressers = hairdresserService.findAll();
        return new ResponseEntity<>(hairdressers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hairdresser> getHairdresserById(@PathVariable int id) {
        return hairdresserService.findById(id)
                .map(hairdresser -> new ResponseEntity<>(hairdresser, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Hairdresser> createHairdresser(@RequestBody Hairdresser hairdresser) {
        Hairdresser savedHairdresser = hairdresserService.save(hairdresser);
        return new ResponseEntity<>(savedHairdresser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hairdresser> updateHairdresser(@PathVariable int id, @RequestBody Hairdresser hairdresserDetails) {
        return hairdresserService.findById(id).map(hairdresser -> {
            hairdresser.setFirstName(hairdresserDetails.getFirstName());
            hairdresser.setEmail(hairdresserDetails.getEmail());
            Hairdresser updatedHairdresser = hairdresserService.save(hairdresser);
            return new ResponseEntity<>(updatedHairdresser, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHairdresser(@PathVariable int id) {
        return hairdresserService.findById(id).map(hairdresser -> {
            hairdresserService.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
