package com.saidtokmak.livebetting.mapper;

import com.saidtokmak.livebetting.dto.BulletinDTO;
import com.saidtokmak.livebetting.dto.CreateBulletinRequestDTO;
import com.saidtokmak.livebetting.entity.Bulletin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BulletinMapper {

    Bulletin toEntity(CreateBulletinRequestDTO createBulletinRequestDTO);

    @Mapping(target = "bulletinId", source = "bulletin.id")
    BulletinDTO toDTO(Bulletin bulletin);
}
