package com.lotto.lotto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lotto.lotto.dto.Lotto;

@Service
public interface LottoService {
    
    public Lotto selectByNo(Long drwNo) throws Exception;

    public List<Lotto> allList() throws Exception;

    public int insertNo(Lotto lotto) throws Exception;
}
