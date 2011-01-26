package client;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class BookStoreJmsProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Message in = exchange.getIn();
        //in.setHeader("org.apache.cxf.request.method", "POST");
        in.setHeader(Exchange.HTTP_METHOD, "GET");
        in.setHeader(Exchange.HTTP_PATH, "/123");
        System.out.println(exchange);
    }

}
