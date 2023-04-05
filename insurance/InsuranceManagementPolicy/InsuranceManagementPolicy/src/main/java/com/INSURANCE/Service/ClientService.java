package com.INSURANCE.Service;

import com.INSURANCE.Payload.ClientDTO;

import java.util.List;

public interface ClientService{


    ClientDTO createClient(ClientDTO clientDTO);
//    List<ClientDTO>getAllClients();


    List<ClientDTO> getAllClients(int pageNo, int pageSize);
    ClientDTO getClientById(Long id);
    //
    ClientDTO updateClient(Long id, ClientDTO clientDTO);
    void deleteClient(Long id);
}

