package vn.woodsland.byserp.framework.exception.web.core.unknown;

import vn.woodsland.byserp.framework.exception.web.core.AbstractExceptionHandlerFactory;
import vn.woodsland.byserp.framework.exception.web.core.IAjaxRequestTypeHandler;
import vn.woodsland.byserp.framework.exception.web.core.ISubmitRequestTypeHandler;

public class UnknownWebClientFactory extends AbstractExceptionHandlerFactory {

	@Override
	public IAjaxRequestTypeHandler ajaxRequestTypeHandler() {
		return new Ajax();
	}

	@Override
	public ISubmitRequestTypeHandler submitRequestTypeHandler() {
		return new Submit();
	}
}
