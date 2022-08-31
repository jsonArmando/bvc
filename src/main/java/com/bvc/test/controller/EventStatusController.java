package com.bvc.test.controller;

import com.bvc.test.dto.EventStatusDto;
import com.bvc.test.exception.EventStatusException;
import com.bvc.test.service.EventStatusService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/eventStatus")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class EventStatusController {
    private EventStatusService eventStatusService;

    @GetMapping(value ="/event-status")
    public ResponseEntity<List<EventStatusDto>> findEventStatus() throws EventStatusException {
        List<EventStatusDto> commodityStatusDtos =eventStatusService.findEventStatus();
        if(!commodityStatusDtos.isEmpty()){
            var response = new ResponseEntity<>(commodityStatusDtos, HttpStatus.OK);
            return response;
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value ="/event-id/{idEvent}")
    public ResponseEntity<List<EventStatusDto>> findById(@PathVariable String idEvent) throws
            EventStatusException{
        var response = new ResponseEntity<>(eventStatusService.findByNumberId(idEvent),HttpStatus.OK);
        return response;
    }

    @GetMapping(value ="/event-digital/{digitalEvent}")
    public ResponseEntity<List<EventStatusDto>> findByDigital(@PathVariable String digitalEvent) throws
            EventStatusException{
        var response = new ResponseEntity<>(eventStatusService.findByDigital(digitalEvent),HttpStatus.OK);
        return response;
    }

    @PostMapping(value ="/event-create",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventStatusDto> createPatientStatus(@Valid @RequestBody EventStatusDto eventStatusDto) throws EventStatusException{
        eventStatusService.create(eventStatusDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
