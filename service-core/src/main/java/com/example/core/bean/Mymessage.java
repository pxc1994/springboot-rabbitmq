package com.example.core.bean;



import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author peng_xiaochun
 * @Date Created in 2020/3/6 15:16
 */
@Data
@Builder
public class Mymessage implements Serializable {

    private static final long serialVersionUID = -3769676432799705977L;

    public String messageId;

    public String createTime;

    public String body;
}
