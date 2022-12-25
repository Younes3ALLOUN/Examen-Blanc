package ma.enset.immatriculationservice.commandside.controller;

import commands.vehicule.VehiculeCreateCommand;
import commands.vehicule.VehiculeUpdateCommand;
import dtos.vehicule.VehiculeReqDto;
import dtos.vehicule.VehiculeUpdateReqDto;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/commands/vehicule")
@AllArgsConstructor
public class VehiculeController {
    private CommandGateway commandGateway;
    @PostMapping("/create")
    public CompletableFuture<String> createVehicule(@RequestBody VehiculeReqDto request){
        CompletableFuture<String> send = commandGateway.send(new VehiculeCreateCommand(
                UUID.randomUUID().toString(), request.getMatricule(), request.getMarque(), request.getModele(), request.getPuissance(), request.getOwnerid()
        ));
        return send;
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateVehicule(@RequestBody VehiculeUpdateReqDto request){
        CompletableFuture<String> send = commandGateway.send(new VehiculeCreateCommand(
                request.getId(), request.getMatricule(), request.getMarque(), request.getModele(), request.getPuissance(), request.getOwnerid()
        ));
        return send;
    }

    @ExceptionHandler
    public ResponseEntity<String> exceptionHandler(Exception e){
        ResponseEntity<String> entity= new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }
}
