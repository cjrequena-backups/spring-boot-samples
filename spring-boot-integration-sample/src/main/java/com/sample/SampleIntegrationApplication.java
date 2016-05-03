package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"META-INF/spring/integration/ftp/FtpInboundChannelAdapterSample-context.xml",
				 "META-INF/spring/integration/ftp/FtpOutboundChannelAdapterSample-context.xml",
				 "META-INF/spring/integration/ftp/FtpOutboundGatewaySample-context.xml"})
public class SampleIntegrationApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleIntegrationApplication.class, args);
	}
}
