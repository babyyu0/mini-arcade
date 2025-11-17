package com.mini.arcade.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class NumberBaseballService {

    private String m_randomNumber = "";

    public void createRandomNumber(int numCount) {
        for(int i = 0; i < numCount; i++) {
            m_randomNumber += (int)Math.ceil(Math.random() * 10);
        }

        log.info("m_randomNumber: {}", m_randomNumber);
    }

    public int[] submitCorrection(String submitNum) {
        int[] strikeInfo = new int[3];
        boolean[] flag = new boolean[m_randomNumber.length() + 1];
        // Strike
        for(int i = 0; i < m_randomNumber.length(); i++) {
            if(m_randomNumber.charAt(i) == submitNum.charAt(i)) {
                flag[i] = true;
                strikeInfo[0]++;
            }
        }

        // Ball
        for(int i = 0; i < m_randomNumber.length(); i++) {
            if(!flag[i] && m_randomNumber.indexOf(submitNum.charAt(i)) != -1) {
                flag[i] = true;
                strikeInfo[1]++;
            }
        }

        strikeInfo[2] = m_randomNumber.length() - strikeInfo[0] - strikeInfo[1];

        return strikeInfo;
    }
}
