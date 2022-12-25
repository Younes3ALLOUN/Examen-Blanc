package ma.enset.RadarService.commandside.controller;

import commands.radar.RadarCreateCommand;
import commands.radar.RadarUpdateCommand;
import dtos.radar.RadarReqDto;
import dtos.radar.RadarUpdateReqDto;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/commands/radar")
@AllArgsConstructor
public class RadarCommandController {
    private CommandGateway commandGateway;

    @PostMapping("/create")
    public CompletableFuture<String> createRadar(@RequestBody RadarReqDto request){
        CompletableFuture<String> responseCommand = commandGateway.send(new RadarCreateCommand(
                UUID.randomUUID().toString(),
                request.getVitesseMax(),
                request.getLongitude(),
                request.getLatitude()
        ));
        return responseCommand;
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateRadar(@RequestBody RadarUpdateReqDto request){
        CompletableFuture<String> responseCommand = commandGateway.send(new RadarUpdateCommand(
                request.getId(),
                request.getVitesseMax(),
                request.getLongitude(),
                request.getLatitude()
        ));
        return responseCommand;
    }
    @ExceptionHandler
    public ResponseEntity<String> exceptionHandler(Exception e){
        ResponseEntity<String> entity= new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }
}
