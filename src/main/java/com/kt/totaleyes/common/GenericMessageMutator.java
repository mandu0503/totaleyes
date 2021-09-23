package com.kt.totaleyes.common;

public interface GenericMessageMutator {
	boolean isCustomMessage();

    Object getData();

    String getMessage();

    String getReturnCode();

    void transformMessage(LocaleAwareMessageService service);
}
