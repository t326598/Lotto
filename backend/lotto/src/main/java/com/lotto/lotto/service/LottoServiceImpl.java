package com.lotto.lotto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lotto.lotto.dto.Lotto;
import com.lotto.lotto.mapper.LottoMapper;

public class LottoServiceImpl implements LottoService{

    @Autowired
    private LottoMapper lottoMapper;

    @Override
    public Lotto selectByNo(Long drwNo) throws Exception {

        return lottoMapper.selectByNo(drwNo);
        
    }

    @Override
    public List<Lotto> allList() throws Exception {
        return lottoMapper.allList();
    }

    @Override
    public int insertNo(Lotto lotto) throws Exception {
      return lottoMapper.insertNo(lotto);
    }
    
}
