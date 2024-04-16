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
 * 題目配置
 */
@Data
public class JudgeConfig {
    /**
     * 时间限制（ms）
     */
    private Long timeLimit;

    /**
     *内存限制 (kb)
     */
    private Long memoryLimit;

    /**
     *堆栈限制(kb)
     */
    private Long stackLimit;
}
