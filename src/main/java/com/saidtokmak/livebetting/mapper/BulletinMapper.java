package com.saidtokmak.livebetting.mapper;

import com.saidtokmak.livebetting.dto.bulletin.BulletinDTO;
import com.saidtokmak.livebetting.dto.bulletin.CreateBulletinRequestDTO;
import com.saidtokmak.livebetting.entity.Bulletin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BulletinMapper {

    Bulletin toEntity(CreateBulletinRequestDTO createBulletinRequestDTO);

    @Mapping(target = "bulletinId", source = "bulletin.id")
    BulletinDTO toDTO(Bulletin bulletin);

    Bulletin toEntityFromBulletinDTO(BulletinDTO bulletinDTO);
}
