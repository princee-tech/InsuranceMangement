package com.INSURANCE.Service.impl;


import com.INSURANCE.Entities.Client;
import com.INSURANCE.Exception.ClientNotFound;
import com.INSURANCE.Payload.ClientDTO;
import com.INSURANCE.Repository.ClientRepository;
import com.INSURANCE.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{




    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {


        Client client1 = mapToEntity(clientDTO);

        Client save = clientRepository.save(client1);

        ClientDTO clientDTO1 = mapToDto(save);
        return  clientDTO1;


    }

    @Override
    public List<ClientDTO>getAllClients(int pageNo, int pageSize) {


        Pageable pageable= PageRequest.of(pageNo, pageSize);
        Page<Client>all1 = clientRepository.findAll(pageable);
        List<Client>all = all1.getContent();

        return all.stream().map(post->mapToDto(post)).collect(Collectors.toList());


    }

    public ClientDTO getClientById(Long id) {
        Client client= clientRepository.findById(id).orElseThrow(() ->new ClientNotFound("Client", "id", id));


        ClientDTO clientDTO= mapToDto(client);
        return clientDTO;

    }


    @Override
    public ClientDTO updateClient(Long id, ClientDTO dto){


        Client client= clientRepository.findById(id).orElseThrow(() ->new ClientNotFound("Client", "id", id));

        client.setName(dto.getName());
        client.setDob(dto.getDob());
        client.setAddress(dto.getAddress());
        client.setContact(dto.getContact());


        Client save = clientRepository.save(client);
        return mapToDto(save);

    }






    public void deleteClient(Long id) {
        Client client= clientRepository.findById(id).orElseThrow(() ->new ClientNotFound("Client", "id", id));
        clientRepository.delete(client);
    }


    private ClientDTO mapToDto(Client save) {
        ClientDTO clientdto=new ClientDTO();
        clientdto.setName(save.getName());
        clientdto.setDob(save.getDob());
        clientdto.setAddress(save.getAddress());
        clientdto.setContact(save.getContact());
        clientdto.setId(save.getId());
        return clientdto;

    }

    Client mapToEntity(ClientDTO clientDTO) {



        Client client= new Client();
        client.setName(clientDTO.getName());
        client.setDob(clientDTO.getDob());
        client.setAddress(clientDTO.getAddress());
        client.setContact(clientDTO.getContact());
        return client;




    }
}

