package com.demo.main.service.mapping;

import com.demo.main.data.entity.ProfileEntity;
import com.demo.main.type.dto.ProfileDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProfileMapper {

    ProfileEntity toEntity(ProfileDto source);

    ProfileDto toDto(ProfileEntity source);

}
