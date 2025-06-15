package com.lotto.lotto.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lotto.lotto.dto.Lotto;

@Mapper
public interface LottoMapper {
    
    public Lotto selectByNo(@Param("drwNo") Long drwNo) throws Exception;

    public List<Lotto> allList() throws Exception;

    public int insertNo(Lotto lotto) throws Exception;
}
