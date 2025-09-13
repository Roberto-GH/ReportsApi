package co.com.pragma.api.dto;

import java.math.BigDecimal;

public record ReportResponseDto(
  String lastUpdated,
  Integer numberOfLoans,
  BigDecimal totalAmount
) {}