package server;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

/**
 * Currently the CXF JAX-RS code determines the base path of a JAX-RS endpoint by simply
 * looking at the defined address property. As the adress is "camel:// ..." when using camel
 * this does not work. So we cut off the base path from the URL before sending to CXF
 */
public class StripPrefixProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		String path = in.getHeader(Exchange.HTTP_PATH, String.class);
		String base = in.getHeader(Exchange.HTTP_BASE_URI, String.class);
		if (base == null) {
			base = exchange.getFromEndpoint().getEndpointUri();
        }
		String relPath = path.substring(base.length());
		in.setHeader(Exchange.HTTP_PATH, relPath);
	}

}
