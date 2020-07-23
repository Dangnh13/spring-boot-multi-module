package vn.woodsland.byserp.framework.exception.web.core.webclient;

import vn.woodsland.byserp.framework.exception.web.core.AbstractExceptionHandlerFactory;
import vn.woodsland.byserp.framework.exception.web.core.IAjaxRequestTypeHandler;
import vn.woodsland.byserp.framework.exception.web.core.ISubmitRequestTypeHandler;

public class WebClientFactory extends AbstractExceptionHandlerFactory {

	@Override
	public IAjaxRequestTypeHandler ajaxRequestTypeHandler() {
		return new Ajax();
	}

	@Override
	public ISubmitRequestTypeHandler submitRequestTypeHandler() {
		return new Submit();
	}
}
