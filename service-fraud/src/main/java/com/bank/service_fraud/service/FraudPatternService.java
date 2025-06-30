package com.bank.service_fraud.service;

import com.bank.service_fraud.dto.FraudPatternDTO;

import java.util.List;

public interface FraudPatternService {

    List<FraudPatternDTO> getAllPatterns();

    FraudPatternDTO getPatternById(Integer id);

    List<FraudPatternDTO> getActivePatterns();

    FraudPatternDTO createPattern(FraudPatternDTO patternDTO);

    FraudPatternDTO updatePattern(Integer id, FraudPatternDTO patternDTO);

    void deletePattern(Integer id);
}
