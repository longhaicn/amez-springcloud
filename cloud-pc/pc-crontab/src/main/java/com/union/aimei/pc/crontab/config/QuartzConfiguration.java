package com.union.aimei.pc.crontab.config;

import lombok.extern.apachecommons.CommonsLog;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author GaoWei
 * @time 2018/6/12 15:07
 * @description quartz定时任务配置
 */
@Configuration
@EnableScheduling
@CommonsLog
public class QuartzConfiguration {

    @Resource
    private DataSource dataSource;

    /**
     * 继承org.springframework.scheduling.crontab.SpringBeanJobFactory
     * 实现任务实例化
     */
    public static class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware{

        private transient AutowireCapableBeanFactory beanFactory;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
             beanFactory=applicationContext.getAutowireCapableBeanFactory();
        }

        /**
         * 将job实例交给spring ioc容器管理
         * @param bundle
         * @return
         * @throws Exception
         */
        @Override
        protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception{
            final Object job=super.createJobInstance(bundle);
            beanFactory.autowireBean(job);
            return job;
        }
    }

    /**
     * 配置任务工程实例
     * @param applicationContext spring上下文
     * @return
     */
    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext){
        /**
         * 采用自定义任务工厂 整合spring实例来完成构建任务
         * see {@link AutowiringSpringBeanJobFactory}
         */
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    /**
     * 配置任务调度器
     * 使用项目数据源作为quartz数据源
     * @param jobFactory 自定义配置任务工厂
     * @return
     * @throws Exception
     */
    @Bean(destroyMethod = "destroy",autowire = Autowire.NO)
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory)
    {
        SchedulerFactoryBean schedulerFactoryBean=null;
        try{
            schedulerFactoryBean = new SchedulerFactoryBean();
            //将spring管理job自定义工厂交由调度器维护
            schedulerFactoryBean.setJobFactory(jobFactory);
            //设置覆盖已存在的任务
            schedulerFactoryBean.setOverwriteExistingJobs(true);
            //项目启动完成后，等待2秒后开始执行调度器初始化
            schedulerFactoryBean.setStartupDelay(2);
            //设置调度器自动运行
            schedulerFactoryBean.setAutoStartup(true);
            //设置数据源，使用与项目统一数据源
            schedulerFactoryBean.setDataSource(dataSource);
            schedulerFactoryBean.setQuartzProperties(quartzProperties());
            //设置上下文spring bean name
            schedulerFactoryBean.setApplicationContextSchedulerContextKey("applicationContext");
        }catch (Exception e){
            log.error("加载 {} 配置文件失败.", e);
            throw new RuntimeException("加载配置文件失败", e);
        }
        return schedulerFactoryBean;
    }


    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }


    @Bean
    public Scheduler scheduler(SchedulerFactoryBean schedulerFactoryBean) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduler.start();
        return scheduler;
    }
}
