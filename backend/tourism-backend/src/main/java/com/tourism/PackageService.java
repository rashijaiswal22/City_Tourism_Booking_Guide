package com.tourism;

import com.tourism.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    public void updatePackage(Long id, Package updatedData) {
        // Pehle purana package ID se dhoondho
        Package existingPkg = packageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package not found with id: " + id));

        // Naya data set karo
        existingPkg.setPackName(updatedData.getPackName());
        existingPkg.setDescription(updatedData.getDescription());
        existingPkg.setDuration(updatedData.getDuration());
        existingPkg.setPrice(updatedData.getPrice());
        existingPkg.setImageUrl(updatedData.getImageUrl());

        // Save kar do
        packageRepository.save(existingPkg);
    }
}