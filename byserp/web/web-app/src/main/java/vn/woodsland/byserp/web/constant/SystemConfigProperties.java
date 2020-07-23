package vn.woodsland.byserp.web.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "system")
@Data
public class SystemConfigProperties {

	private String domainServer;

	private Security security = new Security();

	@Data
	public static class Security {

		private Oauth2 oauth2 = new Oauth2();

		@Data
		public static class Oauth2 {

			private String clientId;
			private String clientSecret;
			private String authServer;

		}

	}

}
