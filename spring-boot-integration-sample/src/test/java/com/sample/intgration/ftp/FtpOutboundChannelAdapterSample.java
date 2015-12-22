package com.sample.intgration.ftp;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.integration.SampleIntegrationApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { SampleIntegrationApplication.class })
public class FtpOutboundChannelAdapterSample {

	@Autowired
	MessageChannel ftpChannelOutbound;

	private final File baseFolder = new File("target" + File.separator + "output");

	@Test
	public void test() throws Exception {

		baseFolder.mkdirs();

		final File fileToSendA = new File(baseFolder, "a.txt");
		final File fileToSendB = new File(baseFolder, "b.txt");
		
		if (!fileToSendA.exists())
			fileToSendA.createNewFile();
		if (!fileToSendB.exists())
			fileToSendB.createNewFile();

		assertTrue(fileToSendA.exists());
		assertTrue(fileToSendB.exists());

		final Message<File> messageA = MessageBuilder.withPayload(fileToSendA).build();
		final Message<File> messageB = MessageBuilder.withPayload(fileToSendB).build();

		ftpChannelOutbound.send(messageA);
		ftpChannelOutbound.send(messageB);

		Thread.sleep(2000);

	}

}
