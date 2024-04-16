package com.yupi.oj.model.dto.questionsubmit;

import com.yupi.oj.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Author 玉米排骨汤
 * @Date 2023/12/23 19:50
 * @Package com.yupi.oj.model.dto.questionsubmit
 * @Version 1.0
 * @Since 1.0
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {

    private String language;
    private Integer status;
    private Long questionId;
    private Long userId;

    private static final long serialVersionUID = 1L;

}
