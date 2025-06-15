package com.lotto.lotto.service;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lotto.lotto.dto.Lotto;
import com.lotto.lotto.mapper.LottoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LottoCrawlService {

    private final LottoMapper mapper;
    private final RestTemplate restTemplate = new RestTemplate();

    

    public void fetchAndSaveAll(Long start, Long end) throws Exception {
        for (Long i = start; i <= end; i++) {
            Lotto existing = mapper.selectByNo(i);
            if (existing != null) continue;

            String url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=" + i;
            try {
                ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode json = objectMapper.readTree(response.getBody());

                if (json.get("returnValue").asText().equals("success")) {
                    Lotto result = new Lotto();
                    result.setDrwNo(json.get("drwNo").asLong());
                    result.setDrwtNo1(json.get("drwtNo1").asInt());
                    result.setDrwtNo2(json.get("drwtNo2").asInt());
                    result.setDrwtNo3(json.get("drwtNo3").asInt());
                    result.setDrwtNo4(json.get("drwtNo4").asInt());
                    result.setDrwtNo5(json.get("drwtNo5").asInt());
                    result.setDrwtNo6(json.get("drwtNo6").asInt());
                    result.setBnusNo(json.get("bnusNo").asInt());
                    result.setDrwNoDate(json.get("drwNoDate").asText());

                    mapper.insertNo(result);
                    Thread.sleep(100); // 과도한 요청 방지
                }

            } catch (Exception e) {
                System.err.println("Error at round " + i + ": " + e.getMessage());
            }
        }
    }
}
