package vn.woodsland.byserp.business.service.impl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import vn.woodsland.byserp.business.service.IMailService;
import vn.woodsland.byserp.dto.inventory.dxo.MailDxo;
import vn.woodsland.byserp.dto.base.rst.Empty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.nio.charset.StandardCharsets;

/**
 * Mail's service implementation
 *
 * @author Ominext's memner
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MailServiceImpl implements IMailService {

	// =========================================================================
	//                                                                Constant
	//                                                                ==========

	// =========================================================================
	//                                                                DI
	//                                                                ==========

	private  JavaMailSender sender;

	private final Configuration freemarkerConfig;

	// =========================================================================
	//                                                                Property
	//                                                                ==========

	// =========================================================================
	//                                                                Public method
	//                                                                ==========

	/**
	 * Send mail
	 *
	 * @param mail data
	 * @return Empty data
	 */
	public Empty sendEmail(MailDxo mail) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			// Be careful about this line. adding UTF-8 to mime message helper important for character encoding
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
			Template template = freemarkerConfig.getTemplate(mail.getId(), StandardCharsets.UTF_8.name());
			String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, mail.getModel());
			helper.setTo(mail.getTo());
			helper.setText(text, true);
			helper.setSubject(mail.getSubject());
		};
		try {
			sender.send(messagePreparator);
		} catch (MailException e) {
			throw new MailSendException(e.getMessage());
		}
		return Empty.getDefaultInstance();
	}

//	@Override
//	public List<Demo> full() {
//		return null;
//	}


// =========================================================================
//                                                                Private method
//                                                                ==========


// =========================================================================
//                                                                Inner class
//                                                                ==========
}
