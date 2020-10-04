package com.demo.main.service.mapping;

import com.demo.main.data.entity.DebitCardEntity;
import com.demo.main.type.dto.DebitCardDto;
import org.mapstruct.Mapper;

@Mapper
public interface DebitCardMapper {

    DebitCardDto toDto(DebitCardEntity source);

}
