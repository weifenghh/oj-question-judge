package com.yupi.oj.judge.strategy;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/17 13:49
 * @Package com.yupi.oj.judge.strategy
 * @Version 1.0
 * @Since 1.0
 */

import com.yupi.oj.model.dto.question.JudgeCase;
import com.yupi.oj.model.dto.questionsubmit.JudgeInfo;
import com.yupi.oj.model.entity.Question;
import com.yupi.oj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 判题上下文
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;
    private List<String> inputList;
    private List<String> outputList;
    private List<JudgeCase> judgeCaseList;
    private Question question;
    private QuestionSubmit questionSubmit;

}
