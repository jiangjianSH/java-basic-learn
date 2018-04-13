package com.jiangjian.study.java.advanced.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class CalculatorBundleActivator implements BundleActivator{


    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Starting calculator service...");
        bundleContext.registerService(CalculatorService.class.getName(), new CalculatorServiceImpl(), null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Stopping calculator service...");
    }
}
