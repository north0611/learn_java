package log_20200107;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * -Dlog4j.configuration=file:.\\conf\\log4j.properties
 *
 */
public class Logdu {
	public final static Logger LOG = LoggerFactory.getLogger(Logdu.class);
	
	public static void main(String[] args) {
		LOG.info("info");
	}

}
