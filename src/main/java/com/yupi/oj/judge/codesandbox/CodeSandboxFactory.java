package com.yupi.oj.judge.codesandbox;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/14 18:34
 * @Package com.yupi.oj.judge.codesandbox
 * @Version 1.0
 * @Since 1.0
 */

import com.yupi.oj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.yupi.oj.judge.codesandbox.impl.RemoteCodeSandbox;
import com.yupi.oj.judge.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * 代码沙箱工厂
 */
public class CodeSandboxFactory {

    public static CodeSandbox newInstance(String type){
        switch(type){
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }

}
