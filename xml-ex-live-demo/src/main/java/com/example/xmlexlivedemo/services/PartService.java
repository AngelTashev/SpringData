package com.example.xmlexlivedemo.services;


import com.example.xmlexlivedemo.models.dtos.PartSeedDto;
import com.example.xmlexlivedemo.models.entities.Part;

import java.util.List;
import java.util.Set;

public interface PartService {
    void seedParts(List<PartSeedDto> partSeedDtos);

    Set<Part> getRandomParts();
}
