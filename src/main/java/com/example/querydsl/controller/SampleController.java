package com.example.querydsl.controller;

import com.example.querydsl.dto.SampleDto;
import com.example.querydsl.model.Sample;
import com.example.querydsl.service.SampleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    @ResponseBody
    public List<SampleDto> findAllInfo() {
        List<Sample> result = sampleService.findAllInfo();
        return result.stream()
                .map(this::convertListToDto)
                .collect(Collectors.toList());
    }

    /**
     * entity to dto
     *
     * @param sample
     * @return
     */
    private SampleDto convertToDto(Optional<Sample> sample) {
        return modelMapper.map(sample, SampleDto.class);
    }

    /**
     * entity list to dto
     *
     * @param sample
     * @return
     */
    private SampleDto convertListToDto(Sample sample) {
        return modelMapper.map(sample, SampleDto.class);
    }

    /**
     * dto to entity
     *
     * @param demoDto
     * @return
     */
    private Sample convertToEntity(SampleDto demoDto) {
        return modelMapper.map(demoDto, Sample.class);
    }
}
