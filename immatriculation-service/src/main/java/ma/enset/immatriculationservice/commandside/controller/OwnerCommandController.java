package ma.enset.immatriculationservice.commandside.controller;

import commands.owner.OwnerCreateCommand;
import dtos.owner.OwnerReqDto;
import dtos.owner.OwnerUpdateReqDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/commands/owner")
@Slf4j @AllArgsConstructor
public class OwnerCommandController {
    private CommandGateway commandGateway;
    @PostMapping("/create")
    public CompletableFuture<String> createOwner(@RequestBody OwnerReqDto request){
        CompletableFuture<String> send = commandGateway.send(new OwnerCreateCommand(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getDat_naissance(),
                request.getEmail()
        ));
    return  send;
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateOwner(@RequestBody OwnerUpdateReqDto request){
        CompletableFuture<String> send = commandGateway.send(new OwnerUpdateReqDto(
                request.getId(),
                request.getDat_naissance(),
                request.getName(),
                request.getEmail()
        ));
        return  send;
    }
    @ExceptionHandler
    public ResponseEntity<String> exceptionHandler(Exception e){
        ResponseEntity<String> entity= new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }
}
