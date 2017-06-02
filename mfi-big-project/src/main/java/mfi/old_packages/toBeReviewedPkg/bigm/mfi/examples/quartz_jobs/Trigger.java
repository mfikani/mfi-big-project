package mfi.old_packages.toBeReviewedPkg.bigm.mfi.examples.quartz_jobs;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

//pin code: 493001

public class Trigger implements Job {

//    protected static Logger logger = Logger.getLogger(Trigger.class);
	
	// Example patterns:
    // * "0 0 * * * *" = the top of every hour of every day.
    // * "*/10 * * * * *" = every ten seconds.
    // * "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
    // * "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
    // * "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
    // * "0 0 0 25 12 ?" = every Christmas Day at midnight
    // 0 0 0 * * * = midnight every day
    final String SCHEDULETIMER = "0/10 * * * * ?";

    public static void main(String[] args) throws SchedulerException {
	try {
	    new Trigger().start();
	} catch (Exception e) {
//	    logger.warn(e.getMessage() + " " + Utility.getCurrentMethodName());
	}
    }

    private void start() {
	try {

	    JobDetail jobDetail = JobBuilder.newJob(Trigger.class).withIdentity("digitalSign").build();

	    org.quartz.Trigger trigger = TriggerBuilder.newTrigger().withIdentity("digitalSign").withSchedule(CronScheduleBuilder.cronSchedule(SCHEDULETIMER)).build();

	    Scheduler scheduler = new StdSchedulerFactory().getScheduler();
	    scheduler.start();
	    scheduler.scheduleJob(jobDetail, trigger);
	} catch (Exception e) {
//	    logger.warn(e.getMessage() + " " + Utility.getCurrentMethodName());
	}
    }

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
//	logger.info("trigger started at: " + new Date());
	try {
//	    AppContext.getInstance().getBean(OperationsService.class).scanInFolder();
		System.out.println("---: executing in :" + new Date());
	} catch (Exception e) {
//	    logger.warn(e.getMessage() + " " + Utility.getCurrentMethodName());
	}
//	logger.info("trigger ends at: " + new Date());

    }

}
