package com.sample.intgration.ftp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.SampleIntegrationApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { SampleIntegrationApplication.class })
public class FtpInboundChannelAdapterSample {

	@Autowired
	PollableChannel ftpChannelInbound;

	@Test
	public void runDemo() throws Exception {
		
		try {
			final File folder = new File("target/input");
			if (folder.exists()){
				deleteFolderContents(folder);	
			}
		} catch (Exception e) {
		}

		Message<?> message1 = ftpChannelInbound.receive(2000);
		Message<?> message2 = ftpChannelInbound.receive(2000);
		Message<?> message3 = ftpChannelInbound.receive(1000);

		log.info(String.format("Received first file message: %s.", message1));
		log.info(String.format("Received second file message: %s.", message2));
		log.info(String.format("Received nothing else: %s.", message3));

		assertNotNull(message1);
		assertNotNull(message2);
		assertNull("Was NOT expecting a third message.", message3);
	}

	public static boolean deleteFolderContents(File folder) {
		log.debug("Deleting content of: " + folder.getAbsolutePath());
		File[] files = folder.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				if (!file.delete()) {
					return false;
				}
			}
		}
		return true;
	}

}
