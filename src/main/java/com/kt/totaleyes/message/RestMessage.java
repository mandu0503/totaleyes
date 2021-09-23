package com.kt.totaleyes.message;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class RestMessage implements GenericMessage, GenericMessageMutator, Serializable{

	private static final long serialVersionUID = 8032084069841382875L;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String returnCode = "";

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String message = "";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data = null;

    @JsonIgnore
    private boolean customMessage = false;

    @Override
    public void setOK() {
        this.setReturnCode(OK);
        this.setMessage(OK);
    }

    @Override
    public void setNG() {
        this.setReturnCode(NG);
        this.setMessage(NG);
    }

    @Override
    public void enableCustomMessage() {
        customMessage = true;
    }

    @Override
    public void transformMessage(LocaleAwareMessageService service) {
        if(this.message != null && !this.message.equals("")) {
            this.message = service.getMessage(this.message);
        }
    }

    @Override
    public String getReturnCode() {
        return returnCode;
    }

    @Override
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean isCustomMessage() {
        return customMessage;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("RestMessage{")
                .append("returnCode='").append(returnCode).append('\'')
                .append(", message='").append(message).append('\'');

        if(data!=null) buffer.append(", data=").append(data.toString());

        buffer.append(", customMessage=").append(customMessage)
                .append('}');

        return buffer.toString();
    }

    @Override
    public void setReturn(String code) {
        // TODO Auto-generated method stub
        if ( code != null ) {
            this.setReturnCode(code);
            this.setMessage(code);
        }
    }

    @Override
    public void setReturn(ReturnCode code) {
        this.setReturn(code.getCode());
    }

}
