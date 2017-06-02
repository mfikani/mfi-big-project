package mfi.old_packages.toBeReviewedPkg.bigm.mfi.examples.quartz_jobs;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * note : 
 * Jar needed : (quartz-2.1.7.jar, slf4j-api-1.6.1.jar) 
 * with slf4j it will return error * 
 * 
 * @author mfi
 *
 *Quartz Job Example
 */
public class TriggerMFI implements Job{

	private int period = 5;
	
	@Override
	public void execute(JobExecutionContext arg0)throws JobExecutionException{
		try
		{
			System.out.println("TriggerMFI started at : "+ new Date());
			System.out.println("MFI : job is executing every "+period+" seconds...");
			System.out.println("TriggerMFI ends at : "+ new Date());
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		try
		{
			new TriggerMFI().start();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void start(){
		try{
			// define the job and tie it to our TriggerMFI class
			JobDetail jobDetail = JobBuilder.newJob(TriggerMFI.class).withIdentity("job1", "group1").build();
			
			// Trigger the job to run now, and then repeat every 40 seconds
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(period).repeatForever()).build();
			
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
