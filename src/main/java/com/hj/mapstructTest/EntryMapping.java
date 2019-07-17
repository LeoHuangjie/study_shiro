package com.hj.mapstructTest;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author huangjie
 * @time 2019-07-17 15:46
 */
@Mapper(componentModel = "spring")
public interface EntryMapping {
    EntryMapping ENTRY_MAPPER = Mappers.getMapper(EntryMapping.class);


//    @Mappings({
      @Mapping(source = "id", target = "studentId")
      @Mapping(source = "name", target = "studentName")
      @Mapping(source = "beginTime", target = "beginTime", dateFormat = "yyyy-MM-dd HH:mm")
      @Mapping(source = "endTime", target = "endTime", dateFormat = "yyyy-MM-dd HH:mm")
//    })
    StudentDto to (Student student);

    @InheritInverseConfiguration
    Student from (StudentDto studentDto);
}
