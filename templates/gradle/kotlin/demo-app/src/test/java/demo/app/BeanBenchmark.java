package test.java.xyz.srclab.common.bean;

import org.apache.commons.beanutils.BeanUtils;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import xyz.srclab.common.bean.Beans;
import xyz.srclab.common.test.TestLogger;

import java.util.concurrent.TimeUnit;

/**
 * @author sunqian
 */
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 3, time = 10)
@Measurement(iterations = 3, time = 10)
@Threads(4)
@Fork(1)
@State(value = Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class BeanBenchmark {

    private static final TestLogger logger = TestLogger.DEFAULT;

    private PerformanceBean initBean;

    @Setup
    public void init() {
        initBean = new PerformanceBean();
        initBean.setS1("s1");
        initBean.setS2("s2");
        initBean.setS3("s3");
        initBean.setS4("s4");
        initBean.setS5("s5");
        initBean.setS6("s6");
        initBean.setS7("s7");
        initBean.setS8("s8");
        initBean.setI1(1);
        initBean.setI2(2);
        initBean.setI3(3);
        initBean.setI4(4);
        initBean.setI5(5);
        initBean.setI6(6);
        initBean.setI7(7);
        initBean.setI8(8);
    }

    @Benchmark
    public void testBeans() {
        Beans.copyProperties(initBean, new PerformanceBean());
    }

    @Benchmark
    public void testBeanUtils() throws Exception {
        BeanUtils.copyProperties(new PerformanceBean(), initBean);
    }

    /*
     * Benchmark                           Mode  Cnt     Score     Error   Units
     * BeanPerformanceTest.testBeanUtils  thrpt    3   360.217 ±  53.893  ops/ms
     * BeanPerformanceTest.testBeans      thrpt    3  6751.077 ± 157.653  ops/ms
     */
    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder().include(BeanBenchmark.class.getSimpleName()).build();
        new Runner(options).run();
    }
}
