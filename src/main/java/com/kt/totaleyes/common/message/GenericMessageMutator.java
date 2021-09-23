package com.kt.totaleyes.common.message;

public interface GenericMessageMutator {
	boolean isCustomMessage();

    Object getData();

    String getMessage();

    String getReturnCode();

    void transformMessage(LocaleAwareMessageService service);
}
