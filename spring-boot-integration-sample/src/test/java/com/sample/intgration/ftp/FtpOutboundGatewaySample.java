package com.sample.intgration.ftp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.SampleIntegrationApplication;
import com.sample.ToFtpFlowGateway;

import lombok.extern.slf4j.Slf4j;

/**
 * Demonstrates use of the outbound gateway to use ls, get and rm.
 *
 * The previous Test {@link FtpOutboundChannelAdapterSample} was uploading 2 test
 * files:
 *
 * <ul>
 *     <li>a.txt</li>
 *     <li>b.txt</li>
 * </ul>
 *
 * This test will now retrieves those 2 files and removes them. Instead of just
 * polling the file, the files are instead retrieved and deleted using explicit
 * FTP commands (LS and RM)
 *
 *
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { SampleIntegrationApplication.class })
public class FtpOutboundGatewaySample {

	@Autowired
	ToFtpFlowGateway toFtpFlow;
	
	@Test
	public void testLsGetRm() throws Exception {
		
		
		// execute the flow (ls, get, rm, aggregate results)
		List<Boolean> rmResults = toFtpFlow.lsGetAndRmFiles("/ftp");

		//Check everything went as expected, and clean up
		assertEquals("Was expecting the collection 'rmResults' to contain 2 elements.", 2, rmResults.size());

		for (Boolean result : rmResults) {
			assertTrue(result);
		}


	}

}