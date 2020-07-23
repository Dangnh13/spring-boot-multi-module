package vn.woodsland.byserp.business.service;

import vn.woodsland.byserp.dto.base.rst.Empty;
import vn.woodsland.byserp.dto.inventory.dxo.MailDxo;
import vn.woodsland.byserp.framework.business.service.IBaseService;

/**
 * Mail's service
 *
 * @author Ominext's memner
 */
public interface IMailService extends IBaseService {

	/**
	 * Send mail
	 *
	 * @param mail data
	 * @return Empty data
	 */
	Empty sendEmail(MailDxo mail);

//	List<Demo> full();
}
