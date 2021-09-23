package com.kt.totaleyes.message;

public interface GenericMessage {
	 /**
     * 정상
     */
    String OK = "OK";

    /**
     * 실패
     */
    String NG = "NG";

    void setOK();

    void setNG();

    void setReturn(String code);

    void setReturn(ReturnCode code);

    void enableCustomMessage();

    void setMessage(String message);

    void setData(Object data);

    void setReturnCode(String returnCode);
}
