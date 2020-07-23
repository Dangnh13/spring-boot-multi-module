package vn.woodsland.byserp.framework.exception.web.core;

public abstract class AbstractExceptionHandlerFactory {
	public abstract IAjaxRequestTypeHandler ajaxRequestTypeHandler();

	public abstract ISubmitRequestTypeHandler submitRequestTypeHandler();
}
