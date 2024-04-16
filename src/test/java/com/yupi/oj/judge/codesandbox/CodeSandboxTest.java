package com.yupi.oj.judge.codesandbox;

import com.yupi.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.oj.judge.codesandbox.model.ExecuteCodeResponse;
import com.yupi.oj.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/15 14:57
 * @Package com.yupi.oj.judge.codesandbox
 * @Version 1.0
 * @Since 1.0
 */
@SpringBootTest
public class CodeSandboxTest {

    @Value("${codesandbox.type:example}")
    private String type;

    @Test
    void executeCodeByProxy(){
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
         codeSandbox = new CodeSandboxProxy(codeSandbox);
         String code = "public class Main {\n" +
                 "\n" +
                 "    public static void main(String[] args) {\n" +
                 "        int a = Integer.parseInt(args[0]);\n" +
                 "        int b = Integer.parseInt(args[1]);\n" +
                 "        System.out.println(\"result\" + (a + b));\n" +
                 "    }\n" +
                 "\n" +
                 "}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }

}
