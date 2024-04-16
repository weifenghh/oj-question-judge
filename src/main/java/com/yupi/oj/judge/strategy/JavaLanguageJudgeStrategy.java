package com.yupi.oj.judge.strategy;

import cn.hutool.json.JSONUtil;
import com.yupi.oj.model.dto.question.JudgeCase;
import com.yupi.oj.model.dto.question.JudgeConfig;
import com.yupi.oj.model.dto.questionsubmit.JudgeInfo;
import com.yupi.oj.model.entity.Question;
import com.yupi.oj.model.enums.JudgeInfoMessageEnum;

import java.util.List;
import java.util.Optional;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/17 13:50
 * @Package com.yupi.oj.judge.strategy
 * @Version 1.0
 * @Since 1.0
 */
public class JavaLanguageJudgeStrategy implements JudgeStrategy{
    @Override
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        JudgeInfo judgeInfo = judgeContext.getJudgeInfo();
        Long memoryLimit = Optional.ofNullable(judgeInfo.getMemoryLimit()).orElse(0L);
        Long timeLimit = Optional.ofNullable(judgeInfo.getTimeLimit()).orElse(0L);
        List<String> inputList = judgeContext.getInputList();
        List<String> outputList = judgeContext.getOutputList();
        List<JudgeCase> judgeCaseList = judgeContext.getJudgeCaseList();
        Question question = judgeContext.getQuestion();
        JudgeInfoMessageEnum judgeInfoMessageEnum = JudgeInfoMessageEnum.ACCEPTED;
        JudgeInfo judgeInfoResponse = new JudgeInfo();
        judgeInfoResponse.setMemoryLimit(memoryLimit);
        judgeInfoResponse.setTimeLimit(timeLimit);
        if(outputList.size() != inputList.size()){
            judgeInfoMessageEnum = judgeInfoMessageEnum.WRONG_ANSWER;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        for(int i = 0; i < judgeCaseList.size(); i++){
            JudgeCase judgeCase = judgeCaseList.get(i);
            if(!judgeCase.getOutput().equals(outputList.get(i))){
                judgeInfoMessageEnum = judgeInfoMessageEnum.WRONG_ANSWER;
                judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
                return judgeInfoResponse;
            }
        }
//        JudgeInfo judgeInfo = executeCodeResponse.getJudgeInfo();

        String judgeConfigStr = question.getJudgeConfig();
        JudgeConfig judgeConfig = JSONUtil.toBean(judgeConfigStr, JudgeConfig.class);
        Long promiseMemoryLimit = judgeConfig.getMemoryLimit();
        Long promiseTimeLimit = judgeConfig.getTimeLimit();
        if(memoryLimit > promiseMemoryLimit){
            judgeInfoMessageEnum = judgeInfoMessageEnum.MEMORY_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        if(timeLimit > promiseTimeLimit){
            judgeInfoMessageEnum = judgeInfoMessageEnum.TIME_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
        return judgeInfoResponse;
    }
}
