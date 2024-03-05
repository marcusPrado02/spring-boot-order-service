package com.example.orderservice.application.service;

import com.example.orderservice.domain.entity.manufacture.Manufacture;
import com.example.orderservice.domain.repository.ManufactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufactureService {

    @Autowired
    private ManufactureRepository manufactureRepository;

    public Optional<List<Manufacture>> listManufactures() {
        return Optional.of(manufactureRepository.findAll());
    }

    public Optional<Manufacture> getManufactureById(Long id) {
        return manufactureRepository.findById(id);
    }

    public Optional<Manufacture> createManufacture(Manufacture costumer) {
        return Optional.of(manufactureRepository.save(costumer));
    }

    public Optional<Manufacture> updateManufacture(Long id, Manufacture updatedManufacture) {
        Optional<Manufacture> existingManufactureOptional = manufactureRepository.findById(id);
        if (existingManufactureOptional.isPresent()) {
            Manufacture existingManufacture = existingManufactureOptional.get();
            existingManufacture.CopyObject(updatedManufacture);

            return Optional.of(manufactureRepository.save(existingManufacture));
        } else {
            // TODO: Criar a lógica de tratamento de erro ao atualizar um registro que não existe
            return null;
        }
    }

    public Optional<Manufacture> deleteManufacture(Long id) {
        Optional<Manufacture> existingManufactureOptional = manufactureRepository.findById(id);
        if(existingManufactureOptional.isPresent()) {
            manufactureRepository.deleteById(id);
            return existingManufactureOptional;
        } else {
            // TODO: Criar a lógica de tratamento de erro ao deletar um registro que não existe
            return null;
        }
    }
}
