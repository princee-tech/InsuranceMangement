package com.INSURANCE.Controller;

import com.INSURANCE.Entities.Client;
import com.INSURANCE.Payload.ClientDTO;
import com.INSURANCE.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController{

    @Autowired
    private ClientService clientService;


    @PostMapping
    public ResponseEntity<ClientDTO>createClient(@RequestBody ClientDTO clientDTO) {
        ClientDTO client = clientService.createClient(clientDTO);
        return new ResponseEntity(client, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ClientDTO>getAllClients(@RequestParam(value = "pageNo",defaultValue = "0",required = false) int pageNo,
                                        @RequestParam (value = "pageSize",defaultValue = "2",required = false) int pageSize){
        return clientService.getAllClients(pageNo,pageSize);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO>getClientById(@PathVariable Long id){
        ClientDTO clientById= clientService.getClientById(id);
        return new ResponseEntity<>(clientById,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO>updateClient(@PathVariable Long id,@RequestBody ClientDTO clientDTO){
        ClientDTO clientDTO1 = clientService.updateClient(id, clientDTO);

        return ResponseEntity.ok(clientDTO1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return new ResponseEntity("Client Details Deleted Successfully",HttpStatus.OK);

    }
}
