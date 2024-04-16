package com.yupi.oj.judge.strategy;

import com.yupi.oj.model.dto.questionsubmit.JudgeInfo;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/17 13:47
 * @Package com.yupi.oj.judge.strategy
 * @Version 1.0
 * @Since 1.0
 */

/**
 * 判题策略
 */
public interface JudgeStrategy {

    JudgeInfo doJudge(JudgeContext judgeContext);

}
