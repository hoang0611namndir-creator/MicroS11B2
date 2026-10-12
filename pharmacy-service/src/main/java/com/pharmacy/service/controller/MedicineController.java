package com.pharmacy.service.controller;

import com.pharmacy.service.entity.Medicine;
import com.pharmacy.service.service.MedicineService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicineById(
            @PathVariable Long id) {

        Medicine medicine = medicineService.getMedicineById(id);

        return ResponseEntity.ok(medicine);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Medicine> updateMedicine(
            @PathVariable Long id,
            @RequestBody Medicine medicine) {

        medicine.setId(id);

        Medicine updatedMedicine =
                medicineService.updateMedicine(medicine);

        return ResponseEntity.ok(updatedMedicine);
    }
}