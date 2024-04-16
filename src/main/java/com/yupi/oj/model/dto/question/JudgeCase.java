package com.yupi.oj.model.dto.question;

/**
 * @Author 玉米排骨汤
 * @Date 2023/12/19 20:23
 * @Package com.yupi.oj.model.dto.question
 * @Version 1.0
 * @Since 1.0
 */

import lombok.Data;

/**
 * 題目用例
 */
@Data
public class JudgeCase {
    /**
     * 輸入用例
     */
    private String input;


    /**
     *
     *輸出用例
     */
    private String output;
}
