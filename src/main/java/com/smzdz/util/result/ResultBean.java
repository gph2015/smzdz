package com.smzdz.util.result;

import java.io.Serializable;

/**
 * 适用于结果是一条表记录
 * Created by wujingpan on 2015/3/6.
 */
@SuppressWarnings("rawtypes")
public class ResultBean<T> extends Result implements Serializable{

	private static final long serialVersionUID = 867933019328199779L;

    protected ResultBean(ResultStatus status, String message) {
		super(status, message);
	}
    public static <T> ResultBean<T> build() {
        return new ResultBean<T>(ResultStatus.SUCCESS, null);
    }
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    /**
     * 成功
     */
    public void success(T value) {
        this.withSuccess();
        this.value = value;
    }
}
