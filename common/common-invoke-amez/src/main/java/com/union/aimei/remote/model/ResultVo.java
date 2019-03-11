package com.union.aimei.remote.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author GaoWei
 * @describe 远程调用艾美返回对象
 * @time 2017/12/18,14:14
 */
@Data
@EqualsAndHashCode
public class ResultVo<T> implements Serializable {
    private Status status;
    private Integer code;
    private String msg;
    private T data;

    public ResultVo() {

    }

    /**
     * 返回值
     */
    public enum Status {
        /**
         * 成功
         */
        SUCCESS("0", "成功"),
        /**
         * 失败
         */
        ERROR("-1", "失败");

        /**
         * value值
         */
        private String value;
        /**
         * label值
         */
        private String label;

        Status(String value, String label) {
            this.value = value;
            this.label = label;
        }

        public String getValue() {
            return value;
        }

        public String getLabel() {
            return label;
        }
    }


}
