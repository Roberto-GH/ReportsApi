package co.com.pragma.api.mapper;

import co.com.pragma.api.constants.ReportsWebKeys;
import co.com.pragma.api.dto.ReportResponseDto;
import co.com.pragma.model.report.Report;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ReportsWebKeys.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReportDtoMapper {

  ReportResponseDto toResponseDto(Report user);

}
