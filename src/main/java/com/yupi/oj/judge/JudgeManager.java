package com.yupi.oj.judge;

import com.yupi.oj.judge.strategy.DefaultJudgeStrategy;
import com.yupi.oj.judge.strategy.JavaLanguageJudgeStrategy;
import com.yupi.oj.judge.strategy.JudgeContext;
import com.yupi.oj.judge.strategy.JudgeStrategy;
import com.yupi.oj.model.dto.questionsubmit.JudgeInfo;
import com.yupi.oj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/17 14:43
 * @Package com.yupi.oj.judge
 * @Version 1.0
 * @Since 1.0
 */
@Service
public class JudgeManager {

    JudgeInfo doJudge(JudgeContext judgeContext){
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if("java".equals(language)){
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
