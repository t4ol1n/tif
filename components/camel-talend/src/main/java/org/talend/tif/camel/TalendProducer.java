/**
 * Copyright (C) 2010 Talend Inc. - www.talend.com
 */

package org.talend.tif.camel;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;
import org.apache.camel.util.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Talend producer.
 */
public class TalendProducer extends DefaultProducer {
    private static final transient Log LOG = LogFactory.getLog(TalendProducer.class);
    private static final String[] EMPTY_STRING_ARRAY = {};
    
    public TalendProducer(TalendEndpoint endpoint) {
        super(endpoint);
    }

    public void process(Exchange exchange) throws Exception {
        Object jobInstance = ((TalendEndpoint)getEndpoint()).getJobInstance();
        Method jobMethod = ((TalendEndpoint)getEndpoint()).getJobMethod();
        String context = ((TalendEndpoint)getEndpoint()).getContext();

        List<String> args = new ArrayList<String>();
        if (context != null) {
            args.add("--context=" + context);
        }
        LOG.debug("Invoking Talend job '" + jobInstance.getClass().getCanonicalName() 
            + ".runJob(String[] args)' with args: " + args.toString());
        ObjectHelper.invokeMethod(jobMethod, jobInstance, new Object[]{args.toArray(EMPTY_STRING_ARRAY)});
        // TODO [hz]: should we use the return value to throw an exception?
    }
}
